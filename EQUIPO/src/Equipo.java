
//Edgar leon archuleta
public class Equipo {
	
  private int idClave;
  private String TipoComputadora; 
  private String Marca; 
  private String Modelo; 
  private String Procesador; 
  private String Memoria; 
  private String Almacenamiento; 
  
  
  public Equipo() {
	  	  
  }
  
  public Equipo(int ID, String TC, String marca, String modelo, String procesador, String memoria, String almacenamiento) {
	  
    establecerIDClave(ID);
    establecerTipoComputadora(TC);
    establecerMarca(marca);
    establecerModelo(modelo);
    establecerProcesador(procesador);
    establecerMemoria(memoria);
    establecerAlmacenamiento(almacenamiento);
  }
  
  public void establecerIDClave(int ID) {
    idClave = ID;
  }
  
  public int obtenerIDClave() {
    return idClave;
  }
  
  public void establecerTipoComputadora(String TC) {
    TipoComputadora = TC;
  }
  
  public String obtenerTipoComputadora() {
    return TipoComputadora;
  }
  
  public void establecerMarca(String marca) {
   Marca = marca;
  }
  
  public String obtenerMarca() {
    return Marca;
  }
  
  public void establecerModelo(String modelo) {
    Modelo = modelo;
  }
  
  public String obtenerModelo() {
    return Modelo;
  }
  
  public void establecerProcesador(String procesador) {
    Procesador = procesador;
  }
  
  public String obtenerProcesador() {
    return Procesador;
  }
  
  public void establecerMemoria(String memoria) {
    Memoria = memoria;
  }
  
  public String obtenerMemoria() {
    return Memoria;
  }
  
  public void establecerAlmacenamiento(String almacenamiento) {
    Almacenamiento = almacenamiento;
  }
  
  public String obtenerAlmacenamiento() {
    return Almacenamiento;
  }
}
