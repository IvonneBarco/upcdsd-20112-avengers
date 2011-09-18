package pe.edu.upc.dsd.farma.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;

@WebService(endpointInterface="pe.edu.upc.dsd.farma.service.FarmaciaService")
public class FarmaciaServiceImpl implements FarmaciaService{
	
	@Autowired
	private ClienteDao clienteDao; 
	
	@Override
	public String registrarCliente(Cliente cliente) {
		clienteDao.insertarCliente(cliente);
		return "Cliente registrado";
	}
}
