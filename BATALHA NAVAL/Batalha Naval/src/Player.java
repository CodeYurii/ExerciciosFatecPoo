public class Player {
    public String name;
    private int pontos;

    public Player(String name){
        this.name = name;
        this.pontos = 0;
    }

    public String getName(){
        return name;
    }
    public int getPontos() {
        return pontos;
    }

    public int addPonto() {
        pontos++;
        System.out.println(pontos);
        return pontos;
    }
}
