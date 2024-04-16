/**
 * A classe Funcionario representa um funcionário genérico.
 * Esta classe contém informações básicas sobre um funcionário, como CPF, nome e tipo.
 */
public class Funcionario {
   private String cpf;
   private String nome;
   private String tipo;

    /**
     * Construtor da classe Funcionario.
     * @param cpf CPF do funcionário.
     * @param nome Nome do funcionário.
     * @param tipo Tipo de contratação do funcionário.
     */
    public Funcionario(String cpf, String nome, String tipo) {
        setNome(nome);
        setCpf(cpf);
        setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    /**
     * Setter do tipo, verifica se o tipo foi validado.
     * @param tipo Tipo de contratação do funcionário.
     */
    public void setTipo(String tipo) {
        if(!validacaoTipo(tipo)){throw new IllegalStateException("Tipo de contratação inválido");}
        this.tipo = tipo;
    }

    /**
     * Método para verificar se o tipo fornecido é válido.
     * @param tipo Tipo de contratação do funcionário, se é Horista ou Mensalista.
     * @return Retorna verdadeiro se o tipo atender as regras.
     */
    private boolean validacaoTipo(String tipo){
        return tipo != null && (tipo.equals("Mensalista") || tipo.equals("Horista"));
    }

    public String getCpf() {
        return cpf;
    }

    /**
     * Setter do CPF, verifica se foi inserido um valor para o parametro CPF e se ele possui 11 digitos númericos.
     * @param cpf CPF do funcionário.
     */
    public void setCpf(String cpf) {
        if(cpf == null || cpf.isBlank()){throw new IllegalStateException("O numero de CPF não pode ser nulo ou vazio");}
        cpf = cpf.trim();
        if(cpf.length() > 14 || !cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos com ou sem pontuação .-");
        }
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Setter do NOME, verifica se o parametro NOME foi preenchido
     * @param nome Nome do Funcionário.
     */
    public void setNome(String nome) {
        if(nome == null || nome.isBlank()){throw new IllegalStateException("NOME deve ser preenchido");}
        this.nome = nome;
    }
}
