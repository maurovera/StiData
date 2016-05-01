package com.cr.jee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilidades.HerramientasDrools;
import utilidades.HerramientasWeka;
import utilidades.Regla;


@Stateless
@LocalBean
public class PruebaConWeka {

	public String resultadoWeka(){
		
		HerramientasWeka hw = new HerramientasWeka("/home/mauro/Documentos/documentosPruebas/PATRONES_GUION.csv");
		hw.ejecutar();
		System.out.println(hw.getDrl());
		String valor = hw.getDrl();
		
		
		// la parte de drools
		HerramientasDrools hd = new HerramientasDrools(valor);
		hd.iniciarBaseConocimiento();
		hd.iniciarSession();
		
		Regla r = new Regla();
        r.setConcepto("SUM");
        r.setNivel("MEDIO");
        r.setEstilo("VISUAL");
        r.setSecuenciaEjercicios("E1_E2");
        r.setSecuenciaVideos("VIDEO1_VIDEO2_VIDEO4");
        
		hd.ejecutarRegla(r);
		
		hd.terminarSession();
		
		valor = "mirar terminal";
		return valor;
	}
}
