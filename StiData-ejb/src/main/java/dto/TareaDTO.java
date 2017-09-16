package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entidades.Curso;
import entidades.TareaDetalle;

public class TareaDTO  implements Serializable{
    
	private Integer idtarea;
    
	private Integer curso;
    
	private String nombre;

    private String descripcion;
    
    private String temasSeleccionados;
    
    private String conceptosSeleccionados;
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    private boolean estadoTarea;
    
    private Date tiempo;

    private List<TareaDetalle> listaTareas = new ArrayList<TareaDetalle>();

	public Integer getIdtarea() {
		return idtarea;
	}

	public void setIdtarea(Integer idtarea) {
		this.idtarea = idtarea;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
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

	public List<TareaDetalle> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(List<TareaDetalle> listaTareas) {
		this.listaTareas = listaTareas;
	}

    
    
    
    

}
