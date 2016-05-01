package com.cr.jee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("weka")
@Stateless
@LocalBean
public class TestWeka {

	@EJB
	private PruebaConWeka pw;

	@GET
	@Produces("text/html")
	public String getHtml() {
		return pw.resultadoWeka();

	}

}
