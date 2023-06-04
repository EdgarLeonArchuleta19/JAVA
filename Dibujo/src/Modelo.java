import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// Modelo.java
// Componente Modelo de la arquitectura Modelo - Vista - Controlador

public class Modelo implements Serializable{

	static Figura f;
	static Vector<Figura> figuras;
	static boolean abierto=false;
	static boolean guardado=false;
	static String nombre;
	static String extension;
	static String r="";
	
	
	
	
	enum Tipo {
		Linea, Rectangulo, Elipse;
		}
	
	public Modelo()
	{
		figuras = new Vector<Figura>();
	}
	
	
	
	  public static boolean AbrirD() {		  
		    
		    try {
		      File directorio = new File(".");	
		      JFileChooser archivo = new JFileChooser(directorio.getCanonicalPath());
		      FileNameExtensionFilter ExtensionNombre = new FileNameExtensionFilter("Dibujo Paint", new String[] { "dp" });
		      archivo.setFileFilter(ExtensionNombre);
		      
		      int in = archivo.showOpenDialog(null);
		      if (in == 0) {	  	    	  
		    	  if (archivo.getSelectedFile().getName().lastIndexOf(".dp") == archivo.getSelectedFile().getName().length() - 3) {
		    	      r = archivo.getSelectedFile().getName();
		    	    } else {
		    	      r = archivo.getSelectedFile().getName() + ".dp";
		    	    } 
		    	 	    	  
		        File archivoAbrir = new File(r);	        
		        FileInputStream FIS = new FileInputStream(archivoAbrir);
		        ObjectInputStream OIS = new ObjectInputStream(FIS);
		        figuras = (Vector<Figura>)OIS.readObject();
		        FIS.close();
		        OIS.close();
		        abierto =true;
		      }
		      
		    } catch (ClassNotFoundException ex) {
		      abierto=false;
		    } catch (IOException ex) {		    
		      abierto=false;
		    } 
		    return abierto;
	  }
	  
	  
	  
		

		public static boolean GuardarD() {
			    
			    try {
			      File directorio = new File(".");
			      JFileChooser archivo = new JFileChooser(directorio.getCanonicalPath());
			      FileNameExtensionFilter ExtensionNombre = new FileNameExtensionFilter("Dibujo Paint", new String[] {"dp"});
			      archivo.setFileFilter(ExtensionNombre);
			      
			      int in = archivo.showSaveDialog(null);
			      if (in == 0) {		    	  	    	  
			    	  if (archivo.getSelectedFile().getName().lastIndexOf(".dp") == archivo.getSelectedFile().getName().length() - 3) {
			    	      r = archivo.getSelectedFile().getName();
			    	    } else {
			    	      r = archivo.getSelectedFile().getName() + ".dp";
			    	    } 
			    	  		    	  
			        File archivoGuardar = new File(r);
			        FileOutputStream FOS = new FileOutputStream(archivoGuardar);
			        ObjectOutputStream OSS = new ObjectOutputStream(FOS);
			        OSS.writeObject(figuras);
			        FOS.close();
			        OSS.close();	            
			        guardado = true;
			      } 
			      
			    } catch (IOException ex) {
			      guardado=false;
			    } 
			    return guardado;
		  }	
}



class Figura implements Serializable{
	
	private	Shape	figura;
	private	Color	color;
	private	boolean	relleno;
	
	public Figura( Shape f, Color c, boolean r )
	{
		figura = f;
		color = c;
		relleno = r;
	}
	
	// Método para dibujar la figura
	public void dibujar( Graphics2D g2D )
	{
		g2D.setColor( color );
		if ( relleno )
			g2D.fill( figura );
		else
			g2D.draw( figura );
	}
}

