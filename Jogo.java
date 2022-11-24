package JogoDaVelha;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String marcador = "X";
        int[] placar = new int[2];
        int linha, coluna, partidas;
        String[][] jogada = new String[3][3];
        boolean valida, vitoria;


        System.out.print("Digite o número de partidas: ");
        partidas = scan.nextInt();

//        Fiz a verificação do loop das partidas somando o placar que é um vetor com 2 posições.
//        Cada partida terminaria com alguém ganhando,
//        então a soma do placar do jogador 1 e 2 será igual ao número de partidas jogadas
//        até que o número de partidas seja igual ao que o usuário pediu

        while (placar[0] + placar[1] != partidas) {
            System.out.println("\nNova Rodada!");
            iniciaTabuleiro(jogada);
            imprimeTabuleiro(jogada);

//            Sempre alternar jogadores para o Jogador 2 ter a chance de iniciar,
//            inclusive numa nova rodada

            do {
                do {
                    System.out.printf("Jogador %s, sua vez", marcador);
                    System.out.print("\nDigite a linha: ");
                    linha = scan.nextInt();
                    System.out.print("Digite a coluna: ");
                    coluna = scan.nextInt();

                    valida = verificaJogada(jogada, marcador, linha, coluna);

//          Se a função verificaJogada não retornar um valor true
//          voltamos ao loop para que o jogador repita as estradas

                } while (!valida);

                System.out.println();
                imprimeTabuleiro(jogada);

//          A função verificaVitoria vai retornar um valor que será usada no final do do-while
//          para terminar a partida se alguém já ganhou

                vitoria = verificaVitoria(jogada, marcador);

                if (vitoria){
                    if (marcador.equals("X")) {
                        placar[0]++;
                    } else { placar[1]++;}
                    System.out.printf("O Jogador %s ganhou essa rodada!", marcador);
                    System.out.println("\n      Placar");
                    System.out.printf("Jogador 1: %d ", placar[0]);
                    System.out.printf("\nJogador 2: %d ", placar[1]);
                }
                if (marcador.equals("X")){
                    marcador = "O";
                } else {
                    marcador = "X";}

            } while (!vitoria);

            System.out.println();
        }

//      Aqui mostramos quem ganhou ao final do número de partidas selecionado pelo usuário

        if (placar[0] > placar[1]) {
            System.out.println("Jogador 1 venceu o jogo!!");
        } else if (placar[0] < placar[1]) {
            System.out.println("Jogador 2 venceu o jogo!!");
        } else {
            System.out.println("Empate!!");
        }
    }

    public static void iniciaTabuleiro(String[][] jogada) {
//      Preenche o tabuleiro (matriz) com valores de String em branco
//      para que a verificação seja no verificaJogada

        String branco = " ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogada[i][j] = branco;
            }
        }
    }

    public static void imprimeTabuleiro(String[][] jogada) {
        System.out.println("   c0   c1  c2");
        System.out.printf("l0  %s | %s | %s \n", jogada[0][0], jogada[0][1], jogada[0][2]);
        System.out.println("    _________");
        System.out.printf("l1  %s | %s | %s \n", jogada[1][0], jogada[1][1], jogada[1][2]);
        System.out.println("    _________");
        System.out.printf("l2  %s | %s | %s \n", jogada[2][0], jogada[2][1], jogada[2][2]);
        System.out.println();
    }

    public static boolean verificaVitoria(String[][] jogada, String marcador) {
        boolean vitoria = false;

//      Vitória por linha
        if (jogada[0][0].equals(marcador) && jogada[0][1].equals(marcador) && jogada[0][2].equals(marcador)) {
            vitoria = true;
        } else if (jogada[1][0].equals(marcador) && jogada[1][1].equals(marcador) && jogada[1][2].equals(marcador)) {
            vitoria = true;
        } else if (jogada[2][0].equals(marcador) && jogada[2][1].equals(marcador) && jogada[2][2].equals(marcador)) {
            vitoria = true;
        }
//      Vitória por coluna
        if (jogada[0][0].equals(marcador) && jogada[1][0].equals(marcador) && jogada[2][0].equals(marcador)) {
            vitoria = true;
        } else if (jogada[0][1].equals(marcador) && jogada[1][1].equals(marcador) && jogada[2][1].equals(marcador)) {
            vitoria = true;
        } else if (jogada[0][2].equals(marcador) && jogada[1][2].equals(marcador) && jogada[2][2].equals(marcador)) {
            vitoria = true;
        }
//      Vítoria por diagonal
        if (jogada[0][0].equals(marcador) && jogada[1][1].equals(marcador) && jogada[2][2].equals(marcador)) {
            vitoria = true;
        } else if (jogada[0][2].equals(marcador) && jogada[1][1].equals(marcador) && jogada[2][0].equals(marcador)) {
            vitoria = true;
        }
        return vitoria;
    }

    public static boolean verificaJogada(String[][] jogada, String marcador, int linha, int coluna) {
//      Função que verifica se a jogada é válida.
//      Ou seja, se o valor digitado está no tabuleiro(matriz) ou se já não foi ocupada.

        String branco = " ";
        boolean validada = false;
        try {
            if (jogada[linha][coluna].equals(branco)) {
                jogada[linha][coluna] = marcador;
                validada = true;
            } else {
                System.out.println("Jogada Inválida. Espaço já ocupado");
            }
        }
            catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Jogada Inválida. Escolha entre as linhas e colunas 0, 1 ou 2");
        }
      return validada;
    }
}