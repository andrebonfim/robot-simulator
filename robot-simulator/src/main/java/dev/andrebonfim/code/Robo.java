package dev.andrebonfim.code;

/**
 * Classe abstrata que define a estrutura básica de um robô em um ambiente 2D.
 * Os robôs podem mover-se nas direções X e Y e têm uma orientação específica.
 */
public abstract class Robo {
  protected float posicaoX;
  protected float posicaoY;
  protected Orientacao orientacao;
  protected String nome;
  protected float peso;

  public enum Orientacao {
    FRENTE,
    ATRAS,
    ESQUERDA,
    DIREITA;
  }

  /**
   * Obtém a posição X atual do robô.
   * 
   * @return Posição X como float.
   */
  public float getPosicaoX() {
    return posicaoX;
  }

  /**
   * Obtém a posição Y atual do robô.
   * 
   * @return Posição Y como float.
   */
  public float getPosicaoY() {
    return posicaoY;
  }

  /**
   * Método abstrato para mover o robô para uma nova posição.
   * 
   * @param x Deslocamento em X.
   * @param y Deslocamento em Y.
   */
  public abstract void move(float x, float y);

  /**
   * Método abstrato para mover o robô na direção X por uma distância
   * especificada.
   * 
   * @param dist Distância para mover.
   */
  public abstract void moveX(float dist);

  /**
   * Método abstrato para mover o robô na direção Y por uma distância
   * especificada.
   * 
   * @param dist Distância para mover.
   */
  public abstract void moveY(float dist);
}
