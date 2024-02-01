public class Conserva extends Produto{

    public Conserva(String nome, double peso) {
        super(nome, peso);
    }
    
    public void draw(){
        System.out.println(indent.toString() + toString());
    }
    
    @Override
    public String toString() {
        return "Conserva '" + getNome() + "' - weight: " + getPeso();
    }
}
