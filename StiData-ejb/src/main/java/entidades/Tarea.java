package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_tarea")
    private Integer idtarea;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "asignatura")
    private String asignatura;
    
    /**
     * Seria conceptos separados por coma por el momento 
     **/
    @Column(name = "conceptos")
    private String conceptos;
    
    /**
     * Seria una lista de temas
     **/
	@Column(name = "temas")
    private String temas;
	
	/**
     * Seria una lista de ejercicios
     **/
	@Column(name = "ejercicios")
    private String ejercicios;
	
	
	/**
     * Seria una lista de resultados
     **/
	@Column(name = "resultados")
    private String resultados;


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


	public String getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	public String getConceptos() {
		return conceptos;
	}


	public void setConceptos(String conceptos) {
		this.conceptos = conceptos;
	}


	public String getTemas() {
		return temas;
	}


	public void setTemas(String temas) {
		this.temas = temas;
	}


	public String getEjercicios() {
		return ejercicios;
	}


	public void setEjercicios(String ejercicios) {
		this.ejercicios = ejercicios;
	}


	public String getResultados() {
		return resultados;
	}


	public void setResultados(String resultados) {
		this.resultados = resultados;
	}
	

}
