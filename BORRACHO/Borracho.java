package BORRACHO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Borracho extends JPanel {

	static Scanner in = new Scanner(System.in);
    static Random random = new Random();
        
    static double tries=0;
    static DecimalFormat df = new DecimalFormat("#0.000000"); 
    static ArrayList<Integer> coor_x = new ArrayList<Integer>();
    static ArrayList<Integer> coor_y = new ArrayList<Integer>();
    
    
   
	   public static void main(String[]args){

		       camino();
		       JFrame ventana = new JFrame("Plano cartesiano");
		       Borracho Objeto = new Borracho();
		       ventana.add(Objeto);
		       ventana.setSize(500,500);
		       ventana.setLocationRelativeTo(null);
		       ventana.setVisible(true);
		       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
	   }
	   

	   
	   public void paint(Graphics g){
		   super.paint(g);
	       super.paintComponents(g);
	       Graphics2D g2d=(Graphics2D)g;
	      
		   int a=-9,b=3;
		   for(int j=1;j<=50;j++) { 
			   
			   g.setColor(new Color(74, 75, 73,100));
			   g.fillRect(0,a,500,1);
			   g.setColor(new Color(74, 75, 73,100));
			   g.fillRect(b,0,1,500);
			   a=a+20;
			   b=b+20;
		   }
		   
		   
		   g.setColor(new Color(0,0,0));
		   g.fillRect(243,0,3,500);
		   g.setColor(new Color(0, 0, 0));
		   g.fillRect(0,230,500,3);
		      
		   for(int p=0;p<tries;p++) {
			  
                         BasicStroke grosor= new BasicStroke(6);
                         g2d.setStroke(grosor);
                       
			   g2d.setPaint(Color.RED);
			   g2d.drawLine(20*coor_x.get(p)+245,-20*coor_y.get(p)+231,20*coor_x.get(p)+245,-20*coor_y.get(p)+231);
			   
			  
	   
		   }
		   
		   
		   
		   
		   
		   
	   }
	   
	   
	   
	   public static void camino() {
		   tries=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de juegos"));
		   int x=0,y=0, c=0;
		   double e=0;
		   String exito="";
		   
		   for(int j=0;j<tries;j++) {
               System.out.println("-------------------------------------------------------------------------");
			   System.out.println("N\t#de cuadras\t#alegen\t\tLocalizacion(x,y)\tExito?" );
			   System.out.print(j+1);
			   for(int i=0;i<=9;i++){	   
		             double direccion =random.nextDouble()*1;
		   
		   if(direccion>=0 && direccion< 0.25) y=y+1; 
		   if(direccion>0.25 && direccion< 0.50) y=y-1;
		   if(direccion>0.50 && direccion< 0.75) x=x+1;
		   if(direccion>0.75 && direccion<= 1) x=x-1;
	 
		   System.out.print("\t\n"+"\t"+(i+1)+"\t\t"+df.format(direccion)+"\t ("+x+","+y+")");
	
			   }
			   
			   
			   
			   coor_x.add(x);
			   coor_y.add(y);
			   c= Math.abs(x)+Math.abs(y);
   
			   if(c>=2){
				   exito="si";
				   e++;
	           }
	           else{
	               exito="no";
	           }

			   System.out.println("\t\t\t"+exito);
	           x=0;y=0;
			   }
		   
		      double p=(e/tries)*100;
		      System.out.println("\n\nLa probabilidad que el borracho quede mayor a dos cuadras es de: "+p+"%");
   
	   }	 
 
	   
	   
}
