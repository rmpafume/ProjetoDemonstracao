package com.rmpafume.systemtest.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaInput {
	
	@NotBlank
	private String nome;
	
	@Min(value = 10, message = "Idade não pode ser menor que 10")
    @Max(value = 120, message = "Idade não pode ser maior que 120")
	@NotNull
	private BigDecimal idade;
	
	@NotBlank
	@Email
	private String email;
}
