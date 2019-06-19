package com.ha.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ha.jpa.entity.Academy;
import com.ha.jpa.repository.AcademyRepository;
import com.ha.jpa.repository.AcademyRepositorySupport;
import com.ha.jpa.vo.UserVO;

@RestController
@RequestMapping("/")
public class TestController {
//	@Autowired
//	EntityManager manager;
	
	@Autowired
	AcademyRepository repository;
	
	@Autowired
	AcademyRepositorySupport support;
	
	@GetMapping("test")
	public String getString() {
//		JPAQuery query = new JPAQuery(manager);
		UserVO user = new UserVO();
		
		
//		query.from
		return "Hello world";
	}
	
	@PostMapping("academy")
	public List<Academy> postAcademy(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "addr") String addr) {
		Academy a = new Academy(name, addr);
		repository.save(a);
		return support.findByName(name);
	}
	
	@GetMapping("academy")
	public Academy getAcademy(
			@RequestParam(name = "name", required = true) String name) {
		return support.findByName(name).get(0);
	}
}
