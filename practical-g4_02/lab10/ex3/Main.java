public class Main {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();

        Usuario usuario1 = new Usuario("João", chatMediator);
        Usuario usuario2 = new Usuario("Maria", chatMediator);

        chatMediator.adicionarUsuario(usuario1);
        chatMediator.adicionarUsuario(usuario2);

        usuario1.enviarMensagem("Olá, Maria!", usuario2);
        usuario2.enviarMensagem("Oi, João!", usuario1);
    }
}

