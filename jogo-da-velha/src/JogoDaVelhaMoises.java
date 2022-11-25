package jogodavelha;

import java.util.Objects;
import java.util.Scanner;

public class JogoDaVelhaMoises {
    private static final String[][] tabuleiroApresentacao = new String[3][3];
    private static final String[][] tabuleiroJogo = new String[3][3];

    public static void main(String[] args) throws JogadaInvalidaException {

//      Chamar o método para apresentar o Jogo
        apresentarJogo();

//      Chamar o método para executar o jogo
        executarJogo();
    }

    public static void apresentarJogo() {

        //  Apresentar as regras do jogo
        System.out.println("Bem vindo ao Jogo da Velha!");
        System.out.println("Neste jogo para dois jogadores, ganha a partida quem primeiro conseguir formar uma \nsequência de mesmo símbolo na horizontal, na vertical ou na diagonal.");
        System.out.println("O Jogador 1 utiliza o símbolo 'X' e o Jogador 2, o símbolo 'O'.");
        System.out.println("Para fazer sua jogada, o Jogador deverá indicar primeiramente a linha, e depois a \ncoluna onde está localizado o lugar que deseja marcar.");
        System.out.println("Para referência, exibiremos um desenho em que constam os respectivos \nnúmeros de linha (L) e coluna (C):");

        //  Chamar o méotdo para carregar tabuleiro de apresentaçao com índices e legendas
        carregarTabuleiroApresentacao();

        //  Chamar o método para imprimir tabuleiro de apresentação
        imprimirTabuleiroApresentacao();
    }

    public static void carregarTabuleiroApresentacao() {

        //  Carregar tabuleiro de apresentação com referências de linhas e colunas
        for (int i = 0; i < tabuleiroApresentacao.length; i++) {
            for (int j = 0; j < tabuleiroApresentacao.length; j++) {
                tabuleiroApresentacao[i][j] = i + " - " + j + " | ";
            }
        }
    }

    public static void imprimirTabuleiroApresentacao() {

        //  Imprimir tabuleiro de apresentação no formato de jogo da velha
        System.out.println("L---C---L---C---L---C-");
        for (String[] strings : tabuleiroApresentacao) {
            StringBuilder impressao = new StringBuilder();
            for (int j = 0; j < tabuleiroApresentacao.length; j++) {
                if (strings[j] == null) {
                    impressao.append("     |");
                } else {
                    impressao.append(strings[j]);
                }
            }
            System.out.println(impressao);
            System.out.println("------+-------+-------");
        }
    }

