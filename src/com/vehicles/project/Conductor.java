package com.vehicles.project;

public class Conductor extends Persona{
	
	protected Licence llicencia = new Licence();
	public Conductor(String nom, String cognom, String cognom2, String dataNaixement, Licence llicencia) {
		super(nom, cognom, cognom2, dataNaixement);
		this.llicencia = llicencia;
	}
	
	@Override
	public String toString() {
		return "Conductor: Llicència: " + llicencia + ",\n Nom=" + nom + ", Cognom=" + cognom + ", Segon Cognom=" + cognom2
				+ ",\n Data de Naixement del Conductor=" + dataNaixement;
	}
	
	
}
