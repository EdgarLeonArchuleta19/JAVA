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

/**
 *
 * @author Arctric
 */
public class consView extends javax.swing.JPanel {

    Login lg = new Login();
    Connection con = null;
    SqlServer SQL = new SqlServer();
    String famV = "TODAS", cve, nomA, desA, prcA;
    ArrayList<Articulos> Arts;
    DefaultTableModel model;

    public consView() {
        initComponents();
        creacionTabla();
    }

    private void creacionTabla() {
        familiasComboBox.addItem("TODAS");
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
            Logger.getLogger(consView.class.getName()).log(Level.SEVERE, null, ex);
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
        ConsultaBtn = new javax.swing.JPanel();
        consultaBtnTxt = new javax.swing.JLabel();
        ScrollTablaArts = new javax.swing.JScrollPane();
        TablaArts = new javax.swing.JTable();

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

        ConsultaBtn.setBackground(new java.awt.Color(0, 134, 190));

        consultaBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        consultaBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        consultaBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consultaBtnTxt.setText("CONSULTA");
        consultaBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        consultaBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                consultaBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                consultaBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ConsultaBtnLayout = new javax.swing.GroupLayout(ConsultaBtn);
        ConsultaBtn.setLayout(ConsultaBtnLayout);
        ConsultaBtnLayout.setHorizontalGroup(
            ConsultaBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consultaBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );
        ConsultaBtnLayout.setVerticalGroup(
            ConsultaBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consultaBtnTxt)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cveS)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(desATxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(ConsultaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ScrollTablaArts, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(familiasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConsultaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollTablaArts, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void familiasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familiasComboBoxActionPerformed
        famV = familiasComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_familiasComboBoxActionPerformed

    private void consultaBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaBtnTxtMouseExited
        ConsultaBtn.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_consultaBtnTxtMouseExited

    private void consultaBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaBtnTxtMouseEntered
        ConsultaBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_consultaBtnTxtMouseEntered

    private void consultaBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaBtnTxtMouseClicked
        reiniciarTabla();
        consultaAccion();
    }//GEN-LAST:event_consultaBtnTxtMouseClicked

    private void reiniciarTabla() {
        int fila = TablaArts.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void consultaAccion() {
        Arts = new ArrayList<>();
        asignarVariables();

        String consulta = "Select art.artid, fam.famid, art.artnombre, art.artdescripcion, art.artprecio, fam.famnombre "
                + "from articulos art "
                + "inner join familias fam on fam.famid = art.famid "
                + "where artid like '" + cve + "' and artnombre like '" + nomA + "' "
                + "and artdescripcion like '" + desA + "' and "
                + "artprecio like '" + prcA + "' and famnombre like '" + famV + "' ";

        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(consulta);
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
        if (famV.equals("TODAS")) {
            famV = "%%";
        } else {
            famV = "%" + famV + "%";
        }
    }

    private void fullComboBox() throws SQLException {
        String cone = "jdbc:sqlserver://" + lg.returnSrv() + ";DatabaseName=" + lg.returnBdNom() + ";user=" + lg.returnUser() + ";password=" + lg.returnPass() + "; TrustServerCertificate=True;";
        try {
            con = SQL.Conexion(cone);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(consView.class.getName()).log(Level.SEVERE, null, ex);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConsultaBtn;
    private javax.swing.JScrollPane ScrollTablaArts;
    private javax.swing.JTable TablaArts;
    private javax.swing.JLabel consultaBtnTxt;
    private javax.swing.JSeparator cveS;
    private javax.swing.JLabel cveTxt;
    private javax.swing.JTextField cveV;
    private javax.swing.JSeparator desAS;
    private javax.swing.JLabel desATxt;
    private javax.swing.JTextField desAV;
    private javax.swing.JLabel familiaTxt;
    private javax.swing.JComboBox<String> familiasComboBox;
    private javax.swing.JSeparator nomAS;
    private javax.swing.JLabel nomATxt;
    private javax.swing.JTextField nomAV;
    private javax.swing.JSeparator prcAS;
    private javax.swing.JLabel prcATxt;
    private javax.swing.JTextField prcAV;
    // End of variables declaration//GEN-END:variables

}
