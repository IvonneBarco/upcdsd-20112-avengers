package pe.edu.upc.dsd.farma.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.DatosMensaje;
import pe.edu.upc.dsd.farma.model.DetallePedido;
import pe.edu.upc.dsd.farma.model.Pedido;

@Repository
public class ClienteDaoJdbc extends SimpleJdbcDaoSupport implements ClienteDao {

	@Autowired
	public ClienteDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		getSimpleJdbcTemplate()
				.update("insert into cliente(DNI, nombre, direccion, telefono, distrito, email, flagNotif, password) values(?, ?, ?, ?, ?, ?, ?, ?)",
						cliente.getDni(), cliente.getNombre(),
						cliente.getDireccion(), cliente.getTelefono(),
						cliente.getDistrito(), cliente.getEmail(),
						cliente.getFlagNotif(), cliente.getPassword());
	}

	@Override
	public Cliente validaCliente(String dni, String pwd) {
		
		try {
			return getSimpleJdbcTemplate()
					.queryForObject(
							"select dni, nombre, direccion, telefono, " +
							"distrito,email,flagNotif,password " +
							"From cliente where DNI=? and password = ?",
							new BeanPropertyRowMapper<Cliente>(Cliente.class),
							dni, pwd);
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	@Override
	public List<Pedido> listaPedidos(String dni) {
		try {
			return getSimpleJdbcTemplate().query(
					"select numero, fecha, dniCliente, subImporte, importeFinal " +
					"from	pedido " +
					"where	dniCliente = ?",
					new BeanPropertyRowMapper<Pedido>(Pedido.class), dni);
					
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public DatosMensaje obtieneDatos(int numeroPedido) {
		try {
			return getSimpleJdbcTemplate()
					.queryForObject(
							"select c.email as correoCliente, " +
							"c.nombre as nombreCliente, " +
							"p.importeFinal as importeCompra, " +
							"p.numero as numeroPedido " +
							"From cliente c JOIN "+
							"pedido p " +
							"on c.DNI = p.dniCliente " +
							"where p.numero = ?",
							new BeanPropertyRowMapper<DatosMensaje>(DatosMensaje.class),
							numeroPedido);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}
