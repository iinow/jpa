package com.ha.jpa.controller;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import com.ha.jpa.entity.Academy;
import com.ha.jpa.repository.AcademyRepository;
import com.ha.jpa.repository.AcademyRepositorySupport;
import com.ha.jpa.sys.ApiVersion;

@RestController
@RequestMapping("/")
@ApiVersion(1)
public class TestController {
	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
//	@Autowired
//	EntityManager manager;
	
	@Autowired
	AcademyRepository jpaRepository;
	
	@Autowired
	AcademyRepositorySupport support;
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityManagerFactory factory;

	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	@GetMapping(path = "test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter getString() {
//		JPAQuery query = new JPAQuery(manager);
		SseEmitter emitter = new SseEmitter();
		executor.execute(()->{
			try {
				for(int i = 0; true; i++) {
					SseEventBuilder event = SseEmitter.event()
							.data("SSE DATA - "+LocalTime.now().toString())
							.id(String.valueOf(i))
							.name("sse event - data");
					emitter.send(event);
					Thread.sleep(1000);
				}				
			} catch (Exception e) {
				emitter.completeWithError(e);
			}
		});
		return emitter;
	}
	
	@PostMapping("academy/")
	public List<Academy> postAcademy(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "addr") String addr) {
		Academy a = new Academy(name, addr);
		jpaRepository.save(a);
		return support.findByName(name);
	}
	
	@GetMapping("academy/")
	public Academy postAcademy(
			@RequestParam(name = "i") Long i) {
		return jpaRepository.findById(i).get();
	}
	
	@GetMapping("academy")
	public List<Academy> getAcademy(
			@RequestParam(name = "i", required = false) Long i) {
		if(i == null) {
			return jpaRepository.findAll();
		}
		EntityManager manager2 = factory.createEntityManager(); 
		Academy entity = manager2.find(Academy.class, i);
		logger.info("값 포함 여부 : "+manager.contains(entity));
		EntityTransaction tran = manager2.getTransaction();
		tran.begin();
//		return jpaRepository.findById(i).get();
		entity.setName("d123");
		
		tran.commit();
		return Arrays.asList(entity);
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
		Academy entity = manager.find(Academy.class, i);
		logger.info("값 포함 여부 : "+manager.contains(entity));
		
		Academy b = jpaRepository.findById(i).get();
		b.setAddress(addr);
		b.setName(name);
		jpaRepository.save(b);
	}
	
}
