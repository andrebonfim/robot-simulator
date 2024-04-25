package dev.andrebonfim;

import dev.andrebonfim.code.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * Classe principal que inicia a aplicação de simulação robótica.
 * Utiliza JavaFX para renderizar o ambiente e o robô em um galpão.
 * 
 * @author André Luis Bonfim
 * @version 4.0
 */
public class App extends Application {

    private static final String IMG_FUNDO = "/img/galpao.png";
    private static final String IMG_FRENTE = "/img/robo1.png";
    private static final String IMG_COSTAS = "/img/robo2.png";
    private static final String IMG_ESQ = "/img/robo3.png";
    private static final String IMG_DIR = "/img/robo4.png";
    private static final String IMG_BOX_LVR = "/img/box.png";
    private static final String IMG_BOX_HD = "/img/box2.png";
    private static final String IMG_BOX_PRT = "/img/box3.png";

    private Image imgFundo = new Image(getClass().getResourceAsStream(IMG_FUNDO));
    private Image imgRoboFrente = new Image(getClass().getResourceAsStream(IMG_FRENTE));
    private Image imgRoboCostas = new Image(getClass().getResourceAsStream(IMG_COSTAS));
    private Image imgRoboEsq = new Image(getClass().getResourceAsStream(IMG_ESQ));
    private Image imgRoboDir = new Image(getClass().getResourceAsStream(IMG_DIR));
    private Image imgBoxLvr = new Image(getClass().getResourceAsStream(IMG_BOX_LVR));
    private Image imgBoxHd = new Image(getClass().getResourceAsStream(IMG_BOX_HD));
    private Image imgBoxPrt = new Image(getClass().getResourceAsStream(IMG_BOX_PRT));

    private ImageView viewFundo = new ImageView(imgFundo);
    private ImageView viewRobo = new ImageView(imgRoboFrente);
    private ImageView[] viewBoxLvr = new ImageView[3];
    private ImageView[] viewBoxPrt = new ImageView[3];
    private ImageView[][] viewBoxHd = new ImageView[2][3];

    private Mundo2D mundo = new Mundo2D(600, 400);
    private static final RoboTransporte robo = new RoboTransporte(32, 300);
    private Caixa[] caixaLvr = new Caixa[3];
    private Caixa[] caixaPrt = new Caixa[3];
    private Caixa[][] caixaHd = new Caixa[2][3];

    /**
     * Ponto de entrada principal da aplicação JavaFX.
     * 
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage janela) {
        setupScene(janela);
    }

    /**
     * Configura e exibe a cena principal da aplicação.
     * 
     * @param janela Palco principal onde a cena será exibida.
     */
    private void setupScene(Stage janela) {
        Group grupo = new Group(viewFundo);
        initializeObjects();
        updateRobotPosition();
        addObjectsToGroup(grupo);
        Scene cena = new Scene(grupo, mundo.DIM_X, mundo.DIM_Y);
        configureStage(janela, cena);
        addEventHandlers(cena);
    }

