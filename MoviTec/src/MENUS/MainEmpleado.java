package MENUS;

import javax.swing.*;
import LOGIN.Login;
import SQL.MetodosSQL;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static SQL.MetodosSQL.datosEmpleado;




public final class MainEmpleado extends javax.swing.JFrame {

  
    //Instanciamos la clase MetodosSQL para usar todos los procedimientos.
    MetodosSQL metodos = new MetodosSQL();
    //Combo box para el estatus de las solicitudes.
    JComboBox<String> JcEstatus;


    
    //Se inician los componentes del JPanel para que se cambie al correspondiente y se rellenan los datos del empleado.
    public MainEmpleado() {
        initComponents();
        setLocationRelativeTo(null);      
        setTitle("MoviTec Coordinador");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/IMG/Logo.png")).getImage());
        PanelPrincipal.removeAll();
        PanelPrincipal.add(JPerfil);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();  
        RellenarDatosPerfil();
        
    }

    
    //Metodo para rellenar datos del empleado
      public void RellenarDatosPerfil(){ 
        JNoControl.setText(datosEmpleado[0]);
        JNombre.setText(datosEmpleado[1]);
        JApellido.setText(datosEmpleado[2]);
        JInstituto.setText(datosEmpleado[3]);
        JTelefono.setText(datosEmpleado[4]);
        JCorreo.setText(datosEmpleado[5]);
        JCarrera.setText(datosEmpleado[6]);
        JPuesto.setText(datosEmpleado[7]);
  
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JMenuBarra = new javax.swing.JPanel();
        BtnPerfil = new javax.swing.JButton();
        BtnSolicitudes = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        PanelPrincipal = new javax.swing.JTabbedPane();
        JPerfil = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JNoControl = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JCarrera = new javax.swing.JTextField();
        JTelefono = new javax.swing.JTextField();
        JCorreo = new javax.swing.JTextField();
        JInstituto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPuesto = new javax.swing.JTextField();
        JSolicitudes = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnCancelar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaPlanEstudios = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaMovilidades = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaAlumno = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JMenuBarra.setBackground(new java.awt.Color(51, 102, 255));

        BtnPerfil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnPerfil.setForeground(new java.awt.Color(51, 102, 255));
        BtnPerfil.setText("PERFIL");
        BtnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPerfilActionPerformed(evt);
            }
        });

        BtnSolicitudes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnSolicitudes.setForeground(new java.awt.Color(51, 102, 255));
        BtnSolicitudes.setText("SOLICITUDES");
        BtnSolicitudes.setBorder(null);
        BtnSolicitudes.setBorderPainted(false);
        BtnSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSolicitudesActionPerformed(evt);
            }
        });

        BtnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnSalir.setForeground(new java.awt.Color(51, 102, 255));
        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Salir.png"))); // NOI18N
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JMenuBarraLayout = new javax.swing.GroupLayout(JMenuBarra);
        JMenuBarra.setLayout(JMenuBarraLayout);
        JMenuBarraLayout.setHorizontalGroup(
            JMenuBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JMenuBarraLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(JMenuBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JMenuBarraLayout.createSequentialGroup()
                        .addComponent(BtnSalir)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JMenuBarraLayout.createSequentialGroup()
                        .addGroup(JMenuBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        JMenuBarraLayout.setVerticalGroup(
            JMenuBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JMenuBarraLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BtnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(BtnSalir)
                .addGap(32, 32, 32))
        );

        getContentPane().add(JMenuBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 580));

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        JPerfil.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Perfiles.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("DATOS PERSONALES: ");

        jLabel6.setText("NOMBRE:");

        JNombre.setEditable(false);

        jLabel7.setText("APELLIDO:");

        JApellido.setEditable(false);

        jLabel8.setText("NO. CONTROL:");

        JNoControl.setEditable(false);

        jLabel10.setText("TELEFONO:");

        jLabel11.setText("CORREO:");

        jLabel12.setText("INSTITUTO:");

        jLabel13.setText("CARRERA:");

        JCarrera.setEditable(false);

        JTelefono.setEditable(false);

        JCorreo.setEditable(false);

        JInstituto.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("DATOS EDUCATIVOS: ");

        jLabel2.setText("PUESTO:");

        JPuesto.setEditable(false);

        javax.swing.GroupLayout JPerfilLayout = new javax.swing.GroupLayout(JPerfil);
        JPerfil.setLayout(JPerfilLayout);
        JPerfilLayout.setHorizontalGroup(
            JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPerfilLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPerfilLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPerfilLayout.createSequentialGroup()
                        .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPerfilLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPerfilLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JPerfilLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(JNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPerfilLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(JTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JPerfilLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(JApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE))
                            .addGroup(JPerfilLayout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPerfilLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPerfilLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JNoControl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(JPerfilLayout.createSequentialGroup()
                        .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JInstituto, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(JPuesto))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(JCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        JPerfilLayout.setVerticalGroup(
            JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPerfilLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JNoControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(JCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addComponent(jLabel16)
                .addGap(48, 48, 48)
                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(JCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(JPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        PanelPrincipal.addTab("", JPerfil);

        JSolicitudes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("SOLICITUDES DE MOVILIDAD ESTUDIANTIL");

        BtnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        BtnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Guardar.png"))); // NOI18N
        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnBuscar.setBackground(new java.awt.Color(0, 102, 255));
        BtnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        BtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Buscar.png"))); // NOI18N
        BtnBuscar.setText("Ver detalle");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnCancelar1.setBackground(new java.awt.Color(0, 102, 255));
        BtnCancelar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Cancelar.png"))); // NOI18N
        BtnCancelar1.setText("Cancelar");
        BtnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelar1ActionPerformed(evt);
            }
        });

        TablaPlanEstudios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATERIAS"
            }
        ));
        jScrollPane3.setViewportView(TablaPlanEstudios);
        if (TablaPlanEstudios.getColumnModel().getColumnCount() > 0) {
            TablaPlanEstudios.getColumnModel().getColumn(0).setResizable(false);
        }

        TablaMovilidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha solicitud", "Alumno", "Instituto de Destino", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TablaMovilidades);
        if (TablaMovilidades.getColumnModel().getColumnCount() > 0) {
            TablaMovilidades.getColumnModel().getColumn(0).setResizable(false);
            TablaMovilidades.getColumnModel().getColumn(1).setResizable(false);
            TablaMovilidades.getColumnModel().getColumn(2).setResizable(false);
            TablaMovilidades.getColumnModel().getColumn(3).setResizable(false);
            TablaMovilidades.getColumnModel().getColumn(4).setResizable(false);
        }

        TablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INFO", "ALUMNO"
            }
        ));
        jScrollPane4.setViewportView(TablaAlumno);
        if (TablaAlumno.getColumnModel().getColumnCount() > 0) {
            TablaAlumno.getColumnModel().getColumn(0).setResizable(false);
            TablaAlumno.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout JSolicitudesLayout = new javax.swing.GroupLayout(JSolicitudes);
        JSolicitudes.setLayout(JSolicitudesLayout);
        JSolicitudesLayout.setHorizontalGroup(
            JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JSolicitudesLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JSolicitudesLayout.createSequentialGroup()
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(BtnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCancelar1)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JSolicitudesLayout.createSequentialGroup()
                        .addGroup(JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(JSolicitudesLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JSolicitudesLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(242, 242, 242))))
        );
        JSolicitudesLayout.setVerticalGroup(
            JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JSolicitudesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBuscar)
                    .addGroup(JSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGuardar)))
                .addGap(66, 66, 66))
        );

        PanelPrincipal.addTab("", JSolicitudes);

        getContentPane().add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, -29, 870, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //Boton para cerrar la sesion con un joptionpane
    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
  int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar tu sesión?", "Confirmación de salida", JOptionPane.YES_NO_OPTION);
  
       if (respuesta == JOptionPane.YES_OPTION) {
           new Login().setVisible(true);
           dispose();
      }
      
    }//GEN-LAST:event_BtnSalirActionPerformed

    
    
    //Boton de la barra de menu para meterse a la seccion del perfil del empleado
    private void BtnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPerfilActionPerformed
        PanelPrincipal.removeAll();
        PanelPrincipal.add(JPerfil);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();       
    }//GEN-LAST:event_BtnPerfilActionPerformed

    
    //Boton de la barra de menu para meterse a la seccion de las solicitudes, en donde iniciamos una tabla en la cual se
    //Van a mostrar las movilidades de nuestra BD, tambien declaramos el JCombo Box de estatus para que tenga diferentes
    //Opciones.
    private void BtnSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSolicitudesActionPerformed
        PanelPrincipal.removeAll();
        PanelPrincipal.add(JSolicitudes);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();  
        DefaultTableModel modeloTabla = (DefaultTableModel) TablaMovilidades.getModel();
        modeloTabla.setRowCount(0);
        MetodosSQL.SeleccionarSolicitudesEmpleado(TablaMovilidades, JCarrera.getText(), JInstituto.getText());
        JcEstatus = new JComboBox<>(new String[]{"En Revisión", "Aceptado", "Rechazado", "Cancelado"});
        TableColumn estatusColumn2 = TablaMovilidades.getColumnModel().getColumn(4);
        estatusColumn2.setCellEditor(new DefaultCellEditor(JcEstatus));
        
    }//GEN-LAST:event_BtnSolicitudesActionPerformed

    
    
    //Boton buscar llama a dos metodos de la clase MetodosSQL uno para mostrar las materias del folio selcionado en la 
    //Tabla y otro para mostrar al alumno que corresponde a dicho folio de la BD.
    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed

        MetodosSQL.mostrarMateriasPorFolio(TablaPlanEstudios, TablaMovilidades);   
        DefaultTableModel modeloTabla = (DefaultTableModel) TablaAlumno.getModel();
        modeloTabla.setRowCount(0);      
        MetodosSQL.buscarDatosAlumnoPorFolioMovilidad(TablaMovilidades,TablaAlumno);
        
    }//GEN-LAST:event_BtnBuscarActionPerformed

    
    
    //Boton cancenlar limpia la interfaz y regresa las tablas a sus valores originales para empezar de nuevo.
    private void BtnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelar1ActionPerformed
        DefaultTableModel modeloTabla = (DefaultTableModel) TablaMovilidades.getModel();
        modeloTabla.setRowCount(0);
        DefaultTableModel modeloTabla2 = (DefaultTableModel) TablaPlanEstudios.getModel();
        modeloTabla2.setRowCount(0);
        DefaultTableModel modeloTabla3 = (DefaultTableModel) TablaAlumno.getModel();
        modeloTabla3.setRowCount(0);
        MetodosSQL.SeleccionarSolicitudesEmpleado(TablaMovilidades,JCarrera.getText(),JInstituto.getText());
    }//GEN-LAST:event_BtnCancelar1ActionPerformed

    
    //Boton guardar, verifica si el estatus es aceptado primero, y llena las fechas de inicio y fin
    //automaticamente con un metodo especial en MetodosSQL, despues recoge el valor selecionado y lo actualiza.
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
    
       int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios?", "Confirmación de cambios", JOptionPane.YES_NO_OPTION); 
       if (respuesta == JOptionPane.YES_OPTION) {
           
        String Estatus = JcEstatus.getSelectedItem().toString();
        MetodosSQL.modificarRegistroSeleccionado(TablaMovilidades);
      }
     
    }//GEN-LAST:event_BtnGuardarActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar1;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnPerfil;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton BtnSolicitudes;
    private javax.swing.JTextField JApellido;
    private javax.swing.JTextField JCarrera;
    private javax.swing.JTextField JCorreo;
    private javax.swing.JTextField JInstituto;
    private javax.swing.JPanel JMenuBarra;
    private javax.swing.JTextField JNoControl;
    private javax.swing.JTextField JNombre;
    private javax.swing.JPanel JPerfil;
    private javax.swing.JTextField JPuesto;
    private javax.swing.JPanel JSolicitudes;
    private javax.swing.JTextField JTelefono;
    private javax.swing.JTabbedPane PanelPrincipal;
    private javax.swing.JTable TablaAlumno;
    public static javax.swing.JTable TablaMovilidades;
    private javax.swing.JTable TablaPlanEstudios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
