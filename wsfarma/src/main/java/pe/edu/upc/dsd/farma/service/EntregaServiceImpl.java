package pe.edu.upc.dsd.farma.service;

import java.util.ArrayList;

import javax.jws.WebService;

import pe.edu.upc.dsd.farma.model.PedidoEntrega;

@WebService(endpointInterface = "pe.edu.upc.dsd.farma.service.EntregaService")
public class EntregaServiceImpl implements EntregaService {

	@Override
	public ArrayList<PedidoEntrega> listaPedidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizaPedido(int numeroPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
