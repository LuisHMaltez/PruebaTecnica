import React from 'react';
import './Carrito.css';

const Carrito = ({ carrito, removeFromCart, decreaseQuantity, increaseQuantity }) => {
  return (
    <div className="carrito-sidebar">
      <h2>Carrito de compras</h2>
      <ul>
        {carrito.map(item => (
          <li key={item.prd_id}>
            {item.prd_nombre} - Precio: {item.prd_precio} - Cantidad: {item.cantidad}
            <button onClick={() => removeFromCart(item.prd_id)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Carrito;
