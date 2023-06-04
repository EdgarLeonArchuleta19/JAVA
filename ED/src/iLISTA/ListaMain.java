package iLISTA;



import java.util.Scanner;

public class ListaMain 
{
	public static void main(String[] args) 
	{
		Scanner leer = new Scanner(System.in);
		int Opcion=0;
		int m = 0,e=0, c=0;
		String n="";
		char s = 0;
       int cont=0;
		
	Lista lista = new Lista();
	
	
	
	lista.Insertar(1, "Edgar", 12, 50, 'h');
	lista.Insertar(2, "Ximena", 19, 70, 'f');
	lista.Insertar(3, "Dan", 28, 80, 'h');
	lista.Insertar(4, "Juan", 32, 90, 'h');
	lista.Insertar(5, "Diana", 10, 100, 'f');
	
	
		do {
			
			System.out.println();
			System.out.println("======Menu Lista======");
			System.out.println();
			System.out.println("Insertar - 1");
			System.out.println("Eliminar - 2");
			System.out.println("Vacio - 3");
			System.out.println("Mostrar - 4");
			System.out.println("Promedio general - 5");
			System.out.println("Aprobados - 6");
			System.out.println("Reprobados - 7");
			System.out.println("Mejor calificacion - 8");
			System.out.println("Mostrar Hombres - 9");
			System.out.println("Mostrar mujeres - 10");
			System.out.println("Mostrar de menor a mayor edad - 11");
			System.out.println("Salir - 0");
			System.out.println();
			System.out.print("Escoje tu opcion:");
			Opcion = leer.nextInt();
			
			switch(Opcion)
			{
			case 1:
				System.out.print("Ingresa la Matricula: ");
				m= leer.nextInt();
				System.out.print("Ingresa el Nombre: ");
				n= leer.next();
				System.out.print("Ingresa la Edad: ");
				e= leer.nextInt();
				System.out.print("Ingresa la Calificación: ");
				c= leer.nextInt();
				System.out.print("Ingresa el Sexo: ");
				s= leer.next().charAt(0);
				lista.Insertar(m,n,e,c,s);
				break;
			case 2:
				int elimina=0;
				System.out.println();
				System.out.print("Ingresa el nodo a eliminar: ");
				elimina=leer.nextInt();
				m=elimina;
				 
			     if(lista.Eliminar(m) != null) {
				System.out.println("Nodo Eliminado");
			     }
			     
				break;
			case 3:			
				System.out.println(lista.Vacio());
				break;
			case 4:			
				System.out.println("\n"+"===Lista===");
				lista.Mostrar();
				break;
				
			case 5:
				System.out.println(lista.promedioGeneral());
				System.out.println();
				break;
				
			case 6:
			lista.aprobados();
			System.out.println();
				break;
				
			case 7:
			lista.reprobados();	
			System.out.println();
				break;
				
			case 8:
			lista.mayorCalificacion();
			System.out.println();
				break;
				
			case 9:
			lista.hombres();	
			System.out.println();
				break;
				
			case 10:
			lista.mujeres();	
			System.out.println();
				break;	
			case 11:
				lista.menorALmayor();
			  
				System.out.println();
					break;	
			case 0:
				System.out.println("Haz salido del programa, Fin.");
				break;
			default:
				System.out.println("La opcion no es valida");
				break;
			}	
				
		}while(Opcion!=0);
		
	}

}
