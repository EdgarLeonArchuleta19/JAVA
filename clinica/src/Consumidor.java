// Fig. 23.13: Consumidor.java
// Consumidor con un m�todo run que itera y lee 10 valores del b�fer.
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private final int DIEZ_MINUTOS = 1000 * 60 * 8;	// Milisegundos * Segundos * Minutos
   private final int DIEZ_SEGUNDOS = 1000 * 10;		// Milisegundos * Segundos
   private final int VEINTE_SEGUNDOS = 1000 * 20;		// Milisegundos * Segundos

   // constructor
   public Consumidor( Bufer compartido )
   {
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
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
	      while ( ( ( horaActual - horaInicial ) <= DIEZ_MINUTOS ) || !ubicacionCompartida.estaVacio() )
	      {
	          try
	          {
	             Thread.sleep( VEINTE_SEGUNDOS + generador.nextInt(  DIEZ_SEGUNDOS ) );
	             int tipoServicio = ubicacionCompartida.obtener();
	             
	             // Actualizar contador de tipo de servicio
	             if ( tipoServicio == 1 )
	            	 particularConsulta ++;
	             else if ( tipoServicio == 2 )
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
} // fin de la clase Consumidor


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