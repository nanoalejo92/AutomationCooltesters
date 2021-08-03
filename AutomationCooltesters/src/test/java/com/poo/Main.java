package com.poo;

public class Main {

	public static void main(String[] args) {
		
		//Objeto
		Perro labrador = new Perro (4,"Cafe","Grandes","Golden Labrador");
		System.out.println("Mi perro es de raza" + labrador.getRaza());
		
		Perro chihuahua = new Perro (4,"Blanco","Chico","Chihuahua cabeza de manzana");
		System.out.println("Mi perro es de raza" + chihuahua.getRaza());
	}

}
