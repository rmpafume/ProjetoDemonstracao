package com.rmpafume.systemtest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rmpafume.systemtest.api.assembler.PessoaInputDisassembler;
import com.rmpafume.systemtest.api.assembler.PessoaModelAssembler;
import com.rmpafume.systemtest.api.model.PessoaModel;
import com.rmpafume.systemtest.api.model.input.PessoaInput;
import com.rmpafume.systemtest.domain.model.Pessoa;
import com.rmpafume.systemtest.domain.repository.PessoaRepository;
import com.rmpafume.systemtest.domain.service.CadastroPessoaService;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CadastroPessoaService cadastroPessoa;
	
	@Autowired
	private PessoaInputDisassembler pessoaInputDisassembler;
	
	@Autowired
	private PessoaModelAssembler pessoaModelAssembler;
	
	@GetMapping
	public List<PessoaModel> listar() {
		List<Pessoa> pessoasList = new ArrayList<Pessoa>();
		Iterable<Pessoa> pessoas = pessoaRepository.findAll();
		pessoas.forEach(pessoasList::add);
		
		return pessoaModelAssembler.toCollectionModel(pessoasList);
	}
	
	@GetMapping("/{pessoaId}")
	public Pessoa buscar(@PathVariable Long pessoaId) {		
		return cadastroPessoa.buscarOuFalhar(pessoaId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@RequestBody @Valid PessoaInput pessoaInput){
		Pessoa pessoa = pessoaInputDisassembler.toDomainObject(pessoaInput);
		
		return cadastroPessoa.salvar(pessoa);
	}
	
	@PutMapping("/{pessoaId}")
	public Pessoa alterar(@RequestBody @Valid PessoaInput pessoaInput, @PathVariable Long pessoaId){
		Pessoa pessoaAtual = cadastroPessoa.buscarOuFalhar(pessoaId);
		pessoaInputDisassembler.copyToDomainObject(pessoaInput, pessoaAtual);
		
		return cadastroPessoa.salvar(pessoaAtual);
	}
	
	@DeleteMapping("/{pessoaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long pessoaId) {
		cadastroPessoa.excluir(pessoaId);
	}
}
