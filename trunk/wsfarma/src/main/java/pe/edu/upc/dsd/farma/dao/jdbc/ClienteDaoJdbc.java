package pe.edu.upc.dsd.farma.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;
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
						cliente.getStrDNI(), cliente.getStrNombre(),
						cliente.getStrDireccion(), cliente.getStrTelefono(),
						cliente.getStrDistrito(), cliente.getStrEmail(),
						cliente.getStrFlagNotif(), cliente.getStrPassword());
	}

	@Override
	public void insertarPedido(Pedido pedido) {
		//Cabecera
		getSimpleJdbcTemplate()
				.update("insert into pedido(numero, dniCliente, subImporte, importeFinal) values (?, ?, ?, ?)",
						pedido.getNumero(), pedido.getDniCliente(),
						pedido.getSubImporte(), pedido.getImporteFinal());
	}
}
