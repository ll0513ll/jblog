package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserVo userVo) {
		System.out.println(userVo.toString());
		sqlSession.insert("user.insert", userVo);

	}
	
	public UserVo serch(Map map) {
		
		System.out.println(map.get("id"));
		System.out.println(map.get("password"));
		UserVo userVo = sqlSession.selectOne("user.serch", map);
		return userVo;
		
	}
	
	public String serchId(String id) {
		
		System.out.println("다오 serchId");
		return sqlSession.selectOne("user.serchId",id);
	}

}
