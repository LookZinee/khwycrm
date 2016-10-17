package com.khwy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khwy.mapper.OrgMapper;
import com.khwy.mapper.UserMapper;
import com.khwy.pojo.Org;
import com.khwy.service.OrgServcie;
@Service("orgServcie")
public class OrgServcieImpl implements OrgServcie{ 
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private UserMapper userMapper;

	public OrgMapper getOrgMapper() {
		return orgMapper;
	}

	public void setOrgMapper(OrgMapper orgMapper) {
		this.orgMapper = orgMapper;
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public List<Org> list() {
		List<Org> list = orgMapper.list();
		System.out.println("OrgServcieImpl.list()");
		System.out.println("org的list的长度是："+list.size());
		System.out.println(userMapper);
		if(list != null){
			for (Org org : list) {
				org.setUser(userMapper.findByUserId(org.getOperUserId()));
			}
		}
		return list;
	}

	@Override
	public boolean add(Org org) {
		return orgMapper.add(org);
	}

	@Override
	public boolean del(Integer orgId) {
		return orgMapper.del(orgId);
	}

	@Override
	public Org findById(Integer orgId) {
		return orgMapper.findById(orgId);
	}

	@Override
	public boolean edit(Org org) {
		return orgMapper.edit(org);
	}


	
}
