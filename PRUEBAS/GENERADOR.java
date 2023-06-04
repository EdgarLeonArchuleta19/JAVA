package PRUEBAS;


import java.util.Random;
import java.util.Scanner;

public class GENERADOR {
		
	static Scanner leer = new Scanner(System.in);
	
	    public static void main(String[] args) {
	    	
	        Random random = new Random();
            int n=0;
	         
	        System.out.println("¿Cómo quieres generar tus números Pseudoaleatorios?"+"\n");
	        System.out.println("1.Por teclado");
	        System.out.println("2.Random");
	        
	        do {
	        	
	        System.out.print("\n"+"Elige una opción:");
	        n=leer.nextInt();
	        
	        }while(n==0 || n>=3);
	        
	        
	        if(n==1) {
	        
	        	int G=0;
	        	
	        	System.out.print("Elige la cantidad de numeros a generar:");
	        	G=leer.nextInt();
	        	System.out.println("\n"+"Números Generados:");
	        	 
	        for(int i = 1; i <=G; i++) {
	            Double v = random.nextDouble() * 10 + 1;
	            System.out.println(v);
	        }
	    }
	        
	        if(n==2) {
	        	
		         int gene = random.nextInt(10 - 1) + 1;
		         
		         System.out.println("\n"+"Números Generados:");
		         
		        for(int i = 1; i <=gene; i++) {
		        	 Double v = random.nextDouble() * 10 + 1;
		            System.out.println(v);
		        }
		    }  
	    }
	}
	
