import java.util.Scanner;

public class Imposto {
    /**
     * Classe usada para calcular o valor de imposto a ser pago
     */
    private final double[] aliquota = {0, 0.075, 0.15, .225, .275};
    private final double[] faixaMinimaImposto = {0, 2259.21, 2826.66, 3751.06, 4664.69};
    private final double[] faixaMaximaImposto = {2259.20, 2826.65, 3751.05, 4664.68};
    private double valorPagamento;
    private String faixaRendimento;
    private String nomeContribuinte;
    private double rendimento;

    /**
     * variável usada para retornar ao usuário a porcentagem e alíquota usada.
     */
    private double aliquotaUsada;

    /**
     * Construtor que executa os métodos setter de nome e rendimento do contribuinte e inicia a verificação de faixa de imposto a ser cobrado.
     * @param nomeContribuinte nome do contribuinte.
     */
    public Imposto(String nomeContribuinte) {
        setNomeContribuinte(nomeContribuinte);
        setRendimento();
        verificadorFaixa();
    }

    /**
     * Método que verifica em qual faixa de imposto o rendimento do contribuinte se enquadra.
     */
    public void verificadorFaixa() {
        if (rendimento <= faixaMaximaImposto[0]) {
            setFaixaRendimento("Faixa 1");
        } else if (rendimento >= faixaMinimaImposto[1] && rendimento < faixaMaximaImposto[1]) {
            this.valorPagamento = (rendimento - faixaMinimaImposto[1]) * aliquota[1];
            setFaixaRendimento("Faixa 2");
            this.aliquotaUsada = aliquota[1] * 100;
        }else if (rendimento >= faixaMinimaImposto[2] && rendimento < faixaMaximaImposto[2]) {
            this.valorPagamento = ((rendimento - faixaMaximaImposto[1]) * aliquota[1]) + ((rendimento - faixaMinimaImposto[2]) * aliquota[2]);
            setFaixaRendimento("Faixa 3");
            this.aliquotaUsada = aliquota[2] * 100;
        }else if (rendimento >= faixaMinimaImposto[3] && rendimento < faixaMaximaImposto[3]) {
            this.valorPagamento = ((rendimento - faixaMaximaImposto[2]) * aliquota[2]) + ((rendimento - faixaMaximaImposto[1]) * aliquota[1]) + ((rendimento - faixaMinimaImposto[3]) * aliquota[3]);
            setFaixaRendimento("Faixa 4");
            this.aliquotaUsada = aliquota[3] * 100;
        } else if (rendimento >= faixaMinimaImposto[4]) {
            this.valorPagamento = ((rendimento - faixaMaximaImposto[3]) * aliquota[3]) + ((rendimento - faixaMaximaImposto[2]) * aliquota[2]) + ((rendimento - faixaMaximaImposto[1]) * aliquota[1]) + ((rendimento - faixaMinimaImposto[4]) * aliquota[4]);
            setFaixaRendimento("Faixa 5");
            this.aliquotaUsada = aliquota[4] * 100;
        }
    }
    public double getAliquotaUsada() {
        return aliquotaUsada;
    }

    public double getRendimento() {
        return rendimento;
    }

    /**
     * setter de rendimento do contribuinte, primeiro inicia o scanner, recebe o valor em string.
     * caso seja um valor válido define o rendimento como um double convertido da string,
     * caso seja negativo retorna mensagem de erro.
     * verifica se o valor é menor ou igual a 0 ou se é um formato válido.
     */
    public void setRendimento() {
        Scanner scanner = new Scanner(System.in);
        String rendimentoString = scanner.nextLine();
        try {
            this.rendimento = Double.parseDouble(rendimentoString);
            if (rendimento <= 0){throw new IllegalArgumentException("Rendimento deve ser maior que 0");}
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Rendimento inválido. Por favor, digite um valor double válido.");
        }

    }

    public String getNomeContribuinte() {
        return nomeContribuinte;
    }

    /**
     * Setter do nome do contribuinte, verifica se o nome está nulo ou em branco ou foi digitado null.
     * verifica se o nome digitado é composto por letras.
     * @param nomeContribuinte nome do contribuinte
     */
    public void setNomeContribuinte(String nomeContribuinte) {
        if(nomeContribuinte == null || nomeContribuinte.trim().isEmpty() || nomeContribuinte.equalsIgnoreCase("null")){throw new IllegalArgumentException("O nome deve ser preenchido e nao deve ser null");}
        if (!nomeContribuinte.matches("[a-zA-ZÀ-ÖØ-öø-ÿ\\s'-]+")) {throw new IllegalArgumentException("O nome contém caracteres inválidos");}
        this.nomeContribuinte = nomeContribuinte;
    }

    public String getFaixaRendimento() {
        return faixaRendimento;
    }

    public void setFaixaRendimento(String faixaRendimento) {
        this.faixaRendimento = faixaRendimento;
    }
    public double[] getFaixaMinimaImposto() {
        return faixaMinimaImposto;
    }

    public double[] getFaixaMaximaImposto() {
        return faixaMaximaImposto;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }
}
