package com.khwy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khwy.mapper.PerMapper;
import com.khwy.pojo.Per;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-mvc.xml",
		"classpath:spring/applicationContext-shiro.xml","classpath:spring/applicationContext.xml"})
public class PerMapperTest {
	Logger logger = LoggerFactory.getLogger(PerMapperTest.class);
	@Autowired
	private PerMapper perMapper;

	public PerMapper getPerMapper() {
		return perMapper;
	}

	public void setPerMapper(PerMapper perMapper) {
		this.perMapper = perMapper;
	}
	@Test
	public void listTest(){
		List<Per> perList = perMapper.list();
		for (Per per : perList) {
			System.out.println(per);
		}
	}
	
	
}
