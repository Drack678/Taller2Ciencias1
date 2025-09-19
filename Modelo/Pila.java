package Modelo;

public class Pila {
    Nodo cima;
    int tamanio;
    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }
    public int getTamanio() {
        return tamanio;
    }
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
