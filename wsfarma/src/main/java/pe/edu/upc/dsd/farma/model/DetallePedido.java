package pe.edu.upc.dsd.farma.model;

public class DetallePedido {
	private int producto;
	private int cantidad;
	private int unidadMedida;
	private int importe;
	
	public int getProducto() {
		return producto;
	}
	public void setProducto(int producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(int unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}	
	
}
