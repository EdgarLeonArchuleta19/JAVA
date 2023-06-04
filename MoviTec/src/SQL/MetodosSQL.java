/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.util.Calendar;




/**
 *
 * @author edgar
 */
public class MetodosSQL {
    
    public static ConexionBD conexion = new ConexionBD();
    
    public static PreparedStatement sentecia_preparada;
    public static ResultSet resultado;
    public static String sql, TipoUsuario= null;
    public static int resultado_numero=0;
    public static String[] datos = new String[13];
    public static String[] datosEmpleado = new String[8];
    
    java.sql.Date fechaSql = new java.sql.Date(System.currentTimeMillis());
    java.util.Date fechaUtil = new java.util.Date();
    
    
    
    
    
    
    
    
    
    //////////////////////////////METODOS LOGIN\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public static String BuscarUsuario(String NoControl, String contraseña){

        String busqueda = null;
        Connection conexion =null;

       try{
         conexion = ConexionBD.conectar();
         String sentencia_Buscar = ("SELECT TIPO_USUARIO FROM USUARIO WHERE NoControl= '"+NoControl+"' AND CONTRASEÑA = '"+contraseña+"'");
         sentecia_preparada = conexion.prepareStatement(sentencia_Buscar);
         resultado = sentecia_preparada.executeQuery();
    
         if(resultado.next()){
             busqueda = "usuario encontrado";    
             TipoUsuario = resultado.getString(1);
         }else{
             JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
         }
         
         conexion.close();
        }catch(Exception e){
           System.out.println(e);               
        } 
     
    return busqueda;
    }
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////METODOS MAINALUMNO\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  
    public static  String[] obtenerDatosAlumno(String noControl) {
        
        String[] alumno = {
                "NoCONTROL_ALUMNO", "NOMBRE_ALUMNO", "APELLIDOS_ALUMNO", "CURP_ALUMNO", "TELEFONO_ALUMNO",
                "CORREO_ALUMNO", "NOMBRE_INSTITUTO", "NOMBRE_CARRERA", "SEMESTRE", "PROMEDIO",
                "ESTATUS_NO_ADEDUDO", "ESTATUS_MATERIAS_RC", "NUMERO_MOVILIDADES"
        };
            Connection conexion=null;
            conexion = ConexionBD.conectar();
            String sentenciaBuscar = "SELECT " + String.join(", ", alumno) + " FROM ALUMNOS A INNER JOIN INSTITUTO I ON A.ID_INSTITUTO_ALUMNO = I.ID_INSTITUTO INNER JOIN CARRERA C ON A.ID_CARRERA = C.ID_CARRERA WHERE A.NoCONTROL_ALUMNO = ?";
            try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {
                sentenciaPreparada.setString(1, noControl);
                try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
                    if (resultado.next()) {
                        for (int i = 0; i < alumno.length; i++) {
                            datos[i] = resultado.getString(i + 1);                              
                        }
                    }             
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e.getMessage());
        }
        return datos;
    }
    
    

 
public static String[] obtenerDatosEscuela(String noControlAlumno) {
    String sentenciaBuscar = "SELECT NOMBRE_INSTITUTO FROM INSTITUTO WHERE ID_INSTITUTO <> (SELECT ID_INSTITUTO_ALUMNO FROM ALUMNOS WHERE NoCONTROL_ALUMNO = ?)";
    List<String> instituciones = new ArrayList<>();
    

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {
         sentenciaPreparada.setString(1, noControlAlumno);
        
        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                String nombreInstituto = resultado.getString("NOMBRE_INSTITUTO");
                instituciones.add(nombreInstituto);
                
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }
    
    // Convertir la lista de instituciones a un array
    String[] arrayInstituciones = instituciones.toArray(new String[instituciones.size()]);
    return arrayInstituciones;
}





