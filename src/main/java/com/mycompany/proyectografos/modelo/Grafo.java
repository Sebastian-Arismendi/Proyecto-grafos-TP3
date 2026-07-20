
package com.mycompany.proyectografos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private int numVertices;
    private int numAristas; // <-- NUEVO: Para seguimiento de memoria
    private int[][] matrizAdyacencia;
    private List<Vertice> vertices;
    private List<Arista> aristas;

    public Grafo(int numVertices, int[][] matriz) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = matriz;
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
        this.numAristas = 0; // Inicializar en 0
        
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertice(String.valueOf((char)('A' + i))));
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j] != 0) {
                    aristas.add(new Arista(vertices.get(i), vertices.get(j), matrizAdyacencia[i][j]));
                    numAristas++; // <-- Incrementamos el contador aquí
                }
            }
        }
    }

    // Métodos de evaluación de memoria
    public long calcularMemoriaMatrizAdyacencia() {
        return (long) numVertices * numVertices * 4; 
    }

    public long calcularMemoriaListaAdyacencia() {
        // Estimación: 16 bytes overhead objeto + 8 bytes datos por arista
        return (numVertices * 4) + (numAristas * 24); 
    }

    public List<Vertice> getVertices() { return vertices; }
    public List<Arista> getAristas() { return aristas; }
}
