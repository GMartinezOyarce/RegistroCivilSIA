/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia.modelo;

import java.time.LocalDate;

/**
 *
 * @author gabom
 */


        
public class Matrimonio {
    private int idMatrimonio;
    private LocalDate fechaMatrimonio;
    private Persona conyuge1;
    private Persona conyuge2;
    private Sucursal sucursal;
    
    public Matrimonio(int idMatrimonio, Persona conyuge1, Persona conyuge2, Sucursal sucursal){
        this.idMatrimonio = idMatrimonio;
        this.conyuge1 = conyuge1;
        this.conyuge2 = conyuge2;
        this.sucursal = sucursal;
        this.fechaMatrimonio = LocalDate.now();    
    }
    
    
}
