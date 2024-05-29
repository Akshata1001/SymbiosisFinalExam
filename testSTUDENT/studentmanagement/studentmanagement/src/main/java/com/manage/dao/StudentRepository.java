package com.manage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
