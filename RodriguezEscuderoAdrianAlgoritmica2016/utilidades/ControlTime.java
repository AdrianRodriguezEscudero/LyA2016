//
//  ControlTime.java
//  
// Esta clase es un tipo de dato para medir el tiempo de ejecuci\'on de un programa
//
//
package org.lya.utilidades;

public class ControlTime {
	
	private final long start;
	
	/**
     * Crea el objeto.
     */
    public ControlTime() {
        start = System.currentTimeMillis();
    } 
	
	
	/**
     * @return tiempo trancurrido (en segundos) desde que el objeto fue creado.
     */
    public double finalTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
