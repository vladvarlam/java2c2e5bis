/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import db.Produs;
import service.MainService;
//si pun ceva in test branch
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainService s=new MainService();
        s.adaugaZeceProduse();
        // TODO code application logic here
        //alternativa singleton
        //        ProdusService.getInstance().stergeProdus(p);
//        ProdusService.getInstance().modificaProdus(8, "ALT PRODUS", 100
        // ProdusService.getInstance().getAll().forEach(System.out::println);
        Produs p = new Produs();
        p.setId(6);
        s.stergeProdus( p);
        s.modificaProdus(8, "ALT PRODUS", 100);
        s.getAll().forEach(System.out::println);
        MainFrame f=new MainFrame();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
                
    }
    
}
