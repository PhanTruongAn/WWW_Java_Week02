package com.example.db;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionDB {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab02-week02");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}
