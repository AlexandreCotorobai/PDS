/**
 * Inventario
 */
public class Inventario implements State{

    public void regista(Book book) {
        book.setState(new Disponivel());
        System.out.println("Livro registado");
    }

    public void requisita(Book book) {
        System.out.println("Ação impossivel");

    }

    public void devolve(Book book) {
        System.out.println("Ação impossivel");

    }

    public void reserva(Book book) {
        System.out.println("Ação impossivel");

    }

    public void cancelaReserva(Book book) {
        System.out.println("Ação impossivel");

    }

    @Override
    public String toString() {
        return "Inventario";
    }
    
}