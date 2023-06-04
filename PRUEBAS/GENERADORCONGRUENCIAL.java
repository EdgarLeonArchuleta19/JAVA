package PRUEBAS;

import java.util.Random;
import java.util.Scanner;

public class GENERADORCONGRUENCIAL {
	
	static Scanner leer = new Scanner(System.in);
	static Random random = new Random();
	

	 public static void main(String[] args) {
	
		int siono=0;
        long a = 0, x = 0, c = 0;
        long m = 0;
        
		do {	 
		 
			System.out.println("\n"+"==Generador de Números congruencial=="+"\n");
			a = multiplicador(); 
		    x = semilla(); 
            c = constante(); 
            m = modulo(); 
            calcular(x, a, c, m); 
		   System.out.println("\n"+"¿Deseas seguir generando numeros Pseudoaletarios?");
	       System.out.print("Sí(1)  -  No(2): ");
	       siono=leer.nextInt();
		
			}while(siono==1);
			
			if(siono==2) System.out.println("Fin del programa.");	
	 }
	 
	 
	
	 
	 
	 
	public static long multiplicador() {
				
	   long a=0;
	   long k=0;
	   
	   
	do {	
		  
	     System.out.println("Vamos a generar el multiplicador con la siguiente formula (10^k+1)");
	     System.out.print("Escoje al valor de K(mayor a 2): ");
	     k=leer.nextInt();
	     a=(int) (Math.pow(10, k)+1);
	     System.out.println("El valor generado de a fue: "+a);
	     
	       }while(a%3==0||a%5==0|| a%2!=1 ||k<2);
	
	   
	   return a;
			}
	
	
	
	
     public static long semilla() {
		
	     int opcion=0;
		 long x=0;
		   
	       System.out.println("¿Cómo quieres generar la semilla?");
           System.out.println("1.Por teclado");
           System.out.println("2.Random");
           System.out.print("Elige una opción:");
           opcion=leer.nextInt();
    
    if(opcion==1) {
    	
    	System.out.print("Ingrese la semilla:");
    	x=leer.nextInt();
    	
    }
    if(opcion==2) {
    	x = random.nextInt(1000 - 500) + 500;
    	System.out.println("La semilla generada fue:"+x);
    }

    return x;
			  }

    
	
	
	
    
     public static long constante() {
	   long c=0;
      do {

            System.out.print("Ingresar el incremento Y (numero impar y cumpliendo la regla c mod 200=21):");
            c=leer.nextInt();
            
      }while(c%2!=1 && c%200!=21);
      
      
    return c;   
     }




    
     public static long modulo() {
	   int opcion;
	   long m = 0;
    
          System.out.println("¿Cómo quieres generar el modulo?");
          System.out.println("1.Random");
          System.out.println("2.Cumplir regla");
          System.out.print("Elige una opción:");
          opcion=leer.nextInt();
    
    if(opcion==1) {
    	m = random.nextInt(100000 - 50000) + 50000;
    	System.out.println("El modulo generado fue:"+m);
    }
    
    
    if(opcion==2) {
    	
    	long regla=999999999999989L;
    	m=regla;
    	System.out.println("El numero generado fue:"+m);
    	
    
    } 
     return m;
     
      }


	
	
	
    public static void calcular(long x, long a, long c, long m) {
	
       long s,r;
   	   long comprobarR[] = new long[10000000];
   	   long comprobarS[] = new long[10000000];
   	   boolean validar=true;
   	
   	
   	   System.out.println("Para: X(0)= "+x+", a= "+a+", c= "+c+" y m= "+m+"\n");
       System.out.println("n"+"\t"+"x"+"\t"+"axn+c"+"\t"+"(axn+c)/m"+"\t"+"xn+1");
       
       for(int i=0; validar; i++) {
       	s=a*x+c;
       	r=s%m;
       	System.out.println(i+"\t"+x+"\t"+s+"\t"+s+"/"+m+"\t"+r);
     
       	comprobarS[i]=x;
       	
       	for(int j=0; i>j; j++) {
       		if(comprobarS[i]==comprobarS[j]) {
       		validar=false;
       		System.out.println("Semilla repetida en la posición "+j+" y "+i);
       		}
       	}
       	x=r;
       	comprobarR[i]=x;
    
       		for(int z=0; i>z; z++) {
       			if(comprobarR[i]==comprobarR[z]) {
       				System.out.println("Resultado repetido en la posición "+z+" y "+i);
   	    		 validar=false;
       			}
       		
       	}
       }
    }
}
  

