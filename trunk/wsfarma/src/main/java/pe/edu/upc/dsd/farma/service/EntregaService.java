package pe.edu.upc.dsd.farma.service;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

import pe.edu.upc.dsd.farma.model.PedidoEntrega;

@WebService
public interface EntregaService {
	// Listado de pedidos Por Entregar
		public ArrayList<PedidoEntrega> listaPedidos();
		
		//Actualiza pedido Entregado
		public String actualizaPedido(@WebParam(name = "numeroPedido") int numeroPedido);
}
