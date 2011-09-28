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

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.ClienteSmall;

@Path("clienteRest")
@Produces("text/plain")
public class ClienteRest {

	@Autowired
	private ClienteDao clienteDao;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/registrar")
	public String registraCliente(@FormParam("DNI") String DNI,
			@FormParam("Nombre") String Nombre,
			@FormParam("Direccion") String Direccion,
			@FormParam("Telefono") String Telefono,
			@FormParam("Distrito") String Distrito,
			@FormParam("Email") String Email,
			@FormParam("Password") String Password,
			@FormParam("FlagNotif") String FlagNotif) {
		
		 Cliente cliente = new Cliente();
		 cliente.setStrDNI(DNI);
		 cliente.setStrNombre(Nombre);
		 cliente.setStrDireccion(Direccion);
		 cliente.setStrTelefono(Telefono);
		 cliente.setStrDistrito(Distrito);
		 cliente.setStrEmail(Email);
		 cliente.setStrPassword(Password);
		 cliente.setStrFlagNotif(FlagNotif);
		 
		 clienteDao.insertarCliente(cliente);
		 
		return "Cliente registrado : " + Nombre;
	}

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/obtiene/{nombre}")
	public String obtieneCliente(@PathParam("nombre") String nombre) {
		// clienteDao.insertarCliente(cliente);
		return "Cliente registrado : " + nombre;
	}
}
