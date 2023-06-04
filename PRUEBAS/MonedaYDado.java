package PRUEBAS;

import java.util.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class MonedaYDado {


    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

   public static void main (String [ ] args) {
	
	int option=0, repeat=0;
	
   do{
     do{      
      System.out.println("-Objetos para simular-");
      System.out.println("1 - Dados");
      System.out.println("2 - Monedas");
      System.out.print("Elige una opción: ");
      option=in.nextInt();

        }while(option!=1 && option!=2);

     if(option==1)Dados();
     if(option==2) Moneda();  

     System.out.println("\n"+"¿Deseas seguir?");
     System.out.print("Sí(1)  -  No(2): ");
     repeat =in.nextInt();
   
   }while(repeat!=2);

      if(repeat==2)System.out.println("Fin del programa");

        }

   
   
   
   

public static void Dados(){

int lado1=0,lado2=0,lado3=0,lado4=0,lado5=0,lado6=0;
int N=0,option;

System.out.println("¿Cómo generar los lanzamientos de los dados?");
System.out.println("1 - por teclado");
System.out.println("2 - por random");
System.out.print("Escoge una opción:");
option = in.nextInt();

if(option==1){
System.out.print("Ingresar el número de dados para lanzar:");
int tries=in.nextInt();
N=tries;
}

if(option==2){
int gene = random.nextInt(100 -1)+1;
System.out.println("La cantidad de dardos  a lanzar sera: "+gene);
N=gene;
}



for(int i=1;i<=N;i++){
	double dado =random.nextDouble()*1;
	
	System.out.println("Dado:"+dado);
	
	if(dado>=0 && dado<.1667) {
		System.out.println("El dado ["+i+"] cayo en el lado 1");
		lado1++;
	}
	if(dado>0.1667 && dado<0.3333) {
		System.out.println("El dado ["+i+"] cayo en el lado 1");
		lado2++;
	}
	if(dado>0.3333 && dado<0.5) {
		System.out.println("El dado ["+i+"] cayo en el lado 3");
		lado3++;
	}
	if(dado>0.5 && dado<0.6667) {
		System.out.println("El dado ["+i+"] cayo en el lado 4");
		lado4++;
	}
	if(dado>0.6667 && dado<0.8333) {
		System.out.println("El dado ["+i+"] cayo en el lado 5");
		lado5++;
	}
	if(dado>0.8333 && dado<=1) {
		System.out.println("El dado ["+i+"] cayo en el lado 6");
		lado6++;
	}
	

}

System.out.println("\n=============================");
System.out.println("Total de lanzamientos: "+N);
System.out.println("Total de lados 1: "+lado1);
System.out.println("Total de lados 2: "+lado2);
System.out.println("Total de lados 3: "+lado3);
System.out.println("Total de lados 4: "+lado4);
System.out.println("Total de lados 5: "+lado5);
System.out.println("Total de lados 6: "+lado6);


DefaultPieDataset data = new DefaultPieDataset();
data.setValue("lado1: "+lado1, lado1);
data.setValue("lado2: "+lado2, lado2);
data.setValue("lado3: "+lado3, lado3);
data.setValue("lado4: "+lado4, lado4);
data.setValue("lado5: "+lado5, lado5);
data.setValue("lado6: "+lado6, lado6);


JFreeChart chart = ChartFactory.createPieChart("Representación de dados lanzados", data,true, true, false);

ChartFrame frame = new ChartFrame("Grafica de dados", chart);
frame.pack();
frame.setVisible(true);



    }





public static void Moneda(){

int aguila=0,sello=0;
int N=0, option=0, tries=0;

System.out.println("¿Cómo generar los lanzamientos de las monedas?");
System.out.println("1 - x Teclado");
System.out.println("2 - x Random");
System.out.print("Escoge una opción:");
option = in.nextInt();

if(option==1){
System.out.print("Ingresa monedas a lanzar: ");
tries=in.nextInt();
N=tries;
}

if(option==2){
	int gene = random.nextInt(100 - 1) + 1;
System.out.println("La cantidad de monedas  a lanzar sera: "+gene);
N=gene;
}



for(int i=1;i<=N;i++){

	double moneda =random.nextDouble()*1;
	System.out.println("Moneda:"+moneda);
	if(moneda >=0 && moneda <0.5) {
		System.out.println("la moneda ["+i+"] cayo en aguila");
		aguila++;
	}
	if(moneda >0.5 && moneda <=1) {
		System.out.println("la moneda ["+i+"]cayo en sello");
		sello++;
	}



}

System.out.println("\n=============================");
System.out.println("Total de lanzamientos: "+N);
System.out.println("Total de aguilas: "+aguila);
System.out.println("Total de sellos: "+sello);


DefaultPieDataset data = new DefaultPieDataset();
data.setValue("Aguila: "+aguila, aguila);
data.setValue("Sello: "+sello, sello);


JFreeChart chart = ChartFactory.createPieChart("Representación de monedas lanzadas", data,true, true, false);

ChartFrame frame = new ChartFrame("Grafica de monedas", chart);
frame.pack();
frame.setVisible(true);



}
}
