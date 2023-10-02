package com.example.db;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionDB {
    private static EntityManagerFactory emf;
    public static EntityManager getConnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Lab02-week02");
        }
        System.err.println("Connect successfully!");
        return emf.createEntityManager();
    }

    public static void closeConnection() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

