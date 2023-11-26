import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DetalleProducto from './DetalleProducto';
import './ProductoCatalogo.css';
import FiltroCategoria from './FiltroCategoria';

export const ProductoCatalogo = () => {
  const [productos, setProductos] = useState([]);
  const [originalProductos, setOriginalProductos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [filterName, setFilterName] = useState('');
  const [filterMinPrice, setFilterMinPrice] = useState('');
  const [filterMaxPrice, setFilterMaxPrice] = useState('');
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [categorias, setCategorias] = useState([]);
  const [carrito, setCarrito] = useState([]);
  const [carritoAbierto, setCarritoAbierto] = useState(false);
  const [botonCarritoTexto, setBotonCarritoTexto] = useState('Abrir Carrito');

  useEffect(() => {
    console.log("Iniciando la solicitud de productos...");
    axios.get('http://localhost:8080/allproductosdetallados')
      .then(response => {
        console.log("Productos obtenidos exitosamente:", response.data);
        setProductos(response.data);
        setOriginalProductos(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error("Error al obtener productos", error);
        setLoading(false);
      });

    axios.get('http://localhost:8080/categorias')
      .then(response => {
        console.log("Categorías obtenidas exitosamente:", response.data);
        setCategorias(response.data);
      })
      .catch(error => {
        console.error("Error al obtener categorías", error);
      });
  }, []);

  const handleFilter = () => {
    
    if (!filterName && !filterMinPrice && !filterMaxPrice && selectedCategory === null) {
      setProductos(originalProductos);
      return;
    }


    let filteredProducts = originalProductos.filter(producto => {
      const nameMatch = !filterName || producto.prd_nombre.toLowerCase().includes(filterName.toLowerCase());
      const priceMatch = (
        (!filterMinPrice || producto.prd_precio >= parseFloat(filterMinPrice)) &&
        (!filterMaxPrice || producto.prd_precio <= parseFloat(filterMaxPrice))
      );
      const categoryMatch = selectedCategory === null || producto.cat_id === selectedCategory;
      return nameMatch && priceMatch && categoryMatch;
    });

    setProductos(filteredProducts);
  };

  const addToCart = (producto) => {
    const productoExistente = carrito.find(item => item.prd_id === producto.prd_id);

    if (productoExistente) {
      const carritoActualizado = carrito.map(item =>
        item.prd_id === productoExistente.prd_id
          ? { ...item, cantidad: item.cantidad + 1 }
          : item
      );

      setCarrito(carritoActualizado);
    } else {
      setCarrito([...carrito, { ...producto, cantidad: 1 }]);
    }
  };

  const removeFromCart = (productoId) => {
    const updatedCarrito = carrito.map(item =>
      item.prd_id === productoId
        ? { ...item, cantidad: item.cantidad - 1 }
        : item
    ).filter(item => item.cantidad > 0);

    setCarrito(updatedCarrito);
  };

  const toggleCarrito = () => {
    setCarritoAbierto(!carritoAbierto);
    setBotonCarritoTexto(carritoAbierto ? 'Abrir Carrito' : 'Cerrar Carrito');
  };

  return (
    <div className="producto-catalogo">
      <h1>Catálogo de productos</h1>
      
      <FiltroCategoria
        categorias={['Todas', ...categorias.map(cat => cat.cat_nombre)]}
        onCategoryChange={category => setSelectedCategory(category === 'Todas' ? null : categorias.find(cat => cat.cat_nombre === category)?.cat_id)}
      />

      <div className="filtros">
        <input
          type="text"
          placeholder="Nombre del producto"
          value={filterName}
          onChange={e => setFilterName(e.target.value)}
        />
        <input
          type="number"
          placeholder="Precio mínimo"
          value={filterMinPrice}
          onChange={e => setFilterMinPrice(e.target.value)}
        />
        <input
          type="number"
          placeholder="Precio máximo"
          value={filterMaxPrice}
          onChange={e => setFilterMaxPrice(e.target.value)}
        />
        <button onClick={handleFilter}>Filtrar</button>
        <button onClick={toggleCarrito}>{botonCarritoTexto}</button>
      </div>

      <div className={`grid-container ${carritoAbierto ? 'con-carrito' : ''}`}>
        {loading ? (
          <p>Cargando productos...</p>
        ) : (
          productos.map(producto => (
            <div key={producto.prd_id} className="producto-item">
              <img src={producto.prd_imagen} alt={""} />
              <h3>{producto.prd_nombre}</h3>
              <p>Categoría: {categorias.find(cat => cat.cat_id === producto.cat_id)?.cat_nombre}</p>
              <p>Precio: {producto.prd_precio}</p>
              <div className='button'>
                <button onClick={() => setSelectedProduct(producto)}>Ver detalles</button>
                <button onClick={() => addToCart(producto)}>Agregar al carrito</button>
              </div>
            </div>
          ))
        )}
      </div>

      <div className={`carrito ${carritoAbierto ? 'abierto' : ''}`}>
        <h2>Carrito de compras</h2>
        <ul>
          {carrito.map(item => (
            <li key={item.prd_id}>
              {item.prd_nombre} - Precio: {item.prd_precio}  Cantidad: {item.cantidad}
              <button onClick={() => removeFromCart(item.prd_id)}>Eliminar</button>
            </li>
          ))}
        </ul>
      </div>

      {selectedProduct && (
        <DetalleProducto
          producto={selectedProduct}
          onClose={() => setSelectedProduct(null)}
        />
      )}
    </div>
  );
};

export default ProductoCatalogo;
