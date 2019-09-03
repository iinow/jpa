package com.ha.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.jpa.entity.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long>{

}
