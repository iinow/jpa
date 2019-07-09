package com.ha.jpa.controller;

import java.util.Date;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBodyReturnValueHandler;

import com.ha.jpa.entity.Board;
import com.ha.jpa.repository.BoardRepository;
import com.ha.jpa.service.BoardService;
import com.ha.jpa.sys.ApiVersion;

@RestController
@RequestMapping("/boards")
@ApiVersion(1)
public class BoardController {
	private final static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardService boardService;
	
	/**
	 * @param id = 값은 1 만 보내줘도 된다 도메인 클래스 컨버터가 적용이 되서 1 을 보내주면 찾아가져옴
	 * */
	@PutMapping("/{id}")
	public int updateDate(
			@PathVariable(name = "id", required = true) Board board) {
//		return boardRepository.bulkDateUp(new Date(), board.getId());
		return 0;
	}
	
	@GetMapping("/{id}")
	public Board getBoard(
			@PathVariable(name = "id", required = true) long id) {
		return boardService.setDate(id);
	}
	
	@PostMapping("")
	public void addBoard() {
		new ResponseEntity<Board>(new Board(), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{id}")
	public void patchBoard(
			@PathVariable(required = true, name = "id") String id) {
		StreamingResponseBodyReturnValueHandler handler = new StreamingResponseBodyReturnValueHandler();
		try {
			handler.handleReturnValue(new Board(), null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@PatchMapping("/{id}")
	
}
