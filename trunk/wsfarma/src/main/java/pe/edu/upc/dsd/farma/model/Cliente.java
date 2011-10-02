package pe.edu.upc.dsd.farma.model;

public class Cliente {
	private String dni; // Identificador del cliente
	private String nombre; // Nombre del cliente
	private String direccion; // Dirección del cliente
	private String telefono; // Teléfono del cliente
	private String distrito; // Distrito donde vive el cliente
	private String email; // Correo del cliente
	private String password; // Contraseña del cliente
	private String flagNotif; // Indicador para notificaciones
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFlagNotif() {
		return flagNotif;
	}
	public void setFlagNotif(String flagNotif) {
		this.flagNotif = flagNotif;
	}

	
}
