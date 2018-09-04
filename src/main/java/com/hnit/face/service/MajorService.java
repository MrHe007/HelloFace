package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Major;
import com.hnit.face.bean.MajorExample;
import com.hnit.face.bean.MajorExample.Criteria;
import com.hnit.face.dao.MajorMapper;

@Service
public class MajorService {
	
	@Autowired
	MajorMapper mapper;
	
	public List<Major> getMajorListByDeptId(String deptId){
		
		MajorExample ex = new MajorExample();
		Criteria c = ex.createCriteria();
		c.andAcademicIdEqualTo(Integer.parseInt(deptId));
		List<Major> list = mapper.selectByExample(ex);
		
		if( list.size()>0) {
			return list;
		}else {
			return null;
		}
		
		
	}
	

}
