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
    private Persona conyugue;
    private boolean estaViva;
    private Sucursal sucursalAsignada;
}
