package pe.edu.upc.dsd.farma.model;

public class Cliente {
	private String strDNI; // Identificador del cliente
	private String strNombre; // Nombre del cliente
	private String strDireccion; // Dirección del cliente
	private String strTelefono; // Teléfono del cliente
	private String strDistrito; // Distrito donde vive el cliente
	private String strEmail; // Correo del cliente
	private String strPassword; // Contraseña del cliente
	private String strFlagNotif; // Indicador para notificaciones

	public String getStrDNI() {
		return strDNI;
	}

	public void setStrDNI(String strDNI) {
		this.strDNI = strDNI;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public String getStrDireccion() {
		return strDireccion;
	}

	public void setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
	}

	public String getStrTelefono() {
		return strTelefono;
	}

	public void setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
	}

	public String getStrDistrito() {
		return strDistrito;
	}

	public void setStrDistrito(String strDistrito) {
		this.strDistrito = strDistrito;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrFlagNotif() {
		return strFlagNotif;
	}

	public void setStrFlagNotif(String strFlagNotif) {
		this.strFlagNotif = strFlagNotif;
	}
}
