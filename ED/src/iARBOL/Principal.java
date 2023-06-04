package iARBOL;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArbolBinario A = new ArbolBinario();
  
        		
        		Scanner leer = new Scanner(System.in);
        		int Opcion;
        		
        		A.InsertarABB(15);
        		A.InsertarABB(20);
        		A.InsertarABB(30);
        		A.InsertarABB(18);
        		A.InsertarABB(25);
        		A.InsertarABB(28);
        		A.InsertarABB(26);
        		A.InsertarABB(24);
        		A.InsertarABB(27);
        		A.InsertarABB(40);
        		A.InsertarABB(35);
        		A.InsertarABB(38);
        		A.InsertarABB(31);
        		A.InsertarABB(34);
        		A.InsertarABB(9);
        		A.InsertarABB(11);
        		A.InsertarABB(5);
        		A.InsertarABB(7);
        		A.InsertarABB(6);
        		A.InsertarABB(13);
        		A.InsertarABB(12);
        		A.InsertarABB(10);
        		
        		
        	do {
        			
        			System.out.println();
        			System.out.println("------Menu de una Arbol Binario------"+"\n");
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
        				A.InsertarABB(nuevo);		
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
        			    A.BuscarNodo(buscar);
        				break;
        				
        			case 4:
        				System.out.print("Ingrese el valor a buscar:");
        				int P = leer.nextInt();
        				A.BuscarPadre(P,A.raiz);
        				break;
        			case 5:			
        				System.out.print("Buscar Nivel:");
        				int n = leer.nextInt();
        				int nivel=A.nivelNodo(n,A.raiz);
        				System.out.println("El nivel es: "+nivel);
        				
        				break;
        			case 6:			
        			    A.InOrden(A.raiz);
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