package com.dsc.stadium.repository.impl;

import com.dsc.stadium.dto.StadiumDto;
import com.dsc.stadium.filter.SearchFilter;
import com.dsc.stadium.repository.CustomStadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomStadiumRepositoryImpl implements CustomStadiumRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomStadiumRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<StadiumDto> getList(Double latitude, Double longitude) {
        String sql = "select id,\n" +
                "name,\n" +
                "address,\n" +
                "description,\n" +
                "latitude,\n" +
                "longitude,\n" +
                "price,\n" +
                "distance(latitude, longitude, :latitude2, :longitude2) as distance\n" +
                "from stadium\n" +
                "order by distance limit 20";
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("latitude2", latitude);
        source.addValue("longitude2", longitude);
        return jdbcTemplate.query(sql, source, (rs, rowNum) -> new StadiumDto(rs.getInt("name"), rs.getString("name"), rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("address"), rs.getBigDecimal("price"), rs.getString("description"), rs.getDouble("distance")));
    }
}
