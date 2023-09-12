import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface iEleicao extends Remote {

    public void mostrarTodosOsVotos() throws RemoteException;

    public void receberVotos(String candidato, int numVotos) throws RemoteException;

}
