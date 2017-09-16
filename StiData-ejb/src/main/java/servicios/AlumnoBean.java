package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Alumno;

@Stateless
@LocalBean
public class AlumnoBean {

	@PersistenceContext
	protected EntityManager em;
	final String LISTA = "SELECT a FROM Alumno a";

	/**
	 * Traer un alumno
	 * */
	public Alumno verAlumno(Integer id) {
		Alumno alumno = em.find(Alumno.class, id);
		if (alumno == null)
			return null;
		else
			return alumno;

	}

	/**
	 * Trae lista de alumnos
	 **/
	public List<Alumno> listaAlumnos() {
		List<Alumno> listaAlumno = new ArrayList<Alumno>();
		try {
			String jpql = LISTA;
			Query query = em.createQuery(jpql);
			List<Alumno> resultado = query.getResultList();
			listaAlumno.addAll(resultado);
			for (Alumno alumno : resultado) {
				System.out.println(alumno.getNombres());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlumno;
	}

	
	/**
	 * Crear un alumno
	 **/
	public void crearAlumno(Alumno alumno) {
		em.persist(alumno);

	}
	
	/**
	 * Modificar un alumno*/
	public void modificarAlumno(Alumno alumno) {
		em.merge(alumno);

	}

	/** 
	 * Elimna un alumno
	 * Obs.: igual aca hay que corroborar que exista la entidad */
	public void eliminarAlumno(Integer id) {
		Alumno alumno = verAlumno(id);
		em.remove(alumno);

	}


}
