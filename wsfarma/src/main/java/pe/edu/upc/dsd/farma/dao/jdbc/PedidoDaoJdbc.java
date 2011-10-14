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
import pe.edu.upc.dsd.farma.model.DetallePedidoAlmacen;
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
				.update("insert into pedido(numero, dniCliente, estadoPedido, fecha, subImporte, importeFinal) values(?, ?, ?, ?, ?, ?)",
						pedido.getNumero(), pedido.getDniCliente(), 0,
						pedido.getFecha(), pedido.getSubImporte(),
						pedido.getImporteFinal());

		// Detalle
		for (DetallePedido detalle : pedido.getDetalle())
			getSimpleJdbcTemplate()
					.update("insert into pedidoDetalle(numeroPedido, itemPedido, codigoProducto, cantidad, importe, total) "
							+ "values(?, ?, ?, ?, ?, ?)",
							detalle.getNumeroPedido(), detalle.getItemPedido(),
							detalle.getCodigoProducto(), detalle.getCantidad(),
							detalle.getImporte(), detalle.getTotal());
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
		// Cambiar a Constantes
		int estadoPorDespachar = 0;

		try {
			return getSimpleJdbcTemplate().query(
					"select	p.numero, p.fecha, c.telefono, c.nombre as nombreCliente "
							+ "from	pedido p inner join cliente c "
							+ "on	( p.dniCliente = c.DNI ) "
							+ "where	p.estadoPedido = ?",
					new BeanPropertyRowMapper<PedidoDespacho>(
							PedidoDespacho.class), estadoPorDespachar);

		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public List<PedidoEntrega> listaPedidosEntrega() {
		// Cambiar a Constantes
		int estadoPorEntregar = 1;

		try {
			return getSimpleJdbcTemplate().query(
					"select	p.numero, c.distrito, c.direccion, c.nombre as nombreCliente "
							+ "from	pedido p inner join cliente c "
							+ "on	( p.dniCliente = c.DNI ) "
							+ "where	p.estadoPedido = ?",
					new BeanPropertyRowMapper<PedidoEntrega>(
							PedidoEntrega.class), estadoPorEntregar);

		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public void actualizarEstadoPedido(int numeroPedido, int estado) {
		getSimpleJdbcTemplate().update(
				"update pedido set estadoPedido=? where numero=?", estado,
				numeroPedido);
	}
	
	public List<Pedido> listaPedido(){
		String sql="select * from pedido";
		List<Pedido> listadoPedidos;
		try{
			listadoPedidos=getSimpleJdbcTemplate().query(sql, new BeanPropertyRowMapper<Pedido>(Pedido.class));
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
		return listadoPedidos;
	}
	
	public List<DetallePedidoAlmacen> verDetallePedido(int numeroPedido) {

		try {
			return getSimpleJdbcTemplate().query(
					"select pd.numeroPedido, pd.itemPedido, pd.codigoProducto,p.descripcion, pd.cantidad "
							+ "from	pedidoDetalle pd inner join producto p ON (pd.codigoProducto=p.codigo) " +
							"where	pd.numeroPedido = ?",
					new BeanPropertyRowMapper<DetallePedidoAlmacen>(
							DetallePedidoAlmacen.class), numeroPedido);

		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}


}