package Modelo;

/**
 * La clase Juego representa la lógica principal del juego de pastores.
 * Controla el flujo de turnos, las acciones posibles (robar, revivir, eliminar), 
 * y mantiene la referencia a la mesa de juego, la pila de pastores eliminados y el pastor actual.
 */
public class Juego {
    private int turno; // Número de turno actual
    private Mesa mesa; // Mesa de juego (lista circular de pastores)
    private Pila pilaEliminados; // Pila de pastores eliminados
    private Nodo nodoActual; // Nodo del pastor que tiene el turno actual
    private int numeroPastores; // Número total de pastores en la mesa
    private final int pastoresRecorrer = 3; // Número de pastores a recorrer para eliminar

    /**
     * Constructor de la clase Juego.
     * Inicializa el turno, la mesa, la pila de eliminados y el número de pastores.
     */
    public Juego() {
        this.turno = 1;
        this.mesa = new Mesa();
        this.pilaEliminados = new Pila();
        this.numeroPastores = 0;
    }

    /**
     * Obtiene el número de turno actual.
     * @return el turno actual.
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Establece el número de turno actual.
     * @param turno el turno a establecer.
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * Inicializa la mesa con una cantidad dada de pastores generados aleatoriamente.
     * @param n número de pastores a agregar a la mesa.
     */
    public void initMesa(int n) {
        this.numeroPastores = n;
        Generador generador = new Generador();
        for (int i = 0; i < n; i++) {
            Pastor nuevoPastor = generador.generarPastor();
            mesa.addPastor(nuevoPastor);
        }
    }

    /**
     * Establece el pastor actual para el turno.
     * Si es el primer turno, selecciona el pastor con mayor tesoro.
     */
    public void setPastorActual() {
        if (mesa.getHead() != null && turno == 1) {
            int contador = 0;
            do {
                Nodo actual = mesa.getHead();
                nodoActual = actual;
                Nodo n = actual;
                if (n.getPastor().getTesoro() > nodoActual.getPastor().getTesoro()) {
                    nodoActual = n;
                }
                actual = actual.getSiguiente();
                contador++;
            } while (contador < mesa.getTamannio());
        }
    }

    /**
     * Ejecuta una acción en el turno actual.
     * Las acciones pueden ser: "robar", "revivir" o "eliminar".
     * @param accion la acción a realizar ("robar", "revivir", "eliminar").
     * @param direccion la dirección para eliminar ("derecha" o "izquierda").
     */
    public void jugar(String accion, String direccion) {
        if (accion.equals("robar")) {
            Nodo masRico = encontrarPastorMasRico(mesa.getHead());
            int tesoroRobado = masRico.getPastor().getTesoro() / 3;
            int feligresesRobados = masRico.getPastor().getFeligreses() / 3;
            nodoActual.getPastor().setTesoro(nodoActual.getPastor().getTesoro() + tesoroRobado);
            nodoActual.getPastor().setFeligreses(nodoActual.getPastor().getFeligreses() + feligresesRobados);
            masRico.getPastor().setTesoro(masRico.getPastor().getTesoro() - tesoroRobado);
            masRico.getPastor().setFeligreses(masRico.getPastor().getFeligreses() - feligresesRobados);
            nodoActual = masRico;
        }
        else if (accion.equals("revivir")) {
            Nodo nodoRevivido = pilaEliminados.pop();
            nodoRevivido.getPastor().setTesoro(nodoActual.getPastor().getTesoro() / 2);
            nodoRevivido.getPastor().setFeligreses(nodoActual.getPastor().getFeligreses() / 2);
            nodoActual.getPastor().setTesoro(nodoActual.getPastor().getTesoro() / 2);
            nodoActual.getPastor().setFeligreses(nodoActual.getPastor().getFeligreses() / 2);
            mesa.addPastor(nodoRevivido.getPastor());
            mesa.reordenarMesa();
            nodoActual = nodoRevivido;
        } 
        else if (accion.equals("eliminar")) {
            Nodo masPobre = encontrarPastorMasPobre(nodoActual.getSiguiente(), direccion);
            mesa.deletePastor(masPobre.getPastor());
            pilaEliminados.push(masPobre);
            mesa.reordenarMesa();
            nodoActual = nodoActual.getSiguiente();
        }

    }

    /**
     * Busca el pastor más pobre en una dirección específica a partir de un nodo.
     * @param inicio nodo desde el cual comenzar la búsqueda.
     * @param direccion dirección de búsqueda ("derecha" o "izquierda").
     * @return el nodo del pastor más pobre encontrado.
     */
    public Nodo encontrarPastorMasPobre(Nodo inicio, String direccion) {
        Nodo actual = inicio;
        Nodo masPobre = actual;
        if (direccion.equals("derecha")) {
            for (int i = 0; i < pastoresRecorrer; i++) {
                if (actual.getPastor().getTesoro() < masPobre.getPastor().getTesoro()) {
                    masPobre = actual;
                }
                actual = actual.getSiguiente();
            }
        } else if (direccion.equals("izquierda")) {
            for (int i = 0; i < pastoresRecorrer; i++) {
                if (actual.getPastor().getTesoro() < masPobre.getPastor().getTesoro()) {
                    masPobre = actual;
                }
                actual = actual.getAnterior();
            }
        }
        return masPobre;
    }

    /**
     * Busca el pastor más pobre en toda la mesa.
     * @return el nodo del pastor más pobre.
     */
    public Nodo encontrarPastorMaspobre() {
        Nodo actual = mesa.getHead();
        Nodo masPobre = actual;
        for (int i = 0; i < mesa.getTamannio(); i++) {
            if (actual.getPastor().getTesoro() < masPobre.getPastor().getTesoro()) {
                masPobre = actual;
            }
            actual = actual.getSiguiente();
        }
        return masPobre;
    }

    /**
     * Busca el pastor más rico en toda la mesa a partir de un nodo.
     * @param inicio nodo desde el cual comenzar la búsqueda.
     * @return el nodo del pastor más rico.
     */
    public Nodo encontrarPastorMasRico(Nodo inicio) {
        Nodo actual = inicio;
        Nodo masRico = actual;
        for (int i = 0; i < mesa.getTamannio(); i++) {
            if (actual.getPastor().getTesoro() > masRico.getPastor().getTesoro()) {
                masRico = actual;
            }
            actual = actual.getSiguiente();
        }
        return masRico;
    }

    /**
     * Establece el nodo actual (pastor actual del turno).
     * @param nodoActual el nodo a establecer como actual.
     */
    public void setNodorActual(Nodo nodoActual) {
        this.nodoActual = nodoActual;
    }

    /**
     * Obtiene el nodo actual (pastor actual del turno).
     * @return el nodo actual.
     */
    public Nodo getNodoActual() {
        return nodoActual;
    }

    /**
     * Obtiene el número de pastores en la mesa.
     * @return el número de pastores.
     */
    public int getnumeroPastores() {
        return numeroPastores;
    }

    /**
     * Obtiene la mesa de juego.
     * @return la mesa.
     */
    public Mesa getMesa() {
        return mesa;
    }

}