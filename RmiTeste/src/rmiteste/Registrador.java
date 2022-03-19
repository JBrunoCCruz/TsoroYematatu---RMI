package rmiteste;

import java.rmi.*;
import java.rmi.server.*;

import java.rmi.registry.LocateRegistry;

public class Registrador {
	public Registrador() {
		servidorDNS();
		try {
			Servidor obj = new Servidor ();
			Naming.rebind("//localhost/InverterRef", obj);
			System.out.println("Servidor Registrado!");
		} catch (Exception e) {
			System.out.println("Registrador error: " + e);
		}
	}
	
	public void servidorDNS () {
		try {
			System.out.println("Criando o registry (DNS)");
			LocateRegistry.createRegistry(1099);
			System.out.println("Registry criado! (DNS)\r\n");
		} catch (Exception e) {
			System.out.println("Erro registry: " + e);
		}		
	}
}
