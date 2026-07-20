package org.example.employeemanagementsystem.controller;

import org.example.employeemanagementsystem.entity.Department;
import org.example.employeemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return service.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable Long id) {
        return service.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {

        service.deleteDepartment(id);

        return "Department Deleted Successfully";

    }

}
