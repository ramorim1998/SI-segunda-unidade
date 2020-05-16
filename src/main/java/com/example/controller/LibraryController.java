package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.LibraryRepository;

import libary.models.Livro;

@RestController
@RequestMapping("/livro")
public class LibraryController {
	@Autowired
	private LibraryRepository lr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Livro> listaLivros() {
		Iterable<Livro> listaLivros = lr.findAll();
		return listaLivros;
	}
	
	@PostMapping()
	public Livro cadastrarLivro(@RequestBody Livro livro) {
		return lr.save(livro);
	}
	
	@DeleteMapping()
	public Livro deleteLivro(@RequestBody Livro livro) {
		lr.delete(livro);
		return livro;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Livro> getLivro(@PathVariable("id") String id) {
		return lr.findById(id);
	}
	
	
}
