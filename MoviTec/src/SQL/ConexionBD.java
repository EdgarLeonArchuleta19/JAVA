/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author edgar
 */
public class ConexionBD {
    

    public static String URL_BASEDATOS = "jdbc:sqlserver://EDGAR\\MSSQLSERVER01;databaseName=MOVITEC;encrypt=false";
    public static String NOMBREUSUARIO = "TEC";
    public static String CONTRASEÑA = "123"; 
                

    
    public static Connection conectar(){
         Connection conexion = null; 


        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conexion = DriverManager.getConnection(URL_BASEDATOS, NOMBREUSUARIO, CONTRASEÑA);	  

       
        }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,  ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en base de datos", 0);
        }
        return conexion;  
    }
}
