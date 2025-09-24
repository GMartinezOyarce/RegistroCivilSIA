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
public class Persona {
    private String rut;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String estadoCivil;
    private Persona conyuge;
    private boolean estaViva;
    private Sucursal sucursalAsignada;
    
    
    // es el mejor constructor que pude pensar con lo poco que se.(G)
    public Persona(String rut, String nombre, LocalDate fechaNacimiento, Sucursal sucursalAsignada) {
       this.rut = rut;
       this.nombre = nombre;
       this.fechaNacimiento = fechaNacimiento;
       this.sucursalAsignada = sucursalAsignada;
       this.estadoCivil = "Soltero/a"; 
       this.estaViva = true;          
       this.conyuge = null;           
    }
    
    //getters 
    public String getRut(){
        return this.rut;
    }
    public String getNombre(){
        return this.nombre;
    }
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public String getEstadoCivil(){
        return this.estadoCivil;
    }
 
    public Persona getConyuge(){
        return this.conyuge;
    }
    public boolean getEstaViva(){
        return this.estaViva;
    }
    public Sucursal getSucursal(){
        return this.sucursalAsignada;
    }
    
     //setters 
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
    public void setEstadoCivil(){
        this.estadoCivil = "Casado/a";
    }
    
    public void setConyuge(Persona conyuge){
        this.conyuge = conyuge;
    }
    public void setEstaViva(boolean estaViva){
        this.estaViva = estaViva;
    }
    public void setEstaViva(){
        this.estaViva = false;
    }
    public void setSucursal(Sucursal sucursalAsignada){
        this.sucursalAsignada = sucursalAsignada;
    }
    
    //metodos
    public void mostrar(){
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Estado Civil: " + estadoCivil);
        if(conyuge != null){
            System.out.println("Rut conyuge: " + conyuge.getRut());
        }
        if(estaViva == true){
            System.out.println("Estado: Vivo/a");
        }
        else{
            System.out.println("Estado: Difunto/a");
        }
        System.out.println("Sucursal: " + sucursalAsignada.getNombre());        
    }
}
