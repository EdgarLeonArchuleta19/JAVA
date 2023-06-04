/*
INTEGRANTES:

MIGUEL ANGEL ZAVALA
EDWIN OMAR GASTELUM
EDGAR LEON ARCHULETA

*/

package ARBOL;

public class Arbol{
	
	public static NodoArbol Raiz=null, Padre=null;
	public static int C=0; 
	public static int Total=0;
	
	
	
	public static NodoArbol CreaNodo (int clave){
		NodoArbol Nvo = new NodoArbol();
		Nvo.claveart=clave;
		Nvo.LI=null;
		Nvo.LD=null;
		return Nvo;
	}
	public static void InOrden (NodoArbol Nodo) {
		if (Nodo!=null){
			InOrden(Nodo.LI); 
			System.out.println(Nodo.claveart); 
			InOrden(Nodo.LD); 
		}
	}
	
	public static boolean InsertarABB (int clave, NodoArbol Nodo){
		if (clave < Nodo.claveart) {
			if (Nodo.LI==null){
				NodoArbol Nvo = CreaNodo(clave); 
				Nodo.LI=Nvo;
				System.out.println("Se insertó: "+clave);
				return true;
			}else{
				InsertarABB(clave, Nodo.LI); 
			}
		}else{
			
			if (clave > Nodo.claveart){
				
				if (Nodo.LD==null){
					
					NodoArbol Nvo = CreaNodo(clave); 
					Nodo.LD=Nvo;
					System.out.println("Se inserto: "+clave); 
					return true;
					
				}else{
					InsertarABB(clave, Nodo.LD);
				}
			}
		}
		return false;
	}
	
	
	public static boolean BuscarB(int dato, NodoArbol Nodo){
			
		if (Nodo!=null){
			if (Nodo.claveart==dato){
				System.out.println("Valor encontrado");
				return true;
				
			}else{
				
				if (dato<Nodo.claveart){
					return BuscarB(dato, Nodo.LI); 
				}else{
					return BuscarB(dato, Nodo.LD); 
				}
			}
		}else{
			System.out.println("Valor no encontrado");
			return false;
		}
	}
	
	public static NodoArbol BuscarNodo(int dato, NodoArbol Nodo){
		if (Nodo!=null){
			if (Nodo.claveart==dato){
				return Nodo;
			}else{
				if (dato<Nodo.claveart){
					return BuscarNodo(dato, Nodo.LI); 
				}else{
					return BuscarNodo(dato, Nodo.LD);
				}
			}
		}else{
			return null;
		}
	}
	
	public static NodoArbol BuscarPadre(int dato, NodoArbol Nodo) {
		
		if (Nodo!=null){
			if (Raiz.claveart!=dato){
				if (Nodo.claveart!=dato){
					if (dato<Nodo.claveart){
						Padre=Nodo;
						
						return BuscarPadre(dato, Nodo.LI); 
					}else{
						Padre=Nodo;
						
						return BuscarPadre(dato, Nodo.LD); 
					}
				}
			}else{
				System.out.println("Esta nodo no tiene padre");
			
		}
			}
			
		System.out.print("El nodo padre es:"+Padre.claveart);
		
		
       return Padre;
	}
	
	
	  public static void EliminarABB(int dato) {
	        Raiz = EliminarABB(dato, Raiz);
	    }

	 
	   public static NodoArbol EliminarABB(int a, NodoArbol Nodo) {
		   
	        if (Nodo == null) {
	        	 System.out.println("El valor a eliminar no se encontro");
	           return null;
	        }
	     	
	        int compara = ((Comparable) Nodo.claveart).compareTo(a);
	        if (compara > 0) {
	        	Nodo.LI = (EliminarABB(a, Nodo.LI));
	        } else if (compara < 0) {
	        	Nodo.LD = (EliminarABB(a, Nodo.LD));
	        } else {

	            if (Nodo.LI != null && Nodo.LD != null) {
	             
	                NodoArbol cambiar = buscarM(Nodo.LD);
	                int aux1 = cambiar.claveart;
	                cambiar.claveart = Nodo.claveart;
	                Nodo.claveart = aux1;
	                Nodo.LD = (EliminarABB(a, Nodo.LD));
	            } else {
	            	Nodo = (Nodo.LI != null) ? Nodo.LI : Nodo.LD;
	            }
	            
	            
	            }
	        
	        return Nodo;
	    }
	 
	    private static NodoArbol buscarM(NodoArbol Nodo) {
	        for (; Nodo.LI != null; Nodo = Nodo.LD);
	        return (Nodo);
	        
	    }
	  
	    

		private int nivelNodo(NodoArbol Nodo, int dato){
				
			
			int nivel=0;
			
			if (Nodo==null){
             System.out.println("El valor no existe");
			}
			else {
				if(dato==Nodo.claveart) {
					nivel=nivel+1;
				}else {
					if(dato<Nodo.claveart) {
                      nivel=nivelNodo(Nodo.LI,dato)+1;
				}else {
					if(dato>Nodo.claveart) {
						nivel=nivelNodo(Nodo.LD,dato)+1;
					}
				   }
				  } 
				}
	             return nivel;

}
	
		public int nivelNodo(int dato) {
		 return nivelNodo(Raiz,dato);
		}
		
		
		
}
