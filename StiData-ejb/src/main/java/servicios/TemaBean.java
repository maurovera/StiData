package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Tema;

@Stateless
@LocalBean
public class TemaBean implements TemaLocal, TemaRemote {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public void crearTema(Tema tema) {
		em.persist(tema);

	}

	@Override
	public void modifTema(Tema tema) {
		em.merge(tema);

	}

	/** Obs.: igual aca hay que corroborar que exista la entidad */
	@Override
	public void eliminarTema(Integer id) {
		Tema t = verTema(id);
		em.remove(t);

	}

	/**
	 * Retorna un tema. 
	 **/
	@Override
	public Tema verTema(Integer id) {
		Tema tema = em.find(Tema.class, id);
		if(tema == null)
			return null;
		else
			return tema;

	}

	
	/**
	 * Trae lista de temas
	 **/
	public List<Tema> listaTemas() {
		List<Tema> listaTema = new ArrayList<Tema>();
		try {
			String jpql = "SELECT t FROM Tema t";
			Query query = em.createQuery(jpql);
			List<Tema> resultado = query.getResultList();
			listaTema.addAll(resultado);
			for (Tema t : resultado) {
				System.out.println(t.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTema;
	}
}
