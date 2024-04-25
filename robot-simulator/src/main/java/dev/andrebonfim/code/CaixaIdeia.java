package dev.andrebonfim.code;

/**
 * Classe abstrata que modela a ideia de uma caixa. Esta classe define as
 * características
 * fundamentais de uma caixa, como posição, peso e dimensões, que podem ser
 * utilizadas em
 * simulações ou aplicações que requerem o manejo de objetos físicos.
 *
 * @author André Luis Bonfim
 * @version 4.0
 */
public abstract class CaixaIdeia {
  protected int posX; // Posição X da caixa no ambiente
  protected int posY; // Posição Y da caixa no ambiente
  protected float peso; // Peso da caixa
  protected final float comprimento; // Comprimento da caixa
  protected final float largura; // Largura da caixa
  protected final float altura; // Altura da caixa

  /**
   * Constrói uma instância de CaixaIdeia com especificações detalhadas.
   *
   * @param posX        Coordenada X da caixa.
   * @param posY        Coordenada Y da caixa.
   * @param peso        Peso da caixa.
   * @param comprimento Comprimento da caixa.
   * @param largura     Largura da caixa.
   * @param altura      Altura da caixa.
   */
  public CaixaIdeia(int posX, int posY, float peso, float comprimento, float largura, float altura) {
    this.posX = posX;
    this.posY = posY;
    this.peso = peso;
    this.comprimento = comprimento;
    this.largura = largura;
    this.altura = altura;
  }

  /**
   * Retorna a posição X da caixa.
   *
   * @return A posição X atual da caixa.
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Define a posição X da caixa.
   *
   * @param posX A nova posição X da caixa.
   */
  public void setPosX(int posX) {
    this.posX = posX;
  }

  /**
   * Retorna a posição Y da caixa.
   *
   * @return A posição Y atual da caixa.
   */
  public int getPosY() {
    return posY;
  }

  /**
   * Define a posição Y da caixa.
   *
   * @param posY A nova posição Y da caixa.
   */
  public void setPosY(int posY) {
    this.posY = posY;
  }

  /**
   * Retorna o peso da caixa.
   *
   * @return O peso atual da caixa.
   */
  public float getPeso() {
    return peso;
  }

  /**
   * Define o peso da caixa.
   *
   * @param peso O novo peso da caixa.
   */
  public void setPeso(float peso) {
    this.peso = peso;
  }
}
