package com.skyfree.maven.web.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyfree.maven.service.TestService;

import org.slf4j.Logger;

@RestController
public class TestControl extends BaseControl {
    
    Logger logger = LoggerFactory.getLogger(TestControl.class);

    @Autowired
    TestService service;
    
    @RequestMapping("/test")
    public void test() throws IOException {
        List<Map<String, Object>> testMySql = service.testMySql();
        for(Map<String, Object> map : testMySql) {
            logger.info("{}", map);
        }
    }
}
