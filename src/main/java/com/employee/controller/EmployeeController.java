package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employee/details")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public String getAllEmployees()
    {
        employeeService.getAllEmployees();
        return "All Employees";
    }

    @GetMapping("/getEmployeeByUsername/{userame}")
    public String getEmployeeByUsername(final @RequestParam(name = "username") String username) throws Exception
    {
        try
        {
            employeeService.getEmployeeByUsername(username);
            return "Username";
        }
        catch (Exception e)
        {
            throw new Exception("Resource Not Found");
        }
    }

    @RequestMapping(value = "add")
    public String addEmployee(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/save")
    public String save(final @RequestParam Employee employee)
    {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    /*@PutMapping("/updateEmployee/{employee}")
    public void updateEmployee(final @RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
    }*/

    @DeleteMapping("/deleteEmployee/{username}")
    public String deleteEmployeeByUsername(final @PathVariable(name = "username") String username, Model model)
    {
        employeeService.deleteEmployee(username);
        return "redirect:/";
    }
}