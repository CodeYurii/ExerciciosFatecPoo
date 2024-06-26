// Autor: Yuri Seixeiro
// Data Criação: 08/05/2024
// Última Modificação: 13/05/2024

/*
    * Caso queira criar uma tabela, descomentar o método criarTabela() na main
    * O sistema aceita conexão no UsbWebServer e no Oracle
    * Caso queira mudar a conxeão de banco de dados, descomentar criarConexao() e descomentar o método excluir() referente ao BD desejado
 */

package com.sistema.agendamento.visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Agendamento {
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtDataPedido;
    private JTextField txtValor;
    private JTextField txtPedido;
    private JTable table1;
    private JButton readButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton createButton;
    private JTextField txtConsultaID;
    private JPanel Tela;
    private JButton BuscarTodos;
    private Long id;

    //Construtor com os ActionListener dos botões
    public Agendamento() {

        //Criar
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Ler
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });

        //Ler todos
        BuscarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarTodos();
            }
        });

        //Deletar
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excluir();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Atualizar
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    atualizar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    //Método para conectar ao Banco de Dados Oracle
    private static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                "CLIENTE",
                "cliente"
        );
    }

    /*
    //Método para conectar ao Banco de Dados UsbWebServer
    private static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendamento",
                "root",
                "usbw"
        );
    }*/

    /*
    //Método para criar uma nova tabela no Banco de Dados Oracle
    public static void criarTabela() throws SQLException {
        try (Connection conexao = getConexao()) {
            String query = "CREATE TABLE clientes(" +
                    "id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
                    "nome VARCHAR2(255) NOT NULL," +
                    "telefone VARCHAR2(20) NOT NULL," +
                    "endereco VARCHAR2(255) NOT NULL," +
                    "data_ultimo_pedido DATE NOT NULL ," +
                    "ultimo_pedido VARCHAR2(255) NOT NULL," +
                    "valor NUMBER NOT NULL," +
                    ")";
            PreparedStatement sql = conexao.prepareStatement(query);
            sql.execute();
        }
    }*/

    //Método para criar uma nova tabela no Banco de Dados UsbWebServer
    public static void criarTabela() throws SQLException {
        try (Connection conexao = getConexao()) {
            String query = "CREATE TABLE clientes(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL," +
                    "telefone VARCHAR(20) NOT NULL," +
                    "endereco VARCHAR(255) NOT NULL," +
                    "data_ultimo_pedido DATE NOT NULL," +
                    "ultimo_pedido VARCHAR(255) NOT NULL," +
                    "valor DECIMAL(10, 2) NOT NULL" +
                    ")";
            PreparedStatement sql = conexao.prepareStatement(query);
            sql.execute();
        }
    }

    //Método para salvar os JTextFields no Banco de Dados. Primeiro cria uma conexao e ja prepara o comando a ser realizado no BD,
    // depois faz a validação dos JTextFields e finaliza salvando os dados
    private void salvar() throws SQLException {
        //Cria uma conexão e prepara o comando
        try (Connection conexao = getConexao()) {
            PreparedStatement sql = conexao.prepareStatement(
                    "INSERT INTO clientes(nome, telefone, endereco, data_ultimo_pedido, ultimo_pedido, valor) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");

            //Verificadores de entrada do usuário
            String nome = txtNome.getText();
            if(nome.isEmpty() || !nome.matches("[a-zA-Z ]+")){
                JOptionPane.showMessageDialog(null, "Preencha o nome corretamente", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String telefone = txtTelefone.getText();
            if(telefone.isEmpty() || !telefone.matches("\\d{11}")){
                JOptionPane.showMessageDialog(null, "Preencha o Telefone corretamente (Ex: 11912345678)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String endereco = txtEndereco.getText();
            if(endereco.isEmpty() || !endereco.matches("[a-zA-Z0-9 ]+")){
                JOptionPane.showMessageDialog(null, "Preencha o endereço corretamente (Ex: Rua Joao das Couves 121)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String dataPedido = txtDataPedido.getText();
            if(dataPedido.isEmpty() || !dataPedido.matches("\\d{2}/\\d{2}/\\d{2}")){
                JOptionPane.showMessageDialog(null, "Preencha a data do pedido corretamente (Ex: 12/05/24)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String[] partes = dataPedido.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
                JOptionPane.showMessageDialog(null, "A data do pedido contém valores inválidos", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String pedido = txtPedido.getText();
            if(pedido.isEmpty() || !pedido.matches("[a-zA-Z ]+")){
                JOptionPane.showMessageDialog(null, "Preencha o pedido corretamente (Ex: Pizza Frango com catupiry)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String valorTexto = txtValor.getText();
            if(valorTexto.isEmpty() || !valorTexto.matches("[0-9]+([,]\\d+)?")) {
                JOptionPane.showMessageDialog(null, "Preencha o valor corretamente (Ex: 74,50)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Realiza a inserção dos dados no BD
            sql.setString(1, txtNome.getText());
            sql.setString(2, txtTelefone.getText());
            sql.setString(3, txtEndereco.getText());
            sql.setString(4, txtDataPedido.getText());
            sql.setString(6, txtValor.getText());
            sql.setString(5, txtPedido.getText());
            sql.execute();
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente! " + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    //Método para excluir uma linha no Oracle
    public void excluir() throws SQLException {
        try (Connection conexao = getConexao()) {
            PreparedStatement sql = conexao.prepareStatement(
                    "DELETE FROM clientes WHERE id=?"
            );
            String idTexto = txtConsultaID.getText();
            if (idTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira o ID do cliente a ser exluido.");
                return;
            }
            sql.setLong(1, Long.parseLong(txtConsultaID.getText()));
            ResultSet resultado = sql.executeQuery();
            if(resultado.next()){
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
            }else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado, digite um ID válido!");
            }
        }
    }*/
    //Método para excluir uma linha no WebServer
    public void excluir() throws SQLException {
        try (Connection conexao = getConexao()) {
            PreparedStatement sql = conexao.prepareStatement(
                    "DELETE FROM clientes WHERE id=?"
            );
            String idTexto = txtConsultaID.getText();
            if (idTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira o ID do cliente a ser excluído.");
                return;
            }
            long id = Long.parseLong(idTexto);
            sql.setLong(1, id);

            int linhasAfetadas = sql.executeUpdate(); // Usar executeUpdate() aqui

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para o ID fornecido.");
            }
        }
    }


    //Método para atualizar dados de clientes no BD
    public void atualizar() throws SQLException {
        // Verifica se o campo de ID está vazio
        String idTexto = txtConsultaID.getText();
        if (idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira o ID do cliente a ser atualizado.");
            return;
        }
        try (Connection conexao = getConexao()) {
            // Constrói a consulta SQL base
            StringBuilder query = new StringBuilder("UPDATE clientes SET ");

            // Constrói a lista de parâmetros e seus valores
            List<Object> parametros = new ArrayList<>();

            //Verificadores se foi feito um append na query ou se houve um erro, caso nao tenha append ou tenha erro será salvo nenhum dado no BD
            int verificadorQuery = 0;
            int erro = 0;

            // Adiciona os campos atualizados à consulta e seus valores à lista de parâmetros
            if (!txtNome.getText().isEmpty()) {
                if(txtNome.getText().matches("[a-zA-Z ]+")){
                    query.append("nome=?, ");
                    parametros.add(txtNome.getText());
                    verificadorQuery++;
                } else {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Preencha o nome corretamente", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (!txtTelefone.getText().isEmpty()) {
                if(txtTelefone.getText().matches("\\d{11}")) {
                    query.append("telefone=?, ");
                    parametros.add(txtTelefone.getText());
                    verificadorQuery++;
                } else {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Preencha o Telefone corretamente (Ex: 11912345678)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (!txtEndereco.getText().isEmpty()) {
                if(txtEndereco.getText().matches("[a-zA-Z0-9 ]+")) {
                    query.append("endereco=?, ");
                    parametros.add(txtEndereco.getText());
                    verificadorQuery++;
                } else {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Preencha o endereço corretamente (Ex: Rua Joao das Couves 121)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (!txtDataPedido.getText().isEmpty()) {
                if (txtDataPedido.getText().matches("\\d{2}/\\d{2}/\\d{2}")) {
                    String dataPedido = txtDataPedido.getText();
                    String[] partes = dataPedido.split("/");
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int ano = Integer.parseInt(partes[2]);
                    if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
                        erro++;
                        JOptionPane.showMessageDialog(null, "A data do pedido contém valores inválidos", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        query.append("data_ultimo_pedido=?, ");
                        parametros.add(txtDataPedido.getText());
                        verificadorQuery++;
                    }
                } else {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Preencha a data do pedido corretamente (Ex: 12/05/24)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (!txtPedido.getText().isEmpty()) {
                if(txtPedido.getText().matches("[a-zA-Z ]+")) {
                    query.append("ultimo_pedido=?, ");
                    parametros.add(txtPedido.getText());
                    verificadorQuery++;
                } else {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Preencha o pedido corretamente (Ex: Pizza Frango com catupiry)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (!txtValor.getText().isEmpty()) {
                if (txtValor.getText().matches("[0-9]+([,]\\d+)?")) {
                query.append("valor=?, ");
                parametros.add(txtValor.getText());
                verificadorQuery++;
                } else {
                    erro++;
                    JOptionPane.showMessageDialog(null, "Preencha o valor corretamente (Ex: 74,50)", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Remova a vírgula final da consulta
            query.deleteCharAt(query.length() - 2);

            //Condição que verifica se foi adicionado SET na query e se nao existe erros
            if(verificadorQuery > 0 && erro == 0) {
                // Adiciona o ID a consulta
                query.append("WHERE id=?");
                parametros.add(Long.parseLong(txtConsultaID.getText()));

                // Cria a declaração preparada com a consulta final
                PreparedStatement sql = conexao.prepareStatement(query.toString());

                // Define os valores dos parâmetros
                for (int i = 0; i < parametros.size(); i++) {
                    sql.setObject(i + 1, parametros.get(i));
                }

                // Executa a atualização
                int rowsAffected = sql.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum cliente atualizado. Verifique os dados e tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente atualizado. Verifique os dados e tente novamente.");

            }
        }
    }

    //Método de busca por ID que retorna o registro no BD
    public void buscar() {
        try (Connection conexao = getConexao()) {
            PreparedStatement sql = conexao.prepareStatement(
                    "SELECT * FROM clientes WHERE id=?"
            );
            if (txtConsultaID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
                return;
            }
            sql.setLong(1, Long.parseLong(txtConsultaID.getText()));
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                DefaultTableModel model = new DefaultTableModel();

                // Adiciona as colunas ao modelo com os nomes dos metadados do ResultSet
                ResultSetMetaData metaData = resultado.getMetaData();
                int columnCount = metaData.getColumnCount();
                Vector<String> columnNames = new Vector<>();
                for (int column = 1; column <= columnCount; column++) {
                    columnNames.add(metaData.getColumnName(column));
                }
                model.setColumnIdentifiers(columnNames);

                // Adiciona os dados do cliente à linha do modelo
                Vector<Object> row = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object value = resultado.getObject(columnIndex);
                    if (value instanceof java.sql.Timestamp) {
                        java.sql.Timestamp timestampValue = (java.sql.Timestamp) value;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        value = dateFormat.format(timestampValue);
                    }
                    row.add(value);
                }
                model.addRow(row);

                // Insere o modelo de tabela na tabela
                table1.setModel(model);
            } else {
                // Caso não exista um registro com o ID fornecido
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    //Método de busca que retorna todos os registros no BD
    public void buscarTodos() {
        try (Connection conexao = getConexao()) {
            String sql = "SELECT * FROM clientes";
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            for (int column = 1; column <= columnCount; column++) {
                String columnName = metaData.getColumnName(column);
                columnNames.add(columnName);
            }
            model.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object value = rs.getObject(columnIndex);
                    if (value instanceof java.sql.Timestamp) {
                        java.sql.Timestamp timestampValue = (java.sql.Timestamp) value;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        value = dateFormat.format(timestampValue);
                    }
                    row.add(value);
                }
                model.addRow(row);
            }
            table1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Retire o comentario para criar uma tabela
        //criarTabela();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Agendamento");
            frame.setContentPane(new Agendamento().Tela);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}