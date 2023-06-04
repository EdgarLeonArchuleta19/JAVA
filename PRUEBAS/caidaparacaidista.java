package PRUEBAS;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class caidaparacaidista extends JFrame{
	 JPanel panel;
	 public static double a=9.8, vc=0,vi=0, c, m;
		public static int i=1,n=0,t=5, tiempo=0;
		
	    public caidaparacaidista(){
	        setTitle("grafica");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        init();
	    }

	    private void init() {
	        panel = new JPanel();
	        getContentPane().add(panel);
	      
	        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	        double a=9.8, vc=0,vi=0;
			int i=1,n=0,t=5, tiempo=0;
	        
	        while (n<i) {
				
				n = n+1;
				i = n+1;
				vc = vi+(a-(c/m)*vi)*t;
				
				tiempo=t*n;
				
				 line_chart_dataset.addValue(vc, "velocidad", tiempo+"s");
				
				if (Math.abs(vi-vc)==0) {
					i = n;
				}
				vi = vc;
			}
	        

	    
	        JFreeChart chart=ChartFactory.createLineChart("paracaidas",
	                "tiempo","velocidad",line_chart_dataset,PlotOrientation.VERTICAL,
	                true,true,false);

	      
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	    }



	static Scanner leer = new Scanner(System.in);
	
	public static void main(String args[]) {
		
	    
		System.out.println("-Simulacion de la velocidad de caida libre de un paracaidista-"+"\n");
		System.out.print("Tecle el peso del paracaidista en kilogramos: ");
		m=leer.nextDouble();
		System.out.print("Tecle el coeficiente de resistencia del aire: ");
		c=leer.nextDouble();
		
		System.out.println("\n"+"Tiempo --- Velocidad ");
		System.out.println(tiempo+"            "+vc);
		
		while (n<i) {
			
			n = n+1;
			i = n+1;
			vc = vi+(a-(c/m)*vi)*t;
			
			tiempo=t*n;
			
			System.out.println(tiempo+"           "+vc);
			
			if (Math.abs(vi-vc)==0) {
				i = n;
			}
			vi = vc;
		}
		
		System.out.println("\n"+"La velocidad final del paracaidista es "+vc+" m/s, despues de "+i*t+" segundos.");
		
		

	}


}

