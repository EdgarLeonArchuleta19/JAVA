//Edgar Leon Archuleta 

import java.util.List;
import java.util.Scanner;

public class MenuBusqueda {

    public static int movimientos;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            movimientos = 1;
            System.out.println("\n\nMenu");
            System.out.println("1. Búsqueda por Anchura");
            System.out.println("2. Búsqueda por Profundidad");
            System.out.println("3. Búsqueda por Costo Uniforme");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione el tipo de búsqueda:");
            int opcion = scanner.nextInt();
            if (opcion == 4) {
                System.out.println("Saliendo del programa.");
                break;
            }

            int[][] estadoInicial = {{1, 2, 3}, {4, 5, 0}, {6, 7, 8}};
            int[][] estadoFinal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
            EstadoPuzzle estadoInicialObj = new EstadoPuzzle(estadoInicial);

            List<EstadoPuzzle> solucion = null;

            switch (opcion) {
                case 1:
                    solucion = Busquedas.buscarPorAnchura(estadoInicialObj, estadoFinal);
                    break;
                case 2:
                    solucion = Busquedas.buscarPorProfundidad(estadoInicialObj, estadoFinal);
                    break;
                case 3:
                    solucion = Busquedas.buscarCostoUniforme(estadoInicialObj, estadoFinal);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

            if (solucion != null) {
                for (EstadoPuzzle estado : solucion) {
                     imprimirTablero(estado);
                }
                System.out.println("\n¡Se encontró una solución!");
            } else {
                System.out.println("\nNo se encontró solución.");
            }
        }

        scanner.close();
    }



     // Método para imprimir el tablero del estado
    // y los movimientos en cada paso
   
    private static void imprimirTablero(EstadoPuzzle estado) {

         System.out.println("\nMovimiento: "+movimientos++);
        int[][] tablero = estado.getTablero();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
       
    }
}
