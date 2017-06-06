/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upeu.dao.LoginDao;
import pe.edu.upeu.model.Login;

/**
 *
 * @author UPEU
 */
@Controller
public class HomeController {
    private LoginDao dao = new LoginDao();
    
    
    @RequestMapping("/home")
    public String home(){
        return "Login";
    }
    
    @RequestMapping("/logueo")
    public String Principal(Model mo, HttpServletRequest resquest, HttpServletResponse response) {
        String url = "index";
        String user = resquest.getParameter("user");
        String Pass = resquest.getParameter("pass");
        HttpSession sesion = resquest.getSession();
        Login c = new Login();
        c = dao.ExtUser(user);
        try {
            //comprovamos que existe
            if (c != null ) {
                //Comprovamos si sus intentos son menores que 3
                if(c.getContador() < 3 && c.getEstado() != 0 ){
                    //si su clave y estado es correcto ingresa
                    if(c.getPass().equals(Pass) && c.getEstado() == 1){
                        resquest.getSession().setAttribute("Persona", c);
                        dao.Reiniciar(c.getIdLogin());
                        url = "Entro";
                        //ahora si su calve es diferente actualizamos 
                    }else if (!c.getPass().equals(Pass) ) {
                          dao.ActConta(c.getIdLogin(), c.getContador());
                          url = "Login";
                          }
                }else{
                    //ahora si su contador es mayor o igual que 3 bloqueamos el usaurio
                    dao.Bloquear(c.getIdLogin());
                    url = "Bloquear";
                }
            }else {
                url = "Registrate";
            }
        } catch (Exception e) {
        }
        return url;
    }
    //Para Crear
    
    
    //Esta parte para cerrar sesion e invalidar el acceso
    @RequestMapping("/cerrar")
    private String Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "Login";

        HttpSession session = request.getSession();
        session.invalidate();
        return url;
    }

}
