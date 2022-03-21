package rmijogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceJogo extends Remote{
	boolean moverPeca(String movimento) throws RemoteException;
	boolean enviarMensagem(String mensagem) throws RemoteException;
}
