/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.pucv.inf2236.registrocivilsia;

//importacion de clases
import cl.pucv.inf2236.registrocivilsia.modelo.Sucursal;
import cl.pucv.inf2236.registrocivilsia.modelo.logica.SistemaRegistroCivil;

//importacion de librerias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
//import java.util.List;

/**
 *
 * @author gabo
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //variables que use (no sabia donde dejarlas) ATTE: cris
        int index = 0, año, mes, dia;
        
        //variables Nacimiento ATTE: cris
        LocalDate fechaInscripcion, fechaNacimiento;
        String lugarNacimiento, rutProgenitor1, rutProgenitor2, rutInscrito, nombre;    
        
        
        //variables Matrimonio ATTE: yayo
        LocalDate fechaMatrimonio;
        String rutConyuge1, rutConyuge2;
        
        //variables Defuncion ATTE: yayo
        LocalDate fechaDefuncion;
        String rutFallecido, Causa;
        
        
        //inicializar lector y variable para leer datos;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        //String dato;
        
        //cargar Datos
        SistemaRegistroCivil sistema = new SistemaRegistroCivil();
        sistema.cargarDatosDePrueba();
        
        //variable booleana para poder terminar la ejecucion del programa
        boolean salir = false;
        
        System.out.println("---Bienvenido al sistema del registro civil---");
        
        while (!salir) {
            System.out.println("\n== MENÚ PRINCIPAL ==");
            System.out.println("1. Registrar Nacimiento");
            System.out.println("2. Registrar Matrimonio");
            System.out.println("3. Registrar Defunción");
            System.out.println("4. Emitir Certificado");
            System.out.println("5. Mostrar todas las Personas del sistema");
            System.out.println("6. Mostrar Personas por Sucursal");
            System.out.println("7. Mostrar todos los Nacimientos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    
                    // manejarRegistroNacimiento(scanner, sistema);
                    
                    
                    System.out.println("Seleccione Sucursal:");
                    
                    for(int i=0; i<sistema.getListaSucursales().size(); i++){
                        System.out.println((i+1) + ". " + sistema.getListaSucursales().get(i).getNombre());
                    }
                    index = Integer.parseInt(lector.readLine());
                    index--;
                    
                    
                    System.out.println("Ingrese año de inscripcion:");
                    año = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese mes de inscripcion:");
                    mes = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese dia de inscripcion:");
                    dia = Integer.parseInt(lector.readLine());
                    fechaInscripcion = LocalDate.of(año,mes,dia);
                    System.out.println("Ingrese lugar del nacimiento:");
                    lugarNacimiento = lector.readLine();
                    System.out.println("Ingrese el rut del primer progenitor del nacimiento:");
                    rutProgenitor1 = lector.readLine();
                    System.out.println("Ingrese el rut del segundo progenitor del nacimiento:");
                    rutProgenitor2 = lector.readLine();
                    System.out.println("Ingrese el rut del inscrito:");
                    rutInscrito = lector.readLine();
                    System.out.println("Ingrese el nombre del inscrito:");
                    nombre = lector.readLine();
                    System.out.println("Ingrese año de nacimiento:");
                    año = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese mes de nacimiento:");
                    mes = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese dia de nacimiento:");
                    dia = Integer.parseInt(lector.readLine());
                    fechaNacimiento = LocalDate.of(año,mes,dia);
                    
                    sistema.registrarNacimiento(index, fechaInscripcion, fechaNacimiento, lugarNacimiento, rutProgenitor1, rutProgenitor2, rutInscrito, nombre);
                    
                    break;
                case 2:
                    //manejarRegistroMatrimonio(scanner, sistema);
                    
                    //Creo que poner la sucursal primero es bueno por lo que lo copie
                    System.out.println("Seleccione Sucursal:");
                    
                    for(int i=0; i<sistema.getListaSucursales().size(); i++){
                        System.out.println((i+1) + ". " + sistema.getListaSucursales().get(i).getNombre());
                    }
                    index = Integer.parseInt(lector.readLine());
                    index--;
                    
                    //Fecha del Matrimonio
                    
                    System.out.println("Ingrese año del matrimonio:");
                    año = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese mes del matrimonio:");
                    mes = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese dia del matrimonio::");
                    dia = Integer.parseInt(lector.readLine());
                    fechaMatrimonio = LocalDate.of(año,mes,dia);
                    //me falta hacer el cambio en el archivo de matriomnio para que la fecha se llene desde aqui nomas

                    //Rut de las Personas
                    System.out.println("Ingrese el rut del primer Conyuge del Matrimonio:");
                    rutConyuge1 = lector.readLine();
                    System.out.println("Ingrese el rut del segundo Conyuge del Matrimonio:");
                    rutConyuge2 = lector.readLine();
                    
                    //Ingreso de Datos
                    sistema.registrarMatrimonio(index, fechaMatrimonio, rutConyuge1, rutConyuge2);
                    
                    
                    break;
                case 3:
                    // Lógica para registrar defunción
                    System.out.println("Ingrese año de la defuncion:");
                    año = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese mes de la defuncion:");
                    mes = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese dia de la defuncion:");
                    dia = Integer.parseInt(lector.readLine());
                    fechaDefuncion = LocalDate.of(año,mes,dia);
                    
                    System.out.println("Ingrese el rut del fallecido:");
                    rutFallecido = lector.readLine();
                    System.out.println("Ingrese la causa de la defuncion");
                    Causa = lector.readLine();
                    
                    //sistema.registrarDefuncion(index, fechaDefuncion, Causa, rutFallecido);
                    
                    break;
                case 4:
                    // Lógica para emitir certificados
                    break;
                case 5:
                    //mostrarTodasLasPersonas(sistema);
                    sistema.mostrarPersonasGlobal();
                    break;
                case 6:
                    // Lógica para mostrar personas por sucursal (la que ya tenías)
                    System.out.println("Seleccione Sucursal:");
                    
                    for(int i=0; i<sistema.getListaSucursales().size(); i++){
                        System.out.println((i+1) + ". " + sistema.getListaSucursales().get(i).getNombre());
                    }
                    index = Integer.parseInt(lector.readLine());
                    index--;
                    
                    sistema.getListaSucursales().get(index).mostrarPersonasSucursal();
                    break;
                case 7:
                    sistema.mostrarNacimientosGlobal();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        System.out.println("¡Hasta luego!");
    }
    
    //METODOS
    public void menuAccionesSucursal(BufferedReader lector, SistemaRegistroCivil sistema, Sucursal sucursal){
    
    
    }
    
}


