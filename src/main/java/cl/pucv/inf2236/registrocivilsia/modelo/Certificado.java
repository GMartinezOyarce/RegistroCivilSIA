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
public class Certificado {
    private int idNacimiento;
    private String tipoCertificado;
    private LocalDate fechaEmision;
    private Persona personaAsociada;
    public Certificado(int idNacimiento, String tipoCertificado, Persona personaAsociada){
        this.idNacimiento = idNacimiento;
        this.tipoCertificado = tipoCertificado;
        this.personaAsociada = personaAsociada;
        this.fechaEmision = LocalDate.now();
    }
}
