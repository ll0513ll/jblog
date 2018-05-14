package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;

@Repository
public class CateDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public CateVo cateInsert(CateVo cateVo) {
		System.out.println(cateVo.toString());
		sqlSession.insert("cate.cateInsert",cateVo);
		System.out.println(cateVo.toString());
		return cateVo;
	}
	
	public List<CateVo> catelist(String id){
		
		return sqlSession.selectList("cate.catelist",id);
		
	}
	
	public int catedelete(int cateNo) {
		
		return sqlSession.delete("cate.catedelete",cateNo);
		
	}
	
	public List<CateVo> getCateList(String id){
		
		return sqlSession.selectList("cate.getCateList",id);
	}
	
	public void insertCate(UserVo userVo) {

		sqlSession.selectOne("cate.insertCate", userVo);

	}

}
