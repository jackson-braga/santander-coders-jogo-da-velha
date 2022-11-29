package projeto;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Jogo da Velha
No jogo da velha, participam duas pessoas, que jogam alternadamente, preenchendo cada um
dois espaços vazios. Cada participante poderá usar um símbolo (X ou O). Vence o jogador que
conseguir formar primeiro uma linha com três símbolos iguais, seja ela na horizontal, vertical ou
diagonal.
Desenvolva um jogo da velha que permite informar quantas partidas serão jogadas para definir
um ganhador.ok
Ao iniciar o jogo, o número de partidas deve ser informado, o número de partidas deve ser
maior ou igual a 1. O jogador que ganhar o maior número de partidas é o ganhador do jogo. Se
no final de todas as partidas o número de partidas ganha de cada jogador for igual, a aplicação
deve iniciar uma nova partida para finalizar o jogo somente quando um dos jogadores ganhar a
partida que desempatar o placar. // aplicação tem que repetir até ter um ganhador
Regras básicas do Jogo da Velha
O tabuleiro é uma matriz de três linhas por três colunas. OK2
● Antes de iniciar o jogo, a aplicação solicita quantas partidas vai ter.
● O jogador 1 terá a marcação X e o jogador 2 terá a marcação O. OK
● Os jogadores jogam alternadamente, uma marcação por vez, em um espaço do
tabuleiro que esteja vazia. OK
● A cada jogada é verificado se o jogador da rodada conseguiu marcar a linha. ok
● Caso o jogador forme a linha, a aplicação imprime a mensagem “O Jogador 1 (ou 2)
venceu a rodada!” ok
● Caso o jogador não forme a linha, a aplicação imprime o tabuleiro e passa a vez para o
próximo jogador ok
● Caso todos os espaços em branco forem preenchidos e nenhum jogador formar uma
linha, imprimir “A rodada ficou empatada”. ok
A validação da linha formada pode ser feita
● Verificar se todas as colunas de cada linha possui o mesmo marcador ok
● Verificar se todas as linhas de cada coluna possui o mesmo marcador ok
● Verificar se cada diagonal tem os mesmo marcadores (Diagonal 1 posições ok
1x1,2x2,3x3, diagonal dois 1x3,2x2,3x1) ok
As ações inválidas que o jogador (1 ou 2) cometer, deve ser tratado com o uso de Exceptions.
Por exemplo, quando um jogador escolher um campo do tabuleiro já preenchido ou um campo
inexistente, a aplicação deve disparar uma exceção informando a movimentação errada
solicitado que o movimento seja feito novamente.
* */
public class jogoDaVelha {

    public static void main(String[] args) {


        // Declaração das variáveis utilizadas
        int numeroJogada = 0, contadorJogadas = 0, qtPartidas = 0, linha, coluna, vitoriaJogador1 = 0, vitoriaJogador2 = 0;
        char primeiro = 'X', segundo = 'O';

        // Escolher a quantidade de partidas
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Escolha o número de partidas: ");
            qtPartidas = getNumero();

            if (qtPartidas <= 0) {
                System.out.println("Digite um número maior que Zero!");
            }

        } while (qtPartidas <= 0);

