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
    private LocalDate fechaNacimiento;
    private LocalDate fechaInscripcion;
    private String lugarNacimiento;
    private Sucursal sucursalAsignada;
    
    private Persona inscrito;
    private Persona progenitor1;
    private Persona progenitor2;

    public Nacimiento(int idActa, LocalDate fechaNacimiento,String lugarNacimiento, Persona inscrito, Persona progenitor1, Persona progenitor2, Sucursal sucursalAsignada) {
        this.idActa = idActa;
        this.lugarNacimiento = lugarNacimiento;
        this.inscrito = inscrito;
        this.progenitor1 = progenitor1;
        this.progenitor2 = progenitor2;
        this.sucursalAsignada = sucursalAsignada;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = LocalDate.now();
    }
    public Nacimiento(LocalDate fechaNacimiento,String lugarNacimiento, Persona inscrito, Persona progenitor1, Persona progenitor2, Sucursal sucursalAsignada) {
        this.lugarNacimiento = lugarNacimiento;
        this.inscrito = inscrito;
        this.progenitor1 = progenitor1;
        this.progenitor2 = progenitor2;
        this.sucursalAsignada = sucursalAsignada;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = LocalDate.now();
    }
    
    public void mostrar(){
        System.out.println("Id acta: " + idActa);
        System.out.println("Fecha inscripcion: " + fechaInscripcion);
        System.out.println("Sucursal asignada: " + sucursalAsignada.getNombre());
        System.out.println("Nombre Inscrito: " + inscrito.getNombre());
        System.out.println("Rut Inscrito: " + inscrito.getRut());
        if(progenitor1 == null){
            System.out.println("[Progenitor 1 desconosido]");
        }
        else{
            System.out.println("Nombre Progenitor 1: " + progenitor1.getNombre());
            System.out.println("Rut Progenitor 1: " + progenitor1.getRut());
        }
        if(progenitor2 == null){
            System.out.println("[Progenitor 2 desconosido]");
        }
        else{
            System.out.println("Nombre Progenitor 2: " + progenitor2.getNombre());
            System.out.println("Rut Progenitor 2: " + progenitor2.getRut());
        }
    }
    
    //getters
    public int getIdActa(){
        return this.idActa;
    }
    
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;    
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
    public Sucursal getSucursalAsignada() {
        return sucursalAsignada;
    }
    
    //setters
    public void setProgenitor1(Persona progenitor1){
        this.progenitor1 = progenitor1;
    }
    public void setProgenitor2(Persona progenitor2){
        this.progenitor2 = progenitor2;
    }

    public void setIdActa(int idActa) {
        this.idActa = idActa;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public void setInscrito(Persona inscrito) {
        this.inscrito = inscrito;
    }

    public void setSucursalAsignada(Sucursal sucursalAsignada) {
        this.sucursalAsignada = sucursalAsignada;
    }
    
    //Metodos
    
    public String generarCertificado(){
        String certificado = String.format(
        "--- CERTIFICADO DE NACIMIENTO ---\n" +
        "Se certifica que con fecha %s, fue inscrito(a):\n\n" +
         "Nacido el dia de :" +  
        "Nombre: %s\n" +
        "RUT: %s\n\n" +
        "Lugar de Nacimiento: %s\n" +
        "Progenitor 1: %s\n" +
        "Progenitor 2: %s\n" +
        "---------------------------------",
        this.fechaInscripcion,
        this.fechaNacimiento,
        this.inscrito.getNombre(),
        this.inscrito.getRut(),
        this.lugarNacimiento,
        this.progenitor1.getNombre(),
        this.progenitor2.getNombre()
    );
    return certificado;
        
    }
    
}
