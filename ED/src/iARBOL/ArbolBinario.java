package iARBOL;


public class ArbolBinario {

    public static NodoArbol raiz;
    public static NodoArbol Padre=null;
    

    public ArbolBinario() {
        raiz = null;
    }

    
    public boolean Vacio() {
        return raiz == null;
    }
    
    public NodoArbol Raiz() {
        return raiz;
    }
    
    
    public void InsertarABB(int d) {
        NodoArbol nuevo = new NodoArbol(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol aux = raiz;
            NodoArbol padre;
            while (true) {
                padre = aux;
                if (d < aux.claveart) {
                    aux = aux.LI;

                    if (aux == null) {
                        padre.LI = nuevo;

                        return;
                    }
                } else {
                    aux = aux.LD;
                    if (aux == null) {
                        padre.LD = nuevo;
                        return;
                    }
                }
            }
        }

    }


    public void InOrden(NodoArbol Nodo) {
        if (Nodo != null) {
            InOrden(Nodo.LI);
            System.out.println(Nodo.claveart);
            InOrden(Nodo.LD);
        }
    }

    public NodoArbol BuscarNodo(int d) {
        NodoArbol aux = raiz;
        while (aux.claveart != d) {
            if (d < aux.claveart) {
                aux = aux.LI;
            } else {
                aux = aux.LD;
            }
            if (aux == null) {
            	System.out.println("Valor no encontrado");
                return null;
            }
        }
        System.out.println("Valor encontrado");
        return aux;
    }

    public boolean EliminarABB(int d) {
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean hijoizq = true;
        while (aux.claveart != d) {
            padre = aux;
            if (d < aux.claveart) {
                hijoizq = true;
                aux = aux.LI;
            } else {
                hijoizq = false;
                aux = aux.LD;
            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.LI == null && aux.LD == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (hijoizq) {
                padre.LI = null;
            } else {
                padre.LD = null;
            }
        } else if (aux.LD == null) {
            if (aux == raiz) {
                raiz = aux.LI;
            } else if (hijoizq) {
                padre.LI = aux.LI;
            } else {
                padre.LD = aux.LI;
            }
        } else if (aux.LI == null) {
            if (aux == raiz) {
                raiz = aux.LD;
            } else if (hijoizq) {
                padre.LI = aux.LD;
            } else {
                padre.LD = aux.LD;
            }
        } else {
            NodoArbol reemplazo = ObtenerReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (hijoizq) {
                padre.LI = reemplazo;
            } else {
                padre.LD = reemplazo;
            }
            reemplazo.LI = aux.LI;
        }
        return true;
    }

    public NodoArbol ObtenerReemplazo(NodoArbol nodoreemplazo) {
        NodoArbol reemplazarpadre = nodoreemplazo;
        NodoArbol reemplazo = nodoreemplazo;
        NodoArbol auxiliar = nodoreemplazo.LD;
        while (auxiliar != null) {
            reemplazarpadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.LI;
        }
        if (reemplazo != nodoreemplazo.LD) {
            reemplazarpadre.LI = reemplazo.LD;
            reemplazo.LD = nodoreemplazo.LD;
        }
       
        return reemplazo;
    }

    
    public int nivelNodo(int d, NodoArbol aux){
		
		int nivel=0;
		
		if (aux==null){
         System.out.println("El valor no existe");
		}
		else {
			if(d==aux.claveart) {
				nivel=nivel+1;
			}else {
				if(d<aux.claveart) {
                  nivel=nivelNodo(d,aux.LI)+1;
			}else {
				if(d>aux.claveart) {
					nivel=nivelNodo(d,aux.LD)+1;
				}
			   }
			  } 
			}
             return nivel;

}

	
	
public NodoArbol BuscarPadre(int d, NodoArbol Nodo) {
		
		if (Nodo!=null){
			if (raiz.claveart!=d){
				if (Nodo.claveart!=d){
					if (d<Nodo.claveart){
						Padre=Nodo;
						
						return BuscarPadre(d, Nodo.LI); 
					}else{
						Padre=Nodo;
						
						return BuscarPadre(d, Nodo.LD); 
					}
				}
			}else{
				System.out.println("Esta nodo no tiene padre, es la raiz!!");
				return raiz;
			
		}
			}
			
		System.out.print("El nodo padre es:"+Padre.claveart);
		
		
       return Padre;
	}
}
