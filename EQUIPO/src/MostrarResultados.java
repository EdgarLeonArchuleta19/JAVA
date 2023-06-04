import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.TableRowSorter;
import javax.swing.RowSorter;

public class MostrarResultados extends JFrame {
	
	 static final String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	 static final String URL_BASEDATOS = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Evaluacion;";
	 static final String NOMBREUSUARIO = "jhtp7";
	 static final String CONTRASEÑA = "jhtp7";
	 static final String CONSULTA_PREDETERMINADA = "SELECT * FROM Equipos";
  
  private ResultSetTableModel modeloTabla;
  
  public MostrarResultados() {
	  
    super("Visualizacion del catalogo de equipos");
    
    
    try {
    	
      modeloTabla = new ResultSetTableModel(CONTROLADOR, URL_BASEDATOS, NOMBREUSUARIO, CONTRASEÑA, CONSULTA_PREDETERMINADA);
      
      JButton jButton1 = new JButton("Imprimir...");
      Box box1 = Box.createHorizontalBox();
      box1.add(jButton1);
      final JTable tablaResultados = new JTable(modeloTabla);
      JLabel jLabel = new JLabel("Filtro:");
      final JTextField textoFiltro = new JTextField();
      JButton jButton2 = new JButton("Aplicar filtro");
      Box box2 = Box.createHorizontalBox();
      box2.add(jLabel);
      box2.add(textoFiltro);
      box2.add(jButton2);
      add(box1, "North");
      add(new JScrollPane(tablaResultados), "Center");
      add(box2, "South");
      
      
      jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent param1ActionEvent) {
              try {
                tablaResultados.print();
              } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(null, printerException
                    .getMessage(), "Error al imprimir", 0);
              } 
            }
          });
      
      
      final TableRowSorter<ResultSetTableModel> sorter = new TableRowSorter<>(modeloTabla);
      tablaResultados.setRowSorter( sorter );
      setSize(500, 250);
      setVisible(true);
      setLocationRelativeTo(null);
      
      
      jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent param1ActionEvent) {
            	
              String str = textoFiltro.getText();
              
              if (str.length() == 0) {
                sorter.setRowFilter(null);
              } else {
            	  
                try {
                  sorter.setRowFilter(
                      RowFilter.regexFilter(str, new int[0]));
                } catch (PatternSyntaxException patternSyntaxException) {
                  JOptionPane.showMessageDialog(null, "Patron de exp reg incorrecto", "Patron de exp reg incorrecto", 0);
                } 
              } 
            }
          });
      
      
    } catch (ClassNotFoundException classNotFoundException) {
    	
            JOptionPane.showMessageDialog(null, "No se encontro controlador de base de datos", "No se encontro el controlador", 0);
            System.exit(1);
            
    } catch (SQLException sQLException) {
    	
              JOptionPane.showMessageDialog(null, sQLException.getMessage(), "Error en base de datos", 0);
              modeloTabla.desconectarDeBaseDatos();
              
      System.exit(1);
    } 
    
    addWindowListener(
    	      
            new WindowAdapter() 
            {
               // se desconecta de la base de datos y sale cuando se ha cerrado la ventana
               public void windowClosed( WindowEvent evento )
               {
                  modeloTabla.desconectarDeBaseDatos();
                  System.exit( 0 );
               } // fin del método windowClosed
            } // fin de la clase interna WindowAdapter
         ); // fin de la llamada a addWindowListener
      } 
}
