package rmijogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceJogo extends Remote{
	Boolean mover(String movimento) throws RemoteException;
	Boolean mensagem(String mensagem) throws RemoteException;
}
