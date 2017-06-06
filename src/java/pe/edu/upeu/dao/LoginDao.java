/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.edu.upeu.interfaces.Operaciones;
import pe.edu.upeu.model.Login;
import pe.edu.upeu.util.conexion;

/**
 *
 * @author UPEU
 */
public class LoginDao implements Operaciones<Login>{

    private static ResultSet rs;
    private static PreparedStatement ps;
    private static Connection cx;


    
    private static String sql_crear = "INSERT INTO login (user, pass, estado, contador) VALUES (? , ? ,  1 , 0)";
    private static String sql_editar = "";
    private static String sql_eliminar = "DELETE FROM PERSONA WHERE idPersona =? ";
    private static String sql_listar = "SELECT * FROM PERSONA";
    
    //para comprovar que el usuario existe ;
    public Login ExtUser (String user){
        Login l = null;
        try {
            cx = conexion.getCoxeion();
            String sql = "SELECT * FROM LOGIN WHERE USER = '"+ user +"' ";
            ps = cx.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                l = new Login();
                l.setIdLogin(rs.getInt("idLogin"));
                l.setUser(rs.getString("user"));
                l.setPass(rs.getString("pass"));
                l.setEstado(rs.getInt("estado"));
                l.setContador(rs.getInt("contador"));
            }
        } catch (SQLException e) {
            System.out.println("Error en ExtUser");
        }
        return l;
    }
    
    
    //validamos el iusuario para su logueo 
    public Login validar (String user , String pass){
        Login  x = null;
        try {
            cx = conexion.getCoxeion();
            String sql = "SELECT * FROM LOGIN WHERE USER = '"+user+"' AND PASS='"+ pass+"'";
            ps = cx.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                x = new Login();
                x.setIdLogin(rs.getInt("idLogin"));
                x.setUser(rs.getString("user"));
                x.setPass(rs.getString("pass"));
                x.setEstado(rs.getInt("estado"));
                x.setContador(rs.getInt("contador"));
            }
        } catch (SQLException e) {
            System.out.println("Error en ExtUser");
        }
        return x;
    }
    
    //para actualizar el contador
    public int ActConta(int id , int conta){
        int  op =0 ;
        try {
            cx = conexion.getCoxeion();
            String sql = "UPDATE login SET contador= "+ conta +"  + 1 WHERE idLogin= "+id+"";
            ps = cx.prepareStatement(sql);
            op = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizar conta (actconta):" + e);
        }
        return  op;
    }
    
    public int Bloquear(int id ){
        int  op =0 ;
        try {
            cx = conexion.getCoxeion();
            String sql = "UPDATE login SET estado= 0 WHERE idLogin= '"+ id +"' ";
            ps = cx.prepareStatement(sql);
            op = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizar conta (actconta):" + e);
        }
     
        return  op;
    }
    
 //esto hace que cuando se loguee correctamente el contador se reinicia
    public int Reiniciar(int id) {
        int op = 0;
        try {
            cx = conexion.getCoxeion();
            String sql = "UPDATE login SET contador = 0  WHERE idLogin ='"+id+"'";
            ps = cx.prepareStatement(sql);
            op = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizar conta (actconta):" + e);
        }

        return op;
    }
    
    @Override
    public int crear(Login e) {
        int op = 0;
        try {
            cx = conexion.getCoxeion();
            ps = cx.prepareStatement(sql_crear);
            ps.setString(1, e.getUser());
            ps.setString(2, e.getPass());
            op = ps.executeUpdate();

        } catch (SQLException x) {
            System.out.println("error en crear:" + e);

        }
        return op;
    
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editar(Login e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Login> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Login> buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
