package PRUEBAS;

import java.text.DecimalFormat;

import java.util.Random;
import java.util.Scanner;

public class Tinas {
	
	
	   static DecimalFormat df = new DecimalFormat("#0.00000");
		static Scanner leer = new Scanner(System.in);	
		static Random random = new Random();

	public static void main(String[] args) {
		
		int repeat=0;
		do {
		double peso=0, pesoA=0, Tacumulado = 0;
		String EC = "";
		
		System.out.println("Simulador programa de tinas");
		System.out.print("Ingrese el número de años a simular:");
		int n=leer.nextInt();
		
		
		System.out.println("Años\tdias\tTina\tale\t\tPesoSim\t\tPesoSimA\tExcede capacidad?\tAcumula $200");
		
		  for(int años=1;años<=n;años++){
			  
			  System.out.println(años);
			  
			  
			  for(int dias=1;dias<=260;dias++){
				  
				  System.out.println("\t"+dias);
				  pesoA=0;
				  
				  for(int tinas=1;tinas<=5;tinas++){
					  	  
					  
					  double ale = random.nextDouble();
					  
					  if(ale==0.5) peso=210;
					  if(ale<0.5) peso=190+(Math.sqrt(800*ale));  	  
					  if(ale>0.5) peso=230-(Math.sqrt(800*(1-ale)));    
					
					  
					  pesoA=pesoA+peso;
					  
					  
					  if(pesoA>1000) {
						  EC="si";
						  Tacumulado=Tacumulado+200;
					  }else {
						  EC="no";
					  }
					  
					  System.out.println("\t\t"+tinas+"\t"+df.format(ale)+"\t\t"+df.format(peso)+"\t"+df.format(pesoA)+"\t\t"+EC+"\t\t"+Tacumulado);
					  
				  }
				  
				  
				  
				  
				  
				  
				  
			  }
			  
			  if(Tacumulado>50000) {
				  
				  System.out.println("\nEs mejor comprar");
				  
			  }else {
				  System.out.println("\nEs mejor rentar");
			  }
			  
			 
			  			  
		  }
		  
		     System.out.println("\n"+"¿Deseas seguir?");
		     System.out.print("Sí(1)  -  No(2): ");
		     repeat =leer.nextInt();
		   
		   }while(repeat!=2);

		      if(repeat==2)System.out.println("Fin del programa");

	}

}
