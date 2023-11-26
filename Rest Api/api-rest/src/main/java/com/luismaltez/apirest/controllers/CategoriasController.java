package com.luismaltez.apirest.controllers;

import com.luismaltez.apirest.model.Categorias;
import com.luismaltez.apirest.service.CategoriasService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriasController {
    private final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("/categorias")
    public List<Categorias> getAllCategorias() {
        return categoriasService.getAllCategorias();
    }
}
