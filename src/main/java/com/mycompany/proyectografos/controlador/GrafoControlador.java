
package com.mycompany.proyectografos.controlador;
import com.mycompany.proyectografos.modelo.Grafo;


public class GrafoControlador {
    private Grafo modelo;

    // Recibe los datos crudos desde la Vista (ej. desde un campo de texto en Tkinter/Swing)
    public void procesarEntrada(int n, int[][] matriz) {
        if (esMatrizValida(n, matriz)) {
            // El controlador "controla" la instanciación del modelo
            this.modelo = new Grafo(n, matriz);
            System.out.println("Grafo creado exitosamente con " + n + " vértices.");
        } else {
            // Manejo de errores definido en tu diagrama de estados
            System.err.println("Error: La matriz no es válida.");
        }
    }

    private boolean esMatrizValida(int n, int[][] matriz) {
        // Lógica de validación antes de tocar el modelo
        return matriz.length == n && matriz[0].length == n;
    }
    
    // Método para exponer la información al usuario
    public void imprimirEstructura() {
        if (modelo != null) {
            modelo.getVertices().forEach(System.out::println);
            modelo.getAristas().forEach(System.out::println);
        }
    }
}