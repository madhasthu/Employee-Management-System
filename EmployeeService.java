package com.example.employeemanagement.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ✅ Existing method to get all employees as a list
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ New method to get employees with pagination and sorting
    public Page<Employee> getPaginatedEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return employeeRepository.findAll(pageable);
    }

    // ✅ Save an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // ✅ Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // ✅ Update employee
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // ✅ Search employees by keyword (name or email)
    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.searchEmployees(keyword);
    }

    // ✅ Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
