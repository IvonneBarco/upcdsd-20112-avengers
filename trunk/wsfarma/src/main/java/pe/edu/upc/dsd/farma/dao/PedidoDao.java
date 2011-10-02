package pe.edu.upc.dsd.farma.dao;

import java.util.List;

import pe.edu.upc.dsd.farma.model.DetallePedido;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.model.PedidoDespacho;
import pe.edu.upc.dsd.farma.model.PedidoEntrega;

public interface PedidoDao {
	//Registra Pedido
	public void insertarPedido(Pedido pedido);
	
	//Lista Detalle Pedido
	public List<DetallePedido> listaDetallePedido(int numeroPedido); 
	
	//Lista Pedido Por Despachar
	public List<PedidoDespacho> listaPedidosDespacho(); 
	
	//Lista Pedido Por Entregar
	public List<PedidoEntrega> listaPedidosEntrega(); 
	
}
