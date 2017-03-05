package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Asignatura;
import entidades.Tema;

@Stateless
@LocalBean
public class AsignaturaBean implements AsignaturaLocal, AsignaturaRemote {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public void crearAsignatura(Asignatura asignatura) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifAsignatura(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimAsignatura(Integer id) {
		// TODO Auto-generated method stub

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

}
