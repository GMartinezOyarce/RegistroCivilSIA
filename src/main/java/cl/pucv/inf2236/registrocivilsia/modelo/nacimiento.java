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
public class Nacimiento {
    private int idActa;
    private LocalDate fechaInscripcion;
    private String lugarNacimiento;
    
    private Persona inscrito;
    private Persona progenitor1;
    private Persona progenitor2;
    
    //getters
    public int getIdActa(){
        return this.idActa;
    }
    public LocalDate getFechaInscripcion(){
        return this.fechaInscripcion;
    }
    public String getLugarNacimiento(){
        return this.lugarNacimiento;
    }
    public Persona getInscrito(){
        return this.inscrito;
    }
    public Persona getProgenitor1(){
        return this.progenitor1;
    }
    public Persona getProgenitor2(){
        return this.progenitor2;
    }
    
    //setters
    public void setProgenitor1(Persona progenitor1){
        this.progenitor1 = progenitor1;
    }
    public void setProgenitor2(Persona progenitor2){
        this.progenitor2 = progenitor2;
    }
}
