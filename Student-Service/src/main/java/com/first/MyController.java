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

@RestController
public class MyController {

	@Autowired
	public MyRepo repo;
	
	@GetMapping("/student")
	public List<Student> getStudent()
	{
		return this.repo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student searchStudent(@PathVariable("id") int id)
	{
		return this.repo.findById(id).orElse(new Student());
	}
	
	
	@PostMapping("/student")
	public Student postStudent(@RequestBody Student s)
	{
		return this.repo.save(s);
	}
	
	@DeleteMapping("/student/{id}")
	public String delete(@PathVariable("id") int id)
	{
	   Student s = this.repo.findById(id).orElse(new Student());
	   if(s==null)
	   {
		   return "Not Valid Id";
	   }
	   else
	   {	   
	   this.repo.deleteById(id);
	   return "deleted";
	   }
	}
	
	@PutMapping("/student/{id}")
	public Student update(@RequestBody Student s,@PathVariable("id") int id)
	{
		Student s1 = repo.findById(id).orElse(new Student());
		if(s1==null)
		{
			return s1;
		}
		else
		{
		 return this.repo.save(s1);
		}
	}
	
}
