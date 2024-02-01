public class Emprestado implements State{
    
    public void regista(Book book) {
        System.out.println("Ação impossivel");


    }

    public void requisita(Book book) {
        System.out.println("Ação impossivel");


    }

    public void devolve(Book book) {
        book.setState(new Disponivel());
        System.out.println("Livro devolvido");
    }

    public void reserva(Book book) {
        System.out.println("Ação impossivel");


    }

    public void cancelaReserva(Book book) {
        System.out.println("Ação impossivel");
    }

    @Override
    public String toString() {
        return "Emprestado";
    }
}
