package com.vehicles.project;

public class Licence {
	protected int id;
	protected String tipusLlicencia;
	protected String nomComplet;
	protected String dataCaducitat;
	
	public Licence(int id, String tipusLlicencia, String nomComplet, String dataCaducitat) {
		this.id = id;
		this.tipusLlicencia = tipusLlicencia;
		this.nomComplet = nomComplet;
		this.dataCaducitat = dataCaducitat;
	}
	public Licence() {
		
	}
	
	public void setId (int id) {
		this.id = id;
	}
	public void setLlicencia (String tipusLlicencia) {
		this.tipusLlicencia = tipusLlicencia;
	}
	public void setNom (String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public void setCaducitat (String dataCaducitat) {
		this.dataCaducitat = dataCaducitat;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", Tipus de Llicència=" + tipusLlicencia + ",\n Nom Complet=" + nomComplet
				+ ",\n Data de Caducitat de la Llicència=" + dataCaducitat;
	}


}
