import java.util.Scanner;

public class JogoDaVelha {

    public static void main (String args []) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do primeiro jogador, que vai atuar com X : ");
        String jog1 = scan.next();
        System.out.println("Digite o nome do segundo jogador, que vai atuar com O : ");
        String jog2 = scan.next();
        System.out.println("Digite o número de partidas: ");
        int partidas = scan.nextInt();

        String [][] matrizJogo = new String [3][3];
        zerarTabela(matrizJogo);

        int pontosJog1 = 0; int  pontosJog2 = 0; int ponto; int complet; int p;
        for (p = 0; p < partidas-1; p++) {
            int contador=0;
            do {
                System.out.print("Digite a linha (1 a 3):");
                int linha = scan.nextInt();
                System.out.print("Digite a coluna (1 a 3):");
                int coluna = scan.nextInt();

                int jogador = (contador % 2 == 0) ?  1 : 2;
                imprimeTabela(jogador, matrizJogo,linha,coluna);

                ponto = Point(matrizJogo);
                if (ponto == 1) {
                    if (jogador == 1) {
                        pontosJog1++;
                        System.out.println(jog1 + " Venceu esta partida!");
                    } else pontosJog2++;
                    System.out.println(jog2 + " Venceu esta partida!");
                }

               complet = tabelaCompleta(matrizJogo);
                if (complet == 1) {
                    System.out.println("Tabela cheia");
                    zerarTabela(matrizJogo);
                }

                contador++;
            } while ((pontosJog1 == 0) && (pontosJog2 == 0));
        }
        if (p == partidas) {
            if (pontosJog1 == pontosJog2) {
                partidas++;
            } else if (pontosJog1 > pontosJog2) {
                System.out.println("O VENCEDOR é " + jog1);
            } else System.out.println("O VENCEDOR é " + jog2);
        }
        scan.close();
    }

    public static String [][] zerarTabela(String [][] matrizJogo) {
        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                matrizJogo [i][j] = " ";
                System.out.print("[" + matrizJogo[i][j] + "]");
            }
            System.out.println(" ");
        }
        return matrizJogo;
    }

    public static String[][] imprimeTabela(int jogador, String [][]matrizJogo, int linha, int coluna) {
        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                if ((linha-1) == i && (coluna-1) == j) {
                    if (jogador == 1) {
                        matrizJogo [i][j] = "X";
                    } else matrizJogo [i][j] = "O";
                }
                System.out.print("[" + matrizJogo[i][j] + "]");
            }
            System.out.println(" ");
        }
        return matrizJogo;
    }

    public static int Point (String [][]matrizJogo) {
        // conferir linhas e colunas
            int ponto=0;
        	for (int i = 0; i < 3; i++) {
                if (matrizJogo[i][0] != " ") {
                    if ((matrizJogo[i][0] == matrizJogo[i][1]) && (matrizJogo[i][1] == matrizJogo[i][2])) {
                        ponto = 1;
                    }
                }
                if (matrizJogo[0][i] != " ") {
                    if ((matrizJogo[0][i] == matrizJogo[1][i]) && (matrizJogo[1][i] == matrizJogo[2][i])) {
                        ponto = 1;
                    }
                }
        	}
         // conferir diagonais
            if (matrizJogo[1][1] != " ") {
                if ((matrizJogo[0][0] == matrizJogo[1][1]) && (matrizJogo[1][1] == matrizJogo[2][2])) {
                    ponto = 1;
                }
                if ((matrizJogo[0][2] == matrizJogo[1][1]) && (matrizJogo[1][1] == matrizJogo[2][0])) {
                    ponto = 1;
                }
            }
            return ponto;
    }

     public static int tabelaCompleta(String [][] matrizJogo) {
       int full = 1;
        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
               if (matrizJogo [i][j] == " ") {
                   full = 0;
                   }
            }
        }
        return full;
    }


}
