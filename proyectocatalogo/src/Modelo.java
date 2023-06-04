//By Edgar León Archuleta

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Modelo implements Serializable {
	/**
	 * 
	 */
	private int totalEmpleados;
	private int empleadoActual;
	private Vector<Empleado> empleados;
	public boolean guardado;
	public boolean recuperado;
	
	
	//Constructor
	public Modelo(){
		totalEmpleados = 0;	
		empleadoActual = 0;
		empleados = new Vector<Empleado>();
	}
	
	//Métodos set
	public void setTotalEmpleados( int totalEmpleados ){
		this.totalEmpleados = totalEmpleados;
	}	

	public void setEmpleadoActual(int empleadoActual) {
		this.empleadoActual = empleadoActual;
	}

	public void setEmpleados(Vector<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	//Métodos get
	public int getTotalEmpleados(){
		return this.totalEmpleados;
	}	

	public int getEmpleadoActual() {
		return this.empleadoActual;
	}

	public Vector<Empleado> getEmpleados() {
		return this.empleados;
	}
		
		//Método para guardar los datos en un archivos
		 public boolean guardarEmpleados() {
			    
			    try {
			    	//Guardamos datos del vector empleados en el archivo datos.bin
			      File guardar = new File("datos.txt");
			      
			      FileOutputStream FOS = new FileOutputStream(guardar);
			      ObjectOutputStream OOS = new ObjectOutputStream(FOS);		      
			      guardado=true;
			      
			      OOS.writeObject(empleados);
			      FOS.close();
			      OOS.close();
			      
			    } catch (IOException ex) {
			  
			      guardado=false;
			    } 
			    return guardado;
				//Regresar true si los datos se pudieron guardar
				//Regresar false si los datos no se pudieron guardar
			  }
			  
		 
		//Método para recuperar los datos en un archivos
			  public boolean recuperarEmpleados() {
			   
			    try {
			    //recuperamos el archivo datos.bin con nuestros datos
			      File recupera = new File("datos.txt");
			      
			      FileInputStream FIS = new FileInputStream(recupera);
			      ObjectInputStream OIS = new ObjectInputStream(FIS);
			      			      
			      recuperado=true;
			      
			      try {
					empleados = (Vector<Empleado>)OIS.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					recuperado = false;
				}
			      FIS.close();
			      OIS.close();
			

			    } catch (IOException ex) {
			    	recuperado = false;
			    } 
			    return recuperado;
			  //Regresar true si los datos se pudieron recuperar
				//Regresar false si los datos no se pudieron recuperar
			  }
		
		
		
}
class Empleado implements Serializable {
	private int clave;
	private String nombre;
	private int edad;
	private char genero;
	private char departamento;
	private char turno;
	private boolean activo;
	private boolean lectura;
	private boolean deportes;
	private boolean cine;
	private boolean teatro;
	private boolean juegosDeSalon;
	private boolean conciertos;
	private boolean otros;
	private String especificar;
	
	
	//Constructor por omisión
	public Empleado(){
	}
	
	//Métodos set
	public void setClave( int clave ){
		this.clave = clave;
	}
	
	public void setNombre( String nombre ){
		this.nombre = (nombre !="") ? nombre : this.nombre;
	}
	
	public void setEdad( int edad ){
		this.edad = (edad>0) ? edad : this.edad;
	}
	
	public void setGenero( char genero ){
		if(genero == 'M' || genero == 'F'){
		this.genero = genero;
		}
	}
	
	public void setDepartamento( char departamento ){
		if(departamento == 'F' || departamento == 'A' || departamento == 'P' || departamento == 'V'){
		this.departamento = departamento;
		}
	}
	
	public void setTurno( char turno ){
		if(turno == 'M' || turno == 'V' || turno == 'N'){
		this.turno = turno;
		}
	}
	
	public void setActivo( boolean activo ){
		this.activo = activo;
	}
	
	public void setLectura( boolean lectura ){
		this.lectura = lectura;
	}
	
	public void setDeportes( boolean deportes ){
		this.deportes = deportes;
	}
	
	public void setCine( boolean cine ){
		this.cine = cine;
	}
	
	public void setTeatro( boolean teatro ){
		this.teatro = teatro;
	}
	
	public void setJuegosDeSalon( boolean juegosDeSalon ){
		this.juegosDeSalon = juegosDeSalon;
	}
	
	public void setConciertos( boolean conciertos ){
		this.conciertos = conciertos;
	}
	
	public void setOtros( boolean otros ){
		this.otros = otros;
	}
	
	public void setEspecificar ( String especificar ){
		this.especificar = especificar;
	}
	
	
	//Métodos get
	public int getClave(){
		return this.clave; 
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getEdad(){
		return this.edad;
	}
	
	public char getGenero(){
		return this.genero;
		
	}
	
	public char getDepartamento(){
		return this.departamento;
	}
	
	public char getTurno(){
		return this.turno;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	public boolean getLectura(){
		return this.lectura;
	}
	
	public boolean getDeportes(){
		return this.deportes;
	}
	
	public boolean getCine(){
		return this.cine;
	}
	
	public boolean getTeatro(){
		return this.teatro;
	}
	
	public boolean getJuegosDeSalon(){
		return this.juegosDeSalon;
	}
	
	public boolean getConciertos(){
		return this.conciertos;
	}
	
	public boolean getOtros(){
		return this.otros;
	}
	
	public String getEspecificar(){
		return this.especificar;
	}
}
