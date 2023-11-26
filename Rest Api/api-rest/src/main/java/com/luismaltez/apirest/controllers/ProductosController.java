package com.luismaltez.apirest.controllers;

import com.luismaltez.apirest.model.Categorias;
import com.luismaltez.apirest.model.Productos;
import com.luismaltez.apirest.service.ProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductosController {

    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Productos>> getProductosByCategoryId(@RequestParam(name = "catId") Long catId) {
        List<Productos> productos = productosService.getProductosByCategoryId(catId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @GetMapping("/allproductos")
    public List<Productos> getAllProductos() {
        return productosService.getAllProductos();
    }
}

