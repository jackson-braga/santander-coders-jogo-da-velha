**Jogo da Velha – Checklist** 

**Escopo Reduzido**

Feito:
- Imprimir o tabuleiro ao iniciar
- A cada jogada imprimir o tabuleiro com a marcação
- Verificar se alguém ganhou e imprimir mensagem

Fazer ou Revisar:
- Se todos os espaços forem preenchidos, imprimir “A rodada ficou empatada”
> Gabriel: Ainda não pensei nisso... Da maneira como está se o jogador preenche o tabuleiro o jogo volta pedir uma nova jogada, mas também não aceita nenhuma nova jogada porque no tratamento de erro ele impede uma marcação num campo já preenchido

Tratamento de erros:
- Campo inexistente (IndexOutOfBounds)
- Campo já preenchido

> Gabriel: Fiz uma função chamada verificaJogada. Nela há um try e catch verificando se o jogador digitou algum valor fora da matriz. Dentro do try com um if-else se o campo já foi preenchido

**Final**

Feito:
- Ver Escopo Reduzido
- Informar e rodar número de partidas

Fazer ou Revisar:
- Partida de desempate

> PDF: *“Se no final de todas as partidas o número de partidas ganha de cada jogador for igual, a aplicação deve iniciar uma nova partida para finalizar o jogo”.*

Tratamento de erros:
> Gabriel: Não verifiquei se o número de partidas é maior ou igual a 1
