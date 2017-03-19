package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estilo_aprendizaje")
public class EstiloAprendizaje implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_estilo")
    private Integer idEstilo;
    
    @Column(name = "estilo_aprendizaje")
    private String estiloAprendizaje;
    
	//ESTILO VISUAL
    @Column(name = "resul_v")
    private Integer resulV;
    
	//ESTILO AUDITIVO
    @Column(name = "resul_a")
    private Integer resulA;
    
  //ESTILO LECTOR
    @Column(name = "resul_r")
    private Integer resulR;
    
  //ESTILO KINESTESICO
    @Column(name = "resul_k")
    private Integer resulK;

	public Integer getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(Integer idEstilo) {
		this.idEstilo = idEstilo;
	}

	public String getEstiloAprendizaje() {
		return estiloAprendizaje;
	}

	public void setEstiloAprendizaje(String estiloAprendizaje) {
		this.estiloAprendizaje = estiloAprendizaje;
	}

	public Integer getResulV() {
		return resulV;
	}

	public void setResulV(Integer resulV) {
		this.resulV = resulV;
	}

	public Integer getResulA() {
		return resulA;
	}

	public void setResulA(Integer resulA) {
		this.resulA = resulA;
	}

	public Integer getResulR() {
		return resulR;
	}

	public void setResulR(Integer resulR) {
		this.resulR = resulR;
	}

	public Integer getResulK() {
		return resulK;
	}

	public void setResulK(Integer resulK) {
		this.resulK = resulK;
	}

	@Override
    public String toString() {
        return "model.EstiloAprendizaje[ idEstilo=" + idEstilo + " ]";
    }
}
