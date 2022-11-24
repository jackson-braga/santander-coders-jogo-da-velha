public class JogoDaVelha {
    private String[][] tabuleiro = new String[4][3];

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.carregarTabuleiro();
        jogo.imprimirTabuleiro();
    }

    public void carregarTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 1; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = i + " - " + j + " | ";
            }
        }
    }

    public void iteracao(){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.println(tabuleiro[j][i]);
            }
        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            String impressao = "";
            for (int j = 0; j < tabuleiro[i].length; j++) {
//                System.out.println(tabuleiro.length + " vs " + tabuleiro[i].length);
//                tabuleiro[i][j];
                if(tabuleiro[i][j] == null) {
                    impressao = impressao + "      |";
                    impressao += "      |";
                } else {
                    impressao += tabuleiro[i][j];
                }
            }
            System.out.println(impressao);
            System.out.println("------+-------------");
        }
    }
}
