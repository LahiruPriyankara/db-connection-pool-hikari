package com.lhu.dbconnectionpool.controller;

import com.lhu.dbconnectionpool.model.Student;
import com.lhu.dbconnectionpool.repository.StudentClassRepository;
import com.lhu.dbconnectionpool.repository.StudentInterfaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentInterfaceRepository repository;

    @Autowired
    private StudentClassRepository studentClassRepository;


    private static int SERVER_HIT_COUNT = 0;

    @GetMapping("get-all")
    public ResponseEntity<List<Student>> getAllStudents() throws InterruptedException {
        SERVER_HIT_COUNT++;
        log.info("START getAllStudents..SERVER_HIT_COUNT:"+SERVER_HIT_COUNT);
        List<Student> allStudent = repository.findAll();
        log.info("allStudent : " + allStudent);
        Thread.sleep(30000);
        log.info("END getAllStudents..SERVER_HIT_COUNT:"+SERVER_HIT_COUNT);
        return ResponseEntity.ok(allStudent);
    }

    @GetMapping("save")
    public ResponseEntity<List<Student>> saveStudents() throws Exception {
        log.info("saveStudents..");
        repository.save(Student.builder().studentName("name-" + Math.random()).build());
        return getAllStudents();
    }

    @GetMapping("get-count")
    public ResponseEntity<Long> getStudentsCount() {
        log.info("getStudentsCount..");
        return ResponseEntity.ok(studentClassRepository.getStudentCount());
    }

}
