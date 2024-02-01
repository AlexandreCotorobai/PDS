import java.lang.Math;
import java.util.HashMap;

/**
 *Classe que representa um voo.
 */
public class Flight {
    // variáveis de instância
    private HashMap<String, Reserva> reservasVoo; // mapa para armazenar as reservas
    private int[][] lugaresTur; // matriz de inteiros para os lugares de classe econômica
    private int[][] lugaresExec; // matriz de inteiros para os lugares de classe executiva
    private int numSequencial; // número sequencial para as reservas
    private String codigo; // código do voo
    private Avião aviao; // avião associado ao voo
    private boolean temClasseExecutiva; // flag para indicar se o voo possui classe executiva
    private int lugaresDisponiveisTur; // número de lugares disponíveis na classe econômica
    private int lugaresDisponiveisExe; // número de lugares disponíveis na classe executiva

    /**
     *Construtor para criar um voo sem classe executiva.
     *@param codigo O código do voo.
     *@param filas_tur O número de filas da classe turística.
     *@param LugPorFila_tur O número de lugares por fila da classe turística.
     */
    public Flight(String codigo, int filas_tur, int LugPorFila_tur) {
        // inicializa as variáveis de instância
        this.codigo = codigo;
        this.aviao = new Avião(filas_tur, LugPorFila_tur);
        this.lugaresDisponiveisTur = filas_tur * LugPorFila_tur;
        this.lugaresTur = new int[filas_tur][LugPorFila_tur];
        this.temClasseExecutiva = false;
        this.reservasVoo = new HashMap<>();
        this.numSequencial = 1;
    }

    /**
     *Construtor para criar um voo com classe executiva.
     *@param codigo O código do voo.
     *@param filas_tur O número de filas da classe turística.
     *@param LugPorFila_tur O número de lugares por fila da classe turística.
     *@param filas_exec O número de filas da classe executiva.
     *@param LugPorFila_exec O número de lugares por fila da classe executiva.
     */
    public Flight(String codigo, int filas_tur, int LugPorFila_tur, int filas_exec, int LugPorFila_exec) {
        // inicializa as variáveis de instância
        this.codigo = codigo;
        this.aviao = new Avião(filas_tur, LugPorFila_tur, filas_exec, LugPorFila_exec);
        this.lugaresDisponiveisTur = filas_tur * LugPorFila_tur;
        this.lugaresDisponiveisExe = filas_exec * LugPorFila_exec;
        this.lugaresTur = new int[filas_tur][LugPorFila_tur];
        this.lugaresExec = new int[filas_exec][LugPorFila_exec];
        this.temClasseExecutiva = true;
        this.reservasVoo = new HashMap<>();
        this.numSequencial = 1;
    }

    //Método get
    public String getCodigo() {
        return this.codigo;
    }

    /**
     *Retorna uma string com os lugares associados a uma reserva específica.
     *@param codigoReserva o código de reserva a ser buscado
     *@param numeroSequencial o número sequencial do lugar a ser buscado
     *@return uma string contendo os lugares encontrados
     */
    public String lugaresDaReserva(String codigoReserva, int numeroSequencial) {
        // Inicia a string de lugares com o código de reserva
        String lugares = codigoReserva + " = ";
        // Loop pelas filas executivas do avião
        for (int f = 0; f < this.aviao.getFilasExecutiva(); f++) {
            // Loop pelas filas de cada fila executiva
            for (int l = 0; l < this.aviao.getLugPorFilaExecutiva(); l++) {
                // Verifica se o número sequencial corresponde ao lugar da fileira executiva atual
                if (this.lugaresExec[f][l] == numSequencial) {
                    // Obtém a letra do último lugar na fileira atual usando a tabela ASCII
                    int ascii = 65 + l; // 'A' (65) + lugar (começa no 0)
                    char ultimoLugar = (char) ascii;
                    // Adiciona o lugar encontrado à string de lugares
                    lugares += String.valueOf(f+1) + ultimoLugar + " | ";
                }
            }
        }
        // Loop pelas filas turísticas do avião
        for (int f = 0; f < this.aviao.getFilasTuristica(); f++) {
            // Loop pelas fileiras de cada fila turística
            for (int l = 0; l < this.aviao.getLugPorFilaTuristica(); l++) {
                // Verifica se o número sequencial corresponde ao lugar da fileira turística atual
                if (this.lugaresTur[f][l] == numeroSequencial) {
                    // Obtém a letra do último lugar na fileira atual usando a tabela ASCII
                    int ascii = 65 + l; // 'A' (65) + lugar (começa no 0)
                    char ultimoLugar = (char) ascii;
                    // Adiciona o lugar encontrado à string de lugares
                    lugares += String.valueOf(f+1) + ultimoLugar + " | ";
                }
            }
        }
        // Retorna a string de lugares encontrados
        return lugares;
    }

