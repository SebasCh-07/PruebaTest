package com.krakedev.examen.EvaluacionModuloIII.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.examen.EvaluacionModuloIII.bdd.ReservasBDD;
import com.krakedev.examen.EvaluacionModuloIII.entidades.Reservas;
import com.krakedev.examen.EvaluacionModuloIII.exepciones.KrakeException;


@Path("reservas")
public class ServiciosReservas {
	@Path ("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerReservas(){
		ReservasBDD reBDD = new ReservasBDD();
		ArrayList<Reservas> reservas = null;
		try {
			reservas = reBDD.recuperarReservas();
			return Response.ok(reservas).build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar (Reservas reserva) {
		System.out.println(">>>>>>" + reserva);
		ReservasBDD re = new ReservasBDD();
		try {
			re.insertar(reserva);
			return Response.ok().build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}