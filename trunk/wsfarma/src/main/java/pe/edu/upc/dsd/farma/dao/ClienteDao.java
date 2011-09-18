package pe.edu.upc.dsd.farma.dao;

import pe.edu.upc.dsd.farma.model.Cliente;

public interface ClienteDao {
	
	// Registro de clientes en BD Jdbc
	public void insertarCliente(Cliente cliente);
}
