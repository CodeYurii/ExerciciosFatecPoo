import java.util.Random;

public class Caixa {
    private int numeroCaixa;

    //VERIFICA SE O NUMERO DO CAIXA JA FOI REGISTRADO
    private boolean jaRegistroCaixa(){return numeroCaixa != 0;}

    public Caixa(){
        setNumeroCaixa();
    }
    Random random = new Random();

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    //GERA UM NUMERO ALEATORIO DE CAIXA DE 1 ATÉ 15
    public void setNumeroCaixa() {
        if(jaRegistroCaixa()){throw new IllegalStateException("O número do caixa ja foi registrado");}
        this.numeroCaixa = random.nextInt(15) + 1;
    }
}
