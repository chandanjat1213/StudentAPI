package com.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	
	@Autowired
	public RestTemplate template;
	
	@GetMapping("/show")
	public List<Student> show()
	{
		//RestTemplate template = new RestTemplate() ;
		return template.getForObject("http://student-service/student", List.class);
	}
	
	@GetMapping("/show/{id}")
	public Student showById(@PathVariable("id") int id)
	{
		//RestTemplate template = new RestTemplate() ;
		return template.getForObject("http://student-service/student/"+id+"", Student.class);
	}
	
	@PostMapping("/show")
	public Student addStudent(@RequestBody Student s)
	{
		//estTemplate template = new RestTemplate() ;
		return template.postForObject("http://student-service/student", s, Student.class);
	}
	
	@DeleteMapping("/show/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		//RestTemplate template = new RestTemplate() ;
	    template.delete("http://student-service/student/"+id+"");
		return "deleted";
	}
	
	@PutMapping("/show/{id}")
	public String updateStudent(@RequestBody Student s,@PathVariable("id") int id)
	{
		//RestTemplate template = new RestTemplate() ;
		template.put("http://student-service/student/"+id, s);
		return "updated";
	}
	
	
}
