package pe.edu.upc.dsd.farma.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Mensaje;
import pe.edu.upc.dsd.farma.model.Pedido;

@Path("clienteRest")
@Produces("text/plain")
public class ClienteRest implements ICliente{

	@Autowired
	private ClienteDao clienteDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/registrar")
	@Override
	public String registraCliente(String jsonCliente) {
		// Json Ejemplo :
		/*
		 * { "strDNI":"44992694", "strNombre":"Daniel",
		 * "strDireccion":"Av. La Prueba", "strTelefono":"5369504",
		 * "strDistrito":"San Miguel", "strEmail":"a@a.com",
		 * "strPassword":"abc123", "strFlagNotif":"Si" }
		 */
		
		Gson gson = new Gson();
		
		Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);
			
		clienteDao.insertarCliente(cliente);
		
		Mensaje message = new Mensaje();
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
	public String validaIngreso(@FormParam("dni")String dni, @FormParam("pwd") String pwd) {
		
		Cliente cliente =  clienteDao.validaCliente(dni, pwd);
		Gson gson = new Gson();
		
		Mensaje message = new Mensaje();
		
		if (cliente == null){
			message.setError(true);
			message.setSuccess(false);
			message.setDescripcion("Error Cliente no encontrado");
			
		}else{
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
	public String listaPedidos(@PathParam("dni")String dni) {
		Gson gson = new Gson();
		
		List<Pedido> lista = clienteDao.listaPedidos(dni);
		return gson.toJson(lista);
	}

	@Override
	public String obtieneDescuento(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registraPedido(String jsonPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
