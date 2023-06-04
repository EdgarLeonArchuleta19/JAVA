import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

// Controlador.java
// Componente Controlador de la arquitectura Modelo-Vista-Controlador

public class Controlador {
	private Modelo miModelo;
	private Vista miVista;
	
	private Point2D puntoInicial;
	private Point2D puntoFinal;
	
	// Variables a modificar con las opciones del menú
	Modelo.Tipo tipo = Modelo.Tipo.Linea;
	Color color = Color.BLACK;
	Color ColorAux = color;
	
	boolean relleno = false;
	static boolean Guardado;
	
	
	public Controlador( Modelo miModelo, Vista miVista )
	{
		this.miModelo = miModelo;
		this.miVista = miVista;
	}
	
	public void iniciarVista()
	{
		// Crear Oyentes
		OyenteDeRaton odr = new OyenteDeRaton();
		OyenteMenuArchivo oma = new OyenteMenuArchivo();	
		OyenteMenuDibujo omd = new OyenteMenuDibujo();
		OyenteMenuAyuda omay = new OyenteMenuAyuda();
		MiOyentecierre ov = new MiOyentecierre();
		
			
		// Registrar el oyente en el panel
		miVista.miVentana.miPanel.addMouseListener(odr);
		miVista.miVentana.miPanel.addMouseMotionListener(odr);		
		miVista.miVentana.addWindowListener(ov);
	
		
		//Oyentes del menu archivo
		miVista.miVentana.Nuevo.addActionListener(oma);	
		miVista.miVentana.Abrir.addActionListener(oma);	
		miVista.miVentana.Guardar.addActionListener(oma);	
		miVista.miVentana.Imprimir.addActionListener(oma);	
		miVista.miVentana.Salir.addActionListener(oma);	
		
		//Oyentes menu dibujo
		miVista.miVentana.Linea.addActionListener(omd);
		miVista.miVentana.Rectangulo.addActionListener(omd);
		miVista.miVentana.Elipse.addActionListener(omd);
		miVista.miVentana.Color.addActionListener(omd);
		miVista.miVentana.Relleno.addActionListener(omd);
	
		
		//Oyente menu Ayuda
		miVista.miVentana.Acercade.addActionListener(omay);	
		
	
		miVista.miVentana.setVisible(true);
	}
	
	