    /**
     * Inicializa objetos dentro da cena, como caixas e suas posições iniciais.
     */
    private void initializeObjects() {
        for (int i = 0; i < 3; i++) {
            caixaLvr[i] = new Caixa("Caixa de Livros", 15, 25, 50 + i * 50, 30, 0.40f, 0.40f, 0.30f);
            viewBoxLvr[i] = new ImageView(imgBoxLvr);
            viewBoxLvr[i].setTranslateX(caixaLvr[i].getPosX());
            viewBoxLvr[i].setTranslateY(caixaLvr[i].getPosY());

            caixaPrt[i] = new Caixa("Caixa de Impressoras", 8, 525, 50 + i * 50, 40, 0.60f, 0.60f, 0.40f);
            viewBoxPrt[i] = new ImageView(imgBoxPrt);
            viewBoxPrt[i].setTranslateX(caixaPrt[i].getPosX());
            viewBoxPrt[i].setTranslateY(caixaPrt[i].getPosY());
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                caixaHd[i][j] = new Caixa("Caixa de HDs", 20, 230 + j * 50, i == 0 ? 50 : 160, 40, 0.50f, 0.50f, 0.30f);
                viewBoxHd[i][j] = new ImageView(imgBoxHd);
                viewBoxHd[i][j].setTranslateX(caixaHd[i][j].getPosX());
                viewBoxHd[i][j].setTranslateY(caixaHd[i][j].getPosY());
            }
        }

    }

    /**
     * Adiciona objetos ao grupo principal da cena.
     * 
     * @param grupo Grupo ao qual os objetos serão adicionados.
     */
    private void addObjectsToGroup(Group grupo) {
        grupo.getChildren().add(viewRobo);
        for (ImageView view : viewBoxLvr) {
            grupo.getChildren().add(view);
        }
        for (ImageView view : viewBoxPrt) {
            grupo.getChildren().add(view);
        }
        for (int i = 0; i < viewBoxHd.length; i++) {
            for (ImageView view : viewBoxHd[i]) {
                grupo.getChildren().add(view);
            }
        }
    }

    /**
     * Configura o palco principal, definindo o título e a cena.
     * 
     * @param janela Palco a ser configurado.
     * @param cena   Cena a ser exibida no palco.
     */
    private void configureStage(Stage janela, Scene cena) {
        janela.setTitle("Simulador de Robótica");
        janela.setScene(cena);
        janela.show();
    }

    /**
     * Adiciona manipuladores de eventos à cena para controle do robô.
     * 
     * @param cena Cena à qual os manipuladores de eventos serão adicionados.
     */
    private void addEventHandlers(Scene cena) {
        cena.setOnKeyPressed(evt -> {
            KeyCode code = evt.getCode();
            switch (code) {
                case UP -> moveRobot(KeyCode.UP);
                case DOWN -> moveRobot(KeyCode.DOWN);
                case LEFT -> moveRobot(KeyCode.LEFT);
                case RIGHT -> moveRobot(KeyCode.RIGHT);
                case SPACE -> toggleRobotSpeed();
                default -> {
                } // Não faz nada para teclas não mapeadas
            }
        });
    }

    /**
     * Move o robô na direção especificada pela tecla.
     * 
     * @param key Tecla que indica a direção do movimento.
     */
    private void moveRobot(KeyCode key) {
        int newPos;
        switch (key) {
            case UP:
                viewRobo.setImage(imgRoboCostas);
                newPos = robo.getPosicaoY() - (int) robo.getVelocidade();
                if (robo.avaliaPosicao(robo.getPosicaoX(), newPos)) {
                    robo.setPosicaoY(newPos);
                }
                break;
            case DOWN:
                viewRobo.setImage(imgRoboFrente);
                newPos = robo.getPosicaoY() + (int) robo.getVelocidade();
                if (robo.avaliaPosicao(robo.getPosicaoX(), newPos)) {
                    robo.setPosicaoY(newPos);
                }
                break;
            case LEFT:
                viewRobo.setImage(imgRoboEsq);
                newPos = robo.getPosicaoX() - (int) robo.getVelocidade();
                if (robo.avaliaPosicao(newPos, robo.getPosicaoY())) {
                    robo.setPosicaoX(newPos);
                }
                break;
            case RIGHT:
                viewRobo.setImage(imgRoboDir);
                newPos = robo.getPosicaoX() + (int) robo.getVelocidade();
                if (robo.avaliaPosicao(newPos, robo.getPosicaoY())) {
                    robo.setPosicaoX(newPos);
                }
                break;
            default:
                // Não faz nada se a tecla não corresponder a uma direção.
                break;
        }
        updateRobotPosition();
    }

    /**
     * Atualiza a posição visual do robô na cena.
     */
    private void updateRobotPosition() {
        viewRobo.setTranslateX(robo.getPosicaoX());
        viewRobo.setTranslateY(robo.getPosicaoY());
    }

    /**
     * Alterna a velocidade do robô entre normal e rápida.
     */
    private void toggleRobotSpeed() {
        robo.setVelocidade(robo.getVelocidade() == 1 ? 5 : 1);
    }
}
