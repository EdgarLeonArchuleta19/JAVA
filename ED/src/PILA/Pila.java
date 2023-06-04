
//HECHO POR EDGAR LEON ARCHULETA Y ANGEL FELIX ESPINOZA

package PILA;
class Pila <T>{
	
private T pila[];
private int tope=-1;
public T dato;
private int max=0;


Pila(int maximo){
	max=maximo-1;
	pila=(T[]) new Object[max];
}


public boolean Llena () {
	
if(tope==(max)) {
	 return true;
}else {
	return false;
}

}

public boolean Vacia() {
	if(tope==-1) {
		 return true;
		
	}else {
		return false;
	}
	
}



public boolean Inserta(T dato) {

if(Llena()) {
	System.out.println("La pila esta llena");
	return false;
}

if(!Llena()) {
	tope++;
	pila[tope]=dato;
	 return true;
}else {
	return false;
}

	
}

public boolean Retira() {

	if(Vacia()) {
		System.out.println("La pila esta vacia");
		return false;
	}else {
		tope--;
		return true;
	}
	
}

public void Mostrar() {
	
	if(Vacia()) {
		System.out.println("La pila esta vacia");
	}else {
	
	for(int i=tope; i>=0;i--) {
		System.out.println(pila[i]);
	}
}

}


public void Remplazar() {
	
}

}