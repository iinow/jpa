package com.ha.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.ha.jpa.vo.UserVO;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UserRepositorySupport extends QuerydslRepositorySupport{
	private final JPAQueryFactory queryFactory;
	
	public UserRepositorySupport(JPAQueryFactory queryFactory) {
		super(UserVO.class);
		this.queryFactory = queryFactory;
	}
	
	public List<UserVO> findByUsername(String username){
//		return queryFactory
//				.selectFrom(UserVO.class)
//				.where(U);
		
		return null;
	}
}
