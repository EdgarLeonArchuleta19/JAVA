//Edgar leon archuleta

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class MiVentanaCatalogo extends JFrame {
	
  private JMenuBar barraMenu;
  private JMenu menuArchivo;
  private JMenuItem mnuArcActualizar;
  private JMenuItem mnuArcConsultar;
  private JMenuItem mnuArcImprimir;
  private JMenuItem mnuArcSalir;
  private JMenu menuAyuda;
  private JMenuItem mnuAyuAcercaDe;
  private MostrarEquipos mostrarEquipos = null;
  private MostrarResultados mostrarResultadosConsulta = null;
  
  
  public MiVentanaCatalogo(String titulo) {
	  
    super(titulo);
    
    
    //Oyentes de las clases
    MiOyenteVentana miOyenteVentana = new MiOyenteVentana();
    MiOyenteArchivo miOyenteArchivo = new MiOyenteArchivo();
    MiOyenteAcercaDe miOyenteAcercaDe = new MiOyenteAcercaDe();
        
    barraMenu = new JMenuBar();
    
    //Menus principales
    menuArchivo = new JMenu("Archivo");
    menuArchivo.setMnemonic('A');
       
    menuAyuda = new JMenu("Ayuda");
    menuAyuda.setMnemonic('A');
    
    //Menu de archivo
    mnuArcActualizar = new JMenuItem("Actualizar catalogo");
    mnuArcActualizar.setMnemonic('t');
    mnuArcActualizar.addActionListener(miOyenteArchivo);
    mnuArcConsultar = new JMenuItem("Consultar catalogo");
    mnuArcConsultar.setMnemonic('A');
    mnuArcConsultar.addActionListener(miOyenteArchivo);
    mnuArcImprimir = new JMenuItem("Imprimir catalogo");
    mnuArcImprimir.setMnemonic('I');
    mnuArcImprimir.addActionListener(miOyenteArchivo);
    mnuArcSalir = new JMenuItem("Salir");
    mnuArcSalir.setMnemonic('l');
    mnuArcSalir.addActionListener(miOyenteArchivo);
    
    
    //Menu de ayuda
    mnuAyuAcercaDe = new JMenuItem("Acerca de...");
    mnuAyuAcercaDe.setMnemonic('A');
    mnuAyuAcercaDe.addActionListener(miOyenteAcercaDe);
     
    //Añadir a menus correspondientes
    menuArchivo.add(this.mnuArcActualizar);
    menuArchivo.add(this.mnuArcConsultar);
    menuArchivo.addSeparator();
    menuArchivo.add(this.mnuArcImprimir);
    menuArchivo.addSeparator();
    menuArchivo.add(this.mnuArcSalir);
    menuAyuda.add(this.mnuAyuAcercaDe);
    
    
    
    //Añadir los menus principales a la barra
    barraMenu.add(this.menuArchivo);
    barraMenu.add(this.menuAyuda);
    
    

    
    setJMenuBar(this.barraMenu);
    addWindowListener(miOyenteVentana);
  }
  
  
  
  class MiOyenteArchivo implements ActionListener {  
    public void actionPerformed(ActionEvent param1ActionEvent) {
    	
      JMenuItem jMenuItem = (JMenuItem)param1ActionEvent.getSource();
      
      if (jMenuItem == mnuArcActualizar) {    	  
        if (mostrarEquipos == null) {
        	
          mostrarEquipos = new MostrarEquipos();
          
        } else {
          mostrarEquipos.setVisible(true);
        } 
        
      } else if (jMenuItem == mnuArcConsultar) {    	  
        if (mostrarResultadosConsulta == null) {
        	
                 mostrarResultadosConsulta = new MostrarResultados();
          
        } else {
               mostrarResultadosConsulta.setVisible(true);
        } 
      } else if (jMenuItem == mnuArcImprimir) {
    	  
                 new Imprimir();
        
      } else if (jMenuItem == mnuArcSalir) {
    	  
    	  if (0 == JOptionPane.showConfirmDialog(null, "Deseas salir de la aplicación?", "Catalogo de Equipos", 0))
    	      System.exit(0); 
    	  }
    	  
    	  
      } 
    }
  }
  
  
  
  class MiOyenteAcercaDe implements ActionListener {
    public void actionPerformed(ActionEvent evt) {
    	
      JOptionPane.showMessageDialog(null, "HECHO POR EDGAR LEON ARCHULETA", "Catalogo de Equipos", 1);
    }
  }
  
  
  
  class MiOyenteVentana extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
    	 if (0 == JOptionPane.showConfirmDialog(null, "Deseas salir de la aplicación?", "Catalogo de Equipos", 0))
    	      System.exit(0); 
    	  }
    }
  
  

