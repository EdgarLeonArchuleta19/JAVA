//By Edgar León Archuleta
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JOptionPane;


//Controlador.java
//Componente Controlador del MVC

public class Controlador {
	Modelo miModelo;
	Vista miVista;
	boolean nuevo;
	
	public Controlador(Modelo mod, Vista vis){
		miModelo = mod;
		miVista = vis;
	}
	
	
	
	public void iniciarVista(){
		
		//Crear el oyente de los elementos del menú
		OyenteElementosMenu oem = new OyenteElementosMenu();
		MiOyentecierre oc = new MiOyentecierre();
		
		//Oyentes en las opciones del menú
		miVista.miVentana.mnuActualizar.addActionListener(oem);
		miVista.miVentana.mnuGuardar.addActionListener(oem);
		miVista.miVentana.mnuRecuperar.addActionListener(oem);
		miVista.miVentana.mnuSalir.addActionListener(oem);
		miVista.miVentana.mnuAcercaDe.addActionListener(oem);
		miVista.miVentana.addWindowListener(oc);
		
		miVista.miVentana.setVisible(true);
	}
	
	//Metodo mostrar actual
	
	public void mostrarActual() {
		
		int posicion = miModelo.getEmpleadoActual()-1;
		
		char departamento = miModelo.getEmpleados().get(posicion).getDepartamento();
		char turno = miModelo.getEmpleados().get(posicion).getTurno();
		
		int indiceDepartamento =0;
		int indiceTurno=0;
		
		if(departamento == 'F')
			indiceDepartamento =0;
		else if (departamento == 'A')
			indiceDepartamento =1;
		else if (departamento == 'P')
			indiceDepartamento =2;
		else if (departamento == 'V')
			indiceDepartamento =3;
		
		
		if(indiceTurno == 'M')
			turno =0;
		else if (turno == 'V')
			indiceTurno =1;
		else if (turno == 'N')
			indiceTurno =2;
		
		
		miVista.miCatalogo.miPanel.txtNombre.setText(miModelo.getEmpleados().get(posicion).getNombre());
		miVista.miCatalogo.miPanel.txtEdad.setText(miModelo.getEmpleados().get(posicion).getEdad()+"");
		miVista.miCatalogo.miPanel.rbtMasculino.setSelected(miModelo.getEmpleados().get(posicion).getGenero()=='M');
		miVista.miCatalogo.miPanel.rbtFemenino.setSelected(miModelo.getEmpleados().get(posicion).getGenero()=='F');
		miVista.miCatalogo.miPanel.cmbDepartamento.setSelectedIndex(indiceDepartamento);
		miVista.miCatalogo.miPanel.Turno.setSelectedIndex(indiceTurno);
		miVista.miCatalogo.miPanel.chkActivo.setSelected(miModelo.getEmpleados().get(posicion).getActivo());
		miVista.miCatalogo.miPanel.chkLectura.setSelected(miModelo.getEmpleados().get(posicion).getLectura());
		miVista.miCatalogo.miPanel.chkDeportes.setSelected(miModelo.getEmpleados().get(posicion).getDeportes());
		miVista.miCatalogo.miPanel.chkCine.setSelected(miModelo.getEmpleados().get(posicion).getCine());
		miVista.miCatalogo.miPanel.chkTeatro.setSelected(miModelo.getEmpleados().get(posicion).getTeatro());
		miVista.miCatalogo.miPanel.chkJuegosDeSalon.setSelected(miModelo.getEmpleados().get(posicion).getJuegosDeSalon());
		miVista.miCatalogo.miPanel.chkConciertos.setSelected(miModelo.getEmpleados().get(posicion).getConciertos());
		miVista.miCatalogo.miPanel.chkOtros.setSelected(miModelo.getEmpleados().get(posicion).getOtros());
		miVista.miCatalogo.miPanel.txtOtros.setText(miModelo.getEmpleados().get(posicion).getEspecificar());
	
	}
	

