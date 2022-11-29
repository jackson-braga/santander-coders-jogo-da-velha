import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PauloVitorJogoDaVelha {
    public static void main (String[] args){
        System.out.println("Bem vindo ao jogo da velha!");
        System.out.println("Vocês poderão fazer as jogadas utilizando as respectivas posições no tabuleiro!");
        String linha1 = " 1 | 2 | 3 ";
        String linha2 = " 4 | 5 | 6 ";
        String linha3 = " 7 | 8 | 9 ";

        System.out.println(linha1);
        System.out.println("---*---*---");
        System.out.println(linha2);
        System.out.println("---*---*---");
        System.out.println(linha3);

        System.out.println("Prontos para começar? (S/N)");
        Scanner scan = new Scanner(System.in);
        String jogar = scan.next();

        boolean jogada = true;

        if(Objects.equals(jogar, "N")){
            System.out.println("Jogo cancelado!");
        }

        System.out.println("Informe o nome do primeiro jogador");
        String jogador1 = scan.next();
        System.out.println("Informe o nome do segundo jogador");
        String jogador2 = scan.next();
        System.out.println("Jogador: " + jogador1 + ". Jogador 2: " + jogador2);
        String ganhador = " ";

        int cont = 1;
        String [][]tabuleiro = new String[3][3];
        tabuleiro[0][0]="1";
        tabuleiro[0][1]="2";
        tabuleiro[0][2]="3";
        tabuleiro[1][0]="4";
        tabuleiro[1][1]="5";
        tabuleiro[1][2]="6";
        tabuleiro[2][0]="7";
        tabuleiro[2][1]="8";
        tabuleiro[2][2]="9";

        while(ganhador.equals(" ")){
            int jogadaJogador = 0;

            boolean jogadaValida = true;

            do{
                if (jogada) {
                    System.out.println(jogador1 + " faça sua jogada.");
                    System.out.println("Tabuleiro:");
                    System.out.println("------------------------------------");
                    System.out.println(" " + (tabuleiro[0][0]) + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
                    System.out.println("---*---*---");
                    System.out.println(" " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
                    System.out.println("---*---*---");
                    System.out.println(" " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
                    System.out.println("------------------------------------");
                } else {
                    System.out.println(jogador2 + " faça sua jogada.");
                    System.out.println("Tabuleiro:");
                    System.out.println("------------------------------------");
                    System.out.println(" " + (tabuleiro[0][0]) + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
                    System.out.println("---*---*---");
                    System.out.println(" " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
                    System.out.println("---*---*---");
                    System.out.println(" " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
                    System.out.println("------------------------------------");
                }

                jogadaJogador = scan.nextInt();

                if (jogadaJogador == 1 && Objects.equals(tabuleiro[0][0], "1")) {
                    tabuleiro[0][0] = jogada ? "x" : "o";
                } else if (jogadaJogador == 2 && Objects.equals(tabuleiro[0][1], "2")) {
                    tabuleiro[0][1] = jogada ? "x" : "o";
                } else if (jogadaJogador == 3 && Objects.equals(tabuleiro[0][2], "3")) {
                    tabuleiro[0][2] = jogada ? "x" : "o";
                } else if (jogadaJogador == 4 && Objects.equals(tabuleiro[1][0], "4")) {
                    tabuleiro[1][0] = jogada ? "x" : "o";
                } else if (jogadaJogador == 5 && Objects.equals(tabuleiro[1][1], "5")) {
                    tabuleiro[1][1] = jogada ? "x" : "o";
                } else if (jogadaJogador == 6 && Objects.equals(tabuleiro[1][2], "6")) {
                    tabuleiro[1][2] = jogada ? "x" : "o";
                } else if (jogadaJogador == 7 && Objects.equals(tabuleiro[2][0], "7")) {
                    tabuleiro[2][0] = jogada ? "x" : "o";
                } else if (jogadaJogador == 8 && Objects.equals(tabuleiro[2][1], "8")) {
                    tabuleiro[2][1] = jogada ? "x" : "o";
                } else if (jogadaJogador == 9 && Objects.equals(tabuleiro[2][2], "9")) {
                    tabuleiro[2][2] = jogada ? "x" : "o";
                } else {
                    System.out.println("------------------------------------------------------");
                    System.out.println("Jogada inválida! A posição já foi preenchida!");
                    System.out.println("------------------------------------------------------");
                    jogadaValida = false;
                }
            }while(!jogadaValida);

            System.out.println("Tabuleiro:");
            System.out.println("------------------------------------");
            System.out.println(" " + (tabuleiro[0][0]) + " | " + tabuleiro[0][1] + " | " +  tabuleiro[0][2]);
            System.out.println("---*---*---");
            System.out.println(" " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " +  tabuleiro[1][2]);
            System.out.println("---*---*---");
            System.out.println(" " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " +  tabuleiro[2][2]);
            System.out.println("------------------------------------");

            //Verificando da primeira a terceira linha
            if(Objects.equals(tabuleiro[0][0], tabuleiro[0][1]) && Objects.equals(tabuleiro[0][0], tabuleiro[0][2])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            } else if (Objects.equals(tabuleiro[1][0], tabuleiro[1][1]) && Objects.equals(tabuleiro[1][0], tabuleiro[1][2])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            }else if (Objects.equals(tabuleiro[2][0], tabuleiro[2][1]) && Objects.equals(tabuleiro[2][0], tabuleiro[2][2])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            }
            //Verificando da primeira a terceira coluna
            else if(Objects.equals(tabuleiro[0][0], tabuleiro[1][0]) && Objects.equals(tabuleiro[0][0], tabuleiro[2][0])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            } else if (Objects.equals(tabuleiro[0][1], tabuleiro[1][1]) && Objects.equals(tabuleiro[0][1], tabuleiro[2][1])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            }else if (Objects.equals(tabuleiro[0][2], tabuleiro[1][2]) && Objects.equals(tabuleiro[0][2], tabuleiro[2][2])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            }
            //Verificando as duas diagonais
            else if(Objects.equals(tabuleiro[0][0], tabuleiro[1][1]) && Objects.equals(tabuleiro[0][0], tabuleiro[2][2])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            } else if (Objects.equals(tabuleiro[0][2], tabuleiro[1][1]) && Objects.equals(tabuleiro[0][2], tabuleiro[2][0])){
                ganhador = Objects.equals(tabuleiro[0][0], "x") ? jogador1 : jogador2;
            }

            jogada = !jogada;
            if(!Objects.equals(ganhador, " ")){
                break;
            }
        }

        System.out.println("Finalizou!");
        System.out.println("Finalizou! Parabéns " + ganhador + "! Você venceu! :D :D :D :D :D ");
        System.out.println("------------------------------------");
        System.out.println(" " + (tabuleiro[0][0]) + " | " + tabuleiro[0][1] + " | " +  tabuleiro[0][2]);
        System.out.println("---*---*---");
        System.out.println(" " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " +  tabuleiro[1][2]);
        System.out.println("---*---*---");
        System.out.println(" " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " +  tabuleiro[2][2]);
        System.out.println("------------------------------------");
    }
}
