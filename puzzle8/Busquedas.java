//Edgar Leon Archuleta 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Busquedas {

//BUSQUEDA POR ANCHURA---------------------------------------------------
    public static List<EstadoPuzzle> buscarPorAnchura(EstadoPuzzle estadoInicial, int[][] estadoFinal) {
        Queue<EstadoPuzzle> cola = new LinkedList<>();
        Set<EstadoPuzzle> visitados = new HashSet<>();
        Map<EstadoPuzzle, EstadoPuzzle> padres = new HashMap<>();
        List<EstadoPuzzle> solucion = new ArrayList<>();

        cola.add(estadoInicial);
        visitados.add(estadoInicial);

        while (!cola.isEmpty()) {
            EstadoPuzzle estadoActual = cola.poll();

            if (estadoActual.esEstadoFinal(estadoFinal)) {
                reconstruirSolucion(padres, estadoActual, solucion);
                return solucion;
            }

            // Generar los posibles movimientos
            int filaVacia = estadoActual.getFilaVacia();
            int columnaVacia = estadoActual.getColumnaVacia();

            // Movimiento arriba
            if (filaVacia > 0) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia - 1, columnaVacia);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    cola.add(nuevoEstado);
                }
            }

            // Movimiento abajo
            if (filaVacia < 2) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia + 1, columnaVacia);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    cola.add(nuevoEstado);
                }
            }

            // Movimiento izquierda
            if (columnaVacia > 0) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia, columnaVacia - 1);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    cola.add(nuevoEstado);
                }
            }

            // Movimiento derecha
            if (columnaVacia < 2) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia, columnaVacia + 1);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    cola.add(nuevoEstado);
                }
            }
        }

        return null; // No se encontró solución
    }






//--BUSQUEDA POR PROFUNDIDAD--------------------------------------------------------------------
 public static List<EstadoPuzzle> buscarPorProfundidad(EstadoPuzzle estadoInicial, int[][] estadoFinal) {
        Stack<EstadoPuzzle> pila = new Stack<>();
        Set<EstadoPuzzle> visitados = new HashSet<>();
        Map<EstadoPuzzle, EstadoPuzzle> padres = new HashMap<>();
        List<EstadoPuzzle> solucion = new ArrayList<>();

        pila.push(estadoInicial);
        visitados.add(estadoInicial);

        while (!pila.isEmpty()) {
            EstadoPuzzle estadoActual = pila.pop();

            if (estadoActual.esEstadoFinal(estadoFinal)) {
                reconstruirSolucion(padres, estadoActual, solucion);
                return solucion;
            }

            // Generar los posibles movimientos y agregar los estados vecinos a la pila
            int filaVacia = estadoActual.getFilaVacia();
            int columnaVacia = estadoActual.getColumnaVacia();

            // Movimiento arriba
            if (filaVacia > 0) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia - 1, columnaVacia);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    pila.push(nuevoEstado);
                }
            }

            // Movimiento abajo
            if (filaVacia < 2) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia + 1, columnaVacia);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    pila.push(nuevoEstado);
                }
            }

            // Movimiento izquierda
            if (columnaVacia > 0) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia, columnaVacia - 1);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    pila.push(nuevoEstado);
                }
            }

            // Movimiento derecha
            if (columnaVacia < 2) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia, columnaVacia + 1);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    pila.push(nuevoEstado);
                }
            }
        }

        return null; // No se encontró solución
    }






    //BUSQUEDA COSTO UNIFORME------------------------
    public static List<EstadoPuzzle> buscarCostoUniforme(EstadoPuzzle estadoInicial, int[][] estadoFinal) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(new Comparator<Nodo>() {
            @Override
            public int compare(Nodo nodo1, Nodo nodo2) {
                return Integer.compare(nodo1.getCosto(), nodo2.getCosto());
            }
        });

        Set<EstadoPuzzle> visitados = new HashSet<>();
        Map<EstadoPuzzle, EstadoPuzzle> padres = new HashMap<>();
        List<EstadoPuzzle> solucion = new ArrayList<>();

        colaPrioridad.add(new Nodo(estadoInicial, 0));
        visitados.add(estadoInicial);

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();
            EstadoPuzzle estadoActual = nodoActual.getEstado();
            int costoActual = nodoActual.getCosto();

            if (estadoActual.esEstadoFinal(estadoFinal)) {
                reconstruirSolucion(padres, estadoActual, solucion);
                return solucion;
            }

            // Generar los posibles movimientos, agregar los estados vecinos a la cola de prioridad
            int filaVacia = estadoActual.getFilaVacia();
            int columnaVacia = estadoActual.getColumnaVacia();

            // Movimiento arriba
            if (filaVacia > 0) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia - 1, columnaVacia);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);
                int costoMovimiento = 1; // Ajuste del costo a 1

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    colaPrioridad.add(new Nodo(nuevoEstado, costoActual + costoMovimiento));
                }
            }

            // Movimiento abajo
            if (filaVacia < 2) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia + 1, columnaVacia);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);
                int costoMovimiento = 1; // Ajuste del costo a 1

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    colaPrioridad.add(new Nodo(nuevoEstado, costoActual + costoMovimiento));
                }
            }

            // Movimiento izquierda
            if (columnaVacia > 0) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia, columnaVacia - 1);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);
                int costoMovimiento = 1; // Ajuste del costo a 1

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    colaPrioridad.add(new Nodo(nuevoEstado, costoActual + costoMovimiento));
                }
            }

            // Movimiento derecha
            if (columnaVacia < 2) {
                int[][] nuevoTablero = clonarTablero(estadoActual.getTablero());
                intercambiarCasillas(nuevoTablero, filaVacia, columnaVacia, filaVacia, columnaVacia + 1);
                EstadoPuzzle nuevoEstado = new EstadoPuzzle(nuevoTablero);
                int costoMovimiento = 1; // Ajuste del costo a 1

                if (!visitados.contains(nuevoEstado)) {
                    visitados.add(nuevoEstado);
                    padres.put(nuevoEstado, estadoActual);
                    colaPrioridad.add(new Nodo(nuevoEstado, costoActual + costoMovimiento));
                }
            }
        }

        return null; // No se encontró solución
    }




    //Metodos externos que usan los 3 tipos de busquedas
        private static void reconstruirSolucion(Map<EstadoPuzzle, EstadoPuzzle> padres, EstadoPuzzle estadoFinal, List<EstadoPuzzle> solucion) {
        EstadoPuzzle estadoActual = estadoFinal;
        while (estadoActual != null) {
            solucion.add(0, estadoActual); // Agregar al principio para mantener el orden correcto
            estadoActual = padres.get(estadoActual);
        }
    }


    private static int[][] clonarTablero(int[][] tablero) {
        int[][] nuevoTablero = new int[tablero.length][];
        for (int i = 0; i < tablero.length; i++) {
            nuevoTablero[i] = Arrays.copyOf(tablero[i], tablero[i].length);
        }
        return nuevoTablero;
    }



    private static void intercambiarCasillas(int[][] tablero, int fila1, int columna1, int fila2, int columna2) {
        int temp = tablero[fila1][columna1];
        tablero[fila1][columna1] = tablero[fila2][columna2];
        tablero[fila2][columna2] = temp;
    }




}





//Clase nodo usaba para la cola de prioridad y sus costos
class Nodo {
    private EstadoPuzzle estado;
    private int costo;

    public Nodo(EstadoPuzzle estado, int costo) {
        this.estado = estado;
        this.costo = costo;
    }

    public EstadoPuzzle getEstado() {
        return estado;
    }

    public int getCosto() {
        return costo;
    }

}
