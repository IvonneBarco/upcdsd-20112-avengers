package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.DetallePedido;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.model.ResponseSecuencial;

import com.google.gson.Gson;

@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteServiceIntegrationTest {
	/**
	 * URL del servicio RESTful Cliente
	 */
	private String URLCliente = "http://localhost:8080/wsfarma/rest/clienteRest/";
	private Gson gson = new Gson();

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testObtieneSecuencial() {

		String fullURL = URLCliente + "obtieneNumero";
		ResponseEntity<String> response = restTemplate.getForEntity(fullURL,
				String.class);

		Integer secuencial = gson.fromJson(response.getBody(),
				ResponseSecuencial.class).getNumero();

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(Integer.class, secuencial.getClass());
	}

	@Test
	public void testRegistrarCliente() {
		String fullURL = URLCliente + "registrar";

		Cliente cliente = new Cliente();
		cliente.setDni("44992694");
		cliente.setDireccion("Av. La Prueba");
		cliente.setNombre("Daniel");
		cliente.setTelefono("5369504");
		cliente.setDistrito("San Miguel");
		cliente.setEmail("a@a.com");
		cliente.setPassword("abc123");
		cliente.setFlagNotif("Si");

		String jsonCliente = gson.toJson(cliente);

		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(jsonCliente,headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(fullURL, entity, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testRegistrarPedido(){
		String fullURL = URLCliente + "pedido";
		
		Pedido pedido = new Pedido();
		pedido.setNumero(98);
		pedido.setDniCliente("44992694");
		pedido.setFecha("02-10-2011");
		pedido.setSubImporte(500.00);
		pedido.setImporteFinal(500.00);
		pedido.setEstado(0);
		
		String jsonPedido = gson.toJson(pedido);
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonPedido, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(fullURL, entity, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testRegistrarDetallePedido(){
		String fullURL = URLCliente + "detallepedido";
		
		DetallePedido detallePedido = new DetallePedido();
		detallePedido.setNumeroPedido(98);
		detallePedido.setItemPedido(1);
		detallePedido.setCodigoProducto("P0000002");
		detallePedido.setCantidad(1);
		detallePedido.setImporte(1.00);
		detallePedido.setTotal(1.00);
		
		String jsonDetallePedido = gson.toJson(detallePedido);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonDetallePedido, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(fullURL, entity, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testValidarIngreso(){
		String password = "abc";
		String dni =  "43113358";
		String fullURL = URLCliente + "validar?dni=" + dni + "&pwd=" + password ;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<String> entity = new HttpEntity<String>("",headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(fullURL, entity, String.class);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	public void testAnulaPedido(){
		String fullURL = URLCliente + "anularPedido";
		
		Pedido pedido = new Pedido();
		pedido.setNumero(3);
		
		String jsonPedido = gson.toJson(pedido);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonPedido, headers);
		
		try {
			restTemplate.put(fullURL, entity);
			
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void testObtieneDescuento(){
		String fullURL = URLCliente + "obtieneDescuento/44992694";
		
		ResponseEntity<String> response = restTemplate.getForEntity(fullURL, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	public void testListarPedidos(){
		String fullURL = URLCliente + "listar/11155587";
		
		ResponseEntity<String> response = restTemplate.getForEntity(fullURL, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testListarProductos(){
		String fullURL = URLCliente + "producto";
		
		ResponseEntity<String> response = restTemplate.getForEntity(fullURL, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
