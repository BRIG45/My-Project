package com.mindtree.brindaban.student;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mindtree.brindaban.student.entity.Student;
import com.mindtree.brindaban.student.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class StudentApplicationTests {

	@Autowired

	private MockMvc mockMvc;

	@Autowired

	private StudentRepository studentRepository;

	@BeforeEach

	void setup() {
		studentRepository.deleteAll();
	}

	@Test

	public void givenListOfStudents_whenGetAllStudents_thenReturnStudentsList() throws Exception {
		// given - precondition or setup
		List<Student> listOfStudents = new ArrayList<>();
		listOfStudents.add(new Student(1, "Debjit Samui", "Male", 23, 3, "Science"));
		listOfStudents.add(new Student(2, "Amit Roy", "Male", 34, 4, "Science"));
		listOfStudents.add(new Student(3, "Krishna Das", "Male", 44, 3, "Arts"));
		listOfStudents.add(new Student(4, "Gulpreet Sing Sidhu", "Female", 28, 1, "Science"));
		listOfStudents.add(new Student(5, "Rahul Patra", "Male", 25, 1, "Commerce"));
		listOfStudents.add(new Student(6, "Trisha Dutta", "Female", 32, 1, "Commerce"));
		listOfStudents.add(new Student(7, "Susmita Sen", "Female", 42, 1, "Arts"));

		studentRepository.saveAll(listOfStudents);
		// when - action or the behavior that we are going test
		ResultActions response = mockMvc.perform(get("http://localhost:9092/student"));

		// then - verify the output
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(listOfStudents.size())));
	}
}