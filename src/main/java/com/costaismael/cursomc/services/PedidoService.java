package com.costaismael.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costaismael.cursomc.domain.Pedido;
import com.costaismael.cursomc.repositories.PedidoRepository;
import com.costaismael.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontado id: "+id
				                          +",Tipo: "+Pedido.class.getName()); 	
		}		
		return obj;
	}
}
