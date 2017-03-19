package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "concepto")
public class Concepto implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_concepto")
    private Integer idConcepto;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apriori")
    private Double apriori;
    
    @Column(name = "peso")
    private Double peso;
    
	@JoinColumn(name = "tema", referencedColumnName = "id_tema")
    @ManyToOne
    private Tema tema;
	
	  @JoinTable(name = "ejercicio_concepto", joinColumns = {
		        @JoinColumn(name = "id_concepto", referencedColumnName = "id_concepto")}, inverseJoinColumns = {
		        @JoinColumn(name = "id_ejercicio", referencedColumnName = "id_ejercicio")})
		    @ManyToMany
		    private List<Ejercicio> listaEjercicio;
	
    public Double getApriori() {
		return apriori;
	}

	public void setApriori(Double apriori) {
		this.apriori = apriori;
	}

    
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
    public String toString() {
        return "model.Concepto[ idConcepto=" + idConcepto + " ]";
    }
}
