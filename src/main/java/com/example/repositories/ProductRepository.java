package com.example.repositories;

import com.example.db.ConnectionDB;
import com.example.enums.ProductStatus;
import com.example.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class ProductRepository {
    private final EntityManager em ;
    private final EntityTransaction transaction ;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductRepository(){
        em = ConnectionDB.getConnection();
        transaction = em.getTransaction();
    }

    //Find by id
    public Optional<Product> findById(long id){
        Product product = em.find(Product.class,id);
        return product == null ? Optional.empty() : Optional.of(product);
    }

   // Get All
    public List<Product> getAllPro(){
        return em.createNamedQuery("Product.findAll",Product.class)
                .setParameter("status", ProductStatus.ACTIVE)
                .getResultList();
    }

    // Insert
    public boolean insertPro(Product product){
        try {
           transaction.begin();
           em.persist(product);
           transaction.commit();
           return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    // Update
    public boolean updatePro(Product product){
        try {
           transaction.begin();
           em.merge(product);
           transaction.commit();
           return true;
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    // Delete
    public boolean deletePro(long id){
        Optional<Product> obj = findById(id);
        if(obj.isPresent()){
            Product product = obj.get();
            product.setStatus(ProductStatus.TERMINATE);
            updatePro(product);
            return true;
        }
        return false;
    }
    // Product Active
    public boolean activePro(long id){
        Optional<Product> obj = findById(id);
        if(obj.isPresent()){
            Product product = obj.get();
            product.setStatus(ProductStatus.ACTIVE);
            updatePro(product);
            return true;
        }
        return false;
    }
}
