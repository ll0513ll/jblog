package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping(value="/{id}",method=RequestMethod.GET)
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@RequestMapping(value="",method=RequestMethod.GET)
	public String blogMain(@PathVariable("id") String id, Model model,
						   @RequestParam(value="cateNo",required=false,defaultValue="-1")Integer cateNo,
						   @RequestParam(value="postNo",required=false,defaultValue="-1")Integer postNo) {
		
		blogService.serchId(id);
		BlogVo blogVo = blogService.getblog(id);
		List<CateVo> cateList = blogService.catelist(id);
		
		List<PostVo> catelist=null;
		if(!cateList.isEmpty()) {
			if(cateNo==-1) {
				catelist = blogService.getPostList(cateList.get(0).getCateNo());
			}else {
				catelist = blogService.getPostList(cateNo);
			}
		}
		
		List<PostVo> postlist=null;
		if(!catelist.isEmpty()) {
			if(postNo==-1) {
				postlist = blogService.getPostList(catelist.get(0).getCateNo());
			}else {
				postlist = blogService.getPostList(postNo);
			}
		}
		
		model.addAttribute("postlist",postlist);
		model.addAttribute("serchId",id);
		model.addAttribute("blogVo",blogVo);
		model.addAttribute("cateList",cateList);
		
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/admin/basic",method=RequestMethod.GET)
	public String basic(@PathVariable("id") String id, Model model) {
		
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		return"blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value="/admin/write",method=RequestMethod.GET)
	public String writeForm(@PathVariable("id") String id, Model model) {
		
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		
		List<CateVo> list = blogService.getCateList(id);
		System.out.println(list.toString());
		model.addAttribute("cateList",list);
		
		return "blog/admin/blog-admin-write";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(@PathVariable("id") String id,@RequestParam("file")MultipartFile file,@RequestParam("blogTitle")String blogTitle) {
		
		System.out.println("사진수정 컨트롤러");
		blogService.modify(id,file,blogTitle);
		System.out.println("수정하고 온 컨트롤러");
		return"redirect:/{id}/admin/basic";
	}
	
	@RequestMapping(value="/admin/category",method=RequestMethod.GET)
	public String category(@PathVariable("id") String id, Model model) {
		
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		
		return "blog/admin/blog-admin-cate";
	}
	
	@ResponseBody
	@RequestMapping(value="/cateUpload",method=RequestMethod.POST)
	public CateVo cateUpload(@PathVariable("id") String id, Model model,@RequestBody CateVo cateVo) {
		
		cateVo.setId(id);
		System.out.println(cateVo.toString());
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		CateVo catevo=blogService.cateUpload(cateVo);
		return catevo;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/catelist",method=RequestMethod.GET)
	public List<CateVo> catelist(@PathVariable("id") String id, Model model){
		
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		return blogService.catelist(id);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/catedelete",method=RequestMethod.GET)
	public int catedelete(@RequestParam("cateNo")int cateNo,@PathVariable("id") String id, Model model) {
		
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		int result = blogService.catedelete(cateNo);
		
		if(result!=0) {
			return cateNo;
		}else {
			
			return 0;
		}
	}
	
	@RequestMapping(value="/postUpload",method=RequestMethod.POST)
	public String postUpload(@PathVariable("id") String id, Model model,@ModelAttribute PostVo postVo) {
		
		BlogVo blogVo = blogService.getblog(id);
		model.addAttribute("blogVo",blogVo);
		
		System.out.println(postVo.toString());
		blogService.postUpload(postVo);
		
		return "redirect:/{id}/admin/write";
	}
	
}
