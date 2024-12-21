package com.krakedev.examen.EvaluacionModuloIII.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.examen.EvaluacionModuloIII.bdd.BusesBDD;
import com.krakedev.examen.EvaluacionModuloIII.entidades.BUSES;
import com.krakedev.examen.EvaluacionModuloIII.exepciones.KrakeException;


@Path ("buses")
public class ServiciosBuses {
	@Path ("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerBuses(){
		BusesBDD busBDD = new BusesBDD();
		ArrayList<BUSES> busesR = null;
		try {
			busesR = busBDD.recuperarBuses();
			return Response.ok(busesR).build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(BUSES bt) {
		BusesBDD b= new BusesBDD();
		try {
			b.insertar(bt);
			return Response.ok("Éxito!!!").build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
