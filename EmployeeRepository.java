package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ✅ Search employees by first name, last name, or email
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:keyword% OR e.lastName LIKE %:keyword% OR e.email LIKE %:keyword%")
    List<Employee> searchEmployees(@Param("keyword") String keyword);
}
