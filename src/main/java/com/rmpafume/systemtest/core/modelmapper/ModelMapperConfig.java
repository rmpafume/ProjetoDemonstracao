package com.rmpafume.systemtest.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rmpafume.systemtest.api.model.input.PessoaInput;
import com.rmpafume.systemtest.domain.model.Pessoa;


@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		/* CUSTOMIZANDO UM MAPEAMENTO DE PROPRIEDADES
		 * 
		modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
			.addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
		
		*/
		
		modelMapper.createTypeMap(PessoaInput.class, Pessoa.class) 
			.addMappings(mapper -> mapper.skip(Pessoa::setId));		
		return modelMapper;
	}
}
