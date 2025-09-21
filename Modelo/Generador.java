package Modelo;
import java.util.Random;

/**
 * La clase Generador se encarga de crear instancias aleatorias de la clase Pastor.
 * Genera valores aleatorios para los atributos de Pastor, como el tesoro, oficio y cantidad de feligreses.
 * Además, asigna un identificador único autoincremental a cada Pastor generado.
 */
public class Generador {

    private static int contadorId = 1; // autoincremental
    private static final Random random = new Random();

    // Rango de valores para el tesoro
    private int tesoroMin = 1600000;
    private int tesoroMax = 35000000;

    // Rango de valores para los feligreses
    private static final int feligresesMax = 10000;

    // Oficios disponibles
    private String[] Oficios = {
        "Dios dragon", 
        "Dios humano", 
        "Dios de la tactica", 
        "Dios del norte"
    };

    /**
     * Genera un objeto Pastor con atributos aleatorios.
     * El ID es único y autoincremental, el tesoro se encuentra en el rango [tesoroMin, tesoroMax],
     * el oficio se selecciona aleatoriamente de la lista de oficios disponibles,
     * y la cantidad de feligreses es un número aleatorio entre 0 y feligresesMax.
     *
     * @return Un nuevo objeto Pastor con valores aleatorios.
     */
    public Pastor generarPastor() {
        // ID único autoincremental
        int id = contadorId++;
        
        // Tesoro: número entre tesoroMin y tesoroMax
        int tesoro = tesoroMin + random.nextInt(tesoroMax - tesoroMin + 1);

        // Oficio: elegimos un índice entre 0 y Oficios.length - 1
        int indiceOficio = random.nextInt(Oficios.length);
        String oficio = Oficios[indiceOficio];

        // Feligreses: número entre 0 y feligresesMax
        int feligreses = random.nextInt(feligresesMax + 1);

        return new Pastor(id, tesoro, oficio, feligreses);
    }
}
