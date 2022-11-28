import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        // Importando o Util Scanner
        Scanner scan = new Scanner(System.in);

        // Entrada de Dados
        System.out.println("Digite o nome do primeiro jogador, que vai atuar com X : ");
        String jog1 = scan.next();
        System.out.println("Digite o nome do segundo jogador, que vai atuar com O : ");
        String jog2 = scan.next();
        int partidas = 0;
        boolean continua = true;

        do {
            try {
                System.out.println("Digite o número de partidas: ");
                partidas = scan.nextInt();
                if (partidas == 0) {
                    IllegalArgumentException erro = new IllegalArgumentException();
                    throw erro;
                }
                continua = false;
            } catch (InputMismatchException erro) {
                System.err.println("O valor deve ser um número.");
                scan.nextLine();
            } catch (IllegalArgumentException erro) {
                System.err.println("O valor deve ser maior que 0.");
                scan.nextLine();
            }
        } while (continua);

        // %s uma variável para receber depois
        // Montagem do Tabuleiro
        String[][] matrizJogo = new String[3][3];
        zerarTabela(matrizJogo);

        int pontosJog1 = 0;
        int pontosJog2 = 0;
        int ponto;
        int complet;
        int p;
        int unidadeOcupada = 0;
        int contador=0;int vitoriasJog1 = 0; int vitoriasJog2 = 0;
        // Controles da Partida
        for (p = 0; p <= partidas; p++) {

            do {
                int linha = 0;
                int coluna = 0;
                boolean voltar = true;
                boolean unid;

                do {
                    try {
                        System.out.print("Digite a linha ( 1 a 3 ):");
                        linha = scan.nextInt();
                        System.out.print("Digite a coluna ( 1 a 3 ):");
                        coluna = scan.nextInt();
                        unid = UnidadeMatriz(matrizJogo,(linha-1),( coluna -1));

                        if (unid) {
                            IllegalArgumentException erro = new IllegalArgumentException();
                            throw erro;
                        }
                        if ((linha > 3) || (linha < 1) || (coluna > 3) || (coluna < 1)) {
                            ArrayIndexOutOfBoundsException erro = new ArrayIndexOutOfBoundsException();
                            throw erro;
                        }
                        voltar = false;
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.err.println("Erro - o valor deve ser entre 1 e 3. Digite novamente");
                        scan.nextLine();
                    } catch (InputMismatchException erro) {
                        System.err.println("Erro - O valor deve ser um número. Digite novamente");
                        scan.nextLine();
                    } catch (IllegalArgumentException erro) {
                        System.err.println("Erro - o campo não pode estar ocupado. Digite");
                        scan.nextLine();
                    }
                } while (voltar);

                int jogador = (contador % 2 == 0) ?  1 : 2;
                imprimeTabela(jogador, matrizJogo,linha,coluna);

                ponto = Point(matrizJogo);
                if (ponto == 1) {
                    if (jogador == 1) {
                        pontosJog1++; vitoriasJog1 += pontosJog1;
                        System.out.println(jog1 + " Venceu esta partida!");
                    } else {
                        pontosJog2++; vitoriasJog2 += pontosJog2;
                        System.out.println(jog2 + " Venceu esta partida!");
                    }
                    zerarTabela(matrizJogo);
                }

                complet = tabelaCompleta(matrizJogo);
                if (complet == 1) {
                    System.out.println("Tabela cheia");
                    zerarTabela(matrizJogo); ponto = 0;
                }
                contador++;

            } while ((pontosJog1 == 0) && (pontosJog2 == 0));
            pontosJog1 = 0; pontosJog2 = 0;

            if (p == partidas-1) {
                if (vitoriasJog1 == vitoriasJog2) {
                    partidas++;
                } else if (vitoriasJog1 > vitoriasJog2) {
                    System.out.println("O VENCEDOR é " + jog1);
                    break;
                } else {
                    System.out.println("O VENCEDOR é " + jog2);
                    break;
                }
            }
        }

        scan.close();
    }

    public static String[][] zerarTabela(String[][] matrizJogo) {
        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                matrizJogo [i][j] = " ";
                System.out.print("[" + matrizJogo[i][j] + "]");
            }
            System.out.println(" ");
        }
        return matrizJogo;
    }

    public static String[][] imprimeTabela(int jogador, String[][] matrizJogo, int linha, int coluna) {
        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                if ((linha-1) == i && (coluna-1) == j) {
                    if (jogador == 1) {
                        matrizJogo [i][j] = "X";
                    } else {
                        matrizJogo [i][j] = "O";
                    }
                }
                System.out.print("[" + matrizJogo[i][j] + "]");
            }
            System.out.println(" ");
        }
        return matrizJogo;
    }

    public static int Point (String [][]matrizJogo) {
        // Conferir Linhas e Colunas
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
        // Conferir Diagonais
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

    private static boolean UnidadeMatriz(String matrizJogo[][], int linha, int coluna) {
               if (matrizJogo[linha][coluna].equals(" ")) {
                    return false;
                }
                else return true;
    }

}
