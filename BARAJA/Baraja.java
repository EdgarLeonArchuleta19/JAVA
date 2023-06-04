package BARAJA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.ImageIcon;
@SuppressWarnings("serial")
public class Baraja extends JPanel {
	
	static Scanner in = new Scanner(System.in);
    static Random random = new Random();
	static int x = 11,a, juegos,tries=0;
	static String [] Carta= new String[40];
	static String [] CyF= new String[40];
	static double[] jugador = new double[40];
	static int p1=0,p2=0,p3=0,p4=0;
	static int Rg1=0,Rg2=0,Rg3=0,Rg4=0;
	static String ganadorS="";	   
	static boolean repetir = false;
	
           public static void main(String[]args) throws InterruptedException{		   
        	  do { 
	          tries=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de juegos (1-10000)")); 	          
	          if(tries<1 || tries >10000) JOptionPane.showMessageDialog(null, "seleciona un número dentro del rango","ERROR",  JOptionPane.WARNING_MESSAGE, null);	          
        	  }while(tries<1 || tries >10000);
	          
	          
	          for(juegos=0;juegos<tries;juegos++) {		       
		       JFrame ventana = new JFrame("Juego de cartas");
		       Baraja game = new Baraja();
		       ventana.add(game);
		       ventana.setSize(950,650);
		       ventana.setLocationRelativeTo(null);
		       ventana.setVisible(true);
		       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       
	        	  x=11;
	        	  ganadorS="";
	        	  p1=p2=p3=p4=0;
		       
		       for(a=0;a<=10;a++) {		 
					game.animation();
					game.repaint();
					Thread.sleep(600);	
				}
	          }
	          
	          DefaultPieDataset data = new DefaultPieDataset();
	          data.setValue("P1:"+Rg1, Rg1);
	          data.setValue("P2:"+Rg2, Rg2);
	          data.setValue("P3:"+Rg3, Rg3);
	          data.setValue("P4:"+Rg4, Rg4);
	          JFreeChart chart = ChartFactory.createPieChart("Rondas ganadas por jugador", data,true, true, false);
	          ChartFrame frame = new ChartFrame("Grafica de rondas ganadas", chart);
	          frame.pack();
	          frame.setVisible(true);         
	   }
           

	private void animation() {
			
		x--;		
		if(x==10) {	
			reparte();
		}	
		if(x<10) {
		            if(jugador[a] > jugador[a+9] && jugador[a] > jugador[a+19] && jugador[a] > jugador[a+29]) { p1++;   
		        }else{
		            if(jugador[a+9] > jugador[a] && jugador[a+9] > jugador[a+19] && jugador[a+9] > jugador[a+29]) {p2++;
		         }else{
		             if(jugador[a+19] > jugador[a] && jugador[a+19] > jugador[a+9] && jugador[a+19] > jugador[a+29]){p3++;          	
		         }else {
		             if(jugador[a+29] > jugador[a] && jugador[a+29] > jugador[a+9] && jugador[a+29] > jugador[a+19])p4++;
		                }
		            }
		        }
		   }
	
	} 
		 		   
