package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libary.models.Livro;

public interface LibraryRepository extends JpaRepository<Livro, String>{

}
