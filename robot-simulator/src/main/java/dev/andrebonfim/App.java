package dev.andrebonfim;

import dev.andrebonfim.code.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Mundo2D mundo = new Mundo2D(100, 100);
        RoboTransporte robo = setupRobo();
        Caixa caixa1 = new Caixa("Item1", 1, 70, 70, 5.0f, 2, 2, 2);
        executeRobotCommands(robo, mundo, caixa1);
    }

    private static RoboTransporte setupRobo() {
        // Configuração inicial do Robô
        return new RoboTransporte("R-ATM", 10.0f, 50, 50);
    }

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
                    robo.printPos(); // Supondo que esta função imprime a posição atual do robô
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Valor errado");
                scan.nextLine(); // Limpa o buffer do scanner para a próxima entrada
            }
        } while (!ok);
        scan.close();
    }

    private static void executeMovementSequence(RoboTransporte robo, Mundo2D mundo, Caixa caixa, char orientacao) {
        // Lógica de movimento e verificação de colisão
        robo.setOrientacao(orientacao);
        float newX = robo.getPosicaoX() + (orientacao == 'w' ? -4 : orientacao == 's' ? 4 : 0);
        float newY = robo.getPosicaoY() + (orientacao == 'a' ? -4 : orientacao == 'd' ? 4 : 0);
        if (newX >= 0 && newX <= mundo.getDimX() && newY >= 0 && newY <= mundo.getDimY()) {
            robo.move(newX, newY);
            checkCollision(robo, caixa);
        }
    }

    private static void checkCollision(RoboTransporte robo, Caixa caixa) {
        // Verifica colisão
        if (robo.getPosicaoX() == caixa.getPosX() && robo.getPosicaoY() == caixa.getPosY()) {
            System.out.println("Colisão com a caixa: " + caixa.getNomeItem());
        }
    }
}
