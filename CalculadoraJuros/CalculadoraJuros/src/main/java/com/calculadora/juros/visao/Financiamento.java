package com.calculadora.juros.visao;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class Financiamento extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel resultadoLabel;

    public Financiamento() {
        // PAINEL SUPERIOR
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#E2FADB"));
        panel.setBounds(0, 0, 750, 150);
        panel.setLayout(null);

        // PAINEL INFERIOR
        JPanel panelBotao = new JPanel();
        panelBotao.setBackground(Color.decode("#DBEFBC"));
        panelBotao.setBounds(0, 150, 750, 600);
        panelBotao.setLayout(null);

        //SETOR DOS 4 TEXTFIELD'S
        textField = new JTextField();
        textField.setBounds(250, 200, 200, 30);
        textField.setBackground(Color.decode("#E2FADB"));
        textField.setVisible(true);
        add(textField);

        textField2 = new JTextField();
        textField2.setBounds(250, 300, 200, 30);
        textField2.setVisible(true);
        textField2.setBackground(Color.decode("#E2FADB"));
        add(textField2);

        textField3 = new JTextField();
        textField3.setBounds(250, 400, 200, 30);
        textField3.setVisible(true);
        textField3.setBackground(Color.decode("#E2FADB"));
        add(textField3);

        textField4 = new JTextField();
        textField4.setBounds(250, 500, 200, 30);
        textField4.setVisible(true);
        textField4.setBackground(Color.decode("#E2FADB"));
        add(textField4);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border roundedBorder = BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );

        textField.setBorder(roundedBorder);
        textField2.setBorder(roundedBorder);
        textField3.setBorder(roundedBorder);
        textField4.setBorder(roundedBorder);

        // ADICIONA OS TEXTFIELD'S AO JFRAME
        getContentPane().add(textField, BorderLayout.CENTER);

        //SETOR DOS TEXTOS QUE REPRESENTAM OS TEXTFIELD'S
        JLabel text = new JLabel("Nº de meses");
        text.setBounds(20, 200, 200, 30);
        text.setFont(new Font("Garamond", Font.BOLD, 20));
        text.setForeground(Color.decode("#040F0F"));
        text.setVisible(true);
        add(text);

        JLabel text2 = new JLabel("Taxa de juros mensal");
        text2.setBounds(20, 300, 200, 30);
        text2.setFont(new Font("Garamond", Font.BOLD, 20));
        text2.setForeground(Color.decode("#040F0F"));
        text2.setVisible(true);
        add(text2);

        JLabel text3 = new JLabel("Valor da prestação");
        text3.setBounds(20, 400, 200, 30);
        text3.setFont(new Font("Garamond", Font.BOLD, 20));
        text3.setForeground(Color.decode("#040F0F"));
        text3.setVisible(true);
        add(text3);

        JLabel text4 = new JLabel("Valor Financiado");
        text4.setBounds(20, 500, 200, 30);
        text4.setFont(new Font("Garamond", Font.BOLD, 20));
        text4.setForeground(Color.decode("#040F0F"));
        text4.setVisible(true);
        add(text4);

        //SETOR DO CABEÇALHO
        JLabel titulo = new JLabel("Simulador Financiamento");
        titulo.setFont(new Font("Garamond", Font.BOLD, 38));
        titulo.setForeground(Color.decode("#040F0F"));
        titulo.setBounds(0, 0, 500, 100);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVisible(true);
        panel.add(titulo);

        JLabel subtitulo = new JLabel("Preencha 3 campos para obter o resultado do 4º");
        subtitulo.setFont(new Font("Roboto", Font.ITALIC, 11));
        subtitulo.setForeground(Color.decode("#040F0F"));
        subtitulo.setBounds(40, 80, 400, 50);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        subtitulo.setVisible(true);
        panel.add(subtitulo);

        //SETOR DOS BOTÕES
        JButton botao = new JButton("Calcular");
        botao.setSize(100, 20);
        botao.setLocation(20, 440);
        botao.setBackground(Color.decode("#E2FADB"));
        botao.setForeground(Color.decode("#040F0F"));
        botao.setFont(new Font("Roboto", Font.BOLD, 13));
        botao.addActionListener(this);
        panelBotao.add(botao);

        JButton botao2 = new JButton("Limpar");
        botao2.setSize(100, 20);
        botao2.setLocation(135, 440);
        botao2.setBackground(Color.decode("#E2FADB"));
        botao2.setForeground(Color.decode("#040F0F"));
        botao2.setFont(new Font("Roboto", Font.BOLD, 13));
        botao2.addActionListener(this);
        panelBotao.add(botao2);

        JButton botao4 = new JButton("Imprimir");
        botao4.setSize(100, 20);
        botao4.setLocation(365, 440);
        botao4.setBackground(Color.decode("#E2FADB"));
        botao4.setForeground(Color.decode("#040F0F"));
        botao4.setFont(new Font("Roboto", Font.BOLD, 13));
        botao4.addActionListener(this);
        panelBotao.add(botao4);

        JButton botao3 = new JButton("Voltar");
        botao3.setSize(100, 20);
        botao3.setLocation(250, 440);
        botao3.setBackground(Color.decode("#E2FADB"));
        botao3.setForeground(Color.decode("#040F0F"));
        botao3.setFont(new Font("Roboto", Font.BOLD, 13));
        botao3.addActionListener(this);
        panelBotao.add(botao3);

        //LABEL DO RESULTADO
        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setFont(new Font("Roboto", Font.BOLD, 13));
        resultadoLabel.setForeground(Color.decode("#040F0F"));
        resultadoLabel.setBounds(10, 470, 500, 60);
        resultadoLabel.setVisible(true);
        panelBotao.add(resultadoLabel);

        // JFRAME EM QUE COLOCO OS PAINEIS
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 750);
        setTitle("Financiamento");
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel);
        add(panelBotao);
    }

    //MÉTODO RESPONSÁVEL POR REALIZAR OS CÁLCULOS
    public void calcular() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat("#.##", otherSymbols);
        double valorPrestacao;
        double taxaJuros;
        int numMeses;
        double jurosTotal;
        double valorPresente;
        double valorFuturo;

        try{
        //VERIFICADOR SE ESTÁ FALTADO O VALOR FINANCIADO
        if (!textField.getText().isEmpty() && !textField2.getText().isEmpty() && !textField3.getText().isEmpty() && textField4.getText().isEmpty()) {
            valorPrestacao = Double.parseDouble(textField3.getText());
            taxaJuros = Double.parseDouble(textField2.getText())/100;
            numMeses = Integer.parseInt(textField.getText());
            if (numMeses <= 0 || valorPrestacao <= 0 || taxaJuros <= 0) {
                throw new NumberFormatException();
            }
            valorFuturo = valorPrestacao * numMeses;
            valorPresente = (valorFuturo / Math.pow(1 + taxaJuros, numMeses));
            jurosTotal = valorFuturo - valorPresente;
            resultadoLabel.setText("<html>O valor total do financiamento de " + numMeses + " parcelas de R$" + df.format(valorPrestacao)
                    + " é: R$" + df.format(valorFuturo) +"<br>sendo R$" + df.format(jurosTotal) + " em juros!</html>");
            textField4.setText(df.format(valorPresente));
        //VERIFICADOR SE ESTÁ FALTANDO O VALOR DA PRESTAÇÃO
        } else if(!textField.getText().isEmpty() && !textField2.getText().isEmpty() && textField3.getText().isEmpty() && !textField4.getText().isEmpty()){
            valorPresente = Double.parseDouble(textField4.getText());
            taxaJuros = Double.parseDouble(textField2.getText())/100;
            numMeses = Integer.parseInt(textField.getText());
            if (numMeses <= 0 || valorPresente <= 0 || taxaJuros <= 0) {
                throw new NumberFormatException();
            }
            valorFuturo = valorPresente * (Math.pow(1 + taxaJuros, numMeses));
            valorPrestacao = valorFuturo / numMeses;
            jurosTotal = valorFuturo - valorPresente;
            resultadoLabel.setText("<html>O total do financiamento de " + numMeses + " parcelas de R$" + df.format(valorPrestacao)
                    + " é: R$" + df.format(valorFuturo) +"<br>sendo R$" + df.format(jurosTotal) + " em juros!</html>");
            textField3.setText(df.format(valorPrestacao));
        //VERIFICADOR SE ESTÁ FALTANDO A TAXA DE JUROS
        } else if(!textField.getText().isEmpty() && textField2.getText().isEmpty() && !textField3.getText().isEmpty() && !textField4.getText().isEmpty()){
            valorPresente = Double.parseDouble(textField4.getText());
            valorPrestacao = Double.parseDouble(textField3.getText());
            numMeses = Integer.parseInt(textField.getText());
            if (numMeses <= 0 || valorPrestacao <= 0 || valorPresente <= 0) {
                throw new NumberFormatException();
            }
            valorFuturo = numMeses * valorPrestacao;
            jurosTotal = valorFuturo - valorPresente;
            taxaJuros = (Math.pow(valorFuturo / valorPresente, 1.0 / numMeses) - 1) * 100;
            resultadoLabel.setText("<html>O total do financiamento de " + numMeses + " parcelas de R$" + df.format(valorPrestacao)
                    + " é: R$" + df.format(valorFuturo) +"<br>sendo R$" + df.format(jurosTotal) + " em juros!</html>");
            textField2.setText(df.format(taxaJuros));
        //VERIFICADOR SE ESTÁ FALTANDO O NUMERO DE MESES
        } else if(textField.getText().isEmpty() && !textField2.getText().isEmpty() && !textField3.getText().isEmpty() && !textField4.getText().isEmpty()) {
            valorPresente = Double.parseDouble(textField4.getText());
            valorPrestacao = Double.parseDouble(textField3.getText());
            taxaJuros = Double.parseDouble(textField2.getText())/100;
            if (valorPresente <= 0 || valorPrestacao <= 0 || taxaJuros <= 0) {
                throw new NumberFormatException();
            }
            valorFuturo = valorPresente;
            numMeses = 1;
            while (valorFuturo > 0) {
                valorFuturo += (1 + taxaJuros) - valorPrestacao;
                numMeses++;
            }
            valorFuturo = valorPrestacao * numMeses;
            jurosTotal = valorFuturo - valorPresente;
            resultadoLabel.setText("<html>O total do financiamento de " + numMeses + " parcelas de R$" + df.format(valorPrestacao)
                    + " é: R$" + df.format(valorFuturo) +"<br>sendo R$" + df.format(jurosTotal) + " em juros!</html>");
            textField.setText(String.valueOf(numMeses));
        //CASO ESTEJA PREENCHIDO 1, 2 OU 4 CAMPOS E CASO O USUARIO PREENCHA UM VALOR INVÁLIDO, RETORNA MENSAGEM DE ERRO
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha exatamente 3 campos.");
        } }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira números válidos nos campos.");
            }
    }

    //MÉTODO PARA VOLTAR PARA A PÁGINA HOME E FECHAR A JANELA ATUAL
    public void voltar(){
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }

    //MÉTODO COM OS ACTIONPERFORMED DOS BOTOES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calcular")) {
            calcular();
        } else if (e.getActionCommand().equals("Limpar")) {
            limpar();
        } else if (e.getActionCommand().equals("Voltar")) {
            voltar();
        } else if (e.getActionCommand().equals("Imprimir")){
            imprimir();
        }
    }

    //MÉTODO PARA IMPRIMIR
    private void imprimir() {
        // Captura a tela como uma imagem
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        paint(graphics);

        // Cria um documento PDF
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("tela.pdf"));
            document.open();
            // Adiciona a imagem ao PDF
            Image pdfImage = Image.getInstance(image, null);
            document.add(pdfImage);
            document.close();
            JOptionPane.showMessageDialog(this, "Tela impressa em PDF com sucesso!");
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao imprimir a tela em PDF: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    //MÉTODO PARA LIMPAR OS TEXTFIELD'S
    private void limpar() {
        textField.setText(null);
        textField2.setText(null);
        textField3.setText(null);
        textField4.setText(null);
        resultadoLabel.setText(null);
    }

    public static void main(String[] args) {
        new Financiamento();
    }
}