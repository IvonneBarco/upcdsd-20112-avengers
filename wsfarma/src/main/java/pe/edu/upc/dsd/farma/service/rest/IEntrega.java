package pe.edu.upc.dsd.farma.service.rest;


public interface IEntrega {
			// Listado de pedidos Por Entregar
			public String listaPedidos();
			
			//Actualiza pedido Entregado
			public String actualizaPedido(String JsonNumeroPedido);
}
