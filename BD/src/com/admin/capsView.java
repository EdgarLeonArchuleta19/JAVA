package com.admin;

import com.login.Login;
import com.sql.SqlServer;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;

/**
 *
 * @author Arctric
 */
public class capsView extends javax.swing.JPanel {

    Login lg = new Login();
    Connection con = null;
    SqlServer SQL = new SqlServer();
    String famV = "TODAS", cve, nomA, desA, prcA;
    ArrayList<Articulos> Arts;
    DefaultTableModel model;
    int pagAnt = 0;

    public capsView() {
        initComponents();
        creacionTabla();
        errorLimpiar.setVisible(false);
        errorLlenarDatos.setVisible(false);
        datosTabla();
        botonNuevo();
        nuevoBtn.setSelected(true);
    }

    private void creacionTabla() {
        model = new DefaultTableModel();
        model.addColumn("ART ID");
        model.addColumn("FAM ID");
        model.addColumn("ART NOMBRE");
        model.addColumn("ART DESC");
        model.addColumn("ART PRECIO");
        model.addColumn("NOM FAMILIA");
        this.TablaArts.setModel(model);
        try {
            fullComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(capsView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cveTxt = new javax.swing.JLabel();
        cveV = new javax.swing.JTextField();
        cveS = new javax.swing.JSeparator();
        nomATxt = new javax.swing.JLabel();
        nomAV = new javax.swing.JTextField();
        nomAS = new javax.swing.JSeparator();
        desATxt = new javax.swing.JLabel();
        desAV = new javax.swing.JTextField();
        desAS = new javax.swing.JSeparator();
        prcATxt = new javax.swing.JLabel();
        prcAV = new javax.swing.JTextField();
        prcAS = new javax.swing.JSeparator();
        familiaTxt = new javax.swing.JLabel();
        familiasComboBox = new javax.swing.JComboBox<>();
        limpiarBtn = new javax.swing.JPanel();
        limpiarBtnTxt = new javax.swing.JLabel();
        ScrollTablaArts = new javax.swing.JScrollPane();
        TablaArts = new javax.swing.JTable();
        grabarBtn = new javax.swing.JPanel();
        grabarBtnTxt = new javax.swing.JLabel();
        nuevoBtn = new javax.swing.JCheckBox();
        modificarBtn = new javax.swing.JCheckBox();
        eliminarBtn = new javax.swing.JCheckBox();
        errorLimpiar = new javax.swing.JLabel();
        errorLlenarDatos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(590, 490));

        cveTxt.setFont(new java.awt.Font("Roboto Light", 1, 10)); // NOI18N
        cveTxt.setText("CLAVE");

        cveV.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cveV.setForeground(new java.awt.Color(51, 51, 51));
        cveV.setBorder(null);
        cveV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cveVMousePressed(evt);
            }
        });
        cveV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cveVActionPerformed(evt);
            }
        });
        cveV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cveVKeyReleased(evt);
            }
        });

        cveS.setForeground(new java.awt.Color(0, 0, 0));

        nomATxt.setFont(new java.awt.Font("Roboto Light", 1, 10)); // NOI18N
        nomATxt.setText("NOMBRE DEL ARTICULO");

        nomAV.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nomAV.setForeground(new java.awt.Color(51, 51, 51));
        nomAV.setBorder(null);
        nomAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nomAVMousePressed(evt);
            }
        });
        nomAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomAVActionPerformed(evt);
            }
        });
        nomAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomAVKeyReleased(evt);
            }
        });

        nomAS.setForeground(new java.awt.Color(0, 0, 0));

        desATxt.setFont(new java.awt.Font("Roboto Light", 1, 10)); // NOI18N
        desATxt.setText("DESCRIPCIÓN DEL ARTICULO");

        desAV.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        desAV.setForeground(new java.awt.Color(51, 51, 51));
        desAV.setBorder(null);
        desAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                desAVMousePressed(evt);
            }
        });
        desAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desAVActionPerformed(evt);
            }
        });
        desAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desAVKeyReleased(evt);
            }
        });

        desAS.setForeground(new java.awt.Color(0, 0, 0));

        prcATxt.setFont(new java.awt.Font("Roboto Light", 1, 10)); // NOI18N
        prcATxt.setText("PRECIO DEL ARTICULO");

        prcAV.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        prcAV.setForeground(new java.awt.Color(51, 51, 51));
        prcAV.setBorder(null);
        prcAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prcAVMousePressed(evt);
            }
        });
        prcAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prcAVActionPerformed(evt);
            }
        });
        prcAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prcAVKeyReleased(evt);
            }
        });

        prcAS.setForeground(new java.awt.Color(0, 0, 0));

        familiaTxt.setFont(new java.awt.Font("Roboto Light", 1, 10)); // NOI18N
        familiaTxt.setText("FAMILIA");

        familiasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>());
        familiasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familiasComboBoxActionPerformed(evt);
            }
        });

        limpiarBtn.setBackground(new java.awt.Color(0, 134, 190));

        limpiarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 12)); // NOI18N
        limpiarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        limpiarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        limpiarBtnTxt.setText("LIMPIAR");
        limpiarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                limpiarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                limpiarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout limpiarBtnLayout = new javax.swing.GroupLayout(limpiarBtn);
        limpiarBtn.setLayout(limpiarBtnLayout);
        limpiarBtnLayout.setHorizontalGroup(
            limpiarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(limpiarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        limpiarBtnLayout.setVerticalGroup(
            limpiarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(limpiarBtnTxt)
        );

        TablaArts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ART ID", "FAM ID", "ARTNOMBRE", "ART DESC", "ART PRECIO", "NOM FAMILIA"
            }
        ));
        ScrollTablaArts.setViewportView(TablaArts);

        grabarBtn.setBackground(new java.awt.Color(0, 134, 190));

        grabarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 12)); // NOI18N
        grabarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        grabarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grabarBtnTxt.setText("GRABAR");
        grabarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grabarBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grabarBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grabarBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                grabarBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout grabarBtnLayout = new javax.swing.GroupLayout(grabarBtn);
        grabarBtn.setLayout(grabarBtnLayout);
        grabarBtnLayout.setHorizontalGroup(
            grabarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(grabarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        grabarBtnLayout.setVerticalGroup(
            grabarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(grabarBtnTxt)
        );

        nuevoBtn.setText("NUEVO");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("MODIFICAR");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("ELIMINAR");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        errorLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        errorLimpiar.setForeground(new java.awt.Color(153, 0, 0));
        errorLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLimpiar.setText("( ! ) No se pueden limpiar datos en MODIFICAR!");

        errorLlenarDatos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        errorLlenarDatos.setForeground(new java.awt.Color(153, 0, 0));
        errorLlenarDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLlenarDatos.setText("( ! ) Faltaron datos por llenar, revise nuevamente!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cveS)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(desATxt, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addGap(264, 264, 264))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(familiaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(369, 369, 369))
                    .addComponent(nomAS)
                    .addComponent(prcAS)
                    .addComponent(nomAV)
                    .addComponent(prcAV)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomATxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(289, 289, 289))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prcATxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(295, 295, 295))
                    .addComponent(cveV)
                    .addComponent(desAS)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cveTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(376, 376, 376))
                    .addComponent(desAV)
                    .addComponent(familiasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grabarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollTablaArts, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(errorLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(errorLlenarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(cveV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cveS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomATxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(nomAV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nomAS, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desATxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(desAV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desAS, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prcATxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(prcAV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(prcAS, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(familiaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(familiasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limpiarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nuevoBtn)
                                .addComponent(modificarBtn)
                                .addComponent(eliminarBtn))))
                    .addComponent(grabarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTablaArts, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(errorLimpiar)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(461, Short.MAX_VALUE)
                    .addComponent(errorLlenarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cveVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cveVMousePressed

    }//GEN-LAST:event_cveVMousePressed

    private void cveVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cveVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cveVActionPerformed

    private void cveVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cveVKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            if (modificarBtn.isSelected()) {
                nomAV.setEnabled(true);
                desAV.setEnabled(true);
                prcAV.setEnabled(true);
                familiasComboBox.setEnabled(true);
                recuperarDatos();

                nomAV.setBackground(new Color(255, 255, 255));
                desAV.setBackground(new Color(255, 255, 255));
                prcAV.setBackground(new Color(255, 255, 255));
                familiasComboBox.setBackground(new Color(255, 255, 255));
            }
            nomAV.requestFocus();
        }
    }//GEN-LAST:event_cveVKeyReleased


    private void nomAVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomAVMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomAVMousePressed

    private void nomAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomAVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomAVActionPerformed

    private void nomAVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomAVKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            desAV.requestFocus();
        }
    }//GEN-LAST:event_nomAVKeyReleased

    private void desAVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desAVMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_desAVMousePressed

    private void desAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desAVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desAVActionPerformed

    private void desAVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desAVKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            prcAV.requestFocus();
        }
    }//GEN-LAST:event_desAVKeyReleased

    private void prcAVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prcAVMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_prcAVMousePressed

    private void prcAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prcAVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prcAVActionPerformed

    private void prcAVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prcAVKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            familiasComboBox.showPopup();
            familiasComboBox.requestFocus();
        }
    }//GEN-LAST:event_prcAVKeyReleased

    private void limpiarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarBtnTxtMouseClicked
        if (nuevoBtn.isSelected()) {
            nomAV.setText("");
            desAV.setText("");
            prcAV.setText("");
            familiasComboBox.setSelectedIndex(0);
            errorLimpiar.setVisible(false);
        } else if (eliminarBtn.isSelected()) {
            cveV.setText("");
            nomAV.setText("");
            desAV.setText("");
            prcAV.setText("");
            familiasComboBox.setSelectedIndex(0);
            errorLimpiar.setVisible(false);
        } else {
            errorLimpiar.setVisible(true);
        }
    }//GEN-LAST:event_limpiarBtnTxtMouseClicked

    private void limpiarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarBtnTxtMouseEntered
        limpiarBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_limpiarBtnTxtMouseEntered

    private void limpiarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarBtnTxtMouseExited
        limpiarBtn.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_limpiarBtnTxtMouseExited

    private void familiasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familiasComboBoxActionPerformed
        famV = familiasComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_familiasComboBoxActionPerformed

    private void grabarBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grabarBtnTxtMouseClicked
        errorLlenarDatos.setVisible(false);
        if (nuevoBtn.isSelected()) {
            if(validacion()){
                nuevoAccion();
            }else{
                errorLlenarDatos.setVisible(true);
            }
        } else if (modificarBtn.isSelected()) {
            if(validacion()){
                modificarAccion();
            }else{
                errorLlenarDatos.setVisible(true);
            }
        } else if (eliminarBtn.isSelected()) {
            eliminarAccion();
        }
    }//GEN-LAST:event_grabarBtnTxtMouseClicked

    private void grabarBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grabarBtnTxtMouseEntered
        grabarBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_grabarBtnTxtMouseEntered

    private void grabarBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grabarBtnTxtMouseExited
        grabarBtn.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_grabarBtnTxtMouseExited

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        errorLlenarDatos.setVisible(false);
        botonNuevo();
    }//GEN-LAST:event_nuevoBtnActionPerformed
    private void botonNuevo() {
        errorLimpiar.setVisible(false);
        modificarBtn.setSelected(false);
        eliminarBtn.setSelected(false);
        cveV.setEnabled(false);
        cveV.setText("******************");
        cveV.setBackground(new Color(204, 255, 255));

        if (pagAnt == 2) {
            nomAV.setEnabled(true);
            desAV.setEnabled(true);
            prcAV.setEnabled(true);
            familiasComboBox.setEnabled(true);

            nomAV.setText("");
            desAV.setText("");
            prcAV.setText("");

            nomAV.setBackground(new Color(255, 255, 255));
            desAV.setBackground(new Color(255, 255, 255));
            prcAV.setBackground(new Color(255, 255, 255));
            familiasComboBox.setBackground(new Color(255, 255, 255));
        }

        pagAnt = 1;
    }

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        errorLlenarDatos.setVisible(false);
        errorLimpiar.setVisible(false);
        nuevoBtn.setSelected(false);
        eliminarBtn.setSelected(false);

        nomAV.setEnabled(false);
        desAV.setEnabled(false);
        prcAV.setEnabled(false);
        familiasComboBox.setEnabled(false);

        nomAV.setText("******************");
        desAV.setText("******************");
        prcAV.setText("******************");

        nomAV.setBackground(new Color(204, 255, 255));
        desAV.setBackground(new Color(204, 255, 255));
        prcAV.setBackground(new Color(204, 255, 255));
        familiasComboBox.setBackground(new Color(204, 255, 255));

        if (pagAnt == 1) {
            cveV.setEnabled(true);
            cveV.setText("");
            cveV.setBackground(new Color(255, 255, 255));
        }

        pagAnt = 2;

    }//GEN-LAST:event_modificarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        errorLlenarDatos.setVisible(false);
        errorLimpiar.setVisible(false);
        nuevoBtn.setSelected(false);
        modificarBtn.setSelected(false);

        cveV.setEnabled(true);
        cveV.setText("");
        cveV.setBackground(new Color(255, 255, 255));
        nomAV.setEnabled(true);
        desAV.setEnabled(true);
        prcAV.setEnabled(true);
        familiasComboBox.setEnabled(true);

        nomAV.setText("");
        desAV.setText("");
        prcAV.setText("");

        nomAV.setBackground(new Color(255, 255, 255));
        desAV.setBackground(new Color(255, 255, 255));
        prcAV.setBackground(new Color(255, 255, 255));
        familiasComboBox.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_eliminarBtnActionPerformed

