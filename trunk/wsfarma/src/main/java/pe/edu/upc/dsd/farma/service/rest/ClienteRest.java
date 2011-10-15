package pe.edu.upc.dsd.farma.service.rest;

import java.util.Hashtable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.dao.PedidoDao;
import pe.edu.upc.dsd.farma.dao.ProductoDao;
import pe.edu.upc.dsd.farma.logic.Util;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.DatosMensaje;
import pe.edu.upc.dsd.farma.model.DetallePedido;
import pe.edu.upc.dsd.farma.model.Mensaje;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.model.Producto;
import pe.edu.upc.dsd.farma.model.ResponseSecuencial;

import com.google.gson.Gson;

@Path("clienteRest")
@Produces("text/plain")
public class ClienteRest implements ICliente {

	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private PedidoDao pedidoDao;
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private Mensaje message = new Mensaje();
	private Gson gson = new Gson();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/registrar")
	@Override
	public String registraCliente(String jsonCliente) {
		Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);

		clienteDao.insertarCliente(cliente);

		message.setError(false);
		message.setSuccess(true);
		message.setDescripcion("Cliente Registrado");

		return gson.toJson(message, Mensaje.class);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/validar")
	@Override
	public String validaIngreso(@FormParam("dni") String dni, @FormParam("pwd") String pwd) {
		Cliente cliente = clienteDao.validaCliente(dni, pwd);

		if (cliente == null) {
			message.setError(true);
			message.setSuccess(false);
			message.setDescripcion("Error Cliente no encontrado");

		} else {
			message.setError(false);
			message.setSuccess(true);
			message.setDescripcion("Cliente validado");
		}

		return gson.toJson(message, Mensaje.class);
	}

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/{dni}")
	@Override
	public String listaPedidos(@PathParam("dni") String dni) {
		List<Pedido> lista = clienteDao.listaPedidos(dni);
		return gson.toJson(lista);
	}

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obtieneDescuento/{dni}")
	@Override
	public String obtieneDescuento(@PathParam("dni") String dni) {
		//TODO: Implementar en Dao Descuento
		Hashtable<String, Double> mapper =  new Hashtable<String, Double>();
		mapper.put("descuento", 0.00);
		
		return gson.toJson(mapper);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pedido")
	@Override
	public String registraPedido(String jsonPedido) {
		Pedido pedido = gson.fromJson(jsonPedido, Pedido.class);
		pedidoDao.insertarPedido(pedido);
		
		DatosMensaje datos = clienteDao.obtieneDatos(pedido.getNumero());
		
		Util envio = new Util();
		envio.encolar(jmsTemplate, datos);
		
		message.setSuccess(true);
		message.setError(false);
		message.setDescripcion("Pedido Registrado");
		
		return gson.toJson(message, Mensaje.class);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/detallepedido")
	@Override
	public String registraDetallePedido(String jsonDetallePedido) {
		DetallePedido detalle = gson.fromJson(jsonDetallePedido, DetallePedido.class);
		pedidoDao.insertarDetallePedido(detalle);
		
		message.setSuccess(true);
		message.setError(false);
		message.setDescripcion("Detalle Registrado");
		
		return gson.toJson(message, Mensaje.class);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/anularPedido")
	@Override
	public String anulaPedido(String jsonPedido) {
		
		Pedido pedido = gson.fromJson(jsonPedido, Pedido.class);
		System.out.println("Numero Pedido :" + pedido.getNumero() + "  , estado : " + pedido.getEstado());
		pedidoDao.actualizarEstadoPedido(pedido.getNumero(), pedido.getEstado());
		
		message.setSuccess(true);
		message.setError(false);
		message.setDescripcion("Pedido Anulado");
		
		return gson.toJson(message, Mensaje.class);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/producto")
	@Override
	public String listarProducto() {
		List<Producto> lista = productoDao.listarProducto();
		return gson.toJson(lista);
	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obtieneNumero")
	@Override
	public String obtieneSecuencial() {
		
		int secuencial = pedidoDao.obtieneSecuencial();
		ResponseSecuencial response = new ResponseSecuencial();
		response.setNumero(secuencial);
		
		return  gson.toJson(response, ResponseSecuencial.class);
	}
}
