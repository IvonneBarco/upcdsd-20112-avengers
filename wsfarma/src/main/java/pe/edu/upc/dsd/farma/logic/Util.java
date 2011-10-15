package pe.edu.upc.dsd.farma.logic;

import org.springframework.jms.core.JmsTemplate;

import com.google.gson.Gson;

import pe.edu.upc.dsd.farma.model.DatosMensaje;
import pe.edu.upc.dsd.farma.model.MensajeCola;

public class Util {
	
	public void encolar(JmsTemplate template, DatosMensaje datos ){
		Gson gson = new Gson();
		MensajeCola mensaje = new MensajeCola();
		
		System.out.println(gson.toJson(datos));
		
		mensaje.setMailTo(datos.getCorreoCliente());
		mensaje.setSubject("Notificacion de compra");
		mensaje.setBody("Usted ha registrado un pedido por el importe de : " + datos.getImporteCompra() + " soles, para ver el detalle revise nuestra web.");
		
		
		String mensajeCola = gson.toJson(mensaje);
		
		template.convertAndSend("quispe", mensajeCola);
	}
	
}
