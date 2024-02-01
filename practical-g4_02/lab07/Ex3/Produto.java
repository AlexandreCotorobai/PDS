public abstract class Produto implements ProdutoInterface{
    private String nome;
    private double peso;
    static StringBuffer indent = new StringBuffer();

    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public abstract void draw();
    
}
