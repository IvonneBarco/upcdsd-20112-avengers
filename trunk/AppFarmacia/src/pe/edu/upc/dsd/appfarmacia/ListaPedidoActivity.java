package pe.edu.upc.dsd.appfarmacia;

import java.util.List;

import pe.edu.upc.dsd.appfarmacia.model.PedidoResumen;
import pe.edu.upc.dsd.appfarmacia.service.PedidosService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	private TextView lblnumPedido;
	private TextView lblCliente;
	private TextView lblfecha;
	private TextView lbltelefono;
	private List<PedidoResumen> datos=null;
	private PedidosService pedidoService = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        
        pedidoService= new PedidosService(this);
        datos=pedidoService.getListas();
        AdaptadorPedido adaptador = new AdaptadorPedido(this);
        lstopciones = (ListView)findViewById(R.id.lstOpciones);
        lstopciones.setAdapter(adaptador);
                
        lstopciones.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
            	
            	lblnumPedido = (TextView)v.findViewById(R.id.lblnumPedido);
            	lblCliente=(TextView)v.findViewById(R.id.lblCliente);
            	lblfecha=(TextView)v.findViewById(R.id.lblFecha);
            	lbltelefono=(TextView)v.findViewById(R.id.lblTelefono);
            	
            	Intent intent=new Intent(ListaPedidoActivity.this,DetallePedidoActivity.class);
            	
            	Bundle b=new Bundle();
            	b.putString("NROPEDIDO", lblnumPedido.getText().toString());
            	b.putString("NOMBRECLIENTE",lblCliente.getText().toString());
            	b.putString("FECHAPEDIDO",lblfecha.getText().toString());
            	b.putString("TELEFONOCLIENTE", lbltelefono.getText().toString());
            	
            	intent.putExtras(b);
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
        			holder.numero = (TextView)item.findViewById(R.id.lblnumPedido);
        			holder.nombreCliente = (TextView)item.findViewById(R.id.lblCliente);
        			holder.telefono = (TextView)item.findViewById(R.id.lblTelefono);
        			holder.fecha = (TextView)item.findViewById(R.id.lblFecha);
        			item.setTag(holder);
        		}
        		else
        		{
        			holder = (ViewHolder)item.getTag();
        		}
    			
    			holder.numero.setText(datos.get(position).getNumeroPedido());
    			holder.nombreCliente.setText(datos.get(position).getCliente());
    			holder.telefono.setText(datos.get(position).getTelefono());
    			holder.fecha.setText(datos.get(position).getFecha());
    			return(item);
    		}
        }
        
    static class ViewHolder {
       	TextView numero;
       	TextView nombreCliente;
       	TextView telefono;
       	TextView fecha;
    }

}
