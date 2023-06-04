package PRUEBAS;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class CajeroATM {
	
	

	   static DecimalFormat df = new DecimalFormat("#0.00000");
	   static DecimalFormat df2 = new DecimalFormat("#0.00");
		static Scanner leer = new Scanner(System.in);	
		static Random random = new Random();

	public static void main(String[] args) {
		
		int repeat=0;
		do{
			
		int n=0;
		double Tll=0,Mll=0, Ti=0,Te=0, To=0,TT=0;
		String Operacion="";
		
		System.out.println("\n--Simulador Cajero ATM--");
		System.out.print("Ingrese el número de simulaciones:");
		n=leer.nextInt();
		
			
		
		  for(int i=1;i<=n;i++) {	  
			  System.out.println("\n\nN\tUsuario\t#ale1\tTll\tMll\tTi\tTe\t#ale2\tOperación\tTo\tTT");
			  System.out.println(i);
			  for(int clientes=1;clientes<=100;clientes++){
				  
				  			  
				  double ale1 = random.nextDouble();
				  				  
				  Tll=(-Math.log(1-ale1)/30)*60;
				  Mll=Mll+Tll;
				  		
				  
				 if(TT<Mll) {
					 Ti=Mll;
				 }else {
					 Ti=TT;
				 }
				  			  
				  Te=Ti-Mll;
				  
				  double ale2 = random.nextDouble();
				  
				  if(ale2>=0 && ale2< 0.25) {
					  Operacion="Consult";
					  To=1.33;				  
				  }

				  if(ale2>0.25 && ale2< 0.50) {
					  Operacion="Otros";
					  To=0.83;
				  }
				  if(ale2>0.50 && ale2< 0.85) {
					  Operacion="Retiros";
					  To=2.0;
				  } 
				  if(ale2>0.85 && ale2<= 1) {
					  Operacion="Tranfer";
					  To=1.0;
				  }
				  
				  TT=Ti+To;
				  
				  System.out.println("\t"+clientes+"\t"+df.format(ale1)+"\t"+df2.format(Tll)+"\t"+df2.format(Mll)+"\t"+df2.format(Ti)+"\t"+df2.format(Te)+"\t"+df.format(ale2)+"\t"+Operacion+"\t\t"+df2.format(To)+"\t"+df2.format(TT)+"\t");
				  
				  			  
		     	  }			  
			  }

	     	 
			   
			     System.out.println("\n"+"¿Deseas seguir?");
			     System.out.print("Sí(1)  -  No(2): ");
			     repeat =leer.nextInt();
			   
			   }while(repeat!=2);

			      if(repeat==2)System.out.println("Fin del programa");
		  
		  
		  
		  
	}

}
