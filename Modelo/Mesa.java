package Modelo;

public class Mesa {
    
    private Nodo head; // Primer nodo 
    private Nodo tail; // Nodo Final 
    private int tamannio; // tamaño de la mesa
    
    // Constructor de los nodos 
    public Mesa(Nodo head, Nodo tail, int tamannio) {
        this.head = null;
        this.tail = null;
        this.tamannio = 0;
    }
        // Se agregan los pastores al dinal de la mesa  
    public void addPastor(Pastor p){
        Nodo nuevo= new Nodo(p);

        if (head == null) { // Mesa vacía
            head = tail = nuevo;
            head.setSiguiente(head);
            head.setAnterior(head);
        }else {
            tail.setSiguiente(nuevo);
            nuevo.setAnterior(tail);
            nuevo.setSiguiente(head);
            head.setAnterior(nuevo);
            tail= nuevo;
        }
        tamannio++;
    }
        //Se elimina el pastor de la mesa 
    public void deletePastor(Pastor p){
        if (head==null) return; // valida si la lista esta vacia 
            Nodo actual = head;
            int contador = 0;
            
        do { 
            if (actual.getPastor().equals(p) ) {
                if (actual== head && actual == tail ) {
                    head = tail = null; // caso especial cuando se quiere eliminar el unico nodo de la lista
                }else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());

                    if (actual == head) head = actual.getSiguiente();
                    if (actual == tail) head = actual.getAnterior();
                }
                tamannio--;
            }
            actual= actual.getSiguiente();
            contador++;
        } while (actual != head && contador <= tamannio);
        
    }

    //Getter del tamaño para hacer comparaciones
    public int getTamannio() {
        return tamannio;
    }
    
}