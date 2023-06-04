package EXPRESIONES;

import java.util.Stack;
import java.util.Scanner;
public class Evaluar {
  public static void main(String[] args) {  
   
	  Scanner entrada = new Scanner(System.in);
	  
	  System.out.print("Ingrese la expresion: ");
	String expresion = entrada.nextLine();
	
	String conversion = Evaluar_Expresiones.conversion(expresion);
	System.out.println("Expresion postfija: " + conversion);
	entrada.close();
	
	  
    String expr = conversion; 
    String[] post = expr.split("");   
   
   
    Stack < String > E = new Stack < String > (); 
    Stack < String > P = new Stack < String > (); 

  
    for (int i = post.length - 1; i >= 0; i--) {
      E.push(post[i]);
    }

   
    String operadores = "+-*/%";
    while (!E.isEmpty()) {
      if (operadores.contains("" + E.peek())) {
        P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
      }else {
        P.push(E.pop());
      }
    }

 
    System.out.println("Resultado: " + P.peek());

  }

  private static int evaluar(String op, String n2, String n1) {
    int num1 = Integer.parseInt(n1);
    int num2 = Integer.parseInt(n2);
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    if (op.equals("%")) return (num1 % num2);
    return 0;
  }

}

    

