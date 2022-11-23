import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linha = 0, coluna = 0, cont = 0;
        boolean game = true;
        String simboloX = "X", simboloO = "O";
        int vezesJogadas = 0;
        String[][] matriz = new String[3][3];

        preencherJogo(matriz);

        //Jogo
        while (game == true) {
            // Primeiro jogador
            System.out.println("1° Jogador");
            System.out.println("Informe a linha");
            linha = valorValido(scanner);
            System.out.println("Informe a coluna");
            coluna = valorValido(scanner);
            verificarJogada(matriz, linha, coluna, simboloX);
            game = verificarLinhas(matriz, simboloX);
            if (game == false){
                System.out.println("JOGADOR 1 VENCEU O JOGO");
                break;
            }
            game = verificarColunas(matriz, simboloX);
            if (game == false){
                System.out.println("JOGADOR 1 VENCEU O JOGO");
                break;
            }
            game = verificarDiagonais(matriz, simboloX);
            if (game == false){
                System.out.println("JOGADOR 1 VENCEU O JOGO");
                break;
            }

            vezesJogadas++;
            if (vezesJogadas == 5) {
                System.out.println("Empate infelizmente ;(");
                break;
            }

            desenhaJogo(matriz);

            // Segundo jogador
            System.out.println("2° Jogador");
            System.out.println("Informe a linha");
            linha = valorValido(scanner);
            System.out.println("Informe a coluna");
            coluna = valorValido(scanner);
            verificarJogada(matriz, linha, coluna, simboloO);
            game = verificarLinhas(matriz, simboloO);
            if (game == false){
                System.out.println("JOGADOR 2 VENCEU O JOGO");
                break;
            }
            game = verificarColunas(matriz, simboloO);
            if (game == false){
                System.out.println("JOGADOR 2 VENCEU O JOGO");
                break;
            }
            game = verificarDiagonais(matriz, simboloO);
            if (game == false){
                System.out.println("JOGADOR 2 VENCEU O JOGO");
                break;
            }
            desenhaJogo(matriz);
        }
    }

    public static void preencherJogo(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = " ";
            }
        }
    }

//    public static void limparTela() {
//        for (int cont = 0; cont < 20; cont++) {
//            System.out.println("");
//        }
//    }

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
        while (x <= 0 || x >= 4) {
            System.out.println("Digite 1, 2 OU 3");
            x = scan.nextInt();
        }
        return x;
    }

    public static boolean verificarLinhas(String matriz[][], String simbolo) {
        if ((matriz[0][0].equals(simbolo) && matriz[0][1].equals(simbolo) && matriz[0][2].equals(simbolo)) ||
                (matriz[1][0].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[1][2].equals(simbolo)) ||
                (matriz[2][0].equals(simbolo) && matriz[2][1].equals(simbolo) && matriz[2][2].equals(simbolo))){
            return false;
        } else {
            return true;
        }
    }

    public static boolean verificarColunas(String matriz[][], String simbolo) {
        if ((matriz[0][0].equals(simbolo) && matriz[1][0].equals(simbolo) && matriz[2][0].equals(simbolo)) ||
                (matriz[0][1].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[2][1].equals(simbolo)) ||
                (matriz[0][2].equals(simbolo) && matriz[1][2].equals(simbolo) && matriz[2][2].equals(simbolo))){
            return false;
        } else {
            return true;
        }
    }

    public static boolean verificarDiagonais(String matriz[][], String simbolo) {
        if ((matriz[0][0].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[2][2].equals(simbolo)) ||
                (matriz[0][2].equals(simbolo) && matriz[1][1].equals(simbolo) && matriz[2][0].equals(simbolo))){
            return false;
        } else {
            return true;
        }
    }

}