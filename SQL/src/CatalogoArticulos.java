//Edgar leon archuleta

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CatalogoArticulos extends JFrame {
	

	


		public  String BD ="";
		public  String SERVIDOR ="";
		public  String NOMBREUSUARIO = "";
		public  String CONTRASEÑA = ""; 
		
	
  static JTextField campoTextoserver; 
  static JTextField campoTextobd; 
  static JTextField campoTextouser; 
  static JPasswordField campoTextopass; 
	
	
  private JLabel server;
  private JLabel bd;
  private JLabel user;
  private JLabel pass;
  private JPanel panelNavegar;
  private JButton conectar;
  
  private JLabel status;
  
  private JButton consulta;
  private JButton captura;
  
  
  public MostrarResultadosConsulta mostrarResultadosConsulta = null;
  
  
  public CatalogoArticulos(String titulo) {
	  
    super(titulo);
    
    
    panelNavegar = new JPanel();
     
    
   server = new JLabel();
   campoTextoserver = new JTextField(5);
   bd = new JLabel();
   campoTextobd = new JTextField(5);
   user = new JLabel();
   campoTextouser = new JTextField(5);
   pass = new JLabel();
   campoTextopass = new JPasswordField(5);
   conectar = new JButton();  
   status = new JLabel();
   consulta = new JButton();
   captura = new JButton();
    
   panelNavegar.setLayout(new GridLayout(7, 2, 4, 2));
   
   server.setText("             Servidor");
   panelNavegar.add(server); 
   panelNavegar.add(campoTextoserver);
   
   
   bd.setText("            Base de datos");
   panelNavegar.add(bd);  
   panelNavegar.add(campoTextobd);
   
 
   user.setText("            Usuario");
   panelNavegar.add(user);
   panelNavegar.add(campoTextouser);
   
   
   pass.setText("            Contraseña");
   panelNavegar.add(pass);
   panelNavegar.add(campoTextopass);
    
   
   
   
   conectar.setText("CONECTAR");
   conectar.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
           botonconectarActionPerformed(evt);
         }
       });
   panelNavegar.add(conectar);
   
  
   panelNavegar.add(status);
   status.setVisible(false);
   
   
   
   
   captura.setText("CAPTURA");
   captura.setVisible(false);
   captura.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
           botoncapturaActionPerformed(evt);
         }
       });
   panelNavegar.add(captura);
   
   
   
   consulta.setText("CONSULTA"); 
   consulta.setVisible(false);
   consulta.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
           botonconsultaActionPerformed(evt);
         }
       });
   panelNavegar.add(consulta);
   
  
   add(panelNavegar);
   setVisible(true);
  }
  
  
  
  
  // maneja la llamada cuando se hace clic en botonAnterior
  public void botonconectarActionPerformed( ActionEvent evt )
  {
 
		 
	  
	     Connection conexion = null; 
	 
	     SERVIDOR=campoTextoserver.getText();
	     BD=campoTextobd.getText();
	     NOMBREUSUARIO=campoTextouser.getText();
	     CONTRASEÑA=campoTextopass.getText();
	     
	     
		  String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 	  
		  
		  String URL_BASEDATOS = "jdbc:sqlserver://localhost:"+SERVIDOR+";databaseName="+BD+";";

		  
		  
		  
		  if(campoTextoserver.getText().isEmpty()||campoTextobd.getText().isEmpty()||campoTextouser.getText().isEmpty()||campoTextopass.getText().isEmpty()) {
			  
			  status.setText("ingresa todos los datos");	
			  status.setVisible(true);
			  
		  
		  }else {
		  
		  
	    try {
	    	
	    // carga la clase controlador
	      Class.forName(CONTROLADOR);    
	      conexion = DriverManager.getConnection(URL_BASEDATOS, NOMBREUSUARIO, CONTRASEÑA);
	      
	      
	          
	      if(conexion!=null) {
	    	  
	    	  
	    	  
	    	  status.setText("conexion exitosa");
	    	  campoTextoserver.setEditable(false);	
	    	  campoTextobd.setEditable(false);	 
	    	  campoTextouser.setEditable(false);	
	    	  campoTextopass.setEditable(false);	
	    	  
	    	  status.setVisible(true);
	    	  captura.setVisible(true);
	    	  consulta.setVisible(true);
	    	  
	    	  conexion.close();
	    	  
	    	  
	    	  
	      }
	          
	    
	      
	      
	    } catch (SQLException sQLException) {
	    	
	    	
	      status.setText("fallo la conexion");	
	      status.setVisible(true);
	      JOptionPane.showMessageDialog(null, sQLException.getMessage(), "Error en base de datos", 0);
	      
	      
	    } catch (ClassNotFoundException classNotFoundException) {
	    	status.setText("fallo la conexion");
	    	status.setVisible(true);
	    	 JOptionPane.showMessageDialog(null, classNotFoundException.getMessage(), "Error en base de datos", 0);
	 
	    } 
	    
	    
	    
	    
	  }
}
	  
  
  public void botoncapturaActionPerformed( ActionEvent evt )
  {
	  
	  MostrarEquipos mostrarEquipos = new MostrarEquipos();
	  
	  
  }
	  
	  
  public void botonconsultaActionPerformed( ActionEvent evt )
  {
	  
	  
	  mostrarResultadosConsulta  = new MostrarResultadosConsulta();
	  
	  
  }

  } 

  
  
  
  
  
  

  
  

