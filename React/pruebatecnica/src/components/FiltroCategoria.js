import React from 'react';

const FiltroCategoria = ({ categorias, onCategoryChange }) => {
  return (
    <div>
      <label>Filtrar por categoría: </label>
      <select onChange={(e) => onCategoryChange(e.target.value)}>
        {categorias.map(categoria => (
          <option key={categoria} value={categoria}>{categoria}</option>
        ))}
      </select>
    </div>
  );
};

export default FiltroCategoria;
