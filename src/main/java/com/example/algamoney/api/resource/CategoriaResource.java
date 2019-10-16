package com.example.algamoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;   
	

	// @GetMapping
	// public ResponseEntity<?> listar(){
	// List<Categoria> categorias = categoriaRepository.findAll();
	// return !categorias.isEmpty() ? ResponseEntity.ok(categorias) :
	// ResponseEntity.noContent().build();
	// }

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	// @GetMapping("/{codigo}")
	public Categoria buscarPeloCodigoComFindOne(@PathVariable Long codigo) {

		Categoria categoriaExample = new Categoria();
		categoriaExample.setCodigo(codigo);

		Example<Categoria> example = Example.of(categoriaExample);

		return this.categoriaRepository.findOne(example).orElse(null);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		return this.categoriaRepository.findById(codigo)
				.map(categoria -> ResponseEntity.ok(categoria))
				.orElse(ResponseEntity.notFound().build());

		// Resolução usando o .isPresent()
		// Optional categoria = this.categoriaRepository.findById(codigo);
		// return categoria.isPresent() ?
		// ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
	}
}
