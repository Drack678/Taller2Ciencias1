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

    /**
     * Constructor de la clase Pastor.
     * 
     * @param id         Identificador único del pastor
     * @param tesoro     Valor del tesoro asociado al pastor
     * @param oficio     Oficio o rol del pastor
     * @param feligreses Número de feligreses a cargo del pastor
     * @param nombre     Nombre del pastor
     */
    public Pastor(int id, int tesoro, String oficio, int feligreses) {
        this.id = id;
        this.tesoro = tesoro;
        this.oficio = oficio;
        this.feligreses = feligreses;
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
     * Devuelve una representación en cadena del objeto Pastor, incluyendo su id, tesoro, oficio y feligreses.
     *
     * @return una cadena que describe el estado actual del objeto Pastor
     */
    @Override
    public String toString() {
        return "Pastor [id=" + id + ", tesoro=" + tesoro + ", oficio=" + oficio + ", feligreses=" + feligreses + "]";
    }

    
}