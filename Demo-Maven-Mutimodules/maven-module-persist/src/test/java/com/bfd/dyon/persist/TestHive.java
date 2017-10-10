//package com.bfd.dyon.persist;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@SpringBootTest(classes=TestApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TestHive {
//    @Autowired
//    @Qualifier("hiveDataSource")
//    private DataSource ds;
//    
//    @Test
//    public void testHive() throws SQLException {
//        long start = System.currentTimeMillis();
//        Connection conn = ds.getConnection();
//        PreparedStatement stmt = conn.prepareStatement("select * from email");
//        ResultSet rs = stmt.executeQuery();
////        int count = 10000;
////        while(count -- >= 0) {
////            rs.next();
////        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        
//        stmt.close();
//        conn.close();
//    }
//}
