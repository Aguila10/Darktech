/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package Controlador;

import javax.servlet.http.HttpSession;

/**
 *
 * @author rae
 */
public class Validacion {
    
    HttpSession sesion;
    
    public Validacion(){
    }
    
    
    public static boolean valida_login(String login){    
        String login_pat = "^[A-Za-z0-9]+$";
        return login.matches(login_pat) && login.length() >= 4 && login.length() <= 15;
    }
    
    public static boolean valida_contrasenia(String contraseniaUno , String contraseniaDos){
        return contraseniaUno.equals(contraseniaDos) && contraseniaUno.length() >= 5 && contraseniaUno.length() <= 15;
    }
   
    public static boolean valida_nombre(String nombre){     
        String nombre_pat = "^([A-Za-z])+([\\s]{1}[A-Za-z]+)?([\\s]{1}[A-Za-z]+)?$"; //Nombres de 2 hasta hasta 70   
        return nombre.matches(nombre_pat) && nombre.length() >= 2 && nombre.length() <= 70;
    }
    
    public static boolean valida_telefono(String telefono){   
        String telefono_pat = "^[0-9]+$";
        return telefono.matches(telefono_pat);// && telefono.length() >= 8 && telefono.length() <= 15 ;
    }
    
    public static boolean valida_mail(String email){
        String mail_pat = "^[A-Za-z](\\.?[\\w-]+)*@[a-zA-Z]+(\\.[a-zA-z]+){1,2}$";
        return email.matches(mail_pat) && email.length() <= 70;
    }
    
    
}
