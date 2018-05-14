package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserVo userVo) {
		
		sqlSession.insert("blog.insert",userVo);
	}
	
	public List<PostVo> getPostList(int cateNo){
		return sqlSession.selectList("blog.getList",cateNo);
	}
	
	public String serchId(String id) {
		
		return sqlSession.selectOne("blog.serchId",id);
	}
	
	public BlogVo getblog(String id) {
		
		return sqlSession.selectOne("blog.getblog",id);
	}
	
	public void blogUpdate(Map map) {
		
		System.out.println("사진수정 다오");
		sqlSession.update("blog.blogUpdate",map);
	}
	
	public CateVo cateInsert(CateVo cateVo) {
		System.out.println(cateVo.toString());
		sqlSession.insert("blog.cateInsert",cateVo);
		System.out.println(cateVo.toString());
		return cateVo;
	}
	
	public List<CateVo> catelist(String id){
		
		return sqlSession.selectList("blog.catelist",id);
		
	}
	
	public int catedelete(int cateNo) {
		
		return sqlSession.delete("blog.catedelete",cateNo);
		
	}
	
	public List<CateVo> getCateList(String id){
		
		return sqlSession.selectList("blog.getCateList",id);
	}
	
	public void postUpload(PostVo postVo) {
		
		sqlSession.insert("blog.insertPost",postVo);
	}

	public int getPostTime(int cateNo) {
		
		return sqlSession.selectOne("blog.getPostTime",cateNo);
		
	}
	
	public void insertCate(UserVo userVo) {
		
		sqlSession.selectOne("blog.insertCate",userVo);
		
	}
	
}
