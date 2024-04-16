import java.util.ArrayList;

/**
 * A classe Mensalista representa um funcionário do tipo Mensalista.
 * Esta classe estende a classe Funcionario e adiciona atributos e métodos específicos para funcionários Mensalistas.
 */
public class Mensalista extends Funcionario{
    protected Cargo cargo;
    protected ArrayList<Mensalista>listaFuncionarioMensalista = new ArrayList<>();

    /**
     * Construtor da classe Mensalista.
     * @param cpf CPF do funcionário.
     * @param nome Nome do funcionário.
     * @param cargo Cargo associado ao funcionário mensalista.
     */
    public Mensalista(String cpf, String nome, Cargo cargo) {
        super(cpf, nome, "Mensalista");
        this.cargo = cargo;
        listaFuncionarioMensalista.add(this);
    }

    /**
     * Método para obter o valor do salário associado ao cargo.
     * @return Retorna o valor do salário.
     */
    public double getSalarioCargoMensalista() {
        if(cargo == null){throw new IllegalStateException("O cargo deve ser preenchido");}
        return this.getCargo().getSalarioCargo();
    }
    public Cargo getCargo() {
        return cargo;
    }
}
