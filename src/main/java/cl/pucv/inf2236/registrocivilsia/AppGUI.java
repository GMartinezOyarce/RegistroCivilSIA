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
import cl.pucv.inf2236.registrocivilsia.modelo.Sucursal;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import cl.pucv.inf2236.registrocivilsia.modelo.logica.SistemaRegistroCivil;
import java.time.LocalDate;
import cl.pucv.inf2236.registrocivilsia.modelo.Persona;


public class AppGUI {
    public static void main(String[] args) {
        final SistemaRegistroCivil sistema = new SistemaRegistroCivil();
        sistema.cargarDatosDePrueba();
        
        SwingUtilities.invokeLater(() ->{
            JFrame ventana = new JFrame ("Sistema de Registro Civil");
            ventana.setSize(600, 700); //tamaño mas grande
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar
            ventana.setLocationRelativeTo(null); //para centrar
            ventana.setVisible(true); //para que...se vea
            
            // Usar BorderLayout para mejor organización
            ventana.setLayout(new java.awt.BorderLayout());
            
            // Panel principal con GridLayout para organizar los botones
            javax.swing.JPanel panelPrincipal = new javax.swing.JPanel();
            panelPrincipal.setLayout(new java.awt.GridLayout(7, 2, 10, 10)); // 7 filas, 2 columnas
            panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
            
            // Título
            javax.swing.JLabel titulo = new javax.swing.JLabel("Sistema de Registro Civil", javax.swing.SwingConstants.CENTER);
            titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            ventana.add(titulo, java.awt.BorderLayout.NORTH);
            
            //BOTON REGISTRAR NACIMIENTO
            
            JButton btnRegNac = new JButton("Registrar Nacimiento"); // crea boton para registrar nacimientos
            btnRegNac.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnRegNac); //agrega al panel principal
            
            btnRegNac.addActionListener(e -> {
                // Crear ventana de formulario de nacimiento
                javax.swing.JFrame ventanaNacimiento = new javax.swing.JFrame("Registrar Nacimiento");
                ventanaNacimiento.setSize(500, 600);
                ventanaNacimiento.setLocationRelativeTo(ventana);
                ventanaNacimiento.setLayout(new java.awt.GridBagLayout());
                java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
                
                // Campos del formulario
                javax.swing.JLabel lblFechaNac = new javax.swing.JLabel("Fecha de Nacimiento (YYYY-MM-DD):");
                javax.swing.JTextField txtFechaNac = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblLugarNac = new javax.swing.JLabel("Lugar de Nacimiento:");
                javax.swing.JTextField txtLugarNac = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblRutInscrito = new javax.swing.JLabel("RUT del Inscrito:");
                javax.swing.JTextField txtRutInscrito = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblNombreInscrito = new javax.swing.JLabel("Nombre del Inscrito:");
                javax.swing.JTextField txtNombreInscrito = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblRutProgenitor1 = new javax.swing.JLabel("RUT Progenitor 1:");
                javax.swing.JTextField txtRutProgenitor1 = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblRutProgenitor2 = new javax.swing.JLabel("RUT Progenitor 2:");
                javax.swing.JTextField txtRutProgenitor2 = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblSucursal = new javax.swing.JLabel("Sucursal:");
                javax.swing.JComboBox<String> cmbSucursal = new javax.swing.JComboBox<>();
                for(int i = 0; i < sistema.getListaSucursales().size(); i++) {
                    cmbSucursal.addItem(sistema.getListaSucursales().get(i).getNombre() + " (ID: " + sistema.getListaSucursales().get(i).getIdSucursal() + ")");
                }
                
                javax.swing.JButton btnRegistrar = new javax.swing.JButton("Registrar");
                javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
                
                // Posicionar elementos
                gbc.insets = new java.awt.Insets(5, 5, 5, 5);
                gbc.anchor = java.awt.GridBagConstraints.WEST;
                
                gbc.gridx = 0; gbc.gridy = 0; ventanaNacimiento.add(lblFechaNac, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(txtFechaNac, gbc);
                
                gbc.gridx = 0; gbc.gridy = 1; ventanaNacimiento.add(lblLugarNac, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(txtLugarNac, gbc);
                
                gbc.gridx = 0; gbc.gridy = 2; ventanaNacimiento.add(lblRutInscrito, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(txtRutInscrito, gbc);
                
                gbc.gridx = 0; gbc.gridy = 3; ventanaNacimiento.add(lblNombreInscrito, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(txtNombreInscrito, gbc);
                
                gbc.gridx = 0; gbc.gridy = 4; ventanaNacimiento.add(lblRutProgenitor1, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(txtRutProgenitor1, gbc);
                
                gbc.gridx = 0; gbc.gridy = 5; ventanaNacimiento.add(lblRutProgenitor2, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(txtRutProgenitor2, gbc);
                
                gbc.gridx = 0; gbc.gridy = 6; ventanaNacimiento.add(lblSucursal, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(cmbSucursal, gbc);
                
                gbc.gridx = 0; gbc.gridy = 7; gbc.anchor = java.awt.GridBagConstraints.CENTER;
                ventanaNacimiento.add(btnRegistrar, gbc);
                gbc.gridx = 1; ventanaNacimiento.add(btnCancelar, gbc);
                
                // Acción del botón registrar
                btnRegistrar.addActionListener(ev -> {
                    try {
                        java.time.LocalDate fechaNac = java.time.LocalDate.parse(txtFechaNac.getText());
                        String lugarNac = txtLugarNac.getText();
                        String rutInscrito = txtRutInscrito.getText();
                        String nombreInscrito = txtNombreInscrito.getText();
                        String rutProgenitor1 = txtRutProgenitor1.getText();
                        String rutProgenitor2 = txtRutProgenitor2.getText();
                        int indexSucursal = cmbSucursal.getSelectedIndex();
                        
                        if(lugarNac.isEmpty() || rutInscrito.isEmpty() || nombreInscrito.isEmpty() || 
                           rutProgenitor1.isEmpty() || rutProgenitor2.isEmpty()) {
                            javax.swing.JOptionPane.showMessageDialog(ventanaNacimiento, "Todos los campos son obligatorios");
                            return;
                        }
                        
                        boolean resultado=sistema.registrarNacimiento(indexSucursal, fechaNac, lugarNac, rutProgenitor1, rutProgenitor2, rutInscrito, nombreInscrito);
                        if(resultado == true){
                            javax.swing.JOptionPane.showMessageDialog(ventanaNacimiento, "Nacimiento registrado exitosamente");
                            ventanaNacimiento.dispose();
                        }
                        else{
                            javax.swing.JOptionPane.showMessageDialog(ventanaNacimiento, "Registro fallido, posible causa: progenitores no encontrados");
                        }
                    } catch (Exception ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventanaNacimiento, "Error en el formato de fecha. Use YYYY-MM-DD");
                    }
                });
                
                // Acción del botón cancelar
                btnCancelar.addActionListener(ev -> ventanaNacimiento.dispose());
                
                ventanaNacimiento.setVisible(true);
            });
            
            //BOTON REGISTRAR MATRIMONIO
            JButton btnRegMat = new JButton("Registrar Matrimonio"); 
            btnRegMat.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnRegMat); 
            
            btnRegMat.addActionListener(e -> {
                // Crear ventana de formulario de matrimonio
                javax.swing.JFrame ventanaMatrimonio = new javax.swing.JFrame("Registrar Matrimonio");
                ventanaMatrimonio.setSize(500, 400);
                ventanaMatrimonio.setLocationRelativeTo(ventana);
                ventanaMatrimonio.setLayout(new java.awt.GridBagLayout());
                java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
                
                // Campos del formulario
                javax.swing.JLabel lblRutConyuge1 = new javax.swing.JLabel("RUT Contrayente 1:");
                javax.swing.JTextField txtRutConyuge1 = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblRutConyuge2 = new javax.swing.JLabel("RUT Contrayente 2:");
                javax.swing.JTextField txtRutConyuge2 = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblSucursal = new javax.swing.JLabel("Sucursal:");
                javax.swing.JComboBox<String> cmbSucursal = new javax.swing.JComboBox<>();
                for(int i = 0; i < sistema.getListaSucursales().size(); i++) {
                    cmbSucursal.addItem(sistema.getListaSucursales().get(i).getNombre() + " (ID: " + sistema.getListaSucursales().get(i).getIdSucursal() + ")");
                }
                
                javax.swing.JButton btnRegistrar = new javax.swing.JButton("Registrar");
                javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
                
                // Posicionar elementos
                gbc.insets = new java.awt.Insets(5, 5, 5, 5);
                gbc.anchor = java.awt.GridBagConstraints.WEST;
                
                gbc.gridx = 0; gbc.gridy = 0; ventanaMatrimonio.add(lblRutConyuge1, gbc);
                gbc.gridx = 1; ventanaMatrimonio.add(txtRutConyuge1, gbc);
                
                gbc.gridx = 0; gbc.gridy = 1; ventanaMatrimonio.add(lblRutConyuge2, gbc);
                gbc.gridx = 1; ventanaMatrimonio.add(txtRutConyuge2, gbc);
                
                gbc.gridx = 0; gbc.gridy = 2; ventanaMatrimonio.add(lblSucursal, gbc);
                gbc.gridx = 1; ventanaMatrimonio.add(cmbSucursal, gbc);
                
                gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = java.awt.GridBagConstraints.CENTER;
                ventanaMatrimonio.add(btnRegistrar, gbc);
                gbc.gridx = 1; ventanaMatrimonio.add(btnCancelar, gbc);
                
                // Acción del botón registrar
                btnRegistrar.addActionListener(ev -> {
                    String rutConyuge1 = txtRutConyuge1.getText();
                    String rutConyuge2 = txtRutConyuge2.getText();
                    int indexSucursal = cmbSucursal.getSelectedIndex();
                    
                    if(rutConyuge1.isEmpty() || rutConyuge2.isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(ventanaMatrimonio, "Ambos RUTs son obligatorios");
                        return;
                    }
                    
                    if(rutConyuge1.equals(rutConyuge2)) {
                        javax.swing.JOptionPane.showMessageDialog(ventanaMatrimonio, "Los contrayentes no pueden ser la misma persona");
                        return;
                    }
                    
                    boolean resultado=sistema.registrarMatrimonio(indexSucursal, rutConyuge1, rutConyuge2);
                    if(resultado == true){
                        javax.swing.JOptionPane.showMessageDialog(ventanaMatrimonio, "Matrimonio registrado exitosamente");
                        ventanaMatrimonio.dispose();
                    }
                    else{
                        javax.swing.JOptionPane.showMessageDialog(ventanaMatrimonio, "Matrimonio no registrado, posible causa: conyuge/s no encontrado/s");
                    }
                });
                
                // Acción del botón cancelar
                btnCancelar.addActionListener(ev -> ventanaMatrimonio.dispose());
                
                ventanaMatrimonio.setVisible(true);
            });
            
            //BOTON REGISTRAR DEFUNCION
            JButton btnRegDef = new JButton("Registrar Defuncion"); 
            btnRegDef.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnRegDef); 
            
            btnRegDef.addActionListener(e -> {
                // Crear ventana de formulario de defunción
                javax.swing.JFrame ventanaDefuncion = new javax.swing.JFrame("Registrar Defunción");
                ventanaDefuncion.setSize(500, 400);
                ventanaDefuncion.setLocationRelativeTo(ventana);
                ventanaDefuncion.setLayout(new java.awt.GridBagLayout());
                java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
                
                // Campos del formulario
                javax.swing.JLabel lblFechaDef = new javax.swing.JLabel("Fecha de Defunción (YYYY-MM-DD):");
                javax.swing.JTextField txtFechaDef = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblCausa = new javax.swing.JLabel("Causa de Defunción:");
                javax.swing.JTextField txtCausa = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblRutFallecido = new javax.swing.JLabel("RUT del Fallecido:");
                javax.swing.JTextField txtRutFallecido = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblSucursal = new javax.swing.JLabel("Sucursal:");
                javax.swing.JComboBox<String> cmbSucursal = new javax.swing.JComboBox<>();
                for(int i = 0; i < sistema.getListaSucursales().size(); i++) {
                    cmbSucursal.addItem(sistema.getListaSucursales().get(i).getNombre() + " (ID: " + sistema.getListaSucursales().get(i).getIdSucursal() + ")");
                }
                
                javax.swing.JButton btnRegistrar = new javax.swing.JButton("Registrar");
                javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
                
                // Posicionar elementos
                gbc.insets = new java.awt.Insets(5, 5, 5, 5);
                gbc.anchor = java.awt.GridBagConstraints.WEST;
                
                gbc.gridx = 0; gbc.gridy = 0; ventanaDefuncion.add(lblFechaDef, gbc);
                gbc.gridx = 1; ventanaDefuncion.add(txtFechaDef, gbc);
                
                gbc.gridx = 0; gbc.gridy = 1; ventanaDefuncion.add(lblCausa, gbc);
                gbc.gridx = 1; ventanaDefuncion.add(txtCausa, gbc);
                
                gbc.gridx = 0; gbc.gridy = 2; ventanaDefuncion.add(lblRutFallecido, gbc);
                gbc.gridx = 1; ventanaDefuncion.add(txtRutFallecido, gbc);
                
                gbc.gridx = 0; gbc.gridy = 3; ventanaDefuncion.add(lblSucursal, gbc);
                gbc.gridx = 1; ventanaDefuncion.add(cmbSucursal, gbc);
                
                gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = java.awt.GridBagConstraints.CENTER;
                ventanaDefuncion.add(btnRegistrar, gbc);
                gbc.gridx = 1; ventanaDefuncion.add(btnCancelar, gbc);
                
                // Acción del botón registrar
                btnRegistrar.addActionListener(ev -> {
                    try {
                        java.time.LocalDate fechaDef = java.time.LocalDate.parse(txtFechaDef.getText());
                        String causa = txtCausa.getText();
                        String rutFallecido = txtRutFallecido.getText();
                        int indexSucursal = cmbSucursal.getSelectedIndex();
                        
                        if(causa.isEmpty() || rutFallecido.isEmpty()) {
                            javax.swing.JOptionPane.showMessageDialog(ventanaDefuncion, "Todos los campos son obligatorios");
                            return;
                        }
                        
                        boolean resultado=sistema.registrarDefuncion(indexSucursal, fechaDef, causa, rutFallecido);
                        if(resultado==true){
                            javax.swing.JOptionPane.showMessageDialog(ventanaDefuncion, "Defunción registrada exitosamente");
                            ventanaDefuncion.dispose();
                        }
                        else{
                            javax.swing.JOptionPane.showMessageDialog(ventanaDefuncion, "Defunción no registrada, posible causa: persona no encontrada");
                        }
                    } catch (Exception ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventanaDefuncion, "Error en el formato de fecha. Use YYYY-MM-DD");
                    }
                });
                
                // Acción del botón cancelar
                btnCancelar.addActionListener(ev -> ventanaDefuncion.dispose());
                
                ventanaDefuncion.setVisible(true);
            });
            
            //BOTON EMITIR CERTIFICADO
            JButton btnEmiCer = new JButton("Emitir Certificado"); 
            btnEmiCer.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnEmiCer); 
            
            btnEmiCer.addActionListener(e -> {
                // Crear ventana de emisión de certificados
                javax.swing.JFrame ventanaCertificado = new javax.swing.JFrame("Emitir Certificado");
                ventanaCertificado.setSize(500, 300);
                ventanaCertificado.setLocationRelativeTo(ventana);
                ventanaCertificado.setLayout(new java.awt.GridBagLayout());
                java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
                
                // Campos del formulario
                javax.swing.JLabel lblRut = new javax.swing.JLabel("RUT de la persona:");
                javax.swing.JTextField txtRut = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblTipoCert = new javax.swing.JLabel("Tipo de Certificado:");
                javax.swing.JComboBox<String> cmbTipoCert = new javax.swing.JComboBox<>();
                cmbTipoCert.addItem("Certificado de Nacimiento");
                cmbTipoCert.addItem("Certificado de Matrimonio");
                cmbTipoCert.addItem("Certificado de Defunción");
                
                javax.swing.JButton btnEmitir = new javax.swing.JButton("Emitir Certificado");
                javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
                
                // Posicionar elementos
                gbc.insets = new java.awt.Insets(5, 5, 5, 5);
                gbc.anchor = java.awt.GridBagConstraints.WEST;
                
                gbc.gridx = 0; gbc.gridy = 0; ventanaCertificado.add(lblRut, gbc);
                gbc.gridx = 1; ventanaCertificado.add(txtRut, gbc);
                
                gbc.gridx = 0; gbc.gridy = 1; ventanaCertificado.add(lblTipoCert, gbc);
                gbc.gridx = 1; ventanaCertificado.add(cmbTipoCert, gbc);
                
                gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = java.awt.GridBagConstraints.CENTER;
                ventanaCertificado.add(btnEmitir, gbc);
                gbc.gridx = 1; ventanaCertificado.add(btnCancelar, gbc);
                
                // Acción del botón emitir
                btnEmitir.addActionListener(ev -> {
                    String rut = txtRut.getText();
                    String tipoCert = (String) cmbTipoCert.getSelectedItem();
                    
                    if(rut.isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(ventanaCertificado, "El RUT es obligatorio");
                        return;
                    }
                    
                    String certificado = "";
                    switch(tipoCert) {
                        case "Certificado de Nacimiento":
                            cl.pucv.inf2236.registrocivilsia.modelo.Nacimiento nac = sistema.encontrarNacimiento(rut);
                            if(nac != null) {
                                certificado = nac.generarCertificado();
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(ventanaCertificado, "No se encontró certificado de nacimiento para este RUT");
                                return;
                            }
                            break;
                        case "Certificado de Matrimonio":
                            cl.pucv.inf2236.registrocivilsia.modelo.Matrimonio mat = sistema.encontrarMatrimonio(rut);
                            if(mat != null) {
                                certificado = mat.generarCertificado();
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(ventanaCertificado, "No se encontró certificado de matrimonio para este RUT");
                                return;
                            }
                            break;
                        case "Certificado de Defunción":
                            cl.pucv.inf2236.registrocivilsia.modelo.Defuncion def = sistema.encontrarDefuncion(rut);
                            if(def != null) {
                                certificado = def.generarCertificado();
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(ventanaCertificado, "No se encontró certificado de defunción para este RUT");
                                return;
                            }
                            break;
                    }
                    
                    // Mostrar certificado en una nueva ventana
                    javax.swing.JFrame ventanaMostrarCert = new javax.swing.JFrame("Certificado Emitido");
                    ventanaMostrarCert.setSize(600, 500);
                    ventanaMostrarCert.setLocationRelativeTo(ventanaCertificado);
                    
                    javax.swing.JTextArea txtCertificado = new javax.swing.JTextArea(certificado);
                    txtCertificado.setEditable(false);
                    txtCertificado.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
                    txtCertificado.setWrapStyleWord(true);
                    txtCertificado.setLineWrap(true);
                    
                    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(txtCertificado);
                    ventanaMostrarCert.add(scrollPane);
                    ventanaMostrarCert.setVisible(true);
                    
                    ventanaCertificado.dispose();
                });
                
                // Acción del botón cancelar
                btnCancelar.addActionListener(ev -> ventanaCertificado.dispose());
                
                ventanaCertificado.setVisible(true);
            });
            
            //BOTON MOSTRAR TODAS LAS PERSONAS DEL SISTEMA
            JButton btnMosTodPer = new JButton("Mostrar todas las personas del sistema"); 
            btnMosTodPer.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnMosTodPer); 
            
            btnMosTodPer.addActionListener(e -> {
                javax.swing.JFrame winPersonasList = new javax.swing.JFrame("Todas las Personas del Sistema");
                
                winPersonasList.setSize(800, 400);
                winPersonasList.setVisible(true);
                
                // Crear tabla con datos de personas
                String[] columnas = {"RUT", "Nombre", "Fecha Nacimiento", "Estado Civil", "Estado", "Sucursal"};
                java.util.Map<String, cl.pucv.inf2236.registrocivilsia.modelo.Persona> personas = sistema.getMapPersonas();
                String[][] datos = new String[personas.size()][6];
                
                int i = 0;
                for(cl.pucv.inf2236.registrocivilsia.modelo.Persona p : personas.values()) {
                    datos[i][0] = p.getRut();
                    datos[i][1] = p.getNombre();
                    datos[i][2] = p.getFechaNacimiento().toString();
                    datos[i][3] = p.getEstadoCivil();
                    datos[i][4] = p.getEstaViva() ? "Vivo/a" : "Difunto/a";
                    datos[i][5] = p.getSucursal().getNombre();
                    i++;
                }
                
                javax.swing.JTable tablaPersonasList = new javax.swing.JTable(datos, columnas);
                winPersonasList.add(new javax.swing.JScrollPane(tablaPersonasList));
            });
            
            //BOTON MOSTRAR PERSONAS POR SUCURSAL
            JButton btnMosPerSur = new JButton("Mostrar personas por sucursal"); 
            btnMosPerSur.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnMosPerSur); 
            
            btnMosPerSur.addActionListener(e -> {
                // Crear ventana de selección de sucursal
                javax.swing.JFrame ventanaSeleccionSucursal = new javax.swing.JFrame("Seleccionar Sucursal");
                ventanaSeleccionSucursal.setSize(400, 200);
                ventanaSeleccionSucursal.setLocationRelativeTo(ventana);
                ventanaSeleccionSucursal.setLayout(new java.awt.GridBagLayout());
                java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
                
                javax.swing.JLabel lblSucursal = new javax.swing.JLabel("Seleccione una sucursal:");
                javax.swing.JComboBox<String> cmbSucursal = new javax.swing.JComboBox<>();
                for(int i = 0; i < sistema.getListaSucursales().size(); i++) {
                    cmbSucursal.addItem(sistema.getListaSucursales().get(i).getNombre() + " (ID: " + sistema.getListaSucursales().get(i).getIdSucursal() + ")");
                }
                
                javax.swing.JButton btnMostrar = new javax.swing.JButton("Mostrar Personas");
                javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
                
                gbc.insets = new java.awt.Insets(5, 5, 5, 5);
                gbc.anchor = java.awt.GridBagConstraints.WEST;
                
                gbc.gridx = 0; gbc.gridy = 0; ventanaSeleccionSucursal.add(lblSucursal, gbc);
                gbc.gridx = 1; ventanaSeleccionSucursal.add(cmbSucursal, gbc);
                
                gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = java.awt.GridBagConstraints.CENTER;
                ventanaSeleccionSucursal.add(btnMostrar, gbc);
                gbc.gridx = 1; ventanaSeleccionSucursal.add(btnCancelar, gbc);
                
                btnMostrar.addActionListener(ev -> {
                    int indexSucursal = cmbSucursal.getSelectedIndex();
                    cl.pucv.inf2236.registrocivilsia.modelo.Sucursal sucursalSeleccionada = sistema.getListaSucursales().get(indexSucursal);
                    
                    javax.swing.JFrame winPersonasSucursal = new javax.swing.JFrame("Personas de " + sucursalSeleccionada.getNombre());
                    winPersonasSucursal.setSize(800, 400);
                    winPersonasSucursal.setVisible(true);
                    
                    // Crear tabla con datos de personas de la sucursal
                    String[] columnas = {"RUT", "Nombre", "Fecha Nacimiento", "Estado Civil", "Estado"};
                    java.util.List<cl.pucv.inf2236.registrocivilsia.modelo.Persona> personasSucursal = sucursalSeleccionada.getPersonasRegistradas();
                    String[][] datos = new String[personasSucursal.size()][5];
                    
                    for(int i = 0; i < personasSucursal.size(); i++) {
                        cl.pucv.inf2236.registrocivilsia.modelo.Persona p = personasSucursal.get(i);
                        datos[i][0] = p.getRut();
                        datos[i][1] = p.getNombre();
                        datos[i][2] = p.getFechaNacimiento().toString();
                        datos[i][3] = p.getEstadoCivil();
                        datos[i][4] = p.getEstaViva() ? "Vivo/a" : "Difunto/a";
                    }
                    
                    javax.swing.JTable tablaPersonasSucursal = new javax.swing.JTable(datos, columnas);
                    winPersonasSucursal.add(new javax.swing.JScrollPane(tablaPersonasSucursal));
                    
                    ventanaSeleccionSucursal.dispose();
                });
                
                btnCancelar.addActionListener(ev -> ventanaSeleccionSucursal.dispose());
                
                ventanaSeleccionSucursal.setVisible(true);
            });
            
            //BOTON MOSTRAR TODOS LOS NACIMIENTOS
            JButton btnMosTodNac = new JButton("Listar nacimientos"); 
            btnMosTodNac.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnMosTodNac); 
            
            btnMosTodNac.addActionListener(e -> {
                javax.swing.JFrame winNacList = new javax.swing.JFrame("Nacimientos");
                
                winNacList.setSize(380,300);
                winNacList.setVisible(true);
                
                //Tabla
                String[] columnas = {"ID", "Fecha Nacimiento", "Fecha Inscripcion", "Lugar Nacimiento", "ID Sucursal " , "Rut Inscrito", "Rut Progenitor[1]", "Rut Progenitor[2]"};
                String[][] datos = sistema.getNacimientosForVista();
                javax.swing.JTable tablaNacList = new javax.swing.JTable(datos,columnas);
                winNacList.add(new javax.swing.JScrollPane(tablaNacList));
            });
            
            //BOTON AGREGAR SUCURSAL
            JButton btnAgrSuc= new JButton("Agregar Sucursal"); 
            btnAgrSuc.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnAgrSuc); 
            
