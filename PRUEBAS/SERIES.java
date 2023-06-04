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



public class SERIES extends JPanel {
	static DecimalFormat df3 = new DecimalFormat("#0.0");
	 static DecimalFormat df = new DecimalFormat("#0.000");
     static DecimalFormat df2 = new DecimalFormat("#0.00000");
		static Scanner leer = new Scanner(System.in);	
		static Random random = new Random();
		static 	int option, N;
		static double error;
		static ArrayList<Double> numeros = new ArrayList<Double>();		
		
		static double Chicuadradaerror5[] = {3.8415,5.9915,7.8147,9.4877,11.0705,12.5916,14.0671,15.5073,16.9190,18.3070};
		static double Chicuadradaerror10[] = {2.7055,4.6052,6.2514,7.7794,9.2363,10.6446,12.0170,13.3616,14.6837,15.9872};
		
		static ArrayList<Integer> numerosSX = new ArrayList<Integer>();
		static ArrayList<Integer> numerosSY = new ArrayList<Integer>();
		
		
		
		
		static int SeriesOi[]=new int[25];
		static double SeriesX[]=new double[25];
		

public static void main(String[] args) {
		
		System.out.println("\t===Simulador de pruebas===\n");
		System.out.print("Números a simular(34-100): ");
		N=leer.nextInt();
		System.out.print("Error permitido: ");
		error=leer.nextDouble();	
		
		
		 for(int i=1;i<=N;i++){	
			 numeros.add(random.nextDouble());	
		 }
		 
		do {
		
		System.out.println("\n\n\t===Pruebas Estadisticas===\n");
	
		
		Series();			
		
		   JFrame ventana = new JFrame("Plano cartesiano");
	       SERIES Objeto = new SERIES();
	       ventana.add(Objeto);
	       ventana.setSize(800,600);
	       ventana.setLocationRelativeTo(null);
	       ventana.setVisible(true);
	       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       

			System.out.println("\nNúmeros generados ("+N+"): \n");
			for(int i=0;i<N;i++){	
			System.out.println((i+1)+" - "+numeros.get(i));
			}
		
		}while(option!=0);
		    if(option==0)System.out.println("Fin del programa");

		    
		    
		    
	}
		


public void paint(Graphics g){
	   super.paint(g);
    super.paintComponents(g);
    Graphics2D g2d=(Graphics2D)g;
    
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
	   
	   



	   
	   
	   
	  	   
}

	
public static void Series(){
		
		ArrayList<Double> numerosS2 = new ArrayList<>(numeros);	
		ArrayList<Double> numerosS = new ArrayList<Double>();
		
		int x,y;
		
		 
		System.out.println("\n\tU1\t\tU2");		
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

			
			 /*
			  
			   if(numerosS2.get(i-1)>=0 && numerosS2.get(i-1)<=0.2 && numerosS.get(i-1)>=0 && numerosS.get(i-1)<=0.2) SeriesOi[0]++;			   
			   if(numerosS2.get(i-1)>=0 && numerosS2.get(i-1)<=0.2 && numerosS.get(i-1)>=0.2 && numerosS.get(i-1)<=0.4)SeriesOi[1]++;			   
			   if(numerosS2.get(i-1)>=0 && numerosS2.get(i-1)<=0.2 && numerosS.get(i-1)>=0.4 && numerosS.get(i-1)<=0.6)SeriesOi[2]++;                 
			   if(numerosS2.get(i-1)>=0 && numerosS2.get(i-1)<=0.2 && numerosS.get(i-1)>=0.6 && numerosS.get(i-1)<=0.8)SeriesOi[3]++;                
			   if(numerosS2.get(i-1)>=0 && numerosS2.get(i-1)<=0.2 && numerosS.get(i-1)>=0.8 && numerosS.get(i-1)<=1) SeriesOi[4]++;
			   
			   if(numerosS2.get(i-1)>=0.2 && numerosS2.get(i-1)<=0.4 && numerosS.get(i-1)>=0 && numerosS.get(i-1)<=0.2) SeriesOi[5]++;			   
			   if(numerosS2.get(i-1)>=0.2 && numerosS2.get(i-1)<=0.4 && numerosS.get(i-1)>=0.2 && numerosS.get(i-1)<=0.4)SeriesOi[6]++;			   
			   if(numerosS2.get(i-1)>=0.2 && numerosS2.get(i-1)<=0.4 && numerosS.get(i-1)>=0.4 && numerosS.get(i-1)<=0.6)SeriesOi[7]++;                 
			   if(numerosS2.get(i-1)>=0.2 && numerosS2.get(i-1)<=0.4 && numerosS.get(i-1)>=0.6 && numerosS.get(i-1)<=0.8)SeriesOi[8]++;                
			   if(numerosS2.get(i-1)>=0.2 && numerosS2.get(i-1)<=0.4 && numerosS.get(i-1)>=0.8 && numerosS.get(i-1)<=1) SeriesOi[9]++;
			   
			   if(numerosS2.get(i-1)>=0.4 && numerosS2.get(i-1)<=0.6 && numerosS.get(i-1)>=0 && numerosS.get(i-1)<=0.2) SeriesOi[10]++;			   
			   if(numerosS2.get(i-1)>=0.4 && numerosS2.get(i-1)<=0.6 && numerosS.get(i-1)>=0.2 && numerosS.get(i-1)<=0.4)SeriesOi[11]++;			   
			   if(numerosS2.get(i-1)>=0.4 && numerosS2.get(i-1)<=0.6 && numerosS.get(i-1)>=0.4 && numerosS.get(i-1)<=0.6)SeriesOi[12]++;                 
			   if(numerosS2.get(i-1)>=0.4 && numerosS2.get(i-1)<=0.6 && numerosS.get(i-1)>=0.6 && numerosS.get(i-1)<=0.8)SeriesOi[13]++;                
			   if(numerosS2.get(i-1)>=0.4 && numerosS2.get(i-1)<=0.6 && numerosS.get(i-1)>=0.8 && numerosS.get(i-1)<=1) SeriesOi[14]++;
			   
			   if(numerosS2.get(i-1)>=0.6 && numerosS2.get(i-1)<=0.8 && numerosS.get(i-1)>=0 && numerosS.get(i-1)<=0.2) SeriesOi[15]++;			   
			   if(numerosS2.get(i-1)>=0.6 && numerosS2.get(i-1)<=0.8 && numerosS.get(i-1)>=0.2 && numerosS.get(i-1)<=0.4)SeriesOi[16]++;			   
			   if(numerosS2.get(i-1)>=0.6 && numerosS2.get(i-1)<=0.8 && numerosS.get(i-1)>=0.4 && numerosS.get(i-1)<=0.6)SeriesOi[17]++;                 
			   if(numerosS2.get(i-1)>=0.6 && numerosS2.get(i-1)<=0.8 && numerosS.get(i-1)>=0.6 && numerosS.get(i-1)<=0.8)SeriesOi[18]++;                
			   if(numerosS2.get(i-1)>=0.6 && numerosS2.get(i-1)<=0.8 && numerosS.get(i-1)>=0.8 && numerosS.get(i-1)<=1) SeriesOi[19]++;
			   
			   if(numerosS2.get(i-1)>=0.8 && numerosS2.get(i-1)<=1 && numerosS.get(i-1)>=0 && numerosS.get(i-1)<=0.2) SeriesOi[20]++;			   
			   if(numerosS2.get(i-1)>=0.8 && numerosS2.get(i-1)<=1 && numerosS.get(i-1)>=0.2 && numerosS.get(i-1)<=0.4)SeriesOi[21]++;			   
			   if(numerosS2.get(i-1)>=0.8 && numerosS2.get(i-1)<=1 && numerosS.get(i-1)>=0.4 && numerosS.get(i-1)<=0.6)SeriesOi[22]++;                 
			   if(numerosS2.get(i-1)>=0.8 && numerosS2.get(i-1)<=1 && numerosS.get(i-1)>=0.6 && numerosS.get(i-1)<=0.8)SeriesOi[23]++;                
		       if(numerosS2.get(i-1)>=0.8 && numerosS2.get(i-1)<=1 && numerosS.get(i-1)>=0.8 && numerosS.get(i-1)<=1) SeriesOi[24]++;	 
		       */
		       
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
		System.out.println(Eij);
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
		
		
		 
	 
		

		
		
		
		
		
		
		

		
	}
	








}
