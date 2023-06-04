package GAUSSSEIDEL;

import java.text.DecimalFormat;
import java.util.Scanner;

public class demo{
	
	static Scanner leer = new Scanner(System.in);	
	static DecimalFormat df = new DecimalFormat("#0.000000");	
    final static int Tama�o=7;
    static double matriz[][]=new double[Tama�o][Tama�o];
    static double x1[]=new double[Tama�o];
    static double x2[]=new double[Tama�o];
    static String TU[]=new String[Tama�o];
    static int N;
	static double T_error=0;
     



    
    public static void main(String[] args) {
    	
    	System.out.println("\t\t\tInstituto Tecnologico de Culiac�n");
		System.out.println("\t\tIng. en Sistemas computacionales\n");
		System.out.println("Soluci�n de Sistemas de ecuaciones");
		System.out.println("Edgar L�on Archuleta y Jorge Luis Ca�edo Lizarraga");
		System.out.println("M�todo de Gauss Seidel");
		System.out.println("De 10:00 a 11:00 horas");		
		System.out.println("\n\n==================CAPTURA DE DATOS DEL PROBLEMA=================\n");
		System.out.print("�Cu�l es la pregunta del problema? "); 
		String problema = leer.nextLine();
		System.out.print("�Cu�l es la unidad de la soluci�n? ");
		String unidad = leer.nextLine();
		
		do {
			System.out.print("N�mero de incognitas (2-6):");
			N = leer.nextInt();
			if(N>=2&&N<=6) {
				break;
			}else {
				System.out.println("Error - valor fuera de rango");
			}
		}while(true);
		
		
        System.out.print("Ingrese el total de calculos: ");
        int calculos=leer.nextInt();        
        System.out.print("Ingrese el error: ");
        double error=leer.nextDouble();
        
           
        System.out.println();
        
        
        
        for(int i=0;i<N;i++){
       	 System.out.print("Ingrese la representaci�n del valor ["+(i+1)+"]: ");
           TU[i]=leer.next();
       }
        System.out.println();
        for(int i=0;i<N;i++){
        	 System.out.print("Ingrese el valor inicial de la ecuaci�n ["+(i+1)+"]: ");
            x1[i]=leer.nextDouble();
            x2[i]=x1[i];
        }
        System.out.println();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<=N;j++){
            	System.out.print("Ingrese el dato ["+(j+1)+"] de la ecuaci�n ["+(i+1)+"]: ");
                matriz[i][j]=leer.nextDouble();
            }
        }      
     
        
        
        for(int i=0;i<N;i++){
            for(int j=0;j<=N;j++){
                if(j<N&&j!=i){
                    matriz[i][j]=-(matriz[i][j]/matriz[i][i]);
                }else if(j==N){
                    matriz[i][j]=(matriz[i][j]/matriz[i][i]);
                }
            }
            matriz[i][i]=0;
        }       
        
        
        System.out.println("\n\n\t\t\tInstituto Tecnologico de Culiac�n");
		System.out.println("\t\tIng. en Sistemas computacionales\n");
		System.out.println("Soluci�n de Sistemas de ecuaciones");
		System.out.println("Edgar L�on Archuleta y Jorge Luis Ca�edo Lizarraga");
		System.out.println("M�todo de Gauss Seidel");
		System.out.println("De 10:00 a 11:00 horas");		
		System.out.println("\n\n==================IMPRESI�N DE DATOS DEL PROBLEMA=================\n");
        
        System.out.println("\nPREGUNTA:"+problema);           
        System.out.print("\nNO.\t");
        for(int h=0;h<N;h++) {
      	  System.out.print(TU[h]+"\t\t");
        }     
        System.out.println("ErrorTotal\n");
        System.out.print("0\t");
        
        
        for(int j=0;j<N;j++){
          System.out.print(df.format(x1[j])+"\t");     
        }
          System.out.print(df.format(T_error)+"\n");
        

        out:
        for(int i=1;i<=calculos;i++){  
        	
        	  for(int c=0;c<N;c++){
        	         double aux=0;
        	         for(int c2=0;c2<N;c2++){
        	             aux+=x1[c2]*matriz[c][c2];
        	         }
        	         aux+=matriz[c][N];
        	         x1[c]=aux;
        	     }  
            
            
        		double err[]=new double[Tama�o];  
        	 	T_error=0;   	
        	     for(int e=0;e<N;e++){                 	
        	         	err[e]=Math.abs(x1[e]-x2[e]);          	
        	         	T_error=T_error+err[e];        
        	     }   
            
            
            System.out.print(i+"\t");
            
            for(int j=0;j<N;j++){           	
                System.out.print(df.format(x1[j])+"\t");
                x2[j]=x1[j];       
            }
                        
            System.out.print(df.format(T_error)+"\n");       
            if(T_error<=error)break out;
                             
        }
        
        
        if(T_error<=error) {
        	
        	 System.out.println("\n\nResultados del problema:\n");
             for(int k=0;k<N;k++) {
           	  System.out.println(TU[k]+" = "+df.format(x1[k])+" "+unidad);
     		}
        
        
        }else { 
       	System.out.println("\nALERTA: El proceso supero el n�mero de intentos\ny no encontro la mejor aproximaci�n");
              
        }
    }
    
 

}