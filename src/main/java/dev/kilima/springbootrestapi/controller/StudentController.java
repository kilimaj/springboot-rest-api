package dev.kilima.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

	// http://localhost:8080/students
	@GetMapping("students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "John", "Kilima"));
		students.add(new Student(2, "Mabula", "Kilima"));
		students.add(new Student(3, "Jean", "Bundala"));
		students.add(new Student(4, "Barnabas", "Kilima"));
		return students;
	}

	/*
	 * Spring boot rest api with path variable {id} - URI template variable
	 * http://localhost:8080/students/1/John/Mabula
	 * 
	 * @PathVariable annotation used on a method argument to bind it to the value of
	 * a URI template variable.
	 */
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {
		return new Student(studentId, firstName, lastName);
	}

	/*
	 * Spring Boot REST API with Request Param
	 * http://localhost:8080/students/query?id=1&firstName=Mabula&lastName=Kilima
	 */
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}

}
