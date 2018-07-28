package com.costaismael.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costaismael.cursomc.domain.Cliente;
import com.costaismael.cursomc.repositories.ClienteRepository;
import com.costaismael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontado id: "+id
				                          +",Tipo: "+Cliente.class.getName()); 	
		}		
		return obj;
	}
}
