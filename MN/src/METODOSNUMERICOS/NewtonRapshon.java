package METODOSNUMERICOS;
import java.util.*;

public class NewtonRapshon{

	static Scanner leer = new Scanner(System.in); 
	
	    public static void main(String[] args){   	
	    	
	    System.out.println("\t\t"+"Instituto Tecnológico de Culiacán"); 
	    System.out.println("\t\t"+"Ingenieria en sistemas computacionales"); 
	    System.out.println("\n"); 
	    System.out.println("León Archuleta Edgar"); 
	    System.out.println("Díaz Durazo Marco Antonio"); 
	    System.out.println("Aguilar Lopez Diego"); 
	    System.out.println("Método de Newton Raphson"); 
	    System.out.println("De 10:00 a 11:00 horas.\n"); 
	  
	    System.out.println("Pregunta: Calcular las raíces múltiples de la Ecuación f(x)= x Cosx2"
	    		+ "-4, \nutilizando un rango de"
	    		+ "búsqueda de -500 a 500 en el eje de las x, \ncon un error de 0.001 para mejor"
	    		+ "aproximación.\n\n");
	    
	    
	     
	            int iteraciones, contador=0; 
	            double Fx2=0.0, x2=0.0, factor=0.05,RangoF=0.0, RangoI=0.0; 
	         	double x1=-10, error=0, calculos=0, Fx1=0, dFx1=0;
	         	
	         	System.out.println("x1 = -10");
	            System.out.print("Ingrese el error:"); 
	            error=leer.nextDouble(); 
	            System.out.print("Ingrese el numero de calculos:");            
	            calculos=leer.nextDouble(); 
	            iteraciones=0;            
	            System.out.print("Rango Final:");
	            RangoF=leer.nextDouble();
	            
	             
	            
	     
	            do {
	            	
	            System.out.println("==============================================================================");
	            System.out.println("N\tX1\t\tFX1\t\tF'X1\t\tX2\t\tFX2"); 
	            
	            
	            
	            
	            do {       
	            	
	            	
	              
	              iteraciones++;   
	              Fx1= (x1*(Math.cos(x1*(x1)))-4);
	              dFx1= (-2*((x1*x1)))*Math.sin(x1*x1)+Math.cos(x1*x1);
	             
	                x2= x1-(Fx1/dFx1); 
	                Fx2=(x2*(Math.cos(x2*(x2)))-4);
	                System.out.print(iteraciones); 
	                System.out.printf("     %10.6f    %10.6f", x1, Fx1); 
	                System.out.printf("      %10.6f      %10.6f      %10.6f \n",dFx1, x2, Fx2);             
	                
	                if(Math.abs(Fx2) > error && iteraciones < calculos) { 
	                
	                    x1=x2; 
	                    Fx1=Fx2; 
	                
	                }else{
	                	
	                 	break; 
	                }
	              
	            }while(Math.abs(Fx2) > error || iteraciones < calculos); 
	            
	            iteraciones=0;
	           
	            if (iteraciones < calculos) { 
	                 System.out.println("\n"+"La raiz es igual a: " + x2); 
	             }  
	           
	           System.out.println("\n");
	       
	           
	           if(x2>x1) {
		           x1=x1+factor;
		           }else {
		           
		           if(Math.abs(Fx2) <= error ) {
		        	   x1=x2+factor;
		           }
		           
		           }
		           
	          
	           
	       
	           contador++;
	           
	            }while(contador<calculos && x1<RangoF);
	   
	           }
	           
	        } 
	 
	    
	    


