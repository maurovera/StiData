package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_asignatura")
	private Integer idAsignatura;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "asignatura")
	// private List<Tema> listaTemas;
	private List<Tema> listaTemas = new ArrayList<Tema>();

	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
