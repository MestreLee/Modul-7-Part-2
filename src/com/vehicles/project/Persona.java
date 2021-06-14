package com.vehicles.project;

public abstract class Persona {
	
	protected String nom;
	protected String cognom;
	protected String cognom2;
	protected String dataNaixement;
	
	public Persona(String nom, String cognom, String cognom2, String dataNaixement) {
		this.nom = nom;
		this.cognom = cognom;
		this.cognom2 = cognom2;
		this.dataNaixement = dataNaixement;
	}


}
