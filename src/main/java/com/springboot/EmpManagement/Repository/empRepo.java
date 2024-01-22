package com.springboot.EmpManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.EmpManagement.entity.employee;

public interface empRepo extends JpaRepository<employee, Integer> {

}
