package org.example.employeemanagementsystem.repository;

import org.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Methods

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findByNameEndingWith(String suffix);

    List<Employee> findByNameIgnoreCase(String name);


    // JPQL Query

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:keyword%")
    List<Employee> searchByEmail(@Param("keyword") String keyword);


    @Query("SELECT e FROM Employee e WHERE e.department.name = :dept")
    List<Employee> findEmployeesByDepartment(@Param("dept") String department);


    // Named Query

    @Query(name = "Employee.findByEmailAddress")
    Employee getEmployeeByEmail(String email);

}
