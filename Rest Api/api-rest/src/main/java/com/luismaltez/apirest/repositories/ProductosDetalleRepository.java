package com.luismaltez.apirest.repositories;

import com.luismaltez.apirest.model.Productos;
import com.luismaltez.apirest.model.ProductosDetalle;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductosDetalleRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private ProductosDetalleMapper mapper = new ProductosDetalleMapper();

    public ProductosDetalleRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<ProductosDetalle> findById(Long prdId) {
        String sql = "SELECT * FROM PRODUCTOS WHERE prd_id = :prdId";
        Map<String, Object> params = new HashMap<>();
        params.put("prdId", prdId);
        return namedParameterJdbcTemplate.query(sql, params, mapper);
    }

    public List<ProductosDetalle> getAllProductosDetallados() {
        String sql = "SELECT * FROM PRODUCTOS";
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    public static class ProductosDetalleMapper implements RowMapper<ProductosDetalle> {

        @Override
        public ProductosDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
            long prd_id = rs.getLong("prd_id");
            String prd_nombre = rs.getString("prd_nombre");
            String prd_descripcion = rs.getString("prd_Descripcion");
            Number prd_precio = rs.getBigDecimal("prd_precio");
            String prd_imagen = rs.getString("prd_Imagen");
            String prd_estado = rs.getString("prd_Estado");
            int cat_id = rs.getInt("cat_id");

            return new ProductosDetalle(prd_id, prd_nombre, prd_descripcion, prd_precio, prd_imagen, prd_estado, cat_id);
        }
    }
}