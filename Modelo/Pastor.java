package Modelo;


public class Pastor {
    private int id;
    private int tesoro;
    private String oficio;
    private int feligreses;
    private String nombre;
    private boolean activo;
    
    
    // Constructor 
    public Pastor(int id, int tesoro, String oficio, int feligreses, String nombre, boolean activo) {
        this.id = id;
        this.tesoro = tesoro;
        this.oficio = oficio;
        this.feligreses = feligreses;
        this.nombre = nombre;
        this.activo = activo;
    }
    // Setters And Getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTesoro() {
        return tesoro;
    }
    public void setTesoro(int tesoro) {
        this.tesoro = tesoro;
    }
    public String getOficio() {
        return oficio;
    }
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    public int getFeligreses() {
        return feligreses;
    }
    public void setFeligreses(int feligreses) {
        this.feligreses = feligreses;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {

        this.activo = activo;
    }
}