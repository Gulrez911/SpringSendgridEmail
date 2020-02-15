package com.gul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Student;
import com.gul.repo.StudentRepo;

@Controller
public class HomeController {

	@Autowired
	StudentRepo repo;

	@GetMapping("/")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView("index");
		List<Student> students=repo.findAll();
		mav.addObject("list",students);
		mav.addObject("student", new Student());
		return mav;
	}

	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("index");
		repo.saveAndFlush(student);
		List<Student> students=repo.findAll();
		mav.addObject("list",students);
		mav.addObject("student", new Student());
		return mav;
	}
	
	@GetMapping("delete")
	public ModelAndView delete(@RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView("index");
		repo.deleteById(id);
		List<Student> students=repo.findAll();
		mav.addObject("list",students);
		mav.addObject("student", new Student());
		return mav;
	}
	@GetMapping("edit")
	public ModelAndView edit(@RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView("index");
		Student student =repo.getOne(id);
		List<Student> students=repo.findAll();
		mav.addObject("list",students);
		mav.addObject("student", student);
		return mav;
	}
}
