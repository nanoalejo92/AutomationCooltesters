package com.polimorfismo;

public class Gato extends Animal {
	
	public Gato() {
		super("Gato");
	}

	@Override
	public void speak() {
		System.out.print("Meow-Meow");
		
	}
	
}
