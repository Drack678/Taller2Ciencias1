package Modelo;

/**
 * La clase Pila implementa una estructura de datos tipo pila (LIFO) para almacenar objetos de tipo Pastor.
 * Proporciona métodos para apilar (push), desapilar (pop), verificar si la pila está vacía y obtener el tamaño actual de la pila.
 * Utiliza nodos enlazados para almacenar los elementos.
 */
public class Pila {
    
    Nodo cima;
    int tamanio;

    /**
     * Construye una pila vacía.
     * Inicializa la cima de la pila (cima) en null y su tamaño (tamanio) en 0.
     */
    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    /**
     * Verifica si la pila está vacía.
     * @return {@code true} si la pila no contiene elementos, {@code false} en caso contrario.
     */
    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * Obtiene el tamaño actual de la pila.
     * @return El número de elementos en la pila.
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Apila un nuevo objeto Pastor en la cima de la pila.
     * @param pastor El objeto Pastor a apilar.
     */
    public void push(Pastor pastor) {
        Nodo nuevoNodo = new Nodo(pastor);
        if (estaVacia())
            cima = nuevoNodo;
        else {
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Desapila el objeto Pastor de la cima de la pila y lo devuelve.
     * @return El objeto Pastor desapilado, o {@code null} si la pila está vacía.
     */
    public Pastor pop() {
        if (estaVacia())
            return null;
        else {
            Pastor pastor = cima.getPastor();
            cima = cima.getSiguiente();
            tamanio--;
            return pastor;
        }
    }
}
