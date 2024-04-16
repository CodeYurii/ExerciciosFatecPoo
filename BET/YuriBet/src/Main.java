import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem Vindo ao YuriBet!");
        
        //criando uma nova competição
        Competicao novaCompeticao = new Competicao("04/03/24");
        System.out.println("Iniciando nova competiçao: " + novaCompeticao.dataCompeticao);

        //criando participantes
        Participante participante1 = new Participante("Goku", "12:00", 12.33);
        Participante participante2 = new Participante("Darth Vader", "12:00", 5.33);
        Participante participante3 = new Participante("Gandolf", "13:30", 10.99);
        Participante participante4 = new Participante("Temujin", "14:00", 27.99);
        Participante participante5 = new Participante("Alonso", "15:20", 50.99);
        Participante participante6 = new Participante("Chapolin", "16:50", 30.99);

        //adicionando participantes na competição criada
        novaCompeticao.addParticipante(participante1);
        novaCompeticao.addParticipante(participante2);
        novaCompeticao.addParticipante(participante3);
        novaCompeticao.addParticipante(participante4);
        novaCompeticao.addParticipante(participante5);
        novaCompeticao.addParticipante(participante6);

        //imprimindo quem são os participantes
        System.out.println("\nParticipantes: ");
        System.out.println(participante1.nome + " - Palpite: " + participante1.palpiteHora);
        System.out.println(participante2.nome + " - Palpite: " + participante2.palpiteHora);
        System.out.println(participante3.nome + " - Palpite: " + participante3.palpiteHora);
        System.out.println(participante4.nome + " - Palpite: " + participante4.palpiteHora);
        System.out.println(participante5.nome + " - Palpite: " + participante5.palpiteHora);
        System.out.println(participante6.nome + " - Palpite: " + participante6.palpiteHora);
        System.out.println();

        //sorteio do horário + divulgaçao do premio total em jogo
        String chuva = novaCompeticao.sorteio();
        System.out.println("Sorteio da Competiçao - " + novaCompeticao.dataCompeticao);
        System.out.println("Premio Total: R$" + novaCompeticao.premioTotal);
        System.out.println("Horário Chuva: " + chuva);
        System.out.println();

        //verificador de vencedores
        System.out.println("Resultado de Ganhadores:");
        boolean algumGanhador = false;
        int numeroVencedores = 0;
        List<String> nomesVencedores = new ArrayList<>();
        for (Participante participante : novaCompeticao.getParticipantes()) {
            if (participante.acertouPalpite(chuva)) {
                algumGanhador = true;
                numeroVencedores++;
                nomesVencedores.add(participante.getNome());
            }
        }

        //divulgaçao dos resultados e vencedores
        double premioIndividual;
        if (!algumGanhador) {
            System.out.println("Yuri venceu!");
            System.out.println("Premio: R$" + novaCompeticao.premioTotal);
        } else {
            premioIndividual = novaCompeticao.premioTotal / numeroVencedores;
            for (String nomeVencedor : nomesVencedores) {
                System.out.println("Vencedor: " + nomeVencedor);
                System.out.println("Premio: R$" + premioIndividual);
            }
        }
    }
}