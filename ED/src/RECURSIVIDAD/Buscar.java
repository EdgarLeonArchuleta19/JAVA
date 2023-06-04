package RECURSIVIDAD;
import java.util.Scanner;

public class Buscar {
	
	private static int[]	Vector= {7,0,4,3,5,6,8,9,2,1};
	
	static Scanner leer = new Scanner(System.in);
	
	
	
	public Buscar(int [] V) {
		Vector=V;
		
	}
	
	public static void buscarelemento(int i, int e, int num, int Ne) {
		
		if(e==0 && Ne==00) {
			if(num==Vector[i]) {
				System.out.println("Elemento encontrado");
				System.out.println("posicion del elemento: "+i+" y es: "+" "+Vector[i] );
				e=1;
			}else {

				if(i==10-1) {
					System.out.println("Elemento no encontrado");
					Ne=1;
				}
			}
			buscarelemento(i+1,e,num,Ne);
			
		}
		
		
		
	}
	

	public static void main(String[] args) {
		
		int n=0,e=0,Ne=0;
		int D=0;
		
			
		do {
		
			System.out.println("----Buscar elemento en un Vector----"+"\n");
		System.out.print("Digite elemento a buscar: ");
		n=leer.nextInt();
		buscarelemento(0,e,n,Ne);
		
		System.out.print("\n"+"Seguir?(1=si, 0=no):");
		D=leer.nextInt();
		}while(D==1);
		
		if(D==0) {
			System.out.println("Fin del programa");
		}
		
		
	}


}
