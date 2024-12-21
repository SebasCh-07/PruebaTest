package com.krakedev.examen.EvaluacionModuloIII.entidades;

public class BUSES {
	private String idBUS;
	private int capMax;
	
	public BUSES () {
		
	}
	public BUSES(String idBUS, int capMax) {
		super();
		this.idBUS = idBUS;
		this.capMax = capMax;
	}
	public String getIdBUS() {
		return idBUS;
	}
	public void setIdBUS(String idBUS) {
		this.idBUS = idBUS;
	}
	public int getCapMax() {
		return capMax;
	}
	public void setCapMax(int capMax) {
		this.capMax = capMax;
	}
	@Override
	public String toString() {
		return "BUSES [idBUS=" + idBUS + ", capMax=" + capMax + "]";
	}
	
	
}
