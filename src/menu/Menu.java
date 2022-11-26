package menu;

import metodos.Jogo;
import texto.Tabuleiro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void menu() {
        Jogo jogo = new Jogo();
        Tabuleiro tab = new Tabuleiro();
        int quantPartidasDesejadas = 0;
        int opcao = 0;
        boolean continuar;
        System.out.println("\nIniciar jogo");
        do {
            continuar = false;
            System.out.println("1 - Novo jogo");
            System.out.println("2 - Melhor de três (com placar)");
            System.out.println("3 - Selecionar quantidade de partidas (com placar)");
            System.out.println("4 - Instruções de jogo");
            System.out.println("5 - Posições");
            System.out.println("6 - Sair");
            try {
                opcao = new Scanner(System.in).nextInt();
                if (opcao <= 0 || opcao > 6) {
                    System.out.println("Opção inválida. Escolha uma das opções.");
                    continuar = true;
                }
            } catch (InputMismatchException i) {
                System.out.println("Opção inválida. Escolha uma das opções.");
                continuar = true;
            }

        } while (continuar);
        switch (opcao) {
            case 1:
                //nova alteração para selecionar antes o número de partidas.
                do {
                    System.out.println("Quantas partidas o jogo terá? ");
                    try {
                        quantPartidasDesejadas = new Scanner(System.in).nextInt();
                        if (quantPartidasDesejadas <= 0) {
                            System.out.println("Quantidade incorreta. Insira um valor maior que 0");
                            menu();
                        }
                    } catch (InputMismatchException i) {
                        System.out.println("Quantidade incorreta. Insira um número maior que 0");
                    }
                } while (quantPartidasDesejadas <= 0);
                for (int i = 1; i <= quantPartidasDesejadas; i++) {
                    System.out.println("Iniciando novo jogo.");
                    jogo.jogo();
                }
                menu();
                break;
            case 2:
                System.out.println("Iniciando novo jogo de melhor de três");
                System.out.println("Esse modo de jogo consiste em 3 rodadas que defenirão um vencedor ou empate.\n" + "Caso um vença 2 vezes o jogo se encerrará.");
                jogo.melhorDeTres();
                break;
            case 3:
                jogo.quantidadePartidas();
                break;
            case 4:
                tab.montaTabulerioExemplo();
                break;
            case 5:
                tab.posicoes();
                break;
            case 6:
                System.out.println("Finalizando jogo.");
                System.exit(1);
                break;
        }
    }
}
