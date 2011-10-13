package pe.edu.upc.dsd.appfarmacia.model;

public class PedidoResumen {
	
	    private String numero;
	    private String nombreCliente;
	    private String telefono;
	    private String fecha;
	 
	    public PedidoResumen(){
	    }
	    
	    public PedidoResumen(String numPedido, String clie,String telf,String fec){
	        numero=numPedido;
	        nombreCliente=clie;
	        telefono=telf;
	        fecha=fec;
	    }

		public String getNumeroPedido() {
			return numero;
		}

		public String getCliente() {
			return nombreCliente;
		}

		public String getFecha() {
			return fecha;
		}

		public String getTelefono() {
			return telefono;
		}
	}