	   //Clase para el menu de archivo
	  class OyenteMenuArchivo implements ActionListener {
		    public void actionPerformed(ActionEvent e) {    	
		      String cual = e.getActionCommand();
		      
		      
		      
		      
		      
		      if(cual.equals("Nuevo")) {  
		    	  
		    	  if (Guardado==false && Modelo.figuras.size() != 0) {
		    		  
		    		  int option=JOptionPane.showConfirmDialog(null,  "guardar el dibujo actual?", "Programa de Dibujo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 		    		  
			          if(option==JOptionPane.YES_OPTION) {
			        	  
			        	  
			        	  if(Modelo.GuardarD()==true) {
			        		  Guardado=true;    
			        		  JOptionPane.showMessageDialog(null, "Archivo guardado correctamente", "Programa de Dibujo", -1);
			        		  Modelo.figuras = new Vector<>();	  
				        	  miVista.miVentana.repaint();
			        	  }else {
			        		  JOptionPane.showMessageDialog(null, "Error. No se pudo guardar el archivo",  "Programa de Dibujo", 2);
			        	  }
			        	  
			        	  	        	 			        	  
		    	      }else {
		    	    	  
		    	    	  Guardado = false; 
		    	    	  Modelo.figuras = new Vector<>();	  	    	 	  
		    	    	  miVista.miVentana.Nuevo.setEnabled(false);
		    	    	  miVista.miVentana.repaint();
		    	      }
			          		    	    	  
		    	  }else {	
		    		  
		    		  Modelo.figuras = new Vector<>();	  	  
	    	    	  miVista.miVentana.Nuevo.setEnabled(false);
	    	    	  miVista.miVentana.repaint();
		    		  
		    	  }  
		    	  
		    	  
		    	  
		    	  
		    	 
		      }else if (cual.equals("Abrir...")) {	
			        if (Guardado==false) {
			        	
			        	if(Modelo.figuras.size() == 0) {
			        		
			               if(Modelo.AbrirD()==true) {
			                  Guardado=true;
			                  miVista.miVentana.Nuevo.setEnabled(true);
						      miVista.miVentana.repaint();
		                   }else {
		                      JOptionPane.showMessageDialog(null, "Error. No se pudo abrir el archivo", "Programa de Dibujo", 2);
		                   }
			               
			            }else {
			        		
			        		 int option=JOptionPane.showConfirmDialog(null,  "guardar el dibujo actual?", "Programa de Dibujo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);             
				             if(option==JOptionPane.YES_OPTION) {
				            	 
				            	 if(Modelo.GuardarD()==true) {
					        		  Guardado=true;    
					        		  JOptionPane.showMessageDialog(null, "Archivo guardado correctamente", "Programa de Dibujo", -1);
					        		  
					        		  if(Modelo.AbrirD()==true) {
						 		             Guardado=true;
						 		             miVista.miVentana.Nuevo.setEnabled(true);
						 					 miVista.miVentana.repaint();
						 		      }else {
						 		    	     JOptionPane.showMessageDialog(null, "Error. No se pudo abrir el archivo", "Programa de Dibujo", 2);	 
						 		      }
					        		  
					        	 }else {
					        		  JOptionPane.showMessageDialog(null, "Error. No se pudo guardar el archivo",  "Programa de Dibujo", 2);
					        	 }	
				            	 
				            	 
				              }else {
				            	 
				            	  if(Modelo.AbrirD()==true) {
				 		             Guardado=true;
				 		             miVista.miVentana.Nuevo.setEnabled(true);
				 					 miVista.miVentana.repaint();
				 		          }else {
				 		        	  JOptionPane.showMessageDialog(null, "Error. No se pudo abrir el archivo", "Programa de Dibujo", 2);	 
				 		          }	
				            	  
				             }			        		
			        	 }
			        	
			        	
			        }else if(Guardado==true){		
			    	   
			    		    if(Modelo.AbrirD()==true) {
			 		             Guardado=true;
			 		             miVista.miVentana.Nuevo.setEnabled(true);
			 					 miVista.miVentana.repaint();
			 		        }else {
			 		    	     JOptionPane.showMessageDialog(null, "Error. No se pudo abrir el archivo", "Programa de Dibujo", 2);	 
			 		        }
			    		    
			       }
		    
		      
		      
			        
		      
		      }else if (cual.equals("Guardar como...")) {		    	  
		    	       if(Modelo.GuardarD()==true) { 
		    	    	   Guardado=true; 
		    	    	   JOptionPane.showMessageDialog(null, "Archivo guardado correctamente", "Programa de Dibujo", -1);
		    	       }else {
		    	    	   JOptionPane.showMessageDialog(null, "Error. No se pudo guardar el archivo",  "Programa de Dibujo", 2);
		    	       }
		    	       
		    	       
		    	  
		    	       
		    	       
		      }else if (cual.equals("Imprimir...")) {
		    		    miVista.miVentana.miPanel.print();
		    		
		    		    
		    		    
		    		    
		    		    
		    		    
		      }else if (cual.equals("Salir")) {
		    	    
				  if (Guardado==false && Modelo.figuras.size() != 0) {
					  int option=JOptionPane.showConfirmDialog(null,  "guardar el dibujo actual?", "Programa de Dibujo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);             
			             if(option==JOptionPane.YES_OPTION) {
		    	    	  
		    	    	  if(Modelo.GuardarD()==true) {	    
		    	    		 JOptionPane.showMessageDialog(null, "Archivo guardado correctamente", "Programa de Dibujo", -1);
			                 miVista.miVentana.dispose();
			                 Guardado=true;
			             
			              }else {
			                 JOptionPane.showMessageDialog(null, "Error. No se pudo guardar el archivo",  "Programa de Dibujo", 2);
			                 miVista.miVentana.dispose();
			                 Guardado=false;
			              }
		    	    	  
		    	      }else {
		    	    	  miVista.miVentana.dispose();
		    	    	  Guardado=false;
		    	      }
		    	        
		    	      
		    	    } else if (JOptionPane.showConfirmDialog(null, "salir de la aplicacion?", "Programa de Dibujo", 0) == 0) {
		    	    	miVista.miVentana.dispose();
		    	    }
		   			
		    	  
		      }	      
		    }
		  }
	
	

	
	
	//Clase para el menu de dibujo
	  class OyenteMenuDibujo implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	
		      String cual = e.getActionCommand();
		      
		      if (cual.equals("Linea")) {
		          tipo = Modelo.Tipo.Linea;
		          miVista.miVentana.Relleno.setEnabled(false);
		          
		          
		      } else if (cual.equals("Rectangulo")) {
		    	  tipo = Modelo.Tipo.Rectangulo;
		    	  miVista.miVentana.Relleno.setEnabled(true);
		    	  
		    	  
		      } else if (cual.equals("Elipse")) {
		    	  tipo = Modelo.Tipo.Elipse;
		    	  miVista.miVentana.Relleno.setEnabled(true);
		    	  
		    	  
		      }else if (cual.equals("Relleno")) {
		    	  relleno = ! relleno;    	  
			      miVista.miVentana.Relleno.setSelected(relleno);
			     
			      
			      
		      }else if (cual.equals("Color...")) {		    	  
		    	  
			      ColorAux = JColorChooser.showDialog(null, "Seleccione el color de la figura:", ColorAux);
			      if (ColorAux != null) {
			          color = ColorAux; 
			      }  
		      }
	        }
		  }
	  
	  
	  	  
