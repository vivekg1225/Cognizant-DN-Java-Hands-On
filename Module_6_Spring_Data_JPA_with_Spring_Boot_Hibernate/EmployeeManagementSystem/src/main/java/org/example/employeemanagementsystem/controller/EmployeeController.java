package org.example.employeemanagementsystem.controller;

import org.example.employeemanagementsystem.entity.Employee;
import org.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        service.deleteEmployee(id);

        return "Employee Deleted Successfully";

    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return service.findByDepartment(department);
    }

    @GetMapping("/search/{keyword}")
    public List<Employee> searchEmail(@PathVariable String keyword) {
        return service.searchByEmail(keyword);
    }

    @GetMapping("/page")
    public Page<Employee> getEmployeesPage(
            @RequestParam int page,
            @RequestParam int size) {

        Pageable pageable = PageRequest.of(page, size);

        return service.getEmployees(pageable);
    }

    @GetMapping("/sort")
    public List<Employee> sortEmployees(
            @RequestParam String field) {

        return service.getEmployeesSorted(field);

    }

    @GetMapping("/sort-desc")
    public List<Employee> sortEmployeesDesc(
            @RequestParam String field) {

        return service.getEmployeesSortedDesc(field);

    }
}
