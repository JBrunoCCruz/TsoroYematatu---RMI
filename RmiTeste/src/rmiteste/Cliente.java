package rmiteste;

import java.io.*;
import java.rmi.*;

public class Cliente {
	
	public Cliente() {
		Registrador reg = new Registrador();
		comunicaComServidor();
	}
	
	public void comunicaComServidor () {
		try {
			InverterItf Inv = (InverterItf)Naming.lookup("//localhost/InverterRef");
			System.out.println("Objeto localizado!");
			
			for ( ; ; ) {
				System.out.print("Digite a frase: ");				
				BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
				String line = r.readLine();
				String retorno = Inv.inverter(line);
				System.out.print("Frase invertida = " + retorno + " \r\n");
			}			
		} catch (Exception e) {
			System.out.println("Cliente error: " + e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Inicio....\r\n");
		new Cliente();
	}

}
