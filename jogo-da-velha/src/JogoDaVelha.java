import java.util.Scanner;

public class JogoDaVelha {
    private String[][] tabuleiro = new String[3][3];
    private static int[][] pontos = new int[3][3];
    private static final String PULA_LINHA = "\n";
    private static final String PIPE = "|";
    private static final String JOGADOR_VENCEU = "Jogador %d venceu!";
    private static final String EMPATE = "A rodada ficou empatada";
    private static final String INICIA = "Jogador %d";
    private static final String LINHA = "Insira o valor da linha (0 a 2): ";
    private static final String COLUNA = "Insira o valor da coluna (0 a 2): ";
    private static final String INVALIDO = "Valor inválido, tente novamente.";
    private static final String EXISTED = "Posição já possui valor, tente novamente.";
    public static boolean continua = true;
   
    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
       
        jogo.carregarTabuleiro(pontos);
        jogo.iteracao();
       
        do {
        	pontos = getPontos(pontos, jogo);
        } while(continua);
    }

    public void carregarTabuleiro(int[][] pontos) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = "_" + getSimbol(pontos, i, j) + "_";
            }
        }
    }

    public void iteracao(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + (j == 2 ? PULA_LINHA : PIPE));
            }
        }
    }

    private static String getSimbol(int[][] pontos, int x, int y) {
    	return pontos[x][y] == 0 ? "_" : pontos[x][y] == 10 ? 
    			JogadorEnum.X.name() : JogadorEnum.O.name();
    }
   
    public boolean validaPontuacao(int[][] pontos) {
	    int soma = 0;
	    /*Valida soma das linhas*/
	    for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3 ; j++) {
			    soma += pontos[i][j];
			    if(soma == 30 || soma == 300) {
				    System.out.printf(PULA_LINHA.concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
				    return false;
			    }
		    }
		    soma = 0;
	    }
	   
	    soma = 0;
	    /*Valida soma das colunas*/
	    for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3 ; j++) {
			    soma += pontos[j][i];
			    if(soma == 30 || soma == 300) {
				    System.out.printf(PULA_LINHA.concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
				    return false;
				}
		    }
		    soma = 0;
		}
   
	    soma = 0;
	    /*Valida soma da diagonal principal*/
	    for(int i = 0; i < 3; i++) {
		    soma += pontos[i][i];
			if(soma == 30 || soma == 300) {
				System.out.printf(PULA_LINHA.concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
				return false;
			}
			soma = 0;
	    }
	   
	    soma = 0;
	    /*Valida soma da diagonal secundária*/
	    for(int i = 0, j = 2; i < 3; i++, j--) {
		    soma += pontos[i][j];
			if(soma == 30 || soma == 300) {
				System.out.printf(PULA_LINHA.concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
				return false;
			}
			soma = 0;
	    }
	   
	    if(pontos[0][0] > 0 && pontos[0][1] > 0 && pontos[0][2] > 0 &&
		    pontos[1][0] > 0 && pontos[1][1] > 0 && pontos[1][2] > 0 &&
		    pontos[2][0] > 0 && pontos[2][1] > 0 && pontos[2][2] > 0) {
		    System.out.println(EMPATE);
		    return false;
	    }
	   
	    return true;
    }
   
    private static int[][] getPontos(int[][] pontos, JogoDaVelha jogo) {
	    Scanner entrada = new Scanner(System.in);
	    for(int i = 0; i < 2; i++) {
		    System.out.printf(PULA_LINHA.concat(INICIA), i+1);
		    pontos = getPonto(pontos, i, entrada);
		    jogo.carregarTabuleiro(pontos);
		    jogo.iteracao();
		    continua = jogo.validaPontuacao(pontos);
		    if(!continua) break;
	    }
	    return pontos;
	}
	   
    private static int getValor(Scanner entrada, String text) {
	    try {
	    	System.out.print(PULA_LINHA.concat(text));
	    	int valor = entrada.nextInt();
	    	if(valor < 0 || valor > 2) {
	    		throw new Exception(INVALIDO);
	    	}
		    return valor;
	    } catch(Exception e) {
		    System.out.println(e.getMessage());
		    return getValor(new Scanner(System.in), text);
	    }
    }
    
    private static int[][] getPonto(int[][] pontos, int i, Scanner entrada) {
    	int linha = getValor(entrada, LINHA);
	    int coluna = getValor(entrada, COLUNA);
	    try {
	    	for(int l = 0; l < 3; l++) {
		    	for(int c = 0; c < 3; c++) {
		    		if(l == linha && c == coluna && pontos[l][c] > 0) {
		    			throw new Exception(EXISTED);
		    		}
		    	}
		    }
	    	pontos[linha][coluna] = i == 0 ? JogadorEnum.X.getValor() : JogadorEnum.O.getValor();
	    	return pontos;
	    } catch(Exception e) {
	    	System.out.println(e.getMessage());
	    	return getPonto(pontos, i, new Scanner(System.in));
	    }
    }
}