package METODOSNUMERICOS;

import java.util.Scanner;

public class Newton_Rapshon {
		
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("        Instituto Tecnol�gico de Culiac�n");
		System.out.println("       Ingenieria en sistemas computacionales");
		
		System.out.println();
		
		System.out.println("M�todo de Newton Rapshon");	
		System.out.println("M�todos num�ricos");
		System.out.println("De 10:00 - 11:00 hrs.");
		
		System.out.println();
		
		System.out.println("Calcular las ra�ces m�ltiples de la Ecuaci�n f(x)= x Cosx2 -4, utilizando "
				+ "\nun rango de b�squeda de -50 a 50 en el eje de las x, con un error de "
				+ "\n0.001 para mejor aproximaci�n.");
		
		
        int n = 0;
        double x1 = -100;
        double error = 0.001;
        
        double fx1 = 0;
        double fdx1 = 0;
        
        double x2 = 0;
        double fx2 = 0;
        
        fx1 = x1 * Math.cos(x1 * x1) - 4;
        
        System.out.println("\nN      X1              Fx1          F'x1              X2            Fx2");
        
        do {
        	n++;
        	
        	fdx1 = -2*(x1*x1) * Math.sin(x1*x1) + Math.cos(x1*x1);           //-2x^2sin(x^2) + cos(x^2)
        	x2 = x1 - (fx1/fdx1);
        	
        	fx2 = x2 * Math.cos(x2 * x2) - 4;
        	
        	System.out.print(n);
        	System.out.printf("   %10.6f     %10.6f", x1, fx1);
        	System.out.printf("     %10.6f     %10.6f     %10.6f \n",fdx1, x2, fx2);
        	
        	if(Math.abs(fx2) > error && n <= 100)
        	{
        		x1=x2;
        		fx1=fx2;
        	}
        		else {
        	break;
        	}
        }
        while(Math.abs(fx2) <= error || n <= 100);
        
        if(n <= 50) {
        	System.out.println("\nLa raiz optima es: " + x2);
        }
     
	}
	

}
