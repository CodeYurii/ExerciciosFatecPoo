import java.util.ArrayList;

/**
 * Classe Horista representa um Funcionario do tipo Horista.
 * Esta classe estende a classe Funcionario e adiciona atributos e metodos especificos para Funcionarios do tipo Horista.
 */
public class Horista extends Funcionario{
    private int horaTrabalhada;
    private double valorPorHora;
    protected ArrayList<Horista> listaFuncionarioHorista = new ArrayList<>();

    /**
     * Construtor da classe Horista.
     * @param cpf CPF do funcionário.
     * @param nome Nome do funcionário.
     * @param tipo Tipo de contratação do funcionário
     * @param horaTrabalhada A quantidade de horas trabalhadas pelo funcionário Horista.
     * @param valorPorHora O valor pago por hora para um funcionário Horista.
     */
    public Horista(String cpf, String nome, String tipo, int horaTrabalhada, double valorPorHora) {
        super(cpf, nome, tipo);
        setHoraTrabalhada(horaTrabalhada);
        setValorPorHora(valorPorHora);
        listaFuncionarioHorista.add(this);
    }

    /**
     * Metodo para calcular o salário de um Funcionario do tipo Horista.
     * @return A multiplicaçao das horas trabalhadas pelo valor pago por hora.
     */
    public double calculoSalarioHorista(){
        return getHoraTrabalhada() * getValorPorHora();
    }
    public int getHoraTrabalhada() {
        return horaTrabalhada;
    }

    public void setHoraTrabalhada(int horaTrabalhada) {
        this.horaTrabalhada = horaTrabalhada;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    /**
     * Método que adiciona o valor por hora pago a um funcionário horista e verifica se ele é maior que 0.
     * @param valorPorHora Valor por hora pago a um funcionário horista.
     */
    public void setValorPorHora(double valorPorHora) {
        if(valorPorHora <= 0){throw new IllegalStateException("O valor por hora recebido pelo funcionário tem de ser maior que 0");}
        this.valorPorHora = valorPorHora;
    }
}
