package pe.edu.upc.dsd.farma.service;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.model.PedidoCliente;

@WebService
public interface ClienteService {

	// Valida Ingreso
	public Cliente validaIngreso(@WebParam(name = "dni") String dni,
			@WebParam(name = "pwd") String pwd);

	// Registro de clientes
	public String registraCliente(@WebParam(name = "cliente") Cliente cliente);

	// Listado de pedidos
	public ArrayList<PedidoCliente> listaPedidosCliente(
			@WebParam(name = "dni") String dni);

	// DescuentoCliente
	public double descuentoCliente(@WebParam(name = "dni") String dni);

	// RegistroPedido
	public String registraPedido(@WebParam(name = "pedido") Pedido pedido);
}
