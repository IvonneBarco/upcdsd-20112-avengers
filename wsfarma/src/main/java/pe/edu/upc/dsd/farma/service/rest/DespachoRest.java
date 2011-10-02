package pe.edu.upc.dsd.farma.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import pe.edu.upc.dsd.farma.dao.PedidoDao;
import pe.edu.upc.dsd.farma.model.Mensaje;
import pe.edu.upc.dsd.farma.model.PedidoDespacho;

@Path("despachoRest")
@Produces("text/plain")
public class DespachoRest implements IDespacho {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	private Mensaje message = new Mensaje();
	private Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/")
	@Override
	public String listaPedidos() {
		List<PedidoDespacho> lista = pedidoDao.listaPedidosDespacho();
		return gson.toJson(lista);
	}

	@Override
	public String actualizaPedido(String jsonNumeroPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
