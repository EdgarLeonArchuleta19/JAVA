//By Edgar Le�n Archuleta

//Aplicaci�n catalogo MVC
public class Catalogo {
	
	public static void main(String[]args){		
		Modelo miModelo = new Modelo();
		Vista miVista = new Vista();
		Controlador miControlador = new Controlador(miModelo, miVista);	
		miControlador.iniciarVista();
	}
}
