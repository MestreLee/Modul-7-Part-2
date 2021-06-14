package com.vehicles.project;

public class Titular extends Conductor{
	
	protected boolean seguro;
	protected boolean garatge;
	
	public Titular(String nom, String cognom, String cognom2, String dataNaixement, Licence llicencia, boolean seguro, boolean garatge) {
		super(nom, cognom, cognom2, dataNaixement, llicencia);
		this.seguro = seguro;
		this.garatge = garatge;
	}

	@Override
	public String toString() {
		String seguro = this.seguro ? "Si" : "No";
		String garatge = this.garatge ? "Si" : "No";
		return "Titular: Seguro=" + seguro + ", Garatge=" + garatge + ",\n Llicència=" + llicencia + ",\n Nom=" + nom
				+ ", Cognom=" + cognom + ", Segon Cognom=" + cognom2 + ",\n Data de Naixement del Titular=" + dataNaixement + ".";
	}
	
	

}
