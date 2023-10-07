package com.example.repositories;

import com.example.db.ConnectionDB;
import com.example.enums.EmployeeStatus;
import com.example.models.Customer;
import com.example.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private final EntityManager em ;
    private final EntityTransaction transaction ;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository(){
        em = ConnectionDB.getConnection();
        transaction = em.getTransaction();
    }

    // Get All
    public List<Employee> getAllEmp() {
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter("statusActive", EmployeeStatus.ACTIVE)
                .getResultList();
    }


    // Insert
    public boolean insertEmp(Employee employee){
        try{
            transaction.begin();
            em.persist(employee);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    // Update
    public boolean updateEmp(Employee employee){
        try {
            transaction.begin();
            em.merge(employee);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    // Delete
    public boolean deleteEmp(long id){
        Optional<Employee> obj = findById(id);
        if(obj.isPresent()){
            Employee employee = obj.get();
            employee.setStatus(EmployeeStatus.DELETE);
            updateEmp(employee);
            return true;
        }
        return false;
    }
    // Set Active
    public boolean activeEmp(long id){
        Optional<Employee> obj = findById(id);
        if(obj.isPresent()){
             Employee employee = obj.get();
             employee.setStatus(EmployeeStatus.ACTIVE);
             updateEmp(employee);
             return true;
        }
        return false;
    }
    // Find by id
    public Optional<Employee> findById(long id){
        Employee employee = em.find(Employee.class,id);
        return employee == null ? Optional.empty() : Optional.of(employee);
    }
}