	public static void reparte() {
		
			for(int j=0; j<40; j++) {				
				do {					
										
					 jugador[j]=0;
					 repetir=false;
					 double numero =random.nextDouble()*1;
					 double palo =random.nextDouble()*1;
								 
					 if(palo>=0 && palo< 0.25){
						 jugador[j]=jugador[j]+0.4;
						 Carta[j]="Oro";
					 }					   				   
					if(palo>0.25 && palo<0.50){
						jugador[j]=jugador[j]+0.3;
						Carta[j]="Copas";
					}										
					if(palo>0.50 && palo<0.75){
						jugador[j]=jugador[j]+0.2;
						Carta[j]="Espadas";
					}					
					if(palo>0.75 && palo<=1){
						jugador[j]=jugador[j]+0.1;
						Carta[j]="Bastos";
					}
					
					
					   if(numero>=0 && numero< 0.10) {
						jugador[j]=jugador[j]+11;
						CyF[j]=Carta[j]+"1.jpeg";										   
					   }
						if(numero>0.10 && numero<0.20) {
							jugador[j]=jugador[j]+10;
							CyF[j]=Carta[j]+"R.jpeg";							 
						}
						if(numero>0.20 && numero<0.30) {
							jugador[j]=jugador[j]+9;
							CyF[j]=Carta[j]+"C.jpeg";						  
						}
						if(numero>0.30 && numero<0.40) {
							jugador[j]=jugador[j]+8;
							CyF[j]=Carta[j]+"S.jpeg";							  
						}
						if(numero>0.40 && numero<0.50) {
							jugador[j]=jugador[j]+7;
							CyF[j]=Carta[j]+"7.jpeg";							  
						}
						if(numero>0.50 && numero<0.60) {
							jugador[j]=jugador[j]+6;
							CyF[j]=Carta[j]+"6.jpeg";							   
						}
						if(numero>0.60 && numero<0.70) {
							jugador[j]=jugador[j]+5;
							CyF[j]=Carta[j]+"5.jpeg";							  
						}
						if(numero>0.70 && numero<0.80) {
							jugador[j]=jugador[j]+4;
							CyF[j]=Carta[j]+"4.jpeg";							 
						}
						if(numero>0.80 && numero<0.90) {
							jugador[j]=jugador[j]+3;
							CyF[j]=Carta[j]+"3.jpeg";							
						}
						if(numero>0.90 && numero<=1) {
							jugador[j]=jugador[j]+2;
							CyF[j]=Carta[j]+"2.jpeg";								   
						}
															
					for (int c = 0; c < 40; c++) {						
			            if (jugador[c] == jugador[j] && c != j) { 
			                repetir=true;			             
			               break;			                             
			            }
			            		            
			            if (jugador[c] == jugador[j] && c == j) {
			            	 repetir=false;
			            	 break;			            	 			            	 
			             } 
			            
			            if(repetir==true) {
			            	break;
			            }		                      	 
			             }	
					
				  }while(repetir==true);
			}
		}
	
	   
	   public void paint(Graphics g){

			  super.paint(g);
			  super.paintComponent(g);
			  Graphics2D g2d=(Graphics2D)g;	 
					  
			  g.setColor(new Color(38, 141, 58));
			  g.fillRect(0, 0, 970, 670); 
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,15)); 
			  g.drawString("P1", 140, 540); 			  
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,15)); 
			  g.drawString("P2", 555, 460); 			  
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,15)); 
			  g.drawString("P3", 490, 90); 		  
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,15)); 
			  g.drawString("P4", 75, 120); 	  
			  
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,18)); 
			  g.drawString("- Juego de Cartas -", 705, 120); 
			  
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,18)); 
			  g.drawString("P1: "+p1, 705, 180); 
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,18)); 
			  g.drawString("P2: "+p2, 705, 230); 
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,18));  
			  g.drawString("P3: "+p3, 705, 280); 
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,18)); 
			  g.drawString("P4: "+p4, 705, 330); 
			  			  
			 if(x==0) {
			  if(p1 > p2 && p1 > p3 && p1 > p4){			  
				  Rg1++;
		            ganadorS="P1";	            
		        }else{
		            if(p2 > p1 && p2 > p3 && p2 > p4){
		            	Rg1++;
		                ganadorS="P2";
		            }else{
		                if(p3 > p1 && p3 > p2 && p3 > p4){
		                	Rg3++;
		                    ganadorS="P3";
		                }else {
		                	 if(p4 > p1 && p4 > p2 && p4 > p3){
		                	Rg4++;  
		                   ganadorS="P4";
		                	 }
		                }
		            }
		        }
			  
			  if((p1==p2&&p1>=p3&&p1>=p4) || (p1==p3&&p1>=p2&&p1>=p4)||(p1==p4&&p1>=p3&&p1>=p2)  || (p2==p3&&p2>=p1&&p2>=p4)||(p2==p4&&p2>=p3&&p2>=p1)   ||(p3==p4&&p3>=p1&&p3>=p2) ) {		  
				  ganadorS="Empate";	
				  		
				  
			  }
			 }
			  
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,14)); 
			  g.drawString("El ganador de la ronda [ "+(juegos+1)+" ] es: ", 680, 400); 
			  g.setColor(new Color(255, 255, 255));
			  g.setFont(new Font("times new roman",Font.BOLD,15)); 
			  g.drawString(ganadorS, 870, 400); 
			  		  
			  ImageIcon imagen = new ImageIcon(getClass().getResource("BarajaAtras.jpeg"));	
			  ImageIcon imagen1 = new ImageIcon(getClass().getResource("BarajaAtrasH.jpeg"));
			  ImageIcon i1 = new ImageIcon(getClass().getResource(CyF[a]));
			  ImageIcon i2 = new ImageIcon(getClass().getResource(CyF[a+9]));
			  ImageIcon i3 = new ImageIcon(getClass().getResource(CyF[a+19]));
			  ImageIcon i4 = new ImageIcon(getClass().getResource(CyF[a+29]));
			  		 
			  int am=170, amH=130;
			  for(int j=1;j<=x;j++) {	  	  
			  g2d.drawImage(imagen.getImage(), am, 500, 40, 70, this);
			  g2d.drawImage(imagen.getImage(), am, 50, 40, 70, this); 
	          g2d.drawImage(imagen1.getImage(), 50, amH, 70, 40, this);  
			  g2d.drawImage(imagen1.getImage(), 530, amH, 70, 40, this);			  
			  am=am+30;
			  amH=amH+30;
			  }  	  
			  if(x<10) {
			   g2d.drawImage(i4.getImage(), 220, 250, 60, 90, this);
			   g2d.drawImage(i3.getImage(), 300, 180, 60, 90, this);
			   g2d.drawImage(i2.getImage(), 380, 250, 60, 90, this);
			   g2d.drawImage(i1.getImage(), 300, 320, 60, 90, this);
			  }
			  		  
			} 
	   }
