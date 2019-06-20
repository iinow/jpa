package com.ha.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ha.jpa.entity.Academy;
import com.ha.jpa.repository.AcademyRepository;
import com.ha.jpa.repository.AcademyRepositorySupport;

@RestController
@RequestMapping("/")
public class TestController {
//	@Autowired
//	EntityManager manager;
	
	@Autowired
	AcademyRepository repository;
	
	@Autowired
	AcademyRepository jpaRepository;
	
	@Autowired
	AcademyRepositorySupport support;
	
	@Autowired
	EntityManager manager;
	
	@GetMapping("test")
	public String getString() {
//		JPAQuery query = new JPAQuery(manager);
		
		
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
			@RequestParam(name = "i", required = true) Long i) {
		return jpaRepository.findById(i).get();
	}
	
	@PutMapping("academy")
	public void putAcademy(
			@RequestParam(name = "i") Long i,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "addr") String addr) {
//		EntityTransaction transaction = manager.getTransaction();
//		transaction.begin();
//		manager.persist(a);
//		Academy b = manager.find(Academy.class, i);
		Academy b = jpaRepository.findById(i).get();
		b.setAddress(addr);
		b.setName(name);
		jpaRepository.save(b);
	}
	
}
