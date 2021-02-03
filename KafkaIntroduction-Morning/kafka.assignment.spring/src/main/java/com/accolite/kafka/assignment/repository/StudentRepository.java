package com.accolite.kafka.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.kafka.assignment.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
