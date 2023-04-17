import Entities.Carga;
import Entities.Motor;
import Entities.Passeio;
import ReadClasses.Leitura;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Teste {
    public static void main(String[] args) {

        String oi = "3810.1";
        System.out.println((Double.parseDouble(oi) >= 0));
        //CRIAÇÃO DE CARROS DE PASSEIO
        Passeio tiggo = new Passeio("KZO0002", "Chery", "Tiggo", "Cinza", 170.0f, 4, new Motor(3, 200), 5);
        Passeio polo = new Passeio("KWO9999", "Volkswagen", "Polo", "Preto", 185.0f, 4, new Motor(5, 180), 5);
        Passeio grandVitara = new Passeio("ABC1234", "Suzuki", "Grand Vitara", "Branco", 176.0f, 4, new Motor(2, 200), 5);
        Passeio uno = new Passeio("ERP8976", "Fiat", "Uno", "Cinza", 155.0f, 4, new Motor(1, 1000), 5);
        Passeio bis = new Passeio("ZYW9809", "Honda", "Bis", "Rosa", 108.0f, 2, new Motor(1, 455), 1);

        //CRIAÇÂO DE CARROS DE CARGA
        Carga strada = new Carga("AAA0000", "Fiat", "Strada", "Bege", 168.0f, 4, new Motor(3, 150), 200, 1085);
        Carga montana = new Carga("ABC0123", "Chevrolet", "Montana", "Vermelha", 171.0f, 4, new Motor(3, 1500), 450, 1200);
        Carga saveiro = new Carga("WER1256", "Volkswagen", "Saveiro", "Branco", 174.0f, 4, new Motor(4, 1600), 433, 1199);
        Carga frontier = new Carga("KZO0354", "Nissan", "Frontier", "Prata", 181.0f, 4, new Motor(7, 4200), 865, 1400);
        Carga hilux = new Carga("IUB5298", "Toyota", "Hilux", "Preta", 180.0f, 4, new Motor(8, 3800), 862, 1458);

        Passeio carrosPasseio[] = {tiggo, polo, grandVitara, uno, bis};
        Carga carrosCarga[] = {strada, montana, saveiro, frontier, hilux};
        List<Carga> carrosDeCargaAdicionados = new ArrayList<>();
        List<Passeio> carrosDePasseioAdicionados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        boolean controle = false;
        boolean controlePasseio = false, controleCarga = false;
        String respostaDoUsuario = "";
        int escolha=0;
        while(controle==false) {
            System.out.println("SISTEMA DE GESTÃO DE VEÌCULOS - MENU INICIAL\n\n" +
                    "1. Cadastrar Veiculo de Passeio\n" +
                    "2. Cadastrar Veiculo de Carga\n" +
                    "3. Imprimir todos os veículos de passeio\n" +
                    "4. Imprimir todos os veículos de carga\n" +
                    "5. Imprimir veículo de passeio pela placa\n" +
                    "6. Imprimir Veiculo de carga pela placa\n" +
                    "7. Sair do sistema\n\n");
            System.out.println("Escolha sua opção\n");
            escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                    while (controlePasseio == false) {
                        Passeio carroDoUsuario = new Passeio();
                        System.out.println("Vamos começar seu cadastro de veículo de passeio. Digite a placa:");
                        carroDoUsuario.setPlaca(Leitura.entDados(entrada.next()));
                        if (Arrays.stream(carrosPasseio).anyMatch(v -> v.getPlaca().equalsIgnoreCase(carroDoUsuario.getPlaca()))) {
                            System.out.println("Já existe um veículo com essa placa");
                            System.out.println("Deseja tentar cadastrar outro carro de passeio?");
                            respostaDoUsuario = entrada.next();
                            if (!respostaDoUsuario.equalsIgnoreCase("Sim")) {
                                controlePasseio = true;
                            }
                        } else {
                            System.out.println("Digite a marca do veículo");
                            carroDoUsuario.setMarca(Leitura.entDados(entrada.next()));
                            if(carroDoUsuario.getMarca().equals("0")){
                                carroDoUsuario.setMarca("Dado inválido fornecido");
                            }
                            System.out.println("Digite a cor");
                            carroDoUsuario.setCor(Leitura.entDados(entrada.next()));
                            if(carroDoUsuario.getCor().equals("0")){
                                carroDoUsuario.setCor("Dado inválido fornecido");
                            }
                            System.out.println("Digite o modelo");
                            carroDoUsuario.setModelo(Leitura.entDados(entrada.next()));
                            if(carroDoUsuario.getModelo().equals("0")){
                                carroDoUsuario.setModelo("Dado inválido fornecido");
                            }
                            carroDoUsuario.setMotor(new Motor());
                            System.out.println("Especifique a potência do motor");
                            carroDoUsuario.getMotor().setPotencia(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Especifique a quantidade de pistões do motor");
                            carroDoUsuario.getMotor().setQtdPist(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Digite a quantidade de passageiros");
                            carroDoUsuario.setQtdPassageiros(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Quantidade de rodas do veículo");
                            carroDoUsuario.setQtdRodas(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Velocidade máxima do carro");
                            carroDoUsuario.setVelocMax(Float.parseFloat(Leitura.entDados(entrada.next())));
                            System.out.println("Deseja adicionar outro veículo de passeio?");
                            respostaDoUsuario = entrada.next();
                            carrosDePasseioAdicionados.add(carroDoUsuario);
                            if (!respostaDoUsuario.equalsIgnoreCase("Sim")) {
                                controlePasseio = true;
                            }
                        }
                    }
                    break;
                case 2:
                    while (controleCarga == false) {
                        Carga carroDoUsuario = new Carga();
                        System.out.println("Vamos começar seu cadastro de veículo de carga. Digite a placa:");
                        carroDoUsuario.setPlaca(Leitura.entDados(entrada.next()));
                        if (Arrays.stream(carrosCarga).anyMatch(v -> v.getPlaca().equalsIgnoreCase(carroDoUsuario.getPlaca()))) {
                            System.out.println("Já existe um veículo com essa placa");
                            System.out.println("Deseja tentar cadastrar outro carro de passeio?");
                            respostaDoUsuario = entrada.next();
                            if (!respostaDoUsuario.equalsIgnoreCase("Sim")) {
                                controleCarga = true;
                            }
                        } else {
                            System.out.println("Digite a marca do veículo");
                            carroDoUsuario.setMarca(Leitura.entDados(entrada.next()));
                            if(carroDoUsuario.getMarca().equals("0")){
                                carroDoUsuario.setMarca("Dado inválido fornecido");
                            }
                            System.out.println("Digite a cor");
                            carroDoUsuario.setCor(Leitura.entDados(entrada.next()));
                            if(carroDoUsuario.getCor().equals("0")){
                                carroDoUsuario.setCor("Dado inválido fornecido");
                            }
                            System.out.println("Digite o modelo");
                            carroDoUsuario.setModelo(Leitura.entDados(entrada.next()));
                            if(carroDoUsuario.getCor().equals("0")){
                                carroDoUsuario.setCor("Dado inválido fornecido");
                            }
                            carroDoUsuario.setMotor(new Motor());
                            System.out.println("Especifique a potência do motor");
                            carroDoUsuario.getMotor().setPotencia(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Especifique a quantidade de pistões do motor");
                            carroDoUsuario.getMotor().setQtdPist(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Especificar Tara");
                            carroDoUsuario.setTara(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Especificar carga máxima");
                            carroDoUsuario.setCargaMax(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Quantidade de rodas do veículo");
                            carroDoUsuario.setQtdRodas(Integer.parseInt(Leitura.entDados(entrada.next())));
                            System.out.println("Velocidade máxima do carro");
                            carroDoUsuario.setVelocMax(Float.parseFloat(entrada.next()));
                            System.out.println("Deseja adicionar outro veículo de carga?");
                            respostaDoUsuario = entrada.next();
                            carrosDeCargaAdicionados.add(carroDoUsuario);
                            if (!respostaDoUsuario.equalsIgnoreCase("Sim")) {
                                controleCarga = true;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("VEÍCULOS DE PASSEIO: \n\n");
                    int i = 1;
                    for(Passeio p: carrosPasseio){
                        System.out.println("Veículo " + i + "----\n" + p.toString() + "\n");
                        i++;
                    }
                    if(!carrosDePasseioAdicionados.isEmpty()){
                        for(Passeio p: carrosDePasseioAdicionados){
                            System.out.println("----Veículo " + i +"----\n" + p.toString() + "\n");
                            i++;
                        }
                    }
                    break;
                case 4:
                    System.out.println("VEÍCULOS DE CARGA");
                    int j = 1;
                    for(Carga c: carrosCarga){
                        System.out.println("----Veículo " + j + "----\n" + c.toString() + "\n");
                        j++;
                    }
                    if(!carrosDePasseioAdicionados.isEmpty()){
                        for(Carga c: carrosDeCargaAdicionados){
                            System.out.println("----Veículo " + j + "----\n" + c.toString() + "\n");
                            j++;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Especifique a placa de veículo de passeio");
                    String placaPasseio = entrada.next();
                    if(Arrays.stream(carrosPasseio).anyMatch(v -> v.getPlaca().equalsIgnoreCase(placaPasseio))){
                        System.out.println(Arrays.stream(carrosPasseio)
                                .filter(c -> c.getPlaca().equalsIgnoreCase(placaPasseio)).toArray(Passeio[]::new)[0].toString());
                    }
                    if(!(carrosDePasseioAdicionados.stream().filter(p -> p.getPlaca().equalsIgnoreCase(placaPasseio)).collect(Collectors.toList()).isEmpty())){
                        System.out.println(carrosDePasseioAdicionados.stream().filter(c -> c.getPlaca().equalsIgnoreCase(placaPasseio)).collect(Collectors.toList()).get(0).toString());
                    }else {
                        System.out.println("Não há carros cadastrados para a placa especificada! \n");
                    }
                    break;
                case 6:
                    System.out.println("Especifique a placa de veículo de carga");
                    String placaCarga = entrada.next();
                    if(Arrays.stream(carrosCarga).anyMatch(v -> v.getPlaca().equalsIgnoreCase(placaCarga))){
                        System.out.println(Arrays.stream(carrosCarga)
                                .filter(c -> c.getPlaca().equalsIgnoreCase(placaCarga)).toArray(Carga[]::new)[0].toString());
                    }
                    if(!(carrosDeCargaAdicionados.stream().filter(c -> c.getPlaca().equalsIgnoreCase(placaCarga)).collect(Collectors.toList()).isEmpty())){
                        System.out.println(Leitura.entDados(carrosDeCargaAdicionados.stream().filter(c -> c.getPlaca().equalsIgnoreCase(placaCarga)).collect(Collectors.toList()).get(0).toString()));
                    }else {
                        System.out.println("Não há veículos de carga cadastrados para a placa especificada! \n");
                    }
                    break;
                case 7:
                    controle = true;
                    break;
                default:
                    System.out.println("Digite um número de 1 a 7!");
            }
        }
    }
}