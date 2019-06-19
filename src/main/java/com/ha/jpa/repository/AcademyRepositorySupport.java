package com.ha.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.ha.jpa.entity.Academy;
import com.ha.jpa.entity.QAcademy;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {
	private final JPAQueryFactory queryFactory;

    public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
        super(Academy.class);
        this.queryFactory = queryFactory;
    }
    
    public List<Academy> findByName(String name){
    	return queryFactory
    			.selectFrom(QAcademy.academy)
    			.where(QAcademy.academy.name.eq(name))
    			.fetch();
    }
}
