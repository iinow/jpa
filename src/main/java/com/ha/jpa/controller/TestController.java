package com.ha.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ha.jpa.vo.UserVO;

@RestController
@RequestMapping("/")
public class TestController {
//	@Autowired
//	EntityManager manager;
	
	@GetMapping("test")
	public String getString() {
//		JPAQuery query = new JPAQuery(manager);
		UserVO user = new UserVO();
		
		
//		query.from
		return "Hello world";
	}
}
