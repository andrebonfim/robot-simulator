package dev.andrebonfim.code;

/**
 * Classe que representa uma caixa física que pode conter múltiplos itens do
 * mesmo tipo.
 * Esta caixa tem dimensões específicas e uma localização no espaço 2D.
 */
public class Caixa extends CaixaIdeia {
  private int qtdItem;
  private int posX;
  private int posY;
  private final float comprimento;
  private final float largura;
  private final float altura;

  /**
   * Constrói uma nova caixa com detalhes específicos.
   * 
   * @param nomeItem    Nome do item na caixa.
   * @param qtdItem     Quantidade de itens.
   * @param posX        Posição X da caixa.
   * @param posY        Posição Y da caixa.
   * @param peso        Peso total da caixa.
   * @param comprimento Comprimento da caixa.
   * @param largura     Largura da caixa.
   * @param altura      Altura da caixa.
   */
  public Caixa(String nomeItem, int qtdItem, int posX, int posY, float peso,
      float comprimento, float largura, float altura) {
    super(nomeItem, peso);
    this.qtdItem = qtdItem;
    this.posX = posX;
    this.posY = posY;
    this.comprimento = comprimento;
    this.largura = largura;
    this.altura = altura;
  }

  public int getQtdItem() {
    return qtdItem;
  }

  public void setQtdItem(int qtdItem) {
    this.qtdItem = qtdItem;
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  @Override
  public String toString() {
    return "Caixa[nomeItem=" + nomeItem + ", qtdItem=" + qtdItem +
        ", posX=" + posX + ", posY=" + posY + ", peso=" + peso +
        ", comprimento=" + comprimento + ", largura=" + largura +
        ", altura=" + altura + "]";
  }
}
