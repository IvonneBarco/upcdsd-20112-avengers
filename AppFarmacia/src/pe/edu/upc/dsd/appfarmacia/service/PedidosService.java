package pe.edu.upc.dsd.appfarmacia.service;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import pe.edu.upc.dsd.appfarmacia.model.PedidoResumen;
import pe.edu.upc.dsd.appfarmacia.repository.AppDaoImp;
import android.content.Context;

public class PedidosService {
	
	Context context;
	AppDaoImp appDaoImp;
	Gson gson;
	
	public PedidosService(Context context) {
		super();
		this.context = context;
		this.appDaoImp = new AppDaoImp(context);
		this.gson = new Gson();
	}
	
	public List<PedidoResumen> getListas(){
		
		String jsonListaPedidos = appDaoImp.getListas();
		if(jsonListaPedidos !=null){
			Type collectionType= new TypeToken<List<PedidoResumen>>(){}.getType();
			List<PedidoResumen> listaPedidos= gson.fromJson(jsonListaPedidos, collectionType);
			return listaPedidos;
		}else
			return null;		
	}

}
