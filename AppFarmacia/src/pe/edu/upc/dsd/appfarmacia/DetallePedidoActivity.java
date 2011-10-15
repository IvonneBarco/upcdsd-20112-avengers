package pe.edu.upc.dsd.appfarmacia;

import java.util.List;

import pe.edu.upc.dsd.appfarmacia.ListaPedidoActivity.ViewHolder;
import pe.edu.upc.dsd.appfarmacia.model.DetallePedido;
import pe.edu.upc.dsd.appfarmacia.service.PedidosService;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class DetallePedidoActivity extends Activity {
	//private GridView grilla;
	private TextView txtnumpedido;
	private TextView txtcliente;
	private TextView txtfecha;
	private TextView txttelefono;
	private List<DetallePedido> datoproductos=null;
	private PedidosService detallepedidoService = null;
	private ListView lstproductos;
	//private String[] datos= new String[25];
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepedido);
        
        
        txtnumpedido=(TextView)findViewById(R.id.Pedido);
        txtcliente=(TextView)findViewById(R.id.Cliente);
        txtfecha=(TextView)findViewById(R.id.Fecha);
        txttelefono=(TextView)findViewById(R.id.Telefono);
        
        Bundle bundle=getIntent().getExtras();
        txtnumpedido.setText(bundle.getString("NROPEDIDO"));
        txtcliente.setText(bundle.getString("NOMBRECLIENTE"));
        txtfecha.setText(bundle.getString("FECHAPEDIDO"));
        txttelefono.setText(bundle.getString("TELEFONOCLIENTE"));
        detallepedidoService=new PedidosService(this);
        datoproductos=detallepedidoService.getdetallePedido(Integer.valueOf(bundle.getString("NROPEDIDO")));
        
        //Log.d("DatosPed",datoproductos.get(0).getDescripcion());
        /*for(int i=1;i<=25;i++){
        	datos[i-1]="Dato"+1;
        }*/
        //ArrayAdapter<String> adaptador =
          //  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
       //grilla = (GridView)findViewById(R.id.GridOpciones);
       //grilla.setAdapter(adaptador);
        AdaptadorDetallePedido adaptador= new AdaptadorDetallePedido(this);
        lstproductos=(ListView)findViewById(R.id.lstProductos);
        lstproductos.setAdapter(adaptador);
	}   
	
	@SuppressWarnings("rawtypes")
	class AdaptadorDetallePedido extends ArrayAdapter{
		
		Activity context;
		
		@SuppressWarnings("unchecked")
		public AdaptadorDetallePedido(Activity context) {
			super(context,R.layout.rowproducto,datoproductos);
			this.context=context;
		}

		public View getView (int position, View convertView, ViewGroup parent){
			View item = convertView;
			ViewDetallePedido holder;
			if(item == null){
				LayoutInflater inflater = context.getLayoutInflater();
    			item = inflater.inflate(R.layout.rowproducto, null);
    			holder=new ViewDetallePedido();
    			holder.itemdetalle=(TextView)item.findViewById(R.id.lblItem);
    			holder.codigoProducto=(TextView)item.findViewById(R.id.lblCodigoProd);
    			holder.descripcionProducto=(TextView)item.findViewById(R.id.lblDesProd);
    			holder.cantidadpedida=(TextView)item.findViewById(R.id.lblCantProd);
    			item.setTag(holder);
			}else{
				holder=(ViewDetallePedido)item.getTag();
			}
			try {
				holder.itemdetalle.setText(String.valueOf(datoproductos.get(position).getItemPedido()));
				holder.codigoProducto.setText(datoproductos.get(position).getCodigoProducto());
				holder.descripcionProducto.setText(datoproductos.get(position).getDescripcion());
				holder.cantidadpedida.setText(datoproductos.get(position).getCantidad());
			} catch (Exception e) {
				// TODO: handle exception
				Log.d("detallePedidolbl", String.valueOf(datoproductos.get(position).getItemPedido()));
				Log.e("detallePedido", e.getMessage());
			}
			
			return (item);
		}
		
	}
	
	static class ViewDetallePedido{
		TextView itemdetalle;
		TextView codigoProducto;
		TextView descripcionProducto;
		TextView cantidadpedida;
		
	}
}

	