	//Clase interna para oyentes de opciones del menú
	class OyenteElementosMenu implements ActionListener
	{			
		public void actionPerformed(ActionEvent e)
		{
			String cual = e.getActionCommand();
				
			//Preguntar cual opción es la que generó el evento
			if(cual.equals("Actualizar catalogo...")){
				//Crear oyentes
				OyenteCasillaOtros oco = new OyenteCasillaOtros();
				OyenteBotonesDialogo obd = new OyenteBotonesDialogo(); 
				OyenyeBotonesNavegacion obn = new OyenyeBotonesNavegacion();
				
				//Mostrar el cuadro de diálogo
				miVista.miCatalogo = new MiCatalogo(miVista.miVentana, "Catalogo de empleados");
				
				//Registrar el oyente en la fuente del evento
				miVista.miCatalogo.miPanel.chkOtros.addItemListener(oco);	
				
				//botones de dialogo enlace
				miVista.miCatalogo.miPanel.btnNuevo.addActionListener(obd);
				miVista.miCatalogo.miPanel.btnModificar.addActionListener(obd);
				miVista.miCatalogo.miPanel.btnGuardar.addActionListener(obd);
				miVista.miCatalogo.miPanel.btnCancelar.addActionListener(obd);
				miVista.miCatalogo.miPanel.btnSalir.addActionListener(obd);
				
				//botones de navegación enlace	
				miVista.miCatalogo.miPanel.btnInicio.addActionListener(obn);
				miVista.miCatalogo.miPanel.btnAnterior.addActionListener(obn);
				miVista.miCatalogo.miPanel.btnSiguiente.addActionListener(obn);
				miVista.miCatalogo.miPanel.btnUltimo.addActionListener(obn);

                miVista.miCatalogo.miPanel.txtElementoActual.addActionListener(obn);

					
				//asegurar valores
				if (miModelo.getEmpleados().size() != 0) {
					
			          miModelo.setEmpleadoActual(1); //si hay empleados empezar de uno
			          miModelo.setTotalEmpleados(miModelo.getEmpleados().size()); //poner el maximo de empleados guardados
			          miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getEmpleadoActual()+"");
			          miVista.miCatalogo.miPanel.txtTotalElementos.setText(miModelo.getTotalEmpleados()+"");
			          miVista.miCatalogo.miPanel.mostrarModificacion = true;
			          miVista.miCatalogo.miPanel.btnModificar.setEnabled(true);//Para editar registros hechos 
			          mostrarActual();
			        } 
					
				
				//Hacer cuadro de diálogo de tipo modal				
				miVista.miCatalogo.setModalityType(ModalityType.APPLICATION_MODAL);
				miVista.miCatalogo.setVisible(true);
				
				
			} else if (cual.equals("Guardar")) {
				
				//si no hay elementos para guardar
		        if (miModelo.getEmpleados().size() == 0) {
		          JOptionPane.showMessageDialog(null,"Error. No hay empleados para guardar en el disco", "Guardar",0);      
		          
		        }else if(miModelo.guardarEmpleados()==true){
		          JOptionPane.showMessageDialog(null,"Empleados guardados correctamente en disco", "Guardar", 1);
		        }else {
		          JOptionPane.showMessageDialog(null, "Error. No se pudo guardar los empleados en  eldisco", "Guardar", 0);
		        } 
		        
		        
		        
		        
		      }else if(cual.equals("Recuperar")) {    
		    	  	  
		        if (miModelo.getEmpleados().size() > 0) {
		        	
		        	 int option=JOptionPane.showConfirmDialog(null, "Los empleados no guardados se perderan,continuar con la recuperación?", "Recuperar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);             
			          if(option==JOptionPane.YES_OPTION) {	
		        	  
		        	  if (miModelo.recuperarEmpleados()) {
				          JOptionPane.showMessageDialog(null, "Empleados recuperados correctamente del disco", "Recuperar", 1);
				        } else {
				          JOptionPane.showMessageDialog(null, "Error, No se pudo recuperar los empleados del disco", "Recuperar", 0);
				        }
	      			}        
		          
		        }
		          else if (miModelo.recuperarEmpleados()) {
		          JOptionPane.showMessageDialog(null, "Empleados recuperados correctamente de disco", "Recuperar", 1);
		        } else {
		          JOptionPane.showMessageDialog(null, "Error, No se pudo recuperar los empleados de disco", "Recuperar", 0);
		        }
				
		        
		        
		        
		        
			}else if(cual.equals("Salir")) {
      			int option = JOptionPane.showConfirmDialog(null, "¿Deseas salir?","Cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      			if(option==JOptionPane.YES_OPTION) {		
      				miVista.miVentana.dispose();		
      			}else{
      				miVista.miVentana.setVisible(true);
      			}
				
			} else if(cual.equals("Acerca de...")) {
				JOptionPane.showMessageDialog(null,"Proyecto elaborado por Edgar León Archuleta","CatMVC",1);
				
			}		
		}
	}
	
	
	
