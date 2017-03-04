package servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servicios.DatosBean;
import entidades.Datos;

@Path("datos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class DatosServicio {

	@EJB
	private DatosBean datos;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{nombre}")
	public String saluda(@PathParam("nombre") String nombre) {
		String saludo = datos.saluda(nombre);
		return saludo;
	}

	@POST
	@Consumes("application/xml")
	@Path("/adentro/{nombre}")
	public Response guardar(@PathParam("nombre") String nombre) {
		String saludo = datos.saluda(nombre);
		Datos d = new Datos();
		d.setId(1);
		d.setNombre("mauro");
		d.setValor(27);
		return Response.ok(d).build();
	}

	@GET
	@Path("/get")
	@Produces("application/json")
	public Datos getProductInJSON() {

		Datos datos = new Datos();
		datos.setId(1);
		datos.setNombre("mauro");
		datos.setValor(27);

		return datos;

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Datos datos) {
		datos.setId(2);
		datos.setNombre("mauro");
		datos.setValor(70);
		String result = "Product created : " + datos;
		return Response.status(201).entity(result).build();

	}

	@GET
	@Path("/unDato")
	@Produces("application/json")
	public Datos traerUnDato() {
		
		Datos d = datos.traerUnDato();
		
		return d;

	}
	
	@POST
	@Path("/guardarDato")
	@Consumes("application/json")
	public Response guardarDato(Datos dato) {
		datos.guardarUnDato(dato);
		String result = "Dato Guardado : " + dato.getNombre();
		return Response.status(201).entity(result).build();

	}
	
	

}
