package PRUEBAS;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class PROYECTOFINAL{

    static DecimalFormat df = new DecimalFormat("#0.00000");
    static DecimalFormat df2 = new DecimalFormat("#0.00");
	static Scanner leer = new Scanner(System.in);	
	static Random random = new Random();

    static ArrayList<String> impresion = new ArrayList<String>();	   
	static ArrayList<Integer> TLL2 = new ArrayList<Integer>();
	static ArrayList<Integer> TerS2 = new ArrayList<Integer>();
	    
	static double TotalSalNor[]= new double[7];
	static double TotalSalExtra[]= new double[7];
	static double TotalOpeA[]= new double[7];
	static double TotalOcioC[]= new double[7];
	static double CostoTotal[]= new double[7];

	
	   static double []tiempoextra=new double[7];
	   static double []tiempoOA=new double[7];
	   static double []tiempoEC=new double[7];
	   
	   
	public static void main(String[] args) {
		
		
		int LC=0, desc;
		System.out.println("\n\t\t\t\t=====Sistema de colas======\n");
		System.out.print("Digite el número de turnos a simular:");
		int N=leer.nextInt();
		
		
	//Se usan 3 ciclos for para todo el programa, uno para el número de turnos, otro para el tipo de equipo y al ultimo los movimientos 	
	for(int turnos=0;turnos<N ; turnos++) {	
		
	    for(int equipos=3;equipos<=6 ; equipos++) {
	    	    	
		System.out.println("\n\nSimulación de las operaciones de descarga durante el turno: "+(turnos+1)+" y con un equipo de: "+equipos);
		System.out.println("\nAlea1\tTell\tTll\tIS\tAle2\tTS\tTerS\tOP\tTeC\tLC");
		
		 desc=0;
		 int totalTEC=0, contador=0;
		 double alea1=0, alea2=0;
		 int CE=0, TeLL=0, TLL=660, TS=0,IS=0, TerS=0, OP=0, TEC=0;
		 boolean repetir=true, descanso=false;	 

		 TLL2.clear();
		 TerS2.clear();
	
		 
		 for(int i=0;repetir ; i++) {
			 			 		
		    //Se genera el numero aleatorio 1
           	alea1=random.nextDouble();		
            
        	
        	//Camion en espera.	 
			 if(i==0) {		
			if(alea1>=0.00 && alea1<0.50) CE=0;
			if(alea1>=0.50 && alea1<0.75) CE=1;
			if(alea1>=0.75 && alea1<0.90) CE=2;
			if(alea1>=0.90 && alea1<1.00) CE=3;			
			LC=CE;
			 }
            
           
    		
    		//Tiempo entre llegada.
    		if(alea1> 0.00 && alea1<0.02) TeLL=20;
    		if(alea1>=0.02 && alea1<0.10) TeLL=25;
    		if(alea1>=0.10 && alea1<0.22) TeLL=30;		
    		if(alea1>=0.22 && alea1<0.47) TeLL=35;
    		if(alea1>=0.47 && alea1<0.67) TeLL=40;
    		if(alea1>=0.67 && alea1<0.82) TeLL=45;
    		if(alea1>=0.82 && alea1<0.92) TeLL=50;
    		if(alea1>=0.92 && alea1<0.97) TeLL=55;
    		if(alea1>=0.97 && alea1<=1.00) TeLL=60;
            
    		
		    //Tiempo de llegada validando si hay camiones esperando antes de abrir.   			
    		   if(CE!=0) {		    	
				    	TLL=660;    				    	
				    	TLL2.add(i,TLL);	    	
				    }else {
				    	TLL=TLL+TeLL;					    	
				    	TLL2.add(i,TLL);
				    }		
    		
    		   
    		 //No aceptar camiones si es mayor a las 7:30 se acaba ciclo.
		     if(TLL>=1170) {
		    	 repetir=false;
	        	   break;        	   
	        	}	
		     
		     
		     //Se convierte el tiempo de llegada al formato de horas y minutos.
		    String sTLL=Integer.toString(TLL);
		    SimpleDateFormat sdf = new SimpleDateFormat("mm");
			try {
			    Date dt = sdf.parse(sTLL);
			    sdf = new SimpleDateFormat("hh:mm");
			    sTLL=sdf.format(dt);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
			
	
		    //Corazon del programa donde se valida el inicio del servicio, el ocio del personal y el tiempo de espera del camion
			//Validando si se ha tomado el descanso o no.
			if(TerS>=900 && descanso==false){
							
				if(TLL>=TerS+30) {				
			        IS=TLL;	//inicio de servicio	    	
					OP=TLL-(TerS+30); //Ocio personal
					TEC=0; //Tiempo de espera
			        
				}else {				
					IS=TerS+30;//inicio de servicio
					OP=0; //Ocio personal
					TEC=IS-TLL; //Tiempo de espera				
				}		
				
				descanso=true; //descanso hecho	
				desc=i;
								
			}else if(TerS<=TLL) {										 
      			 IS=TLL;//inicio de servicio			 
				 if(i>0) OP=IS-TerS; //Ocio personal				 
				 TEC=0; //Tiempo de espera			 
			}else {					 			 			 
				 IS=TerS;	//inicio de servicio					 
				 OP=0; //Ocio personal				 
				 TEC=IS-TLL; //Tiempo de espera
			 }
			
			
		  
		   			
			//Modificaciones en el inicio del servicio y el tiempo de espera de camiones 
			//si hay camiones en espera al inciar el dia.
			   if(CE!=0) {		    	
				    if(i>0) {
				    	IS=TerS;
				    	TEC=TerS-660;	    	
				      }else {
				    	IS=660;
				    	TEC=0;    	
				      }					    
				    }
						
			
			//Se convierte el inicio de servicio al formato de horas y minutos. 
		    String sIS=Integer.toString(IS);	    
		    SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
			try {
			    Date dt = sdf2.parse(sIS);
			    sdf2 = new SimpleDateFormat("hh:mm");
			    sIS=sdf2.format(dt);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
		    
		    
		    
            //Se genera el numero aleatorio 2
	     	alea2=random.nextDouble();
		
		
	     	
	     	//Tiempos de servicios depenciendo de la cantidad de personas en el equipo.	     	
	     	if(equipos==3) {	     	
		   //Tiempo de servicio equipo 3 personas
	      	if(alea2>=0.00 && alea2<0.05) TS=20;
		    if(alea2>=0.05 && alea2<0.15) TS=25;
		    if(alea2>=0.15 && alea2<0.35) TS=30;		
		    if(alea2>=0.35 && alea2<0.60) TS=35;
		    if(alea2>=0.60 && alea2<0.72) TS=40;
	     	if(alea2>=0.72 && alea2<0.82) TS=45;
	     	if(alea2>=0.82 && alea2<0.90) TS=50;
	    	if(alea2>=0.90 && alea2<0.96) TS=55;
	    	if(alea2>=0.96 && alea2<=1.00) TS=60;
	     	}
	     		
	     	if(equipos==4) {
	    	//Tiempo de servicio equipo 4 personas
	    	if(alea2>=0.00 && alea2<0.05) TS=15;
	    	if(alea2>=0.05 && alea2<0.20) TS=20;
	    	if(alea2>=0.20 && alea2<0.40) TS=25;		
	    	if(alea2>=0.40 && alea2<0.60) TS=30;
	    	if(alea2>=0.60 && alea2<0.75) TS=35;
	    	if(alea2>=0.75 && alea2<0.87) TS=40;
	    	if(alea2>=0.87 && alea2<0.95) TS=45;
	    	if(alea2>=0.95 && alea2<0.99) TS=50;
	    	if(alea2>=0.99 && alea2<=1.00) TS=55;
	     	}    	
	    	
	     	if(equipos==5) {
	    	//Tiempo de servicio equipo 5 personas
	    	if(alea2>=0.00 && alea2<0.10) TS=10;
	    	if(alea2>=0.10 && alea2<0.28) TS=15;
	    	if(alea2>=0.28 && alea2<0.50) TS=20;		
	    	if(alea2>=0.50 && alea2<0.68) TS=25;
	    	if(alea2>=0.68 && alea2<0.78) TS=30;
	    	if(alea2>=0.78 && alea2<0.86) TS=35;
	    	if(alea2>=0.86 && alea2<0.92) TS=40;
	    	if(alea2>=0.92 && alea2<0.97) TS=45;
	    	if(alea2>=0.97 && alea2<=1.00) TS=50;
	     	}
	    	
	     	if(equipos==6) {
	    	//Tiempo de servicio equipo 6 personas
	    	if(alea2>=0.00 && alea2<0.12) TS=5;
	    	if(alea2>=0.12 && alea2<0.27) TS=10;
	    	if(alea2>=0.27 && alea2<0.53) TS=15;		
	    	if(alea2>=0.53 && alea2<0.68) TS=20;
	    	if(alea2>=0.68 && alea2<0.80) TS=25;
	    	if(alea2>=0.80 && alea2<0.88) TS=30;
	    	if(alea2>=0.88 && alea2<0.94) TS=35;
	    	if(alea2>=0.94 && alea2<0.98) TS=40;
	    	if(alea2>=0.98 && alea2<=1.00) TS=45;
	    	
	     	}
	         	
	     	
	    
	    	
 
	    //Se calcula cuando termina servicio y se convierte al formato de horas y minutos.  	
	    TerS=IS+TS;	 
	    TerS2.add(i,TerS);		
	    String sTerS=Integer.toString(TerS);	
	    SimpleDateFormat sdf3 = new SimpleDateFormat("mm");
	 			try {
	 			    Date dt = sdf3.parse(sTerS);
	 			    sdf3 = new SimpleDateFormat("hh:mm");
	 			   sTerS=sdf3.format(dt);
	 			} catch (ParseException e) {
	 			    e.printStackTrace();
	 			}
	 			
	 			
	 			
	 
	 			
	 	//Guarda el tipo de impresion que se despliega para lugar calcular la longitud de cola		
	 	if(CE==0) {
	 		impresion.add(i,df.format(alea1)+"\t"+TeLL+"\t"+sTLL+"\t"+sIS+"\t"+df.format(alea2)+"\t"+TS+"\t"+sTerS+"\t"+OP+"\t"+TEC+"\t");
	 	}
	 	if(CE!=0){	 		
	 		OP=0; CE--;
	 		impresion.add(i,"\t\t"+sTLL+"\t"+sIS+"\t"+df.format(alea2)+"\t"+TS+"\t"+sTerS+"\t"+OP+"\t"+TEC+"\t"); 		
	 	}
	 	
	 
		//Se calcula el total de la espera del camion de cada equipo para sacar los costos totales
	 	totalTEC=totalTEC+TEC; 			 	
	 	contador++;
		}
		 
		 
		 //Se calcula la longitud de cola 
		 int [] Lc = new int [contador];	 
		 int z, z2=0;	 
		 for(int w=0;w<contador;w++) {		 	
			 for(z=z2;z<contador;z++) {
				 			 
				 if(TerS2.get(w)>TLL2.get(z)) {
					 Lc[z]++;
				 }		 
			 }
			 z2++;
			 
			 
		//Se imprimen los datos dependiendo de cada caso como: si hay camiones en espera al inciar el dia, toca descanso o todo normal.
			 if(w==desc) {
				 System.out.println(impresion.get(w)+(Lc[w]));			 
			 }else if (w<LC) { 			 
				 System.out.println(impresion.get(w)+(LC));
				 LC--;			 			
			 }else {		 
			     System.out.println(impresion.get(w)+(Lc[w]-1));
			 }			 
		 }

		 
		 
		 
		 //Se calcula el tiempo de operacion del almacen y el ocio de los camiones
		 tiempoOA[equipos]=((TerS)-(660.0)-(30))/60.0;
		 tiempoEC[equipos]=(totalTEC)/60.0;
		 	 
		 //Se calcula el tiempo extra que trabaja cada equipo
		 tiempoextra[equipos]=TerS-1170;	 
		 if(tiempoextra[equipos]<0) tiempoextra[equipos]=0;						 
		 tiempoextra[equipos]=tiempoextra[equipos]/60;
				 
		
		 
	}
	    

		
	    //Se realizan los calculos de la la tabla final
	    for(int equipos=3;equipos<=6 ; equipos++) {
	    	
	    	 double SalNor=equipos*(8)*(25);
			 double SalExtra=37.50*(equipos)*(tiempoextra[equipos]);		    
			 double Salarios=SalNor+SalExtra;    	
			 double OpeA=500*(tiempoOA[equipos]);
			 double OcioC=100*(tiempoEC[equipos]);
			 double Espera=OpeA+OcioC;			    
			 double costo=Salarios+Espera;
			 
			 
			 TotalSalNor[equipos]=TotalSalNor[equipos]+SalNor;
			 TotalSalExtra[equipos]=TotalSalExtra[equipos]+SalExtra;		 
			 TotalOpeA[equipos]=TotalOpeA[equipos]+OpeA;
			 TotalOcioC[equipos]=TotalOcioC[equipos]+OcioC;		 
			 CostoTotal[equipos]=CostoTotal[equipos]+costo;   
	    
	     }
	     
	}
	
	
	        //Se imprime la tabla final con los costos totales de cada tipo de equipo.  
            System.out.println("\n\nSimulación del sistema de colas durante "+(N)+" turnos y considerando diferentes tamaños de equipo.\n\n");		    
            System.out.println("TamE\tSalNor\tSalExt\tOcioC\tOpeA\tCostos totales");        
            for(int equipos=3;equipos<=6 ; equipos++) {   
            System.out.println(equipos+"\t"+(TotalSalNor[equipos]/N)+"\t"+df2.format(TotalSalExtra[equipos]/N)+"\t"+df2.format(TotalOcioC[equipos]/N)+"\t"+df2.format(TotalOpeA[equipos]/N)+"\t"+df2.format( CostoTotal[equipos]/N));	           
            }

	    
	}	
}

