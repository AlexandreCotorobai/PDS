import java.util.*;

public class LeilaoSubject {
    private Produto produto;
    private List<Observer> observers = new ArrayList<Observer>();
    private String highestBidder = null;
    // timer leilao
    // estado produto

    public LeilaoSubject() {
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setState(Estado estado) {
        this.produto.setState(estado);
        if (estado == Estado.LEILAO) {
            notifyObservers(this.produto.getName() + " is now in LEILAO");
        } else if (estado == Estado.STOCK) {
            notifyObservers(this.produto.getName() + " is now on STOCK");
        } else if (estado == Estado.VENDAS) {
            notifyObservers(this.produto.getName() + " is now on VENDAS. Sold to " + highestBidder);
        }

    }

    public Estado getState() {
        return this.produto.getState();
    }

    public double getPrice() {
        return this.produto.getPrice();
    }

    public void setPrice(double price, String highestBidder) {
        this.produto.setPrice(price);
        this.highestBidder = highestBidder;
        notifyObservers(produto.getName() + " price is now " + price + "€. Bid by " + highestBidder);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }
}