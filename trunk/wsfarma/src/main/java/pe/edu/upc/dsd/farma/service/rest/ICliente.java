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
	
	// Obtiene Secuencial Pedido
	public String obtieneSecuencial();
	
	// RegistroPedido
	public String registraPedido(String jsonPedido);
	
	// Registro Detalle Pedido
	public String registraDetallePedido(String jsonDetallePedido);
	
	//Listar Producto
	public String listarProducto();
	
	//Anular Pedido
	public String anulaPedido(String jsonPedido);
	
}
