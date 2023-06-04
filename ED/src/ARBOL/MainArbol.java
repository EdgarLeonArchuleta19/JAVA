
package ARBOL;

import java.util.Scanner;

public class MainArbol{
	
	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		
		Arbol A = new Arbol();
		NodoArbol Nuevo = A.CreaNodo(0);
		A.Raiz=Nuevo;
		int Opcion;
		
		A.InsertarABB(15, A.Raiz);
		A.InsertarABB(20, A.Raiz);
		A.InsertarABB(30, A.Raiz);
		A.InsertarABB(18, A.Raiz);
		A.InsertarABB(25, A.Raiz);
		A.InsertarABB(28, A.Raiz);
		A.InsertarABB(26, A.Raiz);
		A.InsertarABB(24, A.Raiz);
		A.InsertarABB(27, A.Raiz);
		A.InsertarABB(40, A.Raiz);
		A.InsertarABB(35, A.Raiz);
		A.InsertarABB(38, A.Raiz);
		A.InsertarABB(31, A.Raiz);
		A.InsertarABB(34, A.Raiz);
		A.InsertarABB(9, A.Raiz);
		A.InsertarABB(11, A.Raiz);
		A.InsertarABB(5, A.Raiz);
		A.InsertarABB(7, A.Raiz);
		A.InsertarABB(6, A.Raiz);
		A.InsertarABB(13, A.Raiz);
		A.InsertarABB(12, A.Raiz);
		A.InsertarABB(10, A.Raiz);
		
		
	do {
			
			System.out.println();
			System.out.println("------Menu de una Arbol Binario------");
			System.out.println("Insertar - 1");
			System.out.println("Eliminar - 2");
			System.out.println("Buscar - 3");
			System.out.println("Buscar Padre - 4");
			System.out.println("Nivel de Nodo - 5");
			System.out.println("Mostrar - 6");
			System.out.println("Salir - 0");
			System.out.println();
			System.out.print("Escoje tu opcion:");
			Opcion = leer.nextInt();
			
			switch(Opcion)
			{
			case 1:
				System.out.print("Ingresa el nuevo caracter:");
				int nuevo = leer.nextInt();
				A.InsertarABB(nuevo, A.Raiz);		
				break;
			case 2:
				System.out.println();
				System.out.print("Ingresa el valor a retirar:");
				int Eliminar = leer.nextInt();
				A.EliminarABB(Eliminar);
				break;
			case 3:
				System.out.print("Ingrese el valor a buscar:");
				int buscar = leer.nextInt();
			    A.BuscarB(buscar, A.Raiz);
				break;
				
			case 4:
				System.out.print("Ingrese el valor a buscar:");
				int P = leer.nextInt();
				A.BuscarPadre(P, A.Raiz);
				break;
			case 5:			
				System.out.print("Buscar Nivel:");
				int n = leer.nextInt();
				int nivel=A.nivelNodo(n);
				System.out.println("El nivel es: "+nivel);
				
				break;
			case 6:			
			    A.InOrden(A.Raiz);
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

