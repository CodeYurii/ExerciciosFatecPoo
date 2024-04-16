import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Competicao {
    public String dataCompeticao;
    public LocalTime horaChuva;
    public ArrayList<Participante> participantes;
  	public double premioTotal;

    //construtor criação competição
    public Competicao(String dataCompeticao){
        this.dataCompeticao = dataCompeticao;
        this.participantes = new ArrayList<>();
      	this.premioTotal = 0;
    }

    //metodo para adicionar participante
    public void addParticipante(Participante participante){
        participantes.add(participante);
      	this.premioTotal += participante.getValorAposta();
    }
  	
	//metodo para sortear o horario da chuva
    //mudar 'horaAleatoria' e 'minutoAleatorio' para testar mais de 1 ganhador
  	public String sorteio(){
      Random random = new Random();
      int horaAleatoria = random.nextInt(24);
      int minutoAleatorio = random.nextInt(60);
      LocalTime horaChuva = LocalTime.of(horaAleatoria, minutoAleatorio);
      return horaChuva.toString();      
    }

    //acessando a lista de participantes
  	public List<Participante> getParticipantes() {
        return participantes;
    }

}
