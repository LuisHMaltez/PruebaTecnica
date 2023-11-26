package com.luismaltez.apirest.model;

public class Categorias {
    public final long cat_id;
    public final String cat_nombre;

    public Categorias(long catId, String catNombre) {
        cat_id = catId;
        cat_nombre = catNombre;
    }
}
