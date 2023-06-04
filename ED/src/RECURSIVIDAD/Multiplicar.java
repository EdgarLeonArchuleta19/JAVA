package RECURSIVIDAD;
import java.util.Scanner;

public class Multiplicar {

	
	 static  Scanner leer = new Scanner(System.in);
     
		public static void multiplicar(int tabla, int Nv){
	        if(Nv>1){
	            multiplicar(tabla, Nv-1);
	        }
	        System.out.println(tabla + " x " + Nv + " = " + (tabla * Nv) );
	    }
		
		
	    
	    public static void main(String[] args) {
	    	
	        int t=0;
	        int D=0;
	        
	        do {
	        	System.out.println("----Multiplicación----"+"\n");
	        	
	             System.out.print("Digite la tabla de multiplicar: ");
	             t = leer.nextInt();
	             System.out.println("\n"+"Tabla del " + t+"\n");
	             multiplicar(t, 10);
	        
	        
	    		System.out.print("\n"+"Seguir? (1=si, 0=no):");
	    		D=leer.nextInt();
	    		}while(D==1);
	    		
	    		if(D==0) {
	    			System.out.println("Fin del programa");
	    		}
	    }
	    
	

	

}