	//Clase interna para la casilla de verificación otros
	class OyenteCasillaOtros implements ItemListener
	{
		public void itemStateChanged( ItemEvent e)
		{
			miVista.miCatalogo.miPanel.txtOtros.setEnabled(
					miVista.miCatalogo.miPanel.chkOtros.isSelected());
		}
	}
	
	
	
	
	
	//Clase interna para los botones del cuadro de diálogo
	class OyenteBotonesDialogo implements ActionListener{
		public void actionPerformed( ActionEvent e){
			String cual = e.getActionCommand();
			
			if(cual.equals("Nuevo")){
				nuevo = true;
				miVista.miCatalogo.miPanel.limpiarComponentes();
				miVista.miCatalogo.miPanel.habilitarComponentes();
				
			}else if (cual.equals("Modificar")) {
				miVista.miCatalogo.miPanel.habilitarComponentes();
		      
			
		    }else if(cual.equals("Guardar")) {
				
				//preguntar si el empeado es nuevo
				//para agregarlo al vector
				
				if(nuevo) {
					miModelo.getEmpleados().add(new Empleado());
					miModelo.setTotalEmpleados(miModelo.getTotalEmpleados()+1);
					miModelo.setEmpleadoActual(miModelo.getTotalEmpleados());
				    miModelo.getEmpleados().get(miModelo.getTotalEmpleados()-1).setClave(miModelo.getTotalEmpleados());
				    
				    //Actualizar datos del catalogo
				    miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getTotalEmpleados()+"");
				    miVista.miCatalogo.miPanel.txtTotalElementos.setText(miModelo.getTotalEmpleados()+"");
				    miVista.miCatalogo.miPanel.mostrarModificacion=true;
				    nuevo=false;
				}
				
				
				//actualizar los datos
				//departamento
				int indiceDepartamento = miVista.miCatalogo.miPanel.cmbDepartamento.getSelectedIndex();
				int indiceTurno = miVista.miCatalogo.miPanel.Turno.getSelectedIndex();
						
						
				char departamento = 'F';
				char turno = 'M';
				
				if(indiceDepartamento ==0) 
					departamento='F';
				else if(indiceDepartamento ==1)
					departamento='A';
				else if(indiceDepartamento ==2)
					departamento='P';
				else if(indiceDepartamento ==3)
					departamento='V';
				
				
				if(indiceTurno ==0) 
					turno='M';
				else if(indiceTurno ==1)
					turno='V';
				else if(indiceTurno ==2)
					turno='N';
				
				//Validar la edad
				try {
					Integer.parseInt(miVista.miCatalogo.miPanel.txtEdad.getText());				
				}
				catch(Exception ex) {	
					miVista.miCatalogo.miPanel.txtEdad.setText("0");			
				}
				//Determinar la posición actual
				int posicion = miModelo.getEmpleadoActual()-1;

				
				//Guardar todo en vector
				miModelo.getEmpleados().get(posicion).setNombre(miVista.miCatalogo.miPanel.txtNombre.getText());
				miModelo.getEmpleados().get(posicion).setEdad(Integer.parseInt(miVista.miCatalogo.miPanel.txtEdad.getText()));
				miModelo.getEmpleados().get(posicion).setGenero(miVista.miCatalogo.miPanel.rbtMasculino.isSelected()?'M':'F');
				miModelo.getEmpleados().get(posicion).setDepartamento(departamento);
				miModelo.getEmpleados().get(posicion).setTurno(turno);
				miModelo.getEmpleados().get(posicion).setActivo(miVista.miCatalogo.miPanel.chkActivo.isSelected());
				miModelo.getEmpleados().get(posicion).setLectura(miVista.miCatalogo.miPanel.chkLectura.isSelected());
				miModelo.getEmpleados().get(posicion).setDeportes(miVista.miCatalogo.miPanel.chkDeportes.isSelected());
				miModelo.getEmpleados().get(posicion).setCine(miVista.miCatalogo.miPanel.chkCine.isSelected());
				miModelo.getEmpleados().get(posicion).setTeatro(miVista.miCatalogo.miPanel.chkTeatro.isSelected());
				miModelo.getEmpleados().get(posicion).setJuegosDeSalon(miVista.miCatalogo.miPanel.chkJuegosDeSalon.isSelected());
				miModelo.getEmpleados().get(posicion).setConciertos(miVista.miCatalogo.miPanel.chkConciertos.isSelected());
				miModelo.getEmpleados().get(posicion).setOtros(miVista.miCatalogo.miPanel.chkOtros.isSelected());
				miModelo.getEmpleados().get(posicion).setEspecificar(miVista.miCatalogo.miPanel.txtOtros.getText());
				miVista.miCatalogo.miPanel.deshabilitarComponentes(true);
				
				
			}else if ( cual.equals("Cancelar")){

			if (miModelo.getEmpleados().size() != 0){
                miVista.miCatalogo.miPanel.deshabilitarComponentes(true);
			}else{
				miVista.miCatalogo.miPanel.limpiarComponentes();
				miVista.miCatalogo.miPanel.deshabilitarComponentes(false);
			}
		}
		else if(cual.equals("Salir"))
			miVista.miCatalogo.dispose();
	}
	}
	
	
	
	
	
	
	//Clase interna para oyentes de los botones de navegación
		
	
	//cambia el empleado por verse
      class OyenyeBotonesNavegacion implements ActionListener{
    	  
    	  public void actionPerformed( ActionEvent e){
  			String cual = e.getActionCommand();
  			
  				
  			
  			//ir al inicio
  			if(cual.equals("<<")) {
  				if ( miModelo.getEmpleadoActual()>1 || miModelo.getEmpleadoActual()!=0 ) {
  					
 	  		         miModelo.setEmpleadoActual(1); //se pone el primer empleado
 	  		         miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getEmpleadoActual()+"");
 	  		        
 				}
  				
  			//ir al anterior
  			}else if(cual.equals("<") ) {
  				if (miModelo.getEmpleadoActual() > 1) {	
  					
  	  		         miModelo.setEmpleadoActual(miModelo.getEmpleadoActual() - 1);//se retrocede un empleado
  	  		         miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getEmpleadoActual()+"");
  	  		         
  				}
  				
  			}
  			     //ir al siguiente
  			else if(cual.equals(">") ) {	
  				if (miModelo.getEmpleadoActual() < miModelo.getTotalEmpleados()) {	
  					
 	  		         miModelo.setEmpleadoActual(miModelo.getEmpleadoActual() + 1);//se aumenta un empleado
 	  		         miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getEmpleadoActual()+"");
 	  		         
 				}
  			
  			     //ir al ultimo
  			}else if(cual.equals(">>") ) {			
  				if (miModelo.getEmpleadoActual() < miModelo.getTotalEmpleados()) {	
  					
	  		         miModelo.setEmpleadoActual(miModelo.getTotalEmpleados());//se va al final
	  		         miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getEmpleadoActual()+"");
	  		         
				}
  				
  		    }else {
  		    	
  			      //Poner clave con teclado 
		          int claveEscrita=0; 
		          claveEscrita=Integer.parseInt(miVista.miCatalogo.miPanel.txtElementoActual.getText());
		          
		          //Validar el Rango 
		          if (claveEscrita > 0 && claveEscrita <= miModelo.getTotalEmpleados()) {
		              miModelo.setEmpleadoActual(claveEscrita);
		            
		          }else{
		        	  //fuera de rango se pone el ultmimo valor asignado
		        	miVista.miCatalogo.miPanel.txtElementoActual.setText(miModelo.getEmpleadoActual()+"");
		          } 
		       
 			
  			
  		}
  			
  			//al usar una condicion de todas se refrescara al final el valor actual
  			if(miModelo.getEmpleados().size() != 0) {
  			mostrarActual();
  			}
  			
        }
      }
      
     
     
  	//Clase interna para preguntar antes del cierre de la vista  
      class MiOyentecierre extends WindowAdapter{		
      		public void windowClosing(WindowEvent e) {
      					
      			int option = JOptionPane.showConfirmDialog(null, "¿Deseas salir?","Cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      			if(option==JOptionPane.YES_OPTION) {		
      				miVista.miVentana.dispose();		
      			}else {
      				miVista.miVentana.setVisible(true);
      			}
      			
      		}		
      	}
      	
      	
      
      
      
      
      } 