    public static void executarJogo() throws JogadaInvalidaException {

        Scanner scan = new Scanner(System.in);

        int contadorVitorias1 = 0;
        int contadorVitorias2 = 0;
        int contadorEmpates = 0;
        int partidasJogadas;
        int qtdPartidas;

        //  Pedir que o usuário defina a quantidade de partidas e salvar em uma variável de controle
        do {
            System.out.println("Informe a quantidade de partidas desejadas:");
            qtdPartidas = scan.nextInt();
        } while (qtdPartidas <= 0);

        //  Iniciar execuçao do Jogo
        //  Entrar no laço de repetição que executará o jogo enquanto a quantidade de partidas informada pelo usuário não for atendida.
        do {
            int verificadorNovaPartida = 0;

            //  Carregar tabuleiro em branco
            carregarTabuleiroJogo();
            System.out.println("\nIniciando nova partida.");

            //  Entrar no laço de repetição que executará o jogo até que hava um vencedor da partida
            do {
                jogadaJogador1();

                //  Verificar se o Jogador 1 venceu a partida
                if (verificarGanhador1()) {
                    imprimirTabuleiroJogo();
                    contadorVitorias1++;
                    verificadorNovaPartida++;
                    break;

                } else if (verificarEmpate()) {
                    contadorEmpates++;
                    break;
                }

                jogadaJogador2();

                //  Verificar se o Jogador 2 venceu a partida
                if (verificarGanhador2()) {
                    imprimirTabuleiroJogo();
                    contadorVitorias2++;
                    verificadorNovaPartida++;
                    break;

                } else if (verificarEmpate()) {
                    contadorEmpates++;
                    break;
                }

                //  Implementar a condição para que se houver um vencedor na partida, sair do laço
            } while (verificadorNovaPartida == 0);

            if (verificarGanhador1()) {
                System.out.println("\nJogador 1 ganhou a partida!");
            } else if (verificarGanhador2()) {
                System.out.println("\nJogador 2 ganhou a partida!");
            }
            System.out.println("\nScore:");
            System.out.println("Jogador 1: " + contadorVitorias1);
            System.out.println("Jogador 2: " + contadorVitorias2);
            System.out.println("Empates: " + contadorEmpates);

            //  Implementar a condição para que se a quantidade de partidas desejas for atingida, e não houver empate, sair do laço
            partidasJogadas = contadorVitorias1 + contadorVitorias2 + contadorEmpates;
        }
        while ((partidasJogadas < qtdPartidas) || contadorVitorias1 == contadorVitorias2);

        if (contadorVitorias1 > contadorVitorias2) {
            System.out.println("\nVencedor: Jogador 1, com " + contadorVitorias1 + " vitórias em " + partidasJogadas + " partidas jogadas.");
        } else {
            System.out.println("\nVencedor: Jogador 2, com " + contadorVitorias2 + " vitórias em " + partidasJogadas + " partidas jogadas.");
        }
        System.out.println("Encerrando jogo!");
    }
    public static void jogadaJogador1() {
        Scanner scan = new Scanner(System.in);
        boolean linhaCorreta1 = false;
        boolean colunaCorreta1 = false;
        int jogador1Linha;
        do {
            System.out.println("\nJogador 1: Informe a linha:");
            jogador1Linha = scan.nextInt();
            if (jogador1Linha < 0 || jogador1Linha > 2) {
                System.out.println("Jogada inválida!");
                imprimirTabuleiroJogo();
                System.out.println("\nInforme uma linha válida entre 0 e 2:");
            } else {
                linhaCorreta1 = true;
            }
        } while (!linhaCorreta1);

        do {
            System.out.println("Jogador 1: Informe a coluna:");
            int jogador1Coluna = scan.nextInt();
            if (jogador1Coluna < 0 || jogador1Coluna > 2) {
                System.out.println("Jogada inválida!");
                imprimirTabuleiroJogo();
                System.out.println("\nInforme uma coluna válida entre 0 e 2:");
            } else if (Objects.equals(tabuleiroJogo[jogador1Linha][jogador1Coluna], "X") || Objects.equals(tabuleiroJogo[jogador1Linha][jogador1Coluna], "O")) {
                System.out.println("Jogada inválida. Espaço já ocupado.");
                imprimirTabuleiroJogo();
                System.out.println("\nInforme outro espaço: ");
                jogadaJogador1();
                break;
            } else if (Objects.equals(tabuleiroJogo[jogador1Linha][jogador1Coluna], " ")) {
                tabuleiroJogo[jogador1Linha][jogador1Coluna] = "X";
                colunaCorreta1 = true;
            }
        } while (!colunaCorreta1);
    }
    public static void jogadaJogador2() {
        Scanner scan = new Scanner(System.in);
        boolean linhaCorreta2 = false;
        boolean colunaCorreta2 = false;
        int jogador2Linha;
        do {
            System.out.println("\nJogador 2: Informe a linha:");
            jogador2Linha = scan.nextInt();
            if (jogador2Linha < 0 || jogador2Linha > 2) {
                System.out.println("Jogada inválida!");
                imprimirTabuleiroJogo();
                System.out.println("\nInforme uma linha válida entre 0 e 2:");
            } else {
                linhaCorreta2 = true;
            }
        } while (!linhaCorreta2);

        do {
            System.out.println("Jogador 2: Informe a coluna:");
            int jogador2Coluna = scan.nextInt();
            if (jogador2Coluna < 0 || jogador2Coluna > 2) {
                System.out.println("Jogada inválida!");
                imprimirTabuleiroJogo();
                System.out.println("\nInforme uma coluna válida entre 0 e 2:");
            } else if (Objects.equals(tabuleiroJogo[jogador2Linha][jogador2Coluna], "X") || Objects.equals(tabuleiroJogo[jogador2Linha][jogador2Coluna], "O")) {
                System.out.println("Jogada inválida. Espaço já ocupado.");
                imprimirTabuleiroJogo();
                System.out.println("\nInforme outro espaço: ");
                jogadaJogador2();
                break;
            } else if (Objects.equals(tabuleiroJogo[jogador2Linha][jogador2Coluna], " ")) {
                tabuleiroJogo[jogador2Linha][jogador2Coluna] = "O";
                colunaCorreta2 = true;
            }
        } while (!colunaCorreta2);
    }
    public static boolean verificarGanhador1() {
        boolean verificadorParada = false;
        if (tabuleiroJogo[0][0].equals("X") && tabuleiroJogo[1][1].equals("X") && tabuleiroJogo[2][2].equals("X")
                || tabuleiroJogo[2][0].equals("X") && tabuleiroJogo[1][1].equals("X") && tabuleiroJogo[0][2].equals("X")
                || tabuleiroJogo[0][0].equals("X") && tabuleiroJogo[0][1].equals("X") && tabuleiroJogo[0][2].equals("X")
                || tabuleiroJogo[1][0].equals("X") && tabuleiroJogo[1][1].equals("X") && tabuleiroJogo[1][2].equals("X")
                || tabuleiroJogo[2][0].equals("X") && tabuleiroJogo[2][1].equals("X") && tabuleiroJogo[2][2].equals("X")
                || tabuleiroJogo[0][0].equals("X") && tabuleiroJogo[1][0].equals("X") && tabuleiroJogo[2][0].equals("X")
                || tabuleiroJogo[0][1].equals("X") && tabuleiroJogo[1][1].equals("X") && tabuleiroJogo[2][1].equals("X")
                || tabuleiroJogo[0][2].equals("X") && tabuleiroJogo[1][2].equals("X") && tabuleiroJogo[2][2].equals("X")) {
            verificadorParada = true;
        } else {
            imprimirTabuleiroJogo();
        }
        return verificadorParada;
    }
    public static boolean verificarGanhador2() {
        boolean verificadorParada = false;

        if (tabuleiroJogo[0][0].equals("O") && tabuleiroJogo[1][1].equals("O") && tabuleiroJogo[2][2].equals("O")
                || tabuleiroJogo[2][0].equals("O") && tabuleiroJogo[1][1].equals("O") && tabuleiroJogo[0][2].equals("O")
                || tabuleiroJogo[0][0].equals("O") && tabuleiroJogo[0][1].equals("O") && tabuleiroJogo[0][2].equals("O")
                || tabuleiroJogo[1][0].equals("O") && tabuleiroJogo[1][1].equals("O") && tabuleiroJogo[1][2].equals("O")
                || tabuleiroJogo[2][0].equals("O") && tabuleiroJogo[2][1].equals("O") && tabuleiroJogo[2][2].equals("O")
                || tabuleiroJogo[0][0].equals("O") && tabuleiroJogo[1][0].equals("O") && tabuleiroJogo[2][0].equals("O")
                || tabuleiroJogo[0][1].equals("O") && tabuleiroJogo[1][1].equals("O") && tabuleiroJogo[2][1].equals("O")
                || tabuleiroJogo[0][2].equals("O") && tabuleiroJogo[1][2].equals("O") && tabuleiroJogo[2][2].equals("O")) {
            verificadorParada = true;
        } else {
            imprimirTabuleiroJogo();
        }
        return verificadorParada;
    }

