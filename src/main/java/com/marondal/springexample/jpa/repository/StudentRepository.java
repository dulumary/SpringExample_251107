package com.marondal.springexample.jpa.repository;

import com.marondal.springexample.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
