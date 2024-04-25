package dev.andrebonfim.code;

/**
 * Classe abstrata que define a estrutura básica e as funcionalidades essenciais
 * de um robô.
 * Serve como base para diferentes tipos de robôs com capacidades específicas.
 * 
 * Esta classe é responsável por gerenciar as propriedades comuns como nome,
 * peso, e posição,
 * além de definir métodos abstratos para movimentação que devem ser
 * implementados por subclasses.
 * 
 * @author André Luis Bonfim
 * @version 4.1
 */
public abstract class Robo {

  protected String nome; // Nome do robô
  protected float peso; // Peso do robô em quilogramas
  protected float posicaoX; // Posição X atual do robô no ambiente
  protected float posicaoY; // Posição Y atual do robô no ambiente
  protected Orientacao orientacao; // Orientação atual do robô

  /**
   * Construtor padrão para inicializar um robô com configurações padrão.
   */
  public Robo() {
    this.nome = "Robo Padrão";
    this.peso = 50; // Peso padrão em quilogramas
    this.posicaoX = 0; // Posição inicial X
    this.posicaoY = 0; // Posição inicial Y
  }

  /**
   * Construtor para inicializar um robô com nome, peso e posição específicos.
   * 
   * @param nome Nome do robô.
   * @param peso Peso do robô em quilogramas.
   * @param posX Posição inicial X no ambiente.
   * @param posY Posição inicial Y no ambiente.
   */
  public Robo(String nome, float peso, float posX, float posY) {
    this.nome = nome;
    this.peso = peso;
    this.posicaoX = posX;
    this.posicaoY = posY;
  }

  /**
   * Método abstrato para mover o robô para uma nova posição.
   * Este método deve ser implementado por todas as subclasses, definindo como o
   * robô se move.
   * 
   * @param posX Nova posição X para mover o robô.
   * @param posY Nova posição Y para mover o robô.
   */
  public abstract void move(float posX, float posY);

  /**
   * Método abstrato para mover o robô ao longo do eixo X.
   * 
   * @param dist Distância para mover o robô ao longo do eixo X.
   */
  public abstract void moveX(float dist);

  /**
   * Método abstrato para mover o robô ao longo do eixo Y.
   * 
   * @param dist Distância para mover o robô ao longo do eixo Y.
   */
  public abstract void moveY(float dist);
}
