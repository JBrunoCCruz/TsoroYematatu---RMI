package rmijogo;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Registrador {

	public Registrador () {
		servidorDNS ();
		try {
			// Servidor obj = new Servidor ();
			// Naming.rebind("//localhost:1099/InverterRef", obj);
			// System.out.println("Servidor Registrado!");
		} catch (Exception e) {
			System.out.println("Registrador error: " + e);
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
