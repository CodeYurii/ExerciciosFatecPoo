package poo.exercicio.sistemanotificacao;

public class Principal {
    public static void main(String[] args) {
        //Cadastro de usuários
        Usuario usuario1 = new Usuario("José da Silva", "jose@gmail.com", "995311891", "995311891", true, true, true);
        Usuario usuario2 = new Usuario("Maria Radioativa", "radio@gmail.com", "994371816", "994371816", true, true, false);
        Usuario usuario3 = new Usuario("Gengis Khan", "temujin@gmail.com", "974730174", "974730174", true, false, false);
        Usuario usuario4 = new Usuario("César Augusto", "roma@gmail.com", "962349367", "962349367", false, true, false);

        // Criação de uma mensagem e envio para o usuário criado
        EnviarMensagem enviarMensagem1 = new EnviarMensagem("Esta é uma mensagem enviada ao usuário", usuario1);
        EnviarMensagem enviarMensagem2 = new EnviarMensagem("Esta é uma mensagem enviada ao usuário", usuario2);
        EnviarMensagem enviarMensagem3 = new EnviarMensagem("Esta é uma mensagem enviada ao usuário", usuario3);
        EnviarMensagem enviarMensagem4 = new EnviarMensagem("Esta é uma mensagem enviada ao usuário", usuario4);
        System.out.println(enviarMensagem1.enviar() + "\n");
        System.out.println(enviarMensagem2.enviar() + "\n");
        System.out.println(enviarMensagem3.enviar() + "\n");
        System.out.println(enviarMensagem4.enviar() + "\n");

        // Criação de um usuário com informações vazias para teste
        //Usuario usuarioTeste = new Usuario();

        // Atribuição de valores vazios aos campos do usuário para simular entradas inválidas
        //usuarioTeste.setNome("   ");
        //usuarioTeste.setEmail("  ");
        //usuarioTeste.setSms("   ");
        //usuarioTeste.setApp("  ");

        // Envio de uma mensagem para o usuário de teste
        //EnviarMensagem enviarTesteMensagem = new EnviarMensagem("sdv  ", usuarioTeste);
    }
}
