package Modelo;

public class Juego {
    private int turno;
    private Mesa mesa;
    private Nodo nodoActual;
    private int numeroPastores;
    private final int pastoresRecorrer = 3;
    
    public Juego() {
        this.turno = 1;
        this.mesa = new Mesa();
        this.numeroPastores = 0;
    }

    // Getters && Setters
    public int getTurno() {
        return turno;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void initMesa(int n){
        this.numeroPastores = n;
        Generador generador = new Generador();
        for (int i = 0; i < n; i++) {
            Pastor nuevoPastor = generador.generarPastor();
            mesa.addPastor(nuevoPastor);
        }
    }

    public void setPastorActual() {
        if (mesa.getHead() != null && turno == 1){
            int contador = 0; // No hay pastores en la mesa{
            do{
                Nodo actual = mesa.getHead();
                nodoActual = actual;
                Nodo n = actual;
                if(n.getPastor().getTesoro()>nodoActual.getPastor().getTesoro()){
                    nodoActual = n;
                }
                actual = actual.getSiguiente();
                contador++;
            }
            while (contador < mesa.getTamannio());
        }
    }
    public void jugar(String accion, String direccion){
        if(accion.equals("robar")){
            
        } else if (accion.equals("revivir")){
            // Lógica para intercambiar
        } else if (accion.equals("eliminar")){
            Nodo n = nodoActual.getSiguiente();
            Nodo temp = nodoActual.getSiguiente();
            for (int i = 0; i < pastoresRecorrer; i++) {
                if(n.getPastor().getTesoro()<temp.getPastor().getTesoro()){
                    temp = n;
                }
            }   
        }

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
