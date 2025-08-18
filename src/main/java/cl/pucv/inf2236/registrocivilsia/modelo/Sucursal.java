/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia.modelo;

/**
 *
 * @author gabom
 */
public class Sucursal {
    private int idSucursal;
    private String nombre;
    private String ciudad;
    private String region;
    
    public class Sucursal(int idSucursal, String nombre, String ciudad, String region){
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.region = region;
    }
}
