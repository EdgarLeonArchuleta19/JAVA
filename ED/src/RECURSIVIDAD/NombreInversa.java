package RECURSIVIDAD;

import java.util.Scanner;

public class NombreInversa {

	 static  Scanner leer = new Scanner(System.in);
	 
	 
	    private static String invertirNombre(String nombre){
	        if(nombre.length()==1){
	            return nombre;
	        } else {
	            return invertirNombre(nombre.substring(1)) + nombre.charAt(0);
	        }
	   
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	int D=0;
	    	String nombre;
	    	
	  do {
	         System.out.print("Digite un nombre: ");
	         nombre = leer.nextLine();
	      
	         String invertida = invertirNombre(nombre);
	         System.out.printf("Nombre invertido: "+"%s", invertida);
	    	
	     	System.out.print("\n"+"Seguir? (1=si, 0=no):");
    		D=leer.nextInt();
    		nombre=null;
	  }while(D==1);
		
		if(D==0) {
			System.out.println("Fin del programa");
		}
	    	
	    }
	     


}
