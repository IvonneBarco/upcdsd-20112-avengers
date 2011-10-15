package pe.edu.upc.dsd.appfarmacia;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class DetallePedidoActivity extends Activity {
	//private GridView grilla;
	private TextView txtnumpedido;
	private TextView txtcliente;
	private TextView txtfecha;
	private TextView txttelefono;
	
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
        
        /*for(int i=1;i<=25;i++){
        	datos[i-1]="Dato"+1;
        }*/
        //ArrayAdapter<String> adaptador =
          //  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
       //grilla = (GridView)findViewById(R.id.GridOpciones);
       //grilla.setAdapter(adaptador);
	}   

}
