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
import java.sql.*;

/**
 *
 * @author gabom
 */
public class SistemaRegistroCivil {
    // listas 
    private List<Sucursal> listaSucursales;
    private List<Nacimiento> listaNacimiento;
    private List<Matrimonio> listaMatrimonio;
    private List<Defuncion> listaDefuncion; 
    //mapa
    private Map<String, Persona> mapPersonas;
    
    //ID de listas
    private int idNacimiento = 0;
    private int idMatrimonio = 0;
    private int idDefuncion = 0;
    
    // url Base de datos
    private String urlBD = "jdbc:sqlite:registrocivil.db";
    
    public SistemaRegistroCivil(){
        this.listaSucursales = new ArrayList<>();
        this.listaNacimiento = new ArrayList<>();
        this.listaMatrimonio = new ArrayList<>();
        this.listaDefuncion = new ArrayList<>();
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
        // ocupo el try-catch para poder asegurar la conexion
        try(Connection conn = DriverManager.getConnection(urlBD);
                  Statement query = conn.createStatement()){
                  System.out.println("Conectado a la base de datos. Cargando Informacion....");
            
                  //---------Cargo datos de la tabla sucursales----------- 
                  String sqlSucursales ="SELECT * FROM sucursales";
                  ResultSet tablaSucursales = query.executeQuery(sqlSucursales);
            
                  while(tablaSucursales.next()){
                           //Leo los datos por cada fila
                           int id = tablaSucursales.getInt("id_sucursal");
                           String nombre = tablaSucursales.getString("nombre");
                           String ciudad = tablaSucursales.getString("ciudad");
                           String region = tablaSucursales.getString("region");
                
                           //creo el objeto sucursal
                           Sucursal sucursal = new Sucursal(id, nombre, ciudad, region);
                
                            this.listaSucursales.add(sucursal);
                  }
             
                  // -------------Cargo datos de la tabla personas------------
                  String sqlPersonas = "SELECT * FROM personas";
                  ResultSet tablaPersonas = query.executeQuery(sqlPersonas);
            
                  while(tablaPersonas.next()){
                           String rut = tablaPersonas.getString("rut");
                           String nombre = tablaPersonas.getString("nombre");
                           LocalDate fechaNacimiento = LocalDate.parse(tablaPersonas.getString("fecha_nacimiento"));
                
                           int sucursalId = tablaPersonas.getInt("sucursal_id");
                    
                           Sucursal sucursalAsignada = null;
                           for(Sucursal s : this.listaSucursales){
                                   if (s.getIdSucursal() == sucursalId){
                                   sucursalAsignada = s;
                                   }
                           }
                           // Creo el objeto Persona con la relacion establecida
                
                           Persona persona = new Persona(rut,nombre, fechaNacimiento, sucursalAsignada);
                           persona.setEstadoCivil(tablaPersonas.getString("estado_civil"));
                           persona.setEstaViva(tablaPersonas.getInt("esta_viva") == 1);
                
                           this.mapPersonas.put(rut, persona);
                
                           if(sucursalAsignada != null){
                                    sucursalAsignada.agregarPersona(persona);                   
                           }
                  }
                  // Cargo las relaciones entre las personas
                  
                  tablaPersonas = query.executeQuery(sqlPersonas);
                  while(tablaPersonas.next()){
                           String rutActual = tablaPersonas.getString("rut");
                           String rutConyuge = tablaPersonas.getString("conyuge_rut");
                           
                           if(rutActual != null && rutConyuge != null){
                                   Persona personaActual = this.mapPersonas.get(rutActual);
                                   Persona conyuge = this.mapPersonas.get(rutConyuge);
                                   
                                   if(personaActual != null && conyuge != null){
                                            personaActual.setConyuge(conyuge);
                                   }                           
                           }         
                  }
                  
                  System.out.println("Personas Cargadas y relaciones establecidas");
                  
                  
                  //Cargo nacimientos
                  String sqlNacimiento = "SELECT * FROM nacimientos";
                  ResultSet tablaNacimientos = query.executeQuery(sqlNacimiento);
                  
                  while(tablaNacimientos.next()){
                          int idActa =tablaNacimientos.getInt("id_acta");
                          LocalDate fechaNacimiento = LocalDate.parse(tablaNacimientos.getString("fecha_inscripcion"));
                          String lugarNacimiento =tablaNacimientos.getString("lugar_nacimiento");
                          String inscritoRut = tablaNacimientos.getString("inscrito_rut");
                          String progenitor1Rut = tablaNacimientos.getString("progenitor1_rut");
                          String progenitor2Rut = tablaNacimientos.getString("progenitor2_rut");
                          int sucursalId = tablaNacimientos.getInt("sucursal_id");
                          
                          Persona inscrito = this.mapPersonas.get(inscritoRut);
                          Persona progenitor1 = this.mapPersonas.get(progenitor1Rut);
                          Persona progenitor2 = this.mapPersonas.get(progenitor2Rut);
                          
                          Sucursal sucursalAsignada = null;
                          for(Sucursal s: this.listaSucursales){
                                   if(s.getIdSucursal() == sucursalId){
                                            sucursalAsignada = s;
                                            break;
                                   }
                          }
                          
                          if(inscrito != null && progenitor1 != null && progenitor2 != null && sucursalAsignada != null){
                                   Nacimiento nacimiento = new Nacimiento(idActa, fechaNacimiento, lugarNacimiento, inscrito, progenitor1, progenitor2, sucursalAsignada);
                                   this.listaNacimiento.add(nacimiento);
                          }       
                  
                  }
                  
                  //Cargo Matrimonios
                  String sqlMatrimonios = "SELECT * FROM matrimonios";
                  ResultSet tablaMatrimonios = query.executeQuery(sqlMatrimonios);
    
                  while (tablaMatrimonios.next()) {
                           int idMatrimonio = tablaMatrimonios.getInt("id_matrimonio");
                           String rut1 = tablaMatrimonios.getString("contrayente1_rut");
                           String rut2 = tablaMatrimonios.getString("contrayente2_rut");
                           int sucursalId = tablaMatrimonios.getInt("sucursal_id");
    
                           // 2. BUSCA los objetos Persona y Sucursal correspondientes en las listas que ya cargamos
                           Persona p1 = this.mapPersonas.get(rut1);
                           Persona p2 = this.mapPersonas.get(rut2);
                           Sucursal sucursalAsignada = null;
                          
                           for(Sucursal s: this.listaSucursales){
                                   if(s.getIdSucursal() == sucursalId){
                                            sucursalAsignada = s;
                                            break;
                                   }
                          }
                          if (p1 != null && p2 != null && sucursalAsignada != null) {
                                   Matrimonio mat = new Matrimonio(idMatrimonio, p1, p2, sucursalAsignada); 
                                   this.listaMatrimonio.add(mat);
                           }       
                  }
                  
                  //Cargo Defunciones
                  String sqlDefunciones = "SELECT * FROM defunciones";
                  ResultSet tablaDefunciones = query.executeQuery(sqlDefunciones);

                  while (tablaDefunciones.next()) {
                           // 1. Lee los datos del acta de defunción
                           int idActa = tablaDefunciones.getInt("id_acta");
                           LocalDate fecha = LocalDate.parse(tablaDefunciones.getString("fecha_defuncion"));
                           String causa = tablaDefunciones.getString("causa");
                           String fallecidoRut = tablaDefunciones.getString("fallecido_rut");
                           int sucursalId = tablaDefunciones.getInt("sucursal_id");
    
                           // 2. BUSCA los objetos Persona y Sucursal en tus colecciones en memoria
                           Persona fallecido = this.mapPersonas.get(fallecidoRut);
                           Sucursal sucursalAsignada = null;
                          
                           for(Sucursal s: this.listaSucursales){
                                   if(s.getIdSucursal() == sucursalId){
                                            sucursalAsignada = s;
                                            break;
                                   }        
                          }
    
                           // 3. Si todos los objetos relacionados existen, crea el objeto Defuncion
                           if (fallecido != null && sucursalAsignada != null) {
                           Defuncion def = new Defuncion(idActa, fecha, causa, fallecido, sucursalAsignada); 
                            this.listaDefuncion.add(def);
                           }
                  }
                  
                  
        } catch (SQLException e){
            System.out.println("Error al cargar la base de datos: " + e.getMessage());
        }
           
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
    public void registrarNacimiento(int index, LocalDate fechaNacimiento, String lugarNacimiento,String rutProgenitor1, String rutProgenitor2, String rutInscrito, String nombre){
           Persona nuevaPer = new Persona(rutInscrito,nombre,fechaNacimiento,listaSucursales.get(index));
           
           Persona progenitor1, progenitor2;
           
           progenitor1 = busquedaPersona(rutProgenitor1);
           progenitor2 = busquedaPersona(rutProgenitor2);
           
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
        
           
           this.idNacimiento++;
           Nacimiento nuevoNac = new Nacimiento(this.idNacimiento,fechaNacimiento, lugarNacimiento, nuevaPer, progenitor1, progenitor2, nuevaPer.getSucursal());
           
           
           System.out.println("[Persona ingresada]");
           nuevaPer.mostrar();
           System.out.println("");
           
           System.out.println("[Acta registrada]");
           nuevoNac.mostrar();
           System.out.println("");
           
           this.listaSucursales.get(index).agregarPersona(nuevaPer);
           this.listaNacimiento.add(nuevoNac);
           mapPersonas.put(rutInscrito, nuevaPer);
           
           
    }
    public void mostrarNacimientosGlobal(){
        System.out.println("");
        if(listaNacimiento.isEmpty()){
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
        
        conyuge1 = busquedaPersona(rutConyuge1);
        conyuge2 = busquedaPersona(rutConyuge2);
        
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
        conyuge1.setEstadoCivil("");
        
        conyuge2.setConyuge(conyuge1);
        conyuge2.setEstadoCivil("");
        
           
        System.out.println("[Matrimonio registrado]");
        nuevoMatri.mostrar();
        System.out.println("");
           
        this.listaMatrimonio.add(nuevoMatri);
    }

    public void registrarDefuncion(int index, LocalDate fechaDefuncion, String Causa, String rutFallecido) {
        Persona fallecido;
        Sucursal sucursal;
        sucursal = listaSucursales.get(index);
        
        fallecido = busquedaPersona(rutFallecido);
        
        if(fallecido==null){
            System.out.println("Persona no encontrada");
            return;
        }
        
        this.idDefuncion++;
        Defuncion nuevoDefun = new Defuncion(this.idDefuncion, fechaDefuncion, Causa, fallecido, sucursal);
           
        System.out.println("[Defuncion registrada]");
        nuevoDefun.mostrar();
        System.out.println("");
        
        if(fallecido.getConyuge()!=null){
            fallecido.getConyuge().setEstadoCivil("Viuda/o");
        }
        fallecido.setEstaViva();
        listaDefuncion.add(nuevoDefun);
    }
    
    public Persona busquedaPersona(String rutPers){
        for(Persona perso : mapPersonas.values()){
            if(rutPers.equals(perso.getRut())){
                return perso;
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
    
    public boolean agregarSucursal(int idSucursal, String nombre, String ciudad, String region){
        for(int i=0; i<listaSucursales.size();i++){
            if(listaSucursales.get(i).getIdSucursal()==idSucursal){
                return false;
            }
        }
        
        Sucursal newSur=new Sucursal(idSucursal, nombre, ciudad, region);
        listaSucursales.add(newSur);
        return true;
    }
    public boolean modificarSucursal(int idSucursal, String nombre, String ciudad, String region){
        for(int i=0; i<listaSucursales.size();i++){
            if(listaSucursales.get(i).getIdSucursal()==idSucursal){
                listaSucursales.get(i).setCiudad(ciudad);
                listaSucursales.get(i).setNombre(nombre);
                listaSucursales.get(i).setRegion(region);
                
                System.out.println("[Sucursal modificada]");
                listaSucursales.get(i).mostrarSucursal();
                System.out.println("");
                
                return true;
            }
        }
        return false;
    }
    public boolean eliminarSucursal(int idSucursal){
        for(int i=0; i<listaSucursales.size();i++){
            if(listaSucursales.get(i).getIdSucursal()==idSucursal){
                listaSucursales.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean buscarSucursal(int idSucursal){
        for(int i=0; i<listaSucursales.size();i++){
            if(listaSucursales.get(i).getIdSucursal()==idSucursal){
                System.out.println("[Sucursal encontrada]");
                listaSucursales.get(i).mostrarSucursal();
                return true;
            }
        }
        return false;
    }
    public void listarSucursales(){
        boolean haySucursales=false;
        for(int i=0; i<listaSucursales.size();i++){
            
            System.out.println("[Sucursal #"+ (i+1) +"]");
            listaSucursales.get(i).mostrarSucursal();
            System.out.println("");
            if(haySucursales==false){
                haySucursales=true;
            }
        }
        if(haySucursales==false)
            System.out.println("[No hay sucursales]");
        
    }
    public boolean buscarMostrarPersonaEnSucursal(int idSucursal, String rut){
        Persona target;
        
        for(int i=0; i<listaSucursales.size();i++){
            if(listaSucursales.get(i).getIdSucursal()==idSucursal){
                target=listaSucursales.get(i).getBuscarPersona(rut);
                if(target != null){
                    System.out.println("[Persona encontrada]");
                    target.mostrar();
                    System.out.println("");
                    return true;
                }
            }
        }
        return false;
    }
}
