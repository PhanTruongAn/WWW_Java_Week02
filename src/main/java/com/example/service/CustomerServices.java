package com.example.service;

import com.example.models.Customer;
import com.example.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServices {
    private final CustomerRepository customerRepository;
    public CustomerServices(){
        customerRepository = new CustomerRepository();
    }
    public List<Customer> getAllCus(){
        return customerRepository.getAllCus();
    }
    public boolean insertCus(Customer cus) {
        customerRepository.insertCus(cus);
        return true;
    }
    public boolean updateCus(Customer cus){
        customerRepository.updateCus(cus);
        return true;
    }
    public boolean deleteCus(long id){
        customerRepository.deleteCus(id);
        return true;
    }
    public Optional<Customer> findById(long id){
        return  customerRepository.findById(id);
    }
}
