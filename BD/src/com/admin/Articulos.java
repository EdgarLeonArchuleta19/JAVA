package com.admin;

/**
 *
 * @author Arctric
 */
public class Articulos {
    private int artID, famID;
    private String artNombre, artDescripcion;
    private double artPrecio;
    private String famNombre;

    public Articulos(int artID, int famID, String artNombre, String artDescripcion, double artPrecio, String famNombre) {
        this.artID = artID;
        this.famID = famID;
        this.artNombre = artNombre;
        this.artDescripcion = artDescripcion;
        this.artPrecio = artPrecio;
        this.famNombre = famNombre;
    }

    /**
     * @return the artID
     */
    public int getArtID() {
        return artID;
    }

    /**
     * @param artID the artID to set
     */
    public void setArtID(int artID) {
        this.artID = artID;
    }

    /**
     * @return the famID
     */
    public int getFamID() {
        return famID;
    }

    /**
     * @param famID the famID to set
     */
    public void setFamID(int famID) {
        this.famID = famID;
    }

    /**
     * @return the artNombre
     */
    public String getArtNombre() {
        return artNombre;
    }

    /**
     * @param artNombre the artNombre to set
     */
    public void setArtNombre(String artNombre) {
        this.artNombre = artNombre;
    }

    /**
     * @return the artDescripcion
     */
    public String getArtDescripcion() {
        return artDescripcion;
    }

    /**
     * @param artDescripcion the artDescripcion to set
     */
    public void setArtDescripcion(String artDescripcion) {
        this.artDescripcion = artDescripcion;
    }

    /**
     * @return the artPrecio
     */
    public double getArtPrecio() {
        return artPrecio;
    }

    /**
     * @param artPrecio the artPrecio to set
     */
    public void setArtPrecio(double artPrecio) {
        this.artPrecio = artPrecio;
    }

    /**
     * @return the famNombre
     */
    public String getFamNombre() {
        return famNombre;
    }

    /**
     * @param famNombre the famNombre to set
     */
    public void setFamNombre(String famNombre) {
        this.famNombre = famNombre;
    }

    @Override
    public String toString() {
        return "Articulos{" + "artID=" + artID + ", famID=" + famID + ", artNombre=" + artNombre + ", artDescripcion=" + artDescripcion + ", artPrecio=" + artPrecio + ", famNombre=" + famNombre + '}';
    }
    
    
    
}
