public class Usuario {
    private String nome;
    private Mediator mediator;

    public Usuario(String nome, Mediator mediator) {
        this.nome = nome;
        this.mediator = mediator;
    }

    public void enviarMensagem(String mensagem, Usuario destinatario) {
        mediator.enviarMensagem(mensagem, this, destinatario);
    }

    public void receberMensagem(String mensagem, Usuario remetente) {
        System.out.println(nome + " recebeu a seguinte mensagem de " + remetente.getNome() + ": " + mensagem);
    }

    public String getNome() {
        return nome;
    }
}

