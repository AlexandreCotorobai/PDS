import java.util.*;

public class Cliente extends Observer {
    private String name;
    private List <LeilaoSubject> leiloes_participar = new ArrayList<LeilaoSubject>();
    
    public Cliente(String name) {
        this.name = name;
    }

    
    @Override
    public void update(String message) {
        System.out.println(this.name + " -> " + message);
    }


    public void bid(LeilaoSubject leilao, double valor) {
        if(leilao.getState() == Estado.LEILAO) {
            // se o valor for valido, é add à lista de observers e o price metido a esse valor
            if(valor > leilao.getPrice()) {
                leilao.setPrice(valor, this.name);
                if (!leiloes_participar.contains(leilao)) {
                    leiloes_participar.add(leilao);
                }
                System.out.println("You are the highest bidder");
            }
            else {
                System.out.println("Bid too low, actual price is " + leilao.getPrice() + "€");
            }
        }
        else {
            System.out.println("The auction is not available");
        }
        

    }

    public void consultarLeiloes() {
        for(LeilaoSubject leilao : leiloes_participar) {
            System.out.println(leilao);
        }
    }
    
}