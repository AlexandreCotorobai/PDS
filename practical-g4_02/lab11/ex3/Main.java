import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Java Anti-Stress", 232424223, 2019, "Omodionah");
        Book book2 = new Book("A Guerra dos Padrões", 234234234, 2322, "Jorge Omel");
        Book book3 = new Book("A procura da Luz", 234234234, 3322, "Khumatkli");

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(book2);
        books.add(book3);

        while(true){
         
            System.out.println("*** Biblioteca ***");
            for(int i = 0; i < books.size(); i++){
                System.out.println("| " + (i+1) + " " + books.get(i).toString() + "|");
            }
            System.out.println(" <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");

            
            System.out.print("\n\n>> ");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();

            String[] inputs = input.split(",");
            int bookIndex = Integer.parseInt(inputs[0])-1;
            int operation = Integer.parseInt(inputs[1]);


            
            switch (operation) {
                case 1:
                    book.regista(books.get(bookIndex));
                    break;
                case 2:
                    book.requisita(books.get(bookIndex));
                    break;
                case 3:
                    book.devolve(books.get(bookIndex));
                    break;
                case 4:
                    book.reserva(books.get(bookIndex));
                    break;
                case 5:
                    book.cancelaReserva(books.get(bookIndex));
                    break;
                default:
                    System.out.println("Invalid operation!");
                    break;
            }


        }


    }
}
