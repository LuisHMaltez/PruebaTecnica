package com.luismaltez.apirest.model;

public class ProductosDetalle {

    public final long prd_id;
    public final String prd_nombre;
    public final String prd_descripcion;
    public final Number prd_precio;
    public final String prd_imagen;
    public final String prd_estado;
    public final int cat_id;

    public ProductosDetalle(long prdId, String prdNombre, String prdDescripcion, Number prdPrecio, String prdImagen, String prdEstado, int catId) {
        prd_id = prdId;
        prd_nombre = prdNombre;
        prd_descripcion = prdDescripcion;
        prd_precio = prdPrecio;
        prd_imagen = prdImagen;
        prd_estado = prdEstado;
        cat_id = catId;
    }
}

