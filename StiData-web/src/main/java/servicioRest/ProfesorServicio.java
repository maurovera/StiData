package servicioRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servicios.ProfesorBean;
import entidades.Alumno;
import entidades.Profesor;

@Path("profesorServicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class ProfesorServicio {

	@EJB
	private ProfesorBean profesorBean;

	/**trae un profesor
	 * */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("profesores/{id}")
	public Profesor obtenerProfesor(@PathParam("id") Integer id) {
		Profesor profesor = new Profesor();
		try {
			profesor = profesorBean.verProfesor(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return profesor;
	}

	/**
	 * Lista de Profesores
	 **/
	@GET
	@Path("/profesores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profesor> listaProfesores() {
		return profesorBean.listaProfesores();
	}

	/**
	 * Modificar un profesor
	 **/
	@POST
	@Path("/profesores")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarProfesor(Profesor profesor) {
		profesorBean.modificarProfesor(profesor);
		String result = "Profesor Modificado : " + profesor.getNombre();
		return Response.status(201).entity(result).build();

	}

	/**
	 * Crear un Profesor
	 * 
	 **/
	@PUT
	@Path("/profesores")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearProfesor(Profesor profesor) {
		profesorBean.crearProfesor(profesor);
		String result = "Profesor Creado : " + profesor.getNombre();
		return Response.status(201).entity(result).build();

	}

	/**
	 * Eliminar un profesor
	 * 
	 ***/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/profesores/{id}")
	public Response eliminarProfesor(@PathParam("id") Integer id) {
		profesorBean.eliminarProfesor(id);
		String result = "Profesor Eliminado ";
		return Response.status(200).entity(result).build();

	}

}
