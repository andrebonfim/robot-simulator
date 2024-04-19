package dev.andrebonfim.code;

public class RoboTransporte extends Robo {
    static final int FRENTE = 0;
    static final int ATRAS = 1;
    static final int ESQUERDA = 2;
    static final int DIREITA = 3;
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

    public RoboTransporte(String nome, float peso, float posX, float posY) {
        this.nome = nome;
        this.peso = peso;
        this.posicaoX = posX;
        this.posicaoY = posY;
    }

    @Override
    public void move(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isInfinite(x) || Float.isInfinite(y)) {
            throw new IllegalArgumentException("Posições não podem ser NaN ou infinitas.");
        }
        this.posicaoX = x;
        this.posicaoY = y;
    }

    @Override
    public void moveX(float dist) {
        if (Float.isNaN(dist) || Float.isInfinite(dist)) {
            throw new IllegalArgumentException("Distância não pode ser NaN ou infinita.");
        }
        this.posicaoX += dist;
    }

    @Override
    public void moveY(float dist) {
        if (Float.isNaN(dist) || Float.isInfinite(dist)) {
            throw new IllegalArgumentException("Distância não pode ser NaN ou infinita.");
        }
        this.posicaoY += dist;
    }

    public void setOrientacao(char tecla) {
        switch (tecla) {
            case 'w':
                this.orientacao = FRENTE;
                moveY(velocidadeMax);
                break;
            case 's':
                this.orientacao = ATRAS;
                moveY(-velocidadeMax);
                break;
            case 'a':
                this.orientacao = ESQUERDA;
                moveX(-velocidadeMax);
                break;
            case 'd':
                this.orientacao = DIREITA;
                moveX(velocidadeMax);
                break;
            default:
                throw new IllegalArgumentException("Tecla inválida: " + tecla);
        }
    }

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

    private String orientacaoToString(int orientacao) {
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