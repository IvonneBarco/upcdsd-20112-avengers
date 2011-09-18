package pe.edu.upc.dsd.farma.service;

import java.util.ArrayList;

import javax.jws.WebService;

import pe.edu.upc.dsd.farma.model.PedidoDespacho;

@WebService(endpointInterface = "pe.edu.upc.dsd.farma.service.DespachoService")
public class DespachoServiceImpl implements DespachoService {

	@Override
	public ArrayList<PedidoDespacho> listaPedidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizaPedido(int numeroPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
