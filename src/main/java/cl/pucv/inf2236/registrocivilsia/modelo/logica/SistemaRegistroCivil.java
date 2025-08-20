/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia.modelo.logica;


 // solo para poder ocupar las clases que se encuentran en la carpeta modelo
import cl.pucv.inf2236.registrocivilsia.modelo.Persona;
import cl.pucv.inf2236.registrocivilsia.modelo.Sucursal;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gabom
 */
public class SistemaRegistroCivil {
    private List<Sucursal> listaSucursales;
    private Map<String, Persona> mapPersonas;
    
    public SistemaRegistroCivil(){
        this.listaSucursales = new ArrayList<>();
        this.mapPersonas = new HashMap<>();
    }
    
    
    //getters // modificar esto y los demas getters para enviar una copia y no todo el dato. FLOJERAA COMPLETAAA!!!!
    public List<Sucursal> getListaSucursales(){
        return listaSucursales;
    }
    public Map<String,Persona> getMapPersonas(){
        return mapPersonas;
    }
    //setters creo que no se deberian implementar
    
    
    
    public void cargarDatosDePrueba(){
        //creo las sucursales en distintas ciudades
        Sucursal sucValparaiso = new Sucursal(1, "Oficina Valparaiso", "Valparaiso", "Valparaiso");
        Sucursal sucSanAntonio = new Sucursal(2, "Oficina San Antonio", "San Antonio", "Valparaiso");
        
        //añado las sucursales a el array listaSucursales
        this.listaSucursales.add(sucValparaiso);
        this.listaSucursales.add(sucSanAntonio);
        
        //creo las fechas de nacimiento de las personas
        LocalDate fechaNacimientoGabriel = LocalDate.of(2005,12,12);
        LocalDate fechaNacimientoRebeca = LocalDate.of(2004,02,04);
        LocalDate fechaNacimientoAdazme = LocalDate.of(1999,01,22);
        LocalDate fechaNacimientoFrecia = LocalDate.of(1980,02,19);
        
        //creo las personas
        Persona gabriel = new Persona("22007130-8","Gabriel",fechaNacimientoGabriel,sucSanAntonio);
        Persona rebeca = new Persona("21510429-k","Rebeca", fechaNacimientoRebeca,sucSanAntonio);
        Persona adazme = new Persona("20358720-3","Adazme", fechaNacimientoAdazme,sucValparaiso);
        Persona frecia = new Persona("19273189-9", "Frecia", fechaNacimientoFrecia, sucValparaiso);
        
        //agrego personas a Sucursales
        sucValparaiso.agregarPersona(adazme);
        sucValparaiso.agregarPersona(frecia);
        
        sucSanAntonio.agregarPersona(gabriel);
        sucSanAntonio.agregarPersona(rebeca);
        
        // agrego a las personas al hashmap ordenado por rut
        this.mapPersonas.put(gabriel.getRut(), gabriel);
        this.mapPersonas.put(rebeca.getRut(), rebeca);
        this.mapPersonas.put(adazme.getRut(), adazme);
        this.mapPersonas.put(frecia.getRut(), frecia);
    }
}
