/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ProdusDao;
import db.Produs;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vlad
 */
public class MainService {
    
    private EntityManagerFactory emf;
    
    public MainService(){
    emf=Persistence.createEntityManagerFactory("java2c2e5bisPU");
    }
     //daca era privat constructorul de mai sus faceam cu singleton
//    private static final class SingletonHolder {
//        private static final ProdusService SINGLETON = new ProdusService();
//    }
//
//    public static ProdusService getInstance() {
//        return SingletonHolder.SINGLETON;
//    }
//
    
    public void adaugaZeceProduse() {
        EntityManager em = emf.createEntityManager();
        ProdusDao produsDao = new ProdusDao(em);
        
        try {
            em.getTransaction().begin();
            for (int i=1 ;i<=10; i++) {
                Produs p = new Produs();
                p.setNume("PRODUS "+i);
                p.setPret(10);
                produsDao.adaugaProdus(p);
                em.flush();
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public List<Produs> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            ProdusDao dao = new ProdusDao(em);
            return dao.getAllProducts();
        } finally {
            em.close();
        }
    }
    
     public void stergeProdus(Produs p) {
        EntityManager em = emf.createEntityManager();
        ProdusDao dao = new ProdusDao(em);
        
         try {
            em.getTransaction().begin();
            //p = em.merge(p);
            p = dao.getProdus(p.getId());
            if (p != null) {
                dao.stergeProdus(p);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
     public void modificaProdus(int id, String nume, double pret) {
        EntityManager em = emf.createEntityManager();
        ProdusDao dao = new ProdusDao(em);
        
        try {
            em.getTransaction().begin();
            Produs p = dao.getProdus(id);
            //em.detach(p);
            if (p != null) {
                p.setNume(nume);
                p.setPret(pret);
                //em.refresh(p);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
