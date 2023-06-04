//Edgar Leon Archuleta

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasEquipo {
	
	 static final String CONTROLADOR = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	 static final String URL_BASEDATOS = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Evaluacion;";
	 static final String NOMBREUSUARIO = "jhtp7";
	 static final String CONTRASEÑA = "jhtp7";
  
  private Connection conexion = null; 
  private PreparedStatement seleccionarTodosLosEquipos = null; 
  private PreparedStatement seleccionarEquiposPorMarca = null; 
  private PreparedStatement insertarNuevoEquipo = null;
  private PreparedStatement modificarEquipoActual = null;
  
  
  // constructor
  public ConsultasEquipo() {
	  
    try {
    	
    // carga la clase controlador
      Class.forName(CONTROLADOR);    
      conexion = DriverManager.getConnection(URL_BASEDATOS, NOMBREUSUARIO, CONTRASEÑA);
     
      seleccionarTodosLosEquipos = conexion.prepareStatement("SELECT * FROM Equipos");     
      seleccionarEquiposPorMarca = conexion.prepareStatement("SELECT * FROM Equipos WHERE Marca = ?");     
      insertarNuevoEquipo = conexion.prepareStatement("INSERT INTO Equipos ( TipoComputadora, Marca, Modelo, Procesador, Memoria, Almacenamiento ) VALUES ( ?, ?, ?, ?, ?, ? )");      
      modificarEquipoActual = conexion.prepareStatement("UPDATE Equipos SET TipoComputadora = ?, Marca = ?, Modelo = ?, Procesador = ?, Memoria = ?, Almacenamiento = ? WHERE IDClave = ?");
      
    } catch (SQLException sQLException) {
    	
      sQLException.printStackTrace();
      System.exit(1);
      
    } catch (ClassNotFoundException classNotFoundException) {
    	
      classNotFoundException.printStackTrace();
    } 
  }
  
  
  // selecciona todas las direcciones en la base de datos
  public List<Equipo> obtenerTodosLosEquipos() {
	  
    ArrayList<Equipo> arrayList = null;
    ResultSet resultSet = null;
    
    
    try {
    	
      resultSet = seleccionarTodosLosEquipos.executeQuery();
      arrayList = new ArrayList<Equipo>();
      
      while (resultSet.next())
    	  
        arrayList.add(new Equipo(resultSet
              .getInt("idClave"), resultSet
              .getString("TipoComputadora"), resultSet
              .getString("Marca"), resultSet
              .getString("Modelo"), resultSet
              .getString("Procesador"), resultSet
              .getString("Memoria"), resultSet
              .getString("Almacenamiento"))); 
      
    } catch (SQLException sQLException) {
    	
      sQLException.printStackTrace();
      
    } finally {
    	
      try {
        resultSet.close();
      } catch (SQLException sQLException) {
    	  
        sQLException.printStackTrace();
        close();
      } 
    } 
    return arrayList;
  }
  
  
  
  //clase para obtener equipos por la marca
  public List<Equipo> obtenerEquiposPorMarca(String nombre) {
	  
    ArrayList<Equipo> arrayList = null;
    ResultSet resultSet = null;
    
    
    try {
    	
      seleccionarEquiposPorMarca.setString(1, nombre);
      resultSet = seleccionarEquiposPorMarca.executeQuery();
      arrayList = new ArrayList<Equipo>();
      
      while (resultSet.next())
    	  
        arrayList.add(new Equipo(resultSet
              .getInt("idClave"), resultSet
              .getString("TipoComputadora"), resultSet
              .getString("Marca"), resultSet
              .getString("Modelo"), resultSet
              .getString("Procesador"), resultSet
              .getString("Memoria"), resultSet
              .getString("Almacenamiento"))); 
      
    } catch (SQLException sQLException) {
    	
      sQLException.printStackTrace();
    } finally {
      try {
    	  
        resultSet.close();
      } catch (SQLException sQLException) {
    	  
        sQLException.printStackTrace();
        close();
      } 
    } 
    return arrayList;
  }
  
  
  //clase para agregar equipos
  public int agregarEquipo(String TC, String marca, String modelo, String procesador, String memoria, String almacenamiento) {
    int i = 0;
    try {
      
      insertarNuevoEquipo.setString(1, TC);
      insertarNuevoEquipo.setString(2, marca);
      insertarNuevoEquipo.setString(3, modelo);
      insertarNuevoEquipo.setString(4, procesador);
      insertarNuevoEquipo.setString(5, memoria);
      insertarNuevoEquipo.setString(6, almacenamiento);
      i = insertarNuevoEquipo.executeUpdate();
      
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      close();
    } 
    return i;
  }
  
  
  //clave para modificar los equipos
  public int modificarEquipo( String TC, String marca, String modelo, String procesador, String memoria, String almacenamiento,int ID) {
    int i = 0;
    
    try {
    	
      modificarEquipoActual.setString(1, TC);
      modificarEquipoActual.setString(2, marca);
      modificarEquipoActual.setString(3, modelo);
      modificarEquipoActual.setString(4, procesador);
      modificarEquipoActual.setString(5, memoria);
      modificarEquipoActual.setString(6, almacenamiento);
      modificarEquipoActual.setInt(7, ID);
      
      i = modificarEquipoActual.executeUpdate();
      
      
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
      close();
    } 
    return i;
  }
  
  //metodo para cerrar la conexion
  public void close() {
	  
    try {
      conexion.close();
    } catch (SQLException sQLException) {
      sQLException.printStackTrace();
    } 
  }
}
