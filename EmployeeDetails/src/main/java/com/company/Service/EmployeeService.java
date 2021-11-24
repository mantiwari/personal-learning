package com.company.Service;

import com.company.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

      void addEmployee(Employee emp);
       List <Employee> showEmployee();
       Employee updateEmployee(Long id);
       void deleteEmployee(Long id);
}
