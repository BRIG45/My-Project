package com.mindtree.brindaban.college.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.brindaban.college.entity.College;
import com.mindtree.brindaban.college.repository.CollegeRepository;
import com.mindtree.brindaban.college.service.CollegeService;
import com.mindtree.brindaban.college.valueandobject.RequestTemplate;
import com.mindtree.brindaban.college.valueandobject.Student;

@Component

public class CollegeImple implements CollegeService {

	@Autowired

	CollegeRepository collegeRepo;

	@Autowired

	RestTemplate restTemplate;

	@Override

	public College add(College col) {
		return collegeRepo.save(col);
	}

	@Override

	public List<College> list() {
		return collegeRepo.findAll();
	}

	@Override

	public College update(long col_id, String col_name) {
		College coll = collegeRepo.findById(col_id);
		coll.setCol_name(col_name);
		return collegeRepo.save(coll);
	}

	@Override

	public College searchById(long col_id) {
		if (collegeRepo.findById(col_id) == null) {
			return null;
		}
		return collegeRepo.findById(col_id);
	}

	@Override

	public List<RequestTemplate> listWithStud() {
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<College> allColl = this.list();
		Iterator<College> ir = allColl.iterator();
		while (ir.hasNext()) {
			College coll = ir.next();
			ResponseEntity<Student[]> response = restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-ascname/" + coll.getCol_id(), Student[].class);
			Student[] students = response.getBody();
			List<Student> stdList = Arrays.asList(students);
			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(coll);
			RTm.setStudentList(stdList);
			fullList.add(RTm);
		}
		return fullList;
	}

	@Override

	public RequestTemplate specificCollStud(long col_id) {
		College college = this.searchById(col_id);
		ResponseEntity<Student[]> response = restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-desc-age/" + college.getCol_id(), Student[].class);
		Student[] students = response.getBody();
		List<Student> studList = Arrays.asList(students);
		RequestTemplate requestTemplate = new RequestTemplate();
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(studList);
		return requestTemplate;
	}
}