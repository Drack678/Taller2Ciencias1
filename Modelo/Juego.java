package Modelo;

public class Juego {
    private int turno;
    private Mesa mesa;
    private int numeroPastores;
    
    public Juego() {
        this.turno = 0;
        this.mesa = new Mesa();
        this.numeroPastores = 0;
    }

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

    public int getnumeroPastores() {
        return numeroPastores;
    }
    public Mesa getMesa() {
        return mesa;
    }

}
