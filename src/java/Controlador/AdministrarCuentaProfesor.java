/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package Controlador;

import Modelo.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rae
 */
@WebServlet(name = "AdministrarCuentaProfesor", urlPatterns = {"/AdministrarCuentaProfesor"})
public class AdministrarCuentaProfesor extends HttpServlet {
    
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
        
        String identificador = request.getParameter("identificador");
        ConexionBD conexion = new ConexionBD();
        HttpSession sesion = request.getSession(true);
        
        if(identificador.equals("datos")){
            String nombre  = request.getParameter("nombre");
            String mail  = request.getParameter("mail");
            
            continua = continua && Validacion.valida_nombre(nombre);
            continua = continua && Validacion.valida_mail(mail);
            
            if(continua){
                conexion.actualizaDatosProfesor(conexion.regresaIdProfesor((String)sesion.getAttribute("login")), nombre, mail);
                
                sesion.setAttribute("nombre",nombre);
                sesion.setAttribute("mail",mail);
                
                return "exito";
            }else{
                return "error";
            }
            
        }else{ // identificador == "contrasenia"
            String contraseniaCero = request.getParameter("contraseniaCero");
            String contraseniaUno = request.getParameter("contraseniaUno");
            String contraseniaDos = request.getParameter("contraseniaDos");
            
            continua = Validacion.valida_contrasenia(contraseniaUno,contraseniaDos);
            
            if(continua){
                conexion.actualizaContraseñaProfesor(conexion.regresaIdProfesor((String)sesion.getAttribute("login")),contraseniaUno);
                return "exito";
            }else{
                return "error";
            }
            
        }
        
        
    }
    
}
