package com.ha.jpa.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.jpa.entity.Board;
import com.ha.jpa.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository repository;
	
	@Transactional
	public void setDate(long i) {
		Board board = repository.findById(i).get();
		board.setDate(new Date());
		System.out.println(board.toString());
	}
}
