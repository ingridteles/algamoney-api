package com.example.algamoney.api.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.dto.LancamentoDTO;
import com.example.algamoney.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
//	@GetMapping
//	public List<Lancamento> listar() {
//		return lancamentoRepository.findAll();
//	}
	
//	@GetMapping
//	public List<LancamentoDTO> listarFiltrado() {
//		return lancamentoRepository.findFiltrado();
//	}
	
	@GetMapping
	public ResponseEntity<List<LancamentoDTO>> findSequenciais() {

        List<Lancamento> lista = lancamentoRepository.findFiltrado();
        List<LancamentoDTO> listaDTO = lista.stream().map(obj -> new LancamentoDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
		return this.lancamentoRepository.findById(codigo)
				.map(lancamento -> ResponseEntity.ok(lancamento))
				.orElse(ResponseEntity.notFound().build());
	}
}
