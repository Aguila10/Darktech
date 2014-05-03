/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package Controlador;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.tika.Tika;

/**
 *
 * @author rae
 */
public class Validacion {
    
    public Validacion(){
    }
    
    
    public static boolean valida_login(String login){
        
        String login_pat = "^[A-Za-z0-9ñ_]+$";
        
        if(login == null){
            return false;
        }
        
        return login.matches(login_pat) && login.length() >= 4 && login.length() <= 15;
    }
    
    public static boolean valida_contrasenia(String contraseniaUno , String contraseniaDos){
        
        if(contraseniaUno == null || contraseniaDos == null){
            return false;
        }
        
        return contraseniaUno.equals(contraseniaDos) && contraseniaUno.length() >= 5 && contraseniaUno.length() <= 15;
    }
    
    public static boolean valida_nombre(String nombre){
        
        String nombre_pat = "^([A-Za-zñ])+([\\s]{1}[A-Za-zñ]+)?([\\s]{1}[A-Za-zñ]+)?$"; //Nombres de 2 hasta hasta 70
        
        if(nombre == null){
            return false;
        }
        
        return nombre.matches(nombre_pat) && nombre.length() >= 2 && nombre.length() <= 70;
    }
    
    public static boolean valida_telefono(String telefono){
        String telefono_pat = "^[0-9]+$";
        
        if(telefono == null){
            return false;
        }
        
        return telefono.matches(telefono_pat) && telefono.length() >= 8 && telefono.length() <= 15 ;
    }
    
    public static boolean valida_mail(String email){
        String mail_pat = "^[A-Za-z0-9_](\\.?[\\w-]+)*@[a-zA-Z]+(\\.[a-zA-z]+){1,2}$";
        
        if(email == null){
            return false;
        }
        
        return email.matches(mail_pat) && email.length() <= 70;
    }
    
    public static boolean valida_video(File file,HttpSession sesion) throws IOException{
        
        if(file.length() > 10485760){
            sesion.setAttribute("video","El tamaño maximo de archivo son 10 Mb");
            return false;
        }
        
        if(!(new Tika().detect(file).equals("video/mp4"))){
            sesion.setAttribute("video","Solo son aceptados archivos con formato *.mp4");
            return false;
        }
        return true;
    }
    
    public static boolean valida_pdf(File file,HttpSession sesion) throws IOException{
        
        if(file.length() > 2097152){
            sesion.setAttribute("pdf","El tamaño maximo de archivo son 2 Mb");
            return false;
        }
        if(!(new Tika().detect(file).equals("application/pdf"))){
            sesion.setAttribute("pdf","Solo son aceptados archivos con formato *.pdf");
            return false;
        }
        
        return true;
    }
    
}
