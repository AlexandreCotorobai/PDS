/*
* A classe Avião define a estrutura de um avião.
* Ela tem quatro variáveis de instância que armazenam informações sobre as filas e assentos de cada classe.
* Os dois primeiros argumentos do construtor são necessários e definem as informações para a classe turística,
* enquanto os dois últimos são opcionais e definem as informações para a classe executiva.
* Os quatro métodos get definidos nesta classe retornam o número de filas e assentos em cada classe.
*/
public class Avião {

    // Variáveis de instância
    private int filas_tur; // número de filas na classe turística
    private int LugPorFila_tur; // número de lugares por fila na classe turística
    private int filas_exec; // número de filas na classe executiva
    private int LugPorFila_exec; // número de lugares por fila na classe executiva

    /**
     *Construtor para avião com classe turística apenas.
     *@param filas_tur número de filas na classe turística.
     *@param LugPorFila_tur número de lugares por fila na classe turística.
     */
    public Avião(int filas_tur, int LugPorFila_tur) {
        this.filas_tur = filas_tur;
        this.LugPorFila_tur = LugPorFila_tur;
        this.LugPorFila_exec = 0; // número de lugares por fila na classe executiva é 0
    }

    /**
     *Construtor para avião com ambas as classes.
     *@param filas_tur número de filas na classe turística.
     *@param LugPorFila_tur número de lugares por fila na classe turística.
     *@param filas_exec número de filas na classe executiva.
     *@param LugPorFila_exec número de lugares por fila na classe executiva.
     */
    public Avião(int filas_tur, int LugPorFila_tur, int filas_exec, int LugPorFila_exec) {
        this.filas_exec = filas_exec;
        this.filas_tur = filas_tur;
        this.LugPorFila_tur = LugPorFila_tur;
        this.LugPorFila_exec = LugPorFila_exec;
    }

    /**
     *Retorna o número de lugares por fila na classe turística.
     *@return o número de lugares por fila na classe turística.
     */
    public int getLugPorFilaTuristica() {
        return this.LugPorFila_tur;
    }

    /**
     *Retorna o número de filas na classe turística.
     *@return o número de filas na classe turística.
     */
    public int getFilasTuristica() {
        return this.filas_tur;
    }

    /**
     *Retorna o número de lugares por fila na classe executiva.
     *@return o número de lugares por fila na classe executiva.
     */
    public int getLugPorFilaExecutiva() {
        return this.LugPorFila_exec;
    }

    /**
     *Retorna o número de filas na classe executiva.
     *@return o número de filas na classe executiva.
     */
    public int getFilasExecutiva() {
        return this.filas_exec;
    }
}