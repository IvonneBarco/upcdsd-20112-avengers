package pe.edu.upc.dsd.farma.model;

public class PedidoEntrega {
	private int numero;
	private String distrito;
	private String direccion;
	private String nombreCliente;

	public int getNumero() {
		return numero;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
