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
 * @author caenhiro
 */
@WebServlet(name = "MuestraCursos", urlPatterns = {"/MuestraCursos"})
public class MuestraCursos extends HttpServlet {
        
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
        mostrar_cursos(request,response);
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
        mostrar_cursos(request,response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void mostrar_cursos(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nivel = request.getParameter("nivel");
        PrintWriter out = response.getWriter();
        out.println("<h1>"+nivel+"</h1>");
        ConexionBD con = new ConexionBD();
        ArrayList lista = null;
        
        /*El boton de solicitar solo esta disponible si lo solicita un alumno*/
        HttpSession sesion = request.getSession(true);
        String alumno = "";
        String presiona = "";
        boolean boton = false;
        if(sesion.getAttribute("identidad")==null){
            presiona = "";
            boton = false;
        } else if(sesion.getAttribute("identidad").equals("alumno")){
            boton = true;
            alumno = (String)sesion.getAttribute("login");
        }
          
        if (nivel.equals("Principiante")) {
            lista =  con.ListaCursosDisponiblesPrincipiantes();
        } else{
            if(nivel.equals("Intermedio")){
                lista = con.ListaCursosDisponiblesIntermedios();
            } else {
                if (nivel.equals("Avanzado")){
                    lista = con.ListaCursosDisponiblesAvanzados();
                } else {
                    if (nivel.equals("Conversaci\u00f3n")){
                        lista = con.ListaCursosDisponiblesConversacion();
                    }
                }
            }
        }
           
        if (lista.size()%3 == 0 ){
            for (int i = 0 ; i < (lista.size()/3); i++){
                out.println(" <div class='row'> " );
                
                for (int j =0; j < 3 ; j++) {
                    Curso cur = (Curso)lista.get(3*i + j);
                    if(boton){presiona="<center><button onclick= \"solicita('"+cur.getIdcurso()+"','"+alumno+"')\" >Solicitar</button>";
                    }else{
                        presiona ="";
                    }
                    out.println( "<div class="+"col-md-4 "+"id ="+cur.getIdcurso()+"><center><h5>Nombre Profesor:<br> <a href=\"#popupCuatro\" class=\"fancyBox\" onclick='showVideo("+cur.getIdcurso()+")'>"+cur.getProfesor()+"</a><br>"+
                            "Horario:<br> "+cur.getHora()+ "</h5><center><br>"
                            +presiona+"</div></center>");
                }
                out.println("</div>");
            }
        }    else{
            for (int i = 0 ; i < (lista.size()/3); i++){
                out.println(" <div class='row'> " );
                
                for (int j =0; j < 3 ; j++) {
                    Curso cur = (Curso)lista.get(3*i + j);
                    
                    if(boton){presiona="<center><button onclick= \"solicita('"+cur.getIdcurso()+"','"+alumno+"')\" >Solicitar</button>";
                    }else{
                        presiona ="";
                    }
                    out.println( "<div class="+"col-md-4 "+"id ="+cur.getIdcurso()+"><center><h5>Nombre Profesor:<br> <a href=\"#popupCuatro\" class=\"fancyBox\" onclick='showVideo("+cur.getIdcurso()+")'>"+cur.getProfesor()+"</a><br>"+
                            "Horario:<br> "+cur.getHora()+ "</h5><center><br>"
                            +presiona+"</div></center>");
                }
                out.println("</div>");
            }
            
            out.println(" <div class='row'> " );
            
            for (int j =0; j < lista.size()%3 ; j++) {
                Curso cur = (Curso)lista.get(3*(lista.size()/3) + j);
               if(boton){presiona="<center><button onclick= \"solicita('"+cur.getIdcurso()+"','"+alumno+"')\" >Solicitar</button>";
                    }else{
                        presiona ="";
                    }
                    out.println( "<div class="+"col-md-4 "+"id ="+cur.getIdcurso()+"><center><h5>Nombre Profesor:<br> <a href=\"#popupCuatro\" class=\"fancyBox\" onclick='showVideo("+cur.getIdcurso()+")'>"+cur.getProfesor()+"</a><br>"+
                            "Horario:<br> "+cur.getHora()+ "</h5><center><br>"
                            +presiona+"</div></center>");
            }
            out.println("</div>");
        }
    }
    
}