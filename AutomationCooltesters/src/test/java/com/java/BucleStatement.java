package com.java;

public class BucleStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//While
		int numero = 1;
		while(numero <= 10) {
			System.out.println("El numero es "+ numero);
			++numero;
		}
		
		// Do-while _ Cuantas veces se tiene que sumar asi mismo "numeroSum" para llegar a 100?
		
		int numeroSum = 5;
		int sumTotal = 0;
		int count = 0;
		
		do {
			//sumTotal = sumTotal + numeroSum;
			sumTotal += numeroSum;
			++count;
		}while(sumTotal < 100);
		System.out.println("El numero se sumo "+ count);
		
		//FOR
		
		int numeroFor = 10;
		
		for(int i=1;i<=numeroFor;i++) {
			//Block code
			System.out.println("El numero FOR es "+ i);
			
			if(i==5) {
				break;
			}
			
		}
		
	}

}
