package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.service.ClienteService;

public class ClienteServiceTest {
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void testRegistrarCliente(){
		Cliente cliente = new Cliente();
		
		cliente.setStrDNI("08123596");
		cliente.setStrNombre("Juan Perez");
		cliente.setStrDireccion("Av. Javier Prado Este 221");
		cliente.setStrDistrito("San Isidro");
		cliente.setStrTelefono("4110000");
		cliente.setStrEmail("mimail@mail.com");
		cliente.setStrFlagNotif("");
		cliente.setStrPassword("");
		
		Assert.assertEquals("Cliente registrado", clienteService.registraCliente(cliente));
	}
}
