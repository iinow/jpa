package com.ha.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.jpa.vo.UserVO;

public interface UserRepository extends JpaRepository<UserVO, String>{

}
