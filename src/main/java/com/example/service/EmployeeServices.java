package com.example.service;

import com.example.models.Employee;
import com.example.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }
    public List<Employee> getAllEmp() {
        return employeeRepository.getAllEmp();
    }
    public boolean insertEmp(Employee employee){
        employeeRepository.insertEmp(employee);
        return true;
    }
    public boolean updateEmp(Employee employee){
        employeeRepository.updateEmp(employee);
        return true;
    }
    public boolean deleteEmp(long id){
        employeeRepository.deleteEmp(id);
        return true;
    }
    public boolean activeEmp(long id){
        employeeRepository.activeEmp(id);
        return true;
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }
}
