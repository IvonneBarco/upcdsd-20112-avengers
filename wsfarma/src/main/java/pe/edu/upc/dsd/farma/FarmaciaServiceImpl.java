package pe.edu.upc.dsd.farma;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface="pe.edu.upc.dsd.farma.FarmaciaService")
public class FarmaciaServiceImpl implements FarmaciaService{
	
	@Autowired
	private ClienteDao clienteDao; 
	
	@Override
	public String registrarCliente(Cliente cliente) {
		clienteDao.insertarCliente(cliente);
		return "Cliente registrado";
	}
}
