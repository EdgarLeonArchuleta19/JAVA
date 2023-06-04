package iPILA;

import java.util.Scanner;

public class Pila {
	Scanner teclado = new Scanner(System.in);
    Nodo primero;
    
    public Pila(){
        primero = null;
    }
    
    public void ingresarNodo(){
        Nodo nuevo = new Nodo();
        System.out.print(" Ingrese el dato que contendra el nuevo Nodo: ");
        nuevo.dato = teclado.nextInt();
        
        nuevo.siguiente = primero;
        primero = nuevo;
        System.out.println("\n Nodo ingresado con exito\n");
    }

    public void modificarNodo(){
        Nodo actual = new Nodo();
        actual = primero;
        boolean encontrado = false;
        System.out.print(" Ingrese el dato del nodo a Modificar: ");
        int nodoBuscado = teclado.nextInt();
        if(primero != null && encontrado != true){
            while(actual != null){
                if(actual.dato == nodoBuscado){
                    System.out.println("\n Nodo con el dato " + actual.dato + " Encontrado \n");
                    System.out.print("Ingrese el nuevo dato para este nodo: ");
                    actual.dato = teclado.nextInt();
                    System.out.println("\n Nodo modificado\n");
                    encontrado = true;
                }
                actual = actual.siguiente;
            }
            if(!encontrado){
                System.out.println("\n Nodo no encontrado\n");
            }
        }else{
            System.out.println("\n La pila se encuentra vacia\n");
        }  
    }

    public void desplegarPila(){
        Nodo actual = new Nodo();
        actual = primero;
        if(primero != null){
            while(actual != null){
                System.out.println(" " + actual.dato);
                actual = actual.siguiente;
            }   
        }else{
            System.out.println("\n La pila se encuentra vacia\n");
        }
    }

}
