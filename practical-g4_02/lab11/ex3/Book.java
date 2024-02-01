/**
 * Book
 */

public class Book {

    private String title;
    private int ISBN;
    private int year;
    private String author;
    private State currentState;

    public Book(String title, int ISBN, int year, String author) {
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.author = author;
        this.currentState = new Inventario();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getState() {
        return currentState.toString();
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-15s", title, author, getState());
    }

    public void regista(Book book) {
        currentState.regista(book);
    }

    public void requisita(Book book) {
        currentState.requisita(book);
    }

    public void devolve(Book book) {
        currentState.devolve(book);
    }

    public void reserva(Book book) {
        currentState.reserva(book);
    }

    public void cancelaReserva(Book book) {
        currentState.cancelaReserva(book);
    }

    

    
}