package com.mindtree.brindaban.student.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.brindaban.student.entity.Student;
import com.mindtree.brindaban.student.repository.StudentRepository;
import com.mindtree.brindaban.student.service.StudentService;
import com.mindtree.brindaban.student.valueandobject.College;
import com.mindtree.brindaban.student.valueandobject.ResponseTemplate;



@Component
public class StudentImple implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student add(Student std) {
		return studentRepo.save(std);
	}

	@Override
	public List<Student> list() {
		return studentRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return studentRepo.findById(id);
	}

	@Override
	public ResponseTemplate stdWithColl(long stdId) {
		ResponseTemplate RT = new ResponseTemplate();
		Student std = studentRepo.findById(stdId);

		long col_id = std.getCol_id();
		College college = restTemplate.getForObject("http://COLLEGE-SERVICE/college/" + col_id, College.class);
		RT.setCollege(college);
		RT.setStudent(std);
		return RT;
	}

	@Override
	public Student assignCollege(long studentId, long col_Id) {
		Student std = studentRepo.findById(studentId);
		College coll = restTemplate.getForObject("http://COLLEGE-SERVICE/college/" + col_Id, College.class);
		if (std == null || coll == null) {
			return null;
		}
		std.setCol_id(col_Id);
		studentRepo.save(std);
		return std;
	}
	
	@Override
	public List<Student> getAscendingNameById(long col_id) {
		return studentRepo.ascendingName(col_id);
	}

	@Override
	public List<Student> getStudentByStreamWithDescAge(String stream) {
		return studentRepo.getStudentByStreamWithDescAge(stream);
	}
}