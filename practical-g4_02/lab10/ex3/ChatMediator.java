import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {
    private List<Usuario> usuarios;

    public ChatMediator() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario remetente, Usuario destinatario) {
        destinatario.receberMensagem(mensagem, remetente);
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
