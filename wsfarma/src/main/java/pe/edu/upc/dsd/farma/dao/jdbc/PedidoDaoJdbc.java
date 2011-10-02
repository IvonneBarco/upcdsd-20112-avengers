package pe.edu.upc.dsd.farma.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dsd.farma.dao.PedidoDao;
import pe.edu.upc.dsd.farma.model.DetallePedido;
import pe.edu.upc.dsd.farma.model.Pedido;
import pe.edu.upc.dsd.farma.model.PedidoDespacho;
import pe.edu.upc.dsd.farma.model.PedidoEntrega;

@Repository
public class PedidoDaoJdbc extends SimpleJdbcDaoSupport implements PedidoDao {

	@Autowired
	public PedidoDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void insertarPedido(Pedido pedido) {
		// Cabecera
		getSimpleJdbcTemplate()
				.update("insert into pedido(numero, dniCliente, fecha, subImporte, importeFinal) values(?, ?, ?, ?, ?)",
						pedido.getNumero(), pedido.getDniCliente(),
						pedido.getFecha(), pedido.getSubImporte(),
						pedido.getImporteFinal());

		// Detalle
		for (DetallePedido detalle : pedido.getDetalle())
			getSimpleJdbcTemplate()
					.update("insert into pedidoDetalle(numeroPedido, itemPedido, codigoProducto, estadoPedido,cantidad, importe, total) "
							+ "values(?, ?, ?, ?, ?, ?, ?)",
							detalle.getNumeroPedido(), detalle.getItemPedido(),
							detalle.getCodigoProducto(), 0,
							detalle.getCantidad(), detalle.getImporte(),
							detalle.getTotal());
	}
	
	@Override
	public List<DetallePedido> listaDetallePedido(int numeroPedido) {

		try {
			return getSimpleJdbcTemplate().query(
					"select numeroPedido, itemPedido, codigoProducto, cantidad, importe, total "
							+ "from	pedidoDetalle " + "where	numeroPedido = ?",
					new BeanPropertyRowMapper<DetallePedido>(
							DetallePedido.class), numeroPedido);

		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public List<PedidoDespacho> listaPedidosDespacho() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoEntrega> listaPedidosEntrega() {
		// TODO Auto-generated method stub
		return null;
	}

}