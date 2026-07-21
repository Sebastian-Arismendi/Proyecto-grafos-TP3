package com.mycompany.proyectografos.controlador;

import com.mycompany.proyectografos.modelo.Grafo;
import com.mycompany.proyectografos.modelo.Vertice;
import com.mycompany.proyectografos.modelo.Arista;

import java.util.List;

/**
 *
 * @author sebas
 */
public class GrafoControlador {
    private Grafo modelo;
    
    // Recibe los datos crudos desde la Vista (ej. desde la matriz inicial)
    public void procesarEntrada(int n, int[][] matriz) {
        if (esMatrizValida(n, matriz)) {
            // El controlador "controla" la instanciación del modelo
            this.modelo = new Grafo(n, matriz);
            System.out.println("Grafo creado exitosamente con " + n + " vértices.");
        } else {
            // Manejo de errores definido en tu diagrama de estados
            System.err.println("Error: La matriz no es válida o está vacía.");
        }
    }

    public Grafo getGrafo() {
        return this.modelo;
    }

    public void setGrafo(Grafo modelo) {
        this.modelo = modelo;
    }

    // Validación segura mejorada para evitar ArrayIndexOutOfBoundsException
    private boolean esMatrizValida(int n, int[][] matriz) {
        return matriz != null && n > 0 && matriz.length == n && matriz[0].length == n;
    }
    
    // Método para exponer la información al usuario en consola
    public void imprimirReporteMemoria() {
        if (modelo != null) {
            if (modelo.getVertices() != null) {
                modelo.getVertices().forEach(System.out::println);
            }
            if (modelo.getAristas() != null) {
                modelo.getAristas().forEach(System.out::println);
            }
        }
    }

    // =========================================================================
    // MATRIZ DE INCIDENCIA
    // =========================================================================
    public Object[][] generarMatrizIncidencia() {
        return generarMatrizIncidencia(this.modelo);
    }

    public Object[][] generarMatrizIncidencia(Grafo grafo) {
        if (grafo == null || grafo.getVertices() == null) {
            return new Object[0][0];
        }

        List<Vertice> vertices = grafo.getVertices();
        List<Arista> aristas = grafo.getAristas();

        int numVertices = vertices.size();
        int numAristas = (aristas != null) ? aristas.size() : 0;

        // La matriz de incidencia tiene dimensiones (Vértices x Aristas)
        Object[][] matriz = new Object[numVertices][numAristas];

        // 1. Inicializar todas las celdas en 0
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numAristas; j++) {
                matriz[i][j] = 0;
            }
        }

        // 2. Marcar con 1 las conexiones entre Vértices y Aristas
        if (aristas != null) {
            for (int col = 0; col < numAristas; col++) {
                Arista arista = aristas.get(col);
                int idxOrigen = vertices.indexOf(arista.getOrigen());
                int idxDestino = vertices.indexOf(arista.getDestino());

                if (idxOrigen != -1) matriz[idxOrigen][col] = 1;
                if (idxDestino != -1) matriz[idxDestino][col] = 1;
            }
        }

        return matriz;
    }

    // =========================================================================
    // 1. MATRIZ DE ADYACENCIA
    // =========================================================================
    public Object[][] generarMatrizAdyacencia() {
        if (modelo == null || modelo.getVertices() == null) return new Object[0][0];

        List<Vertice> vertices = modelo.getVertices();
        List<Arista> aristas = modelo.getAristas();
        int n = vertices.size();
        
        Object[][] matriz = new Object[n][n];

        // Inicializar en 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = 0;
            }
        }

        // Marcar con 1 las conexiones existentes (simétrico para grafos no dirigidos)
        if (aristas != null) {
            for (Arista a : aristas) {
                int u = vertices.indexOf(a.getOrigen());
                int v = vertices.indexOf(a.getDestino());
                if (u != -1 && v != -1) {
                    matriz[u][v] = 1;
                    matriz[v][u] = 1; // Asegura la simetría bidireccional
                }
            }
        }

        // Forzar ceros en la diagonal principal para evitar bucles o lazos fantasma
        for (int i = 0; i < n; i++) {
            matriz[i][i] = 0;
        }

        return matriz;
    }

    // =========================================================================
    // 2. LISTA DE ADYACENCIA
    // =========================================================================
    public Object[][] generarListaAdyacencia() {
        if (modelo == null || modelo.getVertices() == null) {
            return new Object[0][0];
        }

        int n = modelo.getVertices().size();
        Object[][] datos = new Object[n][2];
        
        // Obtenemos la matriz de adyacencia usando el método interno
        Object[][] matrizAdy = generarMatrizAdyacencia();
        
        for (int i = 0; i < n; i++) {
            datos[i][0] = "V" + i; // Nombre del vértice
            
            StringBuilder adyacentes = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Verificamos si hay conexión (1) y evitamos agregarse a sí mismo en la diagonal
                if (matrizAdy[i][j] != null && Integer.parseInt(matrizAdy[i][j].toString()) == 1 && i != j) {
                    adyacentes.append("V").append(j).append(" ");
                }
            }
            datos[i][1] = adyacentes.toString().trim();
        }
        return datos;
    }

    // =========================================================================
    // 3. LISTA DE ARISTAS
    // =========================================================================
    public Object[][] generarListaAristas() {
        if (modelo == null || modelo.getAristas() == null) return new Object[0][0];

        List<Arista> aristas = modelo.getAristas();
        int m = aristas.size();

        Object[][] datos = new Object[m][3];

        for (int i = 0; i < m; i++) {
            Arista a = aristas.get(i);
            datos[i][0] = "V" + a.getOrigen().getId();
            datos[i][1] = "V" + a.getDestino().getId();
            datos[i][2] = "1"; // Peso por defecto
        }

        return datos;
    }

    // =========================================================================
    // REPORTE DE MEMORIA
    // =========================================================================
    public String obtenerReporteMemoriaActual(String tipoEstructura) {
        int v = (modelo != null && modelo.getVertices() != null) ? modelo.getVertices().size() : 0;
        int e = (modelo != null && modelo.getAristas() != null) ? modelo.getAristas().size() : 0;
        
        long bytesEstimados = 0;
        switch (tipoEstructura != null ? tipoEstructura : "") {
            case "Matriz de Adyacencia":
                bytesEstimados = (long) v * v * 4; // Enteros (4 bytes por celda)
                break;
            case "Matriz de Incidencia":
                bytesEstimados = (long) v * e * 4; // Vértices x Aristas
                break;
            case "Lista de Adyacencia":
                bytesEstimados = (v * 24L) + (e * 16L); // Estimación de objetos y referencias
                break;
            case "Lista de Aristas":
                bytesEstimados = (long) e * 24; // Estimación por cada arista guardada
                break;
        }
        return "Consumo estimado de memoria (" + tipoEstructura + "): " + bytesEstimados + " bytes";
    }
}