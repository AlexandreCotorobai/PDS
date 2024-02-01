import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////
/* Como compilar&correr:
1) - Abrir terminal o diretório deste ficheiro 'Main.java'
2) - Compilar os ficheiros correndo o comando:javac *.java
3) - Correr o comando (Para executar sem Ficheiro):java Main
4) - Correr o comando (Para seceutar com Ficheiro):java Main comandos.txt
*/
////////////////////////////////////////////////////////////////////////

public class Main {

    /*
    * Verifica a quantidade de argumentos passados para a função main().
    * Se nenhum argumento (ficheiro de texto) é passado, vai pedindo informação ao utilizador.
    * Se um argumento (ficheiro de texto) é passado, o programa tenta abrir um arquivo
    * com o nome do argumento passado, assumindo que o arquivo está no diretório deste ficheiro Java.
    * Cada linha do arquivo é lida e o comando correspondente é executado.
    * Se o arquivo não for encontrado, uma mensagem de erro é exibida.
    * Se mais de um argumento (ficheiro de texto) é passado, uma mensagem de erro é exibida.
    */
    public static void main(String args[]) {
        // Verifica se nenhum argumento foi passado
        if (args.length == 0) { // sem ficheiro de comandos
            //Exibe um menu de opções para o usuário e lê a entrada do usuário.
            //Em seguida chama outros métodos para executar a ação solicitada.
            boolean usuarioNaoInseriuQ = true;
            Scanner sc = new Scanner(System.in);
            while (usuarioNaoInseriuQ) {//Enquanto não for usada a função 'Q' para sair
                System.out.println("\nEscolha uma opção: (H para ajuda)");
                String option[] = sc.nextLine().split(" ");
                usuarioNaoInseriuQ = selecionador(option);//Chamar a função pedida
            }
            sc.close();
            System.exit(0);
        // Verifica se um argumento foi passado
        } else if (args.length == 1) { // com ficheiro de comandos
            // Tenta abrir o arquivo passado como argumento
            try {
                File fl = new File(args[0]);
                Scanner sc = new Scanner(fl);
                // Lê cada linha do arquivo e executa a função correspondente
                while (sc.hasNextLine()) {
                    String option[] = sc.nextLine().split(" ");
                    selecionador(option);
                }
                // Fecha o arquivo
                sc.close();
            // Caso o arquivo não seja encontrado, exibe uma mensagem de erro
            } catch (FileNotFoundException e) {
                System.out.println("Ficheiro não existente, tenta outra vez.");
            }
        // Caso mais de um argumento (ficheiro de texto) seja passado, exibe uma mensagem de erro
        } else {
            System.out.println("Número inválido de argumentos (ficheiros de texto).");
        }
    }

    /**
     *Este método recebe uma string no formato "NúmeroxNúmero" e retorna um array de inteiros com os dois números separados.
     *Se a string não estiver no formato correto, lança uma exceção NumberFormatException e retorna null.
     *@param str a string a ser analisada e convertida em um array de inteiros
     *@return um array de inteiros com os dois números separados, ou null se a string não estiver no formato correto
     *@throws NumberFormatException se a string não estiver no formato "NúmeroxNúmero"
     */
    public static int[] parseStringX(String str) {
        try {
            String[] strPair = str.split("x");
            int rows = Integer.parseInt(strPair[0]);
            int seats = Integer.parseInt(strPair[1]);
            if (rows < 1 || seats < 1) {
                throw new NumberFormatException();
            }
            return new int[] {rows, seats};
        } catch (NumberFormatException e) {
            System.err.println("ERRO! - O parâmetro deve ser 'NúmeroxNúmero'. ");
            return null;
        }
    }

    /**
     * Verifica se o código de Voo é válido ou não.
     * Devolve um erro se o output for inválido.
     */
    public static String vooValidoCodigo(String code) {
        //Usar uma expressão regular para verificar se o código de voo está no formato que queremos

        /*

         '(?<![A-Z])' Esta parte é um lookbehind negativo, que verifica se a letra anterior não é uma letra maiúscula (A-Z).
         Ela garante que a expressão regular só encontrará um código de voo se ele não estiver precedido por outra letra maiúscula.

         '[A-Z]{2}' Esta parte encontra duas letras maiúsculas consecutivas.

         '\\d{4}' Esta parte encontra quatro dígitos numéricos.

         '(?<![A-Z])' Esta parte é outro lookbehind negativo, que verifica se a próxima letra não é uma letra maiúscula (A-Z).
         Ela garante que a expressão regular só encontrará um código de voo se ele não estiver seguido por outra letra maiúscula.

        */

        if (code.matches("(?<![A-Z])[A-Z]{2}\\d{4}(?<![A-Z])")) {
            //Se é válido, devolve o código de voo
            return code;
        } else {
            //Se não estiver no formato que queremos, devolve null e imprime uma mensagem de erro.
            System.err.println("ERRO! - Código de Voo Inválido! O código tem de ter duas letras maiusculas seguidas de quatro dígitos.");
            return null;
        }
    }

