package dev.andrebonfim.code;

/**
 * Classe que representa um espaço bidimensional onde objetos podem ser
 * posicionados e
 * movimentados. Esta classe é útil em simulações que requerem uma representação
 * espacial
 * bidimensional.
 * 
 * @author André Luis Bonfim
 * @version 4.1
 */
public class Mundo2D {

  public final int DIM_X; // Dimensão horizontal do mundo
  public final int DIM_Y; // Dimensão vertical do mundo

  /**
   * Constrói um espaço bidimensional com as dimensões especificadas.
   *
   * @param dimX Largura do mundo bidimensional.
   * @param dimY Altura do mundo bidimensional.
   */
  public Mundo2D(int dimX, int dimY) {
    this.DIM_X = dimX;
    this.DIM_Y = dimY;
  }
}
