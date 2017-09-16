package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarea_detalle")
public class TareaDetalle {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_tarea_detalle")
	private Integer idTareaDetalle;

	@JoinColumn(name = "tarea", referencedColumnName = "id_tarea")
	@ManyToOne
	private Tarea tarea;

	@OneToOne
	private Ejercicio ejercicio;

	@Column(name = "resultado")
	private boolean resultado;
	
	@Column(name = "nombre")
	private String nombre;
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdTareaDetalle() {
		return idTareaDetalle;
	}

	public void setIdTareaDetalle(Integer idTareaDetalle) {
		this.idTareaDetalle = idTareaDetalle;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
	

}
