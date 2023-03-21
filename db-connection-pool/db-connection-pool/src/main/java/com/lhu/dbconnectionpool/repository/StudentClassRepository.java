package com.lhu.dbconnectionpool.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@Slf4j
public class StudentClassRepository {

    @Autowired
    private DataSource dataSource;

    public Long getStudentCount() {
        try {
            Connection connection = dataSource.getConnection();
            log.info("01. Schema name is " + connection.getSchema());
        } catch (Exception e) {
            e.printStackTrace();
        }

        long count = 0L;
        try {
            Connection connection = dataSource.getConnection();
            log.info("02. Schema name is " + connection.getSchema());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM student");

            while (resultSet.next()) {
                count = resultSet.getLong(1);
            }
            log.info("Count " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
