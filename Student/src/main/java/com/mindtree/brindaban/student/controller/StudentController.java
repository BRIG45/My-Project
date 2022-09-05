package com.mindtree.brindaban.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.brindaban.student.entity.Student;
import com.mindtree.brindaban.student.service.StudentService;
import com.mindtree.brindaban.student.valueandobject.ResponseTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping
	public Student add(@RequestBody Student std) {
		return studentService.add(std);
	}

	@GetMapping
	public List<Student> liststudent() {
		return studentService.list();
	}

	@GetMapping("/{stdId}")
	public ResponseTemplate stdWithcoll(@PathVariable long stdId) {
		return studentService.stdWithColl(stdId);
	}

	@PutMapping("/{stdId}/{col_Id}")
	public String updateCollege(@PathVariable long stdId, @PathVariable long col_Id) {
		Student stud = studentService.assignCollege(stdId, col_Id);
		if (stud != null) {
			return stud.toString();
		}
		return "Sorry.College or student not found";
	}

	@GetMapping("/student-with-ascname/{col_id}")
	public List<Student> nameByAscending(@PathVariable long col_id) {
		return studentService.getAscendingNameById(col_id);
	}

	@GetMapping("/student-with-desc-age/{stream}")
	public List<Student> getStudentByStreamWithDescAge(@PathVariable String stream) {
		return studentService.getStudentByStreamWithDescAge(stream);
	}
}