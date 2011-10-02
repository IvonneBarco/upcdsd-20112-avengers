package pe.edu.upc.dsd.farma.service.rest;

public interface IDespacho {
	
		// Listado de pedidos Por Despachar
		public String listaPedidos();
		
		//Actualiza pedido por Entregar
		public String actualizaPedido(String jsonNumeroPedido);
		
}
