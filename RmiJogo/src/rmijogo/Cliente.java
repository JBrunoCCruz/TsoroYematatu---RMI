package rmijogo;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import rmijogo.Registrador;

import java.util.Scanner;


public class Cliente  extends UnicastRemoteObject implements InterfaceJogo {
	static Scanner console = new Scanner(System.in);
	
	public Cliente () throws RemoteException {
		super ();
		System.out.print("Criado ");
	}
	
	public static void registra () {
		System.out.print("Jogador1 (1) ou Jogador2 (2)?: ");
		int tipoDeJogador = console.nextInt();
		
		if (tipoDeJogador == 1) {
			new Registrador ("Jogador1");
		} else if (tipoDeJogador == 2) {
			new Registrador ("Jogador2");
		} else {
			new Registrador ("Jogador3");
		}
	}
	
	public Boolean mover (String movimento) {
		return true;
	}
	
	public Boolean mensagem (String mensagem) {
		return true;
	}

	public static void main (String[] args) {
		try {
			registra ();
		} catch (Exception e) {
			System.out.print("Main error " + e);
		}
	}
}
