import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.print.PrinterJob;
import java.util.Vector;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PageFormat;

// Vista.java
// Implementacion del componente Vista de la arquitectura ;odelo-Vista-Controlador

public class Vista {
	MiVentana miVentana;
	
	public Vista()
	{
		miVentana = new MiVentana("");
	}


}

class MiVentana extends JFrame{
		  
	  MiPanel miPanel;	  
	  JMenuBar BarraPrincipal;  
	  
	  
	  
	  JMenu MenuArchivo;
	  
	  JMenuItem Nuevo; 
	  JMenuItem Abrir;
	  JMenuItem Guardar;
	  JMenuItem Imprimir;
	  JMenuItem Salir;
	  
	  
	  
	  JMenu MenuDibujar;
	  
	  ButtonGroup TiposDeFiguras;	  
	  JRadioButtonMenuItem Linea;	  
	  JRadioButtonMenuItem Rectangulo;	  
	  JRadioButtonMenuItem Elipse;
	  JCheckBoxMenuItem Relleno;
	  JMenuItem Color;

	  
	  
	  JMenu MenuAyuda;
	  
	  JMenuItem Acercade;
	  
	
	public MiVentana( String titulo){
		super("Proyecto MVC Dibujo");
			
		setDefaultCloseOperation(0);
		setSize( 600, 400 );
		setResizable(false);
		setLocationRelativeTo(null);

		
		BarraPrincipal = new JMenuBar();	    
	    
	    //Agregat botones y menus a BotonArchivo
	    MenuArchivo = new JMenu("Archivo");
	    MenuArchivo.setMnemonic('A');
	    Nuevo = new JMenuItem("Nuevo");
	    Nuevo.setMnemonic('N');
	    Nuevo.setEnabled(false);
	    Abrir = new JMenuItem("Abrir...");
	    Abrir.setMnemonic('A');
	    Guardar = new JMenuItem("Guardar como...");
	    Guardar.setMnemonic('G');
	    Imprimir = new JMenuItem("Imprimir...");
	    Imprimir.setMnemonic('I');
	    Salir = new JMenuItem("Salir");
	    Salir.setMnemonic('S');
      
	    
	    //Agregar a menu dibujar botones
	    MenuDibujar = new JMenu("Dibujar");
	    MenuDibujar.setMnemonic('D');
	    Linea = new JRadioButtonMenuItem("Linea", true);
	    Linea.setMnemonic('L');
	    Rectangulo = new JRadioButtonMenuItem("Rectangulo");
	    Rectangulo.setMnemonic('R');
	    Elipse = new JRadioButtonMenuItem("Elipse");
	    Elipse.setMnemonic('E');
	    Relleno = new JCheckBoxMenuItem("Relleno", false);
	    Relleno.setMnemonic('n');
	    Relleno.setEnabled(false);
	    Color = new JMenuItem("Color...");
	    Color.setMnemonic('C');
	    
	    TiposDeFiguras = new ButtonGroup();
	    TiposDeFiguras.add(Linea);
	    TiposDeFiguras.add(Rectangulo);
	    TiposDeFiguras.add(Elipse);

	    
	  
	    //Agregar caracteristicas a menu ayuda
	    MenuAyuda = new JMenu("Ayuda");
	    MenuAyuda.setMnemonic('u');
	    Acercade = new JMenuItem("Acerca de...");
	    Acercade.setMnemonic('A');
	    
	    
	    
	    
	    
        //Agregar botones a los menus
	    MenuArchivo.add(Nuevo);
	    MenuArchivo.addSeparator();
	    MenuArchivo.add(Abrir);
	    MenuArchivo.add(Guardar);
	    MenuArchivo.addSeparator();
	    MenuArchivo.add(Imprimir);
	    MenuArchivo.addSeparator();
	    MenuArchivo.add(Salir);
 	    
        MenuDibujar.add(Linea);
        MenuDibujar.add(Rectangulo);
        MenuDibujar.add(Elipse);
        MenuDibujar.addSeparator();
        MenuDibujar.add(Relleno);
        MenuDibujar.addSeparator();
        MenuDibujar.add(Color);
    
	    MenuAyuda.add(Acercade);
	    
	    
	    
	    //Agregar los menus a la barra
	    BarraPrincipal.add(MenuArchivo);
	    BarraPrincipal.add(MenuDibujar);
	    BarraPrincipal.add(MenuAyuda);
	    
	    
	    setJMenuBar(BarraPrincipal);	  	
		miPanel = new MiPanel();
		add(miPanel);
		
	}	

}



class MiPanel extends JPanel{
	
	
	public MiPanel(){
		  setOpaque(false);
	      Modelo.figuras = new Vector<>();

	}
	
	
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		
		// Convertir de Graphics a Graphics2D
		Graphics2D g2D = ( Graphics2D ) g;
		
		for ( Figura f : Modelo.figuras)
			f.dibujar( g2D );
	}
	
	public void print(){
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName(" Programa de Dibujo ");

		pj.setPrintable (new Printable() {    
			public int print(Graphics pg, PageFormat pf, int pageNum){
				if (pageNum > 0){
					return Printable.NO_SUCH_PAGE;
				}

				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				double factorEscalaX = 50.0;
				double factorEscalaY = 50.0;
				g2.scale(factorEscalaX/pf.getImageableWidth(), factorEscalaY/pf.getImageableHeight());
				paint(g2);
				return Printable.PAGE_EXISTS;
			}
		});
		if (pj.printDialog() == false)
			return;

		try {
			pj.print();
		} catch (PrinterException ex) {
			// handle exception
		}
	}
	
}





