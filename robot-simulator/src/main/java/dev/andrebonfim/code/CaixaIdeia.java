package dev.andrebonfim.code;

/**
 * Classe abstrata que representa a ideia de uma caixa que pode conter itens.
 * Define propriedades comuns a todas as caixas, como o nome do item e seu peso.
 * Serve como superclasse para diferentes tipos de caixas específicas.
 * 
 * @author André Luis Bonfim
 * @version 3.0
 */
public abstract class CaixaIdeia {
  protected String nomeItem; // Nome do item contido na caixa.
  protected float peso; // Peso do item contido na caixa.

  /**
   * Construtor que inicializa uma caixa com um nome de item e peso especificados.
   * 
   * @param nomeItem Nome do item contido na caixa.
   * @param peso     Peso do item contido na caixa.
   */
  public CaixaIdeia(String nomeItem, float peso) {
    this.nomeItem = nomeItem;
    this.peso = peso;
  }

  /**
   * Retorna o nome do item contido na caixa.
   * 
   * @return Nome do item.
   */
  public String getNomeItem() {
    return nomeItem;
  }

  /**
   * Retorna o peso do item contido na caixa.
   * 
   * @return Peso do item.
   */
  public float getPeso() {
    return peso;
  }
}
