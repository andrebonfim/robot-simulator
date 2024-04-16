package dev.andrebonfim;

import dev.andrebonfim.code.*;

public class App {
    public static void main(String[] args) {
        Mundo2D mundo = new Mundo2D(100, 100);
        RoboTransporte robo = setupRobo();
        Caixa caixa1 = new Caixa("Item1", 1, 70, 70, 5.0f, 2, 2, 2);

        executeMovementSequence(robo, mundo, caixa1);
    }

    private static RoboTransporte setupRobo() {
        // Configuração inicial do Robô
        return new RoboTransporte("R-ATM", 10.0f, 50, 50);
    }

    private static void executeMovementSequence(RoboTransporte robo, Mundo2D mundo, Caixa caixa) {
        // Lógica de movimento e verificação de colisão
        for (int i = 0; i < 4; i++) {
            robo.setOrientacao((char) ('w' + i));
            for (int j = 0; j <= 10; j++) {
                float newX = robo.getPosicaoX() + (i % 2 == 0 ? j * 4 : 0);
                float newY = robo.getPosicaoY() + (i % 2 != 0 ? j * 4 : 0);
                if (newX >= 0 && newX <= mundo.getDimX() && newY >= 0 && newY <= mundo.getDimY()) {
                    robo.move(newX, newY);
                    System.out.println(robo); // Imprime o status após cada movimento
                    checkCollision(robo, caixa);
                }
            }
        }
    }

    private static void checkCollision(RoboTransporte robo, Caixa caixa) {
        // Verifica colisão
        if (robo.getPosicaoX() == caixa.getPosX() && robo.getPosicaoY() == caixa.getPosY()) {
            System.out.println("Colisão com a caixa: " + caixa.getNomeItem());
        }
    }
}
