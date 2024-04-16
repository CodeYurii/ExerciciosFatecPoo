package poo.exercicio.sistemanotificacao;
import java.util.Objects;

/**
 * Classe abstrata que serve como base para diferentes tipos de notificações.
 * Esta classe define uma estrutura básica para notificações, contendo uma mensagem a ser enviada.
 * As subclasses devem implementar o método abstrato getEnvioMensagem() para definir o formato específico
 * da mensagem a ser enviada, dependendo do tipo de destino (email, SMS, app).
 */
public abstract class Notificacao {
    private String mensagem;

    /**
     * Contrutor da classe abstrata Notificacao, que contém a mensagem a ser enviada pelas classes herdeiras
     * @param mensagem mensagem a ser enviada
     */
    public Notificacao(String mensagem){
        setMensagem(mensagem);
    }

    public String getMensagem() {
        return mensagem;
    }

    /**
     * SetMensagem com tratamento para nao aceitar mensagem vazia ou nula
     * @param mensagem mensagem a ser definida
     */
    public void setMensagem(String mensagem) {
        Objects.requireNonNull(mensagem, "A mensagem não pode ser nula.");
        mensagem = mensagem.trim();
        if (mensagem.isEmpty()) {
            throw new IllegalArgumentException("A mensagem não pode ser vazia.");
        }
        this.mensagem = mensagem;
    }

    /**
     * Método abstrato deve ser implementado pelas classes herdeiras para definir o formato
     * específico da mensagem a ser enviada, dependendo do tipo de destino (email, SMS, app).
     */
    public abstract String getEnvioMensagem();
}
