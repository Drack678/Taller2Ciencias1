package Modelo;

/**
 * La clase Mesa representa una lista circular doblemente enlazada de objetos Pastor.
 * Permite agregar, eliminar y reordenar pastores en la mesa, asegurando que no haya dos pastores
 * con el mismo oficio consecutivos.
 */
public class Mesa {
    
    private Nodo head; // Primer nodo (inicio de la mesa)
    private Nodo tail; // Último nodo (final de la mesa)
    private int tamannio; // Tamaño actual de la mesa (cantidad de pastores)

    /**
     * Constructor de la clase Mesa.
     * Inicializa la mesa vacía.
     * 
     * @param head No se utiliza, la mesa inicia vacía.
     * @param tail No se utiliza, la mesa inicia vacía.
     * @param tamannio No se utiliza, la mesa inicia vacía.
     */
    public Mesa(Nodo head, Nodo tail, int tamannio) {
        this.head = null;
        this.tail = null;
        this.tamannio = 0;
    }

    /**
     * Agrega un pastor al final de la mesa.
     * 
     * @param p El pastor a agregar.
     */
    public void addPastor(Pastor p){
        Nodo nuevo= new Nodo(p);

        if (head == null) { // Mesa vacía
            head = tail = nuevo;
            head.setSiguiente(head);
            head.setAnterior(head);
        } else {
            tail.setSiguiente(nuevo);
            nuevo.setAnterior(tail);
            nuevo.setSiguiente(head);
            head.setAnterior(nuevo);
            tail = nuevo;
        }
        tamannio++;
    }

    /**
     * Elimina un pastor de la mesa.
     * 
     * @param p El pastor a eliminar.
     */
    public void deletePastor(Pastor p){
        if (head == null) return; // Valida si la lista está vacía
        Nodo actual = head; 
        do { 
            if (actual.getPastor().equals(p)) {
                if (actual == head && actual == tail) {
                    // Caso especial: único nodo en la lista
                    head = tail = null;
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());

                    if (actual == head) head = actual.getSiguiente();
                    if (actual == tail) tail = actual.getAnterior();
                }
                tamannio--;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != head);  
    }

    /**
     * Reordena la mesa para que no haya dos pastores con el mismo oficio consecutivos.
     * Si encuentra dos pastores consecutivos con el mismo oficio, intercambia el siguiente
     * con el primer candidato válido más adelante en la lista.
     */
    public void reordenarMesa() {
        if (head == null) return;

        Nodo actual = head;
        do {
            if (!verificarCondicionMesa(actual)) {
                Nodo candidato = actual.getSiguiente().getSiguiente();
                while (candidato != head && actual.getPastor().getOficio().equals(candidato.getPastor().getOficio())) {
                    candidato = candidato.getSiguiente();
                }
                if (candidato != head) {
                    Pastor temp = actual.getSiguiente().getPastor();
                    actual.getSiguiente().setPastor(candidato.getPastor());
                    candidato.setPastor(temp);
                }
            }
            actual = actual.getSiguiente();
        } while (actual != head);
    }

    /**
     * Verifica si el nodo y su siguiente cumplen la condición de no tener el mismo oficio.
     * 
     * @param nodo Nodo a verificar.
     * @return true si el nodo y su siguiente tienen oficios diferentes, false en caso contrario.
     */
    public boolean verificarCondicionMesa(Nodo nodo){
        if (nodo == null) 
            return true;
        Pastor pastorActual = nodo.getPastor();
        Pastor pastorSiguiente = nodo.getSiguiente().getPastor();
        if (pastorActual.getOficio().equals(pastorSiguiente.getOficio()))
            return false;
        return true;
    }

    /**
     * Obtiene el tamaño actual de la mesa.
     * 
     * @return El número de pastores en la mesa.
     */
    public int getTamannio() {
        return tamannio;
    }

    /**
     * Obtiene el nodo cabeza de la mesa.
     * 
     * @return El nodo cabeza de la mesa.
     */
    public Nodo getHead() {
        return head;
    }
    
}