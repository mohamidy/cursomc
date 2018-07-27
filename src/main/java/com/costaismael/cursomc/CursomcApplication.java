package com.costaismael.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.costaismael.cursomc.domain.Categoria;
import com.costaismael.cursomc.domain.Cidade;
import com.costaismael.cursomc.domain.Cliente;
import com.costaismael.cursomc.domain.Endereco;
import com.costaismael.cursomc.domain.Estado;
import com.costaismael.cursomc.domain.Produto;
import com.costaismael.cursomc.domain.enums.TipoCliente;
import com.costaismael.cursomc.repositories.CategoriaRepository;
import com.costaismael.cursomc.repositories.CidadeRepository;
import com.costaismael.cursomc.repositories.ClienteRepository;
import com.costaismael.cursomc.repositories.EnderecoRepository;
import com.costaismael.cursomc.repositories.EstadoRepository;
import com.costaismael.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;		
	@Autowired
	private EstadoRepository estadoRepository;	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
	
		Produto p1 = new Produto (null,"computador",2000.00);
		Produto p2 = new Produto (null,"impressora",30.00);
		Produto p3 = new Produto (null,"mouse",90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Santa Catarina");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Joinville",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));		
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria da Silva", "maria@gmail.com","3548",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("3464580","99868686"));
		
		Endereco e1 = new Endereco(null, "Rua","30", "Apto","Jardim","35548",cli1,c1);
		Endereco e2 = new Endereco(null, "Avenida","99", "Casa","Costa","35548",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
		
	}
}
