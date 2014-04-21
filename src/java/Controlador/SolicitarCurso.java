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

/**
 *
 * @author mphb
 */
@WebServlet(name = "SolicitarCurso", urlPatterns = {"/SolicitarCurso"})
public class SolicitarCurso extends HttpServlet {

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
            mandaMail(request.getParameter("curso"), request.getParameter("alumno"));
        }
    }
    
    public void mandaMail(String curso, String alumno){
        String cuerpo;
        ConexionBD con = new ConexionBD();
        String nombreAlumno = con.regresaNombreAlumno(alumno);
        String[] param = con.regresaNombreCorreoNivelHorarioProfesor(new Integer(curso).intValue());
        cuerpo = "Prof. "+param[0]+":\n"
                + "El alumno: "+nombreAlumno+" ha solicitado el curso: "
                + param[2]+" "+param[3]+"\n"+
                "Confrimar solicitud.";
        int idalumno = con.regresaIdAlumno(alumno);
        
        con.seleccionaCurso(new Integer(curso).intValue(), idalumno);
        EnviaMail nuevo = new EnviaMail(param[1], "[Solicitud_Curso Escuela de Inglés]", cuerpo);
        
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
        //processRequest(request, response);
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

}
