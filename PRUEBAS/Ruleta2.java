package PRUEBAS;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;


public class Ruleta2 {
	
	static DecimalFormat df = new DecimalFormat("#0.00000");	
	 static Random random = new Random();
	 static Scanner leer = new Scanner(System.in);	
	 public static double alea=0;

	
	static int dinerot,ganancia=1000,apuesta;
	static String color, gana,metta;
	static boolean meta,anulado;
	 
	
	public static void main(String[] args) {
		
		int repeat=0;	 
			
		     do{  
		    	 
		    	dinerot=0;ganancia=1000;apuesta=0;
		    	color=""; gana="";metta="";
		    	meta=false;anulado=false; 
		    			    	
		     System.out.println("\nSimulador de ruleta de apuestas");	
		     juego();
		   
		     System.out.println("\n"+"¿Deseas seguir?");
		     System.out.print("Sí(1)  -  No(2): ");
		     repeat =leer.nextInt();
		   
		   }while(repeat!=2);

		      if(repeat==2)System.out.println("Fin del programa");
		
		
	}
	
	public static void ale() {		
		alea= random.nextDouble();
	}
	
	
	public static void juego() {
		
		
		//Jugador 1
		int iteracion=1;
		int dineroi=200;
		String exito="-";
		apuesta=1;
		meta=false;
		System.out.println("JUGADOR 1");
		System.out.println("Iteracion\t$Antes\tApuesta\t#Aleatorio\tColor\tGano\t$Despues\tMeta\tExito");
		
		
		
		do {
			ale();
			
			if(alea>0 && alea<0.4545) {
				color="rojo";
			}
			if(alea>0.4545 && alea<0.9090) {
				color="negro";
			}
			if(alea>0.9090 && alea<1) {
				color="verde";
			}
			
			
			
			if(color=="rojo") {
				if(anulado==true) {
					gana="si";
					dinerot=dineroi;
					anulado=false;
				}else {
				gana="si";
				dinerot=dineroi+apuesta;
				
				}
			}
			
			if(color=="negro") {
				gana="no";
				dinerot=dineroi-apuesta;
				
			}
			
			if(color=="verde") {
				gana="nulo";
				dinerot=dineroi;
				anulado=true;
			}
			
			
			
			if(dinerot<=0 || dinerot<apuesta) {
				meta=true;
			}
			
			
			if(dinerot>=ganancia) {
				meta=true;
				metta="si";	
				exito="++";
			}else {
				metta="no";
			}
			
			System.out.println(iteracion+"\t\t"+dineroi+"\t"+apuesta+"\t"+df.format(alea)+"\t\t"+color+"\t"+gana+"\t"+dinerot+"\t\t"+metta+"\t"+exito);
			dineroi=dinerot;
			iteracion++;
			
			
		}while(meta==false);
		
		
		
		
		//Jugador 2
		System.out.println("------------------------------------------------------------------------------------------------------------");
	
		iteracion=1;
		dineroi=200;
		exito="-";
		apuesta=1;
		meta=false;
		System.out.println("JUGADOR 2");
		System.out.println("Iteracion\t$Antes\tApuesta\t#Aleatorio\tColor\tGano\t$Despues\tMeta\tExito");
		
		
		do{
			ale();
			
			
			if(alea>0 && alea<0.4545) {
				color="rojo";
			}
			if(alea>0.4545 && alea<0.9090) {
				color="negro";
			}
			if(alea>0.9090 && alea<1) {
				color="verde";
			}
			
			
			if(dineroi<apuesta) {
				apuesta=dineroi;
			}
			
			
			
			if(color=="rojo") {
				if(anulado==true) {
					gana="si";
					dinerot=dineroi;
					anulado=false;
				}else {
				gana="si";
				dinerot=dineroi+apuesta;
				}
			}
			if(color=="negro") {
				gana="no";
				dinerot=dineroi-apuesta;
			}
			
			if(color=="verde") {
				gana="nulo";
				dinerot=dineroi;
				anulado=true;
			}
			
			
			if(dinerot<=0) {
				meta=true;
			}	
			
			
			if(dinerot>=ganancia) {
				meta=true;
				metta="si";	
				exito="++";
			}else {
				metta="no";
			}
			
			
			System.out.println(iteracion+"\t\t"+dineroi+"\t"+apuesta+"\t"+df.format(alea)+"\t\t"+color+"\t"+gana+"\t"+dinerot+"\t\t"+metta+"\t"+exito);
			dineroi=dinerot;
			iteracion++;
			
			if(gana=="no") {
				apuesta=apuesta*2;
			}
			else {
				apuesta=1;
			}
			
		}while(meta==false);
		
		System.out.println("------------------------------------------------------------------------------------------------------------");
	}
	
	
}

