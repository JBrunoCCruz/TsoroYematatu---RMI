package rmijogo;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Registrador {

	public Registrador (String tipoDeCliente) {
		servidorDNS ();
		if (tipoDeCliente.equals("Jogador1")) {
			try {
				System.out.println("Criando Cli1");
				Cliente cli = new Cliente();
				Naming.rebind( ("//localhost/Jogador1") , cli);
				System.out.println("Cliente " + tipoDeCliente +  " Registrado!");
				
			} catch (Exception e) {
				System.out.println("Registrar Jog_1 error: " + e);
			}
			
		} else if (tipoDeCliente.equals("Jogador2")) {
			try {
				System.out.println("Criando Cli2");
				Cliente cli = new Cliente();
				Naming.rebind( ("//localhost/Jogador2") , cli);
				System.out.println("Cliente " + tipoDeCliente +  " Registrado!");
				
			} catch (Exception e) {
				System.out.println("Registrar Jog_2 error: " + e);
			}
			
		} else {
			System.out.println("Erro! Tipo de jogador inválido!");
		}				
	}
	
	public void servidorDNS () {
		try {			
			LocateRegistry.createRegistry(1099);
			System.out.println("Criado! (DNS)\r\n");
		} catch (Exception e) {
			System.out.println("Erro registry DNS: " + e);
		}
	}
}
