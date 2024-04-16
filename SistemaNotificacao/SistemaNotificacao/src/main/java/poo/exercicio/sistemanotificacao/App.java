package poo.exercicio.sistemanotificacao;

/**
 * Classe que representa uma notificação via App.
 * Esta classe estende a classe abstrata Notificacao e implementa o método getEnvioMensagem()
 * para definir o formato específico da mensagem a ser enviada por app.
 */
public class App extends Notificacao{
    /**
     * Construtor para envio de mensagem via App
     * @param mensagem mensagem a ser enviada
     */
    public App(String mensagem) {
        super(mensagem);
    }

    /**
     * Método polimórfico para envio de mensagem no estilo App
     * @return retorna String que representa mensagem no formato App.
     */
    @Override
    public String getEnvioMensagem() {
        String representacao = "Mensagem via App: " + getMensagem();
        return representacao;
    }
}
