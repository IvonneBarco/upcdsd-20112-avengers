package pe.edu.upc.dsd.farma.model;

import java.util.ArrayList;

public class Pedido {
	private int numero;
	private String dniCliente;
	private String fecha;
	private double subImporte;
	private double importeFinal;
	private ArrayList<DetallePedido> detalle;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
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
	public ArrayList<DetallePedido> getDetalle() {
		return detalle;
	}
	public void setDetalle(ArrayList<DetallePedido> detalle) {
		this.detalle = detalle;
	}
	
}
