
//HECHO POR EDGAR LEON ARCHULETA Y ANGEL FELIX ESPINOZA

package COLA;
import java.util.Scanner;


public class ColaMain {

	public static <T> void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int Opcion=0;
		Cola<T> cola = new Cola<T>(5);
		
		
		do {
			
			System.out.println();
			System.out.println("------Menu de una Cola Circular------");
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
				cola.Inserta((T) otro);		
				break;
			case 2:
				System.out.println();
				
				if(cola.Retira()) {
				System.out.println("Se elimino el valor: "+cola.Dr);
				}
				break;
			case 3:
				
				System.out.println(cola.Llena());
				break;
			case 4:			
				System.out.println(cola.Vacia());
				break;
			case 5:			
				System.out.println("\n"+"Cola actual:"+"\n");
				cola.Mostrar();
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
