package pe.edu.upc.dsd.farma.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import pe.edu.upc.dsd.farma.model.Cliente;

@WebService
public interface FarmaciaService {
	public String registrarCliente(@WebParam(name = "cliente") Cliente cliente); // Registro de clientes
}
