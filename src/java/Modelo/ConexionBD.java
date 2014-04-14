
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
     *Metodo que imprime el nombre del profesor y el correo electronico 
     * @param idprofesor la llave del profesor a buscar
     */
    public void buscaProfesor(Integer idprofesor) {

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select * from profesor where idprofesor=?");
            query.setInt(1, idprofesor);
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {

                cad = ("Nombre del profesor " + rset.getString(3) + " , "
                        + "  Correo electronico " + rset.getString(6));
            }
            System.out.println(cad);
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *Metodo que regresa el el login pedido 
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
     *Metodo que nos imprime el nombre y correo electronico de todos los profesores
     * en la tabla
     */
    public void ListaProfesores() {

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select * from profesor");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {

                cad = ("Nombre del profesor " + rset.getString(3) + " , "
                        + "  Correo electronico " + rset.getString(6));
            }
            System.out.println(cad);
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *Metodo que nos regresa el id profesor idcurso nombre del profesor
     * de todos los cursos que siguen disponibles
     */
    public void ListaCursosDisponibles() {

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select profesor.idprofesor, profesor.idcurso, profesor.nombre from"
                    + " profesor_disponible join profesor on profesor.idcurso = profesor_disponible.idcurso;");
            ResultSet rset = query.executeQuery();
            String cad = "";
            while (rset.next()) {

                cad = ("Id profesor " + rset.getInt(1) + " , "
                        + "Id curso " + rset.getInt(2) + " , "
                        + "Nombre del profesor " + rset.getString(3));
            }
            System.out.println(cad);
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *Metodo que inserta un profesor
     *
     * @param nombre profesor
     * @param liga_video del profesor
     * @param liga_constancia del profesor
     * @param correo_electronico del profesor
     * @param login del profesor
     * @param contrasenia del profesor
     * @return String el resultado de la función
     */
    public String insertaProfesor( String nombre, String liga_video,
            String liga_constancia, String correo_electronico, String login, String contrasenia) {
        String res = "";
        Statement statement;
        ResultSet resultSet;

        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from agrega_profesor('"+ nombre 
                    + "','" + liga_video + "','" + liga_constancia + "','" + correo_electronico + "'"
                    + ",'" + login + "','" + contrasenia + "');");

            while (resultSet.next()) {
                res = resultSet.getString(1);
            }

            System.out.println(res);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    /**
     *Metodo que inserta un curso 
     * @param nivel del curso
     * @param horario del curso
     * @param fecha del curso
     * @param idprofesor del curso
     * @return resultado de la funcion
     */
    public String insertaCurso(String nivel, String horario, String fecha, Integer idprofesor) {
        String res = "";
        Statement statement;
        ResultSet resultSet;

        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  agrega_curso('" + nivel + "', "
                    + "'" + horario + "','" + fecha + "'," + idprofesor + ");");

            while (resultSet.next()) {
                res = resultSet.getString(1);
            }

            System.out.println(res);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    /**
     *Metodo que insert aun alumno
     * @param nombre del alumno
     * @param telefono del alumno
     * @param correo_electronico del alumno
     * @param login del alumno
     * @param contrasenia del alumno
     * @return el resultado de la funcion
     */
    public String insertaAlumno(String nombre, String telefono,
            String correo_electronico, String login, String contrasenia) {
        String res = "";
        Statement statement;
        ResultSet resultSet;

        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  agrega_alumno('" + nombre
                    + "','" + telefono + "','" + correo_electronico + "','" + login + "'"
                    + ",'" + contrasenia + "');");

            while (resultSet.next()) {
                res = resultSet.getString(1);
            }

            System.out.println(res);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    /**
     *Metodo que regresa el idalumno dado su nombre
     * @param nombre del alumno
     * @return 0 si no existe o el idalumno
     */
    public int regresaIdAlumno(String nombre) {
        int res = 0;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select idalumno from alumno"
                    + " where nombre =?");
            query.setString(1, nombre);
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
     *metodo que regresa el idprofesor dado un nombre
     * @param nombre del profesor
     * @return o si no existe o el idprofesor
     */
    public int regresaIdProfesor(String nombre) {
        int res = 0;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select idprofesor from profesor"
                    + " where nombre =?");
            query.setString(1, nombre);
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
     *Metodo que regresa el idcurso 
     * @param idprofesor del curso
     * @param horario del curso
     * @return o si no existe el curso buscado o el idcurso
     */
    public int regresaIdCurso(int idprofesor, String horario) {
        int res = 0;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user, password);
            PreparedStatement query = con.prepareStatement("select curso.idcurso from "
                    + "profesor_disponible join curso on curso.idcurso = profesor_disponible.idcurso"
                    + "where curso.idprofesor=? and horario = ?;");
            query.setInt(1, idprofesor);
            query.setString(2, horario);
            ResultSet rset = query.executeQuery();
            while (rset.next()) {

                res = (rset.getInt(1));
            }
        } catch (SQLException | java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return res;
    }
    
    
    
    public String actualizaAlumno(int idalumno, String nombre, String correo, String contrasenia) {
        String res = "";
        Statement statement;
        ResultSet resultSet;

        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualiza_alumno(" + idalumno + ", "
                    + "'" + nombre + "','" + correo + "','" + contrasenia + "');");

            while (resultSet.next()) {
                res = resultSet.getString(1);
            }

            System.out.println(res);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
    
    
        public String actualizaProfesor(int idprofesor, String nombre, String correo, String contrasenia) {
        String res = "";
        Statement statement;
        ResultSet resultSet;

        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * from  actualiza_profesor(" + idprofesor + ", "
                    + "'" + nombre + "','" + correo + "','" + contrasenia + "');");

            while (resultSet.next()) {
                res = resultSet.getString(1);
            }

            System.out.println(res);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    /**
     *
     * @param args
//     */
//    public static void main(String[] args) {
//        Conexion on = new Conexion();
//        on.insertaAlumno("nombre", "asd", "awdsfg", "adsdf", "adsfd");
//        System.out.println(on.buscaLogin("jeaqqn").equals(""));
//
//    on.ListaCursosDisponibles();
//    on.ListaProfesores();
//    int k = on.regresaIdAlumno("carlos");
//    on.actualizaAlumno(k, "carlos1", "correo1","newcontra");
//    on.insertaProfesor("nombre1", "liga" , "datprofe1", "datprof1", "profesor1", "hola");
//    int j = on.regresaIdProfesor("nombre1");
//    on.actualizaProfesor(j, "profe1", "correo1", "newcontra");
//    String log = on.buscaLogin("profesor1");
//    on.buscaProfesor(1);
//    on.insertaCurso("intermedio", "hora", "12/02/83", 1);
//    
//    
//      
//        System.out.println(k);
//        System.out.println(j);
//        System.out.println(log);
//            }

}