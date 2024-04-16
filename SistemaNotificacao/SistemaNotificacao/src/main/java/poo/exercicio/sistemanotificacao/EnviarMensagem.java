package poo.exercicio.sistemanotificacao;
/**
 * Classe responsável por enviar mensagens para um usuário, construindo a mensagem com base nas preferências de notificação do usuário.
 * Esta classe recebe uma mensagem e um usuário como parâmetros e constrói a mensagem de acordo com as preferências de notificação do usuário,
 * incluindo informações sobre o destino da mensagem (email, SMS, app).
 */
public class EnviarMensagem {
    // Atributos da classe
    String mensagemEnviada;
    Notificacao notificacao;
    Usuario usuario;

    /**
     * Construtor da classe EnviarMensagem.
     * @param mensagem A mensagem a ser enviada.
     * @param usuario O usuário para quem a mensagem será enviada.
     * @throws IllegalArgumentException Se o usuário fornecido for nulo ou se o nome do usuário estiver vazio.
     */
    public EnviarMensagem(String mensagem, Usuario usuario){
        // Verifica se o usuário fornecido é válido
        if (usuario == null || usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Informe um usuário válido");
        }
        // Inicializa os atributos da classe
        this.usuario = usuario;
        StringBuilder construtorString = new StringBuilder();
        construtorString.append("Notificação para o usuário: ")
                .append(usuario.getNome())
                .append("\n");
        // Verifica as preferências de notificação do usuário e constrói a mensagem correspondente
        if(usuario.isViaEmail()){
            this.notificacao = new Email(mensagem);
            construtorString.append("Email Destino: ")
                    .append(usuario.getEmail())
                    .append("\n")
                    .append(notificacao.getEnvioMensagem())
                    .append("\n");
        }
        if(usuario.isViaSms()){
            this.notificacao = new Sms(mensagem);
            construtorString.append("SMS Destino: ")
                    .append(usuario.getSms())
                    .append("\n")
                    .append(notificacao.getEnvioMensagem())
                    .append("\n");
        }
        if(usuario.isViaApp()){
            this.notificacao = new App(mensagem);
            construtorString.append("App Destino: ")
                    .append(usuario.getApp())
                    .append("\n")
                    .append(notificacao.getEnvioMensagem())
                    .append("\n");
        }
        // Define a mensagem enviada
        this.mensagemEnviada = construtorString.toString();
    }

    /**
     * Retorna a mensagem enviada.
     * @return A mensagem enviada para o usuário.
     */
    public String enviar(){
        return mensagemEnviada;
    }
}
