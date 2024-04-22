package dev.andrebonfim.code;

/**
 * Representa um robô de transporte que pode mover-se em um espaço bidimensional
 * e mudar sua orientação.
 * Herda características básicas de Robo.
 */
public class RoboTransporte extends Robo {
    private final float velocidadeMax = 5; // Velocidade máxima que o robô pode se mover
    private final float pesoCargaMax = 20; // Peso máximo de carga que o robô pode transportar
    private final String tipoTracao = "esteira"; // Tipo de tração do robô

    /**
     * Construtor padrão do RoboTransporte que inicializa valores básicos.
     */
    public RoboTransporte() {
        this.nome = "R-ATM";
        this.peso = 10;
        this.posicaoX = 50;
        this.posicaoY = 50;
        this.orientacao = Orientacao.FRENTE;
    }

    /**
     * Construtor do RoboTransporte que permite especificação completa de suas
     * propriedades.
     * 
     * @param nome Nome do robô.
     * @param peso Peso do robô.
     * @param posX Posição inicial X.
     * @param posY Posição inicial Y.
     */
    public RoboTransporte(String nome, float peso, float posX, float posY) {
        this.nome = nome;
        this.peso = peso;
        this.posicaoX = posX;
        this.posicaoY = posY;
    }

    /**
     * Move o robô para a posição especificada.
     * 
     * @param x Nova posição X.
     * @param y Nova posição Y.
     * @throws IllegalArgumentException Se x ou y forem NaN ou infinitos.
     */
    @Override
    public void move(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isInfinite(x) || Float.isInfinite(y)) {
            throw new IllegalArgumentException("Posições não podem ser NaN ou infinitas.");
        }
        this.posicaoX = x;
        this.posicaoY = y;
    }

    /**
     * Move o robô na direção X pela distância especificada.
     * 
     * @param dist Distância para mover na direção X.
     * @throws IllegalArgumentException Se a distância for NaN ou infinita.
     */
    @Override
    public void moveX(float dist) {
        if (Float.isNaN(dist) || Float.isInfinite(dist)) {
            throw new IllegalArgumentException("Distância não pode ser NaN ou infinita.");
        }
        this.posicaoX += dist;
    }

    /**
     * Move o robô na direção Y pela distância especificada.
     * 
     * @param dist Distância para mover na direção Y.
     * @throws IllegalArgumentException Se a distância for NaN ou infinita.
     */
    @Override
    public void moveY(float dist) {
        if (Float.isNaN(dist) || Float.isInfinite(dist)) {
            throw new IllegalArgumentException("Distância não pode ser NaN ou infinita.");
        }
        this.posicaoY += dist;
    }

    /**
     * Define a orientação do robô com base na tecla de comando inserida.
     * 
     * @param tecla Tecla de comando ('w', 's', 'a', 'd').
     * @throws IllegalArgumentException Se a tecla for inválida.
     */
    public void setOrientacao(char tecla) {
        switch (tecla) {
            case 'w':
                super.orientacao = Orientacao.FRENTE;
                moveY(velocidadeMax);
                break;
            case 's':
                super.orientacao = Orientacao.ATRAS;
                moveY(-velocidadeMax);
                break;
            case 'a':
                super.orientacao = Orientacao.ESQUERDA;
                moveX(-velocidadeMax);
                break;
            case 'd':
                super.orientacao = Orientacao.DIREITA;
                moveX(velocidadeMax);
                break;
            default:
                throw new IllegalArgumentException("Tecla inválida: " + tecla);
        }
    }

    /**
     * Realiza uma série de movimentos programados.
     * 
     * @param moves Array de comandos de movimento.
     */
    public void movimentosAgendados(String... moves) {
        for (String tecla : moves) {
            if (!tecla.equals("--move")) {
                setOrientacao(tecla.charAt(0));
                printPos();
            }
        }
    }

    /**
     * Imprime a posição atual e orientação do robô.
     */
    public void printPos() {
        String orientacaoStr = orientacaoToString(this.orientacao);
        System.out.println("Posição atual do Robô: X=" + this.posicaoX + ", Y=" + this.posicaoY +
                ", Orientação: " + orientacaoStr);
    }

    @Override
    public String toString() {
        return String.format(
                "RoboTransporte:\n" +
                        "  Nome:            %s\n" +
                        "  Posição X:       %.2f\n" +
                        "  Posição Y:       %.2f\n" +
                        "  Orientação:      %s\n" +
                        "  Peso:            %.2f kg\n" +
                        "  Velocidade Máx:  %.2f m/s\n" +
                        "  Carga Máx:       %.2f kg\n" +
                        "  Tipo de Tração:  %s\n",
                nome, posicaoX, posicaoY, orientacaoToString(orientacao), peso, velocidadeMax, pesoCargaMax,
                tipoTracao);
    }

    /**
     * Converte a orientação do robô para uma string legível.
     * 
     * @param orientacao Orientação do robô.
     * @return String representando a orientação.
     */
    private String orientacaoToString(Orientacao orientacao) {
        switch (orientacao) {
            case FRENTE:
                return "Frente";
            case ATRAS:
                return "Atrás";
            case ESQUERDA:
                return "Esquerda";
            case DIREITA:
                return "Direita";
            default:
                return "Desconhecida";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RoboTransporte that = (RoboTransporte) obj;
        return Float.compare(that.posicaoX, posicaoX) == 0 &&
                Float.compare(that.posicaoY, posicaoY) == 0 &&
                orientacao == that.orientacao &&
                nome.equals(that.nome) &&
                Float.compare(that.peso, peso) == 0 &&
                Float.compare(that.velocidadeMax, velocidadeMax) == 0 &&
                Float.compare(that.pesoCargaMax, pesoCargaMax) == 0 &&
                tipoTracao.equals(that.tipoTracao);
    }
}
