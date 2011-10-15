package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import pe.edu.upc.dsd.farma.model.Pedido;

import com.google.gson.Gson;


@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EntregaServiceIntegrationTest {
	/**
	 * URL del servicio RESTful Entrega
	 */
	private String URL = "http://localhost:8080/wsfarma/rest/entregaRest/";
	private Gson gson = new Gson();

	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testActualizaPedido(){
		String fullURL = URL + "actualizar";
		
		Pedido pedido = new Pedido();
		pedido.setNumero(4);
		pedido.setEstado(1);
		
		String jsonPedido = gson.toJson(pedido);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonPedido, header);
		
		try {
			restTemplate.put(fullURL, entity);
		} catch (Exception e) {
			Assert.fail();
		}
	}	
}
