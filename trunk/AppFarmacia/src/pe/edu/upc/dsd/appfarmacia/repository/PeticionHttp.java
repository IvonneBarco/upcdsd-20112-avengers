package pe.edu.upc.dsd.appfarmacia.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;

//import org.w3c.dom.Document;

import android.util.Log;

public class PeticionHttp {

	public static synchronized String realizarPeticion(String urlRequest) throws IOException {
		// TODO Auto-generated method stub
		String jsonRespuesta="";
		try {
			HttpURLConnection urlConnection=null;
			URL url=new URL(urlRequest);
			urlConnection=(HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			//urlConnection.setReadTimeout(240000);
			//urlConnection.connect();
			Log.d("Ver",String.valueOf(urlConnection.getResponseCode()));
			
			jsonRespuesta=parseResponse(urlConnection.getInputStream());
			Log.i("ListaPedidos3",jsonRespuesta);
			
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("ListaPedidos4",e.getMessage());
		}
		return jsonRespuesta;
	}

	public static synchronized String realizarPeticionPut(String urlPeticion,String jsonnumpedido) throws IOException{
		HttpURLConnection urlConnection= null;
		URL url = new URL(urlPeticion);
		urlConnection=(HttpURLConnection)url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("PUT");
		Log.d("realizaPut",String.valueOf(urlConnection.getResponseCode()));
		OutputStreamWriter out= new OutputStreamWriter(urlConnection.getOutputStream());
		out.write(jsonnumpedido);
		out.close();
		return "";
	}
	
	private static String parseResponse(InputStream inputStream) {
		// TODO Auto-generated method stub
		String jsonResponse="";
		
		try {
			/*DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db= dbf.newDocumentBuilder();
			
			Document doc=db.parse(inputStream);
			jsonResponse=doc.getFirstChild().getFirstChild().getChildNodes().item(0).getNodeValue();*/
			//InputStream is=inputStream;
			
			jsonResponse=readFromBuffer(new BufferedReader( new InputStreamReader(inputStream)));
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("ListaPedidos2", e.getMessage());
		}
		return jsonResponse;
	}
	
	/*public static String httppost(String urlPeticion)throws IOException{
		URL url = new URL( urlPeticion );
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod( "POST" );
	    con.setDoInput( true );
	    con.setDoOutput( true );
	    
	}*/

	private static String readFromBuffer(BufferedReader bufferedReader) {
		// TODO Auto-generated method stub
		StringBuilder text = new StringBuilder();
		try{
			String line;
			while((line=bufferedReader.readLine())!=null){
				text.append(line);
				text.append("\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return text.toString();
	}
	
}
