package Controlador;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ConexionBD;
import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tika.Tika;

/**
 *
 * @author rae
 */
@MultipartConfig()
public class RegistrarProfesor extends HttpServlet {
    
    File video;
    File pdf;
    
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
        
        validar(request,response);
        response.sendRedirect("registrarProfesor.jsp");
        
        /*
        try (PrintWriter out = response.getWriter()) {
        // TODO output your page here. You may use following sample code.
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("paso1");
        //out.println(new Tika().detect(video));
        out.println(sesion.getAttribute("pdf"));
        out.println("paso2");
        out.println("</body>");
        out.println("</html>");
        
        }*/
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
    
    private void validar(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        boolean continua = true;
        
        String path_video;
        String path_pdf;
        
        String login = request.getParameter("login");
        String contraseniaUno = request.getParameter("contraseniaUno");
        String contraseniaDos = request.getParameter("contraseniaDos");
        String nombre  = request.getParameter("nombre");
        String mail  = request.getParameter("mail");
        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String nivel = request.getParameter("nivel");
        String horario = request.getParameter("horario");
        
        HttpSession sesion = request.getSession(true);
        
        sesion.setAttribute("login", login);
        sesion.setAttribute("contraseniaUno", contraseniaUno);
        sesion.setAttribute("contraseniaDos", contraseniaDos);
        sesion.setAttribute("nombre", nombre);
        sesion.setAttribute("mail", mail);
        sesion.setAttribute("dia", dia);
        sesion.setAttribute("mes", mes);
        sesion.setAttribute("nivel", nivel);
        sesion.setAttribute("horario", horario);
        
        ConexionBD conexion = new ConexionBD();
        Boolean disponible = conexion.buscaLogin(login).equals("");
        
        File video = subirVideo(request,response);
        File pdf = subirPdf(request,response);

        
        path_video = "videos/" + video.getName();
        path_pdf = "pdfs/" + pdf.getName();
        
        this.video = video;
        this.pdf = pdf;
        
        
        // Validacion del lado del servidor.
        
        continua = continua && Validacion.valida_login(login);
        continua = continua && disponible;
        continua = continua && Validacion.valida_contrasenia(contraseniaUno,contraseniaDos);
        continua = continua && Validacion.valida_nombre(nombre);
        continua = continua && Validacion.valida_mail(mail);
        continua = continua && Validacion.valida_video(video,sesion);
        continua = continua && Validacion.valida_pdf(pdf,sesion);
        
        if(continua){
            conexion.insertaProfesor(nombre,path_video,path_pdf,mail,login,contraseniaUno);
            conexion.insertaCurso(nivel,horario,"2004-"+mes+"-"+dia, conexion.regresaIdProfesor(login));
            sesion.setAttribute("identidad","profesor");
            sesion.setAttribute("init","Iniciando sesion");
            sesion.setAttribute("resultado", "exito");
        }else{
            sesion.setAttribute("resultado", "error");
            video.delete();
            pdf.delete();
        }
        
    }
    
    
    private File subirVideo(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException{
        
        String basePath = new File("").getAbsolutePath();
        String[] parts = basePath.split("/");
        final String path = "/"+parts[1]+"/"+parts[2]+"/NetBeansProjects/pag_ingles/web/videos";
        final Part filePart = request.getPart("video");
        final String fileName = getFileName(filePart);
        
        OutputStream out = null;
        InputStream filecontent = null;
        
        final File file=new File(path + File.separator+ fileName);
        
        
        try {
            out = new FileOutputStream(file);
            filecontent = filePart.getInputStream();
            
            int read = 0;
            final byte[] bytes = new byte[1024];
            
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
        } catch (FileNotFoundException fne) {
            /*
            writer.println("You either did not specify a file to upload or are "
            + "trying to upload a file to a protected or nonexistent "
            + "location.");*/
            
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        return file;
    }
    
    private File subirPdf(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException{
        
        String basePath = new File("").getAbsolutePath();
        String[] parts = basePath.split("/");
        final String path = "/"+parts[1]+"/"+parts[2]+"/NetBeansProjects/pag_ingles/web/pdfs";
        final Part filePart = request.getPart("constancia");
        final String fileName = getFileName(filePart);
        
        OutputStream out = null;
        InputStream filecontent = null;
        
        final File file = new File(path + File.separator + fileName);
        
        try {
            out = new FileOutputStream(file);
            filecontent = filePart.getInputStream();
            
            int read = 0;
            final byte[] bytes = new byte[1024];
            
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
        } catch (FileNotFoundException fne) {
            /*
            writer.println("You either did not specify a file to upload or are "
            + "trying to upload a file to a protected or nonexistent "
            + "location.");*/
            
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        
        
        return file;
    }
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
}