    /**
     * Remove a reserva indicada do mapa de assentos da classe especificada.
     *
     * @param classe a classe de assentos (E para executiva, T para turística)
     * @param numReserva o número da reserva a ser removida
     */
    public void removerReservaMapa(char classe, int numReserva) {
        if (classe == 'E') { // se a classe for executiva
            // percorre todas as filas e assentos da classe executiva
            for (int f = 0; f < this.aviao.getFilasExecutiva(); f++) {
                for (int l = 0; l < this.aviao.getLugPorFilaExecutiva(); l++) {
                    // verifica se o número da reserva coincide com o assento atual
                    if (this.lugaresExec[f][l] == numReserva) {
                        // se for o assento correto, remove a reserva (seta o valor para 0)
                        this.lugaresExec[f][l] = 0;
                    }
                }
            }
        } else if (classe == 'T') { // se a classe for turística
            // percorre todas as filas e assentos da classe turística
            for (int f = 0; f < this.aviao.getFilasTuristica(); f++) {
                for (int l = 0; l < this.aviao.getLugPorFilaTuristica(); l++) {
                    // verifica se o número da reserva coincide com o assento atual
                    if (this.lugaresTur[f][l] == numReserva) {
                        // se for o assento correto, remove a reserva (seta o valor para 0)
                        this.lugaresTur[f][l] = 0;
                    }
                }
            }
        }
    }

    /**
     *Classe responsável por remover uma reserva específica do mapa de assentos da classe especificada (executiva ou turística).
     *
     *@param classe Um caractere que representa a classe de assentos (E para executiva, T para turística).
     *@param numPass O número total de passageiros na reserva.
     *@param numReserva O número da reserva a ser removida.
     */
    public void alterarMapaReservas(char classe, int numPass, int numReserva) {

        // Variável para controlar a quantidade de passageiros restantes
        int passageirosRestantes = numPass;

        if (classe == 'E') { // Se a classe for executiva

            // Verifica se há filas vazias primeiro
            for (int f = 0; f < this.aviao.getFilasExecutiva(); f++) {

                // Flag para controlar se a fila está vazia
                boolean linhaVazia = true;

                // Verifica se há lugares ocupados na fila
                for (int l = 0; l < this.aviao.getLugPorFilaExecutiva(); l++) {
                    if (this.lugaresExec[f][l] != 0) {
                        linhaVazia = false;
                        break;
                    }
                }

                // Se a fila estiver vazia, atribui o número da reserva aos lugares
                if (linhaVazia) {
                    for (int l = 0; l < this.aviao.getLugPorFilaExecutiva(); l++) {
                        if (passageirosRestantes > 0) {
                            this.lugaresExec[f][l] = numReserva;
                            passageirosRestantes--;
                        }
                    }
                }
            }

            // Verifica se há filas com lugares desocupados (mas não cheias)
            for (int f = 0; f < this.aviao.getFilasExecutiva(); f++) {
                for (int l = 0; l < this.lugaresExec[0].length; l++) {

                    // Se houver um lugar desocupado, atribui o número da reserva ao lugar
                    if (this.lugaresExec[f][l] == 0 && passageirosRestantes > 0) { // lugar desocupado

                        this.lugaresExec[f][l] = numReserva;
                        passageirosRestantes--;
                    }
                }
            }

        } else if (classe == 'T') { // Se a classe for turística

            // Verifica se há filas vazias primeiro
            for (int f = 0; f < this.aviao.getFilasTuristica(); f++) {

                // Flag para controlar se a fila está vazia
                boolean linhaVazia = true;

                // Verifica se há lugares ocupados na fila
                for (int l = 0; l < this.aviao.getLugPorFilaTuristica(); l++) {
                    if (this.lugaresTur[f][l] != 0) {
                        linhaVazia = false;
                        break;
                    }
                }

                // Se a fila estiver vazia, atribui o número da reserva aos lugares
                if (linhaVazia) {
                    for (int l = 0; l < this.aviao.getLugPorFilaTuristica(); l++) {
                        if (passageirosRestantes > 0) {

                            this.lugaresTur[f][l] = numReserva;
                            passageirosRestantes--;
                        }
                    }
                }
            }

            // Verifica se há filas com lugares desocupados (mas não cheias)
            for (int f = 0; f < this.aviao.getFilasTuristica(); f++) {
                for (int l = 0; l < this.lugaresTur[0].length; l++) {
                    // Se houver um lugar desocupado, atribui o número da reserva ao lugar
                    if (this.lugaresTur[f][l] == 0 && passageirosRestantes > 0) { // lugar desocupado

                        this.lugaresTur[f][l] = numReserva;
                        passageirosRestantes--;
                    }
                }
            }
        }
    }


