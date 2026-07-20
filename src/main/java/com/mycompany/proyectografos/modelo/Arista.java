
package com.mycompany.proyectografos.modelo;

public class Arista {
    private final Vertice origen;
    private final Vertice destino;
    private final int peso;

    public Arista(Vertice origen, Vertice destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigen() { return origen; }
    public Vertice getDestino() { return destino; }
    public int getPeso() { return peso; }

    @Override
    public String toString() {
        return String.format("Arista[%s -> %s, peso=%d]", 
            origen.getId(), destino.getId(), peso);
    }
}
