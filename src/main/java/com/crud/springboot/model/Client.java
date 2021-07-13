package com.crud.springboot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
@Data - gera o código padronizado para classes Java
@Entity - cria uma entidade do JPA para ser associada a uma tabela no banco com o mesmo nome
@AllArgs - vai criar o construtor passando todos os parametros
@NoArgs - Vai criar o contrutor sem passar parametros
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String nome;
    private String email;
    private Integer telefone;
    private Integer cpf;
    private Boolean status;
}
