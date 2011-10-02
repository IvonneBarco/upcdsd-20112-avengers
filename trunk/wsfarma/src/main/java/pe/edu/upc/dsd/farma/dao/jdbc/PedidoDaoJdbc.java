package pe.edu.upc.dsd.farma.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dsd.farma.dao.PedidoDao;
import pe.edu.upc.dsd.farma.model.DetallePedido;
import pe.edu.upc.dsd.farma.model.Pedido;

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
					.update("insert into pedidoDetalle(numeroPedido, itemPedido, codigoProducto, cantidad, importe, total) values(?, ?, ?, ?, ?, ?)",
							detalle.getNumeroPedido(), detalle.getItemPedido(),
							detalle.getCodigoProducto(), detalle.getCantidad(),
							detalle.getImporte(), detalle.getTotal());
	}

}