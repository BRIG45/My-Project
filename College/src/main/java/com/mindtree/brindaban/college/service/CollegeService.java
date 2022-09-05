package com.mindtree.brindaban.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.brindaban.college.entity.College;
import com.mindtree.brindaban.college.valueandobject.RequestTemplate;

@Service
public interface CollegeService {
	College add(College college);

	List<College> list();

	College update(long col_id, String col_name);

	College searchById(long col_id);

	List<RequestTemplate> listWithStud();

	RequestTemplate specificCollStud(long col_id);
}