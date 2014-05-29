package Modelo;

import Controlador.Curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
 *
 * @author daemoncc
 */
public class ConexionBD{
    
    String driver = "org.postgresql.Driver";
    String connectString = "jdbc:postgresql://localhost:5433/EscuelaDeIngles";
    String user = "postgres";
    String password = "308264113";
    
    
    /**
     * Metodo que regresa el el login pedido
     *
     * @param login parametro a buscar en la tabla registro
     * @return el login si lo encontro
     */
    public String buscaLogin(String login) {
        String res = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select * from registro where loggin =?");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                res = (rset.getString(3));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    
    
    /**
     * Metodo que inserta un curso
     *
     * @param nivel del curso
     * @param horario del curso
     * @param fecha del curso
     * @param idprofesor del curso
     * @return resultado de la funcion
     */
    public boolean insertaCurso(String nivel, String horario, String fecha, Integer idprofesor) {
        boolean res=false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  agregaCurso('" + nivel + "', "
                    + "'" + horario + "','" + fecha + "'," + idprofesor + ");");
            
            while (resultSet.next()) {
                System.out.println(res);
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    /**
     * Metodo que nos imprime el nombre y correo electronico de todos los
     * profesores en la tabla
     */
    public void ListaProfesores() {
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select * from profesor");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {
                
                cad = ("Nombre del profesor " + rset.getString(2) + " , "
                        + "  Correo electronico " + rset.getString(5));
            }
            System.out.println(cad);
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    /**
     * Metodo que inserta un profesor
     *
     * @param nombre profesor
     * @param liga_video del profesor
     * @param liga_constancia del profesor
     * @param correo_electronico del profesor
     * @param login del profesor
     * @param contrasenia del profesor
     * @return String el resultado de la funci贸n
     */
    public boolean insertaProfesor(String nombre, String liga_video,
            String liga_constancia, String correo_electronico, String login, String contrasenia) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from agregaProfesor('" + nombre
                    + "','" + liga_video + "','" + liga_constancia + "','" + correo_electronico + "'"
                    + ",'" + login + "','" + contrasenia + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    /**
     * Metodo que insert aun alumno
     *
     * @param nombre del alumno
     * @param telefono del alumno
     * @param correo_electronico del alumno
     * @param login del alumno
     * @param contrasenia del alumno
     * @return el resultado de la funcion
     */
    
    public boolean insertaAlumno(String nombre, String telefono,
            String correo_electronico, String login, String contrasenia) {
        boolean res = true;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  agregaAlumno('" + nombre
                    + "','" + telefono + "','" + correo_electronico + "','" + login + "'"
                    + ",'" + contrasenia + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    
    /**
     * Metodo que regresa el idalumno dado su login
     *
     * @param login del alumno
     * @return 0 si no existe o el idalumno
     */
    public int regresaIdAlumno(String login) {
        int res = 0;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select alumno.idalumno from alumno join "
                    + "registro on registro.idalumno = alumno.idalumno where registro.loggin =?");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                
                res = (rset.getInt(1));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    
    /**
     * metodo que regresa el idprofesor dado un nombre
     *
     * @param login del profesor
     * @return o si no existe o el idprofesor
     */
    public int regresaIdProfesor(String login) {
        int res = 0;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select registro.idprofesor from profesor join"
                    + " registro on registro.idprofesor = profesor.idprofesor where registro.loggin=? ");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                
                res = (rset.getInt(1));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    /**
     *
     * @param idalumno
     * @param nombre
     * @param telefono
     * @param correo
     * @param contrasenia
     * @return
     */
    public boolean actualizaAlumno(int idalumno, String nombre, String telefono ,String correo, String contrasenia) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualizaAlumno(" + idalumno + ", "
                    + "'" + nombre + "','" + telefono + "','" + correo + "','" + contrasenia + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    /**
     *
     * @param idprofesor
     * @param nombre
     * @param correo
     * @param contrasenia
     * @return
     */
    public boolean actualizaProfesor(int idprofesor, String nombre, String correo, String contrasenia) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualizaProfesor(" + idprofesor + ", "
                    + "'" + nombre + "','" + correo + "','" + contrasenia + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    /**
     *
     * @param idcurso
     * @param idalumno
     * @return
     */
    public boolean seleccionaCurso(int idcurso,int idalumno) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  seleccionaCurso(" + idcurso + "," + idalumno + ");");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    public int regresaAlumnoSolicitoCurso(int idCurso){
        Statement statement;
        ResultSet resultSet;
        int res=0;
        
        Connection con;
        try {
            con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT idalumno from historial_curso where idcurso="+idCurso+";");
            
            while (resultSet.next()) {
                res = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     return res;
    }
    
    /**
     *
     * @param idcurso
     * @param idalumno
     * @return
     */
    public boolean asignaCurso(int idcurso,int idalumno) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  asignaCurso(" + idcurso + "," + idalumno + ");");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    /**
     *
     * @param idcurso
     * @param idalumno
     * @return
     */
    public boolean rechazaCurso(int idcurso,int idalumno) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  rechazaCurso(" + idcurso + "," + idalumno + ");");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    /**
     *
     * @param idcurso
     * @param calificacion
     * @return
     */
    public boolean asignaCalificacion(int idcurso,double calificacion ) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  asignaCalificacion(" + idcurso + "," + calificacion + ");");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    // hacer que regresen arrglos
    
    /**
     * Metodo que nos regresa el id profesor idcurso nombre del profesor horario de
     * todos los cursos que siguen disponibles
     */
    public void ListaCursosDisponibles() {
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.idprofesor,"
                    + " profesor_disponible.idcurso, profesor.nombre, curso.horario , curso.fecha_apertura from "
                    + "profesor_disponible join profesor on profesor.idprofesor = profesor_disponible.idprofesor join "
                    + "curso on profesor_disponible.idcurso = curso.idcurso ;");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {
                cad = ("Id profesor " + rset.getInt(1) + " , "
                        + "Id curso " + rset.getInt(2) + " , "
                        + "Nombre del profesor " + rset.getString(3)
                        + "Horario " + rset.getString(4)
                        + "Fecha inicio " + rset.getString(5));
                System.out.println(cad);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     */
    public ArrayList<Curso> ListaCursosDisponiblesPrincipiantes() {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.idprofesor,"
                    + " profesor_disponible.idcurso, profesor.nombre, curso.horario , curso.fecha_apertura ,"
                    + "curso.nivel from profesor_disponible join profesor on profesor.idprofesor = profesor_disponible.idprofesor join "
                    + "curso on profesor_disponible.idcurso = curso.idcurso "
                    + "where curso.nivel = 'Principiante' and curso.estado = 'Disponible'  ;");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {
                cad = ("Id profesor " + rset.getInt(1) + " , "
                        + "Id curso " + rset.getInt(2) + " , "
                        + "Nombre del profesor " + rset.getString(3)
                        + "Horario " + rset.getString(4)
                        + "Fecha inicio " + rset.getString(5)
                        + "Nivel " + rset.getString(6));
                
                Curso curso = new Curso(rset.getInt(1),rset.getInt(2),rset.getString(3),
                        rset.getString(4),rset.getString(5),rset.getString(6));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    /**
     *
     */
    public ArrayList<Curso> ListaCursosDisponiblesIntermedios() {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.idprofesor,"
                    + " profesor_disponible.idcurso, profesor.nombre, curso.horario , curso.fecha_apertura , curso.nivel from "
                    + "profesor_disponible join profesor on profesor.idprofesor = profesor_disponible.idprofesor join "
                    + "curso on profesor_disponible.idcurso = curso.idcurso where curso.nivel = 'Intermedio' and curso.estado = 'Disponible' ;");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {
                cad = ("Id profesor " + rset.getInt(1) + " , "
                        + "Id curso " + rset.getInt(2) + " , "
                        + "Nombre del profesor " + rset.getString(3)
                        + "Horario " + rset.getString(4)
                        + "Fecha inicio " + rset.getString(5)
                        + "Nivel" +  rset.getString(6));
                
                Curso curso = new Curso(rset.getInt(1),rset.getInt(2),rset.getString(3),
                        rset.getString(4),rset.getString(5),rset.getString(6));
                
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    /**
     *
     */
    public ArrayList<Curso> ListaCursosDisponiblesAvanzados() {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.idprofesor,"
                    + " profesor_disponible.idcurso, profesor.nombre, curso.horario , curso.fecha_apertura , curso.nivel from "
                    + "profesor_disponible join profesor on profesor.idprofesor = profesor_disponible.idprofesor join "
                    + "curso on profesor_disponible.idcurso = curso.idcurso "
                    + "where curso.nivel = 'Avanzado' and curso.estado = 'Disponible' ;");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {
                cad = ("Id profesor " + rset.getInt(1) + " , "
                        + "Id curso " + rset.getInt(2) + " , "
                        + "Nombre del profesor " + rset.getString(3)
                        + "Horario " + rset.getString(4)
                        + "Fecha inicio " + rset.getString(5)
                        + "nivel " +  rset.getString(6));
                
                Curso curso = new Curso(rset.getInt(1),rset.getInt(2),rset.getString(3),
                        rset.getString(4),rset.getString(5),rset.getString(6));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    /**
     *
     */
    public ArrayList<Curso> ListaCursosDisponiblesConversacion() {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.idprofesor, profesor_disponible.idcurso, "
                    + "profesor.nombre, curso.horario , curso.fecha_apertura , curso.nivel from profesor_disponible join profesor on profesor.idprofesor = profesor_disponible.idprofesor join "
                    + "curso on profesor_disponible.idcurso = curso.idcurso where curso.nivel = 'Conversación' and curso.estado = 'Disponible' ;");
            ResultSet rset = query.executeQuery();
            String cad = "";
            
            while (rset.next()) {
                cad = ("Id profesor " + rset.getInt(1) + " , "
                        + "Id curso " + rset.getInt(2) + " , "
                        + "Nombre del profesor " + rset.getString(3)
                        + "Horario " + rset.getString(4)
                        + "Fecha inicio " + rset.getString(5)
                        + "Nivel " + rset.getString(6));
                Curso curso = new Curso(rset.getInt(1),rset.getInt(2),rset.getString(3),
                        rset.getString(4),rset.getString(5),rset.getString(6));
                lista.add(curso);
            }
            
            
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return lista;
    }
    // hasta qui regresar arrglos
    
    /**
     *
     * @param login
     * @return
     */
    public String regresaLigaVIdeoProfesor(String login) {
        String res = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.liga_video from profesor join"
                    + " registro on registro.idprofesor = profesor.idprofesor where registro.loggin=? ");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                
                res = (rset.getString(1));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    /**
     *
     * @param idcurso
     * @param calificacion
     * @return
     */
    public boolean iniciaSesion(String login , String contrasenia ) {
        boolean res = false;
        
        int res1 =0;
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            
            PreparedStatement query = con.prepareStatement("SELECT count(*) from  registro where "
                    + "loggin =? and contrasenia =?");
            query.setString(1, login);
            query.setString(2, contrasenia);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                res1 = rset.getInt(1);
            }
            if (res1 == 1) {
                res = true;
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    public String[] regresaDatosProfesor(String login) {
        String[] arreglo = new String[2];
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.nombre, profesor.correo_electronico "
                    + "from profesor join registro on profesor.idprofesor = registro.idprofesor where registro.loggin=?;");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            
            while (rset.next()) {
                
                arreglo[0]=rset.getString(1);
                arreglo[1]=rset.getString(2);
                
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return arreglo;
    }
    
    public String[] regresaDatosAlumno(String login) {
        String[] arreglo = new String[3];
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select alumno.nombre, alumno.telefono, "
                    + "alumno.correo_electronico from alumno join registro on"
                    + " alumno.idalumno = registro.idalumno where registro.loggin=?;");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            
            while (rset.next()) {
                
                arreglo[0]=rset.getString(1);
                arreglo[1]=rset.getString(2);
                arreglo[2]=rset.getString(3);
                
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return arreglo;
    }
    
    public boolean actualizaDatosAlumno(int idalumno, String nombre, String telefono ,String correo) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualizaAlumno1(" + idalumno + ", "
                    + "'" + nombre + "','" + telefono + "','" + correo + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    
    
    public boolean actualizaContraseñaAlumno(int idalumno, String contrasenia) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualizaAlumno2(" + idalumno + ", '" + contrasenia + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    public boolean actualizaDatosProfesor(int idprofesor, String nombre, String correo) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualizaProfesor1(" + idprofesor + ", "
                    + "'" + nombre + "','" + correo + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    
    public boolean actualizaContraseñaProfesor(int idprofesor, String contrasenia) {
        boolean res = false;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualizaProfesor2(" + idprofesor + ", '" + contrasenia + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    
    
    
    public String regresaNombreAlumno(String login) {
        String res = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select alumno.nombre from alumno join "
                    + "registro on registro.idalumno = alumno.idalumno where registro.loggin =?");
            query.setString(1, login);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                
                res = (rset.getString(1));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    
    public String[] regresaNombreCorreoNivelHorarioProfesor(int idcurso) {
        String[] res = new String[4];
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.nombre , profesor.correo_electronico , "
                    + "curso.horario , curso.nivel from profesor join registro on registro.idprofesor = profesor.idprofesor "
                    + "join curso on curso.idprofesor = profesor.idprofesor where curso.idcurso =?");
            
            query.setInt(1, idcurso);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                res[0] = rset.getString(1);
                res[1] =rset.getString(2);
                res[2] = rset.getString(3);
                res[3] = rset.getString(4);
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    
    public boolean eliminaAlumno(String login) {
        boolean res = true;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from eliminaalumno('" + login + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
    
    
    
    public boolean eliminaProfesor(String login) {
        boolean res = true;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from eliminaprofesor('" + login + "');");
            
            while (resultSet.next()) {
                res = resultSet.getBoolean(1);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    /**
     *
     * @param idcurso
     * @return
     */
    public String regresaLigaVIdeoProfesor(int idcurso) {
        String res = "";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.liga_video from"
                    + " profesor join curso on curso.idprofesor = profesor.idprofesor where curso.idcurso =? ");
            query.setInt(1, idcurso);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                
                res = (rset.getString(1));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public ArrayList<Curso> CursosProfesor(String loggin) {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
             PreparedStatement query = con.prepareStatement("select curso.idcurso,curso.horario , curso.nivel , alumno.nombre from curso join profesor on\n" +
"curso.idprofesor = profesor.idprofesor join registro on registro.idprofesor = profesor.idprofesor\n" +
"join alumno_inscrito on alumno_inscrito.idcurso = curso.idcurso join alumno on alumno_inscrito.idalumno = alumno.idalumno  \n" +
"             where registro.loggin = ?");
            
            query.setString(1, loggin);
            String cad = "";
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                cad = (  "Curso" + rset.getInt(1)
                        +"Horario " + rset.getString(2)
                        + "Nivel " + rset.getString(3)
                        +"Nombre Alumno" + rset.getString(4));
                
                Curso curso = new Curso(1,rset.getInt(1),"",rset.getString(2),"",rset.getString(3),rset.getString(4));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
 
    public ArrayList<Curso> CursosProfesorPendiente(String loggin) {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
             PreparedStatement query = con.prepareStatement("select curso.idcurso,curso.horario , curso.nivel , alumno.nombre \n" +
"from curso join profesor on curso.idprofesor = profesor.idprofesor join registro on registro.idprofesor = profesor.idprofesor\n" +
"join historial_curso on historial_curso.idcurso = curso.idcurso join alumno on historial_curso.idalumno = alumno.idalumno \n" +
" where registro.loggin = ?  and curso.estado = 'Solicitado'");
            
            query.setString(1, loggin);
            String cad = "";
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                cad = (  "Curso" + rset.getInt(1)
                        +"Horario " + rset.getString(2)
                        + "Nivel " + rset.getString(3)
                        +"Nombre Alumno" + rset.getString(4));
                
                Curso curso = new Curso(1,rset.getInt(1),"",rset.getString(2),"",rset.getString(3),rset.getString(4));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Curso> CursosAlumnoEnCurso(String loggin) {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
             PreparedStatement query = con.prepareStatement("select curso.idcurso, curso.horario ,  curso.nivel , profesor.nombre "
                     + "from alumno join registro on registro.idalumno = alumno.idalumno join alumno_inscrito on"
                     + " alumno_inscrito.idalumno = alumno.idalumno join curso on "
                     + "curso.idcurso = alumno_inscrito.idcurso join profesor on profesor.idprofesor = curso.idprofesor " 
                     + " where registro.loggin = ? and curso.estado!='Finalizado'");
            
            query.setString(1, loggin);
            String cad = "";
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                cad = (  "Curso" + rset.getInt(1)
                        +"Horario " + rset.getString(2)
                        + "Nivel " + rset.getString(3)
                        +"Nombre Profesor" + rset.getString(4));
                
                Curso curso = new Curso(1,rset.getInt(1),rset.getString(4),rset.getString(2),"",rset.getString(3),rset.getString(4));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
     public ArrayList<Curso> CursosAlumnoFinalizados(String loggin) {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
             PreparedStatement query = con.prepareStatement("select curso.idcurso, curso.horario ,  curso.nivel , profesor.nombre , alumno_inscrito.calificacion "
                     + "from alumno join registro on registro.idalumno = alumno.idalumno join alumno_inscrito on"
                     + " alumno_inscrito.idalumno = alumno.idalumno join curso on "
                     + "curso.idcurso = alumno_inscrito.idcurso join profesor on profesor.idprofesor = curso.idprofesor " 
                     + " where registro.loggin = ?  and curso.estado = 'Finalizado' ");
            
            query.setString(1, loggin);
            String cad = "";
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                cad = (  "Curso" + rset.getInt(1)
                        +"Horario " + rset.getString(2)
                        + "Nivel " + rset.getString(3)
                        +"Nombre Profesor" + rset.getString(4)
                        +"Calificacion " + rset.getInt(5));
                
                Curso curso = new Curso(rset.getInt(1),rset.getString(4),rset.getString(2),rset.getString(3),rset.getInt(5));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

     public ArrayList<Curso> CursosProfesorCalificar(String loggin) {
        ArrayList<Curso> lista = new ArrayList<Curso>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
             PreparedStatement query = con.prepareStatement("select curso.idcurso,curso.horario , curso.nivel , alumno.nombre from curso join profesor on\n" +
"curso.idprofesor = profesor.idprofesor join registro on registro.idprofesor = profesor.idprofesor\n" +
"join alumno_inscrito on alumno_inscrito.idcurso = curso.idcurso join alumno on alumno_inscrito.idalumno = alumno.idalumno \n" +
"           where registro.loggin = ? and alumno_inscrito.calificacion is null and curso.estado = 'Asignado'");
            
            query.setString(1, loggin);
            String cad = "";
            ResultSet rset = query.executeQuery();
            while (rset.next()) {
                cad = (  "Curso" + rset.getInt(1)
                        +"Horario " + rset.getString(2)
                        + "Nivel " + rset.getString(3)
                        +"Nombre Alumno" + rset.getString(4));
                
                Curso curso = new Curso(1,rset.getInt(1),"",rset.getString(2),"",rset.getString(3),rset.getString(4));
                
                lista.add(curso);
            }
            
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
//    public static void main(String[] args) {
//        ConexionBD con = new ConexionBD();
//        ArrayList a = con.CursosProfesorCalificar("profesor");
//        System.out.println(a.size());
//        String path = "videos/";
//        String path1 = "pdfs/";
//        
//        
//  con.insertaAlumno("Julián Domínguez", "5511223344", "xjean02_x@hotmail.com", "julian2", "21614399");//1
//  con.insertaAlumno("Cristina Alvarez Rodríguez", "5511223344", "xjean02_x@hotmail.com", "cristina2", "21614399");
//  con.insertaAlumno("Mario Oporto", "5511223344", "xjean02_x@hotmail.com", "mario2", "21614399");
//  con.insertaAlumno("Carlos Gdansky", "5511223344", "xjean02_x@hotmail.com", "carlos2", "21614399");
//  con.insertaAlumno("Adela Segarra", "5511223344", "xjean02_x@hotmail.com", "adela2", "21614399");
//  con.insertaAlumno("Eduardo De Pedro", "5511223344", "xjean02_x@hotmail.com", "eduardo2", "21614399");
//  con.insertaAlumno("José María Diaz Bancalari", "5511223344", "xjean02_x@hotmail.com","jose2", "21614399");
//  con.insertaAlumno("Gloria Bidegain", "5511223344", "xjean02_x@hotmail.com","gloria2", "21614399");
//  con.insertaAlumno("Rosalva Cruz Ortega", "5511223344", "xjean02_x@hotmail.com","rosalva2", "21614399");
//  con.insertaAlumno("Ramiro Chavarria Lopez", "5511223344", "xjean02_x@hotmail.com","ramiro2", "21614399");
//  con.insertaAlumno("Orlando Campos Rosas", "5511223344", "xjean02_x@hotmail.com","orlando2", "21614399");
//  
//  con.insertaProfesor("Manuel Antonio Fernández Ortubey",path+"video1.mp4",
//            path1 + "cons1.pdf", "xjean02_x@hotmail.com", "manuel1", "21614399");//profe1
//  con.insertaCurso("Principiante","09:00hrs-10:00hrs", "01/05/2014",1);//curso 1
//        
//        
//  con.insertaProfesor("María Luna Java Ferreira",path+"video2.mp4",
//            path1+"cons2.pdf", "xjean02_x@hotmail.com", "maria1", "21614399");
//  con.insertaCurso("Intermedio","09:00hrs-10:00hrs", "02/05/2014",2);
//            
//            
//  con.insertaProfesor("Hugo Leonardo Lopetegui de León",path+"video3.mp4",
//            path1+"cons3.pdf", "xjean02_x@hotmail.com", "hugo1", "21614399");
//  con.insertaCurso("Avanzado","09:00hrs-10:00hrs", "03/06/2014",3);
//        
//        
//  con.insertaProfesor("Javier Asdrúbal Ortiz Zárate",path+"video4.mp4",
//            path1+"cons4.pdf", "xjean02_x@hotmail.com", "javier1", "21614399");
//  con.insertaCurso("Conversación","12:00hrs-13:00hrs", "04/06/2014",4);
//        
//        con.insertaProfesor("Emir Andrés Monegal de la Madrid",path+"video5.mp4",
//            path1+"cons5.pdf", "xjean02_x@hotmail.com", "emir1", "21614399");
//        con.insertaCurso("Principiante","10:00hrs-11:00hrs", "10/06/2014",5);
//        
//        con.insertaProfesor("Deyanira Susana Soler Gomínez",path+"video6.mp4",
//            path1+"cons6.pdf", "xjean02_x@hotmail.com", "deyanira1", "21614399");
//        con.insertaCurso("Intermedio","11:00hrs-12:00hrs", "01/06/2014",6);
//        
//        con.insertaProfesor("Alicia Olivia Peláez Jaume",path+"video7.mp4",
//            path1+"cons7.pdf", "xjean02_x@hotmail.com", "alicia1", "21614399");
//        con.insertaCurso("Avanzado","8:00hrs-09:00hrs", "01/07/2014",7);
//        
//        con.insertaProfesor("Abel Braulio Dorens Viera",path+"video8.mp4",
//            path1+"cons8.pdf", "xjean02_x@hotmail.com", "abel1", "21614399");
//        con.insertaCurso("Conversación","14:00hrs-15:00hrs", "16/07/2014",8);
//        
//  
//  con.insertaProfesor("Carmen Urrutia Salas",path+"video9.mp4",
//            path1+"cons5.pdf", "xjean02_x@hotmail.com", "carmen1", "21614399");
//  con.insertaProfesor("Diego Palacios Rios",path+"video10.mp4",
//            path1+"cons5.pdf", "xjean02_x@hotmail.com", "diego1", "21614399");
//  
//  con.insertaProfesor("Arturo Lopez Portillo",path+"video2.mp4",
//            path1+"cons5.pdf", "xjean02_x@hotmail.com", "arturo1", "21614399");
//  con.insertaProfesor("Damian Palacios Rosas",path+"video2.mp4",
//            path1+"cons5.pdf", "xjean02_x@hotmail.com", "damian1", "21614399");
//  
//        
//        
//    }
}