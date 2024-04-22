package dev.andrebonfim.code;

/**
 * Representa um espaço bidimensional definido por suas dimensões X e Y.
 */
public class Mundo2D {
  final int DIM_X;
  final int DIM_Y;

  /**
   * Constrói um novo mundo 2D com as dimensões especificadas.
   * 
   * @param dimX Dimensão X do mundo.
   * @param dimY Dimensão Y do mundo.
   */
  public Mundo2D(int dimX, int dimY) {
    this.DIM_X = dimX;
    this.DIM_Y = dimY;
  }

  /**
   * Retorna a dimensão X do mundo.
   * 
   * @return Dimensão X como inteiro.
   */
  public int getDimX() {
    return DIM_X;
  }

  /**
   * Retorna a dimensão Y do mundo.
   * 
   * @return Dimensão Y como inteiro.
   */
  public int getDimY() {
    return DIM_Y;
  }
}
