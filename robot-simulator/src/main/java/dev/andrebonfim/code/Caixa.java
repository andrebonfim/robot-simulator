package dev.andrebonfim.code;

/**
 * Classe que representa uma caixa física no ambiente simulado.
 * Esta caixa tem dimensões e uma localização específica, além de um conteúdo
 * definido.
 * 
 * @author André Luis Bonfim
 * @version 3.0
 */
public class Caixa extends CaixaIdeia {
  private int posX; // Posição X da caixa no ambiente
  private int posY; // Posição Y da caixa no ambiente
  private int comprimento; // Comprimento da caixa
  private int largura; // Largura da caixa
  private int altura; // Altura da caixa

  /**
   * Constrói uma nova caixa com especificações completas incluindo localização e
   * dimensões.
   * 
   * @param nomeItem    Nome do item contido na caixa.
   * @param peso        Peso do item contido na caixa.
   * @param posX        Posição X da caixa no ambiente.
   * @param posY        Posição Y da caixa no ambiente.
   * @param comprimento Comprimento da caixa.
   * @param largura     Largura da caixa.
   * @param altura      Altura da caixa.
   */
  public Caixa(String nomeItem, int peso, int posX, int posY, int comprimento, int largura, int altura) {
    super(nomeItem, peso);
    this.posX = posX;
    this.posY = posY;
    this.comprimento = comprimento;
    this.largura = largura;
    this.altura = altura;
  }

  /**
   * Retorna a posição X da caixa no ambiente.
   * 
   * @return A posição X da caixa.
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Retorna a posição Y da caixa no ambiente.
   * 
   * @return A posição Y da caixa.
   */
  public int getPosY() {
    return posY;
  }

  /**
   * Retorna o comprimento da caixa.
   * 
   * @return O comprimento da caixa.
   */
  public int getComprimento() {
    return comprimento;
  }

  /**
   * Retorna a largura da caixa.
   * 
   * @return A largura da caixa.
   */
  public int getLargura() {
    return largura;
  }

  /**
   * Retorna a altura da caixa.
   * 
   * @return A altura da caixa.
   */
  public int getAltura() {
    return altura;
  }
}
