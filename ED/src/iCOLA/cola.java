package iCOLA;

public class cola 
{	
	private Nodo inicio, fin;
    String Cola = "";
    
    public cola(){
        inicio = null;
        fin = null;
    }
    
    public boolean ColaVacia(){
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void Insertar(int informacion){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.informacion = informacion;
        nuevo_nodo.siguiente = null;
          
        if (ColaVacia()) {
            inicio = nuevo_nodo;
            fin = nuevo_nodo;
        } else
        	
        {
            fin.siguiente = nuevo_nodo;
            fin = nuevo_nodo;
        }
    }

    public void ColaInvertida(){
        Nodo recorrido = inicio;
        String Invertir = "";
        
        while(recorrido != null){
            Cola += recorrido.informacion + " ";
            recorrido = recorrido.siguiente;
        }
        
        String cadena [] = Cola.split(" ");
        
        
        for (int i = cadena.length - 1; i >= 0; i--) {
            Invertir += " " +cadena[i];                    
        }
        
        System.out.println("Cola original");
        System.out.println(Cola);
        System.out.println();
        
        System.out.println("Cola invertida");
        System.out.println(Invertir);
        Cola = "";
    }
    
    /*
    public static void main(String[] args) {
        
        cola cola = new cola();
        
        cola.Insertar(5);
        cola.Insertar(10);
        cola.Insertar(15);
        cola.Insertar(20);
        cola.Insertar(25);
            
       
        cola.ColaInvertida();
	}
	*/
}
