package com.mindtree.brindaban.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.brindaban.student.entity.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findById(long id);

	@Query

	(value = "SELECT * FROM student WHERE col_id=:col_id ORDER BY name ASC", nativeQuery = true)
	List<Student> ascendingName(@Param("col_id") long col_id);

	@Query

	(value = "SELECT * FROM student WHERE stream=:stream ORDER BY age DESC", nativeQuery = true)
	List<Student> getStudentByStreamWithDescAge(@Param("stream") String stream);
}