package com.example;

import com.example.db.ConnectionDB;
import com.example.enums.EmployeeStatus;
import com.example.models.Customer;
import com.example.models.Employee;
import com.example.repositories.CustomerRepository;
import com.example.repositories.EmployeeRepository;
import com.example.service.CustomerServices;
import com.example.service.EmployeeServices;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class test {
    public static void main(String[] args) {
        CustomerServices data = new CustomerServices();
//        long size = data.nextAutoID();
//        System.out.println(size);
        long id = 11;
        Customer cus = new Customer(id,"vsdvs","vsdvsd","fwqfq","vvbr");
        boolean rs = data.insertCus(cus);
        System.err.println(rs);
//        Optional<Customer> cus = data.findbyId(4L);
//        System.out.println(cus);
//        ConnectionDB.getConnection();
//        boolean rs  = data.activeEmp(1L);
//        System.out.println(rs);
//        Optional<Employee> em = data.findById(3L);
//        System.out.println(em);
//        Timestamp time = Timestamp.valueOf(LocalDateTime.of(02,10,2002) );
//        Employee em = new Employee("csacsa",time,"cbjhvds","hvsd","cjskv", EmployeeStatus.DELETE);
//        boolean rs = data.insertEmp(em);
//        System.out.println(rs);
    }

}
