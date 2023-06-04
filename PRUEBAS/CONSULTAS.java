package PRUEBAS;
import java.text.DecimalFormat;
import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class CONSULTAS{


    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

   public static void main (String [ ] args) {
   int repeat=0;
	
     do{      	 
     consulta();
     System.out.println("\n"+"¿Deseas seguir?");
     System.out.print("Sí(1)  -  No(2): ");
     repeat =in.nextInt();
   
   }while(repeat!=2);

      if(repeat==2)System.out.println("Fin del programa");

}
   
    

public static void consulta(){

int dias0=0,dias1=0, dias2=0,dias3=0,dias4=0,dias5=0;

System.out.print("Número de consultas:");
int tries=in.nextInt();
String dia="";
DecimalFormat df = new DecimalFormat("#0.000000");

System.out.println("|N|#aleagen|resultado|");

for(int i=1;i<=tries;i++){
	
	double consultas =random.nextDouble()*1;

	if(consultas>=0 && consultas< 0.05) { dias0++; dia="dia0";}
	if(consultas>0.05 && consultas<0.15) { dias1++;dia="dia1";}
	if(consultas>0.15 && consultas<0.35) { dias2++;dia="dia2";}
	if(consultas>0.35 && consultas<0.65) { dias3++;dia="dia3";}
	if(consultas>0.65 && consultas<0.85) {dias4++;dia="dia4";}
    if(consultas>0.85 && consultas<=1) {dias5++;dia="dia5";}
    
    
    System.out.println("|"+i+"|"+df.format(consultas)+"|"+dia+"|");
	
}


DefaultPieDataset data = new DefaultPieDataset();
data.setValue("Cero consultas: "+dias0, dias0);
data.setValue("Una consulta: "+dias1, dias1);
data.setValue("Dos consultas: "+dias2, dias2);
data.setValue("Tres consultas: "+dias3, dias3);
data.setValue("Cuatro consultas: "+dias4, dias4);
data.setValue("Cinco consultas: "+dias5, dias5);


JFreeChart chart = ChartFactory.createPieChart("Representación de consultas", data,true, true, false);

ChartFrame frame = new ChartFrame("Grafica de consultas", chart);
frame.pack();
frame.setVisible(true);



    }

}
