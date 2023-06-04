// Fig. 23.12: Productor.java
// Productor con un m�todo run que inserta los valores del 1 al 10 en el b�fer.
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Productor implements Runnable
{
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private final int OCHO_MINUTOS = 1000 * 60 * 8;	// Milisegundos * Segundos * Minutos
   private final int DIEZ_SEGUNDOS = 1000 * 60;		// Milisegundos * Segundos

   // constructor
   public Productor( Bufer compartido )
   {
       ubicacionCompartida = compartido;
   } // fin del constructor de Productor

   // almacena valores del 1 al 10 en ubicacionCompartida
   public void run()                             
   {
      int particularConsulta = 0;
      int particularSeguimiento = 0;
      int trabajadorBanco = 0;
      
      long horaInicial = 0;
      long horaActual = 0;
      
      // Obtener la hora actual en milisegundos
      Calendar tiempo = new GregorianCalendar();
      horaInicial = tiempo.getTimeInMillis();
      horaActual = horaInicial;
      
      // Ciclo por diez minutos
      while ( ( horaActual - horaInicial ) <= OCHO_MINUTOS )
      {
          try
          {
             Thread.sleep( generador.nextInt(  DIEZ_SEGUNDOS ) );
             int tipoPaciente = generador.nextInt( 3 ) + 1;
             ubicacionCompartida.establecer( tipoPaciente );
             
             // Actualizar contador de tipo de servicio
             if ( tipoPaciente == 1 )
            	 particularConsulta ++;
             else if ( tipoPaciente == 2 )
            	 particularSeguimiento ++;
             else
            	 trabajadorBanco ++;
          } // fin de try
          // si las l�neas 25 o 26 se interrumpen, imprime el rastreo de la pila
          catch ( InterruptedException excepcion ) 
          {
             excepcion.printStackTrace();
          } // fin de catch

          // Obtener la nueva hora
          tiempo = new GregorianCalendar();
          horaActual = tiempo.getTimeInMillis();    	  
      }
      
      // Totalizar servicios
      int totalServicios = particularConsulta + particularSeguimiento + trabajadorBanco;
      
      // Calcular los importes
      double impConsulta = particularConsulta * 300.0;
      double impSeguimiento = particularSeguimiento * 100.0;
      double impBanco = trabajadorBanco * 0.0;
      
      double impTotal = impConsulta + impSeguimiento + impBanco;
      
      System.out.println( 
         "Clinica cerrado" );
      System.out.printf( "Servicio\tCantidad\tImporte\n" );
      System.out.printf( "Particular-Consulta\t%,9d\t%,9.2f\n", particularConsulta, impConsulta);
      System.out.printf( "Particular-Seguimiento\t%,9d\t%,9.2f\n", particularSeguimiento, impSeguimiento);
      System.out.printf( "Trabajador-Banco\t%,9d\t%,9.2f\n", trabajadorBanco, impBanco);
      System.out.printf( "Total\t%,9d\t%,9.2f\n", totalServicios, impTotal);
   } // fin del m�todo run
} // fin de la clase Productor



/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/