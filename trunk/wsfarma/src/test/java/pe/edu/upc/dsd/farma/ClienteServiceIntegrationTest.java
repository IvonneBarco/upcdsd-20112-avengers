package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.service.ClienteService;

@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteServiceIntegrationTest {
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void testRegistrarCliente(){
		
		Cliente cliente = new Cliente();
		cliente.setDni("08123596");
		cliente.setNombre("Juan Perez");
		cliente.setDireccion("Av. Javier Prado Este 221");
		cliente.setDistrito("San Isidro");
		cliente.setTelefono("4110000");
		cliente.setEmail("mimail@mail.com");
		cliente.setFlagNotif("1");
		cliente.setPassword("123");
		
		Assert.assertEquals("Cliente registrado", clienteService.registraCliente(cliente));
	}
	
	@Test
	public void testRegistrarPedido(){
		
		Pedido pedido = new Pedido();
		pedido.setNumero(1011);
		pedido.setDniCliente("08123596");
		pedido.setSubImporte(100);
		pedido.setImporteFinal(100);
		
		Assert.assertEquals("Pedido registrado", clienteService.registraPedido(pedido));
	}
	
	@Test
	public void testDescuentoCliente(){
		
		Assert.assertEquals(0.0, clienteService.descuentoCliente(""),0);
		
	}
	
	@Test
	public void testlistaPedidosCliente(){
		
		Assert.assertEquals(null, clienteService.listaPedidosCliente(""));
		
	}
}