package Modelo;

/**
 * La clase Pastor representa a un pastor con atributos como id, tesoro, oficio,
 * número de feligreses, nombre y estado de actividad.
 * Proporciona métodos para acceder y modificar estos atributos.
 */
public class Pastor {
    private int id; // Identificador único del pastor
    private int tesoro; // Valor del tesoro asociado al pastor
    private String oficio; // Oficio o rol del pastor
    private int feligreses; // Número de feligreses a cargo del pastor
    private String nombre; // Nombre del pastor
    private boolean activo; // Estado de actividad del pastor

    /**
     * Constructor de la clase Pastor.
     * 
     * @param id         Identificador único del pastor
     * @param tesoro     Valor del tesoro asociado al pastor
     * @param oficio     Oficio o rol del pastor
     * @param feligreses Número de feligreses a cargo del pastor
     * @param nombre     Nombre del pastor
     * @param activo     Estado de actividad del pastor (true si está activo)
     */
    public Pastor(int id, int tesoro, String oficio, int feligreses, String nombre, boolean activo) {
        this.id = id;
        this.tesoro = tesoro;
        this.oficio = oficio;
        this.feligreses = feligreses;
        this.nombre = nombre;
        this.activo = activo;
    }

    /**
     * Obtiene el identificador del pastor.
     * @return id del pastor
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del pastor.
     * @param id Nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el valor del tesoro del pastor.
     * @return tesoro del pastor
     */
    public int getTesoro() {
        return tesoro;
    }

    /**
     * Establece el valor del tesoro del pastor.
     * @param tesoro Nuevo valor del tesoro
     */
    public void setTesoro(int tesoro) {
        this.tesoro = tesoro;
    }

    /**
     * Obtiene el oficio del pastor.
     * @return oficio del pastor
     */
    public String getOficio() {
        return oficio;
    }

    /**
     * Establece el oficio del pastor.
     * @param oficio Nuevo oficio
     */
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    /**
     * Obtiene el número de feligreses del pastor.
     * @return número de feligreses
     */
    public int getFeligreses() {
        return feligreses;
    }

    /**
     * Establece el número de feligreses del pastor.
     * @param feligreses Nuevo número de feligreses
     */
    public void setFeligreses(int feligreses) {
        this.feligreses = feligreses;
    }

    /**
     * Obtiene el nombre del pastor.
     * @return nombre del pastor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del pastor.
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Indica si el pastor está activo.
     * @return true si está activo, false en caso contrario
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el estado de actividad del pastor.
     * @param activo Nuevo estado de actividad
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}