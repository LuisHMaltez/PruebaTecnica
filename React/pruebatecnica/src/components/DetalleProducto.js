import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './ProductoCatalogo'
import './DetalleProducto.css';
  
const DetalleProducto = ({ producto, onClose, categoriaNombre }) => {
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
    console.log("Iniciando la solicitud de productos...");
  axios.get('http://localhost:8080/categorias')
        .then(response => {
          console.log("Categorías obtenidas exitosamente:", response.data);
          setCategorias(response.data);
        })
        .catch(error => {
          console.error("Error al obtener categorías", error);
        });
    }, []);

  return (
    <div className="detalle-producto">
      <h2>{producto.prd_nombre}</h2>
      <p>Id del producto: {producto.prd_id}</p>
      <img src={producto.prd_imagen} alt="" />
      <p>{producto.prd_descripcion}</p>
      <p>Precio: {producto.prd_precio}</p>
      <p>Estado: {producto.prd_estado}</p>
      <p>Categoria: {categorias.find(cat => cat.cat_id === producto.cat_id)?.cat_nombre}</p>
      <button onClick={onClose}>Cerrar</button>
    </div>
  );
};

export default DetalleProducto;
