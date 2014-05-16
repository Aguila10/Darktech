package Controlador;

/**
 *
 * @author caenhiro
 */
public class Curso {
    public int idprofesor;
    public int idcurso;
    public int califi;
    public String profesor,hora,fecha,nivel,alumno;
    
    public Curso(int idprofesor, int idcurso, String profesor,String hora, String fecha,String nivel, String nombre){
        this.idprofesor = idprofesor;
        this.idcurso = idcurso;
        this.profesor = profesor;
        this.hora = hora;
        this.fecha = fecha;
        this.nivel = nivel;
        this.alumno = nombre;     
    }
    
    public Curso(int idprofesor, int idcurso, String profesor,String hora, String fecha,String nivel){
        this.idprofesor = idprofesor;
        this.idcurso = idcurso;
        this.profesor = profesor;
        this.hora = hora;
        this.fecha = fecha;
        this.nivel = nivel;
    
    }

    public Curso(int idcurso, String profesor,String hora, String nivel, int calif){
        this.idcurso = idcurso;
        this.profesor = profesor;
        this.hora = hora;
        this.nivel = nivel;
        this.califi = calif; 
    }
    
    public int getIdprofesor() {
        return idprofesor;
    }
    
    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }
    
    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }
    
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public int getIdcurso() {
        return idcurso;
    }
    
    public String getProfesor() {
        return profesor;
    }
    
    public String getHora() {
        return hora;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getNivel() {
        return nivel;
    }

    /**
     * @return the alumno
     */
    public String getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    
    
    /**
     * @return the califi
     */
    public int getCalifi() {
        return califi;
    }

    /**
     * @param califi the califi to set
     */
    public void setCalifi(int califi) {
        this.califi = califi;
    }
}