package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

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
		ResponseEntity<String> response = restTemplate.getForEntity(fullURL, String.class);
		
		Integer secuencial = gson.fromJson(response.getBody(),ResponseSecuencial.class).getNumero();
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(Integer.class, secuencial.getClass());
	}
	
}
