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
public class Defuncion {
    private int idActa;
    private LocalDate fechaDefuncion;
    private String causa;
    private Persona fallecido; 
    
    public Defuncion(LocalDate fecha, String causa, Persona fallecido) {
        this.fechaDefuncion = fecha;
        this.causa = causa;
        this.fallecido = fallecido;
    }
}
