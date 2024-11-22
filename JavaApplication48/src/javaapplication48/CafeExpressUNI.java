/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



package cafeexpressuni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeExpressUNI extends JFrame {
    private int clientesAtendidos = 0;
    private int[] cafesVendidos = new int[3]; // Índices: 0 - pequeño, 1 - mediano, 2 - grande
    private double totalEnCaja = 0;

    public CafeExpressUNI() {
        setTitle("Café Express UNI");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JLabel lblTamano = new JLabel("Tamaño del café:");
        String[] tamanos = {"Pequeño (Lps. 45)", "Mediano (Lps. 56)", "Grande (Lps. 65)"};
        JComboBox<String> cmbTamano = new JComboBox<>(tamanos);

        JLabel lblAgregado = new JLabel("Agregado:");
        String[] agregados = {"Leche (Lps. 5)", "Cremora (Lps. 8)", "Sencillo (Lps. 0)"};
        JComboBox<String> cmbAgregado = new JComboBox<>(agregados);

        JLabel lblEdad = new JLabel("Edad del cliente:");
        JTextField txtEdad = new JTextField(3);

        JButton btnFacturar = new JButton("Facturar");

        btnFacturar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tamanoIndex = cmbTamano.getSelectedIndex();
                int agregadoIndex = cmbAgregado.getSelectedIndex();
                int edad = Integer.parseInt(txtEdad.getText());

                double precioCafe = 0;
                switch (tamanoIndex) {
                    case 0:
                        precioCafe = 45;
                        break;
                    case 1:
                        precioCafe = 56;
                        break;
                    case 2:
                        precioCafe = 65;
                        break;
                }

                double precioAgregado = 0;
                switch (agregadoIndex) {
                    case 0:
                        precioAgregado = 5;
                        break;
                    case 1:
                        precioAgregado = 8;
                        break;
                    case 2:
                        precioAgregado = 0;
                        break;
                }

                double total = precioCafe + precioAgregado;
                if (edad >= 18) {
                    total *= 0.75; // Descuento del 25%
                } else {
                    total *= 0.90; // Descuento del 10%
                }

                clientesAtendidos++;
                cafesVendidos[tamanoIndex]++;
                totalEnCaja += total;

                JOptionPane.showMessageDialog(null, "Total a pagar: Lps. " + total);
            }
        });

        JButton btnCerrarCaja = new JButton("Cerrar Caja");

        btnCerrarCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reporte = "Clientes atendidos: " + clientesAtendidos + "\n"
                        + "Cafés vendidos - Pequeños: " + cafesVendidos[0] + "\n"
                        + "Cafés vendidos - Medianos: " + cafesVendidos[1] + "\n"
                        + "Cafés vendidos - Grandes: " + cafesVendidos[2] + "\n"
                        + "Total en caja: Lps. " + totalEnCaja;
                JOptionPane.showMessageDialog(null, reporte);
            }
        });

        setLayout(new GridLayout(5, 2));
        add(lblTamano);
        add(cmbTamano);
        add(lblAgregado);
        add(cmbAgregado);
        add(lblEdad);
        add(txtEdad);
        add(btnFacturar);
        add(btnCerrarCaja);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CafeExpressUNI().setVisible(true);
            }
        });
    }
}
