package pe.edu.upc.dsd.farma.model;

public class DatosMensaje {
	private String correoCliente;
	private String nombreCliente;
	private double importeCompra;
	private int numeroPedido;
	
	public String getCorreoCliente() {
		return correoCliente;
	}
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public double getImporteCompra() {
		return importeCompra;
	}
	public void setImporteCompra(double importeCompra) {
		this.importeCompra = importeCompra;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

}
