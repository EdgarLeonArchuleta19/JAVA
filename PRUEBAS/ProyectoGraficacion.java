package PRUEBAS;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class ProyectoGraficacion extends JFrame{

	public ProyectoGraficacion(){
        super("PROYECTO DE GRAFICACION");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
   }
	
	 public void paint(Graphics g){
	       super.paint(g);
	       super.paintComponents(g);
	       Graphics2D DIBUJO=(Graphics2D)g;
	       
	       //Fondo con degradado
		   DIBUJO.setPaint(new GradientPaint(300, 0, (new Color(106, 216, 239)), 300, 800, Color.WHITE));
		   DIBUJO.fillRect(0, 0, 600, 600);
		   
		   //Nubes
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(43, 280, 29, 31, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(64, 277, 36, 37, 0,180);
		   
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(147, 208, 20, 18, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(164, 200, 42, 32, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(198, 202, 25, 36, 0,180);
		   
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(175, 48, 33, 33, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(204, 42, 48, 45, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(247, 55, 19, 19, 0,180);
		   
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(63, 146, 26, 24, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(85, 140, 38, 36, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(115, 145, 21, 26, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(132, 143, 32, 30, 0,180);
		  
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(431, 92, 24, 25, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(450, 82, 40, 45, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(482, 80, 47, 49, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(520, 89, 31, 31, 0,180);
		   
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(380, 172, 33, 27, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(406, 167, 40, 37, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(442, 170, 32, 31, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(470, 173, 22, 25, 0,180);
		    
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(521, 270, 19, 17, 0,180);
		   g.setColor(new Color(209, 255, 251));
		   g.fillArc(536, 266, 27, 25, 0,180);
		   
		   //Pasto
		   g.setColor(new Color(163, 220, 83));
		   g.fillRect(0,467,600,133);
		   
		   
		 //                                 ---Edificios de atras---
		   
		   //Edificio izquieda en medio azul
		   g.setColor(new Color(100, 178, 188));
		   g.fillRect(212,160,68,185);
		   int ima=160;
		   for(int i=0;i<4;i++) {
		   g.setColor(new Color(67, 149, 163)); 
		   g.fillRect(212,ima,68,13);
		   ima=ima+41;
		   }
		   g.setColor(new Color(27, 120, 139));
		   g.fillRect(255,189,29,152);
		   
		   //Edificio derecha azul fondo
		   g.setColor(new Color(77, 206, 199));
		   g.fillRect(427,213,81,88);
		   int ia=440;
		   for(int i=0;i<3;i++) {
		   g.setColor(new Color(96, 177, 186)); 
		   g.fillRect(ia,213,14,82);
		   ia=ia+27;
		   }
		   g.setColor(new Color(29, 119, 136));
		   g.fillRect(457,266,24,32);
		   
		   
		   //Edificio izquierda azul
		   g.setColor(new Color(100, 178, 188));
		   g.fillRect(45,333,41,137);
		   int ea=333;
		   for(int i=0;i<5;i++) {
		   g.setColor(new Color(67, 149, 163)); 
		   g.fillRect(45,ea,41,13);
		   ea=ea+28;
		   }
		   g.setColor(new Color(27, 120, 139));
		   g.fillRect(77,333,9,137);
		   
		   //Edificio derecha rojo
		   g.setColor(new Color(242, 107, 107));
		   g.fillRect(457,294,99,177);
		   int dr=306;
		   for(int i=0;i<4;i++) {
		   g.setColor(new Color(77, 206, 197)); 
		   g.fillRect(467,dr,89,27);
		   dr=dr+41;
		   }
		   g.setColor(new Color(195, 80, 89));
		   g.fillRect(457,294,10,85);
	 
		   
		   //Edificio izquierda rojo
		   g.setColor(new Color(195, 80, 89));
		   g.fillRoundRect(86, 216, 126, 185, 15, 15);	   
		   g.setColor(new Color(242, 107, 107));
		   g.fillRoundRect(86, 216, 100, 185, 15, 15); 		   
		   g.setColor(new Color(242, 107, 107));
		   g.fillRoundRect(82, 216, 100, 21, 25, 25); 	   
		   g.setColor(new Color(242, 107, 107));
		   g.fillRect(82, 229, 103, 7);	   
		   g.setColor(new Color(195, 80, 89));
		   g.fillRect(94, 235, 79, 3);
		   g.setColor(new Color(195, 80, 89));
		   g.fillRect(83, 235, 120, 2);
		   
		   int izr=249,izr2=102;
		   for(int i=0;i<5;i++) {
		   g.setColor(new Color(77, 206, 197)); 
		   g.fillRoundRect(102,izr,19,19,3,3);
		   izr=izr+26;
		   }
		   for(int i=0;i<3;i++) {
		   g.setColor(new Color(77, 206, 197)); 
		   g.fillRoundRect(izr2,249,19,19,3,3);
		   g.setColor(new Color(77, 206, 197)); 
		   g.fillRoundRect(izr2,275,19,19,3,3);
		   izr2=izr2+26;
		   }
		  
		   
		   //Edificio izquierda blaco
		   g.setColor(new Color(255,255,255));
		   g.fillRoundRect(125, 295, 125, 127, 15, 15);
		   g.setColor(new Color(201, 204, 209));
		   g.fillRoundRect(155,295,100,90,15,15);
	       int ib=305;
		   for(int i=0;i<5;i++) {
			   g.setColor(new Color(67, 149, 163)); 
			   g.fillRect(160,ib,88,16);
			   ib=ib+25;
			   }
		   
		   //Edificio platino derecha
		   g.setColor(new Color(193, 232, 217));
		   g.fillRect(384,238,72,154);
		   int pd=250;
		   for(int i=0;i<5;i++) {
			   g.setColor(new Color(79, 204, 198)); 
			   g.fillRoundRect(399,pd,19,19,2,2);
			   g.setColor(new Color(79, 204, 198)); 
			   g.fillRoundRect(425,pd,19,19,2,2);
			   pd=pd+28;
			   }
		   g.setColor(new Color(67, 149, 163));
		   g.fillRect(384,238,15,103);
		   
		   //Edificio largo del medio
		   g.setColor(new Color(205, 204, 202));
		   g.fillRoundRect(279,89,107,13,15,15);
		   g.setColor(new Color(255, 255, 255));
		   g.fillRoundRect(289,82,88,12,15,15);
		   g.setColor(new Color(121, 220, 241 ));
		   g.fillRect(279,75,107,13);
		   
		   g.setColor(new Color(255,255,255));
		   g.fillRect(281,98,103,243);
		   g.setColor(new Color(100, 178, 188)); 
		   g.fillRect(289,104,87,227);
		   
		   g.setColor(new Color(67, 149, 163)); int [] m7 = {289,325,289}; 	int [] m8 = {104,104,142};
		   g.fillPolygon (m7, m8, 3);
		   g.setColor(new Color(67, 149, 163));  int [] m5 = {376,376,289,289};   int [] m6 = {117,183,270,203};
		   g.fillPolygon (m5, m6, 4);
		   g.setColor(new Color(67, 149, 163)); int [] m1 = {376,376,301,289,289};   int [] m2 = {224,251,331,331,309};
		   g.fillPolygon (m1, m2, 5);
		   g.setColor(new Color(67, 149, 163));  int [] m3 = {376,376,319};  int [] m4 = {331,270,331};
		   g.fillPolygon (m3, m4, 3);
		   
		   int lm=126,lm2=121;
		   for(int i=0;i<8;i++) {   
		   g.setColor(new Color(205, 204, 202)); 
		   g.fillRect(278,lm2,109,5);
		   g.setColor(new Color(255, 255, 255)); 
		   g.fillRect(289,lm,95,5);
		   lm=lm+30;
		   lm2=lm2+30;
		   }
		 	   
	       //Edificios del medio
		   g.setColor(new Color(229, 169, 101));
		   g.fillRect(188,373,225,104);
		   g.setColor(new Color(229, 169, 101));
		   g.fillRect(86,391,102,86);
		   g.setColor(new Color(229, 169, 101));
		   g.fillRect(413,391,102,86);
		   
		   //Fondos de edificios
		   g.setColor(new Color(100, 178, 188));
		   g.fillRect(199,373,204,97);
		   g.setColor(new Color(100, 178, 188));
		   g.fillRect(94,391,94,79);
		   g.setColor(new Color(100, 178, 188));
		   g.fillRect(412,391,94,79);
		   
		   //Sombras de los fondos del edificio
		   g.setColor(new Color(67, 149, 163));  int [] s1 = {128,160,103,94,94};  int [] s2 = {400,400,470,470,444};
		   g.fillPolygon (s1, s2, 5);
		   g.setColor(new Color(67, 149, 163)); int [] s3 = {226,250,174,149};  int [] s4 = {380,380,470,470};
		   g.fillPolygon (s3, s4, 4);
		   g.setColor(new Color(67, 149, 163)); int [] s5 = {311,335,262,238}; int [] s6 = {380,380,470,470};
		   g.fillPolygon (s5, s6, 4); 
		   g.setColor(new Color(67, 149, 163)); int [] s7 = {358,376,303,285}; int [] s8 = {380,380,470,470};
		   g.fillPolygon (s7, s8, 4);
	       g.setColor(new Color(67, 149, 163)); int [] s9 = {416,440,374,350}; int [] s10 = {380,380,470,470};
		   g.fillPolygon (s9, s10, 4); 
		   g.setColor(new Color(67, 149, 163)); int [] s11 = {489,506,506,464,432}; int [] s12 = {400,400,416,470,470};
		   g.fillPolygon (s11, s12, 5);	   
		   g.setColor(new Color(67, 149, 163)); int [] s13 = {506,506,484}; int [] s14 = {445,470,470};
		   g.fillPolygon (s13, s14, 3);	   
		   g.setColor(new Color(229, 169, 101));
		   g.fillRect(188,412,11,42);
		   g.setColor(new Color(229, 169, 101));
		   g.fillRect(403,388,9,42);
		   
		   
		   
		   //Cortinas de blaco y rojo
		   int p=196,iz=92,d=412;
		   for(int i=0;i<13;i++) { 
		   g.setColor(new Color(40, 113, 139));
		   g.fillOval(p, 382, 8, 5);
		   g.setColor(new Color(255,255,255));
		   g.fillRect(p,373,8,9);
		   g.setColor(new Color(255,255,255));
		   g.fillOval(p, 379, 8, 5);
		   p=p+8;
		   g.setColor(new Color(40, 113, 139));
		   g.fillOval(p, 382, 8, 5);
		   g.setColor(new Color(198, 77, 93));
		   g.fillRect(p,373,8,9);
		   g.setColor(new Color(198, 77, 93));
		   g.fillOval(p, 379, 8, 5);
		   p=p+8;
		   }
		   g.setColor(new Color(0, 0, 0,100));
		   g.fillRect(188,372,225,4);
		  
		   for(int i=0;i<6;i++) { 
		   g.setColor(new Color(40, 113, 139));
		   g.fillOval(iz, 400, 8, 5);
		   g.setColor(new Color(255,255,255));
		   g.fillRect(iz,390,8,9);
		   g.setColor(new Color(255,255,255));
		   g.fillOval(iz, 397, 8, 5);
		   iz=iz+8;
		   g.setColor(new Color(40, 113, 139));
		   g.fillOval(iz, 400, 8, 5);
		   g.setColor(new Color(198, 77, 93));
		   g.fillRect(iz,390,8,9);
		   g.setColor(new Color(198, 77, 93));
		   g.fillOval(iz, 397, 8, 5);
		   
		   iz=iz+8;
		   
		   }   
		   g.setColor(new Color(0, 0, 0,100));
		   g.fillRect(86,390,102,3);
		   
		   for(int i=0;i<6;i++) { 
			   g.setColor(new Color(40, 113, 139));
			   g.fillOval(d, 400, 8, 5);
			   g.setColor(new Color(198, 77, 93));
			   g.fillRect(d,390,8,9);
			   g.setColor(new Color(198, 77, 93));
			   g.fillOval(d, 397, 8, 5);
			   d=d+8;
			   g.setColor(new Color(40, 113, 139));
			   g.fillOval(d, 400, 8, 5);
			   g.setColor(new Color(255,255,255));
			   g.fillRect(d,390,8,9);
			   g.setColor(new Color(255,255,255));
			   g.fillOval(d, 397, 8, 5);
			   d=d+8;
			   }     
		   g.setColor(new Color(0, 0, 0,100));
		   g.fillRect(412,390,103,3);
		   
		   //Puerta y marcos blancos(Edificio del medio) 
		   g.setColor(new Color(117, 62, 35,150));
		   g.drawRect(259,394,81,77);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(84,434,177,1);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(339,434,177,1);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(84,441,177,1);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(339,441,177,1);
		    
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(93,402,1,80);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(187,391,1,80);
		   
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(198,387,2,80);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(401,387,2,83);
		   
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(505,402,1,80);
		   g.setColor(new Color(117, 62, 35,150));
		   g.fillRect(412,391,1,80);
		   
		   
		   g.setColor(new Color(255,255,255,200));
		   g.drawRect(260,395,78,74);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(84,435,177,6);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(339,435,177,6);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(260,436,78,2);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(297,395,4,74);
		   g.setColor(new Color(117, 62, 35,50));
		   g.fillRect(298,395,1,74);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(278,395,2,74);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(318,395,2,74);
		   
		   //Botones de la puerta
		   g.setColor(new Color(255,255,255));
		   g.fillRect(345,410,7,4);
		   g.setColor(new Color(0,0,0));
		   g.fillRect(346,411,5,2);
		 
		   g.setColor(new Color(255,255,255));
		   g.fillRect(345,416,5,5);
		   g.setColor(new Color(229, 169, 101));
		   g.fillRect(346,417,3,3);
		   
		   g.setColor(new Color(255,255,255));
		   g.fillRect(345,423,5,5);
		   g.setColor(new Color(0,0,0));
		   g.fillRect(346,424,3,3);
		   
		   //Ceras marron
		   g.setColor(new Color(117, 62, 35));
		   g.fillRect(85,470,174,9);
		   g.setColor(new Color(117, 62, 35));
		   g.fillRect(339,470,177,9); 
		   
		   
		   //Cartel de afuera
		   g.setColor(new Color(183, 174, 188  ));  int [] c1= {196,227,235,188};  int [] c2= {437,437,481,481};
		   g.fillPolygon (c1, c2, 4);   
		   g.setColor(new Color(43, 40, 57));  int [] c3= {197,203,190};  int [] c4= {445,481,481};
		   g.fillPolygon (c3, c4, 3);	   
		   g.setColor(new Color(241, 243, 246));  int [] c5= {199,227,235,208};  int [] c6= {437,437,482,482};
		   g.fillPolygon (c5, c6, 4);		   
		   g.setColor(new Color(255, 215, 71));  int [] c7= {202,225,231,210}; 	 int [] c8= {440,440,477,477};
		   g.fillPolygon (c7, c8, 4);		   
		   g.setColor(new Color(193, 74, 82)); 
		   g.fillRect(206,444,17,6);
		   
		   int ca=208,ca2=453;
		   for(int i=0;i<4;i++) {   
		   g.setColor(new Color(193, 74, 82)); 
		   g.fillRect(ca,ca2,17,3);
		   ca=ca+1;
		   ca2=ca2+5;
		   }
		   
		   //Cartel del medio
		   g.setColor(new Color(43, 40, 57));
		   g.fillRoundRect(184, 340, 232, 33, 10, 10);
		   g.setColor(new Color(255, 215, 71));
		   g.setFont(new Font("arial",Font.BOLD,19)); 
		   g.drawString("SUPERMARKET", 227, 365); 
		   g.setColor(new Color(109, 107, 105));
		   g.drawRoundRect(187,344,225,26,8,8);	   
		   g.setColor(new Color(109, 107, 105));
		   g.drawLine(213,344,213,370);	   
		   g.setColor(new Color(109, 107, 105));
		   g.drawLine(386,344,386,370);	   
		   g.setColor(new Color(255, 215, 71)); int [] x1 = {200,194,206}; int [] y1 = {350,356,356};
		   g.fillPolygon (x1, y1, 3);
		   g.setColor(new Color(255, 215, 71)); int [] x2 = {200,194,206}; int [] y2 = {362,356,356};
		   g.fillPolygon (x2, y2, 3);	   
		   g.setColor(new Color(255, 215, 71)); int [] x3 = {400,394,406}; int [] y3 = {350,356,356};
		   g.fillPolygon (x3, y3, 3);
		   g.setColor(new Color(255, 215, 71)); int [] x4 = {400,394,406}; int [] y4 = {362,356,356};
		   g.fillPolygon (x4, y4, 3);
		  
		   //Carteles de los lados
		   g.setColor(new Color(43, 40, 57));
		   g.fillRoundRect(82, 379, 107, 12, 5, 5);
		   g.setColor(new Color(43, 40, 57));
		   g.fillRoundRect(411, 379, 107, 12, 5, 5);
		   
		   g.setColor(new Color(109, 107, 105));
		   g.drawRoundRect(84,381,104,8,8,8);
		   
		   g.setColor(new Color(109, 107, 105));
		   g.drawRoundRect(413,381,104,8,8,8);
		  
		   //Calle
		   g.setColor(new Color(132,129,130));
		   g.fillRect(1,485,600,85);
		   g.setColor(new Color(94, 109, 70));
		   g.drawLine(1,570,600,570);
		   g.setColor(new Color(255,255,255));
		   g.drawLine(1,540,600,540);
		   
		   //Entrada en calle
		   g.setColor(new Color(132,129,130));
		   g.fillRect(259,470,80,23);
		   g.setColor(new Color(84, 82, 83 ));
		   g.fillRect(259,474,80,4);
		   g.setColor(new Color(84, 82, 83 ));
		   g.fillRect(259,482,80,4);
		   
		   //Lineas con 3 colores
		   g.setColor(new Color(169, 171, 177));
		   g.fillRect(1,504,258,8);
		   g.setColor(new Color(43, 40, 57,200));
		   g.drawLine(1,513,258,513);
		   g.setColor(new Color(255,255,255,200));
		   g.drawLine(1,505,258,505);
		   
		   g.setColor(new Color(169, 171, 177));
		   g.fillRect(339,504,260,8);
		   g.setColor(new Color(43, 40, 57,200));
		   g.drawLine(340,513,600,513);
		   g.setColor(new Color(255,255,255,200));
		   g.drawLine(340,505,600,505);
		     
		   g.setColor(new Color(169, 171, 177));
		   g.fillRect(1,479,258,8);
		   g.setColor(new Color(43, 40, 57,200));
		   g.drawLine(1,488,258,488);
		   g.setColor(new Color(255,255,255,200));
		   g.drawLine(1,480,258,480);
		   
		   g.setColor(new Color(169, 171, 177));
		   g.fillRect(339,479,260,8);
		   g.setColor(new Color(43, 40, 57,200));
		   g.drawLine(340,488,600,488);
		   g.setColor(new Color(255,255,255,200));
		   g.drawLine(340,480,600,480);
		   
		   
		   //Lineas "t" invertidas
	       g.setColor(new Color(255,255,255,200));
		   g.fillRect(28,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(26,494,7,3);  
		     
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(80,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(78,494,7,3); 
		   
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(134,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(132,494,7,3); 
		   
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(188,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(186,494,7,3); 

		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(242,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(240,494,7,3);
		   
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(354,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(352,494,7,3);  
		     
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(408,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(406,494,7,3); 
		   
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(462,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(460,494,7,3); 
		   
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(516,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(514,494,7,3); 

		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(570,488,3,8);
		   g.setColor(new Color(255,255,255,200));
		   g.fillRect(568,494,7,3); 
		 
		   //Carro amarillo
		   g.setColor(new Color(255, 215, 71));
           g.fillArc(37, 481, 105, 57, 0,180);
		   g.setColor(new Color(255, 215, 71));
		   g.fillRoundRect(38, 498, 125, 26, 20, 20);
		   g.setColor(new Color(255, 215, 71));
		   g.fillArc(130, 498, 42, 26, 270,180);
		   g.setColor(new Color(242, 107, 107)); 
		   g.fillRoundRect(37,506,6,9,8,8);
		   g.setColor(new Color(43, 40, 57)); 
		   g.fillRect(69,504,6,2);
		   g.setColor(new Color(43, 40, 57)); 
		   g.fillRect(97,504,6,2);
		   
		   g.setColor(new Color(100, 178, 188));
		   g.fillArc(68, 484, 54, 30, 90,-90);
		   g.setColor(new Color(100, 178, 188));
		   g.fillArc(64, 484, 48, 30, 180, -90);
		   
		   g.setColor(new Color(230, 170, 102)); 
		   g.fillRect(39,517,129,5);
		   g.setColor(new Color(230, 170, 102)); 
		   g.fillRoundRect(39,517,129,7,5,5);
		   g.setColor(new Color(110, 82, 78));
		   g.fillArc(45, 510, 29, 31, 180, -180);
		   g.setColor(new Color(110, 82, 78));
		   g.fillArc(131, 510, 29, 31, 180, -180);
		   
		   g.setColor(new Color(43, 40, 57));
		   g.fillOval(49, 513, 21, 21);
		   g.setColor(new Color(43, 40, 57));
		   g.fillOval(135, 513, 21, 21);
		   
		   g.setColor(new Color(167, 168, 186));
		   g.fillOval(53, 517, 13, 13);
		   g.setColor(new Color(167, 168, 186));
		   g.fillOval(139, 517, 13, 13);
		   
		   g.setColor(new Color(255, 255, 255));
		   g.fillRoundRect(161,507,10,4,5,5);
		
		   //Carro rojo
		   g.setColor(new Color(242, 107, 107));
           g.fillArc(407, 515, 91, 38, 0,180);
           g.setColor(new Color(242, 107, 107));
           g.fillRoundRect(413,525,94,30,10,10);
           g.setColor(new Color(242, 107, 107));
		   g.fillOval(379, 530, 54, 24);
		   g.setColor(new Color(43, 40, 57)); 
		   g.fillRect(443,535,6,2);
		   g.setColor(new Color(43, 40, 57)); 
		   g.fillRect(473,535,6,2);	   
		   g.setColor(new Color(193, 74, 82)); 
		   g.fillRoundRect(500,532,6,9,8,8);
		   g.setColor(new Color(242, 107, 107));
		   g.fillOval(400, 526, 44, 15);
		   g.setColor(new Color(242, 107, 107)); 
		   g.fillRoundRect(378,541,122,13,8,8);
		   g.setColor(new Color(193, 74, 82)); 
		   g.fillRoundRect(378,547,130,10,25,5);		   
		   g.setColor(new Color(100, 178, 188));
		   g.fillArc(428, 520, 54, 25, 90,-90);
		   g.setColor(new Color(100, 178, 188));
		   g.fillArc(421, 520, 58, 25, 180, -90);		   
		   g.setColor(new Color(110, 82, 78));
		   g.fillArc(391, 541, 29, 31, 180, -180);
		   g.setColor(new Color(110, 82, 78));
		   g.fillArc(476, 541, 29, 31, 180, -180);	   
		   g.setColor(new Color(43, 40, 57));
		   g.fillOval(395, 545, 21, 21);
		   g.setColor(new Color(43, 40, 57));
		   g.fillOval(480, 545, 21, 21);		   
		   g.setColor(new Color(167, 168, 186));
		   g.fillOval(399, 549, 13, 13);
		   g.setColor(new Color(167, 168, 186));
		   g.fillOval(484, 549, 13, 13);
		   g.setColor(new Color(255, 255, 255));
		   g.fillRoundRect(379,540,10,4,5,5);
		   
	       //Tres aboles de la calle
		   g.setColor(new Color(141, 198, 60));
		   g.fillRoundRect(80, 555, 105, 33, 15, 15);
		   g.setColor(new Color(163, 220, 83));
		   g.fillRoundRect(80, 555, 105, 28, 15, 15);
		   
		   g.setColor(new Color(141, 198, 60));
		   g.fillRoundRect(247, 555, 105, 33, 15, 15);
		   g.setColor(new Color(163, 220, 83));
		   g.fillRoundRect(247, 555, 105, 28, 15, 15);
		   
		   g.setColor(new Color(141, 198, 60));
		   g.fillRoundRect(414, 555, 105, 33, 15, 15);
		   g.setColor(new Color(163, 220, 83));
		   g.fillRoundRect(414, 555, 105, 28, 15, 15);
		   
		   g.setColor(new Color(141, 198, 60));
		   g.fillRect(133,560,30,20);
		   g.setColor(new Color(141, 198, 60));
		   g.fillRoundRect(158, 560, 20, 20, 10, 10);
		   g.setColor(new Color(141, 198, 60));
		   g.fillRect(300,560,30,20);
		   g.setColor(new Color(141, 198, 60));
		   g.fillRoundRect(325, 560, 20, 20, 10, 10);
		   g.setColor(new Color(141, 198, 60));
		   g.fillRect(467,560,30,20);
		   g.setColor(new Color(141, 198, 60));
		   g.fillRoundRect(492, 560, 20, 20, 10, 10);
		   
		   
		   //Arboles
	       g.setColor(new Color(117, 62, 35));
		   g.fillRect(43,458,5,22);
		   g.setColor(new Color(117, 62, 35));
		   g.fillRect(553,458,5,22);
		   
		   g.setColor(new Color(163, 220, 83));
		   g.fillArc(19, 406, 52, 52, -270,180);
		   g.setColor(new Color(141, 198, 60));
		   g.fillArc(19, 406, 52, 52,270,180);
		   
		   g.setColor(new Color(163, 220, 83));
		   g.fillArc(35, 367, 19, 40, -270,180);
		   g.setColor(new Color(141, 198, 60));
		   g.fillArc(35, 367, 19, 40,270,180);
		   
		   g.setColor(new Color(141, 198, 60));  int [] a1 = {45,53,68};   int [] a2 = {406,377,421};
		   g.fillPolygon (a1, a2, 3);
		   
		   g.setColor(new Color(163, 220, 83));  int [] a3 = {44,37,22};	 int [] a4 = {406,377,421};
		   g.fillPolygon (a3, a4, 3);
		   
		   g.setColor(new Color(163, 220, 83));
		   g.fillArc(530, 406, 52, 52, -270,180);
		   g.setColor(new Color(141, 198, 60));
		   g.fillArc(530, 406, 52, 52,270,180);
		   
		   g.setColor(new Color(163, 220, 83));
		   g.fillArc(546, 367, 19, 40, -270,180);
		   g.setColor(new Color(141, 198, 60));
		   g.fillArc(546, 367, 19, 40,270,180);
	       
		   g.setColor(new Color(141, 198, 60)); int [] a5 = {557,564,580}; int [] a6 = {406,377,421};
		   g.fillPolygon (a5, a6, 3);
		   g.setColor(new Color(163, 220, 83)); int [] a7 = {556,547,532}; int [] a8 = {406,377,421};
		   g.fillPolygon (a7, a8, 3);
	   
	 }
	
	public static void main(String[] args){  	
	      new ProyectoGraficacion();			
	}
}