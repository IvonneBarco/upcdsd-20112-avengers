package pe.edu.upc.dsd.farma.service.rest;

import pe.edu.upc.dsd.farma.model.Cliente;


public interface ICliente {
	
	// Valida Ingreso
		public Cliente validaIngreso(String dni, String pwd);

		// Registro de clientes
		public String registraCliente(String json);

		// Listado de pedidos
		//public ArrayList<PedidoCliente> listaPedidosCliente(String dni);

		// DescuentoCliente
		//public double descuentoCliente(String dni);

		// RegistroPedido
		//public String registraPedido(Pedido pedido);
}
