package com.krakedev.examen.EvaluacionModuloIII.entidades;

import java.util.Date;

public class Reservas {
	private String codigoReserva;
	private Usuarios usuarioRe;
	private int boletos;
	private Rutas ruta;
	private Date fechaReserva;
	
	public Reservas() {
		
	}
	public Reservas(String codigoReserva, Usuarios usuarioRe, int boletos, Rutas ruta, Date fechaReserva) {
		super();
		this.codigoReserva = codigoReserva;
		this.usuarioRe = usuarioRe;
		this.boletos = boletos;
		this.ruta = ruta;
		this.fechaReserva = fechaReserva;
	}
	public String getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	public Usuarios getUsuarioRe() {
		return usuarioRe;
	}
	public void setUsuarioRe(Usuarios usuarioRe) {
		this.usuarioRe = usuarioRe;
	}
	public int getBoletos() {
		return boletos;
	}
	public void setBoletos(int boletos) {
		this.boletos = boletos;
	}
	public Rutas getRuta() {
		return ruta;
	}
	public void setRuta(Rutas ruta) {
		this.ruta = ruta;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	@Override
	public String toString() {
		return "Reservas [codigoReserva=" + codigoReserva + ", usuarioRe=" + usuarioRe + ", boletos=" + boletos
				+ ", ruta=" + ruta + ", fechaReserva=" + fechaReserva + "]";
	}
	
	
}
