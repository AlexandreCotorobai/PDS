
public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private Estado estado;
        
    public Produto(int codigo, String descricao, double preco, Estado estado) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estado = estado;
    }

    public String getName(){
        return this.descricao;
    }

    public Estado getState() {
        return this.estado;
    }

    public void setState(Estado estado) {
        this.estado = estado;
    }

    public double getPrice() {
        return this.preco;
    }

    public void setPrice(double price) {
        this.preco = price;
    }
    

    @Override
    public String toString() {
        return "Produto: " + codigo + " " + descricao + " " + preco + " " + estado;
    }
    
}