public class Participante {
    public String nome;
    public String palpiteHora;
    public double valorAposta;

    //construtor para criar um participante
    public Participante(String nome, String palpiteHora, double valorAposta){
        this.nome = nome;
        this.palpiteHora = palpiteHora;
        this.valorAposta = valorAposta;
    }

    public String getNome(){
        return nome;
    }

    //metodo para retornar palpites iguais ao sorteio
  	public boolean acertouPalpite(String horaSorteada) {
        return palpiteHora.equals(horaSorteada);
    }
  
  public double getValorAposta(){
    	return valorAposta;
  }
}
