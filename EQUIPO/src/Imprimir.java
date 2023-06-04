//Edgar leon Archuleta


import java.awt.print.PrinterException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Imprimir extends JFrame {
	
	
	 static final String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	 static final String URL_BASEDATOS = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Evaluacion;";
	 static final String NOMBREUSUARIO = "jhtp7";
	 static final String CONTRASEÑA = "jhtp7";
	 static final String CONSULTA_PREDETERMINADA = "SELECT * FROM Equipos";
	  
	
  
  private ResultSetTableModel modeloTabla;
  
  public Imprimir() {
	  
    try {
    	
      modeloTabla = new ResultSetTableModel(CONTROLADOR, URL_BASEDATOS, NOMBREUSUARIO, CONTRASEÑA, CONSULTA_PREDETERMINADA);
      
      JTable jTable = new JTable(modeloTabla);
      add(new JScrollPane(jTable));
      setSize(500, 250);
      setVisible(false);
      setLocationRelativeTo(null);
      
      try {
    	  
        jTable.print();
        
      } catch (PrinterException printerException) {
    	  
        JOptionPane.showMessageDialog(null, printerException.getMessage(), "Hubo un error al imprimir la tabla", 0);
      } 
    } catch (ClassNotFoundException classNotFoundException) {
    	
      JOptionPane.showMessageDialog(null, "No se encontro controlador de base de datos", "No se encontro el controlador", 0);
      System.exit(1);
      
    } catch (SQLException sQLException) {
    	
      JOptionPane.showMessageDialog(null, sQLException.getMessage(), "Error en base de datos", 0);
      modeloTabla.desconectarDeBaseDatos();
      System.exit(1);
    } 
  }
}
