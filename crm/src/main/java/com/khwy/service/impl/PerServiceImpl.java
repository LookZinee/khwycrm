package com.khwy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khwy.mapper.PerMapper;
import com.khwy.pojo.Per;
import com.khwy.service.PerServcie;
@Service
public class PerServiceImpl implements PerServcie{
	Logger logger = LoggerFactory.getLogger(PerServiceImpl.class);
	@Autowired
	private PerMapper perMapper;
	@Override
	public List<Per> list() {
		return perMapper.list();
	}
	public PerMapper getPerMapper() {
		return perMapper;
	}
	public void setPerMapper(PerMapper perMapper) {
		this.perMapper = perMapper;
	}

}
