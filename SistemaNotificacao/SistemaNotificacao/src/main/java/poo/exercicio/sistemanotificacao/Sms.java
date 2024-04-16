package poo.exercicio.sistemanotificacao;

/**
 * Classe que representa uma notificação via Sms.
 * Esta classe estende a classe abstrata Notificacao e implementa o método getEnvioMensagem()
 * para definir o formato específico da mensagem a ser enviada por sms.
 */
public class Sms extends Notificacao{
    /**
     * Construtor para envio de mensagem via Sms
     * @param mensagem mensagem a ser enviada
     */
    public Sms(String mensagem) {
        super(mensagem);
    }

    /**
     * Método polimórfico para envio de mensagem no estilo Sms
     * @return retorna String que representa mensagem no formato Sms.
     */
    @Override
    public String getEnvioMensagem() {
        String representacao = "Mensagem via SMS: " + getMensagem();
        return representacao;
    }
}
