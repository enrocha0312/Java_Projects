package Entities;

import java.text.DecimalFormat;

public final class Carga extends Veiculo {

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
        return "Placa: "  +  getPlaca() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Modelo: " + getModelo() + "\n"
                +"Cor: " + getCor() + "\n"
                +"Velocidade Máxima: " + new DecimalFormat("#.00").format(getVelocMax() * 100000) + " cm/h \n"
                +"Quantidade de rodas: " + getQtdRodas() + "\n"
                +"Quantidade de pistões do motor: " + getMotor().getQtdPist() + "\n"
                +"Potência do motor: " + getMotor().getPotencia() + "\n";
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
}
