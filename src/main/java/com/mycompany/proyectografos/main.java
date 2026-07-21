
package com.mycompany.proyectografos;

import com.mycompany.proyectografos.vista.VentanaPrincipal;

public class main {
    public static void main(String[] args) {
        // Asegura que la interfaz gráfica corra en el hilo seguro de Swing
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}