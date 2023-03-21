package com.lhu.dbconnectionpool.repository;

import com.lhu.dbconnectionpool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInterfaceRepository extends JpaRepository<Student, Integer> {
}
