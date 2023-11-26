package com.luismaltez.apirest.controllers;

import com.luismaltez.apirest.model.Categorias;
import com.luismaltez.apirest.model.Productos;
import com.luismaltez.apirest.model.ProductosDetalle;
import com.luismaltez.apirest.service.CategoriasService;
import com.luismaltez.apirest.service.ProductosDetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoDetalleController {
    private final ProductosDetalleService productosDetalleService;

    public ProductoDetalleController(ProductosDetalleService productosDetalleService) {
        this.productosDetalleService = productosDetalleService;
    }

    @GetMapping("/producto")
    public ResponseEntity<List<ProductosDetalle>> getProductosById(@RequestParam(name = "prdId") Long prdId) {
        List<ProductosDetalle> productosDetalle = productosDetalleService.getProductoById(prdId);
        return new ResponseEntity<>(productosDetalle, HttpStatus.OK);
    }
    @GetMapping("/allproductosdetallados")
    public List<ProductosDetalle> getAllProductosDetallados() {
        return productosDetalleService.getAllProductosDetallados();
    }
}
