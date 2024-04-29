package com.calculadora.juros.visao;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Home extends JFrame {

    public Home(){
        //IMPORTA A IMAGEM DE FUNDO DO CABEÇALHO
        ImageIcon image = new ImageIcon("src/main/resources/imagens/13.jpg");
        Image imagemMenor = image.getImage().getScaledInstance(600, 270, Image.SCALE_SMOOTH);
        JLabel jLabel = new JLabel(new ImageIcon(imagemMenor));
        jLabel.setBounds(0, 0, 600, 270);

        // JFRAME
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 750);
        setTitle("Home");
        setLocationRelativeTo(null);
        setLayout(null);

        // PAINEL SUPERIOR
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 270);
        add(panel);

        // TÍTULO E SUBTITULO DO CABEÇALHO
        JLabel titulo = new JLabel("Financia Já");
        titulo.setFont(new Font("Garamond", Font.BOLD, 55));
        titulo.setForeground(Color.decode("#040F0F"));
        titulo.setBounds(40, 70, 400, 100);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        JLabel subtitulo = new JLabel("Calcule seu financiamento");
        subtitulo.setFont(new Font("Garamond", Font.ITALIC, 25));
        subtitulo.setForeground(Color.decode("#040F0F"));
        subtitulo.setBounds(40, 140, 400, 50);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitulo);

        // PAINEL INFERIOR DOS BOTÕES
        JPanel panelBotao = new JPanel();
        panelBotao.setBackground(Color.decode("#DBEFBC"));
        panelBotao.setLayout(null); // Mesma observação sobre o layout null
        panelBotao.setBounds(0, 270, 500, 480); // Ajustado para o tamanho do JFrame
        add(panelBotao);

        //SETOR DOS BOTÕES
        Border border = BorderFactory.createLineBorder(Color.decode("#CFEBDF"), 1);
        JButton botao = new JButton("Financiamento");
        botao.setSize(250, 90);
        botao.setLocation(120, 120);
        botao.setBackground(Color.decode("#E2FADB"));
        botao.setForeground(Color.decode("#040F0F"));
        botao.setFont(new Font("Garamond", Font.BOLD, 25));
        botao.addActionListener(e -> new Financiamento());
        botao.addActionListener(e -> dispose());
        botao.setBorder(border);
        panelBotao.add(botao);

        JButton botao2 = new JButton("Exemplos Cálculo");
        botao2.setSize(250, 90);
        botao2.setLocation(120, 280);
        botao2.setBackground(Color.decode("#E2FADB"));
        botao2.setForeground(Color.decode("#040F0F"));
        botao2.setFont(new Font("Garamond", Font.BOLD, 25));
        botao2.setBorder(border);
        botao2.addActionListener(e -> new ExemploCalculos());
        botao2.addActionListener(e -> dispose());
        panelBotao.add(botao2);

        //LABEL DE INSTRUÇÃO
        JLabel instrucao = new JLabel("Selecione uma opção");
        instrucao.setFont(new Font("Garamond", Font.BOLD, 35));
        instrucao.setForeground(Color.decode("#040F0F"));
        instrucao.setBounds(45, 0, 400, 100);
        instrucao.setHorizontalAlignment(SwingConstants.CENTER);
        panelBotao.add(instrucao);

        // Adiciona a imagem de fundo após a configuração dos outros componentes para que não seja sobreposta
        panel.add(jLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }
}