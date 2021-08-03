package com.rmpafume.systemtest.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmpafume.systemtest.domain.exception.PessoaNaoEncontradaException;
import com.rmpafume.systemtest.domain.model.Pessoa;
import com.rmpafume.systemtest.domain.repository.PessoaRepository;

@Service
public class CadastroPessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@Transactional
	public void excluir(Long pessoaId) {
		try {
			pessoaRepository.deleteById(pessoaId);
			pessoaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new PessoaNaoEncontradaException(pessoaId);
		}
	}
	
	public Pessoa buscarOuFalhar(Long pessoaId) {
		return pessoaRepository.findById(pessoaId)
				.orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));
	}
}
