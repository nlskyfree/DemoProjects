package com.skyfree.maven.persist.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MySQLRepository {
    
    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    JdbcTemplate mysqlTemplate;
    
    public List<Map<String, Object>> testMySQL() {
        return mysqlTemplate.queryForList("select * from data_source");
    }
    
}