//  LLENADO DE COMBOBOX
    private void fullComboBox() throws SQLException {
        String cone = "jdbc:sqlserver://" + lg.returnSrv() + ";DatabaseName=" + lg.returnBdNom() + ";user=" + lg.returnUser() + ";password=" + lg.returnPass() + "; TrustServerCertificate=True;";
        try {
            con = SQL.Conexion(cone);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(capsView.class.getName()).log(Level.SEVERE, null, ex);
        }

        String familias = "Select * from familias";

        ResultSet rs = null;
        PreparedStatement ps = null;

        ps = con.prepareStatement(familias);
        rs = ps.executeQuery();
        while (rs.next()) {
            familiasComboBox.addItem(rs.getString(2));
        }
        ps.close();
        rs.close();
    }

//  BOTONES DE FUNCIONES DE CAPTURA
    private void nuevoAccion() {
        int idFamilia = returnFamId();

        try {
            CallableStatement cst = con.prepareCall("{call SP_ArticulosInsertar (?,?,?,?)}");
            cst.setString(1, nomAV.getText());
            cst.setString(2, desAV.getText());
            cst.setDouble(3, Double.parseDouble(prcAV.getText()));
            cst.setInt(4, idFamilia);
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(capsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        datosTabla();
    }

    private void eliminarAccion() {
        asignarVariables();
        String idFamilia = String.valueOf(returnFamId());

        try {
            CallableStatement cst = con.prepareCall("{call SP_ArticulosEliminar (?,?,?,?,?)}");
            cst.setString(1, cve);
            cst.setString(2, nomA);
            cst.setString(3, desA);
            cst.setString(4, prcA);
            cst.setString(5, idFamilia);
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(capsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        datosTabla();
    }

    private void modificarAccion() {
        int idFamilia = returnFamId();

        try {
            CallableStatement cst = con.prepareCall("{call SP_ArticulosActualizar (?,?,?,?,?)}");
            cst.setInt(1, Integer.parseInt(cveV.getText()));
            cst.setString(2, nomAV.getText());
            cst.setString(3, desAV.getText());
            cst.setDouble(4, Double.parseDouble(prcAV.getText()));
            cst.setInt(5, idFamilia);
            cst.execute();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(capsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        datosTabla();
    }

    private int returnFamId() {
        int idFamilia = 0;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String famID = "Select famid "
                + "from familias "
                + "where famnombre = '" + famV + "'";
        try {
            ps = con.prepareStatement(famID);
            rs = ps.executeQuery();
            rs.next();
            idFamilia = rs.getInt(1);
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(capsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idFamilia;
    }

//  METODOS PARA EL LLENADO DE LA TABLA
    private void recuperarDatos() {
        String datos = "Select art.artnombre, art.artdescripcion, art.artprecio, fam.famnombre "
                + "from articulos art "
                + "inner join familias fam on fam.famid = art.famid "
                + "where art.artid = '" + cveV.getText() + "'";

        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(datos);
            rs = ps.executeQuery();
            rs.next();
            nomAV.setText(rs.getString(1));
            desAV.setText(rs.getString(2));
            prcAV.setText(String.valueOf(rs.getDouble(3)));
            familiasComboBox.setSelectedItem(rs.getString(4));
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(consView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void datosTabla() {
        reiniciarTabla();
        Arts = new ArrayList<>();
        String datos = "Select art.artid, fam.famid, art.artnombre, art.artdescripcion, art.artprecio, fam.famnombre "
                + "from articulos art "
                + "inner join familias fam on fam.famid = art.famid";

        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(datos);
            rs = ps.executeQuery();
            while (rs.next()) {
                Arts.add(new Articulos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6)));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(consView.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < Arts.size(); i++) {
            String[] ArticulosC = new String[6];
            ArticulosC[0] = Integer.toString(Arts.get(i).getArtID());
            ArticulosC[1] = Integer.toString(Arts.get(i).getFamID());
            ArticulosC[2] = Arts.get(i).getArtNombre();
            ArticulosC[3] = Arts.get(i).getArtDescripcion();
            ArticulosC[4] = Double.toString(Arts.get(i).getArtPrecio());
            ArticulosC[5] = Arts.get(i).getFamNombre();

            model.addRow(ArticulosC);
        }
    }

    private void reiniciarTabla() {
        int fila = TablaArts.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void asignarVariables() {
        if (cveV.getText().equals("")) {
            cve = "%%";
        } else {
            cve = "%" + cveV.getText() + "%";
        }
        if (nomAV.getText().equals("")) {
            nomA = "%%";
        } else {
            nomA = "%" + nomAV.getText() + "%";
        }
        if (desAV.getText().equals("")) {
            desA = "%%";
        } else {
            desA = "%" + desAV.getText() + "%";
        }
        if (prcAV.getText().equals("")) {
            prcA = "%%";
        } else {
            prcA = "%" + prcAV.getText() + "%";
        }
    }
//  VALIDACIONES
    private boolean validacion(){
        return !"".equals(cveV.getText()) && !"".equals(nomAV.getText()) && !"".equals(desAV.getText()) && !"".equals(prcAV.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollTablaArts;
    private javax.swing.JTable TablaArts;
    private javax.swing.JSeparator cveS;
    private javax.swing.JLabel cveTxt;
    private javax.swing.JTextField cveV;
    private javax.swing.JSeparator desAS;
    private javax.swing.JLabel desATxt;
    private javax.swing.JTextField desAV;
    private javax.swing.JCheckBox eliminarBtn;
    private javax.swing.JLabel errorLimpiar;
    private javax.swing.JLabel errorLlenarDatos;
    private javax.swing.JLabel familiaTxt;
    private javax.swing.JComboBox<String> familiasComboBox;
    private javax.swing.JPanel grabarBtn;
    private javax.swing.JLabel grabarBtnTxt;
    private javax.swing.JPanel limpiarBtn;
    private javax.swing.JLabel limpiarBtnTxt;
    private javax.swing.JCheckBox modificarBtn;
    private javax.swing.JSeparator nomAS;
    private javax.swing.JLabel nomATxt;
    private javax.swing.JTextField nomAV;
    private javax.swing.JCheckBox nuevoBtn;
    private javax.swing.JSeparator prcAS;
    private javax.swing.JLabel prcATxt;
    private javax.swing.JTextField prcAV;
    // End of variables declaration//GEN-END:variables

}
