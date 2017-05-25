package org.lya.practica1.ejercicio1;
import java.util.*;

public class SumaTripletas {
	private static int count;
	private static Scanner lector = new Scanner(System.in);

	public static int tripletaSumCount(SecuenciaEnteros secuenciaProblema) {
		
		int[] vector;
		int num;
		//double start;
		//double end;
		vector = secuenciaProblema.getValoresSecuencia();
		num = secuenciaProblema.getNumElementos();
		
		int count = 0;
		//start = System.nanoTime();
		for (int i = 0; i < num;i++) {
			for (int j = i + 1; j < num;j++) {
				for (int k = j + 1; k < num; k++) {
					if (vector[i] + vector[j] + vector[k] ==0) {
						count++;
					}
				}
			}
		}
		//end = System.nanoTime();
		//double time = end-start;
		//System.out.println("Tiempo de ejecucion: " + time + "ns");
		return count;
	}
	public static String tripletasSumPrint (SecuenciaEnteros secuenciaProblema) {
		
		int[] vector;
		int num;
		String cadena = "";
		count = 0;
		//double start;
		//double end;
		vector = secuenciaProblema.getValoresSecuencia();
		num = secuenciaProblema.getNumElementos();
		
		
		//start = System.nanoTime();
		for (int i = 0; i < num;i++) {
			for (int j = i + 1; j < num;j++) {
				for (int k = j + 1; k < num; k++) {
					if (vector[i] + vector[j] + vector[k] == 0) {
						count++;
						cadena += vector[i] + "\t" + vector[j] + "\t" + vector[k] + "\n";
					}
				}
			}
		}
		//end = System.nanoTime();
		//double time = end-start;
	//	System.out.println("Tiempo de ejecucion: " + time + "ns");
		
		return cadena;
	}
	
	public static void main(String[] args) {
		
		SecuenciaEnteros secuencia;
		double[] tiempo = new double[10];
		int tamanno = 500;
		int rango = 50;
		double start, end;
		double media = 0;
		
		//Se repitir· hasta 16000.
		
		for (tamanno = 500; tamanno <= 16000; tamanno*=2) {
			int a = 0;
			System.out.print("Ver tripletas de tamaÒo " + tamanno + " pulse 1, ver el tiempo de ejecuciÛn pulse 2, para ver ambas cosas pulse 3: ");
			a = lector.nextInt();
			secuencia = new SecuenciaEnteros (tamanno,rango);
			if (a == 1 || a == 3) {
				tripletasSumPrint(secuencia);
				System.out.println("Se han encontrado " + count + "tripletas");
			}
			for (int i = 0; i < 10; i++) {
				start = System.nanoTime();
				SumaTripletas.tripletaSumCount(secuencia);
				end = System.nanoTime();
				tiempo[i] = end - start;
			}
			Arrays.sort(tiempo);
			media = calcularMedia(tiempo);
			if (a == 2 || a == 3) {
				System.out.println("La media de tiempo para tamaÒo = " + tamanno + " es: " + media + " ns");
			}
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