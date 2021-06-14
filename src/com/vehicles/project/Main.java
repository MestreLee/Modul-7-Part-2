package com.vehicles.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int triarNum(int min, int max){
		Boolean bool = false;
		Scanner Obj0 = new Scanner(System.in);
		int tria = Obj0.nextInt();
		//Llegim la new-line que causa problemes amb l'scanner si no es fa:
		Obj0.nextLine();
		while (tria < min || tria > max){
			//Scanner Obj0 = new Scanner(System.in);
			if (!bool) {
				System.out.println("Valor incorrecte!Escriu un valor entre " + min + " i " + max + ":");
			}
			try {
				tria = Obj0.nextInt();
				bool =  false;
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				Obj0.nextLine();
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte!Escriu un valor entre " + min + " i " + max + ":");
				 bool =  true;
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 Obj0.nextLine();
			 }
		}
		return tria;
	}
	
	static int triarVehicle(int num, String permis) throws Exception{
		
		int tria = num;
		if (tria == 0) {
			//System.out.println(permis + " " + tria);
			if(!permis.equals("cotxe")) {
				throw new Exception ("No tens permís per conduir un cotxe!");
			}
			
		}else if (tria == 1) {
			//System.out.println(permis + " " + tria);
			if(!permis.equals("moto")) {
				throw new Exception ("No tens permís per conduir una moto!");
			}
			
		}else if(tria == 2) {
			//System.out.println(permis + " " + tria);
			if(!permis.equals("camio")){
				throw new Exception ("No tens permís per conduir un camió!");
			}
			
		}
		return tria;
	}
	
	static double comprovarDiametre(double diametre){
		double diam = diametre;
		boolean bool = false;
		while (diam < 0.4 || diam > 4) {
			Scanner Obj1 = new Scanner(System.in);
			if (!bool) {
				System.out.println("Diàmetre incorrecte! Ha de ser més gran de 0.4 i més petit de 4:");
			}
			try {
				diam = Obj1.nextDouble();
				bool = false;
			}catch (InputMismatchException e) {
				System.out.println("Format incorrecte! escriu un número entre el 0,4 i el 4:");
				bool = true;
			}		  
		}
	    return diam;
	}
	static boolean comprovarMatricula(String matricula){
		boolean bool = true;
		String str = matricula;
		if (str.length() > 7 || str.length() < 6) {
			System.out.println("La matrícula no pot tenir més de 7 ni menys de 6 caracters!");
	    	bool = false;
	    }
		int i = 0;
		while (i < str.length() && bool == true) {
			Boolean flag = Character.isDigit(str.charAt(i));
	    	if (i < 4) {
	    		if(!flag) {
	    			System.out.println("Els primers 4 caracters han de ser dígits!");
	    			bool = false;
		        }
	    	}else{
	    		if(flag) {
	    			System.out.println("Els últims caracters han de ser lletres!");
	    			bool = false;
		        }
	    	} 
	    	
	    	i++;
		}    	
		return bool;
	}

	public static void main(String[] args) {
		
		//Instanciem un objecte de classe Titular
		
		String nom = "Bernat";
		String cognom = "Cócera";
		String cognom2 = "Saló";
		String dataNaixement = "8 febrer 1985";
		boolean seguro = true;
		boolean garatge = true;
		
		Licence llicencia = new Licence(44556, "cotxe", nom + " " + cognom + " " + cognom2, "21 gener 2021");
		
		Titular titular = new Titular(nom, cognom, cognom2, dataNaixement, llicencia, seguro, garatge);
		
		System.out.println(titular.toString());
		
		//Preguntem a l'usuari si vol crear un cotxe, una moto o un camió
		System.out.println("Vols crear un cotxe (0), una moto (1) o un camió (2) ?");
		String permis = titular.llicencia.tipusLlicencia;
		int triaVehicle = triarNum(0,2); 
		try {
			triaVehicle = triarVehicle(triaVehicle, permis);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//Demanem a l'usuari que introdueixi la matrícula, la marca i el color del vehicle
		
		System.out.println("Introdueix la matrícula del vehicle:");
		Scanner myObj = new Scanner(System.in);
		String matriculaVehicle = myObj.nextLine();
		Boolean bool =  false;		
		while(!bool) {
			bool = comprovarMatricula(matriculaVehicle);
			if (!bool) {
				System.out.println("Introdueix la matrícula del vehicle:");
				matriculaVehicle = myObj.nextLine();
			}
		}
		
		System.out.println("Introdueix la marca del vehicle:");
		String marcaVehicle = myObj.nextLine();
		System.out.println("Introdueix el color del vehicle:");
		String colorVehicle = myObj.nextLine();
	
		//Demanem a l'usuari la marca i el diàmetre de les rodes del darrere
		double diametreRodaDarrere = 0;
		double diametreRodaDavant = 0;
		System.out.println("Introdueix la marca de la roda del darrere:");
		String marcaRodaDarrere = myObj.nextLine();
		System.out.println("Introdueix el diàmetre de la roda del darrere:");
		
		bool = false;
		
		while (!bool){
			try {
				diametreRodaDarrere = myObj.nextDouble();
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				myObj.nextLine();
				comprovarDiametre(diametreRodaDarrere);
				bool = true;
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte! escriu un número entre el 0,4 i el 4:");
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 myObj.nextLine();
			 }
		}		 
		 
		Wheel rodaDarrere = new Wheel (marcaRodaDarrere, diametreRodaDarrere);
				
		System.out.println("Introdueix la marca de la roda del davant:");
		String marcaRodaDavant = myObj.nextLine();
		System.out.println("Introdueix el diàmetre de la roda del davant:");
		
        bool = false;
		
		while (!bool){
			try {
				diametreRodaDavant = myObj.nextDouble();
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				myObj.nextLine();
				comprovarDiametre(diametreRodaDavant);
				bool = true;
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte! escriu un número entre el 0,4 i el 4:");
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 myObj.nextLine();
			 }
		}		 
		
		Wheel rodaDavant = new Wheel (marcaRodaDavant, diametreRodaDavant);
		
		if (triaVehicle == 0) {
			Car cotxe = new Car(matriculaVehicle, marcaVehicle, colorVehicle);
			List<Wheel> rodesDarrere = new ArrayList<Wheel>();
			rodesDarrere.add(rodaDarrere);
			rodesDarrere.add(rodaDarrere);	
			List<Wheel> rodesDavant = new ArrayList<Wheel>();
			rodesDavant.add(rodaDavant);
			rodesDavant.add(rodaDavant);
			
			try {
				cotxe.addWheels(rodesDarrere, rodesDavant);
			}catch(Exception x) {
				System.out.print(x.getMessage());
			}
			
			System.out.println(cotxe.toString());
			System.out.println("El titular serà també el conductor del cotxe? 0 - si, 1 - no");

			if (triarNum(0, 1) == 1) {
				System.out.println("Digues el nom, els cognoms i la data de naixement del conductor del cotxe:");
				nom = myObj.nextLine();
				cognom = myObj.nextLine();
				cognom2 = myObj.nextLine();
				dataNaixement = myObj.nextLine();
				System.out.println("Digues la id de la llicència, el seu tipus i la data de caducitat:");
				int idLlicencia = myObj.nextInt();
				myObj.nextLine();
				String tipusLlicencia = myObj.nextLine();
				String caducaLlicencia = myObj.nextLine();
				try {
					triarVehicle(triaVehicle,tipusLlicencia);
				}catch (Exception x) {
					System.out.println (x.getMessage());
					System.exit(1);
				}
				
				Licence llicencia2 = new Licence(idLlicencia, tipusLlicencia, nom + " " + cognom + " " + cognom2, caducaLlicencia);
				Conductor conductor = new Conductor (nom, cognom, cognom2, dataNaixement, llicencia2);
				System.out.println(conductor.toString());
			}else {
				System.out.println(titular.toString());
			}
		}else if(triaVehicle == 1) {
			Bike moto = new Bike(matriculaVehicle, marcaVehicle, colorVehicle);
			
			try {
				moto.addWheels(rodaDarrere, rodaDavant);
			}catch(Exception x) {
				System.out.print(x.getMessage());
			}
			
			System.out.println(moto.toString());
			System.out.println("El titular serà també el conductor de la moto? 0 - si, 1 - no");

			if (triarNum(0, 1) == 1) {
				System.out.println("Digues el nom, els cognoms i la data de naixement del conductor del cotxe:");
				nom = myObj.nextLine();
				cognom = myObj.nextLine();
				cognom2 = myObj.nextLine();
				dataNaixement = myObj.nextLine();
				System.out.println("Digues la id de la llicència, el seu tipus i la data de caducitat:");
				int idLlicencia = myObj.nextInt();
				myObj.nextLine();
				String tipusLlicencia = myObj.nextLine();
				String caducaLlicencia = myObj.nextLine();
				try {
					triarVehicle(triaVehicle,tipusLlicencia);
				}catch (Exception x) {
					System.out.println (x.getMessage());
					System.exit(1);
				}
				Licence llicencia2 = new Licence(idLlicencia, tipusLlicencia, nom + " " + cognom + " " + cognom2, caducaLlicencia);
				Conductor conductor = new Conductor (nom, cognom, cognom2, dataNaixement, llicencia2);
				System.out.println(conductor.toString());
			}else {
				System.out.println(titular.toString());
			}
			
		}else {
			Truck camio = new Truck(matriculaVehicle, marcaVehicle, colorVehicle);
			List<Wheel> rodesDarrere = new ArrayList<Wheel>();
			rodesDarrere.add(rodaDarrere);
			rodesDarrere.add(rodaDarrere);	
			List<Wheel> rodesDavant = new ArrayList<Wheel>();
			rodesDavant.add(rodaDavant);
			rodesDavant.add(rodaDavant);
			
			try {
				camio.addWheels(rodesDarrere, rodesDavant);
			}catch(Exception x) {
				System.out.print(x.getMessage());
			}
			
			System.out.println(camio.toString());
			System.out.println("El titular serà també el conductor del comió? 0 - si, 1 - no");

			if (triarNum(0, 1) == 1) {
				System.out.println("Digues el nom, els cognoms i la data de naixement del conductor del cotxe:");
				nom = myObj.nextLine();
				cognom = myObj.nextLine();
				cognom2 = myObj.nextLine();
				dataNaixement = myObj.nextLine();
				System.out.println("Digues la id de la llicència, el seu tipus i la data de caducitat:");
				int idLlicencia = myObj.nextInt();
				myObj.nextLine();
				String tipusLlicencia = myObj.nextLine();
				String caducaLlicencia = myObj.nextLine();
				try {
					triarVehicle(triaVehicle,tipusLlicencia);
				}catch (Exception x) {
					System.out.println (x.getMessage());
					System.exit(1);
				}
				Licence llicencia2 = new Licence(idLlicencia, tipusLlicencia, nom + " " + cognom + " " + cognom2, caducaLlicencia);
				Conductor conductor = new Conductor (nom, cognom, cognom2, dataNaixement, llicencia2);
				System.out.println(conductor.toString());
			}else {
				System.out.println(titular.toString());
			}
		}
		
	}

}
