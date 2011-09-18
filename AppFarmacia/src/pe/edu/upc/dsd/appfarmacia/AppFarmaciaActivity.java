package pe.edu.upc.dsd.appfarmacia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AppFarmaciaActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        final EditText txtnombre=(EditText)findViewById(R.id.txtNombre);
    	final Button btnentrar=(Button)findViewById(R.id.btnEntrar);
    	
        btnentrar.setOnClickListener(new OnClickListener(){
        	//@Override
            public void onClick(View v) {
                //Creamos el Intent
            	Intent intent = new Intent(AppFarmaciaActivity.this, FrmPantalla2.class);
            	
            	//Creamos la información a pasar entre actividades
            	Bundle b = new Bundle(); 
            	b.putString("NOMBRE", txtnombre.getText().toString());
            	
            	//Añadimos la información al intent
            	intent.putExtras(b);
            	
            	//Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}