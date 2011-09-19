package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.service.ClienteService;
import pe.edu.upc.dsd.farma.service.ClienteServiceImpl;

@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
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
		cliente.setStrFlagNotif("1");
		cliente.setStrPassword("123");
		
		Assert.assertEquals("Cliente registrado", clienteService.registraCliente(cliente));
	}
}
