package METODOSNUMERICOS;
import java.text.DecimalFormat;
import java.util.*;

public class nr{

	static Scanner leer = new Scanner(System.in); 
	
	    public static void main(String[] args){  
	    	
	    	
	   //Portada del programa con la información
	    System.out.println("\t\t"+"Instituto Tecnológico de Culiacán"); 
	    System.out.println("\t\t"+"Ingenieria en sistemas computacionales"); 
	    System.out.println("\n"); 
	    System.out.println("León Archuleta Edgar"); 
	    System.out.println("Díaz Durazo Marco Antonio"); 
	    System.out.println("Aguilar Lopez Diego"); 
	    System.out.println("Método de Newton Raphson"); 
	    System.out.println("De 11:00 a 12:00 horas.\n"); 
	    System.out.println("Pregunta: Calcular las raíces múltiples de la Ecuación f(x)= x Cosx2"
	    		+ "-4, \nutilizando un rango de"
	    		+ "búsqueda de -500 a 500 en el eje de las x, \ncon un error de 0.001 para mejor"
	    		+ "aproximación.\n\n");
	    
	    
	      //Declaración de variables
	            int iteraciones, contador=0; 
	            double Fx1=0.0,dFx1=0.0,Fx2=0.0,x2=0.0,factor=0.55,RangoF=0,x1=0,error=0,calculos=0;
	            DecimalFormat df = new DecimalFormat("#.000000");
	            
	            
	            
	       //Se piden los datos para generar el metodo con raices multiples   	
	            System.out.print("Ingrese x1:");            
	            x1=leer.nextDouble(); 
	            System.out.print("Ingrese el error:"); 
	            error=leer.nextDouble(); 
	            System.out.print("Ingrese el numero de calculos:");            
	            calculos=leer.nextDouble(); 
	            iteraciones=0;            
	            System.out.print("Rango Final:");
	            RangoF=leer.nextDouble();
	            Fx1=x1*Math.cos(x1*x1)-4;
	            
	            
	            
	        //Empieza el ciclo para encontrar las raices de la función  
	            do {	
	            System.out.println("==============================================================================");
			         System.out.println("N\tX1\t\tFX1\t\tF'X1\t\tX2\t\tFX2");  	
	            do {       
	            	
	        //Se formulan los datos y se imprimen	
	              iteraciones++; 
	              dFx1= (-2*((x1*x1)))*Math.sin(x1*x1)+Math.cos(x1*x1);
	              x2= x1-(Fx1/dFx1); 
	              Fx2=x2*Math.cos((Math.pow(x2, 2)))-4;
	              System.out.println(iteraciones+"\t"+df.format(x1)+"\t"+df.format(Fx1)+"\t"+df.format(dFx1)+"\t"+df.format(x2)+"\t"+df.format(Fx2)); 
	                
	                
	        //Aqui se declara que los valores de x1 y fx1 se pasaron mientras el error y las iteraciones sigan
	                if(Math.abs(Fx2) > error && iteraciones < calculos) { 
	                    x1=x2; 
	                    Fx1=Fx2;     
	                }else{
	                	break; 
	                } 
	            }while(Math.abs(Fx2) > error || iteraciones < calculos); 
	            
	        
	        //Reiniciamos las iteraciones cuando se encuentra la raiz y se imprime
	            iteraciones=0;
	            if (iteraciones < calculos) System.out.println("\n"+"La raiz es igual a: " + x2); 
	            
	            
	        //Se valida que X2 sea mayor a x1 para que el programa encuentre los puntos para la derecha
	           if(x2>x1) {
	           x1=x1+factor;
	           }else {
	           
	           if(Math.abs(Fx2) <= error ) {
	        	   x1=x2+factor;
	              }
	           }
	         
	        //Ciclo que se repita hasta que el número de calculos o el rango se pase
	           contador++;
	           System.out.println("\n\n");
	            }while(contador<calculos && x1<RangoF);
	                
	            }
	       
	        } 
	 
	    