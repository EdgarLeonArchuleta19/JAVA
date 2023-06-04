package com.login;

import com.admin.adminView;
import com.admin.capsView;
import com.sql.SqlServer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;
    public static String userName, password, bdNombre, serverIp;
    private int cont = 0;

    public Login() {
        initComponents();
        PassError.setVisible(false);
        setLocationMove(0, 0);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/images/favicon.png"));
        setIconImage(iconoPropio);
        accionRegen(1);

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
        PanelLogo = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnEsp = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        minTxt = new javax.swing.JLabel();
        bdLabel = new javax.swing.JLabel();
        bdNom = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        srvLabel = new javax.swing.JLabel();
        srvIp = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        userLabel = new javax.swing.JLabel();
        userLog = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        userPass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        PassError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bgKeyReleased(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogo.setBackground(new java.awt.Color(204, 255, 204));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logoGif.gif"))); // NOI18N

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(PanelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 520));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/IconL.png"))); // NOI18N
        favicon.setText("INICIAR SESIÓN");
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

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

        btnEsp.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout btnEspLayout = new javax.swing.GroupLayout(btnEsp);
        btnEsp.setLayout(btnEspLayout);
        btnEspLayout.setHorizontalGroup(
            btnEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEspLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEspLayout.setVerticalGroup(
            btnEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEspLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnEspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 724, Short.MAX_VALUE)
                .addComponent(btnEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        bdLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        bdLabel.setText("BASE DE DATOS");
        bg.add(bdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        bdNom.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bdNom.setForeground(new java.awt.Color(204, 204, 204));
        bdNom.setText("Ingrese el nombre de la base de datos");
        bdNom.setBorder(null);
        bdNom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bdNomMousePressed(evt);
            }
        });
        bdNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdNomActionPerformed(evt);
            }
        });
        bdNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bdNomKeyReleased(evt);
            }
        });
        bg.add(bdNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 410, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 410, 20));

        srvLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        srvLabel.setText("SERVIDOR");
        bg.add(srvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        srvIp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        srvIp.setForeground(new java.awt.Color(204, 204, 204));
        srvIp.setText("Ingrese la ip del servidor");
        srvIp.setBorder(null);
        srvIp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                srvIpMousePressed(evt);
            }
        });
        srvIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srvIpActionPerformed(evt);
            }
        });
        srvIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srvIpKeyReleased(evt);
            }
        });
        bg.add(srvIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 410, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 410, 20));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        userLog.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userLog.setForeground(new java.awt.Color(204, 204, 204));
        userLog.setText("Ingrese su nombre de usuario");
        userLog.setBorder(null);
        userLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userLogMousePressed(evt);
            }
        });
        userLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLogActionPerformed(evt);
            }
        });
        userLog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userLogKeyReleased(evt);
            }
        });
        bg.add(userLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 410, 20));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        userPass.setForeground(new java.awt.Color(204, 204, 204));
        userPass.setText("********");
        userPass.setBorder(null);
        userPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userPassMousePressed(evt);
            }
        });
        userPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPassActionPerformed(evt);
            }
        });
        userPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userPassKeyReleased(evt);
            }
        });
        bg.add(userPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 410, 20));

        loginBtn.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("LOG IN");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 270, 40));

        PassError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PassError.setForeground(new java.awt.Color(153, 0, 0));
        PassError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PassError.setText("( ! ) Error de sesión, compruebe los datos nuevamente.");
        bg.add(PassError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 520, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitTxt.setForeground(Color.red);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void userLogMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLogMousePressed
        accionRegen(3);
    }//GEN-LAST:event_userLogMousePressed

    private void accionRegen(int aux) {
        if (srvIp.getText().isEmpty()) {
            srvIp.setText("Ingrese la ip del servidor");
            srvIp.setForeground(new java.awt.Color(204, 204, 204));
        } else if (aux == 1) {
            srvIp.setText("");
            srvIp.setForeground(Color.black);
        }
        if (bdNom.getText().isEmpty()) {
            bdNom.setText("Ingrese el nombre de la base de datos");
            bdNom.setForeground(new java.awt.Color(204, 204, 204));
        } else if (aux == 2) {
            bdNom.setText("");
            bdNom.setForeground(Color.black);
        }
        if (userLog.getText().isEmpty()) {
            userLog.setText("Ingrese su nombre de usuario");
            userLog.setForeground(new java.awt.Color(204, 204, 204));
        } else if (aux == 3) {
            userLog.setText("");
            userLog.setForeground(Color.black);
        }
        if (String.valueOf(userPass.getPassword()).isEmpty()) {
            userPass.setText("********");
            userPass.setForeground(new java.awt.Color(204, 204, 204));
        } else if (aux == 4) {
            userPass.setText("");
            userPass.setForeground(Color.black);
        }
    }

    private void userPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPassMousePressed
        accionRegen(4);
    }//GEN-LAST:event_userPassMousePressed

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        accionLogin();
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void accionLogin() {
        PassError.setVisible(true);
        SqlServer SQL = new SqlServer();
    
        password = String.valueOf(userPass.getPassword());
        userName = userLog.getText();
        serverIp = srvIp.getText();
        bdNombre = bdNom.getText();
        String cond = "TrustServerCertificate=True;";

        String cone = "jdbc:sqlserver://" + serverIp + ";DatabaseName=" + bdNombre + ";user=" + userName + ";password=" + password + ";" + cond;

        try {
            Connection con = SQL.Conexion(cone);
            if (con != null) {
                this.setVisible(false);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                SQL.desconectar();
                adminView av = new adminView();
            } else {
                PassError.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bdNomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdNomMousePressed
        accionRegen(2);
    }//GEN-LAST:event_bdNomMousePressed

    private void srvIpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srvIpMousePressed
        accionRegen(1);
    }//GEN-LAST:event_srvIpMousePressed

    private void srvIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srvIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srvIpActionPerformed

    private void bdNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdNomActionPerformed

    private void userLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userLogActionPerformed

    private void userPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPassActionPerformed

    private void minTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseClicked
        setExtendedState(1);
    }//GEN-LAST:event_minTxtMouseClicked

    private void minTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseEntered
        minTxt.setForeground(Color.red);
    }//GEN-LAST:event_minTxtMouseEntered

    private void minTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseExited
        minTxt.setForeground(Color.black);
    }//GEN-LAST:event_minTxtMouseExited

    private void bgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bgKeyReleased

    }//GEN-LAST:event_bgKeyReleased

    private void srvIpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srvIpKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            accionRegen(2);
            bdNom.requestFocus();
        }
    }//GEN-LAST:event_srvIpKeyReleased

    private void bdNomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bdNomKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            accionRegen(3);
            userLog.requestFocus();
        }
    }//GEN-LAST:event_bdNomKeyReleased

    private void userPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userPassKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            accionLogin();
        }
    }//GEN-LAST:event_userPassKeyReleased

    private void userLogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userLogKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            accionRegen(4);
            userPass.requestFocus();
        }
    }//GEN-LAST:event_userLogKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JLabel PassError;
    private javax.swing.JLabel bdLabel;
    private javax.swing.JTextField bdNom;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnEsp;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel minTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField srvIp;
    private javax.swing.JLabel srvLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userLog;
    private javax.swing.JPasswordField userPass;
    // End of variables declaration//GEN-END:variables

    public String returnUser() {
        return userName;
    }

    public String returnPass() {
        return password;
    }

    public String returnSrv() {
        return serverIp;
    }

    public String returnBdNom() {
        return bdNombre;
    }

    
}
