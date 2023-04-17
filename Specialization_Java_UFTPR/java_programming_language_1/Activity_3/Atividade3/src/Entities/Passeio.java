package Entities;

public final class Passeio extends Veiculo{

    private int qtdPassageiros;

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public final void  setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public Passeio(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor, int qtdPassageiros) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.qtdPassageiros = qtdPassageiros;
    }

    public Passeio() {
        qtdPassageiros = 0;
        setVelocMax(0);
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*1000;
    }
}
