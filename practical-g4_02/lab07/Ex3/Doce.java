public class Doce extends Produto{
    
    public Doce(String nome, double peso) {
        super(nome, peso);
    }
    
    public void draw(){
        System.out.println(indent.toString() + toString());
    }
    
    @Override
    public String toString() {
        return "Doce '" + getNome() + "' - weight: " + getPeso();
    }
}
