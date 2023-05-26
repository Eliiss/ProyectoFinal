
package com.mycompany.javaeat;

public enum TipoUsuario {
    ADMINISTRADOR,
    CLIENTE_PARTICULAR,
    EMPRESA;
    
    public boolean esClienteParticular(){
        return this == CLIENTE_PARTICULAR; 
    }
    public boolean esEmpresa (){
        return this == EMPRESA ; 
    }
}
