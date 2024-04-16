package poo.exercicio.sistemanotificacao;

/**
 * Classe que representa uma notificação via Email.
 * Esta classe estende a classe abstrata Notificacao e implementa o método getEnvioMensagem()
 * para definir o formato específico da mensagem a ser enviada por email.
 */
public class Email extends Notificacao{
    /**
     * Construtor para envio de mensagem via Email
     * @param mensagem mensagem a ser enviada
     */
    public Email(String mensagem) {
        super(mensagem);
        getEnvioMensagem();
    }

    /**
     * Método polimórfico para envio de mensagem no estilo Email
     * @return retorna String que representa mensagem no formato Email.
     */
    @Override
    public String getEnvioMensagem() {
        String representacao = "Mensagem via Email: " + getMensagem();
        return representacao;
    }
}
