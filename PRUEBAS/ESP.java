package PRUEBAS;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ESP {

	static Scanner leer = new Scanner(System.in);
	static Random random = new Random();
	
	static DecimalFormat df = new DecimalFormat("#0.000000");
	
	
	public static void main(String[] args) {
		
		       
        double pm=0;
        
        
        System.out.print("Digite la cantidad que deseas ganar: ");
        int meta=leer.nextInt();
        
        System.out.println("\n");
    
           
             	
        	            
            for(int i=1;i<=200;i++){
            	
            	

                System.out.println("\n|#corrida|$antes|apuesta|Núm Ale |¿Gano?|$despues|¿Meta?");
            	
            	               
                String gano="";   		  
        		 boolean repetir=true;
           	    String Smeta="";
                int antes=30, despues=0;
                int apuesta=10;
                
             
             System.out.print("|"+i);
             
             for(int j=0;repetir ; j++) {
        	
        		
        	double volado = random.nextDouble();
     		     	
        	
        	
    		 if(volado>=0 && volado< 0.50) {
    			
    			 gano="si";
    			 despues=antes+apuesta;
    			
    		 }
    		
    		
            if(volado> 0.50 && volado<= 1) {
            	
            	gano="no";
            	despues=antes-apuesta;
            	
    		 }
            

            if(despues>=meta) {
            	pm++;
        		Smeta="si";
        		repetir=false;
        		
                    	}
            
           if(despues<=0) {
        	   Smeta="no";
        	   repetir=false;
        	   despues=0;
        	}
            
         
           
           
           
           
            System.out.println("\t |"+antes+"\t|"+apuesta+"\t|"+df.format(volado)+"|"+gano+"\t|"+despues+"\t |"+Smeta);
        	
           

           if(volado>=0 && volado< 0.50) {
        	   apuesta=10;        	   
           }
           if(volado> 0.50 && volado<= 1) {
        	   apuesta=apuesta*2;        	   
           }
           
           antes=despues;
        	
        	}
             
           
        	              
            }
        
		double p=(pm/200)*100;
		
		System.out.println("\nLa probabilidad de llegar a la meta es:"+p+"%");
		

	}
	
	
	
	
	

}
