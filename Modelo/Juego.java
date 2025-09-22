package Modelo;

public class Juego {
    private int turno;
    private Mesa mesa;
    private Pila pilaEliminados;
    private Nodo nodoActual;
    private int numeroPastores;
    private final int pastoresRecorrer = 3;

    public Juego() {
        this.turno = 1;
        this.mesa = new Mesa();
        this.pilaEliminados = new Pila();
        this.numeroPastores = 0;
    }

    // Getters && Setters
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void initMesa(int n) {
        this.numeroPastores = n;
        Generador generador = new Generador();
        for (int i = 0; i < n; i++) {
            Pastor nuevoPastor = generador.generarPastor();
            mesa.addPastor(nuevoPastor);
        }
    }

    public void setPastorActual() {
        if (mesa.getHead() != null && turno == 1) {
            int contador = 0; // No hay pastores en la mesa{
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

    public Nodo encontrarPastorMasPobre(Nodo inicio, String direccion) {
        Nodo actual = inicio;
        Nodo masPobre = actual;
        if (direccion.equals("derecha")) {
            for (int i = 0; i < pastoresRecorrer; i++) {
                if (actual.getPastor().getTesoro() < masPobre.getPastor().getTesoro()) {
                    masPobre = actual; // actualizamos nodo más pobre
                }
                actual = actual.getSiguiente(); // avanzar en la lista circular
            }
        } else if (direccion.equals("izquierda")) {
            for (int i = 0; i < pastoresRecorrer; i++) {
                if (actual.getPastor().getTesoro() < masPobre.getPastor().getTesoro()) {
                    masPobre = actual; // actualizamos nodo más pobre
                }
                actual = actual.getAnterior(); // avanzar en la lista circular
            }
        }
        return masPobre;
    }

    public Nodo encontrarPastorMaspobre() {
        Nodo actual = mesa.getHead();
        Nodo masPobre = actual;
        for (int i = 0; i < mesa.getTamannio(); i++) {
            if (actual.getPastor().getTesoro() < masPobre.getPastor().getTesoro()) {
                masPobre = actual; // actualizamos nodo más pobre
            }
            actual = actual.getSiguiente(); // avanzar en la lista circular
        }
        return masPobre;
    }

    public Nodo encontrarPastorMasRico(Nodo inicio) {
        Nodo actual = inicio;
        Nodo masRico = actual;
        for (int i = 0; i < mesa.getTamannio(); i++) {
            if (actual.getPastor().getTesoro() > masRico.getPastor().getTesoro()) {
                masRico = actual; // actualizamos nodo más rico
            }
            actual = actual.getSiguiente(); // avanzar en la lista circular
        }
        return masRico;
    }

    public void setNodorActual(Nodo nodoActual) {
        this.nodoActual = nodoActual;
    }

    public Nodo getNodoActual() {
        return nodoActual;
    }

    public int getnumeroPastores() {
        return numeroPastores;
    }

    public Mesa getMesa() {
        return mesa;
    }

}
