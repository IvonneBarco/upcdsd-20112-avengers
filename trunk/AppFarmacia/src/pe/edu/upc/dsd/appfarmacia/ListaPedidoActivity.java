package pe.edu.upc.dsd.appfarmacia;

import pe.edu.upc.dsd.appfarmacia.model.PedidoResumen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaPedidoActivity extends Activity {
	
	private ListView lstopciones;
	private PedidoResumen[] datos = new PedidoResumen[25];
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        
        for(int i=1; i<=25; i++)
        	datos[i-1] = new PedidoResumen("Pedido " + i, 
        									"Cliente usuarioRegistrado" + i,
        									"Fecha de Pedido: 19-Set-2011");
        AdaptadorPedido adaptador = new AdaptadorPedido(this);
        lstopciones = (ListView)findViewById(R.id.lstOpciones);
        lstopciones.setAdapter(adaptador);
        
        lstopciones.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //Acciones necesarias al hacer click
            	Intent intent=new Intent(ListaPedidoActivity.this,DetallePedidoActivity.class);
            	startActivity(intent);
            }
        });
	}   
	
    @SuppressWarnings("rawtypes")
    class AdaptadorPedido extends ArrayAdapter{
        	
        	Activity context;
        	
			@SuppressWarnings("unchecked")
			AdaptadorPedido(Activity context) {
        		super(context, R.layout.lista_pedido,datos);
        		this.context = context;
        	}
        	
        	public View getView(int position, View convertView, ViewGroup parent) 
        	{
    			View item = convertView;
    			ViewHolder holder;
        		
        		if(item == null)
        		{
        			LayoutInflater inflater = context.getLayoutInflater();
        			item = inflater.inflate(R.layout.lista_pedido, null);
        			
        			holder = new ViewHolder();
        			holder.numpedido = (TextView)item.findViewById(R.id.lblnumPedido);
        			holder.cliente = (TextView)item.findViewById(R.id.lblCliente);
        			holder.fecha = (TextView)item.findViewById(R.id.lblFecha);
        			item.setTag(holder);
        		}
        		else
        		{
        			holder = (ViewHolder)item.getTag();
        		}
    			
    			holder.numpedido.setText(datos[position].getNumeroPedido());
    			holder.cliente.setText(datos[position].getCliente());
    			holder.fecha.setText(datos[position].getFecha());
    			return(item);
    		}
        }
        
    static class ViewHolder {
       	TextView numpedido;
       	TextView cliente;
       	TextView fecha;
    }
        
        
        /*
        lstopciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					//txtmensaje.setText("Seleccionado: " + datos[position]);
				}
        });*/
        /*
        TextView txtmensaje= (TextView)findViewById(R.id.txtMensaje);
        Bundle bundle= getIntent().getExtras();
        txtmensaje.setText("Hola como estas " + bundle.getString("NOMBRE"));*/
}
