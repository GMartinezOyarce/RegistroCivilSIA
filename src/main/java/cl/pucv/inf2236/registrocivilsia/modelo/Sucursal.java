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
    
    public Sucursal(int idSucursal, String nombre, String ciudad, String region){
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.region = region;
    }
    //getters 
    public int getIdSucursal(){
        return this.idSucursal;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public String getRegion(){
        return this.region;
    }
    
    //setters
    public void setIdSucursal(int idSucursal){
        this.idSucursal = idSucursal;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCiudad(String ciudad){
        this.ciudad= ciudad;
    }
    public void setRegion(String region){
        this.region = region;
    }
    
    //metodos que se quieran implementar
}
