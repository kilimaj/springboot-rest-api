package dev.kilima.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kilima.springbootrestapi.bean.Student;

@RestController
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "John", "Kilima");
		return student;
	}

	@GetMapping("students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "John", "Kilima"));
		students.add(new Student(2, "Mabula", "Kilima"));
		students.add(new Student(3, "Jean", "Bundala"));
		students.add(new Student(4, "Barnabas", "Kilima"));
		return students;
	}
}
