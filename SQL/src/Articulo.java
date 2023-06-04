
//Edgar leon archuleta
public class Articulo {
	
  private int Artid;
  private String ArtNombre; 
  private String ArtDescripcion; 
  private int ArtPrecio; 
  private int Famid; 
  
  
  public Articulo() {
	  	  
  }
  
  public Articulo(int artid, String artNombre, String artDescripcion, int artPrecio, int famid) {
	  
    establecerArtid(artid);
    establecerArtNombre(artNombre);
    establecerArtDescripcion(artDescripcion);
    establecerArtPrecio(artPrecio);
    establecerFamid(famid);
  }
  
  public void establecerArtid(int artid) {
	  Artid = artid;
  }
  
  public int obtenerArtid() {
    return Artid;
  }
  
  
  public void establecerArtNombre(String nombre) {
	  ArtNombre = nombre;
  }
  
  public String obtenerArtNombre() {
    return ArtNombre;
  }
  
  
  public void establecerArtDescripcion(String artDescripcion) {
	  ArtDescripcion = artDescripcion;
  }
  
  public String obtenerArtDescripcion() {
    return ArtDescripcion;
  }
  
  
  public void establecerArtPrecio(int artPrecio) {
	  ArtPrecio = artPrecio;
  }
  
  public int obtenerArtPrecio() {
    return ArtPrecio;
  }
  
  
  public void establecerFamid(int famid) {
	  Famid = famid;
  }
  
  public int obtenerFamid() {
    return Famid;
  }
  

  
  
  
}