    /**
     *Método para realizar reservas em um voo.
     *@param codigo_Voo o código do voo desejado
     *@param classe a classe desejada (E para executiva ou T para turística)
     *@param num_pass o número de passageiros a serem reservados
     *@param imprimir se imprime ou não informação sobre a reserva
     */
    public void reservar(String codigo_Voo, char classe, int num_pass, boolean imprimir) {
        // verifica se a classe desejada é executiva
        if (classe == 'E') {
             // verifica se o avião tem lugares em classe executiva
             if (this.temClasseExecutiva) {
                 // verifica se há lugares disponíveis em classe executiva
                 if (lugaresDisponiveisExe >= num_pass) {
                     // atualiza o número de lugares disponíveis em classe executiva
                     lugaresDisponiveisExe -= num_pass;
                     // cria uma nova reserva
                     Reserva reserva = new Reserva(codigo_Voo, classe, num_pass, numSequencial);
                     // obtém o código da reserva
                     String codigoReserva = reserva.getCodigoReserva();
                     // adiciona a reserva ao mapa de reservas do voo
                     reservasVoo.put(codigoReserva, reserva);
                     // obtém o número da reserva
                     int numReserva = reserva.getNumReserva();
                     // atualiza o mapa de reservas
                     alterarMapaReservas('E', num_pass, numReserva);
                     if (imprimir) {//Não é para imprimir quando é chamada através do comando 'I'
                         // obtém informações sobre a reserva
                         String infoReserva = lugaresDaReserva(codigoReserva, numReserva);
                         // exibe as informações da reserva
                         System.out.println(infoReserva);
                     }
                     // atualiza o número sequencial de reservas
                     numSequencial++;
                 } else {
                     System.out.println("Erro: Não foi possível obter lugares para a reserva: E " + num_pass + "\nSobram "
                             + lugaresDisponiveisExe + " lugar(es) na classe executiva.");
                 }
             } else {
                System.out.println("Erro: Não foi possível obter lugares para a reserva: E " + num_pass
                            + "\nPorque o avião não possui lugares com classe executiva.");
             }
        // verifica se a classe desejada é turística
        } else if (classe == 'T') {
             // verifica se há lugares disponíveis em classe turística
             if (lugaresDisponiveisTur >= num_pass) {
                 // atualiza o número de lugares disponíveis em classe turística
                 lugaresDisponiveisTur -= num_pass;
                 // cria uma nova reserva
                 Reserva reserva = new Reserva(codigo_Voo, classe, num_pass, numSequencial);
                 // obtém o código da reserva
                 String codigoReserva = reserva.getCodigoReserva();
                 // adiciona a reserva ao mapa de reservas do voo
                 reservasVoo.put(codigoReserva, reserva);
                 // obtém o número da reserva
                 int numReserva = reserva.getNumReserva();
                 // atualiza o mapa de reservas
                 alterarMapaReservas('T', num_pass, numReserva);
                 if (imprimir) {//Não é para imprimir quando é chamada através do comando 'I'
                     // obtém informações sobre a reserva
                     String infoReserva = lugaresDaReserva(codigoReserva, numReserva);
                     // exibe as informações da reserva
                     System.out.println(infoReserva);
                 }
                 // atualiza o número sequencial de reservas
                 numSequencial++;
             } else {
                 System.out.println("Erro: Não foi possível obter lugares para a reserva: T " + num_pass + "\nSobram " + lugaresDisponiveisTur
                         + " lugar(es) na classe turística.");
             }
        } else {
            System.out.println("Erro: Classe inexistente. Escolha (T)urística ou (E)xecutiva.");
        }
    }

