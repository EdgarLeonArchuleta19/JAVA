package PRUEBAS;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GeneradoDeClase {

	
	
	static Scanner leer = new Scanner(System.in);
	public static int semilla=0;
	static Random random = new Random();
	static long Comparador[] = new long[100000000];
	static ArrayList<Integer> sem = new ArrayList<Integer>();
	public static void main(String[] args) {
   
		  
		    
		    System.out.println("¿Cómo quieres generar tus números Pseudoaleatorios?"+"\n");
	        System.out.println("1.Por teclado");
	        System.out.println("2.Random");
	        System.out.print("\n"+"Elige una opción:");
	        
	        
	        
	        int n=leer.nextInt();
	        
	        if(n==1) {
	        	System.out.print("Digite la semilla:");
	        	semilla=leer.nextInt();
	        }
	        
           if(n==2) {       	   
        	   semilla= random.nextInt(999 - 100) + 100;
	        	
	        }
   
		
		
		System.out.println("|N|semilla|Semilla cuadrada|Núm i|Sgn|");
		
		
		boolean repetir=true;
		int SemillaC=0, NumI=0,SigN=0;
		String Snum2="",Sni="", Sn="";
		double media=0;
		int sumaS = 0, i=0;
		
		   for(i=0; repetir; i++) {
                     
			      
			   
			   
	        	     SemillaC = (int) Math.pow(semilla,2);	        	  
	        	     Snum2 = String.valueOf(SemillaC);	        	     	        	     
	        	     Sni = Snum2.substring(1,Snum2.length()-1);	 	        	     
	        	    
	        	     Sn = Sni.substring(0,3);
	        	     	        	     
	        	     NumI = Integer.parseInt(Sni);	        	     
			         SigN = Integer.parseInt(Sn);
			       
 	     
	        	
	        	   System.out.println("|"+i+"|"+semilla+"\t  |"+SemillaC+"\t   |"+Sni+"|"+Sn+"|");

	        	 			
	        	 			
	        	   
			         sumaS=(sumaS+semilla);
			         
			         sem.add(i, semilla);
			         semilla=SigN;
			         
			
			         if(semilla==0) {
			        	 repetir = false;
			        	 System.out.println("Semilla igual a cero");
			         }
			         
			         if(semilla<100 && semilla!=0) {
			        	 repetir = false;
			        	 System.out.println("menor a 2 digitos");
			         }
			         
			         
			    
			         for(int j=0;j<=9999999;j++) {
	        	    	   if(semilla==Comparador[j] && semilla!=0) {
	        	    		   System.out.println("semilla repetida en la posicion "+j);
	        	    		  
	        	    		   repetir = false;
	        	    		   break;
	 	        	    	  } 
	 					 }
			         
			         Comparador[i]=semilla;
			         
	
			
			         
			         
			         
			
			
		}
	
		    media=sumaS/i;
	        
		      System.out.println("La media es: "+media);
		      
		    double rango=0,varianza = 0,Tvarianza=0, desviacion=0;
		      for(int j=0;j<i;j++){
		    		rango = Math.pow( sem.get(j)- media, 2);
		    	    varianza = varianza + rango;
		    	    Tvarianza = varianza / i;
		    	    desviacion = Math.sqrt(Tvarianza);
		    	   }

		       System.out.println("La deviación estandar es: "+desviacion);
		
	}
}
	
	
	
	
	


