package PRUEBAS;


import java.util.Random;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics;

public class TableroDardos extends JFrame{
	
	static Scanner leer = new Scanner(System.in);
	static double TE=0,TL=0, fallo=0;
    static double a=0.0, b=0.0,H=0.0,pi=0;
   static Random random = new Random();
   static double coorx[]=new double[10000000];
   static double coory[]=new double[10000000];
   
   
	public TableroDardos(){
        super("Dardos");
        setSize(600, 600);
        setVisible(true);
        JLabel titulo = new JLabel("-TABLERO DE DARDOS-", JLabel.CENTER);
		add(titulo, BorderLayout.NORTH);
        JLabel etiqueta = new JLabel("El valor aproximado de PI es: "+pi, JLabel.CENTER);
		add(etiqueta, BorderLayout.SOUTH);
		
        
   }
	
	public static void lanzamiento() {
		
		for(int i=1;i<=TL;i++) {
			
			   
            int gene = random.nextInt(5 - 1) + 1;
			
			if(gene==1) {
				a = (random.nextDouble() * -1 + 1)*-1;
				b = (random.nextDouble() * -1 + 1)*-1;
			}
            if(gene==2) {
            	a = (random.nextDouble() * -1 + 1)*-1;
    			b = random.nextDouble() * -1 + 1;
			}
			
			if(gene==3) {
				a = random.nextDouble() * -1 + 1;
				b = (random.nextDouble() * -1 + 1)*-1;
			}
            if(gene==4) {
            	a = random.nextDouble() * -1 + 1;
    			b = random.nextDouble() * -1 + 1;
			}
           
    			coorx[i]=(a*200)+300;
    			coory[i]=(b*200)+300;
            
           
	
		System.out.println("Dardo["+i+"] X es: "+a);
		System.out.println("Dardo["+i+"] y es: "+b);
		
		
		H = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		System.out.println("H es "+H);
		

        if(H<=1 && H>=-1) {
			TE++;
			System.out.println("Exito");
		}else{
			fallo++;
			System.out.println("fallo");

		}  
		}
	}
	
	 public void paint(Graphics g){
	       super.paint(g);
	       
	       
	       g.setColor(Color.RED);
	       g.fillOval(100, 100, 400, 400);
	       g.setColor(Color.WHITE);
	       g.fillOval(150, 150, 300, 300);
	       g.setColor(Color.RED);
	       g.drawOval(100, 100, 400, 400);
	       g.drawOval(150, 150, 300, 300);
	       g.drawOval(200, 200, 200, 200);
	       g.drawOval(250, 250, 100, 100);
	       g.drawOval(275, 275, 50, 50);
	       g.setColor(Color.RED);
	       g.fillOval(200, 200, 200, 200);
	       g.setColor(Color.WHITE);
	       g.fillOval(250, 250, 100, 100);
	       g.setColor(Color.RED);
	       g.fillOval(275, 275, 50, 50);
	       
	       
	       
	       Color dardo = new Color(131, 255, 0);
	       g.setColor(dardo);
	       g.setColor(Color.black);
	 
	       for(int i=1;i<=TL;i++) {
	    	   
	       g.drawLine((int)coorx[i], (int)coory[i], (int)coorx[i]+3,(int)coory[i]+3);
	       
	       
	       }
	       
	 }
	
	public static void main(String[] args){  
		
		do {
		System.out.print("Ingresa los dardos a lanzar:");
		TL=leer.nextInt();
	   }while(TL>1000000);
		
		lanzamiento();
		
		System.out.println("Total de lazamientos: "+TL);
		System.out.println("Total de exitos: "+TE);
		System.out.println("Total de fallos: "+fallo);
		
		 pi=(TE/TL)*4;
         
		System.out.println("\n"+"El valor aproximado de Pi es: "+pi);
		
		 TableroDardos application = new TableroDardos();
	      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

