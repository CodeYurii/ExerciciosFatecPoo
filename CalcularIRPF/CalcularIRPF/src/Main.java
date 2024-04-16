/*
Autor: Yuri Seixeiro
Data Criação: 28/03/2024
Data Última Modificação: 30/03/2024
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do Contribuinte: ");

        /**
         * Solicita ao usuário para entrar com o nome do contribuinte.
         */
        String nome = scanner.next();

        System.out.print("Digite a renda do contribuinte (Use '.' para casa decimal): R$");

        /**
         * Criação de um novo objeto contribuinte com os parametros nome e através do construtor solicia ao usuário para entrar com o rendimento.
         */
        Imposto contribuinte = new Imposto(nome);

        /**
         * Impressão do valor de imposto a ser pago.
         */
        System.out.printf("Nome do contribuinte: %s%nRendimento: R$%,.2f%nFaixa de rendimento: %s%nAlíquota: %.1f%%%nValor imposto de renda a ser pago: R$%,.2f",
                contribuinte.getNomeContribuinte(),
                contribuinte.getRendimento(),
                contribuinte.getFaixaRendimento(),
                contribuinte.getAliquotaUsada(),
                contribuinte.getValorPagamento());
    }
}