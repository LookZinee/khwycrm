package com.khwy.service;

import java.util.List;

import com.khwy.pojo.Org;

public interface OrgServcie {

	List<Org> list();

	boolean add(Org org);

	boolean del(Integer orgId);

	Org findById(Integer orgId);

	boolean edit(Org org);

}
