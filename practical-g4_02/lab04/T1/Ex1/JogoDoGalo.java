public class JogoDoGalo implements JGaloInterface {
    private int lines = 3, columns = 3;
    private char jogador;
    private char win;
    private int turns = 0;
    char [][] jogo;
    //Variáveis inicializadas
    //O painel é implementado num array bidimensional
    //A variável que representa o jogador
    //E o vencedor
    public JogoDoGalo(){
        jogo =  new char[lines][columns];
        jogador = 'X';
        win = ' ';
    }

    //Jogador que vai jogar.
    public char getActualPlayer(){
        return jogador;
    }

    //Jogada implementada no array char[][] para fins lógicos
    public boolean setJogada(int lin, int col){
        boolean check = false;
        if(jogo[lin-1][col-1] == 0){
            jogo[lin-1][col-1] = this.jogador;
            check = true;
            toggle();
            turns++;
        }
        return check;
    }
    //Retorna o resultado.
    public char checkResult(){
        return this.win;
    }
    //Verifica, recorrentemente, se o jogo já terminou.
    public boolean isFinished(){
        boolean check = false;
        String diagonal1 = String.valueOf(jogo[0][0]) + String.valueOf(jogo[1][1]) + String.valueOf(jogo[2][2]);
        String diagonal2= String.valueOf(jogo[0][2]) + String.valueOf(jogo[1][1]) + String.valueOf(jogo[2][0]);
        String check1 = "XXX", check2 = "OOO", dummy = "";
        
            //Verificar se alguma linha contém uma sequência vencedora.
            for(int i=0;i<this.lines; i++){
                for(int j=0;j<this.columns;j++){   
                    dummy += jogo[i][j];
                }
                if(dummy.equals(check1) || dummy.equals(check2)){
                    this.win = dummy.charAt(0);
                    check = true;
                    break;
                }
                dummy = "";
            }
            //Se não foi encontra a sequência vencedora na linha, segue-se
            //então para a verificação das colunas. 
            //Caso contrário não é verificado mais nada.
            if(check == false){
                //Verificar se alguma coluna contém uma sequência vencedora.
                for(int i=0;i<this.lines; i++){
                    for(int j=0;j<this.columns;j++){   
                        dummy += jogo[j][i];
                    }
                    if(dummy.equals(check1) || dummy.equals(check2)){
                        this.win = dummy.charAt(0);
                        check = true;
                        break;
                    }
                    dummy = "";
                }
            }
            //Se não foi encontra a sequência vencedora na coluna, segue-se
            //então para a verificação das diagonais. 
            if(check == false){
                //Verificar se alguma diagonal contém uma sequência vencedora.
                if(diagonal1.equals(check1) || diagonal1.equals(check2)){
                    this.win = diagonal1.charAt(0);
                    check = true;
                }else if(diagonal2.equals(check1) || diagonal2.equals(check2)){
                    this.win = diagonal2.charAt(0);
                    check = true;
                }
            }
        return check;
    }

    //Mudança de jogador.
    public void toggle(){
        if(this.jogador == 'X'){
            this.jogador = 'O';
        }else if(this.jogador == 'O'){
            this.jogador = 'X';
        }
    }
}
