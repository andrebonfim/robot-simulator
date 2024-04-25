package dev.andrebonfim.code;

/**
 * Representa um robô de transporte, capaz de mover-se em um ambiente definido,
 * controlar sua velocidade e orientação, e transportar cargas até um limite de
 * peso.
 * <p>
 * Este robô utiliza esteira como tipo de tração, permitindo movimentação suave
 * e
 * estável, ideal para o transporte de itens sensíveis ou para operações em
 * terrenos irregulares.
 * </p>
 * 
 * @author André Luis Bonfim
 * @version 4.1
 */
public class RoboTransporte extends Robo {

    private float velocidade = 1.0f;
    private final int altura = 60;
    private final int largura = 64;

    /**
     * Constrói um RoboTransporte com configurações padrão.
     */
    public RoboTransporte() {
        super.nome = "R-ATM";
        super.peso = 70.0f;
        super.posicaoX = 50.0f;
        super.posicaoY = 50.0f;
    }

    /**
     * Constrói um RoboTransporte com um nome específico.
     * 
     * @param nome O nome do robô.
     */
    public RoboTransporte(String nome) {
        this(); // Chama o construtor padrão para inicializar valores comuns
        super.nome = nome;
    }

    /**
     * Constrói um RoboTransporte com nome e peso específicos.
     * 
     * @param nome O nome do robô.
     * @param peso O peso do robô.
     */
    public RoboTransporte(String nome, float peso) {
        this(nome); // Utiliza o construtor com nome para inicialização
        super.peso = peso;
    }

    /**
     * Constrói um RoboTransporte com posições iniciais X e Y.
     * 
     * @param posX A posição X inicial do robô.
     * @param posY A posição Y inicial do robô.
     */
    public RoboTransporte(float posX, float posY) {
        this(); // Chama o construtor padrão para inicializar valores comuns
        super.posicaoX = posX;
        super.posicaoY = posY;
    }

    /**
     * Constrói um RoboTransporte com nome, peso e posições iniciais.
     * 
     * @param nome O nome do robô.
     * @param peso O peso do robô.
     * @param posX A posição X inicial do robô.
     * @param posY A posição Y inicial do robô.
     */
    public RoboTransporte(String nome, float peso, float posX, float posY) {
        super.nome = nome;
        super.peso = peso;
        super.posicaoX = posX;
        super.posicaoY = posY;
    }

    /**
     * Move o robô para as coordenadas especificadas.
     * <p>
     * Este método atualiza as posições X e Y do robô para as novas coordenadas
     * fornecidas,
     * desde que estas sejam válidas. Coordenadas inválidas, como NaN ou infinito,
     * resultarão
     * em uma exceção.
     * </p>
     * 
     * @param posX Nova posição X do robô.
     * @param posY Nova posição Y do robô.
     * @throws IllegalArgumentException Se as coordenadas forem inválidas.
     */
    @Override
    public void move(float posX, float posY) {
        if (Float.isNaN(posX) || Float.isNaN(posY) || Float.isInfinite(posX) || Float.isInfinite(posY)) {
            throw new IllegalArgumentException("Coordenadas inválidas");
        }
        super.posicaoX = posX;
        super.posicaoY = posY;
    }

    /**
     * Move o robô ao longo do eixo X.
     * <p>
     * Este método desloca o robô uma distância especificada ao longo do eixo X.
     * Distâncias inválidas, como NaN ou infinito, resultarão em uma exceção.
     * </p>
     * 
     * @param dist Distância a ser percorrida no eixo X.
     * @throws IllegalArgumentException Se a distância for inválida.
     */
    @Override
    public void moveX(float dist) {
        if (Float.isNaN(dist) || Float.isInfinite(dist)) {
            throw new IllegalArgumentException("Distância inválida");
        }
        super.posicaoX += dist;
    }

    /**
     * Move o robô ao longo do eixo Y.
     * <p>
     * Este método desloca o robô uma distância especificada ao longo do eixo Y.
     * Distâncias inválidas, como NaN ou infinito, resultarão em uma exceção.
     * </p>
     * 
     * @param dist Distância a ser percorrida no eixo Y.
     * @throws IllegalArgumentException Se a distância for inválida.
     */
    @Override
    public void moveY(float dist) {
        if (Float.isNaN(dist) || Float.isInfinite(dist)) {
            throw new IllegalArgumentException("Distância inválida");
        }
        super.posicaoY += dist;
    }

    /**
     * Avalia se a posição especificada está dentro dos limites permitidos.
     * Verifica contra várias áreas restritas para determinar a validade da posição.
     *
     * @param posX Coordenada X a ser avaliada.
     * @param posY Coordenada Y a ser avaliada.
     * @return true se a posição estiver dentro dos limites permitidos, false caso
     *         contrário.
     */
    public boolean avaliaPosicao(int posX, int posY) {
        posX += largura / 2;
        posY += altura / 2;
        return !(posX < 40 || posX > 560 || posY < 30 || posY > 360 ||
                (posX >= 170 && posX <= 430 && posY >= 240 && posY <= 400) ||
                (posX >= 0 && posX <= 100 && posY >= 0 && posY <= 200) ||
                (posX >= 500 && posX <= 600 && posY >= 0 && posY <= 200) ||
                (posX >= 170 && posX <= 430 && (posY >= 0 && posY <= 90 || posY >= 120 && posY <= 200)));
    }

    /**
     * Retorna a altura do robô.
     * 
     * @return A altura do robô em unidades de medida.
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Retorna a largura do robô.
     * 
     * @return A largura do robô em unidades de medida.
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Retorna a velocidade atual do robô.
     * 
     * @return A velocidade atual do robô.
     */
    public float getVelocidade() {
        return velocidade;
    }

    /**
     * Define a velocidade do robô.
     * 
     * @param velocidade A nova velocidade do robô. Deve ser um valor positivo e
     *                   não pode exceder a velocidade máxima permitida.
     */
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Retorna a posição X atual do robô.
     * 
     * @return A posição X do robô, convertida para inteiro.
     */
    public int getPosicaoX() {
        return (int) this.posicaoX;
    }

    /**
     * Retorna a posição Y atual do robô.
     * 
     * @return A posição Y do robô, convertida para inteiro.
     */
    public int getPosicaoY() {
        return (int) this.posicaoY;
    }

    /**
     * Define a posição X do robô.
     * 
     * @param posicaoX A nova posição X do robô.
     */
    public void setPosicaoX(float posicaoX) {
        this.posicaoX = posicaoX;
    }

    /**
     * Define a posição Y do robô.
     * 
     * @param posicaoY A nova posição Y do robô.
     */
    public void setPosicaoY(float posicaoY) {
        this.posicaoY = posicaoY;
    }
}
