package com.java;

public class ConditionalStatement {

	public static void main(String[] args) {
	
		int velocidad = 80; // Km/h
		int limiteVelocidad = 80; // Km/h
		
		// IF Anidados - IF ELSE IF 
		
		boolean carretera = false;
		
		if(carretera) {
			//Block code
			 System.out.println("Carretera");
			 limiteVelocidad = 110;
			 
			 if (velocidad > limiteVelocidad) {
					System.out.println("El coche va a exceso de velocidad, multa");
				}else {
					System.out.println("El coche va en la velocidad adecuada, felicidades");
				}
		} else if (velocidad > limiteVelocidad) {
			System.out.println("Calle");
			System.out.println("El coche va a exceso de velocidad, multa");
		}else {
			System.out.println("El coche va en la velocidad adecuada, felicidades");
		}	
		
		//SWITCH CASE
		
		int temperatura = 20;
		
		switch(temperatura) {
		
		case 5:
		System.out.println("Clima Muy Frio");
		break;
		
		case 10:
		System.out.println("Clima Frio");
		break;
		
		case 20:
		System.out.println("Clima Templado");
		break;
		
		case 30:
		System.out.println("Clima Calido");
		break;
		
		default:
			System.out.println("Clima no rconocible por el sistema");
			break;
			
		
		}
	}
}
