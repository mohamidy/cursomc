package com.costaismael.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.costaismael.cursomc.domain.Categoria;
import com.costaismael.cursomc.repositories.CategoriaRepository;
import com.costaismael.cursomc.services.exceptions.DataIntegrityException;
import com.costaismael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontado id: "+id
				                          +",Tipo: "+Categoria.class.getName()); 	
		}		
		return obj;
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}	
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}catch (DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não é possível deletar categoria que possui produtos.");	
		}
	}	
}
