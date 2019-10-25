package com.example.algamoney.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.algamoney.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository <Lancamento, Long> {

	@Query("select l from Lancamento l where "
			+ "  not((l.situacao = 1) "
			+ " and (l.pessoa.tipoAcesso = 1)) ")
	List<Lancamento> findFiltrado();
	
	
	

}
