package com.luismaltez.apirest.repositories;

import com.luismaltez.apirest.model.Categorias;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CategoriasRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private CategoriasMapper mapper = new CategoriasMapper();

    public CategoriasRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Categorias> getAllCategorias() {
        String sql = "SELECT * FROM CATEGORIA";
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    public static class CategoriasMapper implements RowMapper<Categorias> {

        @Override
        public Categorias mapRow(ResultSet rs, int rowNum) throws SQLException {
            long cat_id = rs.getLong("cat_id");
            String cat_nombre = rs.getString("cat_nombre");
            return new Categorias(cat_id, cat_nombre);
            }
    }
}
