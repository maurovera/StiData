package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_respuesta")
    private Integer idRespuesta;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "correcta")
    private Boolean correcta;
    
    @JoinColumn(name = "ejercicio", referencedColumnName = "id_ejercicio")
    @ManyToOne 
    private Ejercicio ejercicio;
    
    
	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}

	public Integer getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Integer idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
	@Override
    public String toString() {
        return "model.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }

}
