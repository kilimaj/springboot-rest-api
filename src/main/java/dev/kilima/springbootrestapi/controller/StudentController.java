package dev.kilima.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.kilima.springbootrestapi.bean.Student;

@RestController
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "John", "Kilima");
		// return new ResponseEntity<>(student, HttpStatus.OK);
		// The above is same as below
		// return ResponseEntity.ok(student);
		// parsing a header information
		return ResponseEntity.ok().header("custom-header", "John").body(student);
	}

	// http://localhost:8080/students
	@GetMapping("students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "John", "Kilima"));
		students.add(new Student(2, "Mabula", "Kilima"));
		students.add(new Student(3, "Jean", "Bundala"));
		students.add(new Student(4, "Barnabas", "Kilima"));
		return ResponseEntity.ok(students);
	}

	/*
	 * Spring boot rest api with path variable {id} - URI template variable
	 * http://localhost:8080/students/1/John/Mabula
	 * 
	 * @PathVariable annotation used on a method argument to bind it to the value of
	 * a URI template variable.
	 */
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
		Student student = new Student(studentId, firstName, lastName);
		return ResponseEntity.ok(student);
	}

	/*
	 * Spring Boot REST API with Request Param
	 * http://localhost:8080/students/query?id=1&firstName=Mabula&lastName=Kilima
	 */
	@GetMapping("students/query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {
		Student student = new Student(id, firstName, lastName);
		return ResponseEntity.ok(student);
	}

	/*
	 * Spring boot REST API that handles HTTP POST Request
	 * 
	 * @PostMapping - annotation is used for mapping HTTP POST request onto specific
	 * handler method and @RequestBody - annotation is responsible for retrieving
	 * the HTTP request body and automatically converting it to the Java object.
	 * 
	 * @RequestBody annotation internally uses Spring provided HttpMessageConverter
	 * to convert JSON into Java object
	 */
	@PostMapping("students/create")
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	// Spring Boot REST API that handles HTTP PUT Request - updating existing
	// resource
	@PutMapping("students/{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}

	// Spring Boot REST API that handles HTTP DELETE Request - deleteing existing
	// resource
	@DeleteMapping("students/{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return ResponseEntity.ok("Student successfully deleted");
	}

}
