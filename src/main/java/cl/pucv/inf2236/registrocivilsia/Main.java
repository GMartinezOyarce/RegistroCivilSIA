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
import java.util.List;

/**
 *
 * @author gabom
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //inicializar lector y variable para leer datos;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dato;
        
        //cargar Datos
        SistemaRegistroCivil sistema = new SistemaRegistroCivil();
        sistema.cargarDatosDePrueba();
        
        //variable booleana para poder terminar la ejecucion del programa
        boolean salir = false;
        
        System.out.println("---Bienvenido al sistema del registro civil---");
        
        while(!salir){   
            System.out.println("--- Eliga la sucursal a la cual desea ingresar ---");
            List<Sucursal> sucursales = sistema.getListaSucursales();
            for(int i = 0; i< sucursales.size(); i++){
                System.out.println((1 + i) + "." + sucursales.get(i).getNombre());
            }
            System.out.println("0. Salir del programa");
            System.out.println("Ingrese opcion: ");
            int opcion = Integer.parseInt(lector.readLine());
            
            if (opcion == 0){
                salir = true;
                continue;
            }
            if(opcion >= 1 && opcion <= sucursales.size()){
                Sucursal sucursalSeleccionada = sucursales.get(opcion - 1);
                //menuAccionesSucursal(lector, sistema, sucursalSeleccionada);
                System.out.println("FUNCIOOONOOOO");
            }else{
                System.out.println("Opcion no valida, intente denuevo");
            }
        } 
        System.out.println("Hasta Luego");
    }
}
