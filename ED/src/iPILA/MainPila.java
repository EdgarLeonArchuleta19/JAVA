package iPILA;

import java.util.Scanner;
public class MainPila {
	public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        Pila p = new Pila();
        int opcionMenu = 0;
        
        
        do
            {        
                System.out.println("  MENU DE LA PILA   ");
                
                System.out.println("  1. Insertar");
                System.out.println("  2. Modificar");
                System.out.println("  3. Mostar pila"); 
                System.out.println("  4. Salir"); 
                System.out.print(" Escoja una Opción: ");
                
                opcionMenu = Teclado.nextInt();
                switch (opcionMenu)
                {
                    case 1:
                        System.out.println("\n\n INSERTA NODO EN LA PILA \n");
                        p.ingresarNodo();
                        break;          
                    case 2:
                        System.out.println("\n\n MODIFICAR UN NODO DE LA PILA \n");
                        p.modificarNodo();
                        break;
                    case 3:
                        System.out.println("\n\n DESPLEGAR PILA DE NODOS \n");
                        p.desplegarPila();
                        break;
                    case 4:
                        System.out.println("\n\n Programa finalizado... \n");
                        break;
                    default:
                        System.out.println("\n\n Opcion No Valida \n");
                        break;
                }
            }
            while (opcionMenu != 4);
    }
}
