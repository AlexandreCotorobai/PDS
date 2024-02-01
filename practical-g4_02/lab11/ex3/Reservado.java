public class Reservado implements State{
    
    public void regista(Book book) {
        System.out.println("Ação impossivel");

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
        book.setState(new Disponivel());
        System.out.println("Reserva cancelada");
    }

    @Override
    public String toString() {
        return "Reservado";
    }

}
