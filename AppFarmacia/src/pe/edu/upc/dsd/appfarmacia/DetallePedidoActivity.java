package pe.edu.upc.dsd.appfarmacia;

import java.util.List;

import pe.edu.upc.dsd.appfarmacia.ListaPedidoActivity.ViewHolder;
import pe.edu.upc.dsd.appfarmacia.model.DetallePedido;
import pe.edu.upc.dsd.appfarmacia.model.Pedido;
import pe.edu.upc.dsd.appfarmacia.service.PedidosService;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class DetallePedidoActivity extends Activity {
	
	private TextView txtnumpedido;
	private TextView txtcliente;
	private TextView txtfecha;
	private TextView txttelefono;
	private List<DetallePedido> datoproductos=null;
	private PedidosService detallepedidoService = null;
	private ListView lstproductos;
	private Button btnActualizaEstado;
	int numped;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepedido);
        
        
        txtnumpedido=(TextView)findViewById(R.id.Pedido);
        txtcliente=(TextView)findViewById(R.id.Cliente);
        txtfecha=(TextView)findViewById(R.id.Fecha);
        txttelefono=(TextView)findViewById(R.id.Telefono);
        btnActualizaEstado=(Button)findViewById(R.id.btnActualiza);
        
        Bundle bundle=getIntent().getExtras();
        txtnumpedido.setText(bundle.getString("NROPEDIDO"));
        txtcliente.setText(bundle.getString("NOMBRECLIENTE"));
        txtfecha.setText(bundle.getString("FECHAPEDIDO"));
        txttelefono.setText(bundle.getString("TELEFONOCLIENTE"));
        detallepedidoService=new PedidosService(this);
        numped=Integer.valueOf(bundle.getString("NROPEDIDO"));
        datoproductos=detallepedidoService.getdetallePedido(numped);
        
        AdaptadorDetallePedido adaptador= new AdaptadorDetallePedido(this);
        lstproductos=(ListView)findViewById(R.id.lstProductos);
        lstproductos.setAdapter(adaptador);
        
        btnActualizaEstado.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Pedido pedidopost=new Pedido();
				pedidopost.setNumero(numped);
				pedidopost.setEstado(1);
				detallepedidoService.actualizarEstadoPedido(pedidopost);
			}
		});
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
				holder.cantidadpedida.setText(String.valueOf(datoproductos.get(position).getCantidad()));
			} catch (Exception e) {
				// TODO: handle exception
				Log.d("detallePedidolbl", String.valueOf(datoproductos.get(position).getCantidad()));
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

	