/* Universidade Estadual da Paraíba
*  Atividade de Laboratório nº03 - Prof.: Daniel Gondim
*  Aluno: Andécio Araujo
 */
package Lab3;
import java.util.Scanner;
public class JogoDaVelhaModularizado {
    public void startJogo() {
    //Inicializando as variáveis.
        char player = 'O';
        int linha, coluna, linhaMatriz, colunaMatriz;
        Scanner aux = new Scanner(System.in);
        Jogo j = new Jogo();
        j.inicializarJogo();
        System.out.println("Jogo iniciado!\n");
        j.exibirTabuleiro();
         while (true) {
            player = j.mudarPlayer(player);
            System.out.print("\nJogador " + player + ", defina a sua jogada (nº linha e nº coluna).\n");
            System.out.print("Informe o número correspondente a LINHA desejada: ");
            linhaMatriz = aux.nextInt();
            linha = linhaMatriz - 1;
            System.out.print("Informe o número correspondente a COLUNA desejada: ");
            colunaMatriz = aux.nextInt();
            coluna = colunaMatriz - 1;    
            while (j.verificarSlotValido(linhaMatriz, colunaMatriz)) {
                j.exibirTabuleiro();
                System.out.println("Você escolheu uma opção inválida, tente novamente (nº linha e nº coluna).\n");
                System.out.print("Informe o número correspondente a LINHA desejada: ");
                linhaMatriz = aux.nextInt();
                linha = linhaMatriz - 1;
                System.out.print("Informe o número correspondente a COLUNA desejada: ");
                colunaMatriz = aux.nextInt();
                coluna = colunaMatriz - 1;
            }
            while (j.verificarSlot(linha, coluna)) {
                j.exibirTabuleiro();
                System.out.println("Este espaço já está preenchido, tente novamente (nº linha e nº coluna).\n");
                System.out.print("Informe o número correspondente a LINHA desejada: ");
                linhaMatriz = aux.nextInt();
                linha = linhaMatriz - 1;
                System.out.print("Informe o número correspondente a COLUNA desejada: ");
                colunaMatriz = aux.nextInt();
                coluna = colunaMatriz - 1;
            }
            j.trocarLado(player, linha, coluna);
            j.exibirTabuleiro();
            if (j.verificarVencedor()) {
                System.out.println("\n- O vencedor é o jogador " + player + " !!");
                break;
            }
            if (j.verificarEmpate()) {
                System.out.println("\nEste jogo está empatado!");
                break;
            }
        }
        System.out.print("Gostaria de jogar novamente?\nSe sim, informe um número qualquer. Se não, informe '-1': ");
        Scanner entrada = new Scanner(System.in);
        int jogadorInput = entrada.nextInt();
        if (jogadorInput != -1) {
            System.out.println();
            startJogo();
        } else {
            System.out.print("Fim do Mundo (Nibiru)");
        }
}
    public static void main(String[] args) {
        JogoDaVelhaModularizado j = new JogoDaVelhaModularizado();
        j.startJogo();
    }
}