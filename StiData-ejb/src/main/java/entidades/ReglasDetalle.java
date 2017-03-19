package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "reglas_detalle")
public class ReglasDetalle {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_reglas_detalle")
	private Integer idReglaDetalle;

	
	@JoinColumn(name = "reglas", referencedColumnName = "id_regla")
    @ManyToOne 
    private Reglas reglas;
    
	@Column(name = "regla_drools")
	private String reglaDrools;
	
	@Column(name = "regla_nnge")
	private String reglaNnge;

	public Integer getIdReglaDetalle() {
		return idReglaDetalle;
	}

	public void setIdReglaDetalle(Integer idReglaDetalle) {
		this.idReglaDetalle = idReglaDetalle;
	}

	public Reglas getReglas() {
		return reglas;
	}

	public void setReglas(Reglas reglas) {
		this.reglas = reglas;
	}

	public String getReglaDrools() {
		return reglaDrools;
	}

	public void setReglaDrools(String reglaDrools) {
		this.reglaDrools = reglaDrools;
	}

	public String getReglaNnge() {
		return reglaNnge;
	}

	public void setReglaNnge(String reglaNnge) {
		this.reglaNnge = reglaNnge;
	}
	
	
	
	
}
