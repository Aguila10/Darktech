/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ConexionBD;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "GeneraConstancia", urlPatterns = {"/GeneraConstancia"})
public class GeneraConstancia extends HttpServlet {

    String nombre_arch;
    
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
        String basePath = new File("").getAbsolutePath();
        String[] parts = basePath.split("/");
        final String path = "/"+parts[1]+"/"+parts[2]+"/NetBeansProjects/pag_ingles/constancia.pdf";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Constancia</title>");            
            out.println("</head>");
            out.println("<body marginwidth=\"0\" marginheight=\"0\" style=\"background-color: rgb(38,38,38)\" screen_capture_injected=\"true\">");
            out.println("<embed width=\"1300\" height=\"655\" name=\"plugin\" src=\" constancia.pdf\" type=\"application/pdf\">");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"chrome-extension://cpngackimfmofbokmjmljamhdncknpmg/style.css\">");
            out.println("<script type=\"text/javascript\" charset=\"utf-8\" src=\"chrome-extension://cpngackimfmofbokmjmljamhdncknpmg/js/page_context.js\"></script>");
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
       
        HttpSession sesion = request.getSession(true);
        
        String alumno = (String)sesion.getAttribute("login");
        int idCurso = new Integer(request.getParameter("id")).intValue();
        
        ConexionBD con = new ConexionBD();
        String[] arr = con.regresaDatosAlumno(alumno);
    String nombre = arr[0];
        System.out.println(nombre);
    PDF constancia = new PDF(); 
        try {
           String nombre_arch; 
            nombre_arch = constancia.escribePDF(nombre);
            this.nombre_arch = nombre_arch;
            
        } catch (DocumentException ex) {
            Logger.getLogger(GeneraConstancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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