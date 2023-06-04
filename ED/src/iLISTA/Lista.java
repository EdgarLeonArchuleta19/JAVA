package iLISTA;


public class Lista {

	Nodo NI;
	Nodo NF;
	Nodo aux;
	
	public void Insertar(int M, String Nombre,int Edad, int Calificacion,char Sexo ) {
		
		Nodo N = new Nodo(M,Nombre, Edad, Calificacion, Sexo);
		Nodo Aux=NI;
		Nodo Auxant;
		
		if(Vacio()) {
			NI=N;
			NF=N;
			System.out.println("Inserción exitosa.");
		}else {
			
			if(!Buscar(N.Matricula)) {
				
				if(N.Matricula<NI.Matricula) {
					N.NS=NI;
					NI=N;
					
				}
				if(N.Matricula>NF.Matricula) {
					NF.NS=N;
					NF=N;
					
					}else{
						
			     while(N.Matricula>Aux.Matricula) {
                   Auxant=Aux;
                   Aux=Aux.NS;
                   Auxant.NS=N;
                   N.NS=Aux; 	 
			    }
              }	
				System.out.println("Insercion exitosa.");
			}else {
				System.out.println("Nodo repetido, no ha sido guardado.");
			}
		}
	}
	
	
	
	
	
	public Nodo Eliminar(int M) {
		
		Nodo Aux;
		Nodo Auxant=null;
		Aux=NI;
		
		if(Vacio()) {
			System.out.println("El nodo no existe");
			
		}
		
		if(!Vacio()) {
			if(Buscar(M)) {
				if(NI==NF) {
					NI=null;
					NF=null;
			
				}else {
					
					if(M==NI.Matricula) {
						NI=Aux.NS;
						Aux.NS=null;
					}
					
				       if(M==NF.Matricula) {
							while(Aux!=NF) {
								Auxant=Aux;
								Aux=Aux.NS;	
							}
							NF=Auxant;
							NF.NS=null;
				       }else {
			
				
							while(M!=Aux.Matricula) {
								
								Auxant=Aux;
								Aux=Aux.NS;
							}
							Auxant.NS=Aux.NS;
							Aux.NS=null;
				
					     }
				       }    
				} 
		}
		return Aux;
	}

	
	

public boolean Vacio() {

	if(NI==null) {
		
		return true;
	}else {
		
		return false;
	}
}




public boolean Buscar(int C) {
	Nodo Aux1=NI;
	
	while(Aux1!=null) {
		
		if(C==Aux1.Matricula) {
			return true;
		}
		Aux1=Aux1.NS;
	}
	return false;
}




public void Mostrar() {
	
	aux=NI;
	
	if(Vacio()) {
		System.out.println("Esta vacio");
	}else {
	
	while(aux!=null) {
		System.out.println(aux.Imprime());
		aux=aux.NS;
	}
      }
   }

public int promedioGeneral()
{
	int promedio = 0;
	Nodo aux = NI;
	
	if(Vacio())
	{
		System.out.println("LISTA VACIA");
	}
	else 
	{
		while(aux!=null)
		{
			promedio=promedio+aux.Calificacion;
			aux=aux.NS;
		}
	}
	promedio=promedio/5;
	return promedio;		
}

public void aprobados()
{
	int conteo=0;
	Nodo aux=NI;
	
	if(Vacio())
	{
		System.out.println("LISTA VACIA");
	}
	else 
	{
		while(aux!=null)
		{
			if(aux.Calificacion >= 70)
			{
				conteo++;
				
			}
			aux=aux.NS;
			
		}
		System.out.println( "Numero de alumnos aprobados: "+conteo);
	}
	
}

public void reprobados()
{
	int conteo=0;
	Nodo aux=NI;
	
	if(Vacio())
	{
		System.out.println("LISTA VACIA");
	}
	else 
	{
		while(aux!=null)
		{
			if (aux.Calificacion <= 70)
			{
				conteo++;
			}
			aux=aux.NS;
		}
		System.out.println( "Numero de alumnos aprobados: "+conteo);
	}

}

public void mayorCalificacion()
{
	int mayor = 99;
	Nodo aux = NI;

if(Vacio())
{
	System.out.println("LISTA VACIA");
}
else 
	{
	while (aux!=null)
	{
		
		if(aux.Calificacion>mayor)
		{
			
			mayor = aux.Calificacion;	
			System.out.println(aux.Imprime());
			
		}
		aux = aux.NS;
		
	}
    }

}
public void hombres()
{
	Nodo aux=NI;
	
	while(aux!=null)
	{
		if(aux.Sexo=='h')
		{
			System.out.println(aux.Imprime());
		}
		aux=aux.NS;
	}
}

public void mujeres()
{
	Nodo aux=NI;
	
	while(aux!=null)
	{
		if(aux.Sexo=='f')
		{
			System.out.println(aux.Imprime());
		}
		aux=aux.NS;
	}
}


public void menorALmayor()
{
aux=NI;
	
	if(Vacio()) {
		System.out.println("Esta vacio");
	}else {
	
	while(aux!=null) {
		System.out.println(aux.Imprime());
		aux=aux.NS;
	}
      }
   
  }
}






