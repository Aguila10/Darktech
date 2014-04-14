/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ConexionBD;

/**
 *
 * @author rae
 */
public class RegistrarAlumno extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            /*
            out.println("login " + sesion.getAttribute("login"));
            out.println("contrasenia " + sesion.getAttribute("contrasenia"));    // Codigo utiliazado para pruebas
            out.println("nombre " + sesion.getAttribute("nombre"));
            out.println("telefono " + sesion.getAttribute("telefono"));
            out.println("mail " + sesion.getAttribute("mail"));
            */
            
            out.println(validar(request,response));
            
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public String validar(HttpServletRequest request,HttpServletResponse response){
        
        boolean continua = true;
        String login = request.getParameter("login");
        String contraseniaUno = request.getParameter("contraseniaUno");
        String contraseniaDos = request.getParameter("contraseniaDos");
        String nombre  = request.getParameter("nombre");
        String telefono  = request.getParameter("telefono");
        String mail  = request.getParameter("mail");
            
        ConexionBD conexion = new ConexionBD();
        Boolean disponible = conexion.buscaLogin(login).equals("");
        
        // Validacion del lado del servidor.
          
        continua = continua && Validacion.valida_login(login);
        continua = continua && disponible;
        continua = continua && Validacion.valida_contrasenia(contraseniaUno,contraseniaDos);
        continua = continua && Validacion.valida_nombre(nombre);
        continua = continua && Validacion.valida_telefono(telefono);
        continua = continua && Validacion.valida_mail(mail);
        
        if(continua){    
            conexion.insertaAlumno(nombre, telefono, mail, login, contraseniaUno);
            return "El registro fue exitoso";
        }else{
            return "error";
        }

    }
    
    
}
