package pe.edu.upc.dsd.appfarmacia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FrmPantalla2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        
        TextView txtmensaje= (TextView)findViewById(R.id.txtMensaje);
        Bundle bundle= getIntent().getExtras();
        txtmensaje.setText("Hola como estas " + bundle.getString("NOMBRE"));
    }

}
