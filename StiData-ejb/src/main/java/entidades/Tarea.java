package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_tarea")
    private Integer idtarea;
    
    @JoinColumn(name = "curso", referencedColumnName = "id_curso")
    @ManyToOne 
    private Curso curso;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    
    /**Lista de temas separados por coma*/
    @Column(name="temas_selec")
    private String temasSeleccionados;
    
    /**Lista de conceptos separados por coma*/
    @Column(name="conceptos_selec")
    private String conceptosSeleccionados;
    
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    private Date fechaFin;
    
    @Column(name="estado_tarea")
    private boolean estadoTarea;
    
    @Column(name="tiempo")
    private Date tiempo;

	public Integer getIdtarea() {
		return idtarea;
	}

	public void setIdtarea(Integer idtarea) {
		this.idtarea = idtarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTemasSeleccionados() {
		return temasSeleccionados;
	}

	public void setTemasSeleccionados(String temasSeleccionados) {
		this.temasSeleccionados = temasSeleccionados;
	}

	public String getConceptosSeleccionados() {
		return conceptosSeleccionados;
	}

	public void setConceptosSeleccionados(String conceptosSeleccionados) {
		this.conceptosSeleccionados = conceptosSeleccionados;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(boolean estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
    
    
    
    
}
