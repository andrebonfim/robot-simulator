package dev.andrebonfim.code;

public abstract class CaixaIdeia {
  protected String nomeItem;
  protected float peso;

  public CaixaIdeia(String nomeItem, float peso) {
    this.nomeItem = nomeItem;
    this.peso = peso;
  }

  public String getNomeItem() {
    return nomeItem;
  }

  public void setNomeItem(String nomeItem) {
    this.nomeItem = nomeItem;
  }

  public float getPeso() {
    return peso;
  }

  public void setPeso(float peso) {
    this.peso = peso;
  }

  @Override
  public String toString() {
    return "CaixaIdeia [nomeItem=" + nomeItem + ", peso=" + peso + "]";
  }
}
