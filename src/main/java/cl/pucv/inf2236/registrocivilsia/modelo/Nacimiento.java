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
    
    public Nacimiento(int idActa, String lugarNacimiento, Persona inscrito, Persona progenitor1, Persona progenitor2){
        this.idActa = idActa;
        this.lugarNacimiento = lugarNacimiento;
        this.inscrito = inscrito;
        this.progenitor1 = progenitor1;
        this.progenitor2 = progenitor2;
        this.fechaInscripcion = LocalDate.now();
    }
}
