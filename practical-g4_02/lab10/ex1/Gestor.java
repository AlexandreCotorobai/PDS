import java.util.ArrayList;
import java.util.List;

public class Gestor extends Observer{
    String nome;
    private List <LeilaoSubject> leiloes_participar = new ArrayList<LeilaoSubject>();
    
    public Gestor(String nome){
        this.nome = nome;
    }

    @Override
    public void update(String message) {
        System.out.println("Gestor is aware of the following message: " + message);
    }
}
