package pe.edu.upc.dsd.farma.dao;

import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Pedido;

public interface ClienteDao {
	
	// Registro de clientes en BD Jdbc
	public void insertarCliente(Cliente cliente);
	// Registro de pedido
	public void insertarPedido(Pedido pedido);
}
