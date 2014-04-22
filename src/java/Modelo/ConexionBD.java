package Modelo;

import Controlador.Curso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    String connectString = "jdbc:postgresql://localhost:5432/escuela_ingles";
    String user = "postgres";
    String password = "1008rpdml3";
    
    
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
        boolean res =false ;
        Statement statement;
        ResultSet resultSet;
        
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  agregaCurso('" + nivel + "', "
                    + "'" + horario + "','" + fecha + "'," + idprofesor + ");");
            
            while (resultSet.next()) {
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
            resultSet = statement.executeQuery("SELECT * from  actualizaProfeso2(" + idprofesor  + contrasenia + "');");
            
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
    
    
    
    public static void main(String[] args) {
        ConexionBD con = new ConexionBD();
        con.insertaProfesor("profesor1", "video","constacia", "coreo", "profesor1", "profesor");
        con.insertaCurso("Conversación", "1-2 pm", "12/12/89", 1);
        con.insertaCurso("Conversación", "11-2 pm", "12/12/89", 1);
        con.insertaCurso("Conversación", "12-2 pm", "12/12/89", 1);
        con.insertaCurso("Conversación", "13-2 pm", "12/12/89", 1);
        con.insertaCurso("Conversación", "14-2 pm", "12/12/89", 1);
        con.insertaCurso("Intermedio", "18-2 am", "12/12/89", 1);
        con.insertaCurso("Avanzado", "19-2 am", "12/12/89", 1);
    }
}