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

import servicios.AlumnoBean;
import entidades.Alumno;

@Path("alumnoServicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class AlumnoServicio {

	@EJB
	private AlumnoBean alumnoBean;

	// trae una alumno
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("alumnos/{id}")
	public Alumno obtenerAlumno(@PathParam("id") Integer id) {
		Alumno alumno = new Alumno();
		try {
			alumno = alumnoBean.verAlumno(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return alumno;
	}

	/**
	 * Lista de Asignatura
	 **/
	@GET
	@Path("/alumnos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alumno> listaAlumnos() {
		return alumnoBean.listaAlumnos();
	}

	/**
	 * Modificar un alumno
	 * 
	 **/
	@POST
	@Path("/alumnos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarAlumno(Alumno alumno) {
		alumnoBean.modificarAlumno(alumno);
		String result = "Alumno Modificado : " + alumno.getNombres();
		return Response.status(201).entity(result).build();

	}

	/**
	 * Crear un alumno
	 * 
	 **/
	@PUT
	@Path("/alumnos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearAlumno(Alumno alumno) {
		alumnoBean.crearAlumno(alumno);
		String result = "Alumno Creado : " + alumno.getNombres();
		return Response.status(201).entity(result).build();

	}

	/**
	 * Eliminar un alumno
	 * 
	 ***/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alumnos/{id}")
	public Response eliminarAlumno(@PathParam("id") Integer id) {
		alumnoBean.eliminarAlumno(id);
		String result = "Alumno Eliminado ";
		return Response.status(200).entity(result).build();

	}

}
