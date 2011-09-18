package pe.edu.upc.dsd.farma.service;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

import pe.edu.upc.dsd.farma.model.PedidoDespacho;

@WebService
public interface DespachoService {
	// Listado de pedidos Por Despachar
	public ArrayList<PedidoDespacho> listaPedidos();
	
	//Actualiza pedido por Entregar
	public String actualizaPedido(@WebParam(name = "numeroPedido") int numeroPedido);
	
	
}
