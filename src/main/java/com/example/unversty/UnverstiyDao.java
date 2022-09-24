package com.example.unversty;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UnverstiyDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Unverstiy> all_unver() {
        String sql="select * from unver";
  return   jdbcTemplate.query(sql,(rs,row)->
        Unverstiy.builder().id(rs.getInt(1)).unverName(rs.getString(2)).build()

    );

    }
}
