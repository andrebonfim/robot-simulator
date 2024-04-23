package dev.andrebonfim.code;

/**
 * Classe abstrata que define a estrutura básica e funcionalidades comuns para
 * diferentes tipos de robôs.
 * Esta classe provê atributos e métodos para movimentação e manipulação de um
 * robô em um ambiente 2D.
 *
 * @author André Luis Bonfim
 * @version 3.0
 */
public abstract class Robo {
  protected float posicaoX;
  protected float posicaoY;
  protected float largura; // Utilizado nas verificações de colisão
  protected float altura; // Utilizado nas verificações de colisão
  protected float velocidade;
  protected float velocidadeMax;
  protected Orientacao orientacao;
  protected String nome;
  protected float peso;

  /**
   * Enumeração das possíveis orientações de um robô.
   */
  public enum Orientacao {
    FRENTE,
    ATRAS,
    ESQUERDA,
    DIREITA;
  }

  /**
   * Constrói uma instância de Robo com as dimensões especificadas e posição
   * inicial.
   *
   * @param posX    A posição inicial X do robô.
   * @param posY    A posição inicial Y do robô.
   * @param largura A largura do robô.
   * @param altura  A altura do robô.
   */
  public Robo(float posX, float posY, float largura, float altura) {
    this.posicaoX = posX;
    this.posicaoY = posY;
    this.largura = largura;
    this.altura = altura;
    this.velocidade = 1; // Velocidade inicial padrão
    this.velocidadeMax = 2; // Velocidade máxima inicial
    this.orientacao = Orientacao.FRENTE; // Orientação inicial
  }

  /**
   * Retorna a velocidade máxima do robô.
   *
   * @return A velocidade máxima.
   */
  public float getVelocidadeMax() {
    return velocidadeMax;
  }

  /**
   * Retorna a posição X do robô.
   *
   * @return A posição X.
   */
  public float getPosicaoX() {
    return posicaoX;
  }

  /**
   * Define a posição X do robô.
   *
   * @param posicaoX A nova posição X do robô.
   */
  public void setPosicaoX(float posicaoX) {
    this.posicaoX = posicaoX;
  }

  /**
   * Retorna a posição Y do robô.
   *
   * @return A posição Y.
   */
  public float getPosicaoY() {
    return posicaoY;
  }

  /**
   * Define a posição Y do robô.
   *
   * @param posicaoY A nova posição Y do robô.
   */
  public void setPosicaoY(float posicaoY) {
    this.posicaoY = posicaoY;
  }

  /**
   * Retorna a velocidade atual do robô.
   *
   * @return A velocidade atual.
   */
  public float getVelocidade() {
    return velocidade;
  }

  /**
   * Define a velocidade do robô.
   *
   * @param velocidade A nova velocidade do robô.
   */
  public void setVelocidade(float velocidade) {
    this.velocidade = velocidade;
  }

  /**
   * Retorna a largura do robô.
   *
   * @return A largura do robô.
   */
  public float getLargura() {
    return largura;
  }

  /**
   * Retorna a altura do robô.
   *
   * @return A altura do robô.
   */
  public float getAltura() {
    return altura;
  }

  /**
   * Método abstrato para mover o robô para uma nova posição.
   * Deve ser implementado pelas subclasses para definir o comportamento
   * específico de movimentação.
   *
   * @param x A posição X desejada.
   * @param y A posição Y desejada.
   */
  public abstract void move(float x, float y);

  /**
   * Método abstrato para mover o robô horizontalmente.
   * Deve ser implementado pelas subclasses para definir o comportamento
   * específico de movimentação horizontal.
   *
   * @param dist A distância para mover na direção X.
   */
  public abstract void moveX(float dist);

  /**
   * Método abstrato para mover o robô verticalmente.
   * Deve ser implementado pelas subclasses para definir o comportamento
   * específico de movimentação vertical.
   *
   * @param dist A distância para mover na direção Y.
   */
  public abstract void moveY(float dist);
}
