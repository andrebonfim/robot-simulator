package dev.andrebonfim.code;

public abstract class Robo {
  protected float posicaoX;
  protected float posicaoY;
  protected int orientacao;
  protected String nome;
  protected float peso;

  public float getPosicaoX() {
    return posicaoX;
  }

  public float getPosicaoY() {
    return posicaoY;
  }

  public abstract void move(float x, float y);

  public abstract void moveX(float dist);

  public abstract void moveY(float dist);
}
