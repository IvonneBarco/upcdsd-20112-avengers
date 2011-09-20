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
	@Autowired
	private EntregaService entregaService;
	
	@Test
	public void TestListaPedidos(){
		Assert.assertEquals(null, entregaService.actualizaPedido(0));
	}
	
	@Test
	public void TestActualizaPedido(){
		Assert.assertEquals(null, entregaService.listaPedidos());
	}
}
