package pe.edu.upc.dsd.appfarmacia.repository;

import java.io.IOException;

import android.content.Context;
import android.util.Log;

public class AppDaoImp implements AppDao {
	Context context;
	String urlBase;
	
	
	public AppDaoImp(Context context) {
		this.context = context;
		this.urlBase="http://10.0.2.2:8080/wsfarma/rest/";
	}


	@Override
	public String getListas() {
		// TODO Auto-generated method stub
		String urlRequest = getUrlBase()+"despachoRest/listar";
		Log.d("Ruta WS", urlRequest);
		String jsonListaPedidos = "";
		try{
			jsonListaPedidos=PeticionHttp.realizarPeticion(urlRequest);
		}catch (IOException e) {
			// TODO: handle exception
			Log.e("ListaPedidos", e.getMessage());
		}
		return jsonListaPedidos;
	}


	private String getUrlBase() {
		// TODO Auto-generated method stub
		Log.d("ListaPedidos","Url: "+urlBase);
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}
	
	@Override
	public String getDetallePedido(int pedido) {
		// TODO Auto-generated method stub
		String urlRequest = getUrlBase()+"almacenRest/detallePedido/"+pedido;
		String jsonListaPedidos = "";
		try{
			jsonListaPedidos=PeticionHttp.realizarPeticion(urlRequest);
		}catch (IOException e) {
			// TODO: handle exception
			Log.e("ListaPedidos", e.getMessage());
		}
		return jsonListaPedidos;
	}
	
}
