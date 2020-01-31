package com.employee;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class EmployeeApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Component
    public class DatabaseLoader implements CommandLineRunner
    {
        private final EmployeeDAO employeeDAO;

        @Autowired
        public DatabaseLoader(EmployeeDAO repository)
        {
            employeeDAO = repository;
        }

        @Override
        public void run(String... strings) throws Exception
        {
			employeeDAO.save(new Employee("vishaljain93", "cybage@123", "Vishal", "Jain", 26, 10000.00));
        }
    }

}
