package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.AsignaturaDTO;
import entidades.Asignatura;
import entidades.Concepto;
import entidades.Tema;

@Stateless
@LocalBean
public class AsignaturaBean implements AsignaturaLocal, AsignaturaRemote {

	@PersistenceContext
	protected EntityManager em;

	@EJB
	private TemaBean temaBean;

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

		return asig;
	}

	@Override
	public List<Asignatura> listaAsignatura() {
		List<Asignatura> listaAsignatura = new ArrayList<Asignatura>();
		try {
			String jpql = "SELECT t.idAsignatura, t.descripcion FROM Asignatura t";
			Query query = em.createQuery(jpql);
			List<Object[]> resultado = query.getResultList();

			for (int i = 0; i < resultado.size(); i++) {
					Asignatura as = new Asignatura();
					Integer arg0 = (Integer) resultado.get(i)[0];
					String arg1 = (String) resultado.get(i)[1];
					as.setIdAsignatura(arg0);
					as.setDescripcion(arg1);
					listaAsignatura.add(as); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAsignatura;
	}

	/**
	 * Metodo que se encarga de guardar una asignatura ya con sus temas y
	 * conceptos
	 **/
	public void guardarAsigConTema(AsignaturaDTO asignaturaDto) {

		// Se crea una asignatura. Y se setea todo los datos de asignaturaDTO
		Asignatura asignatura = new Asignatura();

		asignatura.setDescripcion(asignaturaDto.getDescripcion());
		/**
		 * Se borra el id ficticio del detalle, se le asigna la asignatura y se
		 * guarda en la lista.
		 */
		for (Tema t : asignaturaDto.getListaTemas()) {
			for (Concepto c : t.getListaConceptos()) {
				c.setIdConcepto(null);
				c.setTema(t);
			}

			t.setIdTema(null);
			t.setAsignatura(asignatura);
			asignatura.getListaTemas().add(t);

		}
		em.persist(asignatura);

	}

	/**
	 * Metodo que se encarga de modificar una asignatura ya con sus temas y
	 * conceptos. Falta configurar cuando hay un nuevo detalle
	 **/
	public void modificarAsigConTema(AsignaturaDTO asignaturaDto) {

		/**
		 * Trae una asignatura del dto
		 **/
		try {

			Asignatura asignatura = verAsignatura(asignaturaDto
					.getIdAsignatura());

			asignatura.setDescripcion(asignaturaDto.getDescripcion());

			/**
			 * Quitamos las listas de eliminados, modificados y nuevos.
			 **/
			List<List<Tema>> lista = listaGenerica(asignatura.getListaTemas(),
					asignaturaDto.getListaTemas());

			/** Eliminados */
			for (Tema t : lista.get(0)) {
				temaBean.eliminarTema(t.getIdTema());
				asignatura.getListaTemas().remove(t);
			}

			/** Modificados */
			for (Tema t : lista.get(1)) {
				t.setAsignatura(asignatura);
				temaBean.modifTema(t);
			}

			for (Tema t : lista.get(2)) {
				t.setIdTema(null);
				t.setAsignatura(asignatura);
				temaBean.crearTema(t);
			}

			/**
			 * Por ultimo modificamos la asignatura misma si tiene algun cambio
			 **/
			System.out.println("llegue aqui");
			em.flush();
			em.merge(asignatura);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * Metodo que se encarga de Eliminar una asignatura ya con sus temas y
	 * conceptos. Falta configurar cuando hay un nuevo detalle. Obs: funciona.
	 **/
	public void eliminarAsigConTema(Integer asignaturaId) {

		try {
			/**
			 * Trae una asignatura con solo su integer.
			 **/
			Asignatura asignatura = verAsignatura(asignaturaId);

			/** Borramos todos los temas asociados a él */
			for (Tema t : asignatura.getListaTemas()) {
				temaBean.eliminarTema(t.getIdTema());
			}
			// remueve la asignaura
			em.remove(asignatura);

		} catch (Exception e) {
			e.toString();
		}
	}

	/**
	 * Compara lista que llegan de la base de datos con la lista de lo nuevo que
	 * se carga por el frontend
	 * 
	 * @return {@link List} Lista de listas de el tipo que requiera.
	 * @return el primer elemento es: ELIMINADOS el segundo elemento es:
	 *         MODIFICADOS el tercer elemento es: NUEVOS
	 **/
	private <T> List<List<T>> listaGenerica(List<T> listaBD, List<T> listaDto) {
		// listas
		List<List<T>> lista = new ArrayList<List<T>>();
		List<T> eliminados = new ArrayList<T>();
		List<T> modificados = new ArrayList<T>();
		List<T> nuevos = new ArrayList<T>();

		// Quitamos las listas de eliminados.
		for (T t : listaBD) {
			if (listaDto.contains(t)) {
				continue;
			} else {
				eliminados.add(t);
			}
		}

		// quitamos la lista de nuevos y modificados.
		for (T t : listaDto) {
			if (listaBD.contains(t)) {
				modificados.add(t);
			} else {
				nuevos.add(t);
			}
		}

		lista.add(eliminados);
		lista.add(modificados);
		lista.add(nuevos);

		return lista;

	}

}
