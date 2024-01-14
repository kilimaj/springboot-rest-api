package dev.kilima.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
/*
 * @Controller converts the class to a springboot controller 
 * And @ResponseBody converts response from java objects to JSON
 * @RestController - combines both properties of @Controller and @ResponseBody
 */

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

	// HTTP GET REQUEST
	// http://localhost:8080/hello-world
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
}
