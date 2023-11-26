package com.luismaltez.apirest.model;

public class Productos {

    public final long prd_id;
    public final String prd_nombre;
    public final Number prd_precio;

    public Productos(long prdId, String prdNombre, Number prdPrecio) {
        prd_id = prdId;
        prd_nombre = prdNombre;
        prd_precio = prdPrecio;
    }
}

