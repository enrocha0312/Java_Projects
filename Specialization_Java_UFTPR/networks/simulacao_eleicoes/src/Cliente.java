import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args){
        try{
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            iEleicao stub = (iEleicao) registro.lookup("eleicoes");
            LocalDateTime agora = LocalDateTime.now();
            String candidato = "";
            Integer numVotos = 0;
            //simulando um programa com 3 minutos de execucao
            while (!LocalDateTime.now().equals(agora.plusMinutes(3))){
                System.out.println("Digite o nome do candidato");
                candidato = new Scanner(System.in).nextLine();
                System.out.println("Digite o número de votos obtidos na urna");
                numVotos = new Scanner(System.in).nextInt();
                stub.receberVotos(candidato, numVotos);
            }

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