public static String[] obtenerDatosMaterias(String nombreCarrera, String nombreInstituto) {
    String sentenciaObtenerIdCarrera = "SELECT ID_CARRERA FROM CARRERA WHERE NOMBRE_CARRERA = ?";
    String sentenciaObtenerIdInstituto = "SELECT ID_INSTITUTO FROM INSTITUTO WHERE NOMBRE_INSTITUTO = ?";
    String sentenciaBuscar = "SELECT M.NOMBRE_MATERIA " +
            "FROM MATERIA M " +
            "INNER JOIN CARRERAXMATERIA CM ON M.ID_MATERIA = CM.ID_MATERIA " +
            "WHERE CM.ID_CARRERA = ? AND CM.ID_INSTITUTO = ?";
    
    List<String> materias = new ArrayList<>();

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparadaIdCarrera = conexion.prepareStatement(sentenciaObtenerIdCarrera);
         PreparedStatement sentenciaPreparadaIdInstituto = conexion.prepareStatement(sentenciaObtenerIdInstituto);
         PreparedStatement sentenciaPreparadaBuscar = conexion.prepareStatement(sentenciaBuscar)) {
        // Obtener ID de la carrera
        sentenciaPreparadaIdCarrera.setString(1, nombreCarrera);
        try (ResultSet resultadoIdCarrera = sentenciaPreparadaIdCarrera.executeQuery()) {
            if (resultadoIdCarrera.next()) {
                int idCarrera = resultadoIdCarrera.getInt("ID_CARRERA");
                
                // Obtener ID del instituto
                sentenciaPreparadaIdInstituto.setString(1, nombreInstituto);
                try (ResultSet resultadoIdInstituto = sentenciaPreparadaIdInstituto.executeQuery()) {
                    if (resultadoIdInstituto.next()) {
                        int idInstituto = resultadoIdInstituto.getInt("ID_INSTITUTO");
                        
                        // Realizar consulta principal
                        sentenciaPreparadaBuscar.setInt(1, idCarrera);
                        sentenciaPreparadaBuscar.setInt(2, idInstituto);
                        
                        try (ResultSet resultadoBuscar = sentenciaPreparadaBuscar.executeQuery()) {
                            while (resultadoBuscar.next()) {
                                String nombreMateria = resultadoBuscar.getString("NOMBRE_MATERIA");
                                materias.add(nombreMateria);
                            }
                        }
                    } else {
                        System.out.println("No se encontró el instituto con el nombre proporcionado.");
                    }
                }
            } else {
                System.out.println("No se encontró la carrera con el nombre proporcionado.");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }

    // Convertir la lista de materias a un array
    String[] arrayMaterias = materias.toArray(new String[materias.size()]);
    return arrayMaterias;
}





public static void AgregarMaterias(JTable tablaMaterias, String nombreMateria) {
    String sentenciaBuscar = "SELECT ID_MATERIA, NOMBRE_MATERIA, NoCREDITOS FROM MATERIA WHERE NOMBRE_MATERIA = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {

        sentenciaPreparada.setString(1, nombreMateria);

        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            if (resultado.next()) {
                int idMateria = resultado.getInt("ID_MATERIA");
                String nombreMateriaBD = resultado.getString("NOMBRE_MATERIA");
                int noCreditos = resultado.getInt("NoCREDITOS");

                // Verificar si la materia ya existe en la tabla
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaMaterias.getModel();
                boolean materiaExistente = false;
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    String materiaTabla = (String) modeloTabla.getValueAt(i, 1);
                    if (materiaTabla.equals(nombreMateriaBD)) {
                        materiaExistente = true;
                        break;
                    }
                }
                if (materiaExistente) {
                    JOptionPane.showMessageDialog(null, "La materia ya fue agregada al plan escolar", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    modeloTabla.addRow(new Object[]{idMateria, nombreMateriaBD, noCreditos});
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }
}




public static void EliminarMaterias(JTable tabla) {
    DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
    int filaSeleccionada = tabla.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        modeloTabla.removeRow(filaSeleccionada);
    } else {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




public static void InsertarMovilidad(String noControlAlumno, String nombreInstituto) {
    String sentenciaObtenerIdInstituto = "SELECT ID_INSTITUTO FROM INSTITUTO WHERE NOMBRE_INSTITUTO = ?";
    String sentenciaInsertar = "INSERT INTO MOVILIDAD (FECHA_SOLICITUD, NoCONTROL_ALUMNO, ID_INSTITUTO_DESTINO, ESTATUS) VALUES (?, ?, ?, 'En Revisión')";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparadaIdInstituto = conexion.prepareStatement(sentenciaObtenerIdInstituto);
         PreparedStatement sentenciaPreparadaInsertar = conexion.prepareStatement(sentenciaInsertar)) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        Date fechaSolicitud = Date.valueOf(fechaActual);

        // Obtener el ID de instituto correspondiente al nombre del instituto
        sentenciaPreparadaIdInstituto.setString(1, nombreInstituto);
        ResultSet resultadoInstituto = sentenciaPreparadaIdInstituto.executeQuery();
        if (resultadoInstituto.next()) {
            int idInstitutoDestino = resultadoInstituto.getInt("ID_INSTITUTO");

            // Insertar la nueva solicitud de movilidad
            sentenciaPreparadaInsertar.setDate(1, fechaSolicitud);
            sentenciaPreparadaInsertar.setString(2, noControlAlumno);
            sentenciaPreparadaInsertar.setInt(3, idInstitutoDestino);

            int filasInsertadas = sentenciaPreparadaInsertar.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "La solicitud de movilidad se ha generado correctamente.");
            } 
        } 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta SQL: " + e.getMessage());
    }
}




