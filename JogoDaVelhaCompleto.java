import java.util.Scanner;

public class JogoDaVelhaCompleto {
    public static void main(String[] args) throws MenuInvalidoException {
        Scanner scanner = new Scanner(System.in);
        int linha = 0, coluna = 0, cont = 0;
        boolean game = true;
        String simboloX = "X", simboloO = "O";
        int jogador1 = 0, jogador2 = 0;
        int rodadas = 0;
        boolean validacao = true;
        int partidas = 0;
        String[][] matriz = new String[3][3];
        do {
            try {
                System.out.println("Quantas partidas serão jogadas?");
                partidas = scanner.nextInt();
                if (partidas == 0) {
                    IllegalArgumentException trava = new IllegalArgumentException();
                    throw trava;
                }
                validacao = false;
            } catch (IllegalArgumentException trava) {
                System.err.println("O número de partidas deve ser maior que 0.");
                scanner.nextLine();
            }

        } while (validacao);


        preencherJogo(matriz);
        while (partidas > 0) {

            //Jogo
            do {
                // Primeiro jogador
                try {
                    System.out.println("1° Jogador");
                    System.out.println("Informe a linha");
                    linha = valorValido(scanner);
                    System.out.println("Informe a coluna");
                    coluna = valorValido(scanner);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                verificarJogada(matriz, linha, coluna, simboloX);
                game = verificandoSeOk(matriz, simboloX);
                if (!game) {
                    desenhaJogo(matriz);
                    System.out.println("JOGADOR 1 GANHOU!!");
                    jogador1++;
                    preencherJogo(matriz);
                    partidas--;
                    System.out.println("Jogador 1: " + jogador1);
                    System.out.println("Jogador 2: " + jogador2);
                    rodadas = 0;
                    break;
                }

                rodadas++;
                if (rodadas == 5) {
                    desenhaJogo(matriz);
                    System.out.println("Jogada Empatou!! Joguem novamente:");
                    preencherJogo(matriz);
                    System.out.println("Jogador 1: " + jogador1);
                    System.out.println("Jogador 2: " + jogador2);
                    rodadas = 0;
                    break;

                }
                desenhaJogo(matriz);
                // Segundo jogador
                try {
                    System.out.println("2° Jogador");
                    System.out.println("Informe a linha");
                    linha = valorValido(scanner);
                    System.out.println("Informe a coluna");
                    coluna = valorValido(scanner);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                verificarJogada(matriz, linha, coluna, simboloO);
                game = verificandoSeOk(matriz, simboloO);
                if (!game) {
                    desenhaJogo(matriz);
                    System.out.println("JOGADOR 2 GANHOU!!");
                    jogador2++;
                    preencherJogo(matriz);
                    partidas--;
                    System.out.println("Jogador 1: " + jogador1);
                    System.out.println("Jogador 2: " + jogador2);
                    rodadas = 0;
                    break;
                }
                desenhaJogo(matriz);
            } while (game);

            if (partidas == 0 && jogador1 == jogador2) {
                partidas = +1;
            } else if (jogador1 > jogador2 && partidas == 0) {
                System.out.println("PARABÉNS JOGADOR 1!!");
            } else if (jogador2 > jogador1 && partidas == 0) {
                System.out.println("PARABÉNS JOGADOR 2!!");
            }


        }
    }


    public static void preencherJogo(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = " ";
            }
        }
    }

    public static void desenhaJogo(String matriz[][]) {
        //    limparTela();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
                if (j == 0 || j == 1) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
    }

    public static void verificarJogada(String matriz[][], int linha, int coluna, String simbolo) {
        Scanner scanner = new Scanner(System.in);
        int cont = 0;
        if (matriz[linha - 1][coluna - 1].equals(" ")) {
            matriz[linha - 1][coluna - 1] = simbolo;
        } else {
            while (!matriz[linha - 1][coluna - 1].equals(" ")) {
                System.out.println("Informe novamente a linha");
                linha = scanner.nextInt();
                System.out.println("Informe novamente a coluna");
                coluna = scanner.nextInt();
            }
            matriz[linha - 1][coluna - 1] = simbolo;
        }
    }

    public static int valorValido(Scanner scan) {
        int x = 0;
        x = scan.nextInt();
        if (x <= 0 || x >= 4) {
            throw new RuntimeException("Digite 1, 2 OU 3");
        }
        return x;
    }

    public static boolean verificarLinhas(String matriz[][], String simbolo) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0].equals(simbolo) && matriz[i][1].equals(simbolo) && matriz[i][2].equals(simbolo)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarColunas(String matriz[][], String simbolo) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[0][i].equals(simbolo) && matriz[1][i].equals(simbolo) && matriz[2][i].equals(simbolo)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarDiagonais(String matriz[][], String simbolo) {
        if ((matriz[0][0].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[2][2].equals(simbolo)) || (matriz[0][2].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[2][0].equals(simbolo))) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean verificandoSeOk(String matriz[][], String simbolo) {
        if (!verificarLinhas(matriz, simbolo) || !verificarColunas(matriz, simbolo) || !verificarDiagonais(matriz, simbolo)) {
            return false;
        } else {
            return true;
        }
    }


    private static class MenuInvalidoException extends Exception {
    }
}