package pe.edu.upc.dsd.appfarmacia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class DetallePedidoActivity extends Activity {
	private GridView grilla;
	private String[] datos= new String[25];
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepedido);
        for(int i=1;i<=25;i++){
        	datos[i-1]="Dato"+1;
        }
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
       grilla = (GridView)findViewById(R.id.GridOpciones);
       grilla.setAdapter(adaptador);
	}   

}
