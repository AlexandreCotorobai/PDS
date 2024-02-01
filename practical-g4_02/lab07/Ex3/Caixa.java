import java.util.ArrayList;

public class Caixa extends Produto{
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private double pesoTotal;


    public Caixa(String nome, double peso) {
        super(nome, peso);
    }

    public void add(Produto produto){
        produtos.add(produto);
    }

    public double getPesoTotal(){
        this.pesoTotal = getPeso();
        for(Produto produto : produtos){
            if (produto instanceof Caixa){
                this.pesoTotal += ((Caixa) produto).getPesoTotal();
            }else{
                this.pesoTotal += produto.getPeso();
            }
        }

        return pesoTotal;
    }

    public void draw(){
        System.out.println(indent.toString() + toString());
        indent.append("     ");
        for(ProdutoInterface produto : produtos){
            produto.draw();
        }
        indent.delete(indent.length() - 5, indent.length());
    }

    @Override
    public String toString() {
        return "* Caixa '" + getNome() + "' [ weight: " + getPeso() + " ; Total: " + getPesoTotal() + " ]";
    }
}