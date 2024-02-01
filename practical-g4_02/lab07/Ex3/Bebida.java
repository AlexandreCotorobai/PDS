
public class Bebida extends Produto{
    
    public Bebida(String nome, double peso) {
        super(nome, peso);
    }
    
    public void draw(){
        System.out.println(indent.toString() + toString());
    }

    @Override
    public String toString() {
        return "Bebida '" + getNome() + "' - weight: " + getPeso();
    }

}