public static void InsertarMateriasMovilidad(JTable tablaMaterias) {
    String sentenciaInsertar = "INSERT INTO MATERIAS_MOVILIDAD (FOLIO_MOVILIDAD, ID_MATERIA) VALUES (?, ?)";
    String sentenciaObtenerUltimoFolio = "SELECT TOP 1 FOLIO_MOVILIDAD FROM MOVILIDAD ORDER BY FOLIO_MOVILIDAD DESC";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparadaInsertar = conexion.prepareStatement(sentenciaInsertar);
         Statement sentencia = conexion.createStatement()) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMaterias.getModel();
        int rowCount = modeloTabla.getRowCount();

        // Obtener el último valor insertado en FOLIO_MOVILIDAD
        ResultSet resultado = sentencia.executeQuery(sentenciaObtenerUltimoFolio);
        int ultimoFolioMovilidad = -1;
        if (resultado.next()) {
            ultimoFolioMovilidad = resultado.getInt("FOLIO_MOVILIDAD");
        }

        if (ultimoFolioMovilidad != -1) {
            for (int i = 0; i < rowCount; i++) {
                int idMateria = (int) modeloTabla.getValueAt(i, 0); // Suponiendo que el ID de materia está en la primera columna (columna 0)

                sentenciaPreparadaInsertar.setInt(1, ultimoFolioMovilidad);
                sentenciaPreparadaInsertar.setInt(2, idMateria);
                sentenciaPreparadaInsertar.executeUpdate();
            }         
        } 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta SQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}




public static String SeleccionarUltimaSolicitudAlumno(JTable tablaMovilidad, String noControlAlumno) {
    String sentenciaBuscar = "SELECT TOP 1 M.FOLIO_MOVILIDAD, M.FECHA_SOLICITUD, M.NoCONTROL_ALUMNO, I.NOMBRE_INSTITUTO, M.ESTATUS " +
            "FROM MOVILIDAD M " +
            "INNER JOIN INSTITUTO I ON M.ID_INSTITUTO_DESTINO = I.ID_INSTITUTO " +
            "WHERE M.NoCONTROL_ALUMNO = ? " +
            "ORDER BY M.FOLIO_MOVILIDAD DESC";

    String estatus = null;

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {

        sentenciaPreparada.setString(1, noControlAlumno);

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMovilidad.getModel();
        modeloTabla.setRowCount(0); // Limpiar el modelo de la tabla

        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            if (resultado.next()) {
                int folioMovilidad = resultado.getInt("FOLIO_MOVILIDAD");
                String fechaSolicitud = resultado.getString("FECHA_SOLICITUD");
                int noControl = resultado.getInt("NoCONTROL_ALUMNO");
                String nombreInstituto = resultado.getString("NOMBRE_INSTITUTO");
                estatus = resultado.getString("ESTATUS");

                modeloTabla.addRow(new Object[]{folioMovilidad, fechaSolicitud, noControlAlumno, nombreInstituto, estatus});
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }

    return estatus;
}




public static void mostrarMaterias(JTable tablaMaterias, JTable tablaMovilidad) {
    DefaultTableModel modeloTablaMaterias = (DefaultTableModel) tablaMaterias.getModel();
    DefaultTableModel modeloTablaMovilidad = (DefaultTableModel) tablaMovilidad.getModel();

    // Obtener el valor de folioMovilidad de la primera fila de la tablaMovilidad
    int primeraFila = 0;
    String folioMovilidad = String.valueOf(modeloTablaMovilidad.getValueAt(primeraFila, 0)); // Suponiendo que el folio se encuentra en la primera columna (columna 0)

    String sentenciaBuscar = "SELECT m.NOMBRE_MATERIA FROM MATERIAS_MOVILIDAD mm " +
                             "INNER JOIN MATERIA m ON mm.ID_MATERIA = m.ID_MATERIA " +
                             "WHERE mm.FOLIO_MOVILIDAD = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {

        sentenciaPreparada.setInt(1, Integer.parseInt(folioMovilidad));

        modeloTablaMaterias.setRowCount(0); // Limpiar la tabla antes de llenarla con los resultados

        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                String nombreMateria = resultado.getString("NOMBRE_MATERIA");

                modeloTablaMaterias.addRow(new Object[]{nombreMateria});
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }
}




