package com.mindtree.brindaban.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.brindaban.college.entity.College;
import com.mindtree.brindaban.college.service.CollegeService;
import com.mindtree.brindaban.college.valueandobject.RequestTemplate;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeService collService;

	@PostMapping
	public College add(@RequestBody College coll) {
		return collService.add(coll);
	}

	@GetMapping
	public List<College> list() {
		return collService.list();
	}

	@GetMapping("/{col_id}")
	public College searchById(@PathVariable long col_id) {
		return collService.searchById(col_id);
	}

	@GetMapping("/all-college-student")
	public List<RequestTemplate> listWithStud() {
		return collService.listWithStud();
	}
//
//	@GetMapping("/college-with-student/{col_id}")
//	public RequestTemplate specificCollStud(@PathVariable long col_id) {
//		return collService.specificCollStud(col_id);
//	}
}