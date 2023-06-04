package RECURSIVIDAD;
import java.util.Scanner;

public class Division {
	
	 static Scanner leer = new Scanner(System.in);
     
	
	     
	    private static int division(int dividendo, int divisor){
	        if(divisor>dividendo){
	            return 0;
	        } else {
	            return 1 + division(dividendo-divisor, divisor);
	        }
	    }
	    
	    public static void main(String[] args) {
	    	
	        int dividendo, divisor;
	        int D=0;
	        
	        do {
	        	System.out.println("----DIVISON----"+"\n");
	        System.out.print("Digite el dividendo: ");
	        dividendo = leer.nextInt();
	        System.out.print("Digite el divisor: ");
	        divisor = leer.nextInt();
	        System.out.printf("%n"+"La división es: "+"%d", division(dividendo, divisor));
	        
	        
	    		System.out.print("\n"+"Seguir?(1=si, 0=no):");
	    		D=leer.nextInt();
	    		}while(D==1);
	    		
	    		if(D==0) {
	    			System.out.println("Fin del programa");
	    		}
	    }
	    
	    
		
	}

	


