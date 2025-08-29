/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia.modelo;

import java.time.LocalDate;

/**
 *
 * @author gabom (Esto me recuerda que Jayce de arcane firmaba todo lo que era suyo Xd)
 */
public class Defuncion {
    private int idActa;
    private LocalDate fechaDefuncion;
    private String causa;
    private Persona fallecido; 
    private Sucursal sucursal;
    
    public Defuncion(int idActa, LocalDate fecha, String causa, Persona fallecido, Sucursal sucursal) {
        this.idActa = idActa;
        this.fechaDefuncion = fecha;
        this.causa = causa;
        this.fallecido = fallecido;
        this.sucursal = sucursal;
    }
    
    
    //getters
    public int getIdActa(){
        return this.idActa;
    }
    public LocalDate getFechaDefuncion(){
        return this.fechaDefuncion;
    }
    public String getCausa(){
        return this.causa;
    }
    public Persona getFallecido(){
        return this.fallecido;
    }
    public Sucursal getSucursal(){
        return this.sucursal;
    }
    
    //setters
    public void setIdActa(int idActa){
        this.idActa = idActa;
    }
    public void setFechaDefuncion(LocalDate fechaDefuncion){
        this.fechaDefuncion = fechaDefuncion;
    }
    public void setCausa(String causa){
        this.causa = causa;
    }
    public void setFallecido(Persona fallecido){
        this.fallecido = fallecido;
    }
    public void setSucursal(Persona fallecido){
        this.sucursal = sucursal;
    }

    public void mostrar(){
        System.out.println("Id acta: " + idActa);
        System.out.println("Nombre Del Fallecido" + fallecido.getNombre());
        System.out.println("Fecha Defuncion: " + fechaDefuncion);
        System.out.println("Razon De La Defuncion" + causa);
        //Creo que no necesita if, igual si es que necesita me escriben para cambiarlo
    }
}
