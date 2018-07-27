package com.costaismael.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costaismael.cursomc.domain.Categoria;
import com.costaismael.cursomc.repositories.CategoriaRepository;
import com.costaismael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontado id: "+id
				                          +",Tipo: "+Categoria.class.getName()); 	
		}		
		return obj;
	}
}
