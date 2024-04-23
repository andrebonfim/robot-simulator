package dev.andrebonfim;

import java.util.Arrays;
import dev.andrebonfim.code.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * Classe principal que inicializa a interface gráfica do simulador de robótica.
 * Permite a interação com um robô transportador em um ambiente simulado,
 * controlando
 * seu movimento e interação com objetos.
 *
 * <p>
 * Instruções de uso:
 * <ul>
 * <li>Seta para cima: move o robô para frente.</li>
 * <li>Seta para baixo: move o robô para trás.</li>
 * <li>Seta para esquerda: move o robô para a esquerda.</li>
 * <li>Seta para direita: move o robô para a direita.</li>
 * <li>Barra de espaço: alterna a velocidade do robô entre normal e rápida.</li>
 * </ul>
 *
 * <p>
 * A interface gráfica mostra o robô, algumas caixas e o galpão onde o robô
 * opera.
 * 
 * @author André Luis Bonfim
 * @version 3.0
 */
public class App extends Application {

    private static final String IMG_PATH = "/img/";
    private final Image imgFundo = new Image(getClass().getResourceAsStream(IMG_PATH + "galpao.png"));
    private final Image imgRoboFrente = new Image(getClass().getResourceAsStream(IMG_PATH + "robo1.png"));
    private final Image imgRoboCostas = new Image(getClass().getResourceAsStream(IMG_PATH + "robo2.png"));
    private final Image imgRoboEsquerda = new Image(getClass().getResourceAsStream(IMG_PATH + "robo3.png"));
    private final Image imgRoboDireita = new Image(getClass().getResourceAsStream(IMG_PATH + "robo4.png"));
    private final Image imgBoxLvr = new Image(getClass().getResourceAsStream(IMG_PATH + "box.png"));
    private final Image imgBoxHd = new Image(getClass().getResourceAsStream(IMG_PATH + "box2.png"));
    private final Image imgBoxPrt = new Image(getClass().getResourceAsStream(IMG_PATH + "box3.png"));

    private final ImageView viewFundo = new ImageView(imgFundo);
    private final ImageView viewRobo = new ImageView(imgRoboFrente);
    private final ImageView viewBoxLvr = new ImageView(imgBoxLvr);
    private final ImageView viewBoxHd = new ImageView(imgBoxHd);
    private final ImageView viewBoxPrt = new ImageView(imgBoxPrt);

    private Mundo2D mundo = new Mundo2D(600, 400);
    private Caixa caixaLvr = new Caixa("Caixa de Livros", 15, 25, 100, 50, 30, 40);
    private Caixa caixaHd = new Caixa("Caixa de HDs", 20, 150, 200, 50, 30, 40);
    private Caixa caixaPrt = new Caixa("Caixa de Impressoras", 25, 300, 250, 60, 40, 50);
    private RoboTransporte robo = new RoboTransporte(32, 300, Arrays.asList(caixaLvr, caixaHd, caixaPrt), mundo);

    /**
     * Ponto de entrada da aplicação JavaFX.
     * 
     * @param args argumentos da linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Inicializa a cena principal do estágio, configurando componentes gráficos e
     * eventos.
     * 
     * @param janela o estágio principal para esta aplicação.
     */
    @Override
    public void start(Stage janela) {
        setUpScene(janela);
        janela.setTitle("Simulador de Robótica");
        janela.show();
    }

    /**
     * Configura a cena com os componentes visuais necessários.
     * 
     * @param janela o estágio principal onde a cena será configurada.
     */
    private void setUpScene(Stage janela) {
        viewFundo.setTranslateX(0);
        viewFundo.setTranslateY(0);
        viewBoxLvr.setTranslateX(caixaLvr.getPosX());
        viewBoxLvr.setTranslateY(caixaLvr.getPosY());
        viewBoxHd.setTranslateX(caixaHd.getPosX());
        viewBoxHd.setTranslateY(caixaHd.getPosY());
        viewBoxPrt.setTranslateX(caixaPrt.getPosX());
        viewBoxPrt.setTranslateY(caixaPrt.getPosY());
        viewRobo.setTranslateX(robo.getPosicaoX());
        viewRobo.setTranslateY(robo.getPosicaoY());

        Group grupo = new Group(viewFundo, viewBoxLvr, viewBoxHd, viewBoxPrt, viewRobo);
        Scene cena = new Scene(grupo, mundo.getDimX(), mundo.getDimY());
        janela.setScene(cena);
        configureKeyEvents(cena);
    }

    /**
     * Configura os eventos de teclado para controlar o robô.
     * 
     * @param cena a cena onde os eventos de teclado serão registrados.
     */
    private void configureKeyEvents(Scene cena) {
        cena.setOnKeyPressed(evt -> {
            handleKeyPress(evt.getCode());
            updateRoboPosition();
        });
    }

    /**
     * Manipula a pressão de teclas para mover e controlar o robô.
     * 
     * @param code o código da tecla pressionada.
     */
    private void handleKeyPress(KeyCode code) {
        switch (code) {
            case UP:
                viewRobo.setImage(imgRoboCostas);
                robo.moveY(-robo.getVelocidade());
                break;
            case DOWN:
                viewRobo.setImage(imgRoboFrente);
                robo.moveY(robo.getVelocidade());
                break;
            case LEFT:
                viewRobo.setImage(imgRoboEsquerda);
                robo.moveX(-robo.getVelocidade());
                break;
            case RIGHT:
                viewRobo.setImage(imgRoboDireita);
                robo.moveX(robo.getVelocidade());
                break;
            case SPACE:
                toggleSpeed();
                break;
            default:
                break;
        }
    }

    /**
     * Alterna a velocidade do robô entre normal e rápida.
     */
    private void toggleSpeed() {
        if (robo.getVelocidade() == 1) {
            robo.setVelocidade(robo.getVelocidadeMax());
        } else {
            robo.setVelocidade(1);
        }
    }

    /**
     * Atualiza a posição do robô na interface gráfica.
     */
    private void updateRoboPosition() {
        viewRobo.setTranslateX(robo.getPosicaoX());
        viewRobo.setTranslateY(robo.getPosicaoY());
    }
}
