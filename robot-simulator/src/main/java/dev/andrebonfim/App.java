/**
 * Representa a aplicação principal que inicializa o mundo e o robô de transporte.
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author andrebonfim
 */
package dev.andrebonfim;

import dev.andrebonfim.code.*;
import java.util.Scanner;

public class App {
    /**
     * Método principal que configura e executa comandos do robô dentro de um
     * ambiente 2D.
     * 
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Mundo2D mundo = new Mundo2D(100, 100);
        RoboTransporte robo = setupRobo();
        Caixa caixa1 = new Caixa("Item1", 1, 70, 70, 5.0f, 2, 2, 2);
        executeRobotCommands(robo, mundo, caixa1);
    }

    /**
     * Configura o robô com características iniciais.
     * 
     * @return Uma nova instância de RoboTransporte configurada.
     */
    private static RoboTransporte setupRobo() {
        return new RoboTransporte("R-ATM", 10.0f, 50, 50);
    }

    /**
     * Executa uma série de comandos de entrada do usuário para movimentar o robô.
     * Processa comandos até que o usuário decida terminar a execução.
     * 
     * @param robo  O robô a ser comandado.
     * @param mundo O ambiente onde o robô opera.
     * @param caixa A caixa no mundo para interagir.
     */
    private static void executeRobotCommands(RoboTransporte robo, Mundo2D mundo, Caixa caixa) {
        Scanner scan = new Scanner(System.in);
        String tecla;
        boolean ok = false;
        do {
            try {
                tecla = scan.next();
                char orientacao = tecla.charAt(0);
                if (orientacao == '0') {
                    ok = true;
                } else {
                    executeMovementSequence(robo, mundo, caixa, orientacao);
                    robo.printPos(); // Supõe-se que esta função imprime a posição atual do robô
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Valor errado");
                scan.nextLine(); // Limpa o buffer do scanner para a próxima entrada
            }
        } while (!ok);
        scan.close();
    }

    /**
     * Executa a sequência de movimento do robô baseada na orientação fornecida.
     * 
     * @param robo       O robô que será movido.
     * @param mundo      O ambiente onde o robô se movimenta.
     * @param caixa      A caixa com a qual o robô pode colidir.
     * @param orientacao A direção do movimento ('w', 'a', 's', 'd').
     */
    private static void executeMovementSequence(RoboTransporte robo, Mundo2D mundo, Caixa caixa, char orientacao) {
        robo.setOrientacao(orientacao);
        float newX = robo.getPosicaoX() + (orientacao == 'w' ? -4 : orientacao == 's' ? 4 : 0);
        float newY = robo.getPosicaoY() + (orientacao == 'a' ? -4 : orientacao == 'd' ? 4 : 0);
        if (newX >= 0 && newX <= mundo.getDimX() && newY >= 0 && newY <= mundo.getDimY()) {
            robo.move(newX, newY);
            checkCollision(robo, caixa);
        }
    }

    /**
     * Verifica se ocorre uma colisão entre o robô e a caixa.
     * 
     * @param robo  O robô que pode colidir com a caixa.
     * @param caixa A caixa que pode ser colidida pelo robô.
     */
    private static void checkCollision(RoboTransporte robo, Caixa caixa) {
        if (robo.getPosicaoX() == caixa.getPosX() && robo.getPosicaoY() == caixa.getPosY()) {
            System.out.println("Colisão com a caixa: " + caixa.getNomeItem());
        }
    }
}
