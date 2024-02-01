public class Disponivel implements State{

    public void regista(Book book) {
        System.out.println("Ação impossivel");
    }

    public void requisita(Book book) {
        book.setState(new Emprestado());
        System.out.println("Requisição efetuada");
    }

    public void devolve(Book book) {
        System.out.println("Ação impossivel");
    }

    public void reserva(Book book) {
        book.setState(new Reservado());
        System.out.println("Reserva efetuada");
    }

    public void cancelaReserva(Book book) {
        System.out.println("Ação impossivel");
    }

    @Override
    public String toString() {
        return "Disponivel";
    }
    
}
