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
@WebServlet(name = "MuestraAceptarCursos", urlPatterns = {"/MuestraAceptarCursos"})
public class MuestraAceptarCursos extends HttpServlet {

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
//            out.println("<title>Servlet MuestraAceptarCursos</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MuestraAceptarCursos at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        muestra_aceptarCursos(request, response);
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
    
    private void muestra_aceptarCursos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        out.println("<h1>Aceptar Cursos</h1>");
        
        /*Obtener login profesor*/
        HttpSession sesion = request.getSession(true);
        String login = (String)sesion.getAttribute("login");
        /*Pedir consulta segun login del profesor*/
        ConexionBD con = new ConexionBD();
        ArrayList<Curso> lista=con.CursosProfesorPendiente(login);
       
        /*Imprimir lista de cursos pendientes por aceptar*/
         if (lista.size()%3 == 0 ){
            for (int i = 0 ; i < (lista.size()/3); i++){
                out.println(" <div class='row'> " );
                
                for (int j =0; j < 3 ; j++) {
                    Curso cur = (Curso)lista.get(3*i + j);
                    
                    out.println( "<div class='col-md-4'>"
                            +"Nivel:"+cur.getNivel() +"<br>"
                            +"Horario:"+cur.getHora() +"<br>"
                            +"Alumno:"+cur.getAlumno() +"<br>"
                            + "<button onclick='aceptoCurso("+cur.getIdcurso()+")'>Aceptar</button>"
                            + "<button onclick='rechazoCurso("+cur.getIdcurso()+")'>Rechazar</button>"
                            + "</div> ");
                }
                out.println("</div>");
            }
        }    else{
            for (int i = 0 ; i < (lista.size()/3); i++){
                out.println(" <div class='row'> " );
                
                for (int j =0; j < 3 ; j++) {
                    Curso cur = (Curso)lista.get(3*i + j);
                    
                    out.println( "<div class='col-md-4'>"
                            +"Nivel:"+cur.getNivel() +"<br>"
                            +"Horario:"+cur.getHora() +"<br>"
                            +"Alumno:"+cur.getAlumno() +"<br>"
                            + "<button onclick='aceptoCurso("+cur.getIdcurso()+")'>Aceptar</button>"
                            + "<button onclick='rechazoCurso("+cur.getIdcurso()+")'>Rechazar</button>"
                            + "</div> ");
                }
                out.println("</div>");
            }
            
            out.println(" <div class='row'> " );
            
            for (int j =0; j < lista.size()%3 ; j++) {
                Curso cur = (Curso)lista.get(3*(lista.size()/3) + j);
                
                out.println( "<div class='col-md-4'>"
                            +"Nivel:"+cur.getNivel() +"<br>"
                            +"Horario:"+cur.getHora() +"<br>"
                            +"Alumno:"+cur.getAlumno() +"<br>"
                            + "<button onclick='aceptoCurso("+cur.getIdcurso()+")'>Aceptar</button>"
                            + "<button onclick='rechazoCurso("+cur.getIdcurso()+")'>Rechazar</button>"
                            + "</div> ");
            }
            out.println("</div>");
    }  
  }

}