public static void modificarEstatusCancelado(String noControlAlumno) {
    // Obtener el último folio de movilidad del alumno
    String sentenciaFolio = "SELECT TOP 1 FOLIO_MOVILIDAD FROM MOVILIDAD WHERE NoCONTROL_ALUMNO = ? ORDER BY FOLIO_MOVILIDAD DESC";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparadaFolio = conexion.prepareStatement(sentenciaFolio)) {

        sentenciaPreparadaFolio.setString(1, noControlAlumno);

        try (ResultSet resultadoFolio = sentenciaPreparadaFolio.executeQuery()) {
            if (resultadoFolio.next()) {
                int folioMovilidad = resultadoFolio.getInt("FOLIO_MOVILIDAD");

                // Actualizar el estatus en la tabla de la base de datos
                String sentenciaActualizar = "UPDATE MOVILIDAD SET ESTATUS = 'Cancelado' WHERE FOLIO_MOVILIDAD = ?";

                try (PreparedStatement sentenciaPreparadaActualizar = conexion.prepareStatement(sentenciaActualizar)) {
                    sentenciaPreparadaActualizar.setInt(1, folioMovilidad);
                    int filasAfectadas = sentenciaPreparadaActualizar.executeUpdate();

                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "La solicitud se cancelo");
                    }
                }
            } 
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }
}




























