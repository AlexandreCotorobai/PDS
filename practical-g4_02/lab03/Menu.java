/**
 * Menu
 */
public class Menu {
    public Menu(){}

    public void mainMenu(){
        System.out.println("Escolha uma opção: (H para ajuda)");
    }

    public void helpMenu(){
        System.out.println("I <FileName> - Lê um ficheiro de texto contento informação sobre um voo. \nEx: I flight1.txt \n");
        System.out.println("M <Codgio de voo> - Mostrar voo \n");
        System.out.println("F <Codgio de voo> <nº de lugares executivos> <nº de lugares touristicos> - Criar um novo com código do voo. Os lugares executivos são opcionais, podendo existir apenas lugares em turística. \nEx: TP1930 4x3 10x4; 4 filas com 3 lugares excutivos e 10 filas com 4 lugares touristicos \n");
        System.out.println("R <Codgio de voo> <classe> <nº de lugares> - Reservar novos lugares na classe especificada. \nEx: R TP1930 T 3\n");
        System.out.println("C <Codgio de voo> <Reservation_Number> - Cancelar lugares de uma reserva já realizada (O Reservation number é o número que aparece nos lugares no comando M). \nEx: C TP1930 2\n");
        System.out.println("Q - Sair");
        return;
    }
}