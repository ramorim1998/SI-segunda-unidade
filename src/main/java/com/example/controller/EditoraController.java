package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.EditoraRepository;

import libary.models.Editora;
@CrossOrigin
@RestController
@RequestMapping("/editora")
public class EditoraController {
	@Autowired
	private EditoraRepository er;
	
	//editora
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Editora> listaEditoras() {
		Iterable<Editora> listaEditoras = er.findAll();
		return listaEditoras;
	}
	
	@PostMapping()
	public Editora cadastrarEditora(@RequestBody Editora editora) {
		return er.save(editora);
	}
	
	@DeleteMapping()
	public Editora deleteEditora(@RequestBody Editora editora) {
		er.delete(editora);
		return editora;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Editora> getEditora(@PathVariable("id") String id) {
		return er.findById(id);
	}
	
	
}
