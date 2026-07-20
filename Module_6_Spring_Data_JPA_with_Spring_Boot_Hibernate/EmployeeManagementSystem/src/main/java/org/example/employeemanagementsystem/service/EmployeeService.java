package org.example.employeemanagementsystem.service;

import org.example.employeemanagementsystem.entity.Employee;
import org.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByName(name);
    }

    public Employee findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findByDepartment(String department){
        return employeeRepository.findByDepartmentName(department);
    }

    public List<Employee> searchByEmail(String keyword){
        return employeeRepository.searchByEmail(keyword);
    }

    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getEmployeesSorted(String field) {

        return employeeRepository.findAll(
                Sort.by(field)
        );
    }

    public List<Employee> getEmployeesSortedDesc(String field) {

        return employeeRepository.findAll(
                Sort.by(field).descending()
        );
    }

}