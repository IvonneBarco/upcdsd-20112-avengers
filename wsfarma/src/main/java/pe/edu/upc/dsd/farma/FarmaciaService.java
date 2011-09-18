package pe.edu.upc.dsd.farma;

import javax.jws.WebService;

@WebService
public interface FarmaciaService {
	public String registrarCliente(Cliente cliente); // Registro de clientes
}
