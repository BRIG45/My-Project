package com.mindtree.brindaban.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.brindaban.student.entity.Student;
import com.mindtree.brindaban.student.valueandobject.ResponseTemplate;

@Service

public interface StudentService {

	Student add(Student student);

	List<Student> list();

	Student searchById(long id);

	ResponseTemplate stdWithColl(long col_id);

	Student assignCollege(long studentId, long col_Id);

	List<Student> getAscendingNameById(long col_id);

	List<Student> getStudentByStreamWithDescAge(String stream);
}