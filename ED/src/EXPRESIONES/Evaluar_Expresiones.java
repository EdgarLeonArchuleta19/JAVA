package EXPRESIONES;

import java.util.Stack;

public class Evaluar_Expresiones {
	
	static String conversion(String expresion)
	{
		String postfija = "";
		Stack<Character> stack = new Stack <>();
		
		for (int i = 0; i < expresion.length(); i++)
		{
			 char car = expresion.charAt(i);
			 
			 if(jerarquia(car) > 0 )
			 {
				 while(stack.empty() == false && jerarquia(stack.peek()) >= jerarquia(car))
				 {
					 postfija += stack.pop();					 
				 }
				 stack.push(car);
			 }
			 else if (car == ')') 
			 {
				 char aux = stack.pop();
				 while (aux != '(') 
				 {
					 postfija += aux;
					 aux = stack.pop();
				 }
			 }
			 else if (car == '(') 
			 {
				 stack.push(car);
			 }
			 else 
			 {
				 postfija += car;
			 }
		}
		
		for(int i = 0; i < stack.size(); i++) 
		{
			postfija += stack.pop();
		}
		return postfija;
	}
			
	static int jerarquia(char car)
	{
		switch(car) 
		{
		case '+': 
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
}
