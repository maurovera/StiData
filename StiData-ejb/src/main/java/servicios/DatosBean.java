package servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Datos;

@Stateless
@LocalBean
public class DatosBean implements DatosLocal, DatosRemote {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public String saluda(String nombre) {
		if (nombre == null) {
			return "Hola desconocido";
		}

		return "Hola " + nombre;
	}

	/**
	 * Este es un ejemplo de consulta a la base de datos para traer un dato.
	 **/
	@Override
	public Datos traerUnDato() {

		String ql = "SELECT d from Datos d WHERE d.id=3";
		Query q = em.createQuery(ql);
		Datos d1 = (Datos) q.getSingleResult();

		return d1;
	}

	/**
	 * Este es un ejemplo de consulta a la base de datos para guardar un dato.
	 **/
	@Override
	public void guardarUnDato(Datos dato) {

		em.merge(dato);

	}

}
