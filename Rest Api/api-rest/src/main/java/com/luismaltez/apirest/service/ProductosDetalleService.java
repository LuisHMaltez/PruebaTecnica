package com.luismaltez.apirest.service;

import com.luismaltez.apirest.model.Productos;
import com.luismaltez.apirest.model.ProductosDetalle;
import com.luismaltez.apirest.repositories.ProductosDetalleRepository;
import com.luismaltez.apirest.repositories.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosDetalleService {

    private final ProductosDetalleRepository repository;

    public ProductosDetalleService(ProductosDetalleRepository repository) {
        this.repository = repository;
    }

    public List<ProductosDetalle> getProductoById(Long prdId) {
        return repository.findById(prdId);
    }

    public List<ProductosDetalle> getAllProductosDetallados() {
        return repository.getAllProductosDetallados();
    }
}
