package org.lya.practica1.ejercicio2;

import java.util.Arrays;

import org.lya.practica1.ejercicio1.SecuenciaEnteros;
import org.lya.practica1.ejercicio1.SumaTripletas;

public class Subsecuencia {
	
	private static int primer;
	private static int ultimo;
	private static int suma;
	
	
	public static void SubsecuenciaFuerzaBruta(SecuenciaEnteros secuenciaProblema) {
		
		int sumaMax = 0;
		int secIni = 0;
		int secFin = 0;
		int sumaActual;
		
		int [] a = secuenciaProblema.getValoresSecuencia();
		
		for(int i = 0; i < a.length; i++){
			
			for(int j = i; j < a.length; j++){
				
				sumaActual = 0;
				
				for(int k = i; k < a.length; k++){
					
					sumaActual = sumaActual + a[k];
					
					if(sumaActual > sumaMax){
						
						sumaMax = sumaActual;
						secIni = i;
						secFin = k;
						
					}
				}
			}
		}
		
		suma = sumaMax;
		primer = secIni;
		ultimo = secFin;
		
		
	}

	public static void SubsecuenciaMejorado(SecuenciaEnteros secuenciaProblema) {
		
		int sumaActual;
		int sumaMax = 0;
		int secIni = 0;
		int secFin = 0;
		int [] a = secuenciaProblema.getValoresSecuencia();
		
		for (int i = 0; i < a.length; i++){
			
			sumaActual = 0;
			
			for(int j = i; j < a.length; j++){
				
				sumaActual = sumaActual + a[j];
				
				if(sumaActual > sumaMax){
					
					sumaMax = sumaActual;
					secIni = i;
					secFin = j;
					
				}
			}
		}
		
		suma = sumaMax;
		primer = secIni;
		ultimo = secFin;
		
		
	}

	public static void SubsecuenciaLineal(SecuenciaEnteros secuenciaProblema) {
		
		int sumaMax = 0;
		int sumaActual = 0;
		int secIni = 0;
		int secFin = 0;
		int [] a = secuenciaProblema.getValoresSecuencia();
		
		for(int i = 0 , j = 0; j < a.length; j++){
			
			sumaActual += a[j];
			
			if(sumaActual > sumaMax){
				
				sumaMax = sumaActual;
				secIni = i;
				secFin = j;
				
			}else if(sumaActual < 0){
				
				i = j + 1;
				sumaActual = 0;
				
			}
		}
		
		suma = sumaMax;
		primer = secIni;
		ultimo =secFin;
		
		
	}
	
	public static int getSuma(){
		
		return suma;
		
	}
	
	public static int getPrimer(){
		
		return primer;
		
	}
	
	public static int getUltimo(){
		
		return ultimo;
		
	}
	
public static void main(String[] args) {
		
		SecuenciaEnteros secuencia ;
		double[] tiempo = new double[10];
		double[] tiempo1 = new double[10];
		double[] tiempo2 = new double[10];
		int tamanio = 500;
		int rango = 50;
		double start, end;
		double media = 0;
		double media1 = 0;
		double media2 = 0;
		
		//El for se va a repetir hasta 16000 que es lo que permite mi ordenador.
		
		for (tamanio = 500; tamanio <= 16000; tamanio*=2) {
			
			secuencia = new SecuenciaEnteros (tamanio,rango);
			
		for (int i = 0; i < 10; i++) {
			start = System.nanoTime();
			SubsecuenciaFuerzaBruta(secuencia);
			end = System.nanoTime();
			tiempo[i] = end - start;
		}
		Arrays.sort(tiempo);
		media = calcularMedia(tiempo);
		for (int i = 0; i < 10; i++){
			start = System.nanoTime();
			SubsecuenciaMejorado(secuencia);
			end = System.nanoTime();
			tiempo1[i] = end - start;
		}
		Arrays.sort(tiempo1);
		media1 = calcularMedia(tiempo1);
		for (int i = 0; i < 10; i++) {
			start = System.nanoTime();
			SubsecuenciaLineal(secuencia);
			end = System.nanoTime();
			tiempo2[i] = end - start;
		}
		Arrays.sort(tiempo2);
		media2 = calcularMedia(tiempo2);
		
		System.out.println("El tamaño del array: " + tamanio);
		System.out.println("La media de tiempo para Subsecuencia Fuerza Bruta es: " + media + " ns");
		System.out.println("La media de tiempo para Subsecuencia Mejorado es: " + media1 + " ns");
		System.out.println("La media de tiempo para Subsecuencia Lineal es: " + media2 + " ns");
		
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
