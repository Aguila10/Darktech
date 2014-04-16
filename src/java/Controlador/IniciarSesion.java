
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ConexionBD;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rae
 */
public class IniciarSesion extends HttpServlet {
    
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
            out.println(revisaSesion(request,response));
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
    
    
    private String revisaSesion(HttpServletRequest request, HttpServletResponse response){
        
        String login = request.getParameter("login") ;
        String contrasenia = request.getParameter("contrasenia");
        ConexionBD conexion = new ConexionBD();
        String[] atributos;
        
        HttpSession sesion = request.getSession(true);
        
        if(conexion.iniciaSesion(login, contrasenia)){
            
            if(conexion.regresaIdAlumno(login) != 0){
                atributos = conexion.regresaDatosAlumno(login);
                sesion.setAttribute("identidad","alumno");
                sesion.setAttribute("login",login);
                sesion.setAttribute("nombre", atributos[0]);
                sesion.setAttribute("telefono", atributos[1]);
                sesion.setAttribute("mail", atributos[2]);
            }else{
                atributos = conexion.regresaDatosProfesor(login);
                sesion.setAttribute("identidad","profesor");
                sesion.setAttribute("login",login);
                sesion.setAttribute("nombre", atributos[0]);
                sesion.setAttribute("mail", atributos[1]);
                sesion.setAttribute("video", atributos[2]);
            }
        }else{
            return "error";
        }
        return"logueado";
    }
}
