import java.util.ArrayList;
import java.util.List;

import Entities.Motor;
import Entities.Veiculo;

public class Teste {

	public static void main(String[] args) {
			List<Veiculo> veiculos = instanciarCincoVeiculos();
			//testar construtor default
			System.out.println("------ TESTES CARRO COM CONSTRUTOR DEFAULT --------");
			if(veiculos.get(0).getCor().isBlank())
			System.out.println("String vazia de acordo com o exigido no exercício");
			if(veiculos.get(0).getMarca().equals(" "))
			System.out.println("String vazia de acordo com o exigido no exercício");
			if(veiculos.get(0).getModelo().equals(" "))
			System.out.println("String vazia de acordo com o exigido no exercício");
			if(veiculos.get(0).getPlaca().isBlank())
			System.out.println("String vazia de acordo com o exigido no exercício");
			if(veiculos.get(0).getVelocMax() == 0.0)
			System.out.println("Veículo inicializado corretamente com velocidade 0.0");
			if(veiculos.get(0).getQtdRodas() == 0)
			System.out.println("Veículo inicializado corretamente com qtdRodas = 0");
			if(veiculos.get(0).getMotor() == null)
			System.out.println("Motor inicializado sem referência para a Heap");
			
			System.out.println("\n------ TESTES CARRO COM SET EM OBJETO --------");
			veiculos.get(1).setCor("preto");
			veiculos.get(1).setMarca("Volkswagen");
			veiculos.get(1).setModelo("Polo");
			veiculos.get(1).setMotor(new Motor(16, 1000));
			veiculos.get(1).setPlaca("KAA0934");
			veiculos.get(1).setQtdRodas(4);
			veiculos.get(1).setVelocMax(180.0f);
			if(!(veiculos.get(1).getCor().isBlank()))
			System.out.println("Cor do segundo carro " + veiculos.get(1).getCor());
			if(!(veiculos.get(1).getMarca().equals(" ")))
			System.out.println("Marca do segundo carro " + veiculos.get(1).getMarca());
			if(!(veiculos.get(1).getModelo().equals(" ")))
			System.out.println("Modelo do segundo carro " + veiculos.get(1).getModelo());
			if(!(veiculos.get(1).getPlaca().isBlank()))
			System.out.println("Placa do segundo veículo " + veiculos.get(1).getPlaca());
			if(!(veiculos.get(1).getVelocMax() == 0.0))
			System.out.println("Velocidade máxima do veículo 2 " + veiculos.get(1).getVelocMax());
			if(!(veiculos.get(1).getQtdRodas() == 0))
			System.out.println("Quantidade de rodas do segundo veículo " + veiculos.get(1).getQtdRodas());
			if(!(veiculos.get(1).getMotor() == null))
			System.out.println("Especificações do motor do segundo veículo ----> "
					+ "qtdPist: " + veiculos.get(1).getMotor().getQtdPist() + " potência: " + veiculos.get(1).getMotor().getPotencia());
			
			System.out.println("\n------ TESTES VEÍCULO COM CONSTRUTOR COM PARÂMETROS --------");
			veiculos.remove(veiculos.size() -1);
			veiculos.add(new Veiculo("KZO0245", "Toyota", "Hilux", "prata", 168.0f, 4, new Motor(16, 4300)));
			if(!(veiculos.get(4).getCor().isBlank()))
			System.out.println("Cor do último carro " + veiculos.get(4).getCor());
			if(!(veiculos.get(4).getMarca().equals(" ")))
			System.out.println("Marca do último carro " + veiculos.get(4).getMarca());
			if(!(veiculos.get(4).getModelo().equals(" ")))
			System.out.println("Modelo do último carro " + veiculos.get(4).getModelo());
			if(!(veiculos.get(4).getPlaca().isBlank()))
			System.out.println("Placa do último veículo " + veiculos.get(4).getPlaca());
			if(!(veiculos.get(4).getVelocMax() == 0.0))
			System.out.println("Velocidade máxima do último veículo " + veiculos.get(4).getVelocMax());
			if(!(veiculos.get(4).getQtdRodas() == 0))
			System.out.println("Quantidade de rodas do último veículo " + veiculos.get(4).getQtdRodas());
			if(!(veiculos.get(4).getMotor() == null))
			System.out.println("Especificações do motor do último veículo ----> "
					+ "qtdPist: " + veiculos.get(4).getMotor().getQtdPist() + " potência: " + veiculos.get(4).getMotor().getPotencia());
			
			System.out.println("\n -----Todos os veículos criados-----");
			for(Veiculo v: veiculos) {
				System.out.println("Referência na memória para o veículo: " + v);
				System.out.println("Placa do veículo: " + v.getPlaca());
			}
			
			System.out.println("\n ----- Veículos não inicializados (criados com construtor default) -----");
			int i = 0;
			while(i<veiculos.size()) {
				if(veiculos.get(i).getPlaca().isBlank()) {
					System.out.print("Veículo " + i + " inicializado com strings em branco com construtor default\n");
				}
				i++;
			}
			i = 0;
			System.out.println("\n -----Veículos com valores atribuídos -----");
			do {
				if(!(veiculos.get(i).getPlaca().isBlank())) {
					System.out.println("Veículo " + i + " inicializado ou \"setado\" com valores diferentes do default " + 
				" de placa " + veiculos.get(i).getPlaca());
				}
				i++;
			}while(i<veiculos.size());
	}
	
	public static List<Veiculo> instanciarCincoVeiculos(){
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		for (int i=0; i<5; i++) {
			veiculos.add(new Veiculo());
		}
		return veiculos;
	}
}
