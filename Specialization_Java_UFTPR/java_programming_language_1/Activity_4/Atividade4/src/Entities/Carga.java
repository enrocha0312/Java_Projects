package Entities;

import Interfaces.Calcular;

import java.text.DecimalFormat;

public final class Carga extends Veiculo implements Calcular {

    private int cargaMax;

    private int tara;

    public Carga(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor, int cargaMax, int tara) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, motor);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public Carga() {
        tara = 0;
        cargaMax = 0;
        setVelocMax(0);
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*100000;
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
                +"Carga máxima: " + this.getCargaMax() + "\n"
                +"Tara: " + this.getTara() + "\n"
                +"Velocidade Máxima em cm/h: " + new DecimalFormat("#.00").format(this.calcVel(this.getVelocMax())) + " cm/h \n"
                +"Resultado do método calcular da interface: " + this.Calcular();
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public int Calcular() {
        return this.getPlaca().length() + this.getCor().length() + this.getModelo().length() + this.getMarca().length();
    }
}
