package com.mycompany.proyectografos.vista;

import com.mycompany.proyectografos.controlador.GrafoControlador;
import com.mycompany.proyectografos.modelo.Grafo; 
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author sebas
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
private GrafoControlador controlador = new GrafoControlador();
    /**
     * Creates new form VentanaPrincipal
     */
 public VentanaPrincipal() {
    initComponents();
    
    // Configuración de escuchadores
    cmbEstructura.addActionListener(evt -> actualizarVistaTabla());
    ((LienzoGrafo) panelgrafo).setAlCambiarGrafoListener(() -> {
        actualizarVistaTabla();
    });
    
    actualizarVistaTabla();
}

@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btonConvertir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        cmbmatriz = new javax.swing.JButton();
        panelgrafo = new com.mycompany.proyectografos.vista.LienzoGrafo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbEstructura = new javax.swing.JComboBox<>();
        lblMemoria = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnLeerArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        btonConvertir.setText("Convertir");
        btonConvertir.addActionListener(this::btonConvertirActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        cmbmatriz.setText("CambiarMatriz");
        cmbmatriz.addActionListener(this::cmbmatrizActionPerformed);

        panelgrafo.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout panelgrafoLayout = new javax.swing.GroupLayout(panelgrafo);
        panelgrafo.setLayout(panelgrafoLayout);
        panelgrafoLayout.setHorizontalGroup(
            panelgrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        panelgrafoLayout.setVerticalGroup(
            panelgrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        jLabel1.setText("Graficadora de Grafo");

        jLabel2.setText("Ingresar tamaño de matriz");

        cmbEstructura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matriz de Adyacencia", "Matriz de Incidencia", "Lista de Adyacencia", "Lista de Aristas" }));

        lblMemoria.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Evaluación del consumo de memoria");

        jButton1.setText("Salir");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnExportar.setText("Guardar");
        btnExportar.addActionListener(this::btnExportarActionPerformed);

        btnLeerArchivo.setText("Cargar");
        btnLeerArchivo.addActionListener(this::btnLeerArchivoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbEstructura, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(467, 467, 467))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(cmbmatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btonConvertir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panelgrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnLeerArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(118, 118, 118)))
                            .addComponent(lblMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEstructura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelgrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbmatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btonConvertir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLeerArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void actualizarVistaTabla() {
    LienzoGrafo lienzo = (LienzoGrafo) panelgrafo;
    Grafo grafoActual = lienzo.getGrafo();
    
    // Si el grafo no tiene vértices, no forzamos una recarga vacía si el usuario acaba de crear una tabla manual
    if (grafoActual == null || (grafoActual.getVertices() != null && grafoActual.getVertices().isEmpty())) {
        return; 
    }
    
    controlador.setGrafo(grafoActual);

    String seleccion = (cmbEstructura.getSelectedItem() != null) 
                        ? cmbEstructura.getSelectedItem().toString() 
                        : "Matriz de Adyacencia";

    Object[][] datos = new Object[0][0];
    String[] columnas = new String[0];
    int numVertices = (grafoActual.getVertices() != null) ? grafoActual.getVertices().size() : 0;

    switch (seleccion) {
        case "Matriz de Adyacencia":
            datos = controlador.generarMatrizAdyacencia();
            columnas = new String[numVertices];
            for (int i = 0; i < numVertices; i++) columnas[i] = "V" + i;
            break;

        case "Matriz de Incidencia":
            datos = controlador.generarMatrizIncidencia();
            int numAristas = (grafoActual.getAristas() != null) ? grafoActual.getAristas().size() : 0;
            columnas = new String[numAristas];
            for (int i = 0; i < numAristas; i++) columnas[i] = "e" + i;
            break;

        case "Lista de Adyacencia":
            datos = controlador.generarListaAdyacencia();
            columnas = new String[]{"Vértice", "Nodos Adyacentes"};
            break;

        case "Lista de Aristas":
            datos = controlador.generarListaAristas();
            columnas = new String[]{"Origen", "Destino", "Peso"};
            break;
    }

    DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return true; // Permitir edición para poder interactuar
        }
    };
    
    jTable1.setModel(modeloTabla);

    // Actualizar la etiqueta con la evaluación del consumo de memoria en tiempo real
    String reporteMemoria = controlador.obtenerReporteMemoriaActual(seleccion);
    lblMemoria.setText(reporteMemoria);
}
    private void btonConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonConvertirActionPerformed
try {
        int n = jTable1.getRowCount();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Object valor = jTable1.getValueAt(i, j);
                
                // Si la celda está vacía, la interpretamos como 0
                if (valor == null || valor.toString().trim().isEmpty()) {
                    matriz[i][j] = 0;
                } else {
                    int val = Integer.parseInt(valor.toString().trim());
                    
                    // Validación estricta: solo se permiten 0 y 1
                    if (val != 0 && val != 1) {
                        JOptionPane.showMessageDialog(
                            this, 
                            "Valor inválido en la celda (" + i + ", " + j + "). Solo se permiten los valores 0 y 1.", 
                            "Error de validación", 
                            JOptionPane.WARNING_MESSAGE
                        );
                        return; // Detiene el proceso y no genera un grafo incorrecto
                    }
                    
                    matriz[i][j] = val;
                }
            }
        }

        // 1. Procesar la matriz en el controlador para construir el grafo
        controlador.procesarEntrada(n, matriz);
        Grafo grafoGenerado = controlador.getGrafo();

        // 2. Centrar y distribuir los nodos en círculo automáticamente en el panel
        if (grafoGenerado != null && grafoGenerado.getVertices() != null) {
            int anchoPanel = panelgrafo.getWidth();
            int altoPanel = panelgrafo.getHeight();
            
            if (anchoPanel <= 0) anchoPanel = 588; 
            if (altoPanel <= 0) altoPanel = 563;

            int centroX = anchoPanel / 2;
            int centroY = altoPanel / 2;
            int radio = Math.min(centroX, centroY) - 60;

            int totalVertices = grafoGenerado.getVertices().size();
            for (int i = 0; i < totalVertices; i++) {
                double angulo = 2 * Math.PI * i / totalVertices;
                int x = (int) (centroX + radio * Math.cos(angulo));
                int y = (int) (centroY + radio * Math.sin(angulo));
                
                grafoGenerado.getVertices().get(i).setX(x);
                grafoGenerado.getVertices().get(i).setY(y);
            }
        }

        // 3. Enviar el grafo centrado al lienzo y repintar
        ((LienzoGrafo) panelgrafo).setGrafo(grafoGenerado);
        panelgrafo.repaint();

        // 4. Refrescar la vista de la tabla
        actualizarVistaTabla();

        JOptionPane.showMessageDialog(this, "¡Grafo generado y centrado exitosamente!");
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            this, 
            "Por favor, asegúrate de ingresar únicamente números enteros (0 o 1) en la tabla.", 
            "Formato incorrecto", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btonConvertirActionPerformed

    private void cmbmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmatrizActionPerformed
 try {
        int n = Integer.parseInt(jTextField1.getText().trim());

        // Crear una matriz de N x N vacía para que el usuario escriba
        DefaultTableModel modeloMatriz = new DefaultTableModel(n, n) {
            @Override
            public String getColumnName(int column) {
                return "V" + column;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return true; // Asegurar que se pueda escribir en ella
            }
        };
        
        jTable1.setModel(modeloMatriz);
        cmbEstructura.setSelectedItem("Matriz de Adyacencia");
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa un número entero válido para el tamaño.");
    }
    }//GEN-LAST:event_cmbmatrizActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
        this, 
        "¿Estás seguro de que deseas salir de la aplicación?", 
        "Confirmar salida", 
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );
    
    if (opcion == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
     LienzoGrafo lienzo = (LienzoGrafo) panelgrafo;
    if (lienzo.getGrafo() != null) {
        lienzo.getGrafo().vaciar();
    }
    lienzo.setGrafo(null);
    panelgrafo.repaint();
    
    // 2. Vaciar la tabla
    jTable1.setModel(new DefaultTableModel());
    
    // 3. Limpiar campos de texto y etiquetas
    jTextField1.setText("");
    lblMemoria.setText("");
    
    JOptionPane.showMessageDialog(this, "Área de trabajo limpiada exitosamente.");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Guardar reporte de resultados");
    
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File archivoDestino = fileChooser.getSelectedFile();
        
        // Asegurar que termine en .txt
        String ruta = archivoDestino.getAbsolutePath();
        if (!ruta.toLowerCase().endsWith(".txt")) {
            archivoDestino = new java.io.File(ruta + ".txt");
        }
        
        try (java.io.PrintWriter writer = new java.io.PrintWriter(archivoDestino, "UTF-8")) {
            writer.println("=========================================");
            writer.println("       REPORTE DE GRAFOS Y MEMORIA       ");
            writer.println("=========================================");
            writer.println("Estructura analizada: " + cmbEstructura.getSelectedItem());
            writer.println(lblMemoria.getText());
            writer.println("\n-----------------------------------------");
            writer.println("DATOS DE LA TABLA ACTUAL:");
            writer.println("-----------------------------------------");
            
            javax.swing.table.TableModel modelo = jTable1.getModel();
            int filas = modelo.getRowCount();
            int columnas = modelo.getColumnCount();
            
            // Escribir cabeceras de columnas
            for (int c = 0; c < columnas; c++) {
                writer.print(modelo.getColumnName(c) + "\t");
            }
            writer.println();
            
            // Escribir filas de datos
            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {
                    Object valor = modelo.getValueAt(f, c);
                    writer.print((valor != null ? valor.toString() : "") + "\t");
                }
                writer.println();
            }
            
            writer.println("=========================================");
            JOptionPane.showMessageDialog(this, "¡Resultados exportados con éxito a " + archivoDestino.getName() + "!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + ex.getMessage(), "Error de E/S", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnLeerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerArchivoActionPerformed
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Cargar grafo desde archivo");
    
    int userSelection = fileChooser.showOpenDialog(this);
    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File archivoSeleccionado = fileChooser.getSelectedFile();
        
        java.util.List<String[]> lineasDatos = new java.util.ArrayList<>();
        String[] columnas = null;
        
        try (java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(new java.io.FileInputStream(archivoSeleccionado), "UTF-8"))) {
            
            String linea;
            boolean leyendoTabla = false;
            
            while ((linea = reader.readLine()) != null) {
                // Detectar dónde comienzan los datos de la tabla en el archivo de texto exportado
                if (linea.contains("DATOS DE LA TABLA ACTUAL:")) {
                    reader.readLine(); // Saltar la línea de guiones "-----------------------------------------"
                    String lineaCabecera = reader.readLine(); // Leer la línea con los nombres de columnas (V0, V1...)
                    if (lineaCabecera != null) {
                        columnas = lineaCabecera.split("\t");
                    }
                    leyendoTabla = true;
                    continue;
                }
                
                // Si estamos en la sección de la tabla, leemos las filas separadas por tabulaciones
                if (leyendoTabla) {
                    if (linea.startsWith("===") || linea.trim().isEmpty()) {
                        break; // Fin de la tabla
                    }
                    String[] partes = linea.split("\t");
                    lineasDatos.add(partes);
                }
            }
            
            if (columnas == null || lineasDatos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El archivo no tiene el formato de tabla esperado.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Construir la matriz de datos para el DefaultTableModel
            int numFilas = lineasDatos.size();
            int numCols = columnas.length;
            Object[][] datosMatriz = new Object[numFilas][numCols];
            
            for (int i = 0; i < numFilas; i++) {
                String[] fila = lineasDatos.get(i);
                for (int j = 0; j < numCols; j++) {
                    // Si es una matriz de adyacencia, omitimos la primera columna de etiqueta de fila si la hubiera, 
                    // o cargamos directamente los valores numéricos.
                    datosMatriz[i][j] = (j < fila.length) ? fila[j] : "";
                }
            }
            
            // Si la tabla exportada incluye la columna "Vértice" al inicio (como en listas), 
            // asegurarnos de limpiar para dejar solo la matriz numérica cuadrada si es Matriz de Adyacencia.
            // Para Matriz de Adyacencia pura (donde las columnas son V0, V1...):
            DefaultTableModel modeloCargado = new DefaultTableModel(datosMatriz, columnas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return true;
                }
            };
            
            jTable1.setModel(modeloCargado);
            cmbEstructura.setSelectedItem("Matriz de Adyacencia");
            
            // Disparar automáticamente la conversión para dibujar el grafo en el lienzo
            btonConvertirActionPerformed(null);
            
            JOptionPane.showMessageDialog(this, "¡Grafo y datos cargados exitosamente desde el archivo!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al leer o procesar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnLeerArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnLeerArchivo;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btonConvertir;
    private javax.swing.JComboBox<String> cmbEstructura;
    private javax.swing.JButton cmbmatriz;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMemoria;
    private javax.swing.JPanel panelgrafo;
    // End of variables declaration//GEN-END:variables
}
