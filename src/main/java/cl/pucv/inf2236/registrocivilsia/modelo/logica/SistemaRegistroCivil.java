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
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author gabom
 */
public class SistemaRegistroCivil {
    private List<Sucursal> listaSucursales;
    private List<Nacimiento> listaNacimiento;
    private List<Matrimonio> listaMatrimonio;
    private List<Defuncion> listaDefuncion; 
    private int idNacimiento = 0;
    private int idMatrimonio = 0;
    private int idDefuncion = 0;
    private Map<String, Persona> mapPersonas;
    
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
           
           progenitor1 = BusquedaPersona(rutProgenitor1);
           progenitor2 = BusquedaPersona(rutProgenitor2);
           
           /*otra forma
           if(progenitor1==null || progenitor2==null){
            System.out.println("Progenitor no encontrado");
            return;
           }
           */
           if(progenitor1==null){
            System.out.println("Primer progenitor no encontrado");
            return;
           }
           if(progenitor2==null){
            System.out.println("Segundo progenitor no encontrado");
            return;
           }
        
           
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
    
    
    public void registrarMatrimonio(int index, String rutConyuge1, String rutConyuge2){
        Persona conyuge1, conyuge2;
        Sucursal sucursal;
        sucursal = listaSucursales.get(index);
        conyuge1 = mapPersonas.get(rutConyuge1);
        conyuge2 = mapPersonas.get(rutConyuge2);
        
        conyuge1 = BusquedaPersona(rutConyuge1);
        conyuge2 = BusquedaPersona(rutConyuge2);
        
        /*
        Esto podria ser uno y solo Poner persona no encontrada
        pero creo que es mejor que sepan cual fallo
        pongo el otro caso para más comodida
        if(conyuge1==null || conyuge2==null){
            System.out.println("Conyuge no encontrado");
            return;
        }
        
        */
        if(conyuge1==null){
            System.out.println("Primer conyuge no encontrado");
            return;
        }
        if(conyuge2==null){
            System.out.println("Segundo conyuge no encontrado");
            return;
        }
        
        idMatrimonio++;
        Matrimonio nuevoMatri = new Matrimonio(idMatrimonio, conyuge1, conyuge2, sucursal);
        
        conyuge1.setConyuge(conyuge2);
        conyuge2.setConyuge(conyuge1);
           
        System.out.println("[Matrimonio registrado]");
        nuevoMatri.mostrar();
        System.out.println("");
           
        listaMatrimonio.add(nuevoMatri);
    }

    public void registrarDefuncion(int index, LocalDate fechaDefuncion, String Causa, String rutFallecido) {
        Persona fallecido;
        Sucursal sucursal;
        sucursal = listaSucursales.get(index);
        fallecido = mapPersonas.get(rutFallecido);
        
        fallecido = BusquedaPersona(rutFallecido);
        
        if(fallecido==null){
            System.out.println("Persona no encontrada");
            return;
        }
        
        idDefuncion++;
        Defuncion nuevoDefun = new Defuncion(idDefuncion, fechaDefuncion, Causa, fallecido, sucursal);
           
        System.out.println("[Defuncion registrada]");
        nuevoDefun.mostrar();
        System.out.println("");
        
        if(fallecido.getConyuge()!=null){
            fallecido.getConyuge().setEstadoCivil("Viuda/o");
        }
        listaDefuncion.add(nuevoDefun);
    }
    
    public Persona BusquedaPersona(String rutPers){
        for(Persona perso : mapPersonas.values()){
            if(rutPers.equals(perso.getRut())){
                return perso;
            }
        }
        return null;
    }
    
    
}
