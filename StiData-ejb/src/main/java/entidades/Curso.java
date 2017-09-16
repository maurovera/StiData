package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_curso")
	private Integer idCurso;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToOne
	private Asignatura asignatura;


	@Column(name = "asignatura_arbol")
	private byte[] asignaturaArbol;

	@JoinColumn(name = "profesor", referencedColumnName = "id_profesor")
	@ManyToOne
	private Profesor profesor;

	@JoinTable(name = "curso_alumno", joinColumns = { @JoinColumn(name = "id_curso", referencedColumnName = "id_curso") }, inverseJoinColumns = { @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno") })
	@ManyToMany
	private List<Alumno> listaAlumno;

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
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

	@XmlTransient
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}

	
	public byte[] getAsignaturaArbol() {
		return asignaturaArbol;
	}

	public void setAsignaturaArbol(byte[] asignaturaArbol) {
		this.asignaturaArbol = asignaturaArbol;
	}

	@Override
	public String toString() {
		return "model.Curso[ idCurso=" + idCurso + " ]";
	}

}
