/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.pucv.inf2236.registrocivilsia;

/**
 *
 * @author crist
 */

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import cl.pucv.inf2236.registrocivilsia.modelo.logica.SistemaRegistroCivil;
import java.time.LocalDate;


public class AppGUI {
    public static void main(String[] args) {
        final SistemaRegistroCivil sistema = new SistemaRegistroCivil();
        sistema.cargarDatosDePrueba();
        
        SwingUtilities.invokeLater(() ->{
            JFrame ventana = new JFrame ("Registro Civil");
            ventana.setSize(400,300); //tamaño
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar
            ventana.setLocationRelativeTo(null); //para centrar
            ventana.setVisible(true); //para que...se vea
            
            ventana.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));; //disposicion de botones
            
            //BOTON REGISTRAR NACIMIENTO
            
            JButton btnRegNac = new JButton("Registrar Nacimiento"); // crea boton para registrar nacimientos
            btnRegNac.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnRegNac); //agrega a la ventana
            
            btnRegNac.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe ir el formulario de nacimiento");
            });
            
            //BOTON REGISTRAR MATRIMONIO
            JButton btnRegMat = new JButton("Registrar Matrimonio"); 
            btnRegMat.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnRegMat); 
            
            btnRegMat.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe ir el formulario de matrimonio");
            });
            
            //BOTON REGISTRAR DEFUNCION
            JButton btnRegDef = new JButton("Registrar Defuncion"); 
            btnRegDef.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnRegDef); 
            
            btnRegDef.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe ir el formulario de Defuncion");
            });
            
            //BOTON EMITIR CERTIFICADO
            JButton btnEmiCer = new JButton("Emitir Certificado"); 
            btnEmiCer.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnEmiCer); 
            
            btnEmiCer.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe ir el formulario de Certificado");
            });
            
            //BOTON MOSTRAR TODAS LAS PERSONAS DEL SISTEMA
            JButton btnMosTodPer = new JButton("Mostrar todas las personas del sistema"); 
            btnMosTodPer.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnMosTodPer); 
            
            btnMosTodPer.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe mostrar todas las personas");
            });
            
            //BOTON MOSTRAR PERSONAS POR SUCURSAL
            JButton btnMosPerSur = new JButton("Mostrar personas por sucursal"); 
            btnMosPerSur.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnMosPerSur); 
            
            btnMosPerSur.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe mostrar las personas");
            });
            
            //BOTON MOSTRAR TODOS LOS NACIMIENTOS
            JButton btnMosTodNac = new JButton("Mostrar todos los nacimientos"); 
            btnMosTodNac.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnMosTodNac); 
            
            btnMosTodNac.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe mostrar todos los nacimientos");
            });
            
            //BOTON AGREGAR SUCURSAL
            JButton btnAgrSuc= new JButton("Agregar Sucursal"); 
            btnAgrSuc.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnAgrSuc); 
            
            btnAgrSuc.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe ir el formulario de sucursal");
            });
            
            //BOTON ELIMINAR SUCURSAL
            JButton btnEliSuc= new JButton("Eliminar Sucursal"); 
            btnEliSuc.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnEliSuc); 
            
            btnEliSuc.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe eliminar la sucursal elegida");
            });
            
            //BOTON MODIFICAR SUCURSAL
            JButton btnModSuc= new JButton("Modificar Sucursal"); 
            btnModSuc.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnModSuc); 
            
            btnModSuc.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe Modificar la sucursal elegida");
            });
            
            //BOTON BUSCAR SUCURSAL
            JButton btnBusSuc= new JButton("Buscar Sucursal"); 
            btnBusSuc.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnBusSuc); 
            
            btnBusSuc.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe mostrar la sucursal elegida");
            });
            
            //BOTON LISTAR SUCURSALES
            JButton btnLisSuc= new JButton("Listar Sucursal"); 
            btnLisSuc.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnLisSuc); 
            
            btnLisSuc.addActionListener(e -> {
                javax.swing.JFrame winSurList = new javax.swing.JFrame("Sucursales");
                
                winSurList.setSize(380,300);
                winSurList.setVisible(true);
                
                //Tabla
                String[] columnas = {"ID", "Nombre", "Ciudad", "Region"};
                String[][] datos = sistema.getSucursalesForVista();
                javax.swing.JTable tablaSurList = new javax.swing.JTable(datos,columnas);
                winSurList.add(new javax.swing.JScrollPane(tablaSurList));
            });
            
            //BOTON BUSCAR PERSONA EN SUCURSAL
            JButton btnBusPerSuc= new JButton("Buscar Persona en Sucursal"); 
            btnBusPerSuc.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnBusPerSuc); 
            
            btnBusPerSuc.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe mostrar la persona buscada");
            });
            
            //BOTON GUARDAR Y SALIR
            JButton btnGuaAndSal= new JButton("Guardar y Salir"); 
            btnGuaAndSal.setPreferredSize(new java.awt.Dimension(200,40));
            ventana.add(btnGuaAndSal); 
            
            btnGuaAndSal.addActionListener(e -> {
                javax.swing.JOptionPane.showMessageDialog(ventana, "Aqui debe guardar y salir");
            });
            
        });
    }
}
