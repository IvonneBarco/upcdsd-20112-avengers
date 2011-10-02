package pe.edu.upc.dsd.farma.service.rest;

import pe.edu.upc.dsd.farma.model.Cliente;


public interface ICliente {
	
	// Valida Ingreso
		public String validaIngreso(String dni, String pwd);

		// Registro de clientes
		public String registraCliente(String jsonCliente);

		// Listado de pedidos
		public String listaPedidosCliente(String jsonDni);

		// DescuentoCliente
		public String descuentoCliente(String jsonDni);

		// RegistroPedido
		public String registraPedido(String jsonPedido);
}
