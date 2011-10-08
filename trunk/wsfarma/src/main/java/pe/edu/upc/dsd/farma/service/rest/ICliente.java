package pe.edu.upc.dsd.farma.service.rest;

public interface ICliente {

	// Valida Ingreso
	public String validaIngreso(String dni, String pwd);

	// Registro de clientes
	public String registraCliente(String jsonCliente);

	// Listado de pedidos
	public String listaPedidos(String jsonDni);

	// DescuentoCliente
	public String obtieneDescuento(String jsonDni);

	// RegistroPedido
	public String registraPedido(String jsonPedido);
	
	//Listar Producto
	public String listarProducto();
}
