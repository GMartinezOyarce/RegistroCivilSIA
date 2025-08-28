/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia.modelo.logica;


 // solo para poder ocupar las clases que se encuentran en la carpeta modelo
import cl.pucv.inf2236.registrocivilsia.modelo.Defuncion;
import cl.pucv.inf2236.registrocivilsia.modelo.Matrimonio;
import cl.pucv.inf2236.registrocivilsia.modelo.Persona;
import cl.pucv.inf2236.registrocivilsia.modelo.Sucursal;
import cl.pucv.inf2236.registrocivilsia.modelo.Nacimiento;


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
    private List<Nacimiento> listaNacimiento;
    private List<Defuncion> listaDefuncion;
    private List<Matrimonio> listaMatrimonio;
    
    private Map<String, Persona> mapPersonas;
    
    //ID de listas
    private int idNacimiento = 0;
    
    public SistemaRegistroCivil(){
        this.listaSucursales = new ArrayList<>();
        this.listaNacimiento = new ArrayList<>();
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
    public void mostrarPersonasGlobal(){
        int num=0;
        System.out.println("");
        for(Persona p : mapPersonas.values()){
            System.out.println("[Persona " + (num+1) + "]");
            p.mostrar();
            System.out.println("");
            num++;
        }
    }
    public void registrarNacimiento(int index, LocalDate fechaInscripcion, LocalDate fechaNacimiento, String lugarNacimiento,String rutProgenitor1, String rutProgenitor2, String rutInscrito, String nombre){
           Persona nuevaPer = new Persona(rutInscrito,nombre,fechaNacimiento,listaSucursales.get(index));
           
           Persona progenitor1, progenitor2;
           progenitor1 = mapPersonas.get(rutProgenitor1);
           progenitor2 = mapPersonas.get(rutProgenitor2);
           
           idNacimiento++;
           Nacimiento nuevoNac = new Nacimiento(idNacimiento, fechaInscripcion, lugarNacimiento, nuevaPer, progenitor1, progenitor2, nuevaPer.getSucursal());
           
           System.out.println("[Persona ingresada]");
           nuevaPer.mostrar();
           System.out.println("");
           
           System.out.println("[Acta registrada]");
           nuevoNac.mostrar();
           System.out.println("");
           
           listaNacimiento.add(nuevoNac);
           mapPersonas.put(rutInscrito, nuevaPer);
    }
    public void mostrarNacimientosGlobal(){
        System.out.println("");
        if(listaNacimiento.size() == 0){
            System.out.println("[No hay registros de nacimientos]");
            return;
        }
        for(int i=0; i<listaNacimiento.size(); i++){
            System.out.println("Nacimiento numero #" + (i+1) + ":");
            listaNacimiento.get(i).mostrar();
            System.out.println("");
        }
        System.out.println("[Fin de registros nacimiento]");
    }
    
    public Persona buscarPersonaRut(String rut){
        for(Persona p: this.mapPersonas.values()){
            if(rut.equalsIgnoreCase(p.getRut())) {
                return p;
            }
            
        }
        return null;
    }
    
    public Nacimiento encontrarNacimiento(String rut){
        for(int i = 0; i < this.listaNacimiento.size(); i++){
            if(rut.equalsIgnoreCase(this.listaNacimiento.get(i).getInscrito().getRut())){
                return this.listaNacimiento.get(i);
            }
        }
            
        return null;
    }
    public Matrimonio encontrarMatrimonio(String rut){
        for(int i = 0; i < this.listaMatrimonio.size(); i++){
            //verifico cada uno de los conyugues
            if(rut.equalsIgnoreCase(this.listaMatrimonio.get(i).getConyuge1().getRut()) || rut.equalsIgnoreCase(this.listaMatrimonio.get(i).getConyuge2().getRut())){
                return this.listaMatrimonio.get(i);
            }
         }
        return null;
    }
    public Defuncion encontrarDefuncion(String rut){
        for(int i = 0; i < this.listaDefuncion.size(); i++){
            if(rut.equalsIgnoreCase(this.listaDefuncion.get(i).getFallecido().getRut())){
                return this. listaDefuncion.get(i);
            }
        }
        return null;
    }
}
