package dev.andrebonfim.code;

/**
 * Classe abstrata que define a estrutura básica de uma caixa que contém um
 * item.
 * Esta caixa pode ter um nome e um peso associado ao item que contém.
 */
public abstract class CaixaIdeia {
  protected String nomeItem;
  protected float peso;

  /**
   * Constrói uma nova instância de CaixaIdeia.
   * 
   * @param nomeItem Nome do item na caixa.
   * @param peso     Peso do item.
   */
  public CaixaIdeia(String nomeItem, float peso) {
    this.nomeItem = nomeItem;
    this.peso = peso;
  }

  /**
   * Retorna o nome do item na caixa.
   * 
   * @return Nome do item.
   */
  public String getNomeItem() {
    return nomeItem;
  }

  /**
   * Define o nome do item na caixa.
   * 
   * @param nomeItem Novo nome para o item.
   */
  public void setNomeItem(String nomeItem) {
    this.nomeItem = nomeItem;
  }

  /**
   * Retorna o peso do item na caixa.
   * 
   * @return Peso do item.
   */
  public float getPeso() {
    return peso;
  }

  /**
   * Define o peso do item na caixa.
   * 
   * @param peso Novo peso para o item.
   */
  public void setPeso(float peso) {
    this.peso = peso;
  }

  @Override
  public String toString() {
    return "CaixaIdeia [nomeItem=" + nomeItem + ", peso=" + peso + "]";
  }
}
