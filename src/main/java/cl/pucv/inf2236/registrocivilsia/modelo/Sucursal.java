/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabom
 */
public class Sucursal {
    private int idSucursal;
    private String nombre;
    private String ciudad;
    private String region;
    private List<Persona> personasRegistradas;
    
    public Sucursal(int idSucursal, String nombre, String ciudad, String region){
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.region = region;
        this.personasRegistradas = new ArrayList<>();
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
    public void agregarPersona(Persona persona){
        this.personasRegistradas.add(persona);
    }
    public void mostrarPersonasSucursal(){
        if(personasRegistradas.size() < 1){
            System.out.println("[No hay personas en la sucursal " + nombre + "]");
        }
        System.out.println("");
        System.out.println("[Sucursal " + nombre + "]");
        for(int i=0;i<personasRegistradas.size(); i++){
            System.out.println("[Persona " + (i+1) + "]");
            personasRegistradas.get(i).mostrar();
            System.out.println("");
        }
        System.out.println("");
    }
    public void mostrarSucursal(){
        System.out.println("Id sucursal: "+ idSucursal);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Ciudad: "+ ciudad);
        System.out.println("Region: "+ region);
    }
    public Persona getBuscarPersona(String rut){
        for(int i=0; i<personasRegistradas.size();i++){
            if(rut.equals(personasRegistradas.get(i).getRut())){
                return personasRegistradas.get(i);
            }
        }
        return null;
    }
}   
