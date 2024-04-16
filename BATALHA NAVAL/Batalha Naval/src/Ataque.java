import java.util.Scanner;
public class Ataque {
    public boolean realizarAtaque(Cenario cenario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a linha do ataque (1 a 7): ");
        int linha = scanner.nextInt();
        System.out.print("Informe a coluna do ataque (1 a 10): ");
        int coluna = scanner.nextInt();
        linha--;
        coluna--;
            if (cenario.getCampo()[linha][coluna]) {
                System.out.println("Parabéns! Você acertou um navio inimigo!");
                return true;
            } else {
                return false;
            }
    }
}

