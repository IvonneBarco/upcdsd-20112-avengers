package pe.edu.upc.dsd.farma.dao;

import java.util.List;

import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Pedido;

public interface ClienteDao {

	// Registro de clientes en BD Jdbc
	public void insertarCliente(Cliente cliente);

	// Valida Acceso Cliente
	public Cliente validaCliente(String dni, String pwd);

	// Obtiene Lista Pedidos
	public List<Pedido> listaPedidos(String dni);

}
