package PRUEBAS;
import java.util.Random;
import java.util.Scanner;

public class GENERADOR2 {
		
	static Scanner leer = new Scanner(System.in);
	 static Random random = new Random();
	 
	
	//Main menu principal 
	    public static void main(String[] args) {
	    	 int siono = 0;
	    	
	    	do {
            int opcion=0;
            
	        System.out.println("\n"+"==Escoge el metodo para generar números Pseudoaleatorios=="+"\n");
	        System.out.println("1.Metodo de medio cuadrados");
	        System.out.println("2.Metodo de Newman");
	        
	        do {
	        	
		        System.out.print("\n"+"Elige una opción:");
		        opcion=leer.nextInt();
		        
		        }while(opcion==0 || opcion>=3);
	         
	            if(opcion==1)  mediosCuadrados();
	            if(opcion==2)  Newman();
            
		    	
		        System.out.println("\n"+"¿Deseas seguir generando numero Pseudoaletarios?");
		        System.out.print("Sí(1)  -  No(2): ");
		        siono=leer.nextInt();
	    		}while(siono==1);
	    		
	    		if(siono==2) {
	    			System.out.println("Fin del programa.");
	    		}	  
	    }
            
            
	    
	    
	     
	    
	    //Metodo de medios cuadrados
		private static void mediosCuadrados() {
			
	     	String Snum2, N, semilla;
        	int LongitudSemilla, LongitudCuadrado, p, e;
        	long num1, num2, num3 = 0;
        	int i = 1, j=0;
        	boolean aceptado = true;
        	long Comparador[] = new long[10000000];
        	
	        
	        System.out.println("\n"+"¿Cómo quieres generar la semilla?"+"\n");
	        System.out.println("1.Por teclado");
	        System.out.println("2.Random");
	        
	        do {
	        	
	        System.out.print("\n"+"Elige una opción:");
	        e=leer.nextInt();
	        
	        }while(e==0 || e>=3);
	        
	        
	        
	        //Semilla por teclado medios cuadrados
	        if(e==1) {
	            
	        	do {
	        	System.out.print("Escriba semilla(4 digitos): ");
	        	semilla = leer.next();
	        	}while(semilla.length()<=3 || semilla.length()>=5);
	        	
	        
	            LongitudSemilla = 4;
	        	num3 = Integer.parseInt(semilla);
	        	num1 = Integer.parseInt(semilla);
	        	if(num3<=1000)num3=num3+1000;
	        	
	        	
	        	do{
	        		  
	        	      num2 = (long)Math.pow(num1,2);
	        	      Snum2 = Long.toString(num2);
	        	      LongitudCuadrado = Snum2.length();
	        	      p = (LongitudCuadrado-LongitudSemilla) / 2;
	        	      N = Snum2.substring(p,p+LongitudSemilla);
	        	      
	        	      System.out.println("X"+i+": "+ N);
	        	      num1 = Integer.parseInt(N);
	        	      
	        	      if(num1!=0) {
	        	
	        	      for(j=1;j<=9999999;j++) {
	        	    	   if(num1==Comparador[j]) {
	 	        	    		 aceptado=false;
	 	        	    		System.out.println("Número duplicado en la posición "+j+" y "+i);
	 	        	    	  } 
	 					 }  
	        	      }
	        	      
	        	      Comparador[i]=num1;
                      i++;
                      
                      if(num1==0)System.out.println("El generador llego a cero.");
                      if(num1==num3)System.out.println("Número igual a la semilla");
                      
	        	}while(num1!=0 && aceptado==true && num1!=num3);	
	        	
	        	System.out.println("Detenemos generador.");
	        	
		    }  
	        	
	        	
	        	
	        
	        
	        
	        //Semilla creada por random medios cuadrados
	        if(e==2) {
	        	
		         int gene = random.nextInt(9999 - 1000) + 1000;
		         String semillaRandom= Integer.toString(gene);
	         
	        	        
	        	System.out.println("La semilla generada es:"+semillaRandom);
	            LongitudSemilla = 4;
	        	num1 = Integer.parseInt(semillaRandom);
	        	
	        	
	        	do{
	        		  
	        	      num2 = (long)Math.pow(num1,2);
	        	      Snum2 = Long.toString(num2);
	        	      LongitudCuadrado = Snum2.length();
	        	      p = (LongitudCuadrado-LongitudSemilla) / 2;
	        	      N = Snum2.substring(p,p+LongitudSemilla);
	        	      
	        	      System.out.println("X"+i+": "+ N);
	        	      num1 = Integer.parseInt(N);
	        	      
	        	      if(num1!=0) {
	        	
	        	      for(j=1;j<=9999999;j++) {
	        	    	   if(num1==Comparador[j]) {
	 	        	    		 aceptado=false;
	 	        	    		System.out.println("Número duplicado en la posición "+j+" y "+i);
	 	        	    	  } 
	 					 }  
	        	      }
	        	      
	        	      Comparador[i]=num1;
                    i++;
                    
                    if(num1==0)System.out.println("El generador llego a cero.");
                    if(num1==num3)System.out.println("Número igual a la semilla");
                    
	        	}while(num1!=0 && aceptado==true && num1!=num3);	
	        	
	        	System.out.println("Detenemos generador.");
		         
		    
		    }  
	    }
		
		
		
		
		
		
		   //Metodo de newman
		private static void Newman() {
			
			String Snum2, N, semilla;
        	int LongitudSemilla, LongitudCuadrado, p, e;
        	long num1, num2;
        	int i = 1, j=0;
	        boolean aceptado = true;
	        long Comparador[] = new long[100000000];
	      
	        System.out.println("\n"+"¿Cómo quieres generar la semilla?"+"\n");
	        System.out.println("1.Por teclado");
	        System.out.println("2.Random");
	        
	        do {
	        	
	        System.out.print("\n"+"Elige una opción:");
	        e=leer.nextInt();
	        
	        }while(e==0 || e>=3);
	        
	        
	        
	        
	        
	        //Semilla por teclado newman
	        if(e==1) {
	        
	        	
	        	do {
	            System.out.print("Escriba semilla(10 digitos): ");
	        	semilla = leer.next();
	            }while(semilla.length()<=9 || semilla.length()>=11);
	        	
	        	
	        	LongitudSemilla = 5;
	            num1 = Long.parseLong(semilla);
	        	if(num1<=1000000000)num1=num1+1000000000;
	        	
	        	do{
	        		  
	        	      num2 = (long)Math.pow(num1,2);
	        	      Snum2 = Long.toString(num2);
	        	      LongitudCuadrado = Snum2.length();
	        	      p = (LongitudCuadrado-LongitudSemilla) / 2;
	        	      N = Snum2.substring(p,p+LongitudSemilla);
	        	      
	        	      System.out.println("X"+i+": "+ N);
	        	      num1 = Integer.parseInt(N);
	        	      
	        	      if(num1!=0) {
	        	
	        	      for(j=1;j<=9999999;j++) {
	        	    	   if(num1==Comparador[j]) {
	 	        	    		 aceptado=false;
	 	        	    		System.out.println("Número duplicado en la posición "+j+" y "+i);
	 	        	    	  } 
	 					 }  
	        	      }
	        	      
	        	      Comparador[i]=num1;
                    i++;
                    
                    if(num1==0)System.out.println("El generador llego a cero.");
                   
                    
	        	}while(num1!=0 && aceptado==true);	
	        	
	        	System.out.println("Detenemos generador.");
		         
	        
	        
	    }
	        
	        
	        
	        
	        //Semilla creada por random newman
	        if(e==2) {
	        	
		         int gen1 = random.nextInt(99999 - 10000) + 10000;
		         int gen2 = random.nextInt(99999 - 10000) + 10000;
		        
		         String sgen1 = Integer.toString(gen1);
		         String sgen2 = Integer.toString(gen2);
                 String semillaRandom = sgen1 + sgen2;
		            
	        	System.out.println("La semilla generada es:"+semillaRandom);
	        
	        	LongitudSemilla = 5;
	        	num1 = Long.parseLong(semillaRandom);
	        	
	        	
	        	do{
	        		  
	        	      num2 = (long)Math.pow(num1,2);
	        	      Snum2 = Long.toString(num2);
	        	      LongitudCuadrado = Snum2.length();
	        	      p = (LongitudCuadrado-LongitudSemilla) / 2;
	        	      N = Snum2.substring(p,p+LongitudSemilla);
	        	      
	        	      System.out.println("X"+i+": "+ N);
	        	      num1 = Integer.parseInt(N);
	        	      
	        	      if(num1!=0) {
	        	
	        	      for(j=1;j<=9999999;j++) {
	        	    	   if(num1==Comparador[j]) {
	 	        	    		 aceptado=false;
	 	        	    		System.out.println("Número duplicado en la posición "+j+" y "+i);
	 	        	    	  } 
	 					 }  
	        	      }
	        	      
	        	      Comparador[i]=num1;
                      i++;
                    
                    if(num1==0)System.out.println("El generador llego a cero.");
                    
	        	}while(num1!=0 && aceptado==true);	
	        	
	        	System.out.println("Detenemos generador.");
			         
		         
		    }   
	    }
	    }
		

	