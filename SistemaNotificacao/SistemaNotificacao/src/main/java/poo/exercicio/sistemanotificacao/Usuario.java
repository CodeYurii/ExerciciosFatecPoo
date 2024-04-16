package poo.exercicio.sistemanotificacao;
import java.util.Objects;

/**
 * Classe que representa um usuário da aplicação, com preferências de notificação e informações de contato.
 */
public class Usuario {
    private String nome;
    private String email;
    private String sms;
    private String app;
    private boolean viaEmail;
    private boolean viaSms;
    private boolean viaApp;

    /**
     * Construtor padrão da classe Usuario para testes.
     */
    public Usuario() {
    }

    /**
     * Construtor da classe Usuario para inicializar todas as informações necessárias.
     * @param nome Nome do usuário.
     * @param email Endereço de email do usuário.
     * @param app Identificador do aplicativo de mensagens do usuário.
     * @param sms Número de telefone para mensagens SMS do usuário.
     * @param viaEmail Indica se o usuário prefere receber notificações por email.
     * @param viaSms Indica se o usuário prefere receber notificações por SMS.
     * @param viaApp Indica se o usuário prefere receber notificações pelo app.
     */
    public Usuario(String nome, String email, String app, String sms, boolean viaEmail, boolean viaSms, boolean viaApp) {
        this.nome = nome;
        this.email = email;
        this.app = app;
        this.sms = sms;
        setViaEmail(viaEmail);
        setViaSms(viaSms);
        setViaApp(viaApp);
    }

    /**
     * Verifica se o usuário prefere receber notificações por email.
     * @return true se o usuário prefere receber notificações por email, caso contrário false.
     */
    public boolean isViaEmail(){
        return viaEmail;
    }

    /**
     * Verifica se o usuário prefere receber notificações por SMS.
     * @return true se o usuário prefere receber notificações por SMS, caso contrário false.
     */
    public boolean isViaSms(){
        return viaSms;
    }

    /**
     * Verifica se o usuário prefere receber notificações pelo app.
     * @return true se o usuário prefere receber notificações pelo app, caso contrário false.
     */
    public boolean isViaApp(){ return viaApp; }

    public void setViaSms(boolean viaSms) {
        this.viaSms = viaSms;
    }

    public void setViaApp(boolean viaApp) {
        this.viaApp = viaApp;
    }

    public void setViaEmail(boolean viaEmail) {
        this.viaEmail = viaEmail;
    }
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * @param nome O novo nome do usuário.
     * @throws IllegalArgumentException Se o nome fornecido for nulo ou vazio.
     */
    public void setNome(String nome) {
        Objects.requireNonNull(nome, "O nome não pode ser nulo.");
        nome = nome.trim();
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do usuário.
     * @param email O novo endereço de email do usuário.
     * @throws IllegalArgumentException Se o email fornecido for nulo ou vazio.
     */
    public void setEmail(String email) {
        Objects.requireNonNull(email, "O email não pode ser nulo.");
        email = email.trim();
        if (email.isEmpty()) {
            throw new IllegalArgumentException("O email não pode ser vazio.");
        }
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    /**
     * Define o número de telefone para mensagens SMS do usuário.
     * @param sms O novo número de telefone para mensagens SMS do usuário.
     * @throws IllegalArgumentException Se o número de telefone fornecido for nulo ou vazio.
     */
    public void setSms(String sms) {
        Objects.requireNonNull(sms, "O SMS não pode ser nulo.");
        sms = sms.trim();
        if (sms.isEmpty()) {
            throw new IllegalArgumentException("O SMS não pode ser vazio.");
        }
        this.sms = sms;
    }

    public String getApp() {
        return app;
    }

    /**
     * Define o identificador do app do usuário.
     * @param app O novo identificador do app do usuário.
     * @throws IllegalArgumentException Se o identificador do app fornecido for nulo ou vazio.
     */
    public void setApp(String app) {
        Objects.requireNonNull(app, "O app não pode ser nulo.");
        app = app.trim();
        if (app.isEmpty()) {
            throw new IllegalArgumentException("O app não pode ser vazio.");
        }
        this.app = app;
    }
}
