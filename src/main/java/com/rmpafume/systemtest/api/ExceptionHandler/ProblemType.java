package com.rmpafume.systemtest.api.ExceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ERRO_DE_SISTEMA("/erro-de-sistema","Erro de sistema"),
	DADOS_INVALIDOS("/dados-invalidos","Dados inválidos"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso","Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio","Violação de regra de negócio"),
	PARAMETRO_INVALIDO("/parametro-invalido","Parametro invalido");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = "https://rmpafume.test.com.br"+ path;
		this.title = title;
	}
}
