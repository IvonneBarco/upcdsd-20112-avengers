package pe.edu.upc.dsd.farma.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.dsd.farma.dao.PedidoDao;
import pe.edu.upc.dsd.farma.model.DetallePedidoAlmacen;
import pe.edu.upc.dsd.farma.model.Mensaje;

import com.google.gson.Gson;

@Path("almacenRest")
@Produces("text/plain")
public class AlmacenRest implements IAlmacen {

	@Autowired
	private PedidoDao pedidoDao;
	
	private Mensaje message = new Mensaje();
	private Gson gson = new Gson();
	
	@Override
	public String listarPedidos() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/detallePedido/{pedido}")
	@Override
	public String listaDetallepedido(@PathParam("pedido") String numeroPedido) {
		// TODO Auto-generated method stub
		List<DetallePedidoAlmacen> lista= pedidoDao.verDetallePedido(Integer.valueOf(numeroPedido));
		return gson.toJson(lista);
	}

	@Override
	public String validaUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
