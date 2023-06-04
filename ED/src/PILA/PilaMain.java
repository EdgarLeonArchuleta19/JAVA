
//HECHO POR EDGAR LEON ARCHULETA Y ANGEL FELIX ESPINOZA

package PILA;

import java.util.Scanner;

public class PilaMain {

	public static <T> void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int Opcion=0;
		Pila<T> pila = new Pila<T>(5);
	
		do {
			
			System.out.println();
			System.out.println("------Menu de una Pila------");
			System.out.println("Insertar - 1");
			System.out.println("Eliminar - 2");
			System.out.println("Llena - 3");
			System.out.println("Vacia - 4");
			System.out.println("Mostrar - 5");
			System.out.println("Salir - 0");
			System.out.println();
			System.out.print("Escoje tu opcion:");
			Opcion = leer.nextInt();
			
			switch(Opcion)
			{
			case 1:
				System.out.print("Ingresa el nuevo caracter:");
				String otro = leer.next();
				pila.Inserta((T) otro);		
				break;
			case 2:
				System.out.println();
				
				if((boolean) pila.Retira()) {
				System.out.println("Se elimino el valor");
				}
				break;
			case 3:
				
				System.out.println(pila.Llena());
				break;
			case 4:			
				System.out.println(pila.Vacia());
				break;
			case 5:			
				System.out.println("\n"+"Pila actual:"+"\n");
				pila.Mostrar();
				break;
			case 0:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}	
				
		}while(Opcion!=0);
		
	}

}
