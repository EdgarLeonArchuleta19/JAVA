// Fig. 23.13: Consumidor.java
// Consumidor con un método run que itera y lee 10 valores del búfer.
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private final int DIEZ_MINUTOS = 1000 * 60 * 10;	// Milisegundos * Segundos * Minutos
   private final int DIEZ_SEGUNDOS = 1000 * 10;		// Milisegundos * Segundos
   private final int CINCO_SEGUNDOS = 1000 * 5;		// Milisegundos * Segundos

   // constructor
   public Consumidor( Bufer compartido )
   {
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
   public void run()                                           
   {
	      int basico = 0;
	      int normal = 0;
	      int extra = 0;
	      
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
	             Thread.sleep( CINCO_SEGUNDOS + generador.nextInt(  DIEZ_SEGUNDOS ) );
	             int tipoServicio = ubicacionCompartida.obtener();
	             
	             // Actualizar contador de tipo de servicio
	             if ( tipoServicio == 1 )
	            	 basico ++;
	             else if ( tipoServicio == 2 )
	            	 normal ++;
	             else
	            	 extra ++;
	          } // fin de try
	          // si las líneas 25 o 26 se interrumpen, imprime el rastreo de la pila
	          catch ( InterruptedException excepcion ) 
	          {
	             excepcion.printStackTrace();
	          } // fin de catch

	          // Obtener la nueva hora
	          tiempo = new GregorianCalendar();
	          horaActual = tiempo.getTimeInMillis(); 	    	  
	      }
	      
	      // Totalizar servicios
	      int totalServicios = basico + normal + extra;
	      
	      // Calcular los importes
	      double impBasico = basico * 80.0;
	      double impNormal = normal * 100.0;
	      double impExtra = extra * 120.0;
	      
	      double impTotal = impBasico + impNormal + impExtra;
	      
	      System.out.println( 
	         "Trabajadores terminan" );
	      System.out.printf( "Servicio\tCantidad\tImporte\n" );
	      System.out.printf( "Basico\t%,9d\t%,9.2f\n", basico, impBasico);
	      System.out.printf( "Normal\t%,9d\t%,9.2f\n", normal, impNormal);
	      System.out.printf( "Extra\t%,9d\t%,9.2f\n", extra, impExtra);
	      System.out.printf( "Total\t%,9d\t%,9.2f\n", totalServicios, impTotal);
	      
   } // fin del método run
} // fin de la clase Consumidor


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/