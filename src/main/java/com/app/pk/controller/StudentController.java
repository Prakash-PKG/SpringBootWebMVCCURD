package com.app.pk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pk.model.Student;
import com.app.pk.service.IStudentService;

@Controller
public class StudentController {

	
	@Autowired
	private IStudentService service;
	
	//1. show reg page
	@GetMapping("/register")
	public String showReg(Model model) {
		int a=20;
		int p=100;
		int l=1000000;
		//Form Backing Object
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}
	
	//2. save student
	@PostMapping("/save")
	public String save(@ModelAttribute Student student,Model model) 
	{
		Integer id=service.saveStudent(student);
		model.addAttribute("message", "Student '"+id+"' saved!");
		//Form Backing Object
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}
	
	//3. Fetch Data to UI
	@GetMapping("/all")
	public String fetchAll(
			@PageableDefault(page = 0,size = 3)Pageable p,
			Model model)
	{
		Page<Student> page=service.getStudentsPage(p);
		model.addAttribute("page", page);
		return "StudentData";
	}
	
	//4. delete row based on Id
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		if(service.isStudentExist(id)) {
			service.deleteStudent(id);
		}
		//response.sendRedirect
		return "redirect:all";
	}
	//5. show Edit Page with data
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id,Model model) {
		model.addAttribute("student", service.getOneStudent(id));
		return "StudentEdit";
	}
	
	//6. On click update button
	@PostMapping("/update")
	public String update(@ModelAttribute Student student,Model model) {
		service.updateStudent(student);
		return "redirect:all";
	}
	
}
