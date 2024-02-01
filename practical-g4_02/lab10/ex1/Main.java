public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        Produto produto1 = new Produto(1, "Produto 1", 10, Estado.STOCK);
        Produto produto2 = new Produto(2, "Produto 2", 20, Estado.STOCK);    
        Produto produto3 = new Produto(3, "Produto 3", 30, Estado.STOCK);
        Produto produto4 = new Produto(4, "Produto 4", 40, Estado.STOCK);
        Produto produto5 = new Produto(5, "Produto 5", 50, Estado.STOCK);

        LeilaoSubject leilao1 = new LeilaoSubject();
        LeilaoSubject leilao2 = new LeilaoSubject();
        LeilaoSubject leilao3 = new LeilaoSubject();
        LeilaoSubject leilao4 = new LeilaoSubject();
        LeilaoSubject leilao5 = new LeilaoSubject();

    
        Gestor gestor = new Gestor("Gestor 1");
        Cliente cliente = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");


        leilao1.setProduto(produto1);
        leilao2.setProduto(produto2);
        leilao3.setProduto(produto3);
        leilao4.setProduto(produto4);
        leilao5.setProduto(produto5);


        leilao1.addObserver(cliente);
        leilao1.addObserver(gestor);

        // Product on stock should not be available for bidding
        cliente.bid(leilao1, 0); // NOT AVAILABLE!

        // now the product is on auction
        leilao1.setState(Estado.LEILAO);

        // bid should be higher than the current price / base price
        cliente.bid(leilao1, 5); // TOO LOW!

        leilao1.addObserver(cliente2);
        leilao2.addObserver(cliente2);
        // Thread.sleep(2000);

        leilao2.setState(Estado.LEILAO);

        cliente.bid(leilao1, 15); // OK!
        
        cliente2.bid(leilao1, 20); // OK!
        
    
        leilao1.setState(Estado.VENDAS); // PRODUCT SOLD
        
        leilao2.setState(Estado.STOCK); // PRODUCT NOT SOLD
        
    }
}
