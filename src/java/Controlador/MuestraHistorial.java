/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mphb
 */
@WebServlet(name = "MuestraHistorial", urlPatterns = {"/MuestraHistorial"})
public class MuestraHistorial extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet MuestraHistorial</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MuestraHistorial at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        muestraHistorial(request, response);
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

    
    private void muestraHistorial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        out.println("<h1>Historial</h1>");
        
        /*Obtener login alumno*/
        HttpSession sesion = request.getSession(true);
        String login = (String)sesion.getAttribute("login");
        /*Pedir consulta segun login del alumno*/
        ConexionBD con = new ConexionBD();
        ArrayList<Curso> lista = con.CursosAlumnoFinalizados(login);
        
        /*Imprimir lista de cursos en los que esta inscrito el alumno*/
        out.println("<table>");
        out.println("<tr><td>Curso</td><td>Calificación</td><td>Constancia</td></tr>");
        
        for(int i=0; i<lista.size(); i++){
            Curso cur = lista.get(i);
            out.println("<tr>");
            out.println("<td>Nivel: "+cur.getNivel()+"<br>Profesor:"+cur.getProfesor()+"</td>"
                       +"<td>"+cur.getCalifi()+"</td>");
            /*Da una liga de constancia solo si la calificacion es mayor igual a 8*/
            if(cur.getCalifi()>=8){
                out.println("<td><a onclick='generaConstancia("+cur.getIdcurso()+")'>Constancia</a></td>");
            }
            out.println("</tr>");
            
        }
        
        out.println("</table>");
    }
}
