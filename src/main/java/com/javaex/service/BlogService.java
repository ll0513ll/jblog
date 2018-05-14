package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	
	public BlogVo getblog(String id) {

		return blogDao.getblog(id);
	}
	
	public String serchId(String id) {
		
		return blogDao.serchId(id);
	}
	
	public void modify(String id,MultipartFile file,String blogTitle) {
		
		System.out.println("사진수정 서비스");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("blogTitle", blogTitle);
		
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName: "+exName);
		
		//저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName: "+saveName);
		
		map.put("logoFile", saveName);
		//다오 연결 DB저장
		
		blogDao.blogUpdate(map);
		
		//파일 서버 복사
		try {
			if(file.isEmpty()) {
				saveName = "spring-logo.jpg";
			}
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream("D:\\javaStudy\\upload\\" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			
			if(bout!=null) {
				bout.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
