package pe.edu.upc.dsd.appfarmacia.model;

public class PedidoResumen {
	
	    private String numeroPedido;
	    private String cliente;
	    private String fecha;
	 
	    public PedidoResumen(String numPedido, String clie,String fec){
	        numeroPedido=numPedido;
	        cliente=clie;
	        fecha=fec;
	    }

		public String getNumeroPedido() {
			return numeroPedido;
		}

		public String getCliente() {
			return cliente;
		}

		public String getFecha() {
			return fecha;
		}
	}
