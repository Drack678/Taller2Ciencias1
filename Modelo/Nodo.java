package Modelo;

/**
 * Representa un nodo de una lista doblemente enlazada de forma circular.
 * Cada nodo contiene una referencia a un objeto Pastor, así como referencias
 * al nodo siguiente y al nodo anterior en la lista.
 *
 * Esta clase es utilizada para construir estructuras de datos donde se requiere
 * recorrer elementos en ambas direcciones y de manera circular.
 *
 * @author marlon
 */
public class Nodo {
     // datos que contiene el nodo 
    private Pastor pastor;
    // Referencia a los nodos anteriores y siguentes para la lista doblemente enlazada de forma circular 
    private Nodo siguiente;
    private Nodo anterior;
    
    // Constructor 
    /**
     * Construye un nuevo Nodo con el objeto Pastor especificado.
     * Inicializa las referencias 'siguiente' y 'anterior' a null.
     *
     * @param pastor el objeto Pastor que se almacenará en este nodo
     */
    public Nodo(Pastor pastor) {
        this.pastor=pastor;
        this.siguiente = null;
        this.anterior = null;
    }
    // Setters and Getters 

    /**
     * Devuelve el objeto Pastor asociado a este nodo.
     *
     * @return la instancia de Pastor almacenada en este nodo
     */
    public Pastor getPastor() {
        return pastor;
    }

    /**
     * Establece el objeto Pastor asociado a este nodo.
     *
     * @param pastor el Pastor que se asignará a este nodo
     */
    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    
    /**
     * Devuelve el siguiente nodo en la estructura enlazada.
     *
     * @return el siguiente objeto {@code Nodo} enlazado a este nodo, o {@code null} si no hay un nodo siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista enlazada.
     *
     * @param siguiente el nodo que se establecerá como siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Devuelve el nodo anterior (anterior) enlazado a este nodo.
     *
     * @return el nodo {@code Nodo} anterior en la estructura enlazada, o {@code null} si no hay ninguno
     */
    public Nodo getAnterior() {
        return anterior;
    }

    /**
     * Establece la referencia al nodo anterior en la lista enlazada.
     *
     * @param anterior el nodo que se establecerá como anterior
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
}