            btnAgrSuc.addActionListener(e -> {
                // Crear ventana de formulario de sucursal
                javax.swing.JFrame ventanaSucursal = new javax.swing.JFrame("Agregar Sucursal");
                ventanaSucursal.setSize(500, 400);
                ventanaSucursal.setLocationRelativeTo(ventana);
                ventanaSucursal.setLayout(new java.awt.GridBagLayout());
                java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
                
                // Campos del formulario
                javax.swing.JLabel lblIdSucursal = new javax.swing.JLabel("ID de Sucursal:");
                javax.swing.JTextField txtIdSucursal = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblNombre = new javax.swing.JLabel("Nombre:");
                javax.swing.JTextField txtNombre = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblCiudad = new javax.swing.JLabel("Ciudad:");
                javax.swing.JTextField txtCiudad = new javax.swing.JTextField(15);
                
                javax.swing.JLabel lblRegion = new javax.swing.JLabel("Región:");
                javax.swing.JTextField txtRegion = new javax.swing.JTextField(15);
                
                javax.swing.JButton btnAgregar = new javax.swing.JButton("Agregar");
                javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
                
                // Posicionar elementos
                gbc.insets = new java.awt.Insets(5, 5, 5, 5);
                gbc.anchor = java.awt.GridBagConstraints.WEST;
                
                gbc.gridx = 0; gbc.gridy = 0; ventanaSucursal.add(lblIdSucursal, gbc);
                gbc.gridx = 1; ventanaSucursal.add(txtIdSucursal, gbc);
                
                gbc.gridx = 0; gbc.gridy = 1; ventanaSucursal.add(lblNombre, gbc);
                gbc.gridx = 1; ventanaSucursal.add(txtNombre, gbc);
                
                gbc.gridx = 0; gbc.gridy = 2; ventanaSucursal.add(lblCiudad, gbc);
                gbc.gridx = 1; ventanaSucursal.add(txtCiudad, gbc);
                
                gbc.gridx = 0; gbc.gridy = 3; ventanaSucursal.add(lblRegion, gbc);
                gbc.gridx = 1; ventanaSucursal.add(txtRegion, gbc);
                
                gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = java.awt.GridBagConstraints.CENTER;
                ventanaSucursal.add(btnAgregar, gbc);
                gbc.gridx = 1; ventanaSucursal.add(btnCancelar, gbc);
                
                // Acción del botón agregar
                btnAgregar.addActionListener(ev -> {
                    try {
                        int idSucursal = Integer.parseInt(txtIdSucursal.getText());
                        String nombre = txtNombre.getText();
                        String ciudad = txtCiudad.getText();
                        String region = txtRegion.getText();
                        
                        if(nombre.isEmpty() || ciudad.isEmpty() || region.isEmpty()) {
                            javax.swing.JOptionPane.showMessageDialog(ventanaSucursal, "Todos los campos son obligatorios");
                            return;
                        }
                        
                        boolean resultado = sistema.agregarSucursal(idSucursal, nombre, ciudad, region);
                        if(resultado) {
                            javax.swing.JOptionPane.showMessageDialog(ventanaSucursal, "Sucursal agregada exitosamente");
                            ventanaSucursal.dispose();
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(ventanaSucursal, "Ya existe una sucursal con ese ID");
                        }
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventanaSucursal, "El ID debe ser un número entero");
                    }
                });
                
                // Acción del botón cancelar
                btnCancelar.addActionListener(ev -> ventanaSucursal.dispose());
                
                ventanaSucursal.setVisible(true);
            });
            
            //BOTON ELIMINAR SUCURSAL
            JButton btnEliSuc= new JButton("Eliminar Sucursal"); 
            btnEliSuc.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnEliSuc); 
            
            btnEliSuc.addActionListener(e -> {
                String input = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese el ID de la sucursal a eliminar:");
                if(input != null && !input.isEmpty()) {
                    try {
                        int idSucursal = Integer.parseInt(input);
                        boolean resultado = sistema.eliminarSucursal(idSucursal);
                        if(resultado) {
                            javax.swing.JOptionPane.showMessageDialog(ventana, "Sucursal eliminada exitosamente");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(ventana, "No se encontró una sucursal con ese ID");
                        }
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventana, "El ID debe ser un número entero");
                    }
                }
            });
            
            //BOTON MODIFICAR SUCURSAL
            JButton btnModSuc= new JButton("Modificar Sucursal"); 
            btnModSuc.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnModSuc); 
            
            btnModSuc.addActionListener(e -> {
                String input = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese el ID de la sucursal a modificar:");
                if(input != null && !input.isEmpty()) {
                    try {
                        int idSucursal = Integer.parseInt(input);
                        String nombre = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese el nuevo nombre:");
                        String ciudad = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese la nueva ciudad:");
                        String region = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese la nueva región:");
                        
                        if(nombre != null && ciudad != null && region != null && 
                           !nombre.isEmpty() && !ciudad.isEmpty() && !region.isEmpty()) {
                            boolean resultado = sistema.modificarSucursal(idSucursal, nombre, ciudad, region);
                            if(resultado) {
                                javax.swing.JOptionPane.showMessageDialog(ventana, "Sucursal modificada exitosamente");
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(ventana, "No se encontró una sucursal con ese ID");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventana, "El ID debe ser un número entero");
                    }
                }
            });
            
            //BOTON BUSCAR SUCURSAL
            JButton btnBusSuc= new JButton("Buscar Sucursal"); 
            btnBusSuc.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnBusSuc); 
            
            btnBusSuc.addActionListener(e -> {
                String input = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese el ID de la sucursal a buscar:");
                if(input != null && !input.isEmpty()) {
                    try {
                        int idSucursal = Integer.parseInt(input);
                        Sucursal suc =sistema.getSucursalForVista(idSucursal);
                        if(suc == null) {
                            javax.swing.JOptionPane.showMessageDialog(ventana, "No se encontró una sucursal con ese ID");
                        }
                        else{
                            String info= "ID: " + suc.getIdSucursal() + "\n" +
                                         "Nombre: " + suc.getNombre() + "\n" +
                                         "Ciudad: " + suc.getCiudad() + "\n" +
                                         "Región: " + suc.getRegion();
                            JOptionPane.showMessageDialog(ventana,info,"Sucursal encontrada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventana, "El ID debe ser un número entero");
                    }
                }
            });
            
            //BOTON LISTAR SUCURSALES
            JButton btnLisSuc= new JButton("Listar Sucursal"); 
            btnLisSuc.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnLisSuc); 
            
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
            panelPrincipal.add(btnBusPerSuc); 
            
            btnBusPerSuc.addActionListener(e -> {
                String inputId = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese el ID de la sucursal:");
                if(inputId != null && !inputId.isEmpty()) {
                    try {
                        int idSucursal = Integer.parseInt(inputId);
                        String inputRut = javax.swing.JOptionPane.showInputDialog(ventana, "Ingrese el RUT de la persona:");
                        if(inputRut != null && !inputRut.isEmpty()) {
                            Persona per = sistema.buscarPersonaEnSucursalForVista(idSucursal, inputRut);
                            if(per == null) {
                                javax.swing.JOptionPane.showMessageDialog(ventana, "No se encontró la persona en esa sucursal");
                            }
                            else{
                                String info = "RUT: "+ per.getRut()+ "\n"+
                                              "Nombre: "+ per.getNombre()+ "\n"+
                                              "Fecha nacimiento: "+ per.getFechaNacimiento();
                            JOptionPane.showMessageDialog(ventana,info,"Persona encontrada", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(ventana, "El ID debe ser un número entero");
                    }
                }
            });
            
            //BOTON GUARDAR Y SALIR
            JButton btnGuaAndSal= new JButton("Guardar y Salir"); 
            btnGuaAndSal.setPreferredSize(new java.awt.Dimension(200,40));
            panelPrincipal.add(btnGuaAndSal); 
            
            btnGuaAndSal.addActionListener(e -> {
                int opcion = javax.swing.JOptionPane.showConfirmDialog(ventana, 
                    "¿Está seguro que desea guardar los datos y salir?", 
                    "Confirmar salida", 
                    javax.swing.JOptionPane.YES_NO_OPTION);
                if(opcion == javax.swing.JOptionPane.YES_OPTION) {
                    sistema.guardarDatosEnBd();
                    javax.swing.JOptionPane.showMessageDialog(ventana, "Datos guardados exitosamente. Cerrando aplicación...");
                    System.exit(0);
                }
            });
            
            // Agregar el panel principal a la ventana
            ventana.add(panelPrincipal, java.awt.BorderLayout.CENTER);
            
        });
    }
}

