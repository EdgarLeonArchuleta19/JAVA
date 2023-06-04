package GAUSSSEIDEL;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GS{
	
	static Scanner leer = new Scanner(System.in);	
	static DecimalFormat df = new DecimalFormat("#0.000000");	
 
    public static void main(String[] args) {
    	    	
    	   int N;
    	   double T_error=0;   	
    	
    	//Datos de presentación del programa
    	System.out.println("\t\t\tINSTITUTO TECNOLOGICO DE CULIACÁN	");
		System.out.println("\t\t\t\tING. DE SISTEMAS\n");
		System.out.println("Solución de Sistemas de ecuaciones");
		System.out.println("Jorge Luis Cañedo Lizarraga");
		System.out.println("Edgar Léon Archuleta ");
		System.out.println("Método de Gauss Seidel");
		System.out.println("De 10:00 a 11:00 horas");		
		System.out.println("\n\n=========================CAPTURA DE DATOS DEL PROBLEMA========================\n");
		System.out.print("¿Cuál es la pregunta del problema? "); 
		String pregunta = leer.nextLine();
		System.out.print("¿Cuál es la unidad de la solución? ");
		String unidad = leer.nextLine();
		
		//Se capturan los datos del sistema de ecuaciones
		int repeat=0;
		do {
			System.out.print("Número de incognitas (2-6):");
			N = leer.nextInt();
			if(N>=2&&N<=6) {
				break;
			}else {
				repeat=1;
				System.out.println("Error - valor fuera de rango");
			}
		}while(repeat==1);
		
	    double matriz[][]=new double[N+1][N+1];
	    double v1[]=new double[N];
	    double v2[]=new double[N];
	    String R[]=new String[N];
		
		
		
        System.out.print("Ingrese el total de calculos: ");
        int calculos=leer.nextInt();        
        System.out.print("Ingrese el error: ");
        double error=leer.nextDouble();           
        System.out.println();
        
        
        //Se piden los datos de la matriz del sistema de ecuaciones con 3 ciclos repetitivos
        for(int i=0;i<N;i++){
       	 System.out.print("Ingrese la representación del valor ["+(i+1)+"]: ");
           R[i]=leer.next();
       }
        
        System.out.println();
        for(int i=0;i<N;i++){
        	 System.out.print("Ingrese el valor inicial de la ecuación ["+(i+1)+"]: ");
            v1[i]=leer.nextDouble();
            v2[i]=v1[i];
        }
        
        System.out.println();    
        for(int i=0;i<N;i++){
            for(int j=0;j<=N;j++){
            	System.out.print("Ingrese el dato ["+(j+1)+"] de la ecuación ["+(i+1)+"]: ");
                matriz[i][j]=leer.nextDouble();
            }
        }      
     
        
        //Se ordenan los datos en la matriz para el sistema de ecuaciones
        for(int i=0;i<N;i++){
            for(int j=0;j<=N;j++){
                if(j<N && j!=i){ matriz[i][j]=-(matriz[i][j]/matriz[i][i]);
                }else if(j==N){ matriz[i][j]=(matriz[i][j]/matriz[i][i]);
                }
            }
            matriz[i][i]=0;
        }       
        
        //Se imprimen los datos de presentación para mostrar los resultados
        System.out.println("\n\n\t\t\tINSTITUTO TECNOLOGICO DE CULIACÁN	");
		System.out.println("\t\t\t\tING. DE SISTEMAS\n");
		System.out.println("Solución de Sistemas de ecuaciones");
		System.out.println("Jorge Luis Cañedo Lizarraga");
		System.out.println("Edgar Léon Archuleta ");
		System.out.println("Método de Gauss Seidel");
		System.out.println("De 10:00 a 11:00 horas");		
		System.out.println("\n\n=========================IMPRESIÓN DE DATOS DEL PROBLEMA========================\n");
        
		
		//Se imprimen los valores iniciales del problema
        System.out.println("\nPREGUNTA:"+pregunta);           
        System.out.print("\nNO.\t");
        for(int h=0;h<N;h++) {
      	  System.out.print(R[h]+"\t");
        }     
        System.out.println("ErrorTotal\n");
        System.out.print("0\t");        
        for(int j=0;j<N;j++){
          System.out.print(df.format(v1[j])+"\t");     
        }
          System.out.print(df.format(T_error)+"\n");
        

          
        
        out:
        for(int i=1;i<=calculos;i++){  
        	//se hacen los calculos para sacar el resultado con el metodo de gauss seidel
        	//Sustituyendo los viejos valores por nuevos
        	  for(int c=0;c<N;c++){
        	         double aux=0;
        	         for(int c2=0;c2<N;c2++){
        	             aux+=v1[c2]*matriz[c][c2];
        	         }
        	         aux+=matriz[c][N];
        	         v1[c]=aux;
        	     }  
            
            //Se hacen los calculos para sacar el Error total del metodo gauss seidel
        		double err[]=new double[N];  
        	 	T_error=0;   	
        	     for(int e=0;e<N;e++){                 	
        	         	err[e]=Math.abs(v1[e]-v2[e]);          	
        	         	T_error=T_error+err[e];        
        	     }   
            
            //Se imprimen los datos de la captura de datos
            System.out.print(i+"\t");          
            for(int j=0;j<N;j++){           	
                System.out.print(df.format(v1[j])+"\t");
                v2[j]=v1[j];       
            }
                        
            System.out.print(df.format(T_error)+"\n");       
            if(T_error<=error)break out;
                             
        }
        
        //Si el error es menor al error total se imprimen los resultados y si no significa que no se llego a la aproximación
        if(T_error<=error) {        	
        	 System.out.println("\n\nResultados del problema:\n");
             for(int k=0;k<N;k++) {
           	  System.out.println(R[k]+"\t= "+df.format(v1[k])+" "+unidad);
     		}
        
        
        }else { 
       	System.out.println("\nALERTA: El proceso supero el número de intentos\ny no encontro la mejor aproximación");
              
        }
    }
    
 

}