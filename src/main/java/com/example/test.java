package com.example;

import com.example.db.ConnectionDB;
import com.example.enums.EmployeeStatus;
import com.example.models.Customer;
import com.example.models.Employee;
import com.example.models.Product;
import com.example.repositories.CustomerRepository;
import com.example.repositories.EmployeeRepository;
import com.example.service.CustomerServices;
import com.example.service.EmployeeServices;
import com.example.service.ProductServices;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class test {
    public static void main(String[] args) {
          ProductServices data = new ProductServices();
//        LocalDate date =  LocalDate.of(2000, 1, 22);
//        Employee cus = new Employee(4L,"csdvs",date,"cac","cdsd","cca",EmployeeStatus.IN_ACTIVE);
//        boolean rs = data.updateEmp(cus);
//        System.err.println(rs);
//        Optional<Employee> cus = data.findById(4L);
//        System.out.println(cus);
//        ConnectionDB.getConnection();
//        boolean rs  = data.activeEmp(1L);
//        System.out.println(rs);
//        Optional<Employee> em = data.findById(3L);
//        System.out.println(em);
          List<Product> l = data.getAllPro();
          l.forEach(x ->System.out.println(x));
//        boolean rs = data.insertEmp(em);
//        System.out.println(rs);
    }

}
