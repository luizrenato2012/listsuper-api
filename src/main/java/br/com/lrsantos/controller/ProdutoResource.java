package br.com.lrsantos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lrsantos.model.bean.Produto;
import br.com.lrsantos.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listaTodos() {
		List<Produto> produtos = this.repository.findAll();
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	public ResponseEntity<Produto> inclui(@RequestBody @Valid Produto produtoNovo){
		Produto produto = this.repository.save(produtoNovo);
		ResponseEntity response = new ResponseEntity(HttpStatus.CREATED);
		return response.of( Optional.of(produto));
	}
	
	@DeleteMapping
	@RequestMapping("/{id}")
	public ResponseEntity exclui(@PathVariable Long id) {
		this.repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
