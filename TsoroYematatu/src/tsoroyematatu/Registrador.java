package tsoroyematatu;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Registrador {

	public Registrador (String tipoDeCliente) {
		
		if (tipoDeCliente.equals("Jogador1")) {
			try {
				servidorDNS (); // Criar o DNS
				TsoroYematatu cli = new TsoroYematatu();
				Naming.rebind( ("//localhost/Jogador1") , cli);
				System.out.print(tipoDeCliente +  " Registrado!");
				
			} catch (Exception e) {
				System.out.println("Registrar Jog_1 error: " + e);
			}
			
		} else if (tipoDeCliente.equals("Jogador2")) {
			try {
				TsoroYematatu cli = new TsoroYematatu();
				Naming.rebind( ("//localhost/Jogador2") , cli);
				System.out.print(tipoDeCliente +  " Registrado!");
				
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
			System.out.println("Criado - (DNS)");
		} catch (Exception e) {
			System.out.println("Erro registry DNS: " + e);
		}
	}
}
