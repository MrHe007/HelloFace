package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Curricula;
import com.hnit.face.bean.CurriculaExample;
import com.hnit.face.bean.CurriculaExample.Criteria;
import com.hnit.face.dao.CurriculaMapper;

@Service
public class CurriculaService {
	
	@Autowired
	CurriculaMapper mapper;

	public List<Curricula> getCurriculaList(Integer courseId) {
		
		CurriculaExample ex = new CurriculaExample();
		Criteria c = ex.createCriteria();
		List<Curricula> list = mapper.selectByExample(ex);
		
		if( list.size()>0) {
			return list;
		}else {
			return null;
		}
		
	}
	
}
