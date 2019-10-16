package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(codigo);
		return pessoaOpt.isPresent() ? ResponseEntity.ok(pessoaOpt.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Pessoa> criar(@Validated @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);

	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@Validated @RequestBody Pessoa pessoa, @PathVariable Long codigo,
			HttpServletResponse response) {
		Optional<Pessoa> pessoaOptRecuperada = pessoaRepository.findById(codigo);

		Pessoa pessoaRecuperada = null;

		if (pessoaOptRecuperada.isPresent()) {
			pessoaRecuperada = pessoaOptRecuperada.get();
			pessoaRecuperada.setNome(pessoa.getNome());
			pessoaRecuperada.setEndereco(pessoa.getEndereco());
			pessoaRecuperada.setAtivo(pessoa.getAtivo());
			pessoaRecuperada = pessoaRepository.save(pessoaRecuperada);
		}

		return pessoaRecuperada != null ? ResponseEntity.ok(pessoaRecuperada) : ResponseEntity.notFound().build();

	}

}
