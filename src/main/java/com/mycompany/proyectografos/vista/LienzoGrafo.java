package com.mycompany.proyectografos.vista;

import com.mycompany.proyectografos.modelo.Grafo;
import com.mycompany.proyectografos.modelo.Vertice;
import com.mycompany.proyectografos.modelo.Arista;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class LienzoGrafo extends JPanel {

    private Grafo grafo = new Grafo();
    private Vertice nodoSeleccionado = null; // Para crear aristas entre dos clics
    private Runnable alCambiarGrafo; // Callback para avisar a VentanaPrincipal que se actualice la tabla

   public LienzoGrafo() {
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            // =========================================================
            // 1. SI ES CLIC DERECHO: BORRAR EL NODO SELECCIONADO
            // =========================================================
            if (javax.swing.SwingUtilities.isRightMouseButton(e)) {
                Vertice nodoABorrar = obtenerNodoEnCoordenadas(x, y);
                if (nodoABorrar != null) {
                    grafo.eliminarVertice(nodoABorrar);
                    
                    // Si el nodo borrado estaba seleccionado para crear una arista, deseleccionarlo
                    if (nodoSeleccionado == nodoABorrar) {
                        nodoSeleccionado = null;
                    }
                    
                    repaint();
                    if (alCambiarGrafo != null) {
                        alCambiarGrafo.run(); // Actualiza la JTable
                    }
                }
                return; // Salir para no procesar como clic izquierdo
            }

            // =========================================================
            // 2. SI ES CLIC IZQUIERDO: CREAR NODO O ARISTA (CÓDIGO EXISTENTE)
            // =========================================================
            Vertice nodoClickeado = obtenerNodoEnCoordenadas(x, y);

            if (nodoClickeado == null) {
                // Clic en espacio vacío -> Crear nuevo Nodo
                int idNuevo = grafo.getVertices().size();
                Vertice nuevoVertice = new Vertice(idNuevo, x, y);
                grafo.agregarVertice(nuevoVertice);
                nodoSeleccionado = null;
            } else {
                // Clic sobre un nodo existente
                if (nodoSeleccionado == null) {
                    nodoSeleccionado = nodoClickeado;
                } else if (nodoSeleccionado != nodoClickeado) {
                    grafo.agregarArista(new Arista(nodoSeleccionado, nodoClickeado));
                    nodoSeleccionado = null;
                }
            }

            repaint();
            if (alCambiarGrafo != null) {
                alCambiarGrafo.run();
            }
        }
    });
}

    public void setAlCambiarGrafoListener(Runnable listener) {
        this.alCambiarGrafo = listener;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
        repaint();
    }

    private Vertice obtenerNodoEnCoordenadas(int x, int y) {
        int radio = 20;
        for (Vertice v : grafo.getVertices()) {
            // Distancia euclidiana
            double d = Math.hypot(v.getX() - x, v.getY() - y);
            if (d <= radio) {
                return v;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (grafo == null || grafo.getVertices().isEmpty()) {
            g.drawString("Haz clic aquí para crear nodos y conéctalos haciendo clic de uno a otro.", 20, 30);
            return;
        }

        // 1. Dibujar Aristas
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        for (Arista a : grafo.getAristas()) {
            g2d.drawLine(a.getOrigen().getX(), a.getOrigen().getY(), 
                         a.getDestino().getX(), a.getDestino().getY());
        }

        // 2. Dibujar Vértices
        int radio = 20;
        FontMetrics fm = g2d.getFontMetrics();

        for (Vertice v : grafo.getVertices()) {
            // Cambiar color si está seleccionado esperando conexión
            if (v == nodoSeleccionado) {
                g2d.setColor(Color.ORANGE);
            } else {
                g2d.setColor(new Color(100, 149, 237)); // Azul
            }

            g2d.fillOval(v.getX() - radio, v.getY() - radio, 2 * radio, 2 * radio);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(v.getX() - radio, v.getY() - radio, 2 * radio, 2 * radio);

            // Identificador del nodo
            String txt = "V" + v.getId();
            int w = fm.stringWidth(txt);
            g2d.drawString(txt, v.getX() - (w / 2), v.getY() + 5);
        }
    }
}