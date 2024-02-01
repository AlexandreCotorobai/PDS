import java.util.HashMap;

/**
 *A classe Gerenciador é responsável por gerenciar os voos e reservas do sistema.
 */
public class Gerenciador {

    // Criação dos mapas de voos e reservas usando HashMap, que permite associar uma chave a um valor
    private static HashMap<String, Flight> voos = new HashMap<>();
    private static HashMap<String, Reserva> reservas = new HashMap<>();

    /**
     *Adiciona um novo voo ao sistema com o código do voo, número de filas e lugares por fila para as classes turística e executiva.
     *@param codigo_Voo o código do voo a ser adicionado
     *@param filas_tur o número de filas na classe turística para o novo voo
     *@param LugPorFila_tur o número de lugares por fila na classe turística para o novo voo
     *@param filas_exec o número de filas na classe executiva para o novo voo (opcional)
     *@param LugPorFila_exec o número de lugares por fila na classe executiva para o novo voo (opcional)
     */
    public static void addVoo(String codigo_Voo, int filas_tur, int LugPorFila_tur, int filas_exec, int LugPorFila_exec) {

        // Verifica se o voo já existe no mapa de voos
        if (voos.containsKey(codigo_Voo)) {
            System.out.println("Erro: Voo " + codigo_Voo + " já adicionado.");
        } else {
            // Criação de um novo objeto Flight para representar o novo voo e adiciona-lo ao mapa de voos
            Flight flight = new Flight(codigo_Voo, filas_tur, LugPorFila_tur, filas_exec, LugPorFila_exec);
            voos.put(codigo_Voo, flight);
        }
    }

    /**
     *Adiciona um novo voo com apenas a classe turística.
     *@param codigo_Voo o código único do novo voo a ser adicionado
     *@param filas_tur o número de filas na classe turística
     *@param LugPorFila_tur o número de lugares por fila na classe turística
     */
    public static void addVoo(String codigo_Voo, int filas_tur, int LugPorFila_tur) {

        // Verifica se o voo já existe no mapa de voos
        if (voos.containsKey(codigo_Voo)) {
            System.out.println("Erro: Voo " + codigo_Voo + " já adicionado.");

        } else {
            // Criação de um novo objeto Flight para representar o novo voo e adiciona-lo ao mapa de voos
            Flight flight = new Flight(codigo_Voo, filas_tur, LugPorFila_tur);
            voos.put(codigo_Voo, flight);
        }
    }

    /**
     *Método para reservar lugares em um voo.
     *@param codigo_Voo o código do voo desejado.
     *@param classe a classe desejada (turística ou executiva).
     *@param num_pass o número de passageiros para reservar lugares.
     *Verifica se o voo existe no mapa de voos. Se existir, chama o método reservar do objeto Flight
     *associado ao código do voo para reservar os lugares solicitados na classe especificada.
     *Se o voo não existir, imprime uma mensagem de erro.
     */
    public static void reservarLugares(String codigo_Voo, char classe, int num_pass, boolean imprimir) {
        // Verifica se o voo existe no mapa de voos
        if (voos.containsKey(codigo_Voo)) {
            // Obtém o objeto Flight associado ao código do voo
            Flight voo = voos.get(codigo_Voo);
            // Chama o método reservar do objeto Flight para reservar os lugares solicitados na classe especificada
            voo.reservar(codigo_Voo, classe, num_pass, imprimir);
        } else {
            System.out.println("Erro: Código de voo não existente");
        }
    }

    /**
     *Método estático para cancelar uma reserva.
     *@param codigoReserva o código da reserva a ser cancelada
     *@throws Exception se o código da reserva não estiver no formato correto
     */
    public static void cancelarReserva(String codigoReserva) {
        try {
            // Obtém o código do voo a partir do código da reserva
            String codigoVoo = codigoReserva.split(":")[0];
            // Verifica se o voo existe no mapa de voos
            if (voos.containsKey(codigoVoo)) {
                // Obtém o objeto Flight associado ao código do voo
                Flight vooAssociado = voos.get(codigoVoo);
                // Chama o método cancelarReserva do objeto Flight para cancelar a reserva solicitada
                vooAssociado.cancelarReserva(codigoReserva);
            }

        } catch (Exception e) {
            System.out.println("Erro: Código de reserva inválido");
        }
    }

    /**
     *Método para exibir o mapa de reservas de um determinado voo.
     *Verifica se o voo existe na lista de voos. Se o voo existir,
     *obtém o objeto Flight correspondente ao voo e chama o método exibirReservas()
     *do objeto Flight para exibir as reservas do voo. Se o voo não existir,
     *exibe uma mensagem de erro.
     *@param codigoVoo o código do voo a ser exibido o mapa de reservas
     */
    public static void MapaReservas(String codigoVoo) {
        // Verifica se o voo existe na lista de voos
        if (voos.containsKey(codigoVoo)) {
            // Obtém o objeto Flight correspondente ao voo
            Flight voo = voos.get(codigoVoo);
            // Chama o método exibirReservas() do objeto Flight
            voo.exibirReservas();
        } else {
            System.out.println("Erro: Código de voo inválido");
        }
    }
}