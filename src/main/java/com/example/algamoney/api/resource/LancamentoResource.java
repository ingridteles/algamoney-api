package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.model.dto.LancamentoDTO;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.service.LancamentoService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private ApplicationEventPublisher publisher; 
	
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
	
//	@GetMapping("/{codigo}")
//	public ResponseEntity<LancamentoDTO> buscarPeloCodigo(@PathVariable Long codigo) {
//		return this.lancamentoRepository.findById(codigo)
//				.map(lancamento -> ResponseEntity.ok(new LancamentoDTO(lancamento)))
//				.orElse(ResponseEntity.notFound().build());
//	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Lancamento> lancamentoOpt = lancamentoRepository.findById(codigo);
		return lancamentoOpt.isPresent() ? ResponseEntity.ok(lancamentoOpt.get()) : ResponseEntity.notFound().build();
	}

	
	@PostMapping
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public ResponseEntity<Lancamento> criar(@Validated @RequestBody Lancamento lancamento, HttpServletResponse response) {
		Lancamento lancamentoSalvo = lancamentoService.criar(lancamento);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);

	}
}
