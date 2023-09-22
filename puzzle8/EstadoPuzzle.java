//Edgar Leon Archuleta 

import java.util.Arrays;

public class EstadoPuzzle {
    private int[][] tablero;
    private int filaVacia;
    private int columnaVacia;

    public EstadoPuzzle(int[][] tablero) {
        this.tablero = tablero;
        buscarPosicionVacia();
    }

    public boolean esEstadoFinal(int[][] estadoFinal) {
        return Arrays.deepEquals(tablero, estadoFinal);
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int getFilaVacia() {
        return filaVacia;
    }

    public int getColumnaVacia() {
        return columnaVacia;
    }

    private void buscarPosicionVacia() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0) {
                    filaVacia = i;
                    columnaVacia = j;
                    return;
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EstadoPuzzle)) return false;
        EstadoPuzzle otroEstado = (EstadoPuzzle) obj;
        return Arrays.deepEquals(tablero, otroEstado.getTablero());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tablero);
    }
}
