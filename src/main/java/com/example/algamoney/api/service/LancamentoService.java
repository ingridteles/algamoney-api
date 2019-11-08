package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaService pessoaService;

	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaService.find(lancamento.getPessoa().getCodigo());
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento buscarPessoaPeloCodigo(Long codigo) {
		Lancamento lancamentoSalvo = this.lancamentoRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return lancamentoSalvo;
	}
	
	public void delete(Long codigo) {
		Lancamento lancamento = buscarPessoaPeloCodigo(codigo);
		lancamentoRepository.delete(lancamento);
	}


//	public Lancamento find(Long codigo) {
//		Optional<Lancamento> opt = lancamentoRepository.findById(codigo);
//		return opt.orElseThrow(() -> new EmptyResultDataAccessException(1));
//	}
}
