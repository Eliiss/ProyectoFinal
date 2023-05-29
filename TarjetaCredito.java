
package com.mycompany.javaeat;
 
import java.io.Serializable;
import java.time.LocalDate;


public class TarjetaCredito implements Serializable {
    
    private String titular;
    private long numero;
    private LocalDate fechaCaducidad; 
    
    
    public TarjetaCredito(String titular, long numero, LocalDate fechaCaducidad){
        
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("Debe introducir el nombre del titular");
        }
        
        if(String.valueOf(numero).length()!= 16) {
            
            throw new IllegalArgumentException("Número de tarjeta inválido");
        }
        
        if (fechaCaducidad.isBefore(LocalDate.now())) {
            
            throw new IllegalArgumentException("Fecha de caducidad inválida.");
        } 
       this.titular = titular;
       this.numero = numero;
       this.fechaCaducidad = fechaCaducidad; 
          
        
    }
        
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
}