        do {

            // Criação um array de char 3x3
            // Após umma partida o tabuleiro é reinicializado
            int numero = 0;
            char[][] tabuleiro = new char[3][3];
            for (linha = 0; linha < 3; linha++) {
                for (coluna = 0; coluna < 3; coluna++) {
                    numero += 1; // repetição de inteiro
                    tabuleiro[linha][coluna] = Character.forDigit(numero, 10); // popular conversão para char
                }
            }
            // Laço de repetição que controla a quantidade de jogadas
            while (contadorJogadas < 9) {

                // verificação das jogadas com persnalização de jogador
                if (contadorJogadas % 2 == 0) {
                    System.out.println("Jogador 'X', escolha o número da sua jogada: ");
                } else {
                    System.out.println("Jogador 'O', escolha o número da sua jogada: ");
                }
                // Laço de repetição para exibir o tabuleiro
                for (linha = 0; linha < 3; linha++) {
                    for (coluna = 0; coluna < 3; coluna++) {
                        System.out.print(tabuleiro[linha][coluna] + (coluna == 2 ? "\t" : " | "));
                    }
                    System.out.println();
                }
                // Entrada de dados do número da jogada
                numeroJogada = getNumero();

                // Switch Case para receber a opção escolhida e atribuir o X ou a O para o tabuleiro
                switch (numeroJogada) {

                    case 1:
                        if (tabuleiro[0][0] == '1') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[0][0] = primeiro;
                            } else {
                                tabuleiro[0][0] = segundo;
                            }
                        } else {

                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 2:
                        if (tabuleiro[0][1] == '2') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[0][1] = primeiro;
                            } else {
                                tabuleiro[0][1] = segundo;
                            }
                        } else {

                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 3:
                        if (tabuleiro[0][2] == '3') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[0][2] = primeiro;
                            } else {
                                tabuleiro[0][2] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 4:
                        if (tabuleiro[1][0] == '4') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[1][0] = primeiro;
                            } else {
                                tabuleiro[1][0] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 5:
                        if (tabuleiro[1][1] == '5') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[1][1] = primeiro;
                            } else {
                                tabuleiro[1][1] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 6:
                        if (tabuleiro[1][2] == '6') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[1][2] = primeiro;
                            } else {
                                tabuleiro[1][2] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 7:
                        if (tabuleiro[2][0] == '7') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[2][0] = primeiro;
                            } else {
                                tabuleiro[2][0] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 8:
                        if (tabuleiro[2][1] == '8') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[2][1] = primeiro;
                            } else {
                                tabuleiro[2][1] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    case 9:
                        if (tabuleiro[2][2] == '9') {
                            if (contadorJogadas % 2 == 0) {
                                tabuleiro[2][2] = primeiro;
                            } else {
                                tabuleiro[2][2] = segundo;
                            }
                        } else {
                            System.out.println("Jogada já realizada! Escolha outro número.");
                            contadorJogadas--;
                        }
                        break;
                    default:
                        System.out.println("Jogada Inválida! Digite um número de 1 à 9!");
                        contadorJogadas--;
                }

                contadorJogadas++;

                // Verificação de quem foi o ganhador
                if (contadorJogadas >= 5) {

                    if (tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    } else if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X') {
                        System.out.println("O Jogador 1 venceu a rodada!");
                        vitoriaJogador1++;
                        break;
                    }
                    if (tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else if (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O') {
                        System.out.println("O Jogador 2 venceu a rodada!");
                        vitoriaJogador2++;
                        break;
                    } else {
                        if (contadorJogadas == 9) {
                            System.out.println("A rodada ficou empatada!");
                        } else {
                            continue;
                        }
                    }

                }
            }

            //Exibir o tabuleiro após a finalização
            for (linha = 0; linha < 3; linha++) {
                for (coluna = 0; coluna < 3; coluna++) {
                    System.out.print(tabuleiro[linha][coluna] + (coluna == 2 ? "\t" : " | "));
                }
                System.out.println();
            }

            // Para ir subtraindo as quantidades de partidas já executadas
            qtPartidas--;

            //Exibição do placar ao final de cada partida
            System.out.println("\nPlacar: ");
            System.out.printf("Jogador 1 = %d\n", vitoriaJogador1);
            System.out.printf("Jogador 2 = %d\n\n", vitoriaJogador2);

            //Laço de reptição para caso o jogo fique empatado
            if (qtPartidas == 0 && vitoriaJogador1 == vitoriaJogador2) {

                System.out.println("Jogo empatado! Vamos mais uma rodada para decisão final...");
                qtPartidas++;
            }

            // Reinicialização da Jogada (Preparando para nova partida)
            contadorJogadas = 0;


        } while (qtPartidas > 0);

}

    private static int getNumero() {
        int valor;
        try {
            Scanner entrada = new Scanner(System.in);
            valor = entrada.nextInt();
            return valor;
        } catch (InputMismatchException e) {
            System.out.print("Erro! Digitou caractere inválido. Tente Novamente: ");
            return getNumero();
        }
    }
}

