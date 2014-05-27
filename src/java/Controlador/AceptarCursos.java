/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mphb
 */
@WebServlet(name = "AceptarCursos", urlPatterns = {"/AceptarCursos"})
public class AceptarCursos extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AceptarCursos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AceptarCursos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
    String driver = "org.postgresql.Driver";
    String connectString = "jdbc:postgresql://localhost:5433/pag_ingles";
    String user = "postgres";
    String password = "308264113";
        ConexionBD bd = new ConexionBD();
Statement statement;
        ResultSet resultSet;
        // curso
        int idCurso = new Integer(request.getParameter("id")).intValue();
        // alumno
        int idAlumno = bd.regresaAlumnoSolicitoCurso(idCurso);
        
        // acepto el curso
        if("true".equals(request.getParameter("acepto"))){
        try {
            bd.asignaCurso(idCurso, idAlumno);
            
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery(" update curso set  "
                    + "estado = 'Asignado' where idcurso="+ idCurso+";");
            // rechazo el curso    
        } catch (SQLException ex) {
            Logger.getLogger(AceptarCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        else {
            bd.rechazaCurso(idCurso, idAlumno);
        }
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
