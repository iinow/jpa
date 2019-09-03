package com.ha.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.jpa.entity.ClientModel;
import com.ha.jpa.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public void getClientModel(Long id) {
		ClientModel client = repository.findById(id).get();
		String type = client.getGranttypes().get(0).getGranttype();
		System.out.println(type);
		
		String scope = client.getScopes().get(0).getScope();
		System.out.println(scope);
	}
}
