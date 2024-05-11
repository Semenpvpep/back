package com.tsaplev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsaplev.backend.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
