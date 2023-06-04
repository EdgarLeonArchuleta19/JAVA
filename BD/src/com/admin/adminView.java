package com.admin;

import com.login.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class adminView extends javax.swing.JFrame {

    int xMouse, yMouse, pageAct;
    Login lg = new Login();

    public adminView() {
        initComponents();
        this.setVisible(true);
        setLocationMove(0, 0);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/images/favicon.png"));
        setIconImage(iconoPropio);

        consultaAccion();

    }

    private void setLocationMove(int moveWidth, int moveHeight) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        frameSize.width = frameSize.width > screenSize.width ? screenSize.width : frameSize.width;
        frameSize.height = frameSize.height > screenSize.height ? screenSize.height : frameSize.height;
        setLocation((screenSize.width - frameSize.width) / 2 + moveWidth, (screenSize.height - frameSize.height) / 2 + moveHeight);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        userBD = new javax.swing.JLabel();
        conBtn = new javax.swing.JPanel();
        conBtnTxt = new javax.swing.JLabel();
        capBtn = new javax.swing.JPanel();
        capBtnTxt = new javax.swing.JLabel();
        salirBtn = new javax.swing.JPanel();
        salirBtnTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        minTxt = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userBD.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        userBD.setForeground(new java.awt.Color(255, 255, 255));
        userBD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userBD.setText(lg.returnUser());
        bg.add(userBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 250, -1));

        conBtn.setBackground(new java.awt.Color(255, 153, 102));

        conBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        conBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        conBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conBtnTxt.setText("CAPTURA");
        conBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                conBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                conBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout conBtnLayout = new javax.swing.GroupLayout(conBtn);
        conBtn.setLayout(conBtnLayout);
        conBtnLayout.setHorizontalGroup(
            conBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        conBtnLayout.setVerticalGroup(
            conBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        bg.add(conBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, -1));

        capBtn.setBackground(new java.awt.Color(255, 153, 102));

        capBtnTxt.setBackground(new java.awt.Color(0, 153, 153));
        capBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        capBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        capBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        capBtnTxt.setText("CONSULTA");
        capBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        capBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                capBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                capBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout capBtnLayout = new javax.swing.GroupLayout(capBtn);
        capBtn.setLayout(capBtnLayout);
        capBtnLayout.setHorizontalGroup(
            capBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(capBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        capBtnLayout.setVerticalGroup(
            capBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(capBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(capBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, -1));

        salirBtn.setBackground(new java.awt.Color(255, 153, 102));

        salirBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        salirBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        salirBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salirBtnTxt.setText("CERRAR SESIÓN");
        salirBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salirBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout salirBtnLayout = new javax.swing.GroupLayout(salirBtn);
        salirBtn.setLayout(salirBtnLayout);
        salirBtnLayout.setHorizontalGroup(
            salirBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        salirBtnLayout.setVerticalGroup(
            salirBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(salirBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/fondoAnimadoViews.gif"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 530));

        jPanel1.setBackground(new java.awt.Color(175, 221, 224));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 530));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setBackground(new java.awt.Color(255, 255, 255));
        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        minTxt.setBackground(new java.awt.Color(255, 255, 255));
        minTxt.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
        minTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minTxt.setText("-");
        minTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        minTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(724, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        bg.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 590, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 526, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        cerrar();
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitTxt.setForeground(Color.red);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_exitTxtMouseExited

    private void minTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseClicked
        setExtendedState(1);
    }//GEN-LAST:event_minTxtMouseClicked

    private void minTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseEntered
        minTxt.setForeground(Color.red);
    }//GEN-LAST:event_minTxtMouseEntered

    private void minTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseExited
        minTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_minTxtMouseExited

    private void conBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conBtnTxtMouseClicked
        consultaAccion();
    }//GEN-LAST:event_conBtnTxtMouseClicked

    private void consultaAccion() {
        capBtn.setBackground(new Color(255, 153, 102));
        pageAct = 1;
        capsView iU = new capsView();
        iU.setSize(590, 490);
        iU.setLocation(0, 0);
        repaintBtn();
        content.removeAll();
        content.add(iU, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void conBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conBtnTxtMouseEntered
        if (pageAct != 1) {
            conBtn.setBackground(new Color(255, 102, 0));
            if (pageAct == 2) {
                capBtn.setBackground(new Color(255,125,41));
            }
        }
    }//GEN-LAST:event_conBtnTxtMouseEntered

    private void conBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conBtnTxtMouseExited
        if (pageAct != 1) {
            conBtn.setBackground(new Color(255, 153, 102));
            if (pageAct == 2) {
                capBtn.setBackground(new Color(255, 102, 0));
            }
        }
    }//GEN-LAST:event_conBtnTxtMouseExited

    private void capBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capBtnTxtMouseClicked
        capturaAccion();
    }//GEN-LAST:event_capBtnTxtMouseClicked

    private void capturaAccion() {
        conBtn.setBackground(new Color(255, 153, 102));
        pageAct = 2;
        consView cV = new consView();
        cV.setSize(590, 490);
        cV.setLocation(0, 0);
        repaintBtn();
        content.removeAll();
        content.add(cV, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void capBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capBtnTxtMouseEntered
        if (pageAct != 2) {
            capBtn.setBackground(new Color(255, 102, 0));
            if (pageAct == 1) {
                conBtn.setBackground(new Color(255,125,41));
            }
        }
    }//GEN-LAST:event_capBtnTxtMouseEntered

    private void capBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capBtnTxtMouseExited
        if (pageAct != 2) {
            capBtn.setBackground(new Color(255, 153, 102));
            if (pageAct == 1) {
                conBtn.setBackground(new Color(255, 102, 0));
            }
        }
    }//GEN-LAST:event_capBtnTxtMouseExited

    private void salirBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirBtnTxtMouseClicked
        try {
            this.setVisible(false);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        lg.setVisible(true);
    }//GEN-LAST:event_salirBtnTxtMouseClicked

    private void salirBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirBtnTxtMouseEntered
        salirBtn.setBackground(new Color(255, 102, 0));
        if (pageAct == 1) {
            conBtn.setBackground(new Color(255,125,41));
        } else {
            capBtn.setBackground(new Color(255,125,41));
        }

    }//GEN-LAST:event_salirBtnTxtMouseEntered

    private void salirBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirBtnTxtMouseExited
        salirBtn.setBackground(new Color(255, 153, 102));
        if (pageAct == 1) {
            conBtn.setBackground(new Color(255, 102, 0));
        } else {
            capBtn.setBackground(new Color(255, 102, 0));
        }
    }//GEN-LAST:event_salirBtnTxtMouseExited

    public void cerrar() {
        System.exit(0);
    }

    private void repaintBtn() {
        if (pageAct == 1) {
            conBtn.setBackground(new Color(255, 102, 0));
        } else if (pageAct == 2) {
            capBtn.setBackground(new Color(255, 102, 0));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel capBtn;
    private javax.swing.JLabel capBtnTxt;
    private javax.swing.JPanel conBtn;
    private javax.swing.JLabel conBtnTxt;
    public javax.swing.JPanel content;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minTxt;
    private javax.swing.JPanel salirBtn;
    private javax.swing.JLabel salirBtnTxt;
    private javax.swing.JLabel userBD;
    // End of variables declaration//GEN-END:variables
}
