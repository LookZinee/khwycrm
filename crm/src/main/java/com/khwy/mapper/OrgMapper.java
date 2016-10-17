package com.khwy.mapper;

import java.util.List;

import com.khwy.pojo.Org;
import com.khwy.pojo.Role;

public interface OrgMapper {

	List<Org> list();

	boolean add(Org org);

	boolean del(Integer orgId);

	Org findById(Integer orgId);

	boolean edit(Org org);


}
