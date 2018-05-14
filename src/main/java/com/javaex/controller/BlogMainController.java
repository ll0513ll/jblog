package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.service.CateService;
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping(value="/{id}",method=RequestMethod.GET)
public class BlogMainController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CateService cateService;
	@Autowired
	private PostService postService;
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String blogMain(@PathVariable("id") String id, Model model,
						   @RequestParam(value="cateNo",required=false,defaultValue="-1")Integer cateNo,
						   @RequestParam(value="postNo",required=false,defaultValue="-1")Integer postNo) {
		
		blogService.serchId(id);
		BlogVo blogVo = blogService.getblog(id);
		List<CateVo> cateList = cateService.catelist(id);
		
		List<PostVo> catelist=null;
		if(!cateList.isEmpty()) {
			if(cateNo==-1) {
				catelist = postService.getPostList(cateList.get(0).getCateNo());
			}else {
				catelist = postService.getPostList(cateNo);
			}
		}
		
		List<PostVo> postlist=null;
		if(!catelist.isEmpty()) {
			if(postNo==-1) {
				postlist = postService.getPostList(catelist.get(0).getCateNo());
			}else {
				postlist = postService.getPostList(postNo);
			}
		}
		
		model.addAttribute("postlist",postlist);
		model.addAttribute("serchId",id);
		model.addAttribute("blogVo",blogVo);
		model.addAttribute("cateList",cateList);
		
		return "blog/blog-main";
	}
	

}
