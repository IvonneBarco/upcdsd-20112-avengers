package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.edu.upc.dsd.farma.service.DespachoService;
import pe.edu.upc.dsd.farma.service.EntregaService;


@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EntregaServiceIntegrationTest {
	/**
	 * URL del servicio RESTful Entrega
	 */
	private String URL = "http://localhost:8080/wsfarma/rest/entregaRest";
}
