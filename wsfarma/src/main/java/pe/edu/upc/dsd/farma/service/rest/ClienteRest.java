package pe.edu.upc.dsd.farma.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
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

@Path("clienteRest")
@Produces("text/plain")
public class ClienteRest {

	@Autowired
	private ClienteDao clienteDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/registrar")
	public String ingresaCliente(String json) {
		// Json Ejemplo :
		/*
		 * { "strDNI":"44992694", "strNombre":"Daniel",
		 * "strDireccion":"Av. La Prueba", "strTelefono":"5369504",
		 * "strDistrito":"San Miguel", "strEmail":"a@a.com",
		 * "strPassword":"abc123", "strFlagNotif":"Si" }
		 */
		
		Gson gson = new Gson();
		
		Cliente cliente = gson.fromJson(json, Cliente.class);
			
		clienteDao.insertarCliente(cliente);
		
		Mensaje message = new Mensaje();
		message.setError(false);
		message.setSuccess(true);
		message.setDescripcion("Cliente Registrado");
		
		return gson.toJson(message, Mensaje.class);
		
	}


}
