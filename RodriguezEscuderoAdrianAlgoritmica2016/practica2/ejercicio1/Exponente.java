package org.lya.practica2.ejercicio1;
import java.util.*;
import org.lya.utilidades.NumerosAleatorios;

public class Exponente {
	private static Scanner lector = new Scanner(System.in);
	private int base;
	private int exponente;

	public Exponente(int base, int exponente) {
		this.base = base;
		this.exponente = exponente;
	}
	public Exponente (int exponente, int limInf, int limSup) {
		NumerosAleatorios numRand = new NumerosAleatorios();
		this.base = numRand.randomInt(limInf, limSup);
		this.exponente = exponente;
	}

	public double exponenFuerzaBruta() {
		double resultado = 1.0;
		if (this.exponente == 0) { 
			return 1.0;
		}
		for (int i = 0; i < this.exponente; i++) {
			resultado *= this.base;
		}
		return resultado;
	}

	public double exponenRecursivoDyV() {
		if (this.exponente == 0){
			return 1.0;
		}
		return exponenteRecursivoDyV (this.base, this.exponente);
	}
	public static double exponenteRecursivoDyV(int base, int exponente) {
		if (exponente == 1) return base;
		
		if (exponente %2 == 0) {
			return Math.pow(exponenteRecursivoDyV(base, exponente/2), 2.0);
		}
		else {
			return base*exponenteRecursivoDyV(base, exponente - 1);
		}
	}

	public void setExpon(int expon) {
		this.exponente = expon;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getBase() {
		return this.base;
	}
	public static void main(String[] args) {
		
		double[] tiempo = new double[10]; //Recursivo
		double[] tiempo1 = new double[10]; //fuerza Bruta
		Exponente exp;
		int exponente;
		System.out.print("Introduzca el exponente: ");
		exponente = lector.nextInt();
		while (exponente < 0) {
			System.out.println("El exponente debe de ser mayor o igual que 0");
			System.out.print("Introduzca el exponente: ");
			exponente = lector.nextInt();
		}
		int base = (int)(Math.random()*9) + 2;
		int tope;
		System.out.print("Introduzca el tope del exponente (el exponente se duplica mientras sea menor que el tope): ");
		tope = lector.nextInt();
		double start, end;
		double media = 0; 
		double media1 = 0; 
	
		while (exponente < tope) {
			exp = new Exponente (base, exponente);
			for (int i = 0; i < 10; i++) {
				start = System.nanoTime();
				exponenteRecursivoDyV(base, exponente);
				end = System.nanoTime();
				tiempo[i] = end - start;
			}
			Arrays.sort(tiempo);
			media = calcularMedia(tiempo);
			
			for (int i = 0; i < 10; i++) {
				start = System.nanoTime();
				exp.exponenFuerzaBruta();
				end = System.nanoTime();
				tiempo1[i] = end - start;
			}
			Arrays.sort(tiempo1);
			media1 = calcularMedia(tiempo1);
			
			
			System.out.println("La media de tiempo para el algoritmo recursivo con exponente = " + exponente + " y base = " + base + " es: " + media + "ns");
			System.out.println("La media de tiempo para el algoritmo de Fuerza Bruta con exponente = " + exponente + " y base = " + base + " es: " + media1 + "ns \n");
			
			exponente*=2;
		}			
	}
	public static double calcularMedia (double[] array) {
		double media = 0;
		for (int i= 0; i < array.length - 2; i++) {
			if (array.length + 2 == 0) {
				return 0;
			}
			media += array[i];
		}
		media = media /array.length - 2;
		return media;
	}
}
