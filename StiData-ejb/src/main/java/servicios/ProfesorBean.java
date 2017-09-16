package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Profesor;

@Stateless
@LocalBean
public class ProfesorBean {

	@PersistenceContext
	protected EntityManager em;
	final String LISTA = "SELECT p FROM Profesor p";

	/**
	 * Traer un profesor
	 * */
	public Profesor verProfesor(Integer id) {
		Profesor profesor = em.find(Profesor.class, id);
		if (profesor == null)
			return null;
		else
			return profesor;

	}

	/**
	 * Trae lista de profesores
	 **/
	public List<Profesor> listaProfesores() {
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		try {
			String jpql = LISTA;
			Query query = em.createQuery(jpql);
			List<Profesor> resultado = query.getResultList();
			listaProfesor.addAll(resultado);
			for (Profesor profesor : resultado) {
				System.out.println(profesor.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProfesor;
	}

	/**
	 * Crear un profesor
	 **/
	public void crearProfesor(Profesor profesor) {
		em.persist(profesor);

	}

	/**
	 * Modificar un Profesor
	 */
	public void modificarProfesor(Profesor profesor) {
		em.merge(profesor);

	}

	/**
	 * Elimna un profesor Obs.: igual aca hay que corroborar que exista la
	 * entidad
	 */
	public void eliminarProfesor(Integer id) {
		Profesor profesor = verProfesor(id);
		em.remove(profesor);

	}

}
