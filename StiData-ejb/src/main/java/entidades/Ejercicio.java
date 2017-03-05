package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ejercicio")
public class Ejercicio implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_ejercicio")
    private Integer idEjercicio;
    
    @Column(name = "respCorrecta")
    private Integer respCorrecta;
    
    @Column(name = "enunciado")
    private String enunciado;
   
    //nivel de dificultad
    @Column(name = "nivelDif")
    private Integer nivelDif;
    
	//definido por el profesor
    @Column(name = "descuido")
    private Integer descuido;

    @ManyToMany(mappedBy = "listaEjercicio")
    private List<Concepto> listaConceptos;
    
	public Integer getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(Integer idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public Integer getRespCorrecta() {
		return respCorrecta;
	}

	public void setRespCorrecta(Integer respCorrecta) {
		this.respCorrecta = respCorrecta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Integer getNivelDif() {
		return nivelDif;
	}

	public void setNivelDif(Integer nivelDif) {
		this.nivelDif = nivelDif;
	}

	public Integer getDescuido() {
		return descuido;
	}

	public void setDescuido(Integer descuido) {
		this.descuido = descuido;
	}
    
    
}
