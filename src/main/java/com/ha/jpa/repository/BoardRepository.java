package com.ha.jpa.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ha.jpa.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	/**
	 * @value = JPQL ���������� �Ű����� ������ 1��° ���� �����Ѵ�. 
	 * */
//	@Query("select b from Board b where b.id = ?1")
	@Query("select b from Board b where b.id = :id")
	List<Board> findByHello(@Param("id") long i);
	
	
	/**
	 * @value = ����Ƽ�� ���������� �Ű����� ������ 0��° ���� �����Ѵ�. 
	 * */
	@Query(value = "SELECT * FROM BOARD WHERE id = ?0", nativeQuery = true)
	List<Board> findByHello2(@Param("id") long i);
	
	/*
	 * @Transactional
	 * 
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query(value = "update Board b set b.date = :date where b.id = :id") int
	 * bulkDateUp(@Param("date") Date date, @Param("id") long id);
	 */
}
