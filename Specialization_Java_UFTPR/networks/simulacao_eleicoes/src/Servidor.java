import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Servidor implements iEleicao{
    public Servidor() {
    }

    private static Map<String, Integer> candidatoParaVoto = new HashMap<>(Map.of(
            "Lula", 0,
            "Bolsonaro", 0,
            "Ciro Gomes", 0,
            "Marina Silva", 0,
            "Simone Tebet", 0));

    private static Timer contador = new Timer();
    @Override
    public void mostrarTodosOsVotos() throws RemoteException {
        contador.schedule(new TimerTask() {
            @Override
            public void run() {
                candidatoParaVoto.entrySet().forEach(e-> System.out.println("Total de votos para o candidato " + e.getKey()+ ": " + e.getValue()));
            }
        }, 0, 5000);
    }

    @Override
    public void receberVotos(String candidato, int numVotos) throws RemoteException {
        if(!candidatoParaVoto.containsKey(candidato)){
            candidatoParaVoto.put(candidato, numVotos);
        }else{
            Integer valorAntigo = candidatoParaVoto.get(candidato);
            candidatoParaVoto.put(candidato, valorAntigo+numVotos);
        }
    }

    public static void main(String[] args){
        try{
            Servidor servidor = new Servidor();
            //criando Stub
            iEleicao stub = (iEleicao) UnicastRemoteObject.exportObject(servidor,0);
            Registry registro = LocateRegistry.getRegistry("localhost",1099);
            registro.bind("eleicoes", stub);
            System.out.println("Olá. Você digitará dados solicitados para sua urna. Seguem abaixo os candidatos da nossa base de dados:");
            System.out.println("--------------------------------------------------------------------");
            for(String candidato : candidatoParaVoto.keySet()){
                System.out.println(candidato);
            }
            stub.mostrarTodosOsVotos();
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyBoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
