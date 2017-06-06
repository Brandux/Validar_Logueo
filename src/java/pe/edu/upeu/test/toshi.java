/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.test;

import java.sql.Connection;
import pe.edu.upeu.dao.LoginDao;
import pe.edu.upeu.model.Login;
import pe.edu.upeu.util.conexion;

/**
 *
 * @author UPEU
 */
public class toshi {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conex();
       // extuser();
        //validar();
    }
    
    public static void conex() {
        Connection cx = conexion.getCoxeion();
        if (cx != null) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }
    }
    public static  void extuser (){
        LoginDao dao = new LoginDao();

        Login l = dao.ExtUser("brandux");
        System.out.println(l.getIdLogin());
    }
    
     public static  void validar (){
        LoginDao dao= new LoginDao();
        
         Login l = dao.validar("brandux", "1234");
         System.out.println(l.getUser());
    }
    
}
