package com.calculadora.juros.visao;

import javax.swing.*;
import java.awt.*;

public class ExemploCalculos extends JFrame {

    public ExemploCalculos() {
        setTitle("Exemplo Calculos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 750);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));

        // Adiciona as imagens ao painel principal
        String[] imagePaths = {
                "/imagens/30.jpg",
                "/imagens/31.jpg",
                "/imagens/32.jpg",
                "/imagens/33.jpg"
        };

        // Adiciona labels com as imagens
        for (String path : imagePaths) {
            ImageIcon image = new ImageIcon(getClass().getResource(path));
            Image scaledImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setOpaque(true);
            label.setBackground(Color.decode("#E2FADB"));
            mainPanel.add(label);
        }

        // Adiciona o painel principal ao JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Botão "Voltar"
        JButton botao = new JButton("Voltar");
        botao.setBackground(Color.decode("#E2FADB"));
        botao.setForeground(Color.decode("#040F0F"));
        botao.setFont(new Font("Garamond", Font.BOLD, 25));
        botao.addActionListener(e -> new Home());
        botao.addActionListener(e -> dispose());

        // Painel para o botão
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Layout para centralizar o botão
        buttonPanel.setOpaque(true); // Permitir que o JLabel seja desenhado com sua cor de fundo
        buttonPanel.setBackground(Color.decode("#E2FADB")); // Define a cor de fundo
        buttonPanel.add(botao);

        // Adiciona o painel do botão ao final do JFrame
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploCalculos();
    }

}