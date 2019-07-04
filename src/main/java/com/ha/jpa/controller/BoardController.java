package com.ha.jpa.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	 * @param id = ���� 1 �� �����൵ �ȴ� ������ Ŭ���� �����Ͱ� ������ �Ǽ� 1 �� �����ָ� ã�ư�����
	 * */
	@PutMapping("/")
	public int updateDate(
			@RequestParam("id") Board board) {
		return boardRepository.bulkDateUp(new Date(), board.getId());
	}
	
	@GetMapping("/")
	public Board getBoard(
			@RequestParam("id") long id) {
		boardService.setDate(id);
		return boardRepository.findById(id).get();
	}
	
}
