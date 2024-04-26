package dev.andrebonfim.code;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 * Classe que implementa a funcionalidade de um carregador móvel em uma
 * aplicação JavaFX.
 * Este carregador se move horizontalmente entre dois limites definidos.
 * 
 * A classe implementa a interface {@link Runnable} para permitir a execução em
 * uma thread separada,
 * garantindo que a movimentação do carregador seja suave e não interfira na
 * thread da interface gráfica do usuário (GUI).
 * 
 * A movimentação é controlada por um loop que verifica constantemente se a
 * thread foi interrompida,
 * permitindo uma parada segura e limpa da thread quando necessário.
 */
public class Carregador implements Runnable {
  private volatile float posicaoX; // Posição X atual do carregador
  private volatile float posicaoY; // Posição Y atual do carregador, permanece constante
  private final ImageView viewCarregador; // ImageView que representa visualmente o carregador
  private final int velocidade = 3; // Velocidade de movimentação do carregador
  private static final int LIMITE_DIREITO = 350; // Limite direito de movimentação
  private static final int LIMITE_ESQUERDO = 190; // Limite esquerdo de movimentação

  /**
   * Construtor para inicializar o carregador com sua posição inicial e a view
   * correspondente.
   * 
   * @param posX Posição X inicial do carregador.
   * @param posY Posição Y inicial do carregador.
   * @param view ImageView que representa o carregador na interface gráfica.
   */
  public Carregador(float posX, float posY, ImageView view) {
    this.posicaoX = posX;
    this.posicaoY = posY;
    this.viewCarregador = view;
  }

  /**
   * Método principal da thread que controla a movimentação do carregador.
   * Executa um loop que move o carregador para frente e para trás entre os
   * limites definidos,
   * atualizando sua posição na interface gráfica.
   * O loop é interrompido quando a thread é interrompida.
   */
  @Override
  public void run() {
    boolean isMoveRight = true;
    while (!Thread.currentThread().isInterrupted()) {
      isMoveRight = moveCarregador(isMoveRight);
      updatePosition();
      try {
        Thread.sleep(100); // Pausa a thread para controlar a velocidade de movimentação
      } catch (InterruptedException ex) {
        System.out.println("Thread interrompida.");
        Thread.currentThread().interrupt(); // Propaga a interrupção para sair do loop
        break;
      }
    }
  }

  /**
   * Alterna a direção do movimento do carregador e atualiza sua posição X.
   * 
   * @param isMoveRight Booleano que indica se o carregador está se movendo para a
   *                    direita.
   * @return Retorna true se o carregador deve continuar se movendo para a
   *         direita, false caso contrário.
   */
  private boolean moveCarregador(boolean isMoveRight) {
    if (isMoveRight) {
      posicaoX += velocidade;
    } else {
      posicaoX -= velocidade;
    }
    if (isMoveRight && posicaoX > LIMITE_DIREITO) {
      return false;
    } else if (!isMoveRight && posicaoX < LIMITE_ESQUERDO) {
      return true;
    }
    return isMoveRight;
  }

  /**
   * Atualiza a posição do ImageView do carregador na interface gráfica.
   * Utiliza {@link Platform#runLater(Runnable)} para garantir que a atualização
   * seja feita na thread da GUI.
   */
  private void updatePosition() {
    Platform.runLater(() -> {
      viewCarregador.setTranslateX(posicaoX);
      viewCarregador.setTranslateY(posicaoY);
    });
  }
}