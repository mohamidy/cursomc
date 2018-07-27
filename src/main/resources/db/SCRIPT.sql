create table categoria (
        id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nome varchar(255)
    )

    create table produto (
        id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nome varchar(255),
        preco double
    )

    create table produto_categoria (
        produto_id integer not null,
        categoria_id integer not null
    )
    
    
    
alter table produto_categoria 
        add CONSTRAINT `fk_prod_cat`
		FOREIGN KEY (categoria_id) REFERENCES categoria (id)
		
		
alter table produto_categoria 
        add CONSTRAINT `fk_cat_prod`
		FOREIGN KEY (produto_id) REFERENCES produto (id)
