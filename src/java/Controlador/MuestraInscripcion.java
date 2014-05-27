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
@WebServlet(name = "MuestraInscripcion", urlPatterns = {"/MuestraInscripcion"})
public class MuestraInscripcion extends HttpServlet {

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
//            out.println("<title>Servlet MuestraInscripcion</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MuestraInscripcion at " + request.getContextPath() + "</h1>");
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
        muestraInscripcion(request, response);
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

    private void muestraInscripcion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        out.println("<h1>Cursos inscritos:</h1>");
        
         /*Obtener login alumno*/
        HttpSession sesion = request.getSession(true);
        String login = (String)sesion.getAttribute("login");
        /*Pedir consulta segun login del alumno*/
        ConexionBD con = new ConexionBD();
        ArrayList<Curso> lista = con.CursosAlumnoEnCurso(login);
        
        /*Imprimir lista de cursos en los que esta inscrito el alumno*/
        out.println("<table>");
        
        out.println("<tr><td><center><h3>Curso</h3></center></td><td>"
                + "<center><h3>Horario</h3></center></td></tr>");
        
        for(int i=0; i<lista.size(); i++){
            Curso cur = lista.get(i);
            out.println("<tr>");
            out.println("<td><p>Nivel: "+cur.getNivel()
                        +"<br>Profesor: "+cur.getProfesor()+"</p></td>"
                        +"<td><p><center>"+cur.getHora()+"</td>");
            out.println("</center></p></tr>");
        }
        out.println("</table>");
    }
}
