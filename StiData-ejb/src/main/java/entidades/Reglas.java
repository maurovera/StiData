package entidades;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "reglas")
public class Reglas {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_regla")
	private Integer idRegla;

	@Column(name = "fecha_generada")
	private Date fechaGenerada;

	@Basic(fetch=FetchType.LAZY,optional=true)
	@Column(name = "regla_drools")
	@Lob
	private byte[] reglaDrools;

	
	@Basic(fetch=FetchType.LAZY,optional=true)
	@Column(name = "regla_nnge")
	@Lob
	private byte[] reglaNnge;

	public Integer getIdRegla() {
		return idRegla;
	}

	public void setIdRegla(Integer idRegla) {
		this.idRegla = idRegla;
	}

	public Date getFechaGenerada() {
		return fechaGenerada;
	}

	public void setFechaGenerada(Date fechaGenerada) {
		this.fechaGenerada = fechaGenerada;
	}

	public byte[] getReglaDrools() {
		return reglaDrools;
	}

	public void setReglaDrools(byte[] reglaDrools) {
		this.reglaDrools = reglaDrools;
	}

	public byte[] getReglaNnge() {
		return reglaNnge;
	}

	public void setReglaNnge(byte[] reglaNnge) {
		this.reglaNnge = reglaNnge;
	}


}
