package src;

import java.util.Scanner;

/**
 * @author CrisMoura on 24/11/2022
 */
public class JogoDaVelha {

    static String[][] tabuleiro = {{" "," "," "},{" "," "," "},{" "," "," "}};
    static int qtdRodadas = 0;
    static boolean existeGanhador;

    static String player = "player1";

    public static void main(String[] args) throws JogaInvalidaException {

        do {
            System.out.println("##### RODADA - " + qtdRodadas + " #####");

            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println(player.toUpperCase()+", Escolha uma linha e coluna :");
                int linha = scanner.nextInt()-1;
                int coluna = scanner.nextInt()-1;

                jogada(linha, coluna, player);
                imprimeTabuleiro();
                if(verificaGanhador(player)){
                    existeGanhador = true;
                    break;
                }

                if (player.equalsIgnoreCase("player1")){
                    player = "player2";
                }else {
                    player = "player1";
                }

            }catch (JogaInvalidaException e){
                System.out.println("Posição já escolhida por favor selecione outra");
            }


        }while (qtdRodadas <= 9 && !existeGanhador);
    }
    private static boolean verificaGanhador(String player) {

        if(player.equalsIgnoreCase("player1")){
            if (isGanhadorDiagonal("X") || isGanhadorLinhas("X") || isGanhadorColunas("X")){
               System.out.println("Parabens " + player.toUpperCase() + " Você é o ganhador !!!!!!!");
               return true;
            }
        }else {
            if (isGanhadorDiagonal("O") || isGanhadorLinhas("O") || isGanhadorColunas("O")){
                System.out.println("Parabens " + player.toUpperCase() + " Você é o ganhador !!!!!!!");
                return true;
            }
        }

        return false;
    }

    private static boolean isGanhadorColunas(String figura) {
        //Colunas
        if ((tabuleiro[0][0] == figura && tabuleiro[1][0] == figura && tabuleiro[2][0] == figura) ||
                (tabuleiro[0][1] == figura && tabuleiro[1][1] == figura && tabuleiro[2][1] == figura)||
                (tabuleiro[0][2] == figura && tabuleiro[1][2] == figura && tabuleiro[2][2] == figura)) {
            return true;
        }

        return false;
    }

    private static boolean isGanhadorLinhas(String figura) {
        //Linhas
        if ((tabuleiro[0][0] == figura && tabuleiro[0][1] == figura && tabuleiro[0][2] == figura) ||
                (tabuleiro[1][0] == figura && tabuleiro[1][1] == figura && tabuleiro[1][2] == figura)||
                (tabuleiro[2][0] == figura && tabuleiro[2][1] == figura && tabuleiro[2][2] == figura)) {
            return true;
        }

        return false;
    }

    private static boolean isGanhadorDiagonal(String figura) {
        //Diagonais
        if(tabuleiro[0][0] == figura && tabuleiro[1][1] == figura && tabuleiro[2][2] == figura){
            return true;
        } else if (tabuleiro[0][2] == figura && tabuleiro[1][1] == figura && tabuleiro[2][0] == figura) {
            return true;
        }

        return false;
    }

    private static void imprimeTabuleiro() {
        System.out.println("|---|---|---|");
        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print("| " + tabuleiro[i][j] +" ");
            }
            System.out.print("|");
            System.out.println("");
            System.out.println("|---|---|---|");
        }
    }

    private static boolean jogada(int linha, int coluna, String player) throws JogaInvalidaException {
        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro[i].length; j++){
                if (i == linha && j == coluna){
                    if(tabuleiro[i][j] == " "){
                        if (player.equalsIgnoreCase("player1")){
                            tabuleiro[i][j] = "X";
                        }else if(player.equalsIgnoreCase("player2")){
                            tabuleiro[i][j] = "O";
                        }
                        qtdRodadas++;
                        return true;
                    }else{
                        throw new JogaInvalidaException();
                    }

                }
            }
        }
        return false;
    }
}
