package Modelo;
import java.util.Random;

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

    // Generar un Pastor aleatorio
        public  Pastor generarPastor() {
        
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
