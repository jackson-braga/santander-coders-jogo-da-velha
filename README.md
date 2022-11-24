# santander-coders-jogo-da-velha

#Jogo da Velha
<p>No jogo da velha, participam duas pessoas, que jogam alternadamente, preenchendo cada um dos espaços vazios. Cada
participante poderá usar um símbolo (X ou O). Vence o jogador que conseguir formar primeiro uma linha com três símbolos iguais,
seja ela na horizontal, vertical ou diagonal.</p>
<p>Desenvolva o jogo da velha que ao iniciar imprima um tabuleiro e solicite a jogada do Jogador 1, imprima o tabuleiro com a
marcação da jogada e solicite que o Jogador 2 faça sua jogada. A cada jogada o tabuleiro deve ser imprimido para que os jogadores
verifiquem como está o jogo.</p>
<p>Regras básicas do Jogo da Velha</p>
<p>● O tabuleiro é uma matriz de três linhas por três colunas (3 x 3).<p>
<p>● O jogador 1 terá a marcação X e o jogador 2 terá a marcação O.
<p>● Os jogadores jogam alternadamente, uma marcação por vez, em um espaço do tabuleiro que esteja vazia.
<p>● A cada jogada é verificado se o jogador da rodada conseguiu marcar a linha.
<p>● Caso o jogador forme a linha, a aplicação imprime a mensagem “O Jogador 1 (ou 2) venceu a rodada!”
<p>● Caso o jogador não forme a linha, a aplicação imprime o tabuleiro e passa a vez para o próximo jogador
<p>● Caso todos os espaços em branco forem preenchidos e nenhum jogador formar uma linha, imprimir “A rodada ficou
empatada”.
<p>A validação da linha formada pode ser feita
<p>● Verificar se todas as colunas de cada linha possui o mesmo marcador
<p>● Verificar se todas as linhas de cada coluna possui o mesmo marcador
<p>● Verificar se cada diagonal tem os mesmo marcadores (Diagonal 1 posições 1x1,2x2,3x3, diagonal dois 1x3,2x2,3x1)
<p>As ações inválidas que o jogador (1 ou 2) cometer, deve ser tratado com o uso de Exceptions. Por exemplo, quando um jogador
escolher um campo do tabuleiro já preenchido ou um campo inexistente, a aplicação deve disparar uma exceção informando a
movimentação errada solicitado que o movimento seja feito novamente

<p>Foram implementados outras funcionalidades para meta de estudo. </p>
