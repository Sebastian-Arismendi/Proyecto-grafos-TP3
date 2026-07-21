package com.mycompany.proyectografos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices;
    private List<Arista> aristas;

    // Constructor vacío (para cuando se empieza a dibujar desde cero)
    public Grafo() {
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
    }

    // Constructor optimizado para grafos no dirigidos (evita bucles y duplicados)
    public Grafo(int n, int[][] matriz) {
        this();
        for (int i = 0; i < n; i++) {
            vertices.add(new Vertice(i));
        }
        
        // Recorremos solo la mitad superior de la matriz (j = i + 1)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matriz[i][j] != 0) {
                    aristas.add(new Arista(vertices.get(i), vertices.get(j)));
                }
            }
        }
    }

    public void agregarVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }

    public void agregarArista(Arista arista) {
        this.aristas.add(arista);
    }
    
    public void eliminarVertice(Vertice v) {
        if (v == null) return;
        
        // 1. Eliminar todas las aristas conectadas a este vértice
        aristas.removeIf(a -> a.getOrigen().equals(v) || a.getDestino().equals(v));
        
        // 2. Eliminar el vértice
        vertices.remove(v);
        
        // 3. Reorganizar las IDs (V0, V1, V2...) para que queden consecutivas
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).setId(i);
        }
    }

    public void vaciar() {
        vertices.clear();
        aristas.clear();
    }

    public List<Vertice> getVertices() { return vertices; }
    public List<Arista> getAristas() { return aristas; }
}