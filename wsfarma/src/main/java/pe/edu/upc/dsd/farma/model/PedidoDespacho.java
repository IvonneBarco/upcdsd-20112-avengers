package pe.edu.upc.dsd.farma.model;

public class PedidoDespacho {
	private int numero;
	private String fecha;
	private String telefono;
	private DetallePedido detalle;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DetallePedido getDetalle() {
		return detalle;
	}

	public void setDetalle(DetallePedido detalle) {
		this.detalle = detalle;
	}

}
