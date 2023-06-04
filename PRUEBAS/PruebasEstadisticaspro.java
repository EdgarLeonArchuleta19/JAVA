package PRUEBAS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
@SuppressWarnings("serial")
public class PruebasEstadisticaspro extends JPanel {
	
	        static DecimalFormat df = new DecimalFormat("#0.000");
	        static DecimalFormat df2 = new DecimalFormat("#0.00000");
	        static DecimalFormat df3 = new DecimalFormat("#0.0");
			static Scanner leer = new Scanner(System.in);	
			static Random random = new Random();
			static 	int option, N;
			static double error;
			static int SeriesOi[]=new int[25];
			static double SeriesX[]=new double[25];
						
			static ArrayList<Double> numeros = new ArrayList<Double>();
			static ArrayList<Integer> numerosSX = new ArrayList<Integer>();
			static ArrayList<Integer> numerosSY = new ArrayList<Integer>();
						
			static double Chicuadradaerror5[] = {3.8415,5.9915,7.8147,9.4877,11.0705,12.5916,14.0671,15.5073,16.9190,18.3070};
			static double Chicuadradaerror10[] = {2.7055,4.6052,6.2514,7.7794,9.2363,10.6446,12.0170,13.3616,14.6837,15.9872};

			
	public static void main(String[] args) {
		
		System.out.println("\t===Simulador de pruebas Estadisticas===\n");
		
		do {
		System.out.print("Ingresa los números a simular(34-100): ");
		N=leer.nextInt();
		if(N<34 || N>100)System.out.println("valor fuera de rango");;
		}while(N<34 || N>100);
		
		
		System.out.print("Ingresa el error permitido: ");
		error=leer.nextDouble();	
		
		 for(int i=1;i<=N;i++){	
			 numeros.add(random.nextDouble());	
		 }
		 
		do {
		
		System.out.println("\n\nMENU:\n");
		System.out.println("Chicuadrado - 1");
		System.out.println("Kolmogorov - 2");
		System.out.println("Series - 3");
		System.out.println("Huecos - 4");
		System.out.println("Poker - 5");
		System.out.println("Ver lista - 6");
		System.out.println("Salir - 0");
		System.out.print("\n\nEscoge una opción:");
		option=leer.nextInt();
			
		if(option == 1)Chicuadrada();		
		if(option == 2)Kolmogorov();
		if(option == 3)Series();		
		if(option == 4)Huecos();
		if(option == 5)Poker();
		if(option == 6)Lista();
		
		}while(option!=0);
		    if(option==0)System.out.println("Fin del programa");

	}
	
	
	
	
	
	public static void Lista() {	
		System.out.println("\nNúmeros generados ("+N+"): \n");
		for(int i=0;i<N;i++){	
		System.out.println((i+1)+" - "+numeros.get(i));
		}
	}
	
	
	
	
	
