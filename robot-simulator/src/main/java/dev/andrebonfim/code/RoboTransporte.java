package dev.andrebonfim.code;

public class RoboTransporte {
    private float posicaoX;
    private float posicaoY;
    private int orientacao;
    static final int FRENTE = 0;
    static final int ATRAS = 1;
    static final int ESQUERDA = 2;
    static final int DIREITA = 3;
    private final String nome;
    private final float peso;
    private final float velocidadeMax = 5;
    private final float pesoCargaMax = 20;
    private final String tipoTracao = "esteira";

    public RoboTransporte() {
        this.nome = "R-ATM";
        this.peso = 10;
        this.posicaoX = 50;
        this.posicaoY = 50;
        this.orientacao = FRENTE;
    }

    public RoboTransporte(String nome) {
        this.nome = nome;
        this.peso = 10;
        this.posicaoX = 50;
        this.posicaoY = 50;
    }

    public RoboTransporte(String nome, float peso) {
        this.nome = nome;
        this.peso = peso;
        this.posicaoX = 50;
        this.posicaoY = 50;
    }

    public RoboTransporte(String nome, float peso, float posX, float posY) {
        this.nome = nome;
        this.peso = peso;
        this.posicaoX = posX;
        this.posicaoY = posY;
    }

    // Método para mover o robô para uma nova posição
    public void move(float pos) {
        this.posicaoY = pos;
    }

    public void move(float x, float y) {
        posicaoX = x;
        posicaoY = y;
    }

    // Métodos para obter a posição atual do robô
    public float getPosicaoX() {
        return this.posicaoX;
    }

    public float getPosicaoY() {
        return this.posicaoY;
    }

    public void setOrientacao(char tecla) {
        if (tecla == 'w') {
            this.orientacao = FRENTE;
        } else if (tecla == 's') {
            this.orientacao = ATRAS;
        } else if (tecla == 'a') {
            this.orientacao = ESQUERDA;
        } else if (tecla == 'd') {
            this.orientacao = DIREITA;
        }
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

    private String orientacaoToString(int orientacao) {
        switch (orientacao) {
            case 0:
                return "Frente";
            case 1:
                return "Atrás";
            case 2:
                return "Esquerda";
            case 3:
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
                nome.equals(that.nome);
    }
}