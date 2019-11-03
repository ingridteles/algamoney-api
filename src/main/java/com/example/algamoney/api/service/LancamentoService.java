package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.model.enums.Situacao;
import com.example.algamoney.api.model.enums.TipoLancamento;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Lancamento salvar(Lancamento lancamento) {
		Lancamento lancamentoNovo = new Lancamento();
		
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElse(null);
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
			
		}
		
		
		lancamentoNovo.setDescricao(lancamento.getDescricao());
		lancamentoNovo.setDataVencimento(lancamento.getDataVencimento());
		lancamentoNovo.setDataPagamento(lancamento.getDataPagamento());
		lancamentoNovo.setValor(lancamento.getValor());
		lancamentoNovo.setObservacao(lancamento.getObservacao());
//		lancamentoNovo.setTipo(TipoLancamento.toEnum(lancamentoDTO.getTipo()));
//		lancamentoNovo.setSituacao(Situacao.toEnum(lancamentoDTO.getSituacao()));
		
//		lancamentoNovo.setTipo(lancamento.getTipo());
//		lancamentoNovo.setSituacao(lancamento.getSituacao());
		
		lancamentoNovo.setTipo(TipoLancamento.toEnum(1));
		lancamentoNovo.setSituacao(Situacao.toEnum(1));
		
		//Categoria categoria = categoriaService.buscarCategoriaPeloCodigo(lancamentoDTO.getCategoriaId());
		//lancamentoNovo.setCategoria(categoria);
		lancamentoNovo.setCategoria(lancamento.getCategoria());
		
		//Pessoa pessoa = pessoaService.buscarPessoaPeloCodigo(lancamentoDTO.getPessoaId());
		//lancamentoNovo.setPessoa(pessoa);
		lancamentoNovo.setPessoa(lancamento.getPessoa());
		
		
		return lancamentoRepository.save(lancamentoNovo);
		
	}

	public Lancamento find(Long codigo) {
		Optional<Lancamento> opt = lancamentoRepository.findById(codigo);
		return opt.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
}
