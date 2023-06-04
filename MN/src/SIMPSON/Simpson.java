package SIMPSON;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Simpson {

    static Scanner leer = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#0.00000");
    static DecimalFormat df2 = new DecimalFormat("#0.00");


    public static void main(String[] args) {
        
    	
    	//Declaración de variables para el programa
    	int n=1, factor=0;
    	double h, fa, x1,x2,fx2, fb,fx1, Vcal, error, Vreal,a,b, ca, cb;
    	double fpto=0, pto=0, valor=0;
    	String unidad, pregunta;
    	
        //Datos de presentación del programa
    	System.out.println("\t\t\tINSTITUTO TECNOLOGICO DE CULIACÁN	");
		System.out.println("\t\t\t\tING. DE SISTEMAS\n");
		System.out.println("Jorge Luis Cañedo Lizarraga");
		System.out.println("Edgar Léon Archuleta ");
		System.out.println("Integración Numérica - Método de Simpson");
		System.out.println("De 10:00 a 11:00 horas");		
		System.out.println("\n\n=========================CAPTURA DE DATOS DEL PROBLEMA========================\n");
		System.out.print("¿Cuál es la pregunta del problema? "); 
		pregunta = leer.nextLine();
        System.out.print("Valor real:"); 
		Vreal = leer.nextDouble();
        System.out.print("Limite inferior:"); 
		a = leer.nextInt();
        System.out.print("Limite superior: "); 
		b = leer.nextInt();
		System.out.print("¿Cuál es la unidad de la solución? ");
		unidad = leer.next();
       
		
		//Ciclo para poder escoger otro número de diviviones despues de tener los resultados de un problema o terminar el programa
        while(n!=0) {
    	  
    	  
		//Menu para elegir la regla de Simpson a usar
        System.out.println("\n\n=============MENU================");	
        System.out.println("\nMétodo Reglas de Simpson:\n");
   
        System.out.println("Regla 1 n=2");
        System.out.println("Regla 2 n=3");
        System.out.println("Regla 3 n>2 y n=par");
        System.out.println("Regla 4 n>3,  n=impar y n*3");
        System.out.println("Fin. n=0");
        System.out.print("\n\nEscribe el número de divisiones:");
        n=leer.nextInt();       
        
        
        //Si N es igual a 0 el programa acaba y se termina el ciclo        
        if(n==0){      	
            System.out.println("\nFin del programa"); 
            break;
        }
        
        System.out.println("\n\n\t\t\tINSTITUTO TECNOLOGICO DE CULIACÁN	");
		System.out.println("\t\t\t\tING. DE SISTEMAS\n");
		System.out.println("Jorge Luis Cañedo Lizarraga");
		System.out.println("Edgar Léon Archuleta ");
		System.out.println("Integración Numérica - Método de Simpson");
		System.out.println("De 10:00 a 11:00 horas");	
	    System.out.println("\nPregunta: "+pregunta);
	    System.out.println("\n\n=========================IMPRESION DE DATOS DEL PROBLEMA========================\n");
            
        //Si N es igual a 2 se usa el metodo de simpson 1/3    
        if(n==2){
            
        	      	
        	//Se usan las formulas correspondientes y se imprimen los datos de los calculos simpson 1/3
            h=(b-a)/n;                 
            fa=2+Math.sin(2*Math.sqrt(a));
            x1=a+h;           
            fx1=2+Math.sin(2*Math.sqrt(x1));
            fb=2+Math.sin(2*Math.sqrt(b));          
           
            Vcal=((1*h/3)*(fa+(4*fx1)+fb));            
            error =Math.abs(Vreal-Vcal);
            
            
            System.out.println("PX\tX\tF(x)\t\tFactor\tArea");          
            System.out.println("1\t"+a+"\t"+df.format(fa)+"\t\t1\t"+df.format(fa));
            System.out.println("2\t"+x1+"\t"+df.format(fx1)+"\t\t4\t"+df.format(fx1*4));
            System.out.println("3\t"+b+"\t"+df.format(fb)+"\t\t1\t"+df.format(fb));           
            
            System.out.println("\n\n");
            System.out.println("NO. de Divisiones: "+n);
            System.out.println("Valor Real de la integral: "+Vreal+" "+unidad);
            System.out.println("Valor por el Método: "+df.format(Vcal)+" "+unidad);
            System.out.println("Error del metodo: "+df.format(error)+" "+unidad);
            
            
         //Si N es igual a 3 se usa el metodo de simpson 3/8  
        }else if(n==3){
                      
        	
        	
        	//Se usan las formulas correspondientes y se imprimen los datos de los calculos simpson 3/8
            h=(b-a)/n;                 
            fa=2+Math.sin(2*Math.sqrt(a));
            x1=a+h;  
            x2=a+(2*h);
            fx1=2+Math.sin(2*Math.sqrt(x1));
            fx2=2+Math.sin(2*Math.sqrt(x2));
            fb=2+Math.sin(2*Math.sqrt(b));            
           
            Vcal=((3*h/8)*(fa+(3*fx1)+(3*fx2)+fb));            
            error =Math.abs(Vreal-Vcal);
                       
            System.out.println("PX\tX\tF(x)\t\tFactor\tArea");          
            System.out.println("1\t"+df2.format(a)+"\t"+df.format(fa)+"\t\t1\t"+df.format(fa));
            System.out.println("2\t"+df2.format(x1)+"\t"+df.format(fx1)+"\t\t4\t"+df.format(fx1*3));
            System.out.println("3\t"+df2.format(x2)+"\t"+df.format(fx2)+"\t\t4\t"+df.format(fx2*3));
            System.out.println("4\t"+df2.format(b)+"\t"+df.format(fb)+"\t\t1\t"+df.format(fb));
                        
            System.out.println("\n\n");
            System.out.println("NO. de Divisiones: "+n);
            System.out.println("Valor Real de la integral: "+Vreal+" "+unidad);
            System.out.println("Valor por el Método: "+df.format(Vcal)+" "+unidad);
            System.out.println("Error del metodo: "+df.format(error)+" "+unidad);
            
            
            
            
          //Si N es mayor a 2 y par, se usa el metodo de simpson 1/3 complejo  
        }else if(n>2 && n%2==0){
        	
            Vcal=0;
            h=(b-a)/n;
            ca=a;
            cb=b;
                     
            
            //Se usa un ciclo FOR para saber las posiciones donde se usara el factor de 1, 2 y 4
        	System.out.println("PX\tX\tF(x)\t\tFactor\tArea"); 
            for(int x=1;x<=n+1;x++){   
            	     	
            	if(x==1) {
            		factor=1;
            		pto=ca;
            		fpto=2+Math.sin(2*Math.sqrt(pto));
            		valor =factor*fpto;
            		Vcal=Vcal+valor;
            		
            	}else if(x==n+1) {
            		
            		factor=1;
            		pto=cb;
            		fpto=2+Math.sin(2*Math.sqrt(pto));
            		valor =factor*fpto;
            		Vcal=Vcal+valor;
            		
            	}else if(x>1 && x<n+1){
            		
            		 
            		int pos=x-1;
            		int res=(x%2);
            			
            		if(res==0) {
            			factor=4;
            			pto=ca+(pos*h);
                		fpto=2+Math.sin(2*Math.sqrt(pto));
                		valor =factor*fpto;
                		Vcal=Vcal+valor;
                		
            			
            		}else {
            			factor=2;
            			pto=ca+(pos*h);
                		fpto=2+Math.sin(2*Math.sqrt(pto));
                		valor =factor*fpto;
                		Vcal=Vcal+valor;
                		
            			
            		} 		
            	}
          
            	System.out.println(x+"\t"+df2.format(pto)+"\t"+df.format(fpto)+"\t\t"+factor+"\t"+df.format(valor));              
            	}
            
       	    Vcal=(1*h/3)*Vcal;
            error =Math.abs(Vreal-Vcal);
            	
            System.out.println("\n\n");
            System.out.println("NO. de Divisiones: "+n);
            System.out.println("Valor Real de la integral: "+Vreal+" "+unidad);
            System.out.println("Valor por el Método: "+df.format(Vcal)+" "+unidad);
            System.out.println("Error del metodo: "+df.format(error)+" "+unidad);
            
            
            
            
          
          //Si N es mayor a 3, impar y multiplo de 3, se usa el metodo de simpson 3/8 complejo     
        }else if(n>3 && n%2!=0 && n%3==0){
              
            Vcal=0;
            h=(b-a)/n;
            ca=a;
            cb=b;     
        	
            
          //Se usa un ciclo FOR para saber las posiciones donde se usara el factor de 1, 2 y 3
        	System.out.println("PX\tX\tF(x)\t\tFactor\tArea");
            for(int x=1;x<=n+1;x++){   
            	   	
            	if(x==1) {
            		factor=1;
            		pto=ca;
            		fpto=2+Math.sin(2*Math.sqrt(pto));
            		valor =factor*fpto;
            		Vcal=Vcal+valor;
            		
            	}else if(x==n+1) {
            		
            	    factor=1;
            		pto=cb;
            		fpto=2+Math.sin(2*Math.sqrt(pto));
            		valor =factor*fpto;
            		Vcal=Vcal+valor;
            		
            	}else if(x>1 && x<n+1){
            		
            		            		 
            		int pos=x-1;
            		int res=((x-1)%3);
            			
            		if(res==0) {
            		    factor=2;
            			pto=ca+(pos*h);
                		fpto=2+Math.sin(2*Math.sqrt(pto));
                		valor =factor*fpto;
                		Vcal=Vcal+valor;
                	         		           			
            		}else {
            			
            			factor=3;
            			pto=ca+(pos*h);
                		fpto=2+Math.sin(2*Math.sqrt(pto));
                		valor =factor*fpto;
                		Vcal=Vcal+valor;
                	                		            			
            		} 		
            	}
        
            	System.out.println(x+"\t"+df2.format(pto)+"\t"+df.format(fpto)+"\t\t"+factor+"\t"+df.format(valor));
         
            	}
            
            Vcal=(3*h/8)*Vcal;
            error =Math.abs(Vreal-Vcal);
            
            System.out.println("\n\n");
            System.out.println("NO. de Divisiones: "+n);
            System.out.println("Valor Real de la integral: "+Vreal+" "+unidad);
            System.out.println("Valor por el Método: "+df.format(Vcal)+" "+unidad);
            System.out.println("Error del metodo: "+df.format(error)+" "+unidad);
          
            //Si N no cumple con ninguna condición el metodo de simpson no aplica
        }else {
        	System.out.println("Lo siento, Simpson no aplica para este número de divisiones");
        }

      }
        
    }  
}
