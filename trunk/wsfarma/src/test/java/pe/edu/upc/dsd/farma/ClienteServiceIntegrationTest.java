package pe.edu.upc.dsd.farma;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import pe.edu.upc.dsd.farma.model.Cliente;
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

}
