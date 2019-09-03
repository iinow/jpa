package com.ha.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.jpa.entity.ClientGrantTypeModel;
import com.ha.jpa.repository.ClientGrantTypeRepository;

@Service
public class ClientGrantTypeService {

	@Autowired
	private ClientGrantTypeRepository repository;
	
	public void add(ClientGrantTypeModel model) {
		repository.save(model);
	}
}
