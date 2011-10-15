package pe.edu.upc.dsd.appfarmacia.repository;

public interface AppDao {
	public String getListas();
	public String getDetallePedido(int pedido);
	public void actualizarEstadoPedido(String pedido);
}
