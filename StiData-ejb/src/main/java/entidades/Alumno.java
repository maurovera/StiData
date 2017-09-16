package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_alumno")
    private Integer idAlumno;

    @OneToOne
	   private EstiloAprendizaje estilo;
    
    @Column(name = "nivel_actual")
    private String nivelActual;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Size(max = 1)
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "edad")
    private Integer edad;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public EstiloAprendizaje getEstilo() {
		return estilo;
	}

	public void setEstilo(EstiloAprendizaje estilo) {
		this.estilo = estilo;
	}

	public String getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(String nivelActual) {
		this.nivelActual = nivelActual;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
    
	 @Override
	    public String toString() {
	        return "model.Alumno[ idAlumno=" + idAlumno + " ]";
	    }
}
