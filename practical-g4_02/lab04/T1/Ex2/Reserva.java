/*
* Reserva representa uma reserva de um voo,
* contendo informações como a classe da reserva (turística ou executiva),
* o número de passageiros e o número da reserva em si.
*/
public class Reserva {

    private char classe; // classe da reserva (turística ou executiva)
    private int num_pass; // número de passageiros
    private String codigo_reserva; // código da reserva
    private int numReserva; // número da reserva

    /**
     *Construtor da classe Reserva.
     *@param codigo_Voo o código do voo da reserva
     *@param classe a classe da reserva (T para turística e E para executiva)
     *@param num_pass o número de passageiros
     *@param numReserva o número da reserva
     */
    public Reserva(String codigo_Voo, char classe, int num_pass, int numReserva) {
        this.classe = classe; // atribui o valor da classe
        this.num_pass = num_pass; // atribui o valor do número de passageiros
        this.numReserva = numReserva; // atribui o valor do número da reserva
        this.codigo_reserva = codigo_Voo + ":" + numReserva; // cria o código da reserva a partir do código do voo e do número da reserva
    }

    /**
     *Método para obter o código da reserva.
     *@return o código da reserva
     */
    public String getCodigoReserva() {
        return this.codigo_reserva; // retorna o código da reserva
    }

    /**
     *Método para obter a classe da reserva.
     *@return a classe da reserva
     */
    public char getClasse() {
        return this.classe; // retorna a classe da reserva
    }

    /**
     *Método para obter o número de passageiros da reserva.
     *@return o número de passageiros da reserva
     */
    public int getNumPass() {
        return this.num_pass; // retorna o número de passageiros da reserva
    }

    /**
     *Método para obter o número da reserva.
     *@return o número da reserva
     */
    public int getNumReserva() {
        return this.numReserva; // retorna o número da reserva
    }
}