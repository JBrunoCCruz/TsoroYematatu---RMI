package rmijogo;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;



public class Cliente  extends UnicastRemoteObject implements InterfaceJogo {
	
	public Cliente () throws RemoteException {
		
	}
	
	public boolean moverPeca (String movimento) {
		return true;
	}
	
	public boolean enviarMensagem (String mensagem) {
		return true;
	}

	public static void main (String[] args) {
		
	}
}
