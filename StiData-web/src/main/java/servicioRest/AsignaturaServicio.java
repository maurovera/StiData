package servicioRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.AsignaturaDTO;
import dto.TareaDTO;
import servicios.AsignaturaBean;
import entidades.Asignatura;
import entidades.Tema;

@Path("asignaturaServicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class AsignaturaServicio {

	@EJB
	private AsignaturaBean asignaturaBean;

	/**
	 * Lista de Asignatura
	 **/
	@GET
	@Path("/asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Asignatura> listaAsignaturas() {
		return asignaturaBean.listaAsignatura();
	}

	/**
	 * Trae una asignatura
	 * */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asignaturas/{id}")
	public Asignatura obtenerAsig(@PathParam("id") Integer id) {
		Asignatura asignatura = new Asignatura();
		try {
			asignatura = asignaturaBean.verAsignatura(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return asignatura;
	}

	/**
	 * Modificar una asignatura
	 * 
	 **/
	@POST
	@Path("/asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarAsig(Asignatura asignatura) {
		asignaturaBean.modifAsignatura(asignatura);
		String result = "Asig Modificada : " + asignatura.getDescripcion();
		return Response.status(201).entity(result).build();

	}

	/**
	 * Crear una Asignatura
	 * 
	 **/
	@PUT
	@Path("/asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearAsig(Asignatura asignatura) {
		asignaturaBean.crearAsignatura(asignatura);
		String result = "Asig Creada : " + asignatura.getDescripcion();
		return Response.status(201).entity(result).build();
	}

	/**
	 * Eliminar una Asignatura
	 * 
	 ***/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asignaturas/{id}")
	public Response eliminarAsig(@PathParam("id") Integer id) {
		asignaturaBean.elimAsignatura(id);
		String result = "Asig Eliminada ";
		return Response.status(200).entity(result).build();

	}
	
	
	/**
	 * Crear una asignatura con temas. Esta en prueba esto.
	 * 
	 **/
	@PUT
	@Path("/asignaturas/guardar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(AsignaturaDTO asignaturaDto) {
		asignaturaBean.guardarAsigConTema(asignaturaDto);
		String result = "Asignatura con temas Creado : " + asignaturaDto.getDescripcion();
		return Response.status(201).entity(result).build();

	}

	
	/**
	 * Mod una asignatura con temas. Esta en prueba esto.
	 * 
	 **/
	@POST
	@Path("/asignaturas/mod")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarAsig(AsignaturaDTO asignaturaDto) {
		asignaturaBean.modificarAsigConTema(asignaturaDto);
		String result = "Asignatura con temas Modificado : " + asignaturaDto.getDescripcion();
		return Response.status(201).entity(result).build();

	}
	
	
	/**
	 * Eliminar una Asignatura con temas
	 * 
	 ***/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asignaturas/del/{id}")
	public Response eliminarAsigConTemas(@PathParam("id") Integer id) {
		asignaturaBean.eliminarAsigConTema(id);
		String result = "Asig con tema Eliminada ";
		return Response.status(200).entity(result).build();

	}

	
}
