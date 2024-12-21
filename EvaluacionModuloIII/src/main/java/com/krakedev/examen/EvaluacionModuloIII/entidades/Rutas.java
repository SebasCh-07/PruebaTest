package com.krakedev.examen.EvaluacionModuloIII.entidades;

import java.util.Date;

public class Rutas {
	private String codigoR;
	private String origen;
	private String destino;
	private Date horarioSalida;
	private BUSES bus;
	
	public Rutas () {
		
	}
	public Rutas(String codigoR, String origen, String destino, Date horarioSalida, BUSES bus) {
		super();
		this.codigoR = codigoR;
		this.origen = origen;
		this.destino = destino;
		this.horarioSalida = horarioSalida;
		this.bus = bus;
	}
	public String getCodigoR() {
		return codigoR;
	}
	public void setCodigoR(String codigoR) {
		this.codigoR = codigoR;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getHorarioSalida() {
		return horarioSalida;
	}
	public void setHorarioSalida(Date horarioSalida) {
		this.horarioSalida = horarioSalida;
	}
	public BUSES getBus() {
		return bus;
	}
	public void setBus(BUSES bus) {
		this.bus = bus;
	}
	@Override
	public String toString() {
		return "Rutas [codigoR=" + codigoR + ", origen=" + origen + ", destino=" + destino + ", horarioSalida="
				+ horarioSalida + ", bus=" + bus + "]";
	}
	
	
}
