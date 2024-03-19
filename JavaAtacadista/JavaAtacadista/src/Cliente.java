import java.util.Random;

public class Cliente {
    private String nomeCliente;
    private String cpf;
    private double palpiteCliente;
    private int palpiteArredondado;
    Random random = new Random();
    public Cliente(String nomeCliente, String cpf) {
        setNomeCliente(nomeCliente);
        setCpf(cpf);
    }

    public int getPalpiteArredondado() {
        return palpiteArredondado;
    }

    //CONVERTE O TOTAL DECIMAL EM INTEIRO
    public void setPalpiteArredondado() {
        this.palpiteArredondado = (int)Math.floor(palpiteCliente);
    }

    public double getPalpiteCliente() {
        return palpiteCliente;
    }

    //GERA UM PALPITE ALEATORIO DO CLIENTE
    public void setPalpiteCliente() {
        if(palpiteCliente != 0){throw new IllegalStateException("Não pode mudar o palpite");}
        this.palpiteCliente =  random.nextDouble(5000) + 1;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    //ADICIONA O NOME DO CLIENTE
    public void setNomeCliente(String nomeCliente) {
        if(nomeCliente == null || nomeCliente.isBlank()){throw new IllegalStateException("O nome não pode ser nulo ou vazio");}
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    //ADICIONA O NUMERO DE CPF DO CLIENTE
    public void setCpf(String cpf) {
        if(cpf == null || cpf.isBlank()){throw new IllegalStateException("O numero de CPF não pode ser nulo ou vazio");}
        cpf = cpf.trim();
        if(cpf.length() > 14 || !cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos com ou sem pontuação .-");
        }
        this.cpf = cpf;
    }
}
