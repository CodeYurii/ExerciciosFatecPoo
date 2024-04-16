import java.util.Random;

public class Cenario {
    private boolean[][] campo = new boolean[7][10];
    private Random aleatorio;

    public Cenario(){
        this.aleatorio = new Random();
            for(int j = 0; j < 10; j++){
                System.out.print(" ");
                System.out.print(j + 1);
            }
            System.out.println();
            for (int i = 0; i < 7; i++){
                for (int j = 0; j < 10; j++){
                    System.out.print("|_");
                }
                System.out.print("| ");
                System.out.print(i + 1);
                System.out.println();
           }
        posicionarBlocosTrue(campo);
    }

    private void posicionarBlocosTrue(boolean[][] campo) {
        int blocosTrue = 0;
        while (blocosTrue < 15) {
            int i = aleatorio.nextInt(campo.length);
            int j = aleatorio.nextInt(campo[0].length);
            if (!campo[i][j]) {
                campo[i][j] = true;
                blocosTrue++;
            }
        }
    }
    public boolean[][] getCampo() {
        return campo;
    }
}
