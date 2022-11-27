import java.util.NoSuchElementException;
import java.util.Scanner;

public class JogoDaVelhaMain {

    public static final int IDX_LINHA = 0;
    public static final int IDX_COLUNA = 1;
    public static final String INICIANDO_PARTIDA = "Iniciando a partida\n";
    public static final String ESCOLHER_CAMPO = " escolha um campo (linha,coluna)";
    public static final String FEM_DE_JOGO = "Fem de Jogo!!";
    public static final String PARTIDA_EMPATADA = "Deu Velha.... partida empatada!!!";
    public static final String ENTRADA_CAMPO_INVALIDO = "Entrada de campo invalida";
    public static final String JOGADOR_GANHOU = "O %s ganhou!!!";
    public static final String PATTERN_SCAN_CAMPO = "^(\\d,+\\d)$";
    public static final String PATTERN_SPLIT_CAMPO = ",";

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();

        imprimirMensagem(INICIANDO_PARTIDA);

        do {
            imprimirTabuleiro(jogo);
            imprimirMensagem(getMensagemEscolherCampo(jogo));

            String[] campos = getCampos();
            int linha = getValor(campos, IDX_LINHA);
            int coluna = getValor(campos, IDX_COLUNA);

            try {
                jogo.jogada(linha, coluna);
                verificarSituacaoJogo(jogo);
            } catch (CampoInvalidoException | CampoPreenchidoException e) {
                imprimirMensagem(e.getMessage());
            } catch (PartidaFinalizadaException e) {
                imprimirMensagem(e.getMessage());
                break;
            }
        } while (!jogo.isFinalizado());

        imprimirMensagem(FEM_DE_JOGO);
    }

    private static void verificarSituacaoJogo(JogoDaVelha jogo) {
        if(jogo.isFinalizado()) {
            imprimirTabuleiro(jogo);
            if(jogo.isEmpatado()) {
                imprimirMensagem(PARTIDA_EMPATADA);
            } else {
                imprimirMensagem(getMensagemJogadorGanhou(jogo));
            }
        }
    }

    private static String getMensagemEscolherCampo(JogoDaVelha jogo) {
        return jogo.getJogador().getDescricao() + ESCOLHER_CAMPO;
    }

    private static String getMensagemJogadorGanhou(JogoDaVelha jogo) {
        return String.format(JOGADOR_GANHOU, jogo.getJogador().getDescricao());
    }

    private static int getValor(String[] linhaColuna, int idx) {
        return Integer.parseInt(linhaColuna[idx]);
    }

    private static void imprimirTabuleiro(JogoDaVelha jogo) {
        imprimirMensagem(jogo.getTabuleiroImpresso());
    }

    private static String[] getCampos() {
        do {
            try {
                Scanner scan = new Scanner(System.in);
                String campo = scan.next(PATTERN_SCAN_CAMPO);
                return campo.split(PATTERN_SPLIT_CAMPO);
            } catch (NoSuchElementException | IllegalStateException e) {
                imprimirMensagem(ENTRADA_CAMPO_INVALIDO);
            }
        } while (true);
    }

    private static void imprimirMensagem(String mensagem) {
        System.out.println(mensagem + "\n");
    }
}