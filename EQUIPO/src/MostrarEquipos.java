//Edgar leon Archuleta

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MostrarEquipos extends JFrame {
	
  private Equipo entradaActual;
  private ConsultasEquipo consultasEquipo;
  private List<Equipo> resultados;
  private int numeroDeEntradas = 0;
  private int indiceEntradaActual;
  
  
  private JButton botonExplorar;
  private JLabel etiquetaModelo;
  private JTextField campoTextoModelo;
  private JLabel etiquetaTipoComputadora;
  private JTextField campoTextoTipoComputadora;
  private JLabel etiquetaID;
  private JTextField campoTextoID;
  private JTextField campoTextoIndice;
  private JLabel etiquetaMarca;
  private JTextField campoTextoMarca;
  private JTextField campoTextoMax;
  private JButton botonSiguiente;
  private JLabel etiquetaDe;
  private JLabel etiquetaProcesador;
  private JTextField campoTextoProcesador;
  private JButton botonAnterior;
  private JButton botonConsulta;
  private JLabel etiquetaConsulta;
  private JPanel panelConsulta;
  private JPanel panelNavegar;
  private JPanel panelMostrar;
  private JTextField campoTextoConsulta;
  private JButton botonInsertar;
  private JLabel etiquetaMemoria; 
  private JTextField campoTextoMemoria; 
  private JLabel etiquetaAlmacenamiento; 
  private JTextField campoTextoAlmacenamiento; 
  private JButton botonModificar;
  
  
  // constructor sin argumentos
  public MostrarEquipos() {
	  
    super("Catalogo de Equipos");
    
    // establece la conexión a la base de datos y las instrucciones PreparedStatement
    
    consultasEquipo = new ConsultasEquipo();
    
 // crea la GUI
    panelNavegar = new JPanel();
    botonAnterior = new JButton();
    campoTextoIndice = new JTextField(2);
    etiquetaDe = new JLabel();
    campoTextoMax = new JTextField(2);
    botonSiguiente = new JButton();
    panelMostrar = new JPanel();
    etiquetaID = new JLabel();
    campoTextoID = new JTextField(15);
    etiquetaTipoComputadora = new JLabel();
    campoTextoTipoComputadora = new JTextField(15);
    etiquetaMarca = new JLabel();
    campoTextoMarca = new JTextField(15);
    etiquetaModelo = new JLabel();
    campoTextoModelo = new JTextField(15);
    etiquetaProcesador = new JLabel();
    campoTextoProcesador = new JTextField(15);
    etiquetaMemoria = new JLabel();
    campoTextoMemoria = new JTextField(15);
    etiquetaAlmacenamiento = new JLabel();
    campoTextoAlmacenamiento = new JTextField(15);
    panelConsulta = new JPanel();
    etiquetaConsulta = new JLabel();
    campoTextoConsulta = new JTextField(15);
    botonConsulta = new JButton();
    botonExplorar = new JButton();
    botonInsertar = new JButton();
    botonModificar = new JButton();
    
    
    setLayout(new FlowLayout(1, 10, 10));
    setSize(580, 350);
    setResizable(false);
    setLocationRelativeTo(null);
    
    panelNavegar.setLayout(new BoxLayout(panelNavegar, 0));
    
    botonAnterior.setText("Anterior");
    botonAnterior.setEnabled(false);
    
    botonAnterior.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            botonAnteriorActionPerformed(evt);
          }
        }
    );
    
    panelNavegar.add(botonAnterior);
    panelNavegar.add(Box.createHorizontalStrut(10));
    
    campoTextoIndice.setHorizontalAlignment(0);
    
    
    campoTextoIndice.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            campoTextoIndiceActionPerformed(evt);
          }
        }
    );
    
    panelNavegar.add(campoTextoIndice);
    panelNavegar.add(Box.createHorizontalStrut(10));
    
    etiquetaDe.setText("de");
    panelNavegar.add(etiquetaDe);
    panelNavegar.add(Box.createHorizontalStrut(10));
    
    campoTextoMax.setHorizontalAlignment(0);
    campoTextoMax.setEditable(false);
    panelNavegar.add(campoTextoMax);
    panelNavegar.add(Box.createHorizontalStrut(10));
    
    botonSiguiente.setText("Siguiente");
    botonSiguiente.setEnabled(false);
    
    botonSiguiente.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MostrarEquipos.this.botonSiguienteActionPerformed(evt);
          }
        }
    );
    
    panelNavegar.add(botonSiguiente);
    add(panelNavegar);
    panelMostrar.setLayout(new GridLayout(7, 2, 4, 4));
    
    etiquetaID.setText("ID Clave:");
    panelMostrar.add(etiquetaID);
    campoTextoID.setEditable(false);
    panelMostrar.add(campoTextoID);
    
    etiquetaTipoComputadora.setText("Tipo de computadora:");
    panelMostrar.add(etiquetaTipoComputadora);
    panelMostrar.add(campoTextoTipoComputadora);
    
    etiquetaMarca.setText("Marca:");
    panelMostrar.add(etiquetaMarca);
    panelMostrar.add(campoTextoMarca);
    
    etiquetaModelo.setText("Modelo:");
    panelMostrar.add(etiquetaModelo);
    panelMostrar.add(campoTextoModelo);
    
    etiquetaProcesador.setText("Procesador:");
    panelMostrar.add(etiquetaProcesador);
    panelMostrar.add(campoTextoProcesador);
    
    etiquetaMemoria.setText("Memoria:");
    panelMostrar.add(etiquetaMemoria);
    panelMostrar.add(campoTextoMemoria);
    
    etiquetaAlmacenamiento.setText("Almacenamiento:");
    panelMostrar.add(etiquetaAlmacenamiento);
    panelMostrar.add(campoTextoAlmacenamiento);
    
    add(panelMostrar);
    
    panelConsulta.setLayout(new BoxLayout(panelConsulta, 0));
    panelConsulta.setBorder(BorderFactory.createTitledBorder("Buscar una entrada por marca"));
    etiquetaConsulta.setText("Marca de la computadora:");
    
    panelConsulta.add(Box.createHorizontalStrut(5));
    panelConsulta.add(etiquetaConsulta);
    panelConsulta.add(Box.createHorizontalStrut(10));
    panelConsulta.add(campoTextoConsulta);
    panelConsulta.add(Box.createHorizontalStrut(10));
    
    
    
    botonConsulta.setText("Buscar");
    botonConsulta.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MostrarEquipos.this.botonConsultaActionPerformed(evt);
          }
        });
    
    panelConsulta.add(botonConsulta);
    panelConsulta.add(Box.createHorizontalStrut(5));
    
    add(panelConsulta);
    botonExplorar.setText("Explorar todas las entradas");
    botonExplorar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MostrarEquipos.this.botonExplorarActionPerformed(evt);
          }
        });
    
    
    add(botonExplorar);
    botonInsertar.setText("Insertar nueva entrada");
    botonInsertar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MostrarEquipos.this.botonInsertarActionPerformed(evt);
          }
        });
    
    
    add(botonInsertar);
    botonModificar.setText("Modificar entrada actual");
    botonModificar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MostrarEquipos.this.botonModificarActionPerformed(evt);
          }
        });
    
    
    add(botonModificar);
    addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent evt) {
            JFrame jFrame = (JFrame)evt.getSource();
            MostrarEquipos.this.consultasEquipo.close();
            jFrame.dispose();
          }
        });
    setVisible(true);
  }

   
  
  
  // maneja la llamada cuando se hace clic en botonAnterior
  private void botonAnteriorActionPerformed( ActionEvent evt )
  {
     indiceEntradaActual--;
     
     if ( indiceEntradaActual < 0 )
        indiceEntradaActual = numeroDeEntradas - 1;
     
     campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
     campoTextoIndiceActionPerformed( evt );  
  } // fin del método botonAnteriorActionPerformed

  // maneja la llamada cuando se hace clic en botonSiguiente
  private void botonSiguienteActionPerformed( ActionEvent evt ) 
  {
     indiceEntradaActual++;
     
     if ( indiceEntradaActual >= numeroDeEntradas )
        indiceEntradaActual = 0;
     
     campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
     campoTextoIndiceActionPerformed( evt );
  } // fin del método botonSiguienteActionPerformed
  
  
  
  private void botonConsultaActionPerformed(ActionEvent evt) {
   
      resultados = consultasEquipo.obtenerEquiposPorMarca(campoTextoConsulta.getText());
    numeroDeEntradas = resultados.size();
    
    if (numeroDeEntradas != 0) {
    	
      indiceEntradaActual = 0;
      entradaActual = (resultados.get(indiceEntradaActual));
      campoTextoID.setText("" + entradaActual.obtenerIDClave());
      campoTextoTipoComputadora.setText(entradaActual.obtenerTipoComputadora());
      campoTextoMarca.setText(entradaActual.obtenerMarca());
      campoTextoModelo.setText(entradaActual.obtenerModelo());
      campoTextoProcesador.setText(entradaActual.obtenerProcesador());
      campoTextoMemoria.setText(entradaActual.obtenerMemoria());
      campoTextoAlmacenamiento.setText(entradaActual.obtenerAlmacenamiento());
      campoTextoMax.setText("" + numeroDeEntradas);
      campoTextoIndice.setText("" + (indiceEntradaActual + 1));
      botonSiguiente.setEnabled(true);
      botonAnterior.setEnabled(true);
      botonModificar.setEnabled(true);
    } else {
      botonExplorarActionPerformed(evt);
    } 
  }

  
  
