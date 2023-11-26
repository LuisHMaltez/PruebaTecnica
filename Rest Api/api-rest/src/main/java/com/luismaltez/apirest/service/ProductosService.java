package com.luismaltez.apirest.service;

import com.luismaltez.apirest.model.Categorias;
import com.luismaltez.apirest.model.Productos;
import com.luismaltez.apirest.repositories.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductosService {

    private final ProductosRepository repository;

    public ProductosService(ProductosRepository repository) {
        this.repository = repository;
    }

    public List<Productos> getProductosByCategoryId(Long catId) {
        return repository.findByCatId(catId);
    }

    public List<Productos> getAllProductos() {
        return repository.getAllProductos();
    }
}