    /**
     * Método para cancelar uma reserva.
     *
     * @param codigoReserva o código da reserva a ser cancelada
     */
    public void cancelarReserva(String codigoReserva) {
        // Verifica se a reserva existe
        if (this.reservasVoo.containsKey(codigoReserva)) {
            // Obtém a reserva a ser cancelada
            Reserva reservaCancelada = this.reservasVoo.get(codigoReserva);
            // Remove a reserva do mapa de reservas
            this.reservasVoo.remove(codigoReserva);
            // Obtém a classe, o número de lugares e o número da reserva cancelada
            char classe = reservaCancelada.getClasse();
            int numLugares = reservaCancelada.getNumPass();
            int numReserva = reservaCancelada.getNumReserva();
            // Remove a reserva do mapa de assentos
            removerReservaMapa(classe, numReserva);
            // Incrementa o número de lugares disponíveis de acordo com a classe da reserva cancelada
            if (classe == 'T') {
                lugaresDisponiveisTur += numLugares;
            } else if (classe == 'E') {
                lugaresDisponiveisExe += numLugares;
            }
            System.out.println("A reserva " + codigoReserva + " foi cancelada.");
        } else {
            System.out.println("Erro: Código de reserva inválido.");
        }
    }

    /**
     *Método para exibir o mapa de voo, mostrando as reservas de cada lugar no avião.
     */
    public void exibirReservas() {
        // Obtenção do número de filas para classe executiva e classe turística
        int filasExecutiva = this.aviao.getFilasExecutiva();
        int filasTuristica = this.aviao.getFilasTuristica();
        int totalFilas = filasExecutiva + filasTuristica;
        // Obtenção do número de lugares por fila para classe executiva e classe turística
        int lugPorExecutiva = this.aviao.getLugPorFilaExecutiva();
        int lugPorTuristica = this.aviao.getLugPorFilaTuristica();
        // Impressão das filas numeradas
        System.out.format("   ");
        for (int fila = 1; fila <= totalFilas; fila++) {
            System.out.format("%2d ", fila);
        }
        // Impressão dos lugares e seus respectivos números de reserva
        for (int lugar = 0; lugar < Math.max(lugPorExecutiva, lugPorTuristica); lugar++) {
            // Cálculo do código ASCII do caractere do lugar
            int ascii = 65 + lugar; // 'A' (65) + lugar (começa no 0)
            char ultimoLugar = (char) ascii; // Conversão do código ASCII para caractere
            System.out.format("\n%c  ", ultimoLugar);
            // Impressão das reservas da classe executiva
            for (int fila = 0; fila < filasExecutiva; fila++) {
                // Impressão dos números de reserva se a classe executiva existir e se o lugar for válido
                if (this.temClasseExecutiva && lugar < lugPorExecutiva) {
                    System.out.format("%2d ", this.lugaresExec[fila][lugar]);
                // Se o lugar não for válido, imprime espaços em branco
                } else if (this.temClasseExecutiva && lugar >= lugPorExecutiva) {
                    System.out.format("   ");
                }
            }
            // Impressão das reservas da classe turística
            for (int fila = 0; fila < filasTuristica; fila++) {
                System.out.format("%2d ", this.lugaresTur[fila][lugar]);
            }
        }
        // Impressão de uma nova linha para melhorar a aparência do output
        System.out.format("\n");
    }

    //método toString
    public String toString() {
        return "Código de voo " + this.codigo;
    }
}