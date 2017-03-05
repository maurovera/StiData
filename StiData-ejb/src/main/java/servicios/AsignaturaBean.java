package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Asignatura;
import entidades.Tema;

@Stateless
@LocalBean
public class AsignaturaBean implements AsignaturaLocal, AsignaturaRemote {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public void crearAsignatura(Asignatura asignatura) {
		em.persist(asignatura);

	}

	@Override
	public void modifAsignatura(Asignatura asignatura) {
		em.merge(asignatura);

	}

	@Override
	public void elimAsignatura(Integer id) {
		Asignatura a = verAsignatura(id);
		em.remove(a);

	}

	public Asignatura verAsignatura(Integer id) {
		Asignatura asig = em.find(Asignatura.class, id);
		List<Tema> temaLista = new ArrayList<Tema>();
		temaLista = asig.getListaTemas();

		for (Tema t : temaLista) {
			System.out.println(t.getNombre());
		}
		return asig;
	}

	@Override
	public List<Asignatura> listaAsignatura() {
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		try {
			String jpql = "SELECT t FROM Asignatura t";
			Query query = em.createQuery(jpql);
			List<Asignatura> resultado = query.getResultList();
			listaAsignatura.addAll(resultado);
			for (Asignatura a : resultado) {
				System.out.println(a.getDescripcion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAsignatura;
	}
}
