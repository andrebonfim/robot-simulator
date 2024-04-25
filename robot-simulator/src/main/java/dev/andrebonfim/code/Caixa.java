package dev.andrebonfim.code;

/**
 * Classe que modela uma caixa utilizada para armazenar e transportar itens.
 * Esta classe
 * estende CaixaIdeia para adicionar funcionalidades específicas relacionadas ao
 * armazenamento de itens, como nome e quantidade de itens na caixa.
 * 
 * @author André Luis Bonfim
 * @version 4.0
 */
public class Caixa extends CaixaIdeia {

  public String nomeItem; // Nome do item contido na caixa
  public int qtdItem; // Quantidade de itens contidos na caixa

  /**
   * Construtor da Caixa que inicializa uma nova caixa com os detalhes do item,
   * quantidade de itens e especificações físicas da caixa.
   *
   * @param nomeItem    Nome do item que está na caixa.
   * @param qtdItem     Quantidade de itens que está na caixa.
   * @param posX        Posição X da caixa no ambiente.
   * @param posY        Posição Y da caixa no ambiente.
   * @param peso        Peso da caixa.
   * @param comprimento Comprimento da caixa.
   * @param largura     Largura da caixa.
   * @param altura      Altura da caixa.
   */
  public Caixa(String nomeItem, int qtdItem, int posX, int posY, float peso,
      float comprimento, float largura, float altura) {
    super(posX, posY, peso, comprimento, largura, altura);
    this.nomeItem = nomeItem;
    this.qtdItem = qtdItem;
  }

  /**
   * Fornece uma representação em string do estado atual da caixa, incluindo o
   * nome do item e
   * a quantidade de itens.
   *
   * @return Uma string que representa o estado atual da caixa.
   */
  @Override
  public String toString() {
    return "Caixa{" +
        "nomeItem='" + nomeItem + '\'' +
        ", qtdItem=" + qtdItem +
        ", posX=" + posX +
        ", posY=" + posY +
        ", peso=" + peso +
        ", comprimento=" + comprimento +
        ", largura=" + largura +
        ", altura=" + altura +
        '}';
  }
}