	public static void Chicuadrada() {
		
		System.out.println("\n\n==PRUEBA CHI-CUADRADA==\n");
		
		ArrayList<Double> numerosC = new ArrayList<>(numeros);			
		int O=0, TO=0;
		double k, E, intervaloI, intervaloF, acumIF;
		double TE=0, TX=0, X;		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
		
			
		k = (int) Math.sqrt(N);		
		intervaloI = 0;
		intervaloF = 1.0/k;
		acumIF=intervaloF;
		E =N/k;
		
		System.out.println("\ni\tO\tE\t(O-E)\t(O-E)^2/E");	
		System.out.println("------------------------------------------");
		for(int j=0;j<k;j++) {	
		   for(int i=0;i<N;i++){			 
			  if(numerosC.get(i)>=intervaloI && numerosC.get(i)< intervaloF) {
				 O++;	
				 TO++;				
			 }}
		
		   
		X=(Math.pow((O-E), 2)/E);
		TE=TE+E;
		TX=TX+X;
		
		System.out.println(df.format(intervaloF)+"\t"+O+"\t"+df3.format(E)+"\t"+df3.format(O-E)+"\t"+df.format(X));
				
		String numCadena= String.valueOf(df.format(intervaloF));
		dataset.setValue(O,numCadena, numCadena);
		intervaloI=intervaloF;
		intervaloF=intervaloF+acumIF;
		O=0;
		
		}
		dataset.setValue(E, "esperado", "Esperado" );
		
		System.out.println("Totales\t"+TO+"\t"+TE+"\t\t"+df.format(TX));		
		if(error==0.05) {
			System.out.println("\n\n"+df2.format(TX)+" <= "+Chicuadradaerror5[(int) (k-2)]);
		    if(TX<=Chicuadradaerror5[(int) (k-2)]) {		    
		    	System.out.println("Los números estan uniformemente distribuidos");
		    }else {		    	
		    	System.out.println("Los números NO estan uniformemente distribuidos");
		    }}
		
		
		if(error==0.10) {	
			System.out.println("\n\n"+df2.format(TX)+" <= "+Chicuadradaerror10[(int) (k-2)]);
			if(TX<=Chicuadradaerror10[(int) (k-2)]) {				
		    	System.out.println("Los números estan uniformemente distribuidos");
			}else {
				System.out.println("Los números NO estan uniformemente distribuidos");
			}}	
		 
		 JFreeChart chart = ChartFactory.createBarChart3D("Chi-Cuadrada","i", "O", 
			        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(ChartColor.cyan);
	        chart.getTitle().setPaint(ChartColor.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(ChartColor.red); 

		ChartFrame frame = new ChartFrame("Grafica de chi-cuadrada", chart);
		frame.pack();
		frame.setVisible(true);	
				
	}
	
	
	
	
	
	public static void Kolmogorov() {
		
		
		System.out.println("\n\n==PRUEBA KOLMOGOROV==\n");
		
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset(); 
		double error5 [] = {0.21472, 0.20185, 0.19910, 0.19646, 0.19392, 0.19148, 0.18913,
				0.18687, 0.18468, 0.18257, 0.18051, 0.17856, 0.17665,0.17481, 0.17301, 0.17128, 0.16959};
		double error10 [] = {0.22743, 0.22425, 0.22119, 0.21826, 0.21544, 0.21273, 0.21012,
				0.20760, 0.20517, 0.20283, 0.20056, 0.19837, 0.19625,0.19420, 0.19221, 0.19028, 0.18841};
		ArrayList<Double> numerosK = new ArrayList<>(numeros);		
		numerosK.sort(null);		
		ArrayList<Double> mayor = new ArrayList<Double>();	
		
		System.out.println("\ni\tUi\t\ti/N\t\tDi");
		System.out.println("----------------------------------------------------");	
		
		
		for(double i=0;i<N;i++){	
		double iN= (i+1)/N;
		double Di=	Math.abs(numerosK.get((int) i)-iN);
		mayor.add(Di);
		System.out.println((i+1)+"\t"+df2.format(numerosK.get((int) i))+"\t\t"+df2.format(iN)+"\t\t"+df2.format(Di));
		
		
		String Si= String.valueOf(i);
		line_chart_dataset.addValue((iN), "i/N", Si);
		line_chart_dataset.addValue((numerosK.get((int)i)), "Ui", Si);
	
		}		
		
		mayor.sort(null);
		double DiM=mayor.get(N-1);
	
				
		if(N<=50) {
		
		if(error==0.05) {		
			System.out.println("\n\n"+df2.format(DiM)+" <= "+error5[N-34]);
		    if(DiM<=error5[N-34]) {
		    	System.out.println("Los números estan uniformemente distribuidos");
		    }else {
		    	System.out.println("Los números NO estan uniformemente distribuidos");
		    }}
		
		
		if(error==0.10) {
			System.out.println("\n\n"+df2.format(DiM)+" <= "+error10[N-34]);
		    if(DiM<=error10[N-34]) {
		    	System.out.println("Los números estan uniformemente distribuidos");
			}else {		
				System.out.println("Los números NO estan uniformemente distribuidos");
			}}
			
		}else {
			
			double FormulaK=0;			
			if(error==0.05) {				
				FormulaK=1.36/Math.sqrt(N);	
				System.out.println("\n\n"+df2.format(DiM)+" <= "+df2.format(FormulaK));
			    if(DiM<=FormulaK) {			    	
			    	System.out.println("Los números estan uniformemente distribuidos");
			    }else {			    	
			    	System.out.println("Los números NO estan uniformemente distribuidos");
			    }}
			
			
			if(error==0.10) {				
				FormulaK=1.22/Math.sqrt(N);
				System.out.println("\n\n"+df2.format(DiM)+" <= "+df2.format(FormulaK));
			    if(DiM<=FormulaK) {		    
			    	System.out.println("Los números estan uniformemente distribuidos");
				}else {
					System.out.println("Los números NO estan uniformemente distribuidos");
				}}		
		}
		
		
        
        JFreeChart chart=ChartFactory.createLineChart("Trafico en el Blog",
                "Valor","Numeros",line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false); 
        
        ChartFrame frame = new ChartFrame("Grafica de dados", chart);
		frame.pack();
		frame.setVisible(true);	
		
		
		
	}
	
	
	
	
	
public static void Series(){
	
	
	   System.out.println("\n\n==PRUEBA SERIES==\n");
		
	    int x,y;
		ArrayList<Double> numerosS2 = new ArrayList<>(numeros);	
		ArrayList<Double> numerosS = new ArrayList<Double>();			
		 
		System.out.println("\nn\tU1\t\tU2");	
		System.out.println("---------------------------------");
		for(int i=1;i<=N;i++){
			
			if(i<N-1) {				
				numerosS.add(numeros.get(i));	      
			}else {
				numerosS.add(numeros.get(N-1));
			}
			
			 System.out.println((i)+"\t"+df2.format(numerosS2.get(i-1))+"\t\t"+df2.format(numerosS.get(i-1)));    
				
			 x=(int) (numerosS2.get(i-1)*100);
			 y=(int) (numerosS.get(i-1)*100);
			 		
			 numerosSX.add(x);
			 numerosSY.add(y);		 
			 
		}	
		

		double []rangos= {0,0.2,0.4,0.6,0.8,1}; 
		 int con=0;
		 
		 for(int i=0;i<N;i++){
			 con=0;
		  for(int j=0;j<5;j++) { 
			   		   
			   for(int k=0;k<5;k++) { 
				   if(numerosS2.get(i)>=rangos[j] && numerosS2.get(i)<=rangos[j+1] && numerosS.get(i)>=rangos[k] && numerosS.get(i)<=rangos[k+1]) { SeriesOi[con]++;}			   
				  con++;
			   }	   
		   }
		 }
		
		
		 
		double Eij=N/25.0;
		double TX=0;
		for(int i=0;i<25;i++){
								
			SeriesX[i]=Math.pow((SeriesOi[i]-Eij), 2)/Eij;		
			TX=TX+SeriesX[i];
						
		}

		if(error==0.05) {
			System.out.println("\n\n"+df2.format(TX)+" <= "+36.4150);
		    if(TX<=36.4150) {		    
		    	System.out.println("Los números son independientes");
		    }else {		    	
		    	System.out.println("Los números NO son independientes");
		    }}
		
		
		if(error==0.10) {	
			System.out.println("\n\n"+df2.format(TX)+" <= "+33.1962);
			if(TX<=33.1962) {				
		    	System.out.println("Los números son independientes");
			}else {
				System.out.println("Los números NO son independientes");
			}}
		
		
		
		 JFrame ventana = new JFrame("PRUEBA SERIES");
	       PruebasEstadisticaspro Objeto = new PruebasEstadisticaspro();
	       ventana.add(Objeto);
	       ventana.setSize(800,600);
	       ventana.setLocationRelativeTo(null);
	       ventana.setVisible(true);
	       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}




public void paint(Graphics g){
	   super.paint(g);
 super.paintComponents(g);
 Graphics2D g2d=(Graphics2D)g;
 
 g.setColor(new Color(88, 150, 234,100 ));
 g.fillRect(0,0,800,600);
 
 //primer cuadrado
		   g.setColor(new Color(88, 150, 234 ));
		   g.fillRect(70,120,250,250);
		   
		   int a=115,b=175;
		   int d=85,i=360;
		   double c=0.4;
		   String coor;
		   	   
		   g.setColor(new Color(0, 0, 0));
		   g.setFont(new Font("arial",Font.BOLD,13)); 
		   g.drawString("0.2", d, 385); 
		   
		   g.setColor(new Color(0, 0, 0));
		   g.setFont(new Font("arial",Font.BOLD,13)); 
		   g.drawString("0.2", 45, i); 
		   
		   for(int j=1;j<=4;j++) { 
			   
			   coor=df3.format(c); 
			   
			   g.setColor(new Color(255, 255, 255));
			   g.fillRect(a,120,1,250);
			   g.setColor(new Color(255, 255, 255));
			   g.fillRect(70,b,250,1);
			   a=a+50;
			   b=b+50;
			 
			   
			   c=c+0.2;
			   d=d+50;
			   i=i-50;
			   
			   g.setColor(new Color(0, 0, 0));
			   g.setFont(new Font("arial",Font.BOLD,13)); 
			   g.drawString(coor, d, 385); 
			   
			   g.setColor(new Color(0, 0, 0));
			   g.setFont(new Font("arial",Font.BOLD,13)); 
			   g.drawString(coor, 45, i); 	   
			   
		   }
 
	   for(int p=0;p<N;p++) {	   
        BasicStroke grosor= new BasicStroke(4);
        g2d.setStroke(grosor);           
		   g2d.setPaint(Color.BLACK);
		   g2d.drawLine(2*numerosSX.get(p)+100,-2* numerosSY.get(p)+350,2*numerosSX.get(p)+100,-2* numerosSY.get(p)+350);
	   }
	   
	      
	   
	   //Observado
	   g.setColor(new Color(88, 150, 234 ));
	   g.fillRect(427,36,230,230);
	   
	   g.setColor(new Color(0, 0, 0));
	   g.setFont(new Font("arial",Font.BOLD,13)); 
	   g.drawString("0.2", 400, 260); 
	   
	   g.setColor(new Color(0, 0, 0));
	   g.setFont(new Font("arial",Font.BOLD,13)); 
	   g.drawString("0.2", 430, 286); 
	   
	   c=0.4;
	   d=430; i=270; a=460;b=75;
	   
	   
	   for(int j=1;j<=4;j++) { 		   
		   coor=df3.format(c); 
		   
		   g.setColor(new Color(255, 255, 255));
		   g.fillRect(a,36,1,230);
		   g.setColor(new Color(255, 255, 255));
		   g.fillRect(427,b,230,1);
		   a=a+50;
		   b=b+50;
		 
		   
		   c=c+0.2;
		   d=d+50;
		   i=i-50;
		   
		   g.setColor(new Color(0, 0, 0));
		   g.setFont(new Font("arial",Font.BOLD,13)); 
		   g.drawString(coor, d, 286); 
		   
		   g.setColor(new Color(0, 0, 0));
		   g.setFont(new Font("arial",Font.BOLD,13)); 
		   g.drawString(coor, 400, i); 	 		  
	   }
	   
	   int H=440,V=250, contador = 0;
	   for(int j=1;j<=5;j++) { 
		   
		   
		   for(int k=1;k<=5;k++) { 
			   
			   String SeriesOI=Integer.toString(SeriesOi[contador]);  
			   
			   g.setColor(new Color(0, 0, 0));
			   g.setFont(new Font("arial",Font.BOLD,13)); 
			   g.drawString(SeriesOI, H, V); 
			   V=V-50;
			   contador++;
		   }
		   H=H+50;
		   V=250;
		   
	   }
	   

	     
	   
	   //Tabla final
	      
	   g.setColor(new Color(88, 150, 234 ));
	   g.fillRect(427,310,230,230);    
	   
	   g.setColor(new Color(0, 0, 0));
	   g.setFont(new Font("arial",Font.BOLD,13)); 
	   g.drawString("0.2", 400, 520); 
	   
	   g.setColor(new Color(0, 0, 0));
	   g.setFont(new Font("arial",Font.BOLD,13)); 
	   g.drawString("0.2", 430, 310); 
	   
	   c=0.4;
	   d=430; i=540; a=460;b=345;   
	   for(int j=1;j<=4;j++) { 
		   
		   coor=df3.format(c); 
		   
		   g.setColor(new Color(255, 255, 255));
		   g.fillRect(a,310,1,230);
		   g.setColor(new Color(255, 255, 255));
		   g.fillRect(427,b,230,1);
		   a=a+50;
		   b=b+50;		 
		   
		   c=c+0.2;
		   d=d+50;
		   i=i-50;
		   
		   g.setColor(new Color(0, 0, 0));
		   g.setFont(new Font("arial",Font.BOLD,13)); 
		   g.drawString(coor, d, 310); 
		   
		   g.setColor(new Color(0, 0, 0));
		   g.setFont(new Font("arial",Font.BOLD,13)); 
		   g.drawString(coor, 400, i); 	 		  
	   }
	   
	   
	   H=430;V=530; contador = 0;
	   for(int j=1;j<=5;j++) { 	   
		   for(int k=1;k<=5;k++) { 
			   
			   String SeriesXX=df.format(SeriesX[contador]);   
			   
			   g.setColor(new Color(0, 0, 0));
			   g.setFont(new Font("arial",Font.BOLD,13)); 
			   g.drawString(SeriesXX, H, V); 
			   V=V-50;
			   contador++;
		   }
		   H=H+45;
		   V=530;
		   
	   }
	   
	   g.setColor(new Color(0, 0, 0));
	   g.setFont(new Font("arial",Font.BOLD,18)); 
	   g.drawString("Prueba de las series", 100, 50); 
	   
	   g.setColor(new Color(0, 0, 0));
	   g.setFont(new Font("arial",Font.BOLD,13)); 
	   g.drawString("El valor esperado es: "+N/25.0, 100, 450); 
	   
 	   
}
	

	
      public static void Huecos() {
    	  
    	    
    	  System.out.println("\n\n==PRUEBA HUECOS==\n");
    	  
    	  ArrayList<Double> numerosH = new ArrayList<>(numeros);		  
    	  double α=0,β=0,θ=0,Pi=0;;
    	  int e=0, i=0, contadorceros = 0,sumaultimo = 0,TotalOI=0;
    	  String Si="";
    	  double E[]=new double[N];
    	  int I[]=new int[N];
    	  
    	  
    	  System.out.print("Ingresa α:");
    	  α=leer.nextDouble();
    	  System.out.print("Ingresa θ: ");
    	  θ=leer.nextDouble();   	  
    	  β=α+θ;
    	  
    	  System.out.println("\nDonde α="+α+", β="+df.format(β)+", θ="+θ);
    	  System.out.println("\n\nn\tUi\t\te\ti");
    	  System.out.println("----------------------------------");
    	  
    	  for(int n=0;n<N;n++){  
    		  
    		  if(numerosH.get(n)>=α && numerosH.get(n)<β) {
    			  e=1;  			 
    		  }else {
    			e=0;	   
    		  } 		  
    		  E[n]=e;    		 	  
    	  }
    	  
    	  
    	  for(int j=0;j<N;j++) {
    		   		  
    		  if(j<N-1) {
		  
    			  if(E[j]==0) {
        		   i++;          			  
        		   if(E[j+1]==1) {Si=Integer.toString(i);}
        		   if(E[j+1]==0)Si=" ";
    		      } 
    		  
    		      if(E[j]==1){
    			   if(E[j+1]==1)Si=" ";    			     			  
    			   if(E[j+1]==0) {Si="0";I[j]=i; i=0; contadorceros++; }  			    			  
         		 }
    		  }
    		  
    		  if(j==N-1){
    			  
    			  if(E[j]==0) {
        			  i++;
        			  I[j]=i;
        			  Si=Integer.toString(i);
    			  }
        		  if(E[j]==1) {
        			  Si="0"; contadorceros++;  			  
        		  }  		  
    		  } 
		       
    		  
    		  
    		  System.out.println((j+1)+"\t"+df2.format(numerosH.get(j))+"\t\t"+E[j]+"\t"+Si);
    		     		
    	  }

    	  
    	  int Oi[]=new int[N+1];
    	  
    	    for(int d=1; d<=N; d++) {
	            int repetido = 0;
	            for(int j=0; j<N; j++) {
	            	
	                if(I[j] == d) {
	                    repetido++;
	                }	    
	               
	            }
	            Oi[d]=repetido;
    	    	TotalOI=TotalOI+Oi[d];
	        }
    	    
    	    TotalOI=TotalOI+contadorceros;
    	    System.out.println("\n\ni\tPi\t\tOi\tEi\t\tOi-Ei\t\tX");  
    	    System.out.println("-------------------------------------------------------------------------");   
    	    double TotalPi=0, TotalEi=0,TX=0, Ei=0;
    	    double X=0;
    	    int comparador=0;
    	    
    	    for(int tabla=1; tabla<=N; tabla++) {    	    	
    	    	if(tabla==1) {
    	    		Ei=TotalOI*θ;
    	    		X=(Math.pow((contadorceros-Ei), 2)/Ei);
    	    		System.out.println("0\t"+df2.format(θ)+"\t\t"+contadorceros+"\t"+df.format(Ei)+"\t\t"+df.format(contadorceros-Ei)+"\t\t"+df2.format(X));
    	    		
    	    	}else if(Oi[tabla]!=0) {
    	    	
    	    	    
    	    		Pi=Math.pow((1-θ), tabla-1)*θ;
    	    		Ei=TotalOI*Pi;
    	    		X=(Math.pow((Oi[tabla-1]-Ei), 2)/Ei);
    	    		System.out.println((tabla-1)+"\t"+df2.format(Pi)+"\t\t"+Oi[tabla-1]+"\t"+df.format(Ei)+"\t\t"+df.format(Oi[tabla-1]-Ei)+"\t\t"+df2.format(X));
    	    	    	    	
    	    	}else {
    	              
    	    		for(int suma=tabla-1; suma<=N; suma++) {   	    		
    	    			sumaultimo=sumaultimo+Oi[suma];   	    			
    	    		}
    	 	
    	    		Pi=Math.pow((1-θ), tabla-1);
    	    		Ei=TotalOI*Pi;
    	    		X=(Math.pow((sumaultimo-Ei), 2)/Ei);
    	    		System.out.println(">="+(tabla-1)+"\t"+df2.format(Pi)+"\t\t"+sumaultimo+"\t"+df.format(Ei)+"\t\t"+df.format(sumaultimo-Ei)+"\t\t"+df2.format(X));
    	    		comparador=tabla-2;
    	    		TotalPi=TotalPi+Pi;
    	    		TotalEi=TotalEi+Ei;
    	    		TX=TX+X;
    	    		break;
    	    	        	    	
    	    	} 	    	
    	    	TotalPi=TotalPi+Pi;
    	    	TotalEi=TotalEi+Ei;
    	    	TX=TX+X;
    	    }
    	    
    	

    	    TotalPi=TotalPi+θ;
    	    System.out.println("\t"+TotalPi+"\t\t"+TotalOI+"\t"+df.format(TotalEi)+"\t\t\t\t"+df2.format(TX));
	    
    	    
    	    if(error==0.05) {
    			System.out.println("\n\n"+df2.format(TX)+" <= "+Chicuadradaerror5[comparador]);
    		    if(TX<=Chicuadradaerror5[comparador]) {		    
    		    	System.out.println("Los números son independientes");
    		    }else {		    	
    		    	System.out.println("Los números NO son independientes");
    		    }}
    		
    		
    		if(error==0.10) {	
    			System.out.println("\n\n"+df2.format(TX)+" <= "+Chicuadradaerror10[comparador]);
    			if(TX<=Chicuadradaerror10[comparador]) {				
    		    	System.out.println("Los números son independientes");
    			}else {
    				System.out.println("Los números NO son independientes");
    			}}
    		
    		
    		}
    	    
    	    
    	  
    	  
    	 
      
	
	public static void Poker() {
				
		System.out.println("\n\n==PRUEBA POKER==\n");
		
		ArrayList<Double> numerosP = new ArrayList<>(numeros);	
		int pachuca = 0, unpar=0,dospares=0,tercia=0,full=0,poker=0,quintilla=0;	
		String evento ="";
		
		
		System.out.println("\nn\tri\t\tevento");		
		System.out.println("--------------------------------");
		for(int i=0;i<N;i++){
			
			int rep0 = 0, rep2=0, rep3=0, rep4=0,rep5=0;			
		    String Cadena= Double.toString(numerosP.get(i));  
			String num =   Cadena.substring (2,3)+Cadena.substring (3,4)+Cadena.substring (4,5)+Cadena.substring (5,6)+Cadena.substring (6,7);	   		 
			
			 		        
		        for(int d=0; d<10; d++) {
		            int repetido = 0;
		            for(int j=0; j<num.length(); j++) {
		            	
		                if(Double.valueOf(String.valueOf(num.charAt(j))) == d) {
		                    repetido++;
		                }	                
		            }
		            
                     if(repetido==2) rep2++;
		             if(repetido==1) rep0++;
		             if(repetido==3) rep3++;
		             if(repetido==4) rep4++;
 		             if(repetido==5) rep5++;      
		        }
		       		        
		        if(rep0==5) {evento="pachuca"; pachuca++;	}	        
		        if(rep2==1 && rep3 ==0) {evento="par"; unpar++;	}        
		        if(rep2==2) { evento="2 pares"; dospares++;  }
		        if(rep3==1 && rep2 ==0) {evento="tercia";tercia++;}		        
		        if(rep3==1 && rep2==1) { evento="full";full++;}		        
		        if(rep4==1) { evento="pokar";poker++;}		        
		        if(rep5==1) {evento="quintilla";quintilla++;}
		                
		    System.out.println((i+1)+"\t"+num+"\t\t"+evento);      
		        
		    }	
		
		System.out.println("\n\nEvento\t\tFO\tPE\tFE\tX");
		System.out.println("------------------------------------------------------");
		String Eventos[]  = {"pachuca","un par","Tercia","Dos par","Full", "Poker", "Quinti"};
		double FO[]= {pachuca,unpar,tercia,dospares,full,poker,quintilla};
		double PE[]= {0.3024,0.5040,0.0720,0.1080,0.0090,0.0045,0.001};
		double FE=0, X=0, TX=0;
		
		for(int t=0;t<7;t++){
					
			FE=PE[t]*N;
			X=(Math.pow((FO[t]-FE), 2)/FE);
			TX=TX+X;
			System.out.println(Eventos[t]+"\t\t"+FO[t]+"\t"+PE[t]+"\t"+df.format(FE)+"\t"+df2.format(X));
				
		}
		System.out.println("\nTotal de la muestra: "+N+"\t\t\t"+df2.format(TX));
		
		
		
		if(error==0.05) {
			System.out.println("\n\n"+df2.format(TX)+" <= "+Chicuadradaerror5[5]);
		    if(TX<=Chicuadradaerror5[5]) {		    
		    	System.out.println("Los números son independientes");
		    }else {		    	
		    	System.out.println("Los números NO son independientes");
		    }}
		
		
		if(error==0.10) {	
			System.out.println("\n\n"+df2.format(TX)+" <= "+Chicuadradaerror10[5]);
			if(TX<=Chicuadradaerror10[5]) {				
		    	System.out.println("Los números son independientes");
			}else {
				System.out.println("Los números NO son independientes");
			}}		
		}		
	}
*/