package pe.edu.upc.dsd.farma.model;

public class DetallePedido {
	private int numeroPedido;
	private int itemPedido;
	private int codigoProducto;
	private int cantidad;
	private double importe;
	private double total;
	
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public int getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(int itemPedido) {
		this.itemPedido = itemPedido;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
