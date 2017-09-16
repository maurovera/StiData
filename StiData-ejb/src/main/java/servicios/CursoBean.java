package servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dto.CursoDTO;
import entidades.Asignatura;
import entidades.Curso;
import entidades.Profesor;

@Stateless
@LocalBean
public class CursoBean {

	@PersistenceContext
	protected EntityManager em;

	@EJB
	private AsignaturaBean asignaturaBean;

	@EJB
	private ProfesorBean profesorBean;

	public Curso verCurso(Integer id) {
		Curso curso = em.find(Curso.class, id);
		if (curso == null)
			return null;
		else
			return curso;

	}

	public void guardar(CursoDTO cursodto) {

		// Se crea una Curso. Y se setea todo los datos de cursoDTO
		Curso curso = new Curso();

		Asignatura a = asignaturaBean.verAsignatura(cursodto.getIdAsignatura());
		curso.setAsignatura(a);
		curso.setDescripcion(cursodto.getDescripcion());
		curso.setNombre(cursodto.getNombre());
		Profesor p = profesorBean.verProfesor(cursodto.getIdProfesor());
		curso.setProfesor(p);
		String direccion = "/home/mauro/Documentos/TemasNuevos.xdsl";
		try {
			byte[] arbol = readBytesFromFile(direccion);
			curso.setAsignaturaArbol(arbol); // lo guardamos en la entidad
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * Se carga el curso sin alumnos
		 **/
		em.persist(curso);

	}

	// /metodo para readbyte
	private byte[] readBytesFromFile(String filePath) throws IOException {
		File inputFile = new File(filePath);
		FileInputStream inputStream = new FileInputStream(inputFile);
		byte[] fileBytes = new byte[(int) inputFile.length()];
		inputStream.read(fileBytes);
		inputStream.close();
		return fileBytes;
	}

}
