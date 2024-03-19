import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Horario {
    private LocalDateTime horario;

    //VERIFICA SE O HORARIO JA FOI REGISTRADO
    private boolean jaRegistrouHora(){return horario != null;}



    public Horario() {
    }

    //REGISTRA O HORARIO COMO LOCAL DATE E RETORNA FORMATADO PARA STRING
    public void setHorario() {
        if (jaRegistrouHora()) {throw new IllegalStateException("O horário de compra ja foi registrado");}
        this.horario =  LocalDateTime.now();
        horario.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
    public String getHorario(){
        return horario.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

}
