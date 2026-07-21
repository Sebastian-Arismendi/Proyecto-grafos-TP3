package com.mycompany.proyectografos.modelo;

public class Arista {
    private Vertice origen;
    private Vertice destino;

    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Vertice getOrigen() { return origen; }
    public void setOrigen(Vertice origen) { this.origen = origen; }

    public Vertice getDestino() { return destino; }
    public void setDestino(Vertice destino) { this.destino = destino; }

    @Override
    public String toString() {
        return "(" + origen + " -> " + destino + ")";
    }
}