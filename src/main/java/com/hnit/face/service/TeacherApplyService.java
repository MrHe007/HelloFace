package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.TeacherApply;
import com.hnit.face.bean.TeacherApplyExample;
import com.hnit.face.bean.TeacherApplyExample.Criteria;
import com.hnit.face.bean.TeacherExample;
import com.hnit.face.dao.TeacherApplyMapper;

@Service
public class TeacherApplyService {

	@Autowired
	TeacherApplyMapper mapper;
	
	public List<TeacherApply> getApplyList() {
		
		List<TeacherApply> list = null;
		
		TeacherApplyExample ex = new TeacherApplyExample();
		Criteria c = ex.createCriteria();
		list = mapper.selectByExample(ex);
		mapper.selectByExample(ex);
		
		return list;
	}

	public boolean saveApply(TeacherApply apply) {
		int col = mapper.insert(apply);
		
		if(col>0) {
			return true;
		}else {
			return false;
		}
	}

	public TeacherApply getTEaTeacherApplyById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public boolean activeApply(TeacherApply apply,Integer state) {

		if( apply!=null) {
			try {
				apply.setState(state); 		// 更新申请信息
				mapper.updateByPrimaryKeySelective(apply); 		// 更新申请 
				return true;
			}catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
		}
		return false;
		
	}
	
}
