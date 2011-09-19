package pe.edu.upc.dsd.farma.service;

import java.util.ArrayList;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.model.PedidoCliente;

@WebService(endpointInterface="pe.edu.upc.dsd.farma.service.ClienteService")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao clienteDao; 
	
	@Override
	public String registraCliente(Cliente cliente) {
		clienteDao.insertarCliente(cliente);
		return "Cliente registrado";
	}

	@Override
	public ArrayList<PedidoCliente> listaPedidosCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double descuentoCliente(String dni) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String registraPedido(Pedido pedido) {
		clienteDao.insertarPedido(pedido);
		return "Pedido registrado";
	}

	@Override
	public Cliente validaIngreso(String dni, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
