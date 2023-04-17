package Entities;

import Interfaces.Calcular;

import java.text.DecimalFormat;

public final class Passeio extends Veiculo implements Calcular {

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
    public String toString() {
        return  "Placa: "  +  this.getPlaca() + "\n"
                +"Marca: " + this.getMarca() + "\n"
                +"Modelo: " + this.getModelo() + "\n"
                +"Cor: " + this.getCor() + "\n"
                +"Velocidade máxima em km/h: " + this.getVelocMax() + "\n"
                +"Quantidade de rodas: " + this.getQtdRodas() + "\n"
                +"Quantidade de pistões do motor: " + this.getMotor().getQtdPist() + "\n"
                +"Potência do motor: " + this.getMotor().getPotencia() + "\n"
                +"Quantidade de passageiros: " + this.getQtdPassageiros() +"\n"
                +"Velocidade Máxima em cm/h: " + new DecimalFormat("#.00").format(this.calcVel(this.getVelocMax())) + " m/h \n"
                +"Resultado do método calcular da interface: " + this.Calcular();
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*1000;
    }

    @Override
    public int Calcular() {
        return this.getQtdPassageiros() + this.getQtdPassageiros() + (int)this.getVelocMax() + this.getMotor().getPotencia() + this.getMotor().getQtdPist();
    }
}