    /**
     *Método selecionador que recebe um array de strings como argumento e executa uma ação com base no primeiro elemento da matriz.
     *@param option um array de strings com as opções selecionadas pelo usuário.
     *@return um valor booleano true se o programa deve terminar ou false se o programa deve continuar.
     */
    public static boolean selecionador(String[] option) {
        String codigoVoo;
        boolean acabarOprograma = true;
        String switchVar;
        try {// Verificar se a opção é uma string e é possível convertê-la para maiúsculas
            switchVar = option[0].toUpperCase();
        } catch (Exception e) {
            System.err.println("ERRO! - Opção Inválida!");
            return true;
        }
        switch (switchVar) {
            //Mostra o menu de ajuda
            case "H":
                System.out.println("================================ Comandos ==================================");
                System.out.println("|  I <ficheiro>            Lê um ficheiro de texto contendo informações    |");
                System.out.println("|                          sobre o voo e adiciona o mesmo.                 |");
                System.out.println("|  M <codigoVoo>           Exibe o mapa das reservas de um voo.            |");
                System.out.println("|  F <codigoVoo> <lugaresTuristica> <lugaresExecutiva>                     |");
                System.out.println("|                          Acrescenta um novo voo com código, lugares em   |");
                System.out.println("|                          turística e/ou em executiva (parâmetro opcional)|");
                System.out.println("|  R <codigoVoo> <classe> <numeroLugares>                                  |");
                System.out.println("|                          Acrescenta uma nova reserva a um voo, com       |");
                System.out.println("|                          indicação do código do voo, da classe (T/E) e   |");
                System.out.println("|                          do número de lugares.                           |");
                System.out.println("|  C <codigoReserva>       Cancela uma reserva.                            |");
                System.out.println("|  Q                       Encerra o programa.                             |");
                System.out.println("============================================================================");
                break;

            //Inserir Voo
            case "I":
                try {
                    File fl = new File(option[1]); // cria um objeto File com o caminho do ficheiro indicado no segundo argumento
                    Scanner input = new Scanner(fl); // cria um objeto Scanner para ler o ficheiro
                    String infoVoo[] = new String[3]; // array para guardar as informações do voo
                    if (input.hasNextLine())
                        infoVoo = input.nextLine().split(" "); // guarda na array as informações da primeira linha do ficheiro

                        // Obter o código do voo e verificar se é válido
                        codigoVoo = vooValidoCodigo(infoVoo[0].replaceAll(">", "")); // substitui o caractere '>' do código do voo por vazio
                        int disponivelTur = 0; // número de lugares disponíveis na classe turística
                        int disponivelExe = 0; // número de lugares disponíveis na classe executiva

                        // Se não houver classe executiva
                        if (infoVoo.length == 2) {
                            int turistica[] = parseStringX(infoVoo[1]); // converte a string da informação de lugares turísticos para um array de inteiros
                            Gerenciador.addVoo(codigoVoo, turistica[0], turistica[1]); // adiciona o voo à lista de voos na classe Gerenciador
                            disponivelTur = turistica[0] * turistica[1];
                        // Se houver classe executiva
                        } else if (infoVoo.length == 3) {
                            int executiva[] = parseStringX(infoVoo[1]); // converte a string da informação de lugares executivos para um array de inteiros
                            int turistica[] = parseStringX(infoVoo[2]); // converte a string da informação de lugares turísticos para um array de inteiros
                            Gerenciador.addVoo(codigoVoo, turistica[0], turistica[1], executiva[0], executiva[1]); // adiciona o voo à lista de voos na classe Gerenciador com ambos os tipos de lugares
                            disponivelTur = turistica[0] * turistica[1];
                            disponivelExe = executiva[0] * executiva[1];
                        // Se houver um número inválido de informações na primeira linha do ficheiro
                        } else {
                            System.out.println("Erro: O ficheiro tem um número inválido de informações.");
                        }

                        // Print da informação de voo (varia consoante se existe ou não classe executiva)
                        System.out.print("Código de voo " + codigoVoo + ". Lugares disponíveis: ");
                        if (infoVoo.length == 3) // se há lugares disponíveis na classe executiva
                            System.out.print(disponivelExe + " lugares em classe Executiva; ");
                        System.out.print(disponivelTur + " lugares em classe Turística.\n"); // número de lugares disponíveis na classe turística
                        if (infoVoo.length == 2) // se não há lugares disponíveis na classe executiva
                            System.out.print("Classe executiva não disponível neste voo.\n");

                        // Ler linhas do ficheiro (realizar reservas)
                        while (input.hasNextLine()) {
                            try {
                                String reserva[] = input.nextLine().split(" "); // separa a linha em que está a informação de reserva em um array de strings
                                char classe = reserva[0].charAt(0); // guarda a primeira letra da informação da classe da reserva
                                int passageiros = Integer.parseInt(reserva[1]); // guarda o número de passageiros da reserva
                                Gerenciador.reservarLugares(codigoVoo, classe, passageiros,false); // reserva os lugares
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: Cada elemento do par deve ser um número.");
                        }
                    }
                    input.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Erro: Ficheiro não existente.");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Erro: Por Favor indique um ficheiro.");
                }
                break;

            //Mostrar o Mapa de Reservas do Voo
            case "M":
                codigoVoo = vooValidoCodigo(option[1]);
                Gerenciador.MapaReservas(codigoVoo);
                break;
            // Adicionar um Novo Voo
            case "F":
                if (option.length == 3) { // sem classe executiva
                    try {
                        codigoVoo = vooValidoCodigo(option[1]); // verifica se o código do voo é válido
                        int turistica[] = parseStringX(option[2]); // converte o número de assentos turísticos em um array de inteiros
                        Gerenciador.addVoo(codigoVoo, turistica[0], turistica[1]); // adiciona um novo voo sem classe executiva

                    } catch (NumberFormatException e) { // trata uma exceção se os argumentos não forem números válidos
                        System.out.println("Erro: O parâmetro deve ter dois inteiros (maiores que zero) separados por 'x'.");
                    }
                } else if (option.length == 4) { // com classe executiva
                    try {
                        codigoVoo = vooValidoCodigo(option[1]); // verifica se o código do voo é válido
                        int turistica[] = parseStringX(option[2]); // converte o número de assentos turísticos em um array de inteiros
                        int executiva[] = parseStringX(option[3]); // converte o número de assentos executivos em um array de inteiros
                        Gerenciador.addVoo(codigoVoo, turistica[0], turistica[1], executiva[0], executiva[1]); // adiciona um novo voo com classe executiva
                    } catch (NumberFormatException e) { // trata uma exceção se os argumentos não forem números válidos
                        System.out.println("Erro: O parâmetro deve ter dois inteiros (maiores que zero) separados por 'x'.");
                    }
                } else {
                    System.out.println("Erro: Número inválido de parâmetros (escreve H para ajuda)."); // se o número de argumentos não for 3 ou 4, exibe uma mensagem de erro
                }
                break;

            //Adicionar Nova Reserva
            case "R":
                if (option.length == 4) { // verifica se o número de parâmetros está correto
                    codigoVoo = vooValidoCodigo(option[1]); // extrai o código do voo do segundo parâmetro
                    char classe = option[2].charAt(0); // extrai a classe (executiva ou turística) do terceiro parâmetro
                    int numLugares = Integer.parseInt(option[3]); // extrai o número de lugares a reservar do quarto parâmetro

                    if (numLugares < 1) { // verifica se o número de lugares é maior que zero
                        System.out.println("Erro: Número de passageiros inválido."); // imprime mensagem de erro se não for
                        break; // termina o switch case
                    } else {
                        Gerenciador.reservarLugares(codigoVoo, classe, numLugares,true); // realiza a reserva de lugares
                        break; // termina o switch case
                    }
                } else {
                    System.out.println("Erro: Número de parâmetros inválido para opção R."); // imprime mensagem de erro se o número de parâmetros não estiver correto
                }
                break; // termina o switch case


            //Cancelar a Reserva
            case "C":
                // Obtém o código de reserva a partir da segunda posição da opção
                String codigoReserva = option[1];
                // Chama o método cancelarReserva da classe Gerenciador com o código de reserva
                // como argumento para cancelar a reserva correspondente
                Gerenciador.cancelarReserva(codigoReserva);
                // Encerra o switch case atual
                break;

            //Sair do Programa
            case "Q":
                acabarOprograma = false;
                System.out.println("Programa Fechado!");
                break;
            default:
                System.out.println("Comando dado é inválido. Tenta outra vez.");
        }
        return acabarOprograma;
    }
}