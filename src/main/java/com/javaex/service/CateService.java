package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CateDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CateVo;

@Service
public class CateService {
	
	@Autowired
	private CateDao cateDao;
	@Autowired
	private PostDao postDao;

	
	public CateVo cateUpload(CateVo cateVo) {

		return cateDao.cateInsert(cateVo);

	}

	public List<CateVo> catelist(String id) {

		return cateDao.catelist(id);
	}

	public int catedelete(int cateNo) {

		int result = 0;

		int postTime = postDao.getPostTime(cateNo);
		if (postTime == 0) {
			result = cateDao.catedelete(cateNo);
		}

		return result;

	}

	public List<CateVo> getCateList(String id) {

		return cateDao.getCateList(id);
	}

}
