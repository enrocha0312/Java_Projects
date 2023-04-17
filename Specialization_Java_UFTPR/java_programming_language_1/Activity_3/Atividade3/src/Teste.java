import Entities.Carga;
import Entities.Motor;
import Entities.Passeio;


import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teste {
    public static void main(String[] args) {
        Passeio passeio1 = new Passeio();
        Carga carga1 = new Carga();

        System.out.println("--------- TESTANDO O CONSTRUTOR VAZIO DE PASSEIO E CARGA --------");
        if(passeio1.getCor().equals(" ") && passeio1.getMarca().equals(" ") &&
           passeio1.getPlaca().equals(" ") && passeio1.getModelo().equals(" ")){
            System.out.println(" TODAS OS ATRIBUTOS DO TIPO STRING DA CLASSE PASSEIO FORAM INICIALIZADOS DA MANEIRA" +
                    " CORRETA, SEM SER NULL E COM UM ESPAÇO VAZIO");
        }

        if(carga1.getCor().equals(" ") && carga1.getMarca().equals(" ") &&
                carga1.getPlaca().equals(" ") && carga1.getModelo().equals(" ")){
            System.out.println(" TODAS OS ATRIBUTOS DO TIPO STRING DA CLASSE CARGA FORAM INICIALIZADOS DA MANEIRA" +
                    " CORRETA, SEM SER NULL E COM UM ESPAÇO VAZIO");
        }

        if(carga1.getQtdRodas() == 0 && carga1.getVelocMax()==0.0 && passeio1.getQtdRodas()==0 && passeio1.getVelocMax()==0.0
        && passeio1.getQtdPassageiros() == 0){
            System.out.println(" TODOS OS VALORES INT OU FLOAT INICIALIZADOS EM 0 PARA AMBAS AS CLASSES");
        }

        //CRIAÇÃO DE CARROS DE PASSEIO
        Passeio tiggo = new Passeio("KZO0002", "Chery", "Tiggo", "Cinza", 170.0f, 4, new Motor(3, 200), 5);
        Passeio polo = new Passeio("KWO9999", "Volkswagen", "Polo", "Preto", 185.0f, 4,new Motor(5, 180), 5);
        Passeio grandVitara = new Passeio("ABC1234", "Suzuki", "Grand Vitara", "Branco", 176.0f, 4, new Motor(2, 200), 5);
        Passeio uno = new Passeio("ERP8976", "Fiat", "Uno", "Cinza", 155.0f, 4, new Motor(1, 1000), 5);
        Passeio bis = new Passeio("ZYW9809", "Honda", "Bis", "Rosa", 108.0f, 2, new Motor(1, 455), 1);

        //CRIAÇÂO DE CARROS DE CARGA
        Carga strada = new Carga("AAA0000", "Fiat", "Strada", "Bege", 168.0f, 4, new Motor(3, 150), 200, 1085);
        Carga montana = new Carga("ABC0123", "Chevrolet", "Montana", "Vermelha", 171.0f, 4, new Motor(3, 1500), 450, 1200);
        Carga saveiro = new Carga("WER1256", "Volkswagen", "Saveiro", "Branco", 174.0f, 4, new Motor(4, 1600), 433, 1199);
        Carga frontier = new Carga("KZO0354", "Nissan", "Frontier", "Prata", 181.0f, 4, new Motor(7, 4200), 865, 1400);
        Carga hilux = new Carga("IUB5298", "Toyota", "Hilux", "Preta", 180.0f, 4, new Motor(8, 3800), 862, 1458);

        //Criação das listas de veículos
        List<Passeio> passeios = Stream.of(tiggo, polo, grandVitara, uno, bis).collect(Collectors.toList());
        List<Carga> cargas = Stream.of(strada, montana, saveiro, frontier, hilux).collect(Collectors.toList());

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        int i = 1;
        for(Passeio p : passeios){
            System.out.println(" ----- Veículo de passeio " + i +" -----");
            System.out.println("Placa: " + p.getPlaca());
            System.out.println("Marca: " + p.getMarca());
            System.out.println("Modelo: " + p.getModelo());
            System.out.println("Cor: " + p.getModelo());
            System.out.println("Velocidade Máxima: " + decimalFormat.format(p.calcVel(p.getVelocMax())) + " m/h");
            System.out.println("Quantidade de rodas: " + p.getQtdRodas());
            System.out.println("Número de pistões do motor: " + p.getMotor().getQtdPist());
            System.out.println("Potência do motor: " + p.getMotor().getPotencia());
            System.out.println("Quantidade de passageiros: " + p.getQtdPassageiros());
            ++i;
        }
        i=1;
        for(Carga c : cargas){
            System.out.println(" ----- Veículo de carga " + i +" -----");
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Marca: " + c.getMarca());
            System.out.println("Modelo: " + c.getModelo());
            System.out.println("Cor: " + c.getModelo());
            System.out.println("Velocidade Máxima: " + decimalFormat.format(c.calcVel(c.getVelocMax())) + " cm/h");
            System.out.println("Quantidade de rodas: " + c.getQtdRodas());
            System.out.println("Número de pistões do motor: " + c.getMotor().getQtdPist());
            System.out.println("Potência do motor: " + c.getMotor().getPotencia());
            System.out.println("Carga máxima: " + c.getCargaMax());
            System.out.println("Tara: " + c.getTara());
            ++i;
        }
        i=1;

        System.out.println("----- ALTERNATIVA ALTERANDO O MÉTODO HERDADO TOSTRING DE OBJETO \n"
        + "obs: caso realizado somente para carga, porém de aplicação análoga para passeio");
        for(Carga c : cargas){
            System.out.println(" ----- Veículo de carga " + i +" -----");
            System.out.println(c);
            i++;
        }
    }
}