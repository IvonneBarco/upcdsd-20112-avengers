package pe.edu.upc.dsd.farma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.edu.upc.dsd.farma.service.DespachoService;

@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DespachoServiceIntegrationTest {
	@Autowired
	private DespachoService despachoService;
	
	@Test
	public void TestListaPedidos(){
		Assert.assertEquals(null, despachoService.actualizaPedido(0));
	}
	
	@Test
	public void TestActualizaPedido(){
		Assert.assertEquals(null, despachoService.listaPedidos());
	}
}
