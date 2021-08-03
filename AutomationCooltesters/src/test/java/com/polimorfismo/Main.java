package com.polimorfismo;

public class Main {

	public static void main(String[] args) {
		
		Animal humano = new Humano();
		humano.speak();
		
		Animal gato  = new Gato();
		gato.speak();
		
		//Humano
		Animal animal = new Humano();
		animal.speak();
		
		//Gato
		animal = new Gato();
		animal.speak();
		
		//Humano
		animal = new Humano();
		animal.speak();
		
		
	}

}
