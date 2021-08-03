package com.poo;

public class Perro {
	
	//Variable de instancia
	int numPatas;
	String color, tamano, raza;
	
	// Constructor
	public Perro(int numPatas,String color, String tamano, String raza) {
		this.numPatas = numPatas;
		this.color = color;
		this.tamano = tamano;
		this.raza = raza;
				
	}
	public String getRaza() {
		return this.raza;
	}
}
