package com.luismaltez.apirest.repositories;

import com.luismaltez.apirest.model.Productos;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductosRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private ProductosMapper mapper = new ProductosMapper();

    public ProductosRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Productos> findByCatId(Long catId) {
        String sql = "SELECT * FROM PRODUCTOS WHERE cat_id = :catId";
        Map<String, Object> params = new HashMap<>();
        params.put("catId", catId);
        return namedParameterJdbcTemplate.query(sql, params, mapper);
    }

    public List<Productos> getAllProductos() {
        String sql = "SELECT * FROM PRODUCTOS";
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    public static class ProductosMapper implements RowMapper<Productos> {

        @Override
        public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
            long prd_id = rs.getLong("prd_id");
            String prd_nombre = rs.getString("prd_nombre");
            Number prd_precio = rs.getBigDecimal("prd_precio");

            return new Productos(prd_id, prd_nombre, prd_precio);
        }
    }
}