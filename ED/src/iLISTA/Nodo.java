
package iLISTA;


public class Nodo {
	int Matricula;
	int Edad;
	int Calificacion;
	String Nombre;
	char Sexo;
	Nodo NS;
	
	
	Nodo(){
		
	}
	
    Nodo(int Matricula, String Nombre, int Edad,int Calificacion, char Sexo){
    	
    	this.Matricula=Matricula;
    	this.Nombre=Nombre;
    	this.Edad=Edad;
    	this.Calificacion=Calificacion;
    	this.Sexo=Sexo;
	}
    
    
    public String Imprime() {
    	return "\n"+" -ALUMNOS- "+"\n"+"MATRICULA: "+Matricula+"\n"+"NOMBRE: "+Nombre+"\n"+"EDAD: "+Edad+"\n"+"CALIFICACION: "+Calificacion+"\n"+"SEXO: "+Sexo;
    }
    

    public String Imprime2() {
    	return "";
    }
    
    
    
    
    
    
    

}
