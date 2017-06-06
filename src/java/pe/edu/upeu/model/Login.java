/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.model;

/**
 *
 * @author UPEU
 */
public class Login {
    
    private int idLogin ;
    private String user ;
    private String pass;
    private int estado;
    private int contador;

    public Login() {
    }

    public Login(String user, String pass, int estado, int contador) {
        this.user = user;
        this.pass = pass;
        this.estado = estado;
        this.contador = contador;
    }

    public Login(int idLogin, String user, String pass, int estado, int contador) {
        this.idLogin = idLogin;
        this.user = user;
        this.pass = pass;
        this.estado = estado;
        this.contador = contador;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    
}
