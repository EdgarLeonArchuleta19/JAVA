package PRUEBAS;
import java.text.DecimalFormat;
import java.util.*;

public class LICENCIAS{
    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

   public static void main (String [ ] args) {
	int repeat=0;
	
     do{      
     licencia();
     System.out.println("\n"+"¿Deseas seguir?");
     System.out.print("Sí(1)  -  No(2): ");
     repeat =in.nextInt();
   }while(repeat!=2);
      if(repeat==2)System.out.println("Fin del programa");

} 

public static void licencia(){

int licenciasV=0, licenciasD=0 ,costo=0,ingxVta=0,ingxdev=0,TdU=0;
double licencias=0, media=0,varianza=0,desviacion=0,rango=0, Tvarianza=0;
DecimalFormat df = new DecimalFormat("#0.000000");

System.out.print("Ingrese el número de consultas:");
int tries=in.nextInt();
int[] utilidad =new int[tries];
System.out.print("Ingresa la cantidad de consultas a comprar(100/150/200/250/300): ");
int compras=in.nextInt();



System.out.println("|N|#aleagen|Licencias Ve|licencias Devue|Costo|ingxVta|ingxdev|utilidad|");



for(int i=0;i<tries;i++){
			
	
	
	licencias =random.nextDouble()*1;
if(compras==100) {
	
	if(licencias>=0 && licencias< 0.30) {
		licenciasD=0;
	}else {
		licenciasD=0;
	}
}

if(compras==150) {
	
	if(licencias>=0 && licencias< 0.30) {
		licenciasD=50;
	}else {
    licenciasD=0;
	}
}

if(compras==200) {
		if(licencias>=0 && licencias< 0.30) {
			licenciasD=100;
		}
		else if(licencias>0.30 && licencias< 0.50) {
			licenciasD=50;
		}else {
			licenciasD=0;
		}
	    	
}

if(compras==250) {
    if(licencias>=0 && licencias< 0.30) {
    	licenciasD=150;
    }
    else if(licencias>0.30 && licencias< 0.50) {
		licenciasD=100;
	}
	else if(licencias>0.50 && licencias< 0.80) {
		licenciasD=50;
	}else {
	licenciasD=0;
	}
}

if(compras==300) {
	if(licencias>=0 && licencias< 0.30) {
		licenciasD=200;
	}
	else if(licencias>0.30 && licencias< 0.50) {
		licenciasD=150;
	}
	else if(licencias>0.50 && licencias< 0.80) {
		licenciasD=100;
	}
	else if(licencias>0.80 && licencias< 0.95) {
		licenciasD=50;
	}else{
		licenciasD=0;
	}
} 


	//datos de la tabla
    costo=compras*75;
    ingxVta=(compras-licenciasD)*100;
    ingxdev=licenciasD*25;
    utilidad[i]=(ingxVta+ingxdev)-costo;
    licenciasV=compras-licenciasD;
  
    //calcular media 
    TdU=TdU+utilidad[i];
    media=TdU/tries;
    System.out.println("|"+(i+1)+"|"+df.format(licencias)+"|\t"+licenciasV+"\t|\t"+licenciasD+"\t| "+costo+"|  "+ingxVta+"|   "+ingxdev+"   |\t"+utilidad[i]+"|");

}
     //calcular desviacion en otro for porque no quisimos hacer muchos vectores
    for(int j=0;j<tries;j++){
	rango = Math.pow(utilidad[j] - media, 2);
    varianza = varianza + rango;
    Tvarianza = varianza / tries;
    desviacion = Math.sqrt(Tvarianza);
   }


System.out.println("\n\nLa media es: "+media);
System.out.println("La desviacion es: "+desviacion);


    }

}
