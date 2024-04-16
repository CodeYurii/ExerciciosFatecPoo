import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        System.out.println("Bem-vindo ao Jogo Batalha Naval 5000!");
        System.out.println("Pressione Enter para iniciar o jogo...");
        scanner.nextLine();

        System.out.print("Informe o nome do Player 1: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);

        System.out.print("Informe o nome do Player 2: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);

        System.out.println("O objetivo do jogo é acertar os 15 navios inimigos, distribuidos em um campo de batalha de 7 linhas e 10 colunas.");
        System.out.println("Os navios serão alocados de forma aleatória. A cada acerto o Player recebe 1 ponto.");
        System.out.println("Quem fizer 15 pontos primeiro vence o jogo. Boa sorte!\n");

        System.out.println(name1);
        Cenario cenario1 = new Cenario();
        System.out.println();
        Cenario cenario2 = new Cenario();
        System.out.println(name2);


        for(int turno = 1; turno < 70; turno++) {
            System.out.println("\nTurno:" + turno);
            System.out.println("\nPlayer " + name1 + " escolha as coordenadas de ataque\n");
            Ataque ataque1 = new Ataque();
            boolean ataqueBemSucedido = ataque1.realizarAtaque(cenario1);
            if (ataqueBemSucedido) {
                System.out.println("Ponto para o " + name1);
                player1.addPonto();
            }else{
                System.out.println("Errou! Seu ataque não acertou o navio inimigo\n");
            }
            System.out.println("\nPlayer " + name2 + " escolha as coordenadas de ataque\n");
            Ataque ataque2 = new Ataque();
            boolean ataqueBemSucedido2 = ataque2.realizarAtaque(cenario1);
            if (ataqueBemSucedido2) {
                System.out.println("Ponto para o " + name2);
                player2.addPonto();
            }else{
                System.out.println("Errou! Seu ataque não acertou o navio inimigo\n");
            }
        }
    }
}
