package PRUEBAS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AdB extends JFrame{
	
	
	static double coorx[]=new double[10000000];
	static double coory[]=new double[10000000];
	static double Intentos=0,Exitos=0, pi=0,PextremoA=0,anguloAguja=0,FextremoA=0;
	static Scanner leer = new Scanner(System.in); 
	
	
	
	public AdB(){
        super("Dardos");
        setSize(600, 600);
        setVisible(true);
        JLabel titulo = new JLabel("Aguja de Buffon", JLabel.CENTER);
		add(titulo, BorderLayout.NORTH);
        JLabel etiqueta = new JLabel("El valor aproximado de PI es: "+pi, JLabel.CENTER);
		add(etiqueta, BorderLayout.SOUTH);
		
        
   }
	
	
	
	public static void lanzamiento() {

		Random random = new Random(42);
		for(int i=1;i<=Intentos;i++) {
		
		PextremoA = random.nextDouble()*2;
		System.out.println(PextremoA);
	    anguloAguja=random.nextDouble()*180;
	    FextremoA =PextremoA+Math.sin(Math.toRadians(anguloAguja));
	    System.out.println(FextremoA);
		
		
	    
	    coorx[i]=((PextremoA*200));
		coory[i]=((FextremoA*200));
		
		
		System.out.println("Aguja lanzada["+i+"]");
		
		
		if(FextremoA >=2) {
			Exitos++;	
			System.out.println("exito");
	    	} 
		
		
		}
		
	}
	
	
	
	
	public void paint(Graphics g){
	       super.paint(g);
	       
	      
	       g.setColor(Color.BLACK);
	       g.drawLine(0, 200, 600, 200); 
	       g.drawLine(0, 400, 600, 400);    
	       g.setColor(Color.black);
	 
	       for(int i=1;i<=Intentos;i++) {
	       
	       g.drawLine((int)coorx[i], (int)coory[i], (int)coorx[i]+15,(int)coory[i]+35);
	       g.setColor(Color.black);
	       
	       }
	       
	 }
	

	
	public static void main(String[] args){  

	
		do {
		System.out.println("====Sacar el valor estimado de PI con el metodo aguja de Buffon===\n");
		System.out.print("Ingresa agujas que deseas lanzar:");
		Intentos=leer.nextInt();
	    }while(Intentos>1000000);
			
		lanzamiento();
		
		pi=(Intentos/Exitos);
		System.out.println("\n"+"El valor aproximado de Pi es: "+pi);
		
		 AdB application = new AdB();
	     application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}	
}