/////////////////////////////////////////METODOS MAINEMPLEADO\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
public static String[] obtenerDatosEmpleado(String noControlEmpleado) {
    String[] Empleado = {
        "E.NoCONTROL_EMPLEADO", "NOMBRE_EMPLEADO", "APELLIDOS_EMPLEADO", "NOMBRE_INSTITUTO",
        "TELEFONO_EMPLEADO", "CORREO_EMPLEADO", "C.NOMBRE_CARRERA", "ROL_EMPLEADO"
    };
    
    String sentenciaBuscar = "SELECT " + String.join(", ", Empleado) +
            " FROM EMPLEADO E INNER JOIN INSTITUTO I ON E.ID_INSTITUTO_EMPLEADO = I.ID_INSTITUTO " +
            "LEFT JOIN CARRERA C ON E.ID_CARRERA = C.ID_CARRERA " +
            "WHERE E.NoCONTROL_EMPLEADO = ?";
    
    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {
        sentenciaPreparada.setString(1, noControlEmpleado);
        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            if (resultado.next()) {
                datosEmpleado = new String[8]; // Actualizar el tamaño del array según la cantidad de columnas
                for (int i = 0; i < datosEmpleado.length; i++) {
                    datosEmpleado[i] = resultado.getString(i + 1);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }
    
    return datosEmpleado;
}

 
 
 
 
public static void SeleccionarSolicitudesEmpleado(JTable tablaMovilidad, String nombreCarrera, String nombreInstituto) {
    String sentenciaBuscarSolicitudes = "SELECT M.FOLIO_MOVILIDAD, M.FECHA_SOLICITUD, M.NoCONTROL_ALUMNO, I.NOMBRE_INSTITUTO, M.ESTATUS " +
            "FROM MOVILIDAD M " +
            "INNER JOIN ALUMNOS A ON M.NoCONTROL_ALUMNO = A.NoCONTROL_ALUMNO " +
            "INNER JOIN CARRERA C ON A.ID_CARRERA = C.ID_CARRERA " +
            "INNER JOIN INSTITUTO I ON M.ID_INSTITUTO_DESTINO = I.ID_INSTITUTO " +
            "WHERE C.NOMBRE_CARRERA = ? AND I.NOMBRE_INSTITUTO = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscarSolicitudes)) {

        sentenciaPreparada.setString(1, nombreCarrera);
        sentenciaPreparada.setString(2, nombreInstituto);
        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaMovilidad.getModel();
            modeloTabla.setRowCount(0); // Limpiar el modelo de la tabla antes de agregar nuevos datos

            while (resultado.next()) {
                int folioMovilidad = resultado.getInt("FOLIO_MOVILIDAD");
                String fechaSolicitud = resultado.getString("FECHA_SOLICITUD");
                int noControlAlumno = resultado.getInt("NoCONTROL_ALUMNO");
                String Instituto = resultado.getString("NOMBRE_INSTITUTO");
                String estatus = resultado.getString("ESTATUS");

                modeloTabla.addRow(new Object[]{folioMovilidad, fechaSolicitud, noControlAlumno, Instituto, estatus});
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }
}







public static void buscarDatosAlumnoPorFolioMovilidad(JTable tablaMovilidad, JTable tablaAlumno) {
    DefaultTableModel modeloTablaMovilidad = (DefaultTableModel) tablaMovilidad.getModel();
    DefaultTableModel modeloTablaAlumno = (DefaultTableModel) tablaAlumno.getModel();
    
    int filaSeleccionada = tablaMovilidad.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        String folioMovilidad = String.valueOf(modeloTablaMovilidad.getValueAt(filaSeleccionada, 0)); // Suponiendo que el folio se encuentra en la primera columna (columna 0)
        
        String sentenciaBuscar = "SELECT a.NoCONTROL_ALUMNO, a.NOMBRE_ALUMNO, a.APELLIDOS_ALUMNO, a.CURP_ALUMNO, a.TELEFONO_ALUMNO, a.CORREO_ALUMNO, i.NOMBRE_INSTITUTO, c.NOMBRE_CARRERA, a.SEMESTRE, a.PROMEDIO, a.ESTATUS_NO_ADEDUDO, a.ESTATUS_MATERIAS_RC, a.NUMERO_MOVILIDADES " +
                                 "FROM ALUMNOS a " +
                                 "INNER JOIN MOVILIDAD m ON a.NoCONTROL_ALUMNO = m.NoCONTROL_ALUMNO " +
                                 "INNER JOIN CARRERA c ON a.ID_CARRERA = c.ID_CARRERA " +
                                 "INNER JOIN INSTITUTO i ON a.ID_INSTITUTO_ALUMNO = i.ID_INSTITUTO " +
                                 "WHERE m.FOLIO_MOVILIDAD = ?";
        
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {
            
            sentenciaPreparada.setString(1, folioMovilidad);
            
            modeloTablaAlumno.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            
            try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    int noControlAlumno = resultado.getInt("NoCONTROL_ALUMNO");
                    String nombre = resultado.getString("NOMBRE_ALUMNO");
                    String apellidos = resultado.getString("APELLIDOS_ALUMNO");
                    String curp = resultado.getString("CURP_ALUMNO");
                    String telefono = resultado.getString("TELEFONO_ALUMNO");
                    String correo = resultado.getString("CORREO_ALUMNO");
                    String nombreInstituto = resultado.getString("NOMBRE_INSTITUTO");
                    String nombreCarrera = resultado.getString("NOMBRE_CARRERA");
                    String semestre = resultado.getString("SEMESTRE");
                    double promedio = resultado.getDouble("PROMEDIO");
                    String estatusNoAdeudo = resultado.getString("ESTATUS_NO_ADEDUDO");
                    boolean estatusMateriasRC = resultado.getBoolean("ESTATUS_MATERIAS_RC");
                    int numeroMovilidades = resultado.getInt("NUMERO_MOVILIDADES");
                    
                    modeloTablaAlumno.addRow(new Object[]{"No. Control", noControlAlumno});
                    modeloTablaAlumno.addRow(new Object[]{"Nombre", nombre});
                    modeloTablaAlumno.addRow(new Object[]{"Apellidos", apellidos});
                    modeloTablaAlumno.addRow(new Object[]{"CURP", curp});
                    modeloTablaAlumno.addRow(new Object[]{"Teléfono", telefono});
                    modeloTablaAlumno.addRow(new Object[]{"Correo", correo});
                    modeloTablaAlumno.addRow(new Object[]{"Instituto de Origen", nombreInstituto});
                    modeloTablaAlumno.addRow(new Object[]{"Carrera", nombreCarrera});
                    modeloTablaAlumno.addRow(new Object[]{"Semestre", semestre});
                    modeloTablaAlumno.addRow(new Object[]{"Promedio", promedio});
                    modeloTablaAlumno.addRow(new Object[]{"Estatus No Adeudo", estatusNoAdeudo});
                    modeloTablaAlumno.addRow(new Object[]{"Estatus Materias RC", estatusMateriasRC});
                    modeloTablaAlumno.addRow(new Object[]{"Número de Movilidades", numeroMovilidades});
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila en la tabla de movilidad", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




public static void mostrarMateriasPorFolio(JTable tablaMaterias, JTable tablaMovilidad) {
    DefaultTableModel modeloTablaMaterias = (DefaultTableModel) tablaMaterias.getModel();
    DefaultTableModel modeloTablaMovilidad = (DefaultTableModel) tablaMovilidad.getModel();

    int filaSeleccionada = tablaMovilidad.getSelectedRow();

    if (filaSeleccionada != -1) {
        String folioMovilidad = String.valueOf(modeloTablaMovilidad.getValueAt(filaSeleccionada, 0)); // Suponiendo que el folio se encuentra en la primera columna (columna 0)

        String sentenciaBuscar = "SELECT m.NOMBRE_MATERIA FROM MATERIAS_MOVILIDAD mm " +
                                 "INNER JOIN MATERIA m ON mm.ID_MATERIA = m.ID_MATERIA " +
                                 "WHERE mm.FOLIO_MOVILIDAD = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {

            sentenciaPreparada.setString(1, folioMovilidad);

            modeloTablaMaterias.setRowCount(0); // Limpiar la tabla antes de llenarla con los resultados

            try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
                while (resultado.next()) {
                    String nombreMateria = resultado.getString("NOMBRE_MATERIA");

                    modeloTablaMaterias.addRow(new Object[]{nombreMateria});
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e.getMessage());
        }
    }
}





public static void modificarRegistroSeleccionado(JTable tabla) {
    DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
    int filaSeleccionada = tabla.getSelectedRow();

    if (filaSeleccionada != -1) {
        int folioMovilidad = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        String fechaSolicitud = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        int noControlAlumno = (int) modeloTabla.getValueAt(filaSeleccionada, 2);
        String nombreInstitutoDestino = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
        String estatus = (String) modeloTabla.getValueAt(filaSeleccionada, 4);

        // Realizar la modificación en la base de datos utilizando los valores obtenidos

        // Ejemplo de actualización utilizando JDBC y SQL
        String sentenciaActualizar = "UPDATE MOVILIDAD SET FECHA_SOLICITUD = ?, NoCONTROL_ALUMNO = ?, ID_INSTITUTO_DESTINO = ?, ESTATUS = ? WHERE FOLIO_MOVILIDAD = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaActualizar)) {
            sentenciaPreparada.setString(1, fechaSolicitud);
            sentenciaPreparada.setInt(2, noControlAlumno);

            // Obtener el ID del instituto utilizando el nombre
            int idInstitutoDestino = obtenerIdInstituto(nombreInstitutoDestino);

            sentenciaPreparada.setInt(3, idInstitutoDestino);
            sentenciaPreparada.setString(4, estatus);
            sentenciaPreparada.setInt(5, folioMovilidad);

            int filasActualizadas = sentenciaPreparada.executeUpdate();
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "La solicitud de movilidad se actualizó correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la solicitud de movilidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public static int obtenerIdInstituto(String nombreInstituto) {
    int idInstituto = 0;
    String sentenciaBuscar = "SELECT ID_INSTITUTO FROM INSTITUTO WHERE NOMBRE_INSTITUTO = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar)) {
        sentenciaPreparada.setString(1, nombreInstituto);

        try (ResultSet resultado = sentenciaPreparada.executeQuery()) {
            if (resultado.next()) {
                idInstituto = resultado.getInt("ID_INSTITUTO");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
    }

    return idInstituto;
}
}