package org.lya.practica1.ejercicio1;

public class Subsecuencia {

	private static int suma;
	private static int primer;
	private static int ultimo;
	
	
	public static int getSuma() {
		return suma;
	}
	
	public static int getPrimer() {
		return primer;
	}
	
	public static int getUltimo() {
		return ultimo;
	}

	public static void SubsecuenciaFuerzaBruta(
				SecuenciaEnteros secuenciaProblema) {
		suma = 0;
		primer = 0;
		ultimo = 0;
		for (int i=0; i<secuenciaProblema.getValoresSecuencia().length; i++) {
			for (int j=i; j<secuenciaProblema.getValoresSecuencia().length; j++) {
				int sumaAux = 0;
				for (int k=i; k<=j; k++) {
					sumaAux = sumaAux + secuenciaProblema.getValoresSecuencia()[k];
				}
				if (sumaAux > suma) {
					suma = sumaAux;
					primer = i;
					ultimo = j;
				}
			}
		}		
	}

	public static void SubsecuenciaMejorado(SecuenciaEnteros secuenciaProblema) {
		suma = 0;
		primer = 0;
		ultimo = 0;
		for (int i=0; i<secuenciaProblema.getValoresSecuencia().length; i++) {
			int sumaAux = 0;
			for (int j=i; j<secuenciaProblema.getValoresSecuencia().length; j++) {
				sumaAux = sumaAux + secuenciaProblema.getValoresSecuencia()[j];
				if (sumaAux > suma) {
					suma = sumaAux;
					primer = i;
					ultimo = j;
				}
			}
		}
	}

	public static void SubsecuenciaLineal(SecuenciaEnteros secuenciaProblema) {
		suma = 0;
		primer = 0;
		ultimo = 0;
		int sumaAux = 0;
		int inicio = 0;
		for (int i=0; i<secuenciaProblema.getValoresSecuencia().length; i++) {
			sumaAux = sumaAux + secuenciaProblema.getValoresSecuencia()[i];
			if (sumaAux > suma) {
				suma = sumaAux;
				primer = inicio;
				ultimo = i;
			}
			else {
				if (sumaAux < 0) {
					sumaAux = 0;
					inicio = i+1;
				}
			}
		}		
	}
	
	public static void main(String[] args) {	
		double tiempoTotal, tiempoMedioFB, tiempoMedioM, tiempoMedioL, suma;
		double []tiempos;
		
		System.out.println("     N      T(N) FuerzaBruta      T(N) Mejorado        T(N) Lineal");
		for (int n=500; n<=32000; n=n*2) {	
			
			SecuenciaEnteros ts = new SecuenciaEnteros(n,50);
			tiempos = new double [10];
			
			//REPETIR 10 veces:
			for (int i=0; i<tiempos.length; i++) {
				//ControlTime tim = new ControlTime();
				long tiempoAntes = System.nanoTime();
				Subsecuencia.SubsecuenciaFuerzaBruta(ts);
				//tiempoTotal = tim.finalTime();
				long tiempoDespues = System.nanoTime();
				tiempoTotal = tiempoDespues - tiempoAntes;
				tiempos[i] = tiempoTotal;
			}
			//Calcular TIEMPO MEDIO		
		    suma = 0;
		    for (int i=0; i<tiempos.length; i++)
		    	suma = suma + tiempos[i];
			tiempoMedioFB = suma / tiempos.length;
			
			//REPETIR 10 veces:
			for (int i=0; i<tiempos.length; i++) {
				//ControlTime tim = new ControlTime();
				long tiempoAntes = System.nanoTime();
				Subsecuencia.SubsecuenciaMejorado(ts);
				//tiempoTotal = tim.finalTime();
				long tiempoDespues = System.nanoTime();
				tiempoTotal = tiempoDespues - tiempoAntes;
				tiempos[i] = tiempoTotal;
			}
			//Calcular TIEMPO MEDIO		
		    suma = 0;
		    for (int i=0; i<tiempos.length; i++)
		    	suma = suma + tiempos[i];
			tiempoMedioM = suma / tiempos.length;
			
			//REPETIR 10 veces:
			for (int i=0; i<tiempos.length; i++) {
				//ControlTime tim = new ControlTime();
				long tiempoAntes = System.nanoTime();
				Subsecuencia.SubsecuenciaLineal(ts);
				//tiempoTotal = tim.finalTime();
				long tiempoDespues = System.nanoTime();
				tiempoTotal = tiempoDespues - tiempoAntes;
				tiempos[i] = tiempoTotal;
			}
			//Calcular TIEMPO MEDIO		
		    suma = 0;
		    for (int i=0; i<tiempos.length; i++)
		    	suma = suma + tiempos[i];
			tiempoMedioL = suma / tiempos.length;
				
			//IMPRIMIR RESULTADO:
			System.out.printf(" %5d %21.2f %18.2f %18.2f\n", n, 
					tiempoMedioFB, tiempoMedioM, tiempoMedioL);
	
		}
		
	}
}
