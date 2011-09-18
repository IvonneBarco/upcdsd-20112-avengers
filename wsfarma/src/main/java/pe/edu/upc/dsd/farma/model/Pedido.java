package pe.edu.upc.dsd.farma.model;

public class Pedido {
	private int numero;
	private String dniCliente;
	private double subImporte;
	private double importeFinal;
	private DetallePedido detalle;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public double getSubImporte() {
		return subImporte;
	}
	public void setSubImporte(double subImporte) {
		this.subImporte = subImporte;
	}
	public double getImporteFinal() {
		return importeFinal;
	}
	public void setImporteFinal(double importeFinal) {
		this.importeFinal = importeFinal;
	}
	public DetallePedido getDetalle() {
		return detalle;
	}
	public void setDetalle(DetallePedido detalle) {
		this.detalle = detalle;
	}
	
}
