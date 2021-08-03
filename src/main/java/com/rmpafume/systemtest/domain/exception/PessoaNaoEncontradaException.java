package com.rmpafume.systemtest.domain.exception;

public class PessoaNaoEncontradaException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PessoaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public PessoaNaoEncontradaException(Long pessoaId) {
		super(String.format("Não existe um cadastro de pessoa com código %d", pessoaId));
	}
}
