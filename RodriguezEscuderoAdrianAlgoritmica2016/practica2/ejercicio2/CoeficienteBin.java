package org.lya.practica2.ejercicio2;

import java.util.*;

public class CoeficienteBin {
	private static Scanner lector = new Scanner(System.in);
	private int n;
	private int k;

	public CoeficienteBin(int i, int j) {
		this.n = i;
		this.k = j;
	}

	public int coefBinomialProgDinam () {
		int [][] tabla = new int [this.n + 1][this.k + 1];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				if (j == 0 || j == i) {
				tabla[i][j] = 1;
				} else if (j > i){
					tabla [i][j] = 0;
				} else {
					tabla[i][j] = coefBinomialProgDinam(i - 1, j - 1) + coefBinomialProgDinam(i - 1, j);
				}
			}
		}
		return tabla [this.n][this.k];
	}

	private int coefBinomialProgDinam (int n, int k) {
		int [][] tabla = new int [n + 1][k + 1];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				if (j == 0 || j == i) {
				tabla[i][j] = 1;
				} else if (j > i){
					tabla [i][j] = 0;
				} else {
					tabla[i][j] = coefBinomialProgDinam(i - 1, j - 1) + coefBinomialProgDinam(i - 1, j);
				}
			}
		}
		return tabla [n][k];
	}
	public static int coefBinomialProgDinam(CoeficienteBin coef) {
		int n = coef.getN();
		int k = coef.getK();
		int[][] tabla = new int[n + 1][k + 1];
		if ((k == 0) || (k == n)) return 1;
		if ((k > n) || (n == 0)) return 0;
		for (int i = 0; i < n + 1; i++) {
			tabla[i][0] = 1;
		}
		for (int j = 1; j < k + 1; j++) {
				tabla[1][j] = 0;
		}
		for (int r = 1; r < n + 1; r++) {
			for (int s = 1; s < k + 1; s++) {
				tabla[r][s] = tabla[r - 1][s - 1] + tabla[r - 1][s];
			}
		}
		return tabla[n][k];
	}
	public double coefBinomialRecursivo() {
		if (this.k == 0 || this.k == n) {
			return 1.0;	
			} else if (this.k > 0 && this.n > this.k) {
					return coefBinomialRecursivo(this.n - 1, this.k - 1) + coefBinomialRecursivo(this.n - 1, this.k);
				} else {
					return 0.0;
				}
	}
	private double coefBinomialRecursivo(int n, int k) {
		if (k == 0 || k == n) {
			return 1.0;	
			} else if (k > 0 && n > k) {
				return coefBinomialRecursivo(n - 1, k - 1) + coefBinomialRecursivo(n - 1, k);
				} else {
					return 0.0;
				}
	}

	public void setN(int i) {
		this.n = i;		
	}
	public void setK(int i) {
		this.k = i;		
	}
	public int getK () {
		 return this.k;		
	}
	public int getN () {
		return this.n;		
	}
public static void main(String[] args) {
		
		double[] tiempo = new double[10]; //Recursivo
		double[] tiempo1 = new double[10]; //ProgDinam
		System.out.println("Este programa calcula el tiempo que tarda en calcularse el coeficiente binomial (2N)");
		System.out.println("\t\t\t\t\t\t\t\t\t\t( N)");
		int coeficiente;
		System.out.print("Introduzca el coeficiente (N): ");
		coeficiente = lector.nextInt();
		while (coeficiente < 0) {
			System.out.println("El coeficiente debe de ser mayor o igual que 0");
			System.out.print("Introduzca el coeficiente: ");
			coeficiente = lector.nextInt();
		}
		int tope;
		System.out.print("Introduzca el tope del coeficiente (el coeficiente aumenta en 1 mientras sea menor que el tope): ");
		tope = lector.nextInt();
		double start, end;
		double media = 0; //Recursivo
		double media1 = 0; //ProgDinan
		CoeficienteBin coef;
	
		while (coeficiente < tope) {
			coef = new CoeficienteBin(2*coeficiente, coeficiente);
			for (int i = 0; i < 10; i++) {
				start = System.nanoTime();
				coef.coefBinomialRecursivo();
				end = System.nanoTime();
				tiempo[i] = end - start;
			}
			Arrays.sort(tiempo);
			media = calcularMedia(tiempo);
			
			for (int i = 0; i < 10; i++) {
				start = System.nanoTime();
				coefBinomialProgDinam(coef);
				end = System.nanoTime();
				tiempo1[i] = end - start;
			}
			Arrays.sort(tiempo1);
			media1 = calcularMedia(tiempo1);
			
			
			System.out.println("La media de tiempo para el algoritmo recursivo con N = " + coeficiente + " es: " + media + "ns");
			System.out.println("La media de tiempo para el algoritmo de Programación dinámica con N = " + coeficiente + " es: " + media1 + "ns \n");
			
			coeficiente += 1;
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
