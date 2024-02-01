
abstract class Observer {
    protected LeilaoSubject leilao;


    public abstract void update(String message);
    
    // public Observer() {
        
    // }

    // public void set_produto(Produto produto) {
    //     this.produto = produto;
    // }

    // public void update() {
    //     System.out.println("Something changed in the product.");
    // }
}