//maneja la llamada cuando se introduce un nuevo valor en campoTextoIndice
  private void campoTextoIndiceActionPerformed( ActionEvent evt )
  {
     indiceEntradaActual = ( Integer.parseInt( campoTextoIndice.getText() ) - 1 );
     
     if ( numeroDeEntradas != 0 && indiceEntradaActual < numeroDeEntradas )
     {
        entradaActual = resultados.get( indiceEntradaActual );
        campoTextoID.setText("" + entradaActual.obtenerIDClave() );
        
        campoTextoTipoComputadora.setText(entradaActual.obtenerTipoComputadora());
        campoTextoMarca.setText(entradaActual.obtenerMarca());
        campoTextoModelo.setText(entradaActual.obtenerModelo());
        campoTextoProcesador.setText(entradaActual.obtenerProcesador());
        campoTextoMemoria.setText(entradaActual.obtenerMemoria());
        campoTextoAlmacenamiento.setText(entradaActual.obtenerAlmacenamiento());
        
        campoTextoMax.setText( "" + numeroDeEntradas );
        campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
     } // fin de if
   } // fin del método campoTextoIndiceActionPerformed


  // maneja la llamada cuando se hace clic en botonExplorar
  private void botonExplorarActionPerformed( ActionEvent evt )
  {
     try
     {
        resultados = consultasEquipo.obtenerTodosLosEquipos();
        numeroDeEntradas = resultados.size();
     
        if ( numeroDeEntradas != 0 )
        {
           indiceEntradaActual = 0;
           entradaActual = resultados.get( indiceEntradaActual );
           campoTextoID.setText("" + entradaActual.obtenerIDClave());
           campoTextoTipoComputadora.setText(entradaActual.obtenerTipoComputadora());
           campoTextoMarca.setText(entradaActual.obtenerMarca());
           campoTextoModelo.setText(entradaActual.obtenerModelo());
           campoTextoProcesador.setText(entradaActual.obtenerProcesador());
           campoTextoMemoria.setText(entradaActual.obtenerMemoria());
           campoTextoAlmacenamiento.setText(entradaActual.obtenerAlmacenamiento());
           campoTextoMax.setText( "" + numeroDeEntradas );
           campoTextoIndice.setText( "" + ( indiceEntradaActual + 1 ) );
           botonSiguiente.setEnabled( true );
           botonAnterior.setEnabled( true );
        } // fin de if
     } // fin de try
     catch ( Exception e )
     {
        e.printStackTrace();
     } // fin de catch
  } // fin del método botonExplorarActionPerformed

  
  
  
  private void botonInsertarActionPerformed(ActionEvent evt) {
	  
    int resultado = consultasEquipo.agregarEquipo(campoTextoTipoComputadora.getText(), campoTextoMarca
        .getText(), campoTextoModelo.getText(), campoTextoProcesador
        .getText(), campoTextoMemoria.getText(), campoTextoAlmacenamiento
        .getText());
    
    if (resultado == 1) {
      JOptionPane.showMessageDialog(null, "Se agrego equipo!", "Se agrego equipo", 1);
    } else {
      JOptionPane.showMessageDialog(null, "No se agrego equipo!", "Error", -1);
    } 
    botonExplorarActionPerformed(evt);
  }
  
  
  
  private void botonModificarActionPerformed(ActionEvent evt) {
	  
    int i = consultasEquipo.modificarEquipo(campoTextoTipoComputadora.getText(), campoTextoMarca
        .getText(), campoTextoModelo.getText(), campoTextoProcesador
        .getText(), campoTextoMemoria.getText(), campoTextoAlmacenamiento
        .getText(), 
        Integer.parseInt(campoTextoID.getText()));
    
    if (i == 1) {
      JOptionPane.showMessageDialog(null, "Se modifico equipo!", "Se modifico equipo", 1);
    } else {
      JOptionPane.showMessageDialog(null, "No se modifico equipo!", "Error", -1);
    } 
    botonExplorarActionPerformed(evt);
  }
}
