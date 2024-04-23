package dev.andrebonfim.code;

import java.util.List;

/**
 * Classe que representa um robô transportador capaz de navegar em um ambiente
 * 2D.
 * Este robô pode interagir com objetos como caixas e evitar colisões com eles.
 *
 * <p>
 * O robô é capaz de se mover em todas as direções e tem a capacidade de alterar
 * sua velocidade.
 *
 * @author André Luis Bonfim
 * @version 3.0
 */
public class RoboTransporte extends Robo {
    private final float velocidadeMax = 2; // Velocidade máxima do robô
    private List<Caixa> caixas; // Lista de caixas no ambiente que podem colidir com o robô
    private Mundo2D mundo; // Referência ao mundo 2D em que o robô se move

    /**
     * Construtor para RoboTransporte.
     *
     * @param posX   Posição inicial X do robô.
     * @param posY   Posição inicial Y do robô.
     * @param caixas Lista de caixas presentes no mundo que podem colidir com o
     *               robô.
     * @param mundo  O mundo 2D ao qual o robô pertence.
     */
    public RoboTransporte(int posX, int posY, List<Caixa> caixas, Mundo2D mundo) {
        super(posX, posY, 30, 30); // Assume-se dimensões genéricas para o robô
        this.caixas = caixas;
        this.mundo = mundo;
        this.velocidade = 1; // Velocidade inicial
    }

    /**
     * Move o robô para uma nova posição, verificando colisões.
     *
     * @param x Nova posição X desejada.
     * @param y Nova posição Y desejada.
     */
    @Override
    public void move(float x, float y) {
        if (!checaColisao(x, y)) {
            setPosicaoX(x);
            setPosicaoY(y);
        }
    }

    /**
     * Move o robô verticalmente ajustando pela velocidade atual.
     *
     * @param dist A distância para mover na direção Y.
     */
    @Override
    public void moveY(float dist) {
        float deltaY = dist * getVelocidade();
        float novaPosicaoY = this.posicaoY + deltaY;
        if (!checaColisao(this.posicaoX, novaPosicaoY)) {
            this.posicaoY = Math.max(0, Math.min(novaPosicaoY, mundo.getDimY() - this.altura));
        }
    }

    /**
     * Move o robô horizontalmente ajustando pela velocidade atual.
     *
     * @param dist A distância para mover na direção X.
     */
    @Override
    public void moveX(float dist) {
        float deltaX = dist * getVelocidade();
        float novaPosicaoX = this.posicaoX + deltaX;
        if (!checaColisao(novaPosicaoX, this.posicaoY)) {
            this.posicaoX = Math.max(0, Math.min(novaPosicaoX, mundo.getDimX() - this.largura));
        }
    }

    /**
     * Verifica se o movimento resultará em uma colisão com alguma das caixas.
     *
     * @param x A posição X proposta para o movimento.
     * @param y A posição Y proposta para o movimento.
     * @return true se houver colisão, false caso contrário.
     */
    private boolean checaColisao(float x, float y) {
        for (Caixa caixa : caixas) {
            if (x < caixa.getPosX() + caixa.getComprimento() && x + this.largura > caixa.getPosX() &&
                    y < caixa.getPosY() + caixa.getAltura() && y + this.altura > caixa.getPosY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Alterna a velocidade do robô entre a velocidade normal e a máxima.
     */
    public void toggleSpeed() {
        this.velocidade = (this.velocidade == 1) ? velocidadeMax : 1;
    }
}
