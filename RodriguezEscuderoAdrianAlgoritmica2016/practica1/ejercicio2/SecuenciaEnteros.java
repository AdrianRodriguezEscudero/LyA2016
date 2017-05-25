package org.lya.practica1.ejercicio2;

import org.lya.utilidades.*;

public class SecuenciaEnteros {
	
	private int numeroElementos;
	
	
	private int[] valoresSecuencia;


	public SecuenciaEnteros(int[] datos) {
		valoresSecuencia = datos;
		numeroElementos = datos.length;
	}

	public SecuenciaEnteros(int numElem, int rango) {
		valoresSecuencia = new int [numElem];
		numeroElementos = numElem;
						
		for (int i = 0; i < numeroElementos; i++) {
			if (Math.random() < 0.5) {
				valoresSecuencia[i] = 1;
			}else {
				valoresSecuencia[i] = -1;
			}
			valoresSecuencia[i] *= Math.random()*(rango + 1);
		}
	}


	public int[] getValoresSecuencia () {
		return valoresSecuencia;
	}
	public void setValoresSecuencia (int[] nuevoValor) {
		valoresSecuencia = nuevoValor;
	}	
	public int getNumElementos () {
		return numeroElementos;
	}
	public void setNumElementos (int numElem) {
		numeroElementos = numElem;
	}
}