	//Clase para el menu de ayuda
	  class OyenteMenuAyuda implements ActionListener {
		    public void actionPerformed(ActionEvent e) {	    
		      String cual = e.getActionCommand();
		      
		      if(cual.equals("Acerca de...")) {
					JOptionPane.showMessageDialog(null,"Proyecto elaborado por Edgar León Archuleta","CatMVC",1);				
				}		
		  }
	  }
	  
	  
		class MiOyentecierre extends WindowAdapter{		
	   		public void windowClosing(WindowEvent e) {
	   					
	   		  if (Guardado==false && Modelo.figuras.size() != 0) {
				  int option=JOptionPane.showConfirmDialog(null,  "guardar el dibujo actual?", "Programa de Dibujo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);             
		             if(option==JOptionPane.YES_OPTION) {
	    	    	  
	    	    	  if(Modelo.GuardarD()==true) {	    
	    	    		 JOptionPane.showMessageDialog(null, "Archivo guardado correctamente", "Programa de Dibujo", -1);
		                 miVista.miVentana.dispose();
		                 Guardado=true;
		             
		              }else {
		                 JOptionPane.showMessageDialog(null, "Error. No se pudo guardar el archivo",  "Programa de Dibujo", 2);
		                 miVista.miVentana.dispose();
		                 Guardado=false;
		              }
	    	    	  
	    	      }else {
	    	    	  miVista.miVentana.dispose();
	    	    	  Guardado=false;
	    	      }
	    	        
	    	      
	    	    } else if (JOptionPane.showConfirmDialog(null, "salir de la aplicacion?", "Programa de Dibujo", 0) == 0) {
	    	    	miVista.miVentana.dispose();
	    	    }
	   		}		
	   	}
		
	
	private Figura crearFigura(){
		Shape temporal;
		Figura resultado;
		
		// Preguntar si es una linea
		if ( tipo == Modelo.Tipo.Linea )
		{
		
			temporal = new Line2D.Double( puntoInicial.getX(), puntoInicial.getY(), puntoFinal.getX(), puntoFinal.getY());
			resultado = new Figura(temporal, color, false);
		}
		else
		{
			double x1 = Math.min(puntoInicial.getX(), puntoFinal.getX());
			double y1 = Math.min(puntoInicial.getY(), puntoFinal.getY());
			double ancho = Math.abs( puntoFinal.getX() - puntoInicial.getX());
			double alto  = Math.abs( puntoFinal.getY() - puntoInicial.getY());
			
			if ( tipo == Modelo.Tipo.Rectangulo ) {
				temporal = new Rectangle2D.Double( x1, y1, ancho, alto);
			}else {
				temporal = new Ellipse2D.Double( x1, y1, ancho, alto);
			}
			resultado = new Figura( temporal, color, relleno );	
		}
		
		
	
		return resultado;
	}
	
	// Clase interna para los eventos del ratón
	class OyenteDeRaton extends MouseAdapter
	{
		public void mousePressed( MouseEvent e )
		{
			// Si es botón derecho imprimir
			if ( e.getButton() == MouseEvent.BUTTON3 )
			{
				miVista.miVentana.miPanel.print();
				return;
			}
			miVista.miVentana.miPanel.setCursor(
				Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)
					);
			puntoInicial = e.getPoint();
		}
		
		public void mouseReleased( MouseEvent e )
		{
			miVista.miVentana.miPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			puntoFinal = e.getPoint();
			Modelo.f = crearFigura();
			Modelo.figuras.add( Modelo.f );
			Modelo.f = null;
			Guardado=false;
			miVista.miVentana.Nuevo.setEnabled(true);
			miVista.miVentana.miPanel.repaint();
		}
		
		public void mouseDragged( MouseEvent e )
		{
			puntoFinal = e.getPoint();
			
			if ( Modelo.f != null ){
				// Borrar la figura anterior
				Graphics2D g2D = ( Graphics2D ) miVista.miVentana.miPanel.getGraphics();
				g2D.setXORMode(miVista.miVentana.miPanel.getBackground());
				Modelo.f.dibujar(g2D);				
			}
			Modelo.f = crearFigura();
			Graphics2D g2D = ( Graphics2D ) miVista.miVentana.miPanel.getGraphics();
			g2D.setXORMode(miVista.miVentana.miPanel.getBackground());
			Modelo.f.dibujar(g2D);
		}
	}
	
}


