package com.company.Service;

import com.company.Model.Employee;
import com.company.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo emprepo;
    @Override
    public void addEmployee(Employee emp) {
    emprepo.save(emp);
    }

    @Override
    public List<Employee> showEmployee() {
         return (List<Employee>) emprepo.findAll();

    }

    @Override
     public Employee updateEmployee(Long id) {
        Optional<Employee> optional = emprepo.findById(id);
            Employee emp = optional.get();
            return emp;

            }

    @Override
    public void deleteEmployee(Long id){
        emprepo.deleteById(id);

    }
}