    public static boolean verificarEmpate() {
        boolean verificadorParada = false;
        if (!tabuleiroJogo[0][0].equals(" ") && !tabuleiroJogo[0][1].equals(" ") && !tabuleiroJogo[0][2].equals(" ")
                && !tabuleiroJogo[1][0].equals(" ") && !tabuleiroJogo[1][1].equals(" ") && !tabuleiroJogo[1][2].equals(" ")
                && !tabuleiroJogo[2][0].equals(" ") && !tabuleiroJogo[2][1].equals(" ") && !tabuleiroJogo[2][2].equals(" "))
        {
            verificadorParada = true;
            System.out.println("\nA partida ficou empatada!");
        }
        return verificadorParada;
    }

    public static void carregarTabuleiroJogo() {

        //  Carregar tabuleiro de apresentação com referências de linhas e colunas
        for (int i = 0; i < tabuleiroJogo.length; i++) {
            for (int j = 0; j < tabuleiroJogo.length; j++) {
                tabuleiroJogo[i][j] = " ";
            }
        }
    }

    public static void imprimirTabuleiroJogo() {

        //  Imprimir tabuleiro de apresentação no formato de jogo da velha
        System.out.printf("  " + tabuleiroJogo[0][0] + "  |");
        System.out.printf("  " + tabuleiroJogo[0][1] + "  |");
        System.out.printf("  " + tabuleiroJogo[0][2] + "  ");
        System.out.println("\n-----+-----+-----");
        System.out.printf("  " + tabuleiroJogo[1][0] + "  |");
        System.out.printf("  " + tabuleiroJogo[1][1] + "  |");
        System.out.printf("  " + tabuleiroJogo[1][2] + "  ");
        System.out.println("\n-----+-----+-----");
        System.out.printf("  " + tabuleiroJogo[2][0] + "  |");
        System.out.printf("  " + tabuleiroJogo[2][1] + "  |");
        System.out.printf("  " + tabuleiroJogo[2][2] + "  ");
    }
}