package dev.andrebonfim.code;

/**
 * Representa um espaço bidimensional no qual os robôs e outros objetos se
 * movimentam.
 * Esta classe fornece um contexto espacial definido por dimensões X e Y.
 * 
 * @author André Luis Bonfim
 * @version 3.0
 */
public class Mundo2D {
  private int dimX; // Dimensão horizontal do mundo.
  private int dimY; // Dimensão vertical do mundo.

  /**
   * Constrói um novo espaço 2D com as dimensões especificadas.
   * 
   * @param dimX A dimensão horizontal do mundo.
   * @param dimY A dimensão vertical do mundo.
   */
  public Mundo2D(int dimX, int dimY) {
    this.dimX = dimX;
    this.dimY = dimY;
  }

  /**
   * Retorna a dimensão horizontal do mundo.
   * 
   * @return A dimensão horizontal.
   */
  public int getDimX() {
    return dimX;
  }

  /**
   * Retorna a dimensão vertical do mundo.
   * 
   * @return A dimensão vertical.
   */
  public int getDimY() {
    return dimY;
  }
}
