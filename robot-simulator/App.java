package dev.andrebonfim;

import dev.andrebonfim.code.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application {
  private final Image imgFundo = new Image(getClass().getResourceAsStream("/img/galpao.png"));
  private final Image imgRoboFrente = new Image(getClass().getResourceAsStream("/img/robo1.png"));
  private final Image imgRoboCostas = new Image(getClass().getResourceAsStream("/img/robo2.png"));
  private final Image imgRoboEsquerda = new Image(getClass().getResourceAsStream("/img/robo3.png"));
  private final Image imgRoboDireita = new Image(getClass().getResourceAsStream("/img/robo4.png"));
  private final Image imgBoxLvr = new Image(getClass().getResourceAsStream("/img/box.png"));
  private final Image imgBoxHd = new Image(getClass().getResourceAsStream("/img/box2.png"));
  private final Image imgBoxPrt = new Image(getClass().getResourceAsStream("/img/box3.png"));

  private final ImageView viewFundo = new ImageView(imgFundo);
  private final ImageView viewRobo = new ImageView(imgRoboFrente);
  private final ImageView viewBoxLvr = new ImageView(imgBoxLvr);
  private final ImageView viewBoxHd = new ImageView(imgBoxHd);
  private final ImageView viewBoxPrt = new ImageView(imgBoxPrt);

  private final Mundo2D mundo = new Mundo2D(600, 400);
  private final Caixa caixaLvr = new Caixa("Caixa de Livros", 15, 25, 100, 30, 0.4f, 0.4f, 0.3f);
  private final Caixa caixaHd = new Caixa("Caixa de HDs", 15, 25, 100, 30, 0.4f, 0.4f, 0.3f);
  private final Caixa caixaPrt = new Caixa("Caixa de Impressoras", 8, 525, 100, 40, 0.6f, 0.6f, 0.4f);
  private final RoboTransporte robo = new RoboTransporte(32, 300, Arrays.asList(caixaLvr, caixaHd, caixaPrt), mundo);

  @Override
  public void start(Stage stage) {
    setupScene();
    stage.setTitle("Simulador de Robótica");
    stage.show();
  }

  private void setupScene() {
    Group group = new Group(viewFundo, viewBoxLvr, viewBoxHd, viewBoxPrt, viewRobo);
    Scene scene = new Scene(group, mundo.getDimX(), mundo.getDimY());
    stage.setScene(scene);
    configureKeyEvents(scene);
  }

  private void configureKeyEvents(Scene scene) {
    scene.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP:
          viewRobo.setImage(imgRoboCostas);
          robo.moveY(-10);
          break;
        case DOWN:
          viewRobo.setImage(imgRoboFrente);
          robo.moveY(10);
          break;
        case LEFT:
          viewRobo.setImage(imgRoboEsquerda);
          robo.moveX(-10);
          break;
        case RIGHT:
          viewRobo.setImage(imgRoboDireita);
          robo.moveX(10);
          break;
        case SPACE:
          robo.toggleSpeed();
          break;
      }
      updateRoboPosition();
    });
  }

  private void updateRoboPosition() {
    viewRobo.setTranslateX(robo.getPosicaoX());
    viewRobo.setTranslateY(robo.getPosicaoY());
  }

  public static void main(String[] args) {
    launch(args);
  }
}
