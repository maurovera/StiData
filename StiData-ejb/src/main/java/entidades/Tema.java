package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tema")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_tema")
	private Integer idTema;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "peso")
	private Integer peso;

	@JoinColumn(name = "asignatura", referencedColumnName = "id_asignatura")
	@ManyToOne
	private Asignatura asignatura;

	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	private List<Concepto> listaConceptos = new ArrayList<Concepto>();
	
	
	
	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
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

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@XmlTransient
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public String toString() {
		return "model.Tema[ idTema=" + idTema + " ]";
	}

	
	/**
	 * Metodo para comparar*/
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// Si no es una instancia de Tema
		if (!(object instanceof Tema)) {
			return false;
		}
		Tema otroTema = (Tema) object;
		// si uno es nulo es falso 
		if ((this.idTema == null && otroTema.idTema != null)
				|| (this.idTema != null && !this.idTema
						.equals(otroTema.idTema))) {
			return false;
		}
		/**Campos a comparar
		 **/
		if (
				(this.getDescripcion().equals(otroTema.getDescripcion()))&&
				(this.getIdTema().equals(otroTema.getIdTema())) && 
				(this.getNombre().equals(otroTema.getNombre())) &&
				(this.getPeso().equals(otroTema.getPeso()))
				){
			return true;
		}
				
		return true;
	}

	@Transient
	public List<Concepto> getListaConceptos() {
		return listaConceptos;
	}

	public void setListaConceptos(List<Concepto> listaConceptos) {
		this.listaConceptos = listaConceptos;
	}

	
}
