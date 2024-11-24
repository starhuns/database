package com.chensongqing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class OpengaussOdbcConnectionTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConnection() {
        String sql = "SELECT 1";
        jdbcTemplate.queryForObject(sql, Integer.class);
    }
}