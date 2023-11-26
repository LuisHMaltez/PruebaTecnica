package com.luismaltez.apirest.service;

import com.luismaltez.apirest.model.Categorias;
import com.luismaltez.apirest.repositories.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {

    private final CategoriasRepository repository;

    public CategoriasService(CategoriasRepository repository) {
        this.repository = repository;
    }

    public List<Categorias> getAllCategorias() {
        return repository.getAllCategorias();
    }
}
