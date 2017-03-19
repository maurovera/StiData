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
@Table(name = "camino")
public class Camino implements Serializable{
	
	/*un camino se define por:
	el concepto aislado que ha fallado, su estilo de aprendizaje, nivel, materiales mostrados y ejercicios mostrados.
	un ejemplo de camino -> Suma1, Video3, Medio, False*/
							
							
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id_camino")
    private Integer idCamino;
    
    @JoinColumn(name = "sesion", referencedColumnName = "id_sesion")
    @ManyToOne 
    private Sesion sesion;
    
    @Column(name = "concepto")
    private String concepto;
    
    @Column(name = "nivel_alumno")
    private String nivelAlumno;
    
    @Column(name = "estilo_aprendizaje")
    private String estiloAprendizaje;
    
    //se tendra en cuenta un orden de materiales vistos FALLIDOS
    //EJEMPLO-> V1,V2,V4 (lo q ya se mostro y fallo)
    @Column(name = "materiales")
    private String materiales;
    

    //se tendra en cuenta un orden de ejercicios vistos FALLIDOS
    //EJEMPLO-> E1,E2,E7 (lo q ya se mostro y fallo)
    @Column(name = "ejercicios")
    private String ejercicios;
    
    //este es el material que pudo ayudar a que resuelva el ejercicio (TRUE)
    @Column(name = "material_util")
    private String materialUtil;
    
    //este es el ejercicio que pudo resolver (TRUE), luego de ver un material util
    @Column(name = "ejercicio_util")
    private String ejercicioUtil;

	public Integer getIdCamino() {
		return idCamino;
	}

	public void setIdCamino(Integer idCamino) {
		this.idCamino = idCamino;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getNivelAlumno() {
		return nivelAlumno;
	}

	public void setNivelAlumno(String nivelAlumno) {
		this.nivelAlumno = nivelAlumno;
	}

	public String getEstiloAprendizaje() {
		return estiloAprendizaje;
	}

	public void setEstiloAprendizaje(String estiloAprendizaje) {
		this.estiloAprendizaje = estiloAprendizaje;
	}

	public String getMateriales() {
		return materiales;
	}

	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}

	public String getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(String ejercicios) {
		this.ejercicios = ejercicios;
	}

	public String getMaterialUtil() {
		return materialUtil;
	}

	public void setMaterialUtil(String materialUtil) {
		this.materialUtil = materialUtil;
	}

	public String getEjercicioUtil() {
		return ejercicioUtil;
	}

	public void setEjercicioUtil(String ejercicioUtil) {
		this.ejercicioUtil = ejercicioUtil;
	}
    
    
}
