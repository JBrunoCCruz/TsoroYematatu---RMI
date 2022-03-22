package tsoroyematatu;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import java.util.Scanner;

public class TsoroYematatu  extends UnicastRemoteObject implements InterfaceJogo {
	// Atributos utilizados para o RPC
	static Scanner console = new Scanner(System.in);
	static int tipoDeJogador;
	static int tipoDeJogadorOponente;
	
	// Construtor
	public TsoroYematatu () throws RemoteException {
		super ();
		System.out.print("Criado! ");
	}		
	
	
	/*
	 * Métodos remotos
	 * */
	public Boolean mover (String movimento) {
		System.out.println (movimento);
		return true;
	}
	
	public Boolean mensagem (String mensagem) {
		System.out.println (mensagem);
		return true;
	}
	/*
	 * Métodos remotos
	 * */
	
	
	/*
	 * Invocação para registrar no DNS
	 * */
	public static void registra () {
		System.out.print ("Jogador1 (1) ou Jogador2 (2)?: ");
		tipoDeJogador = console.nextInt();
		
		if (tipoDeJogador == 1) {
			tipoDeJogadorOponente = 2;
			new Registrador ("Jogador1");
			
		} else if (tipoDeJogador == 2) {
			tipoDeJogadorOponente = 1;
			new Registrador ("Jogador2");
			
		} else {
			tipoDeJogadorOponente = 0;
			new Registrador ("Jogador3");
		}
	}
	/*
	 * Invocação para registrar no DNS
	 * */
	
	
	/*
	 * Teste de chamada dos métodos remotos
	 * */
	public static void comunica () {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Pressione enter para comunicar: ");
			String tecla = scan.nextLine();
			InterfaceJogo IntJog = (InterfaceJogo) Naming.lookup("//localhost/Jogador" + Integer.toString(tipoDeJogadorOponente) );
			System.out.println ("Objeto localizado! (Jogador" + Integer.toString(tipoDeJogadorOponente) + ")");
			IntJog.mensagem("Mensagem do jogador" + Integer.toString(tipoDeJogador));
		} catch (Exception e) {
			System.out.println ("Comunica erro: " + e);
		}
	}
	/*
	 * Teste de chamada dos métodos remotos
	 * */
	
	
	/*
	 * Interface Gráfica
	 * */
	
	
	/*
	 * Interface Gráfica
	 * */
	
	public static void main(String[] args) {
		try {
			registra ();
			comunica ();
		} catch (Exception e) {
			System.out.print ("Main error " + e);
		}
	}
}
