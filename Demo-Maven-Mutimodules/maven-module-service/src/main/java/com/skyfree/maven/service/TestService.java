package com.skyfree.maven.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyfree.maven.persist.repository.MySQLRepository;

@Service
public class TestService {
    
    @Autowired
    MySQLRepository mySQLRepository;
    
    public List<Map<String, Object>> testMySql() {
        return mySQLRepository.testMySQL();
    }
}
