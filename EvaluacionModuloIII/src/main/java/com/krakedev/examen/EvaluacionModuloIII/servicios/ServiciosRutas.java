package com.krakedev.examen.EvaluacionModuloIII.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.examen.EvaluacionModuloIII.bdd.RutasBDD;
import com.krakedev.examen.EvaluacionModuloIII.entidades.Rutas;
import com.krakedev.examen.EvaluacionModuloIII.exepciones.KrakeException;

@Path("rutas")
public class ServiciosRutas {
	@Path ("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerRutas(){
		RutasBDD rutaBDD = new RutasBDD();
		ArrayList<Rutas> rutas = null;
		try {
			rutas = rutaBDD.recuperarRutas();
			return Response.ok(rutas).build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar (Rutas ruta) {
		System.out.println(">>>>>>" + ruta);
		RutasBDD ru = new RutasBDD();
		try {
			ru.insertar(ruta);
			return Response.ok().build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
