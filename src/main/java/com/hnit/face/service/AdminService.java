package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Admin;
import com.hnit.face.bean.AdminExample;
import com.hnit.face.bean.AdminExample.Criteria;
import com.hnit.face.dao.AdminMapper;
import com.hnit.face.to.MsgTo;

@Service
public class AdminService {

	@Autowired
	AdminMapper mapper;
	
	
	public Admin login(String username,String password){
		
		AdminExample ex = new AdminExample();
		Criteria c = ex.createCriteria();
		
		c.andUsernameEqualTo(username);
		c.andPasswordEqualTo(password);
		
		List<Admin> admins = mapper.selectByExample(ex);
		
		if(admins.size()>0) { 	// 表示找到
			System.out.println("找到");
			return admins.get(0);
		}
		
		return null;
	}
	
}
