package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees()
    {
        return employeeDAO.findAll();
    }

    public Employee getEmployeeByUsername(final String username) throws Exception
    {
        Employee employee = employeeDAO.findById(username).orElseThrow(() -> new Exception("Resource Not Found"));
        return employee;
    }

    public void addEmployee(Employee employee)
    {
    }

    public void updateEmployee(Employee employee)
    {
    }

    public void deleteEmployee(Object username)
    {
    }
}
