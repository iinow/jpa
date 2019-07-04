package com.ha.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ha.jpa.entity.Board;
import com.ha.jpa.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {
	@Autowired
	BoardRepository repository;
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	EntityManager entityManager;

	@Test
	public void contextLoads() {
		for(int i = 0; i < 10; i++) {
			Board board = new Board();
			board.setTemp(new Date().toString());
			repository.save(board);	
		}
		List<Board> list = repository.findAll();
		list.forEach(System.out::println);
	}
	
	@Test
	public void 네임드쿼리사용() {
//		EntityManager manager = entityManagerFactory.createEntityManager();
		List<Board> list =  entityManager.createNamedQuery("Board.findByHello", Board.class)
			.setParameter("id", (long)1)
			.getResultList();
		
		list.forEach(System.out::println);
	}
	
	@Test
	public void 네임드쿼리사용2() {
		List<Board> list = repository.findByHello(1);
		Hibernate.initialize(list);
		list.forEach(System.out::println);
	}
	
	@Test
	public void 업데이트쿼리() {
		List<Board> list = repository.findByHello(1);
		list.forEach(System.out::println);
		
		int i = repository.bulkDateUp(new Date(), 1);
		System.out.println(i);
		
		list = repository.findByHello(1);
		list.forEach(System.out::println);
	}

}
