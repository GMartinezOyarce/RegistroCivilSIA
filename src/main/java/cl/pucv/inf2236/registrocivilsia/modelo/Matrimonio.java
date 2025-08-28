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
    

    
    //getters
    public int getIdMatrimonio(){
        return this.idMatrimonio;
    }
    public LocalDate getFechaMatrimonio(){
        return this.fechaMatrimonio;
    }
    public Persona getConyuge1(){
        return this.conyuge1;
    }
    public Persona getConyuge2(){
        return this.conyuge2;
    }
    public Sucursal getSucursal(){
        return this.sucursal;
    }
    
    //setters
    public void setIdMatrimonio(int idMatrimonio){
        this.idMatrimonio = idMatrimonio;
    }
    public void setFechaMatrimonio(LocalDate fechaMatrimonio){
        this.fechaMatrimonio = fechaMatrimonio;
    }
    public void setConyuge1(Persona conyuge1){
        this.conyuge1 = conyuge1;
    }
    public void setConyuge2(Persona conyuge2){
        this.conyuge2 = conyuge2;
    }
    public void setSucursal(Sucursal sucursal){
        this.sucursal = sucursal;
    }
    public String generarCertificado() {
    String textoCertificado = String.format(
        "--- CERTIFICADO DE MATRIMONIO ---\n" +
        "Se certifica que con fecha %s, contrajeron matrimonio:\n\n" +
        "Contrayente 1:\n" +
        "  Nombre: %s\n" +
        "  RUT: %s\n\n" +
        "Contrayente 2:\n" +
        "  Nombre: %s\n" +
        "  RUT: %s\n" +
        "---------------------------------",
        this.fechaMatrimonio,
        this.conyuge1.getNombre(),
        this.conyuge1.getRut(),
        this.conyuge2.getNombre(),
        this.conyuge2.getRut()
    );
    return textoCertificado;
    }
}
