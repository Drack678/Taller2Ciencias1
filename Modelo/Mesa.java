package Modelo;

/**
 * Clase que representa la mesa de juego como una lista circular doblemente
 * enlazada.
 * Permite almacenar y manipular nodos de tipo Pastor, asegurando las
 * condiciones
 * de vecindad y circularidad.
 */
public class Mesa {

    private Nodo head; // Primer nodo
    private Nodo tail; // Nodo Final
    private int tamannio; // tamaño de la mesa

    /**
     * Constructor para inicializar la mesa vacía.
     */
    public Mesa() {
        this.head = null;
        this.tail = null;
        this.tamannio = 0;
    }

    /**
     * Método para agregar un pastor a la mesa.
     * 
     * @param p el pastor a agregar
     */
    public void addPastor(Pastor p) {
        Nodo nuevo = new Nodo(p);

        if (head == null) {
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
     * Método para eliminar un pastor de la mesa.
     * 
     * @param p el pastor a eliminar
     */
    public void deletePastor(Pastor p) {
        if (head == null)
            return;
        Nodo actual = head;
        do {
            if (actual.getPastor().equals(p)) {
                if (actual == head && actual == tail) {
                    head = tail = null; // caso especial: único elemento
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                    if (actual == head)
                        head = actual.getSiguiente();
                    if (actual == tail)
                        tail = actual.getAnterior();
                }
                tamannio--;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != head);
    }
    
    /**
     * Revive un pastor desde la pila y lo agrega nuevamente a la mesa.
     * 
     * @param pila la pila de la cual se extraerá el pastor.
     * @return el pastor revivido, o null si la pila estaba vacía.
     */
    public Pastor revivirPastor(Pila pila) {
        if (pila == null || pila.estaVacia()) {
            return null; // No hay nada que revivir
        }

        Pastor pastorRevivido = pila.pop(); // Sacar el pastor de la pila
        addPastor(pastorRevivido);          // Volverlo a ingresar a la mesa
        return pastorRevivido;
    }

    /**
     * Verifica si el pastor dado tiene el menor tesoro entre todos en la mesa.
     * 
     * @param pastorSeleccionado el pastor que se quiere validar
     * @return true si el pastor tiene el menor tesoro, false en caso contrario
     */

    public boolean esTesoroMenor(Pastor pastorSeleccionado) {
        if (head == null || pastorSeleccionado == null) {
            return false;
        }

        IteradorMesa it = iterador();
        while (it.tieneSiguiente()) {
            Pastor actual = it.siguiente();

            // Evitamos comparar contra sí mismo
            if (actual.getId() != pastorSeleccionado.getId()) {
                if (pastorSeleccionado.getTesoro() > actual.getTesoro()) {
                    return false; // encontró uno menor → ya no es el menor
                }
            }
        }
        return true; // es menor a todos
    }

    public void reordenarMesa() {
        if (head == null)
            return;

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
     * Verifica si el nodo y su siguiente cumplen la condición de no tener el mismo
     * oficio.
     * 
     * @param nodo Nodo a verificar.
     * @return true si el nodo y su siguiente tienen oficios diferentes, false en
     *         caso contrario.
     */
    public boolean verificarCondicionMesa(Nodo nodo) {
        if (nodo == null)
            return true;
        Pastor pastorActual = nodo.getPastor();
        Pastor pastorSiguiente = nodo.getSiguiente().getPastor();
        if (pastorActual.getOficio().equals(pastorSiguiente.getOficio()))
            return false;
        return true;
    }

    /**
     * Clase interna que implementa un iterador seguro para recorrer
     * la mesa circular doblemente enlazada.
     */

    public static class IteradorMesa {
        private Nodo actual;
        private int elementosRestantes;

        /**
         * Constructor del iterador.
         * 
         * @param head     referencia al primer nodo
         * @param tamannio número de elementos a recorrer
         */
        public IteradorMesa(Nodo head, int tamannio) {
            this.actual = head;
            this.elementosRestantes = tamannio;
        }

        /**
         * Verifica si hay más elementos por recorrer.
         * 
         * @return true si hay más elementos, false en caso contrario
         */
        public boolean tieneSiguiente() {
            return elementosRestantes > 0 && actual != null;
        }

        /**
         * Retorna el siguiente pastor en la mesa.
         * 
         * @return pastor actual
         */
        public Pastor siguiente() {
            if (!tieneSiguiente()) {
                throw new IllegalStateException("No hay más elementos en la mesa");
            }
            Pastor p = actual.getPastor();
            actual = actual.getSiguiente(); // avanzar en la lista circular
            elementosRestantes--;
            return p;
        }
    }

    /**
     * Método que retorna el tamaño actual de la mesa.
     * 
     * @return número de elementos en la mesa
     */
    public int getTamannio() {
        return tamannio;
    }

    /**
     * Método que retorna el primer nodo de la mesa.
     * 
     * @return nodo inicial
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * Retorna un iterador para recorrer la mesa circular.
     * 
     * @return iterador de tipo IteradorMesa
     */
    public IteradorMesa iterador() {
        return new IteradorMesa(head, tamannio);
    }

}
