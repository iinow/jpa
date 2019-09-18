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

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
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
	public void useNamedQuery() {
//		EntityManager manager = entityManagerFactory.createEntityManager();
		List<Board> list =  entityManager.createNamedQuery("Board.findByHello", Board.class)
			.setParameter("id", (long)1)
			.getResultList();
		
		list.forEach(System.out::println);
	}
	
	@Test
	public void useNamedQuery2() {
		List<Board> list = repository.findByHello(1);
		Hibernate.initialize(list);
		list.forEach(System.out::println);
	}
	
	@Test
	public void updateQuery() {
		List<Board> list = repository.findByHello(1);
		list.forEach(System.out::println);
		
//		int i = repository.bulkDateUp(new Date(), 1);
//		System.out.println(i);
		
		list = repository.findByHello(1);
		list.forEach(System.out::println);
	}
	
	@Test
	public void jwt1() {
		String jwtString = null;
		String token = JWT.create().withClaim("name", "hello").sign(Algorithm.none());
		System.out.println(token);
		DecodedJWT decode = JWT.decode(token);
		System.out.println("id: \t"+decode.getId());
		System.out.println("header: \t"+decode.getHeader());
		System.out.println("algorithm: \t"+decode.getAlgorithm());
		System.out.println("payload: \t"+decode.getPayload());
		System.out.println("signature: \t"+decode.getSignature());
		System.out.println("subject: \t"+decode.getSubject());
		decode.getClaims().forEach((k, v)->{
			System.out.println("claims: \t k: "+k+", v: "+v.asString());
		});
		System.out.println("audience: \t"+decode.getAudience());
		System.out.println("contenttype: \t"+decode.getContentType());
		System.out.println("expiresAt: \t"+decode.getExpiresAt());
		System.out.println("issusedAt: \t"+decode.getIssuedAt());
	}

}
