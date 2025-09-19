package Modelo;

public class Nodo {
     // datos que contiene el nodo 
    private Pastor pastor;

    // Referencia a los nodos anteriores y siguentes para la lista doblemente enlazada de forma circular 
    private Nodo siguiente;
    private Nodo anterior;
    
    // Constructor 
    public Nodo(Pastor pastor) {
        this.pastor=pastor;
        this.siguiente = null;
        this.anterior = null;
    }
    // Setters and Getters 

    public Pastor getPastor() {
        return pastor;
    }
    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
}
