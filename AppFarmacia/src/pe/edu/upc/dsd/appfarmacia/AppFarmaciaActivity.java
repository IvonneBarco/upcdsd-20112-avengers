package pe.edu.upc.dsd.appfarmacia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AppFarmaciaActivity extends Activity {
    /** Called when the activity is first created. */
	
	private EditText txtUserName;
	private EditText txtPassword;
	private Button btnAceptar;
	private Button btnCancelar;
	private TextView lblInformacion;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtUserName=(EditText)findViewById(R.id.txtUserName);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);
        lblInformacion=(TextView)findViewById(R.id.lblerror);
        
        btnAceptar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username=txtUserName.getText().toString();
				String password=txtPassword.getText().toString();
				if (username.equalsIgnoreCase("admin")&& password.equals("admin12")){
					//Creamos el Intent
					lblInformacion.setText("");
	            	Intent intent = new Intent(AppFarmaciaActivity.this, FrmPantalla2.class);
	            	
	            	//Creamos la información a pasar entre actividades
	            	Bundle b = new Bundle(); 
	            	b.putString("NOMBRE", username);
	            	
	            	//Añadimos la información al intent
	            	intent.putExtras(b);
	  
	            	//Iniciamos la nueva actividad
	                startActivity(intent);
	               
				}else{
					lblInformacion.setText("El inicio de sesion ha fallado. Usuario/Password incorrecto.");
				}
			}
        });
        btnCancelar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
    }
}