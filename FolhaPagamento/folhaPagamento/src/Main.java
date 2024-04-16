/**
 * Classe principal que contém o método main para executar o programa.
 */

public class Main {
    public static void main(String[] args) {
        // Cria um novo objeto Cargo com nome e salário.
        Cargo cargo = new Cargo("Desenvolvedor", 3200);

        //Cria um novo objeto Horista com CPF, nome, horas trabalhadas e valor.
        Horista funcionarioHorista = new Horista("123.456.789-01", "Maria", "Horista", 100, 55);

        //Cria um novo objeto Mensalista com CPF, nome e cargo especificados.
        Mensalista funcionarioMensalista = new Mensalista("123.456.789-01", "João", cargo);

        //Imprime o cabeçalho da tabela
        System.out.printf("%-15s %-15s %-15s %-15s%n", "CPF", "NOME", "TIPO", "SALARIO");

        //Itera sobre a lista de funcionários mensalistas e imprime suas informações.
        for(Mensalista listaM : funcionarioMensalista.listaFuncionarioMensalista){
            System.out.printf("%-15s %-15s %-15s R$%.2f%n", listaM.getCpf(), listaM.getNome(), listaM.getTipo(), listaM.getSalarioCargoMensalista());
        }

        //Itera sobre a lista de funcionários horistas e imprime suas informações.
        for(Horista listaH : funcionarioHorista.listaFuncionarioHorista){
            System.out.printf("%-15s %-15s %-15s R$%.2f (R$%.2f/Hora)%n", listaH.getCpf(), listaH.getNome(), listaH.getTipo(), listaH.calculoSalarioHorista(), funcionarioHorista.getValorPorHora());
        }

        //Calcula o total dos salários dos funcionários e imprime o resultado.
        double total = funcionarioHorista.calculoSalarioHorista() + funcionarioMensalista.getSalarioCargoMensalista();
        System.out.println("_______________________________________________________________");
        System.out.printf("%21s %28s %.2f%n", "TOTAL", "R$", total);
    }
}