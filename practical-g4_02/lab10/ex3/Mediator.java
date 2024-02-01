public interface Mediator {
    void enviarMensagem(String mensagem, Usuario remetente, Usuario destinatario);
    void adicionarUsuario(Usuario usuario);
}
