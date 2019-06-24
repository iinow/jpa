package com.ha.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ha.jpa.entity.Academy;
import com.ha.jpa.entity.Board;
import com.ha.jpa.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {
	@Autowired
	EntityManagerFactory factory;
	
	@Autowired
	BoardRepository repository;

	@Test
	public void contextLoads() {
		Board board = new Board();
		repository.save(board);
	}

}
