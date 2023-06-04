
//HECHO POR EDGAR LEON ARCHULETA Y ANGEL FELIX ESPINOZA

package COLA;
public class Cola<T> {

	private int Maximo,Frente,Fin;
	private T [] C;
	public T Dr;
	public Cola(){
	this(10);

	}
	
	
	public Cola(int Maximo){
	this.Maximo=Maximo;
	Frente=Fin=-1;
	Dr=null;
	C= (T[]) new Object[Maximo];

	}

	
	public boolean Llena(){

		if(Frente==0 && Fin==Maximo-1 || Fin==Frente-1) {
			
			return true;
		}else {
	return false;
		}
	}

	
	
	public boolean Vacia(){

		if(Frente==-1) {
			return true;
			
		}else {
			return false;
		}
	}

	
	public boolean Inserta(T Dato){

	if(Llena()) {
		System.out.println("La cola esta llena");
	return false;
	
	}
	
	if(Fin==Maximo-1 && Frente!=0) {
		Fin=0;
		
	}else 
	Fin++;
	C[Fin]=Dato;
	
	if(Frente==-1) {
	Frente=0;
	}
	return true;
	
	}

	 
	public boolean Retira(){

	if(Frente==-1) {
		System.out.println("Cola vacia");
		return false;
		
	}else {
	Dr=C[Frente];	
	if(Frente==Fin) {

	Frente=-1;
	Fin=-1;
    
	}else {
	
	if(Frente==Maximo-1 && Fin<Frente) {
		Frente=0;
	}else {
		
		Frente++;
	}
	
	}
	return true;
	}
	}
	

	public void Mostrar(){

		if(Vacia()) {
			
			System.out.println("La cola esta vacia");
		}else {
		
		
	if(Frente<=Fin) {
	
	for(int i=Frente; i<=Fin; i++) {
	System.out.println(C[i]);
	}
	
	}else {
		
		for(int i=Frente; i<=Maximo-1; i++) {
			System.out.println(C[i]);
			}
		for(int i=0; i<=Fin; i++) {
			System.out.println(C[i]);
			}
	    }
		}
	}
	
	
	
	public void Invertir() {
		
		
	}
	
	
}



