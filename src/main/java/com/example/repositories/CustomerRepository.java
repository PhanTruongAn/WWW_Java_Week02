package com.example.repositories;

import com.example.db.ConnectionDB;
import com.example.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private final EntityManager em;
    private final EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository(){
        em = ConnectionDB.getConnection();
        transaction = em.getTransaction();
    }

    //Get All
    public List<Customer> getAllCus(){
        return em.createNamedQuery("Customer.findAll",Customer.class).getResultList();
    }


    // Insert
    public boolean insertCus(Customer cus) {
        try {
            transaction.begin();
            em.persist(cus);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }
    // Update

    public boolean updateCus(Customer cus){
        try {
            transaction.begin();
            em.merge(cus);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    // Delete
    public boolean deleteCus(long id){
          try {
              transaction.begin();
              em.remove(em.find(Customer.class,id));
              transaction.commit();
              return true ;
          }catch (Exception e){
              transaction.rollback();
              logger.error(e.getMessage());
          }
          return false;
    }

    // Find by id
    public Optional<Customer> findById(long id){
        Customer cus = em.find(Customer.class,id);
        return cus == null ? Optional.empty() : Optional.of(cus);
    }
}
