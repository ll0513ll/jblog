package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CateDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CateDao cateDao;
	
	public void join(UserVo userVo) {
		
		userDao.insert(userVo);
		blogDao.insert(userVo);
		cateDao.insertCate(userVo);

	}
	
	public UserVo login(String id,String password) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
				
		return userDao.serch(map);
	}
	
	public boolean serchId(String id) {
		
		System.out.println("서비스 serchId");
		String resultId = userDao.serchId(id);
		return (resultId!=null);
	}
}
