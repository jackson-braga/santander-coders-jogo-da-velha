public class JogoDaVelha {
    private String[][] tabuleiro = new String[3][3];
    private static int[][] pontos = new int[3][3];
    
    private static final String JOGADOR_VENCEU = "Jogador %d venceu!";
    private static final String EMPATE = "A rodada ficou empatada";
    
    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        /*
        jogo.carregarTabuleiro(pontos);
        jogo.iteracao();
        */
        do {
        	jogo.carregarTabuleiro(pontos);
            jogo.iteracao();
            
        } while(jogo.validaPontuacao(pontos));
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
                System.out.print(tabuleiro[i][j] + (j == 2 ? "\n" : "|"));
            }
        }
    }

    private static String getSimbol(int[][] pontos, int x, int y) {
    	return pontos[x][y] == 0 ? "_" : pontos[x][y] == 10 ? JogadorEnum.X.name() : JogadorEnum.O.name();
    }
    
    public boolean validaPontuacao(int[][] pontos) {
    	int soma = 0;
    	/*Valida soma das linhas*/
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3 ; j++) {
    			soma += pontos[i][j];
    			if(soma == 30 || soma == 300) {
    				System.out.printf("\n".concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
    				return false;
    			}
    		}
    	}
    	
    	soma = 0;
    	/*Valida soma das colunas*/
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3 ; j++) {
    			soma += pontos[j][i];
    			if(soma == 30 || soma == 300) {
    				System.out.printf("\n".concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
    				return false;
    			}
    		}
    	}
    	
    	soma = 0;
    	/*Valida soma da diagonal principal*/
    	for(int i = 0; i < 3; i++) {
    		soma += pontos[i][i];
			if(soma == 30 || soma == 300) {
				System.out.printf("\n".concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
				return false;
			}
    	}
    	
    	soma = 0;
    	/*Valida soma da diagonal secundária*/
    	for(int i = 0, j = 2; i < 3; i++, j--) {
    		soma += pontos[i][j];
			if(soma == 30 || soma == 300) {
				System.out.printf("\n".concat(JOGADOR_VENCEU), soma == 30 ? 1 : 2);
				return false;
			}
    	}
    	
    	if(pontos[0][0] > 0 && pontos[0][1] > 0 && pontos[0][2] > 0 &&
    		pontos[1][0] > 0 && pontos[1][1] > 0 && pontos[1][2] > 0 &&
    		pontos[2][0] > 0 && pontos[2][1] > 0 && pontos[2][2] > 0) {
    		System.out.println(EMPATE);
			return false;
    	}
    	
    	return true;
    }
    
    
    
    public void imprimirTabuleiro() {
        
    	
    	/*
    	for (int i = 0; i < tabuleiro.length; i++) {
            String impressao = "";
            for (int j = 0; j < tabuleiro[i].length; j++) {
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
        */
    }
    
    
}
