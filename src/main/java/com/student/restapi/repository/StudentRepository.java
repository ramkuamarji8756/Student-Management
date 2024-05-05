package com.student.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
