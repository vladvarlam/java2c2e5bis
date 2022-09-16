/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vlad
 */

@Entity
//@Access(AccessType.FIELD)
public class Produs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//mai bine cu .table
    private int id;
    

    private String nume;
    

    private double pret;
    
   // private transient int test;
// merge,nu il mapeaza in tabela
//@Access(AccessType.PROPERTY)
    public int getId() {
        
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" + "id=" + id + ", nume=" + nume + ", pret=" + pret + '}';
    }
    
    
}
