package com.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Arctric
 */
public class SqlServer {
    public static Connection online;
    private String status;
    
    public Connection Conexion(String cone) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            online = DriverManager.getConnection(cone);
            status = "Exitoso";
        } catch (SQLException e) {
            status = "Fallido";
        }
        return online;
    }
    
    public Connection getConnection(){
        return online;
    }

    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            online.close();
        }catch(Exception ex){}
    }
    
}
