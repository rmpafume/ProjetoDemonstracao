package com.rmpafume.systemtest.api.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaModel {
	
	private Long id;
	private String nome;
	private BigDecimal idade;
	private String email;
	